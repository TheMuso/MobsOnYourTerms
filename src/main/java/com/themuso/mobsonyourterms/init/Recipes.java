package com.themuso.mobsonyourterms.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mobSpawningStaff), " d ", "dld", " s ", 'd', "gemDiamond", 'l', "gemLapis", 's', "stickWood"));
	}
}
