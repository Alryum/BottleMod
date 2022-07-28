package dev.alryum.bottlemod.items;

import dev.alryum.bottlemod.blocks.ModBlocks;
import dev.alryum.bottlemod.items.custom.Bottle;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.alryum.bottlemod.BottleMod.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> RAINBOW_PITCH = ITEMS.register("rainbow_pitch", () -> new Item(new Item.Properties().tab(ModCreativeTabs.CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> BOTTLE = ITEMS.register("bottle", () -> new Bottle(new Item.Properties().stacksTo(1).tab(ModCreativeTabs.CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> BOTTLE_BLOCK = ITEMS.register("bottle_block", () -> new BlockItem(ModBlocks.BOTTLE_BLOCK.get(), new Item.Properties().tab(ModCreativeTabs.CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> RESIN_BLOCK = ITEMS.register("resin_block", () -> new BlockItem(ModBlocks.RESIN_BLOCK.get(), new Item.Properties().tab(ModCreativeTabs.CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> RESIN_MEAT = ITEMS.register("resin_meat", () -> new Item(new Item.Properties().tab(ModCreativeTabs.CREATIVE_MODE_TAB).food(ModFoods.RESIN_MEAT)));
}