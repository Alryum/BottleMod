package dev.alryum.bottlemod.items.custom;

import dev.alryum.bottlemod.world.dimension.ModDimensions;
import dev.alryum.bottlemod.world.portal.ModTeleporter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.io.*;
import java.util.Scanner;

public class Bottle extends Item {
    public Bottle(Properties p_41383_) {
        super(p_41383_);
    }

    public static Vec3 playerOverworldPosition = null;
    static double x = 0;
    static double y = 0;
    static double z = 0;

    private void overworldCoordinateRecording() {
        // метод записи координат в файл для того, чтобы после закрытия майнкрафта данные не терялись
        // кастим double to string, чтобы записать данные в файл
        // в данном случае вручную ставим разделители, ибо у нас всего 3 числа
        try (FileWriter writer = new FileWriter("playerOverworldPosition.txt", false)) {

            String temp = Double.toString(x);
            writer.write(temp);
            writer.write(",");

            temp = Double.toString(y);
            writer.write(temp);
            writer.write(",");

            temp = Double.toString(z);
            writer.write(temp);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void overworldCoordinateReading() {
        // метод чтения координат из файла
        // данные туда заходят по разделителю "," запятая
        // по нему же их оттуда извлекаем, парсим в double
        try (FileReader reader = new FileReader("playerOverworldPosition.txt")) {
            Scanner scanner = new Scanner(reader);
            String coordinates = scanner.nextLine();
            String[] result = coordinates.split(",");

            x = Double.parseDouble(result[0]);
            y = Double.parseDouble(result[1]);
            z = Double.parseDouble(result[2]);

        } catch (IOException ex) {
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext onContext) {
        Player player = onContext.getPlayer();
        if (onContext.getLevel().dimension() == Level.OVERWORLD) {
            if (player != null) {
                playerOverworldPosition = player.position();
            }
        }



        MinecraftServer minecraftServer = onContext.getLevel().getServer();
        ResourceKey<Level> destination = onContext.getLevel().dimension() == ModDimensions.BOTTLEDIM_KEY
                ? Level.OVERWORLD : ModDimensions.BOTTLEDIM_KEY;

        ServerLevel bottledim_compare = null;
        if (minecraftServer != null) {
            bottledim_compare = minecraftServer.getLevel(ModDimensions.BOTTLEDIM_KEY);
        }
        ServerLevel overworld_compare = null;
        if (minecraftServer != null) {
            overworld_compare = minecraftServer.getLevel(Level.OVERWORLD);
        }

        ServerLevel destinationWorld = null;
        if (minecraftServer != null) {
            destinationWorld = minecraftServer.getLevel(destination);
        }

        if (destinationWorld == bottledim_compare) {
            if (playerOverworldPosition != null) {
                x = playerOverworldPosition.x;
                y = playerOverworldPosition.y;
                z = playerOverworldPosition.z;
                overworldCoordinateRecording();
            }
            // после того, как получаем координаты игрока записываем их в файл
            // записывать нужно каждый раз
            // так как игрок может закрыть или крашнуть майнкрафт в любой момент
            // ЗАПИСЬ КООРДИНАТ ВЕРХНЕГО МИРА
        }

        if (destinationWorld != null && minecraftServer.isNetherEnabled()) {
            if (player != null) {
                player.changeDimension(destinationWorld, new ModTeleporter(destinationWorld)); // телепорт в кастомное измерение
                if (destinationWorld == bottledim_compare) {
                    player.teleportTo(0, 58, 0);
                    // телепорт в кастомном измерении в нужную точку (там где стоит дом)
                } else {
                    if (x == 0 && y == 0 && z == 0) {
                        overworldCoordinateReading();
                        // читаем из файла координаты, маркером служит то, что все координаты равны 0
                        // что является нонсенсом, учитывая, что это double значение
                        // то есть означает то, что майнкрафт перезапускался и эти данные выгрузились
                        // и нулями эти ячейки забили мы
                    }
                    player.teleportTo(x, y, z);
                    // телепорт игрока в верхнем мире
                }
            }
        }

        return super.useOn(onContext);
    }
}
