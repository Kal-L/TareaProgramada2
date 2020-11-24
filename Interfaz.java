
/**
 * Write a description of class Interfaz here.
 *
 * @author Alejandro Araya - B80549
 * @version 22/11/2020
 */
import javax.swing.JOptionPane;
public class Interfaz
{
    // instance variables - replace the example below with your own
    private Escritor writer;

    /**
     * Constructor for objects of class Interfaz
     */
    public Interfaz()
    {
        writer = new Escritor("");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String calculatorMenu(){
        String answer = "";
        
        answer = JOptionPane.showInputDialog("Seleccione la opción que desee utilizar de la calculadora: \n"
                                                +"A. Ingresar los datos manualmente\n"
                                                +"B. Ingresar los datos en un archivo\n"
                                                +"S. Salir");
        
        return answer;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String[] askEquation(){
        String[] answers = new String[3];
        
        answers[0] = JOptionPane.showInputDialog("Ingrese la primera ecuación: ");
        JOptionPane.showMessageDialog(null, answers[0]);
        answers[1] = JOptionPane.showInputDialog("Ingrese el operando: ");
        JOptionPane.showMessageDialog(null, answers[0]+answers[1]);
        answers[2] = JOptionPane.showInputDialog("Ingrese la segunda ecuación: ");
        JOptionPane.showMessageDialog(null, answers[0]+answers[1]+answers[2]);
        
        return answers;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean writeEquation(String fileName){
        String equation = JOptionPane.showInputDialog("Ingrese los datos de la operación que desea realizar "
                                                    +"en el formato respectivo: ");
        writer = new Escritor(fileName);
        boolean control = writer.write(equation+"\r\n");
        writer.close();
        return control;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String askFileName(){
        String fileName = JOptionPane.showInputDialog("Escriba el nombre del archivo donde desea escribir las operaciones: ");
        return fileName;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void deployEquation(String polynomial1, String polynomial2, String operating, String outcome){
        JOptionPane.showMessageDialog(null, polynomial1+"|"+operating+"|"+polynomial2+"|"+outcome);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void deployWritingError(){
        JOptionPane.showMessageDialog(null, "Ocurrió un error al tratar de escribir en el archivo");
    }
}
