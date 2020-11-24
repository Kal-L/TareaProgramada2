
/**
 * Write a description of class Main here.
 *
 * @author Alejandro Araya - B80549
 * @version 22/11/2020
 */
public class Main
{
    public static void main (String[] args){
        Modelo modelo = new Modelo();
        Interfaz interfaz = new Interfaz();
        Controlador controlador = new Controlador(modelo, interfaz);
        controlador.startCalculator();
    }
}
