package dev.alryum.bottlemod;

import dev.alryum.bottlemod.world.dimension.ModDimensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import static dev.alryum.bottlemod.blocks.ModBlocks.BLOCKS;
import static dev.alryum.bottlemod.items.ModItems.ITEMS;

@Mod(dev.alryum.bottlemod.BottleMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BottleMod
{
    public static final String MODID = "bottlemod";
    public BottleMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        ModDimensions.register();
    }
}
