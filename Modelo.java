
/**
 * Write a description of class Modelo here.
 *
 * @author Alejandro Araya - B80549
 * @version 19/11/2020
 */
public class Modelo
{
    // instance variables - replace the example below with your own
    private ListaEnlazada list1;
    private ListaEnlazada list2;
    private ListaEnlazada temporalList;
    String polynomial1;
    String polynomial2;
    String operating;
    String outcome;

    /**
     * Constructor for objects of class Controlador
     */
    public Modelo()
    {
        list1 = new ListaEnlazada();
        list2 = new ListaEnlazada();
        temporalList = new ListaEnlazada();
        polynomial1 = "";
        polynomial2 = "";
        operating = "";
        outcome = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getFileName(String fileName){
        return "Archivos/"+fileName;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void resetLists(){
        list1.resetList();
        list2.resetList();
        temporalList.resetList();
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void resetEquation(){
        polynomial1 = "";
        polynomial2 = "";
        operating = "";
        outcome = "";
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setEquationValues(String referencePolynomial1, String referencePolynomial2, String referenceOperating){
        polynomial1 = referencePolynomial1;
        polynomial2 = referencePolynomial2;
        operating = referenceOperating;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void readFileEquation(String fileName){
        Lector reader = new Lector(fileName);
        String line = reader.readLine();
        reader.close();
        
        String[] split1 = line.split("|");
        polynomial1 = split1[0];
        operating = split1[1];
        polynomial2 = split1[2];
        
        String[] split2 = split1[0].split(" ");
        String[] split3 = split1[2].split(" ");
        
        if("+".equals(operating) || "-".equals(operating)){
            
            for(int index = 0; index < split2.length; index++){
                if(index > 0 && "-".equals(split2[index-1])){
                    String aux = "-"+split2[index];
                    split2[index] = aux;
                }
                list1.addNodeMonomial(split2[index]);
                index++;
            }
            
            for(int index = 0; index < split3.length; index++){
                if(index > 0 && "-".equals(split3[index-1])){
                    String aux = "-"+split3[index];
                    split3[index] = aux;
                }
                list1.addNodeMonomial(split3[index]);
                index++;
            }
        }else{
            for(int index = 0; index < split2.length; index++){
                if(index > 0 && "-".equals(split2[index-1])){
                    String aux = "-"+split2[index];
                    split2[index] = aux;
                }
                list1.addNodeMonomial(split2[index]);
                index++;
            }
        
            for(int index = 0; index < split3.length; index++){
                if(index > 0 && "-".equals(split3[index-1])){
                    String aux = "-"+split3[index];
                    split3[index] = aux;
                }
                list2.addNodeMonomial(split3[index]);
                index++;
            }
        }
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void doOperation(Nodo actualNode,ListaEnlazada list, String operating){
        switch(operating){
            case "+":
                if(actualNode != null){
                    if(list.getSize() == 1){
                        outcome += actualNode.getCoefficient()+"x^"+actualNode.getPower();
                    }else{
                        Nodo aux = actualNode.getNext();
                        boolean control = false;
                        while(aux != null){
                            if(actualNode.getPower() == aux.getPower()){
                                int sum = actualNode.getCoefficient() + aux.getCoefficient();
                                outcome += sum+"x^"+actualNode.getPower();
                                if(actualNode.getNext()!=null || aux.getNext()!=null){
                                    outcome += " ";
                                    outcome += "+";
                                    outcome += " ";
                                }
                                control = true;
                                list1.deleteNode(aux);
                            }
                            aux = aux.getNext();
                        }
                        if(!control){
                            outcome += actualNode.getCoefficient()+"x^"+actualNode.getPower();
                            if(actualNode.getNext()!=null){
                                outcome += " ";
                                outcome += "+";
                                outcome += " ";
                            }
                        }
                    }
                    doOperation(actualNode.getNext(),list1,operating);
                }
                break;
                
            case "-":
                if(actualNode != null){
                    if(list.getSize() == 1){
                        outcome += actualNode.getCoefficient()+"x^"+actualNode.getPower();
                    }else{
                        Nodo aux = actualNode.getNext();
                        boolean control = false;
                        while(aux != null){
                            if(actualNode.getPower() == aux.getPower()){
                                int difference = actualNode.getCoefficient() - aux.getCoefficient();
                                outcome += difference+"x^"+actualNode.getPower();
                                if(actualNode.getNext()!= null || aux.getNext()!=null){
                                    outcome += " ";
                                    outcome += "+";
                                    outcome += " ";
                                }
                                control = true;
                                list1.deleteNode(aux);
                            }
                            aux = aux.getNext();
                        }
                        if(!control){
                            outcome += actualNode.getCoefficient()+"x^"+actualNode.getPower();
                            if(actualNode.getNext()!=null){
                                outcome += " ";
                                outcome += "+";
                                outcome += " ";
                            }
                        }
                    }
                    doOperation(actualNode.getNext(),list1,operating);
                }
                break;
                
            case "*":
                if(actualNode != null){
                    if(list.getSize() == 1){
                        int powerSum = actualNode.getPower() + list.getFirst().getPower();
                        int coefficientProduct = actualNode.getCoefficient() * list.getFirst().getCoefficient();
                        outcome += coefficientProduct+"x^"+powerSum;
                        if(actualNode.getNext() != null){
                            outcome += " ";
                            outcome += "+";
                            outcome += " ";
                        }
                    }else{
                        Nodo aux = list.getFirst();
                        while(aux != null){
                            int powerSum = actualNode.getPower() + aux.getPower();
                            int coefficientProduct = actualNode.getCoefficient() * aux.getCoefficient();
                            temporalList.addNode(coefficientProduct, powerSum);
                            aux = aux.getNext();
                        }
                    }
                    doOperation(actualNode.getNext(),list,operating);
                }
                doOperation(temporalList.getFirst(), temporalList, "+");
                break;
        
            case "/":
                Nodo aux = list.getFirst();
                int coefficientDivision = actualNode.getCoefficient() / aux.getCoefficient();
                int powerDiference = actualNode.getPower() - aux.getPower();
                int coefficientResidual = actualNode.getCoefficient() % aux.getCoefficient();
                if(coefficientResidual == 0){
                    outcome += coefficientDivision+"x^"+powerDiference;
                }else{
                    outcome += coefficientDivision+"x^"+powerDiference+"  +  "+coefficientResidual+"/"+aux.getCoefficient()+"x^"+powerDiference;
                }
                break;
        }
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void readManualEquation(){
        String[] split1 = polynomial1.split(" ");
        String[] split2 = polynomial2.split(" ");
        
        if("+".equals(operating) || "-".equals(operating)){
            
            for(int index = 0; index < split1.length; index++){
                if(index > 0 && "-".equals(split1[index-1])){
                    String aux = "-"+split1[index];
                    split1[index] = aux;
                }
                list1.addNodeMonomial(split1[index]);
                index++;
            }
            
            for(int index = 0; index < split2.length; index++){
                if(index > 0 && "-".equals(split2[index-1])){
                    String aux = "-"+split2[index];
                    split2[index] = aux;
                }
                list1.addNodeMonomial(split2[index]);
                index++;
            }
        }else{
            for(int index = 0; index < split1.length; index++){
                if(index > 0 && "-".equals(split1[index-1])){
                    String aux = "-"+split1[index];
                    split1[index] = aux;
                }
                list1.addNodeMonomial(split1[index]);
                index++;
            }
        
            for(int index = 0; index < split2.length; index++){
                if(index > 0 && "-".equals(split2[index-1])){
                    String aux = "-"+split2[index];
                    split2[index] = aux;
                }
                list2.addNodeMonomial(split2[index]);
                index++;
            }
        }
    }
        
        
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean writeOutcome(){
        Escritor writer = new Escritor("Archivos/Resultado.txt");
        boolean control = writer.write(polynomial1+"|"+operating+"|"+polynomial2+"|"+outcome+"\r\n");
        writer.close();
        return control;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ListaEnlazada getList1(){
        return list1;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ListaEnlazada getList2(){
        return list2;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getOperating(){
        return operating;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getOutcome(){
        return outcome;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getPolynomial1(){
        return polynomial1;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getPolynomial2(){
        return polynomial2;
    }
}
