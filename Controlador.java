
/**
 * Write a description of class Controlador here.
 *
 * @author Alejandro Araya - B80549
 * @version 22/11/2020
 */
public class Controlador
{
    private Modelo modelo;
    private Interfaz interfaz;

    /**
     * Constructor for objects of class Controlador
     */
    public Controlador(Modelo modelo, Interfaz interfaz)
    {
        this.modelo = modelo;
        this.interfaz = interfaz;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getFileNameControlador(String fileName){
        return modelo.getFileName(fileName);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void resetListsControlador(){
        modelo.resetLists();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void resetEquationControlador(){
        modelo.resetEquation();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setEquationValuesControlador(String referencePolynomial1, String referencePolynomial2, String referenceOperating){
        modelo.setEquationValues(referencePolynomial1, referencePolynomial2, referenceOperating);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void readFileEquationControlador(String fileName){
        modelo.readFileEquation(fileName);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void doOperationControlador(Nodo actualNode,ListaEnlazada list, String operating){
        modelo.doOperation(actualNode, list, operating);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void readManualEquationControlador(){
        modelo.readManualEquation();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean writeOutcomeControlador(){
        return modelo.writeOutcome();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ListaEnlazada getList1Controlador(){
        return modelo.getList1();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ListaEnlazada getList2Controlador(){
        return modelo.getList2();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getOperatingControlador(){
        return modelo.getOperating();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getOutcomeControlador(){
        return modelo.getOutcome();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getPolynomial1Controlador(){
        return modelo.getPolynomial1();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getPolynomial2Controlador(){
        return modelo.getPolynomial2();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String calculatorMenuControlador(){
        return interfaz.calculatorMenu();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String[] askEquationControlador(){
        return interfaz.askEquation();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean writeEquationControlador(String fileName){
        return interfaz.writeEquation(fileName);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String askFileNameControlador(){
        return interfaz.askFileName();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void deployEquationControlador(String polynomial1, String polynomial2, String operating, String outcome){
        interfaz.deployEquation(polynomial1, polynomial2, operating, outcome);
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void deployWritingErrorControlador(){
        interfaz.deployWritingError();
    }
    
    
    public void startCalculator(){
        String entry = "";
        
        while(!"S".equals(entry.toUpperCase())){
            entry = calculatorMenuControlador();
            
            if(entry != null){
                switch(entry.toUpperCase()){
                    case "A":
                        String[] values = askEquationControlador();
                        setEquationValuesControlador(values[0],values[2],values[1]);
                        readManualEquationControlador();
                        ListaEnlazada list1 = getList1Controlador();
                        ListaEnlazada list2 = getList2Controlador();
                        String operating = getOperatingControlador();
                        doOperationControlador(list1.getFirst(), list2, operating);
                        String outcome = getOutcomeControlador();
                        deployEquationControlador(values[0], values[2], operating, outcome);
                        resetListsControlador();
                        resetEquationControlador();
                        break;
                    case "B":
                        String file = askFileNameControlador();
                        String fileName = getFileNameControlador(file);
                        boolean control1 = writeEquationControlador(fileName);
                        if(!control1){
                            deployWritingErrorControlador();
                        }
                        readFileEquationControlador(fileName);
                        ListaEnlazada list3 = getList1Controlador();
                        ListaEnlazada list4 = getList2Controlador();
                        String operating1 = getOperatingControlador();
                        String outcome1 = getOutcomeControlador();
                        String polynomial1 = getPolynomial1Controlador();
                        String polynomial2 = getPolynomial2Controlador();
                        doOperationControlador(list3.getFirst(), list4, operating1);
                        deployEquationControlador(polynomial1, polynomial2, operating1, outcome1);
                        boolean control2 = writeOutcomeControlador();
                        if(!control2){
                            deployWritingErrorControlador();
                        }
                        resetListsControlador();
                        resetEquationControlador();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
