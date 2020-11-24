
/**
 * Write a description of class Escritor here.
 *
 * @author Alejandro Araya - B80549
 * @version 18/11/2020
 */
import java.io.*;
public class Escritor
{
    private BufferedWriter writer;
    private boolean inUse;

    /**
     * Constructor for objects of class Escritor
     */
    public Escritor(String fileName, boolean addEnd){
        open(fileName, addEnd);
    }
    
    /**
     * Constructor for objects of class Escritor
     */
    public Escritor(String fileName)
    {
        open(fileName, true);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void open(String fileName, boolean addToEnd){
        try{
            writer = new BufferedWriter(new FileWriter(fileName, addToEnd));
            inUse = true;
        }   
        catch(IOException e)
        {
            inUse = false;
            System.err.println("Ocurrió un error al abrir el archivo: "+ e);
        }
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void close(){
        if(inUse){
            try{
                writer.close();
                inUse = false;
            }
            catch(IOException e){
                System.err.println("Ocurrió un error al abrir el archivo: "+ e);
            }
        }
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean write(String text){
        boolean written = false;
        
        if(inUse){
            try{
                writer.write(text);
                written = true;
            }
            catch(IOException e){
                System.err.println("Ocurrió un error al abrir el archivo: "+ e);
            }
        }
        
        return written;
    }
}   
