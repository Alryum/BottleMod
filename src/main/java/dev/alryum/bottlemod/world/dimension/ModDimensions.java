package dev.alryum.bottlemod.world.dimension;

import dev.alryum.bottlemod.BottleMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;


public class ModDimensions {
    public static final ResourceKey<Level> BOTTLEDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(BottleMod.MODID, "bottle_dimension"));
    public static final ResourceKey<DimensionType> BOTTLEDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, BOTTLEDIM_KEY.registry());

    public static void register() {

    }
}
