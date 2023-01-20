package sg.edu.nus.iss;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shoppingcart {
    public static void main(String[] args) {
        // Prints the welcome message
        System.out.println("Welcome to your shopping cart");

        // Creates an empty list to store the items in the shopping cart
        //ArrayList is like a special kind of shopping list that can add and remove things quickly and find specific things on the list quickly
        List<String> cartItems = new ArrayList<String>();

        // Create a console object to read input from the command line
        //provides methods for reading input from the command line and for printing output to the command line
        Console cons = System.console();
        String input = "";
        // Enter a while loop that continues until the input is "quit"
        while (!input.equals("quit")) {         
            // Prompt the user to enter a command
            // cons.readLine() read a line of text from the console.
            // text is read as a String, and the method returns the text that was entered by the user.
            input = cons.readLine("What do you like to do? (type 'help' to show list of commands)");

            // Check the input against several possible commands
            if (input.equals("help")) {
                // Display a list of available commands
                System.out.println("'list' to show a list of items in shopping cart");
                System.out.println("add <item name>");
                System.out.println("delete <item number>");
                System.out.println("'quit' to exit program");
            } 

            if (input.equals("list")) {
                // Check if the cart is empty
                if (cartItems.size() > 0) {
                    // Print out each item in the cart, along with its index in the list
                    for (int i = 0; i < cartItems.size(); i++)
                        System.out.printf("%d. %s\n", i+1 , cartItems.get(i));
                } else {
                    // If the cart is empty, print a message
                    System.out.println("Your cart is empty");
                }
            }

            //checks if the input starts with 'add'
            if (input.startsWith("add")) {

                // Replace any commas with spaces in the input
                input = input.replace(',', ' ');

                //declares a new variable which stores items the user wants to add
                String stringVal = "";
                // Use a scanner to parse the input and extract the item name
                //scanner is used only for primitive types and strings using regex
                //this removes first four characters "add "
                Scanner scan = new Scanner(input.substring(4));

                //while loops through input and extract each item name
                //hasNext method returns true if there is another item available
            
                while(scan.hasNext()) {
                    //returns the next token from the scanner
                    stringVal = scan.next();

                    //checks if input has already existed
                    if ((cartItems).contains(stringVal)){
                        System.out.printf("Sorry, the item '%s' already exists. \n", stringVal);
                    } else {
                        System.out.printf("We will now proceed to add '%s'. \n", stringVal);
                        // Add the item to the cart
                        cartItems.add(stringVal);
                    }
  
                }
            }

            if (input.startsWith("delete")) {
                String stringVal = "";
                // Use a scanner to parse the input and extract the item index
                Scanner scan = new Scanner(input.substring(6));

                while(scan.hasNext()) {
                    stringVal = scan.next();

                    // Convert the string to an int as stringVal is a string
                    int listItemIndex = Integer.parseInt(stringVal);

                    if (listItemIndex < cartItems.size()) {
                        // Remove the item from the cart
                        cartItems.remove(listItemIndex);
                    } else {
                        // If the index is out of range, print an error message
                        System.out.println("Incorrect item index");
                    }

                }
            }
        }

        // Print a goodbye message
        System.out.println("Goodbye!!! See you again!");}}
