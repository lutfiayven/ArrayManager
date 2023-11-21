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

    public ArrayManager() {
        items = new int[10];
        count = 0;
    }

    public ArrayManager(int[] items) {
        this.items = items;
        count = items.length;
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
    
    //prints out all elements in the array
    public void printArray()
    {
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
    
    // returns the size of the populated elements array
    // ------------------------------------------------
    // return - integer size of the array tracked with count
    public int size()
    {
        return count;
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
            // if we are removing the last element, we dont need to replace the data
            if(pos != count-1)
            {
               // shift all elements up
                for(int i = pos; i < count - 1; i++)
                {
                    items[i] = items[i+1];
                } 
            }

            // lower count 
            count--;
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayManager am = new ArrayManager();
        
        //add the numbers 1-11 to our array
        for(int i = 1; i <= 10; i++)
        {
            am.add(i);
        }
        
        //print out array
        System.out.println("-------Print items---------");
        am.printItems();
        
        System.out.println("-------Remove item---------");
        try
        {
            am.remove(3);
        }
        catch(NoItemsException nie)
        {
            System.out.println("There are no items to remove");
        }
        
        System.out.println("-------Add item---------");
        try
        {
            am.addAt(1000, 15);
        }
        catch(OutOfBoundsException oobe)
        {
            System.out.println(oobe.getMessage());
        }
            
        //print out array
        System.out.println("-------Print items---------");
        am.printItems();
        
        System.out.println("-------Print Array---------");
        am.printArray();
    }
    
}
