package com.Relearn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {

        String[] tools = {"Lights", "Cameras", "Actions"};

        List<String> toolsList = List.of(tools);
        System.out.println(toolsList);

        // -> A List is a Factory class [one that takes an argument and creates an object out of it, fundamentally. It hides the process of instantiating a class, but that's not the point though here...
        System.out.println(toolsList.getClass().getName());
        // -> It is a nested class within the ImmutableCollections class. It is Immutable! of type ListN -> java.util.ImmutableCollections$ListN

        // toolsList.add("distractions"); -> This gives us an Exception, because the List is immutable...

        // but here's how to use the list to populate an ArrayList
        System.out.println("--".repeat(15));
        ArrayList<String> otherItems = new ArrayList<>(toolsList);
        otherItems.add("Sacrifices");
        System.out.println(otherItems);

        //Another way to populate an ArrayList...
        String[] groceries = {"Mangoes", "Apples", "Oranges"};
        ArrayList<String> groceriesArrayList = new ArrayList<>(List.of(groceries));
        //OR
        ArrayList<String> flowers = new ArrayList<>(List.of("hibiscus", "rose", "sunflower", "cactus", "cadillac", "jasmine", "lilly", "paloma"));
        System.out.println(flowers);


        //We can also add a collection to an ArrayList like so...
        groceriesArrayList.addAll(toolsList); // -> We can add collections whether an Array or an ArrayList

        //Fetching data from an ArrayList
        System.out.println("---".repeat(10));
        System.out.println("The third flower in our garden is '" + flowers.get(2) + "'");


        //Searching
        if (flowers.contains("sunflower")){
            System.out.println("Our flower list contains sunflowers :)");
        }

        //Removing...
        System.out.println("---".repeat(10));
        System.out.println(flowers);

        flowers.remove("rose"); //takes an element
        System.out.println(flowers + " -> removed 'rose'");

        flowers.remove(3); //takes an index
        System.out.println(flowers+ " -> removed 'cadillac'");

        flowers.removeAll(List.of("sunflower", "cactus")); //takes a collection
        System.out.println(flowers+ " -> removed 'sunflower' and 'cactus'");

        flowers.retainAll(List.of("lilly", "jasmine", "hibiscus")); //clears the ArrayList but retains the items specified
        System.out.println(flowers+ " -> removed everything, only retaining 'lilly', 'jasmine', and 'hibiscus'");

        flowers.clear();
        System.out.println(flowers + " -> cleared the arraylist");

        System.out.println("isEmty: " + flowers.isEmpty());

        //Adding to an ArrayList using an ...array.util static method - the method takes an array, and makes a list out of it.
        System.out.println("---".repeat(10));
        flowers.addAll(Arrays.asList("hibiscus", "rose", "sunflower", "cactus", "cadillac", "jasmine", "lilly", "paloma"));

        //Sorting
        System.out.println(flowers);
        flowers.sort(Comparator.naturalOrder());
        System.out.println(flowers);
//        System.out.println(flowers);
//        flowers.sort(Comparator.reverseOrder()); -> in reverse alphabetical

        //to Array
        System.out.println("--".repeat(15));
        System.out.println("To Array");
        var flowersArray = flowers.toArray(); //-> without creating a 'new String[]' the type will be 'Object[]' and any type will be able to go into this collection
        var newFlowersArray = flowers.toArray(new String[0]); // -> the 'new String[0]' makes our Array accept only Strings. btw, this way is quite faster than the String[flowers.size()]

        // "... Lastly, we can firmly conclude that the toArray(new T[0]) variant is faster. "Lastly, we firmly conclude that the toArray(new T[size]) and, therefore, should always be the preferred option when we have to convert a collection to an array."
//      //https://www.udemy.com/course/java-the-complete-java-developer-course/learn/lecture/35423778#questions/20791382

//        var flowersArray = flowers.toArray(new String[flowers.size()]); -> The one above is enough...
        System.out.println(Arrays.toString(newFlowersArray));

    }

}
