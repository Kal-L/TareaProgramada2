
/**
 * Write a description of class ListaEnlazada here.
 *
 * @author Alejandro Araya - B80549
 * @version 18/11/2020
 */
public class ListaEnlazada
{
    private int size;
    private Nodo first;

    /**
     * Constructor for objects of class ListaEnlazada
     */
    public ListaEnlazada()
    {
        first = null;
        size = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setFirst(Nodo referenceFirst){
        first = referenceFirst;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getSize(){
        return size;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Nodo getFirst(){
        return first;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addNodeMonomial(String monomial){
        Nodo newNode = new Nodo();
        String[] split1 = monomial.split("x");
        int coefficient = Integer.parseInt(split1[0]);
        String[] split2 = split1[1].split("");
        int power = Integer.parseInt(split2[1]);
        
        newNode.setCoefficient(coefficient);
        newNode.setPower(power);
        
        if(first == null){
            first = newNode;
        }else{
            Nodo aux = first;
            
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            
            aux.setNext(newNode);
        }
        
        size++;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void resetList(){
        first = null;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addNode(int coefficient, int power){
        Nodo newNode = new Nodo();
        newNode.setCoefficient(coefficient);
        newNode.setPower(power);
        
        if(first == null){
            first = newNode;
        }else{
            Nodo aux = first;
            
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            
            aux.setNext(newNode);
        }
        
        size++;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void deleteNode(Nodo node){
            Nodo aux = first;
            
            if(aux == node){
                first = first.getNext();
                aux.setNext(null);
            }else{
                while(aux.getNext() != node){
                    aux = aux.getNext();
                }
                
                Nodo nextNode = aux.getNext().getNext();
                aux.getNext().setNext(null);
                aux.setNext(nextNode);
            }
            
            size--;
    }
}
