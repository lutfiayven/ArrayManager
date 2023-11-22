/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraymanager;

/**
 *
 * @author 13065
 */
public class ArrayManager {

    private int[] items;
    private int count; // tells us where the end of our array is

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }
    
    // A constructor that accepts an array of integers to be assigned to items
    public ArrayManager(int[] items) {
        this.items = items;
        count = items.length;
    }

    // A parameterless constructor that sets count to 0 and sizes the array to 10.
    public ArrayManager() {
        items = new int[10];
        count = 0;
    }
    
    // A constructor that accepts an integer and sizes the array.
    public ArrayManager(int itemNumber) {
        items = new int[itemNumber];
        count = items.length;
    }
    
    // returns the size of the populated elements array
    // ------------------------------------------------
    // return - integer size of the array tracked with count
    public int size(){
        return count;
    }
    
    //prints out all elements in the array
    public void printArray(){
        for(int i = 0; i < items.length; i++)
        {
            System.out.println("items["+i+"]: "+ items[i]);
        }
    }
    
    //prints out only the items that are populated
    public void printItems()
    {
        for(int i = 0; i < count; i++)
        {
            System.out.println("items["+i+"]: "+ items[i]);
        }
    }
    
    //this function adds an item to the end of our array
    //---------------------------------------------------
    // int newItem - the item to be added to the array
    public void add(int newItem)
    {
        //if we have reached the limit of our array size
        if(count == items.length)
        {
            increaseItemsSize();
        }
        
        items[count] = newItem;
        count++;
    }
    
    // increases the size of the items array by 10
    public void increaseItemsSize()
    {
        //make a new, bigger array
        int[] newItems = new int[items.length + 10];

        //copy the old array into the new array
        System.arraycopy(items,0,newItems,0,items.length);

        //save the new array over the old array
        items = newItems;
    }

    //removes an element from the array and moves everything after up by one
    //---------------------------------------------------------------------
    // int pos - the position of the element to remove
    public void remove(int pos) throws NoItemsException
    {
        if(count == 0)
        {
            throw new NoItemsException();
        }
        
        
        // if the item requested it outside of the bounds of our array do not perform this action
        if(pos < count)
        {
            // if we are not removing the last element, we need to replace the data on other positions
            if(pos != count-1){
               // shift all elements up
                for(int i = pos; i < count - 1; i++)
                {
                    items[i] = items[i+1];
                }
                // set the last element to 0 since it was copied on the previous function
                items[count-1] = 0;
            }
            // if removing the last element just set it to 0
            else {
                System.out.println("pos " + pos + " - count " + count);
                items[pos] = 0;
            }

            // lower count 
            count--;
        }
        // print message if selected position is greater thab count
        else {
            System.out.println("Cannot add item to position outside of array");
        }
    }
    
    // adds an element to the array at a specified position
    //-----------------------------------------------------
    // int n - the element we are adding
    // int pos - the position we are adding the element at
    public void addAt(int n, int pos) throws OutOfBoundsException
    {
        // error checking
        // check for negative numbers
        if(pos < 0 || pos > count)
        {
            throw new OutOfBoundsException("Cannot add item to position outside of array");
        }

        // if we are adding an item to the end of items, just use the add method
        if(pos == items.length)
        {
            increaseItemsSize();
        }
       
        // shift the position of all elements at and after pos
        for(int i = count; i > pos; i--)
        {
            items[i] = items[i-1];
        }

        // add element at position
        items[pos] = n;
        // increase count
        count ++;

    }
    
    //function to determine if array is empty
    //----------------------------------------
    // return - returns true if array is empty
    public boolean isEmpty()
    {
        if(count == 0)
            return true;
        else
            return false;
    } 
}