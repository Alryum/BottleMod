package dev.alryum.bottlemod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.alryum.bottlemod.BottleMod.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> BOTTLE_BLOCK = BLOCKS.register("bottle_block", () -> new Block(BlockBehaviour.Properties
            .of(Material.STONE)
            .destroyTime(-1)
    ));

    public static final RegistryObject<Block> RESIN_BLOCK = BLOCKS.register("resin_block", () -> new Block(BlockBehaviour.Properties
            .of(Material.STONE)
            .strength(1.5F)
            .requiresCorrectToolForDrops()
    ));
}
