
/**
 * Write a description of class Nodo here.
 *
 * @author Alejandro Araya - B80549
 * @version 18/11/2020
 */
public class Nodo
{
    // instance variables - replace the example below with your own
    private int coefficient;
    private String unknown;
    private int power;
    private Nodo next;

    /**
     * Constructor for objects of class Nodo
     */
    public Nodo(){
        coefficient = 0;
        unknown = "x";
        power = 0;
        next = null;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setCoefficient(int referenceCoefficient){
        coefficient = referenceCoefficient;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setUnknown(String referenceUnknown){
        unknown = referenceUnknown;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setPower(int referencePower){
        power = referencePower;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setNext(Nodo referenceNext){
        next = referenceNext;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getCoefficient(){
        return coefficient;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getUnknown(){
        return unknown;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getPower(){
        return power;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Nodo getNext(){
        return next;
    }
}
