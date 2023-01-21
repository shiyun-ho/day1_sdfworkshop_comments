package sg.edu.nus.iss;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shoppingcart_try {
    public static void main(String[] args) {
        //print welcome statement
        System.out.println("Welcome to your personalised shopping cart!");

        //create an empty list to store shopping cart
        List<String> cartItems = new ArrayList<String>();

        //require a console object to read input from the command line
        Console console = System.console();
        //empty string to store items within input
        String input = "";

        //as this program requires it to keep looping, a while loop will be required

        while (!input.equalsIgnoreCase("quit")){
            //continuously prompt the user to enter command
            input = console.readLine("What would you like to do? Type 'help' for more instructions. \n");
        
            //checks input against a variety of commands

            //help function 
            if (input.equalsIgnoreCase("help")){
                System.out.println("'list' to show items within the current shopping cart.");
                System.out.println("'add' to add items to the shopping cart");
                System.out.println("'delete' to remove item from shopping cart by index");
                System.out.println("'quit' to quit the shopping cart program");
            }

            //list function
            if (input.equalsIgnoreCase("list")){
                //check if empty
                if (cartItems.size()>0){
                    for (int i = 0; i < cartItems.size(); i++){
                        System.out.printf("%d. %s \n", i+1, cartItems.get(i));
                    }
                } else {
                    System.out.println("You have no items in your shopping cart! Type 'add' to add items to your shopping cart.");
                }
            }

            if (input.startsWith("add")){
                //as there might be multiple items added, replace , with ' '
                input = input.replace(',', ' ');

                //declare new String variable to store items
                String str = "";
                //scanner to parse through input and extract item name only from index 4
                Scanner scan = new Scanner(input.substring(4));
                
                //use a while loop to make sure all items are covered
                while (scan.hasNext()){
                    //scans the next item 
                    str = scan.next();

                    //if items exist, then 
                    if ((cartItems.contains(str))){
                        System.out.printf("Sorry, the item '%s' already exists.\n", str);
                    } else{
                        System.out.printf("Added '%s' to the shopping cart. \n", str);
                        cartItems.add(str);
                    }

                }
            }

            if (input.startsWith("delete")){
                //declares empty string to store items to be deleted
                String str = "";

                //use scanner to parse through response. Start by index 6 to ignore the word delete
                Scanner scan = new Scanner(input.substring(6));

                //while loop to scan through all possible responses
                while (scan.hasNext()){
                    //string is the next item token in line
                    str = scan.next(); 

                    //convert the string to an int as str is a string, we should delete by index
                    //as the item index is back by 1 number (index shows 0 when item looks 1 on interface)
                    int listItemIndex = Integer.parseInt(str) - 1; 

                    if (listItemIndex < cartItems.size()){
                        cartItems.remove(listItemIndex); 
                    } else{
                        System.out.println("Incorrect item index.");
                    }
                }
            }
        
        }

        //when they type quit
        if (input.equalsIgnoreCase("quit")){
            System.out.println("Goodbye!");
        }
        
    }
}
