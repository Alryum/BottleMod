package dev.alryum.bottlemod.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab("bottlemod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BOTTLE.get());
        }
    };
}
