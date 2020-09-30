package gr.codehub.cookbok.services;

import gr.codehub.cookbok.model.Ingredient;
import gr.codehub.cookbok.model.Recipe;

public class RecipesService {

    public Recipe createBoiledEggsRecipe(){
        Recipe recipe = new Recipe("boiled eggs");
        recipe.addIngredient(new Ingredient("egg", 2));
        return recipe;
    }

    public Recipe createOmeletteRecipe(){
        Recipe recipe = new Recipe("omelette");
        recipe.addIngredient(new Ingredient("egg", 2));
        recipe.addIngredient(new Ingredient("cheese", 200));
        recipe.addIngredient(new Ingredient("milk", 50));
        return recipe;
    }

    public Recipe createGreekSaladRecipe(){
        Recipe r = new Recipe("greek salad");
        r.addIngredient(new Ingredient("tomato", 2));
        r.addIngredient(new Ingredient("cucumber", 2));
        r.addIngredient(new Ingredient("olive oil", 100));
        r.addIngredient(new Ingredient("feta", 200));
        return r;
    }

    public Recipe createSimplePastaRecipe(){
        Recipe r = new Recipe("simple pasta");
        r.addIngredient(new Ingredient("macaroni", 150));
        r.addIngredient(new Ingredient("olive oil", 50));
        return r;
    }
}
