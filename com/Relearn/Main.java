package com.Relearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

record GroceryItem(String name, String category, int count){

    public GroceryItem(String name){
        this(name, "uncategorised", 1);
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "name='" + name +
                "', category='" + category +
                "', count='" + count + "'" +
                "} ";
    }
}

record ItemsAndTools(String name, String purpose, int count, boolean isUrgent){

    public ItemsAndTools(String name){
        this(name, "uncategorized", 1, false);
    }

    public ItemsAndTools(String name, boolean isUrgent ){
        this(name, "uncategorized", 1, isUrgent);
    }

    @Override
    public String toString() {
//        return "ItemsAndTools{" +
//                "name='" + name + "" +
//                ", purpose='" + purpose + '\'' +
//                ", count=" + count +
//                ", isUrgent=" + isUrgent +
//                "} ";
//       return String.format("*Name: %s%nPurpose: %s%nCount: %d%nIsUrgent: %s%n*", name, purpose, count, isUrgent);
        return ("\nName: " + name + "\nPurpose: " + purpose + "\nCount: " + count + "\nisUrgent: " + isUrgent);
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Object[] grocery = new Object[3];
//        grocery[0] = new GroceryItem("milk");
//        grocery[1] = new GroceryItem("apples", "produce", 6);
//        grocery[2] = "mangoes";   ->   Even though this compiles, it is not exactly what we want, we want a list of grocery items,
//        so using the generic array Object[] is not very efficient in upholding that rule.

        GroceryItem[] groceryItems = new GroceryItem[3];

        groceryItems[0] = new GroceryItem("milk");
        groceryItems[1] = new GroceryItem("apples", "produce", 6);
        groceryItems[2] = new GroceryItem("oranges", "produce", 7);

        System.out.println(Arrays.toString(groceryItems));

        System.out.println("--".repeat(15));
        ArrayList objectsList = new ArrayList(); // -> We shouldn't make raw usage... it is going to use the Object type if we don't specify the object we want... so...

        ArrayList<ItemsAndTools> itemsAndTools = new ArrayList<>(); //Using ArrayList();
        itemsAndTools.add(new ItemsAndTools("C Course", "Programming", 1, false));
        itemsAndTools.add(new ItemsAndTools("Phone", true));
        itemsAndTools.add(0, new ItemsAndTools("Book", "Journaling and Studying", 6, true)); // -> the .add([index], object) adds the item to an index
//        itemsAndTools.set(0, new ItemsAndTools("Book", "Journaling and Studying", 6, true));  -> the .set([index], object) replaces an item in an index
//        itemsAndTools.remove(0);  -> the .remove(index) removes an item at an index


        System.out.println(itemsAndTools);



    }
}
