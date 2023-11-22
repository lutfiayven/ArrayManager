/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymanager;

import java.util.Scanner;

/**
 *
 * @author 13065
 */
public class ArrayManagerDriver {
    
    static ArrayManager am;
    static Scanner input;
    
    public static void addItem(){        
        System.out.println("Please enter item to be added");
        int newItem = input.nextInt();
        //add the numbers 1-11 to our array
        am.add(newItem);
    }
    
    public static void addItemAt(){        
        System.out.println("Please enter item to be added");
        int newItem = input.nextInt();
        System.out.println("Please enter position");
        int position = input.nextInt();
        try {
            am.addAt(newItem, position);
        }
        catch(OutOfBoundsException oobe)
        {
            System.out.println(oobe.getMessage());
        }
    }
    
    public static void removeItem(){
        System.out.println("Please enter position to be removed");
        int position = input.nextInt();
        try
        {
            am.remove(position);
        }
        catch(NoItemsException nie)
        {
            System.out.println("There are no items to remove");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] items = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        am = new ArrayManager(items);
        int selectedOption = 1;
        do {
            System.out.println("Select from the following options");
            System.out.println("1. Display number or items");
            System.out.println("2. Display all items");
            System.out.println("3. Add an item");
            System.out.println("4. Add item at position");
            System.out.println("5. Remove item");
            System.out.println("6. Break");
            System.out.print("Enter option number:");
            input = new Scanner(System.in);
            selectedOption = input.nextInt();
            
            switch (selectedOption){
                case 1:
                    System.out.println(am.size());
                    break;
                case 2:
                    am.printArray();
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    addItemAt();
                    break;
                case 5:
                    removeItem();
                    break;
            }
        } while (selectedOption > 0 || selectedOption < 6);
        
        
    }   
}
