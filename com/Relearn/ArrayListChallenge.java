package com.Relearn;
import javax.naming.spi.DirObjectFactory;
import java.util.*;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> groceries = new ArrayList<>();
        boolean flag = true;

        while(flag){
            printOptions();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false; // -> break out of the loop if the caller types anything else
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println("Your list: " + groceries);
        }

//        var grocArr = groceries.toArray(new String[0]);   System.out.println(Arrays.toString(grocArr));

//        challenge();
    }

    public static void addItems(ArrayList<String> groceries){
        System.out.println("Add item(s) [separate items by a comma]:");
        String[] items = scanner.nextLine().split(","); //delimit the items by a ','

        for (String item : items){
            String i = item.trim(); //remove whitespaces

            if (!groceries.contains(i)){ //look out for duplicates
                groceries.add(i);
            }
        }
    }

    public static void removeItems(ArrayList<String> groceries){
        System.out.println("Remove item(s) [delimited by a coma]: ");
        String[] items = scanner.nextLine().split(",");

        for (String item : items) {
            String i = item.trim();
                groceries.remove(i);
            }
    }

    public static void printOptions(){
        String textBlock = """
                Available Actions:
                
                0 - to shutdown
                
                1 - to add item(s) to a list (comma delimited list)
                
                2 - to remove any items (comma delimited list)
                
                Enter a number for which action you want to do:""";

        System.out.println(textBlock + " ");
    }

//    public static void challenge(){
//
//        String textBlock = """
//                Available Actions:
//
//                0 - to shutdown
//
//                1 - to add item(s) to a list (comma delimited list)
//
//                2 - to remove any items (comma delimited list)
//
//                Enter a number for which action you want to do:""";
//
//        System.out.println(textBlock + " ");
//
//        int response = scanner.nextInt();
//
//        if (response == 0){
//            return;
//        }
//        else if (response == 1){
//            scanner.nextLine();
//
//            String[] usersAddings = new String[] {scanner.nextLine()};
//            groceries.addAll(List.of(usersAddings));
//            groceries.sort(Comparator.naturalOrder());
//
//            System.out.println("Your grocery list: " + groceries);
//
//            challenge();
//        }
//
//        else if (response == 2){
//            scanner.nextLine();
//
//            String[] usersRemovals = new String[] {scanner.nextLine()};
//            if (!groceries.containsAll(List.of(usersRemovals))){
//                groceries.removeAll(List.of(usersRemovals));
//            }
//
//            System.out.println("Your list: " + groceries);
//            challenge();
//        }
//    }
}
