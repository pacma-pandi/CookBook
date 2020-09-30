package gr.codehub.cookbok;

import gr.codehub.cookbok.exceptions.BusinessException;
import gr.codehub.cookbok.model.CookBook;
import gr.codehub.cookbok.model.Ingredient;
import gr.codehub.cookbok.model.Recipe;
import gr.codehub.cookbok.services.CookBookService;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    private static String readFile(File file) throws BusinessException {
        System.out.println("read file step 1");
        try {
            System.out.println("read file step 2");
            BufferedReader br = new BufferedReader((new FileReader(file)));
            System.out.println("read file step 3");
        } catch (FileNotFoundException e) {
            System.out.println("read file step 4");
            throw new BusinessException();
        }
        System.out.println("read file step 5");
        return "(some content from the file)";
    }

    private static void testRecipeWords() {
        String recipeText = "ena avgo kai mia mpanana kai ena portokali kai ena mhlo ha ha ha ha ha";
        String[] wordsArray = recipeText.split(" ");
        List<String> wordsList = Arrays.asList(wordsArray);

        List<String> longWords = wordsList
                .stream()
                .filter(word -> word.length() > 3)
                .collect(Collectors.toList());

        System.out.println("\nPRINT LONG WORDS WITH for:");
        for (String word : longWords) {
            System.out.println(word);
        }

        System.out.println("\nPRINT LONG WORDS WITH forEach:");
        longWords.forEach(System.out::println);


        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : wordsList) {
            Integer wordCount = wordCountMap.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }
            wordCount++;
            wordCountMap.put(word, wordCount);
        }

        System.out.println("\nPRINT WORD COUNT WITH forEach:");
        wordCountMap
                .forEach((name, count) -> System.out.println(name + " = " + count));

        System.out.println("\nPRINT WORDS FROM MAP:");
        for (String s : wordCountMap.keySet()) {
            System.out.println(s);
        }

        System.out.println("\nPRINT COUNTS FROM MAP:");
        for (Integer s : wordCountMap.values()) {
            System.out.println(s);
        }

        System.out.println("\nPRINT WORDS AND COUNTS FROM MAP:");
        for (Map.Entry entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static void testReadFile() {
        try {
            readFile(new File("difgywdoigvywiogyvceiwygvpvye.ce9igyiyg"));
        } catch (BusinessException e) {
            System.out.println("Business error: cannot see the contents of this file");
        }
    }

    private static void testCookBook() {
        CookBook cookBook = new CookBookService().createCookBook();

        List<Recipe> allRecipes = cookBook.getRecipes();
        System.out.println("\nThe book contains " + allRecipes.size() + " recipes");
        for (Recipe recipe : allRecipes)
            System.out.println("Recipe = " + recipe.getName());

        List<Ingredient> allIngredients = new ArrayList<>();
        for (Recipe recipe : allRecipes)
            allIngredients.addAll(recipe.getIngredients());
        System.out.println("\nThe book recipes use " + allIngredients.size() + " ingredients (with quantities)");
        for (Ingredient ingredient : allIngredients)
            System.out.println("Ingredient = " + ingredient.getName() + ", " + ingredient.getQuantity());

        Set<Ingredient> allUniqueIngredients = new HashSet<>(allIngredients);
        System.out.println("\nThe book recipes use " + allUniqueIngredients.size() + " unique ingredients (with quantities)");
        for (Ingredient ingredient : allUniqueIngredients)
            System.out.println("Unique ingredient = " + ingredient.getName() + ", " + ingredient.getQuantity());

        Set<String> allIngredientTypes = new HashSet<>();
        for (Ingredient ingredient: allIngredients)
            allIngredientTypes.add(ingredient.getName());
        System.out.println("\nThe book recipes use " + allIngredientTypes.size() + " unique ingredient types");
        for (String name: allIngredientTypes)
            System.out.println("Unique ingredient type = " + name);

    }

    public static void main(String[] args) {
        System.out.println("\n===== TESTING COOK BOOK =====");
        testCookBook();

        System.out.println("\n===== TESTING RECIPE WORDS =====");
        testRecipeWords();

        System.out.println("\n===== TESTING READ FILE =====");
        testReadFile();
    }


}
