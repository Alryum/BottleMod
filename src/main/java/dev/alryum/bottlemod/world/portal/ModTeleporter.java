package dev.alryum.bottlemod.world.portal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class ModTeleporter implements ITeleporter {
    protected final ServerLevel level;

    public ModTeleporter(ServerLevel serverLevel) {
        this.level = serverLevel;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        return ITeleporter.super.placeEntity(entity, currentWorld, destWorld, yaw, repositionEntity);
    }

    @Override
    public @Nullable PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        return ITeleporter.super.getPortalInfo(entity, destWorld, defaultPortalInfo);
    }

    @Override
    public boolean isVanilla() {
        return ITeleporter.super.isVanilla();
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        return false;
    }
}
