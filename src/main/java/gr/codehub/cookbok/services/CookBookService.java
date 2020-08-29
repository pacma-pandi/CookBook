package gr.codehub.cookbok.services;

import gr.codehub.cookbok.model.CookBook;

public class CookBookService {

    public CookBook createCookBook() {
        CookBook cookBook = new CookBook("Recipes for beginners");
        RecipesListsService rls = new RecipesListsService();
        cookBook.getRecipes().addAll(rls.createEggRecipes());
        cookBook.getRecipes().addAll(rls.createVegetarianRecipes());
        return cookBook;
    }

}
