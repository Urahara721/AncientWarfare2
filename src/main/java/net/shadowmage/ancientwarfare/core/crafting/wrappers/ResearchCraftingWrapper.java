package net.shadowmage.ancientwarfare.core.crafting.wrappers;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.shadowmage.ancientwarfare.core.crafting.ICraftingRecipe;
import net.shadowmage.ancientwarfare.core.crafting.RecipeResourceLocation;
import net.shadowmage.ancientwarfare.core.crafting.ResearchRecipeBase;

public class ResearchCraftingWrapper implements ICraftingRecipe {
	private static final NonNullList<ItemStack> EMPTY_STACK_LIST = NonNullList.create();
	private final ResearchRecipeBase recipe;
	private final RecipeResourceLocation registryName;

	public ResearchCraftingWrapper(ResearchRecipeBase researchRecipe) {
		this.recipe = researchRecipe;
		if (researchRecipe.getRegistryName() == null) {
			throw new IllegalArgumentException("Null registryName recipes are not allowed here");
		}
		this.registryName = new RecipeResourceLocation(RecipeResourceLocation.RecipeType.RESEARCH, researchRecipe.getRegistryName());
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipe.getIngredients();
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return recipe.getCraftingResult(inv);
	}

	@Override
	public ItemStack getRecipeOutput() {
		return recipe.getRecipeOutput();
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting invCrafting) {
		return EMPTY_STACK_LIST;
	}

	@Override
	public RecipeResourceLocation getRegistryName() {
		return registryName;
	}
}
