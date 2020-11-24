
/**
 * Write a description of class Lector here.
 *
 * @author Alejandro Araya - B80549
 * @version 18/11/2020
 */
import java.io.*;
public class Lector
{
    private BufferedReader reader;
    private boolean inUse;

    /**
     * Constructor for objects of class Lector
     */
    public Lector(String fileName){
        try
        {
            reader = new BufferedReader( new FileReader(fileName));
            inUse = true;
        }
        catch(IOException e)
        {
            inUse = false;
            System.err.println("Ocurrió un error al abrir el archivo: " + e);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void close()
    {
        if(inUse){
            try
            {
                reader.close();
                inUse = false;
            }
            catch(IOException e)
            {
                System.out.println("Ocurrió un error al abrir el archivo: " + e);
            }
        }
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String readLine(){
        String content = "";
        
        if(inUse){
            try
            {
                content = reader.readLine();
            }
            catch(IOException e)
            {
                System.err.println("Ocurrió un error al abrir el archivo: " + e);
            }
        }
        
        return content;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String readFile(){
        String content = "";
        
        if(inUse){
            String line = "";
            while((line = readLine()) != null){
                content += line;
                content += "\r\n";
            }
        }
        
        return content;
    }   
}
