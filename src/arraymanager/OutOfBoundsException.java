/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymanager;

/**
 *
 * @author 13065
 */
public class OutOfBoundsException extends Exception{
    
    public OutOfBoundsException()
    {
        super("Object not in bounds of array manager.");
    }
    
    public OutOfBoundsException(String message)
    {
        super(message);
    }
}
