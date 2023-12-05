
package practica.pkg1.pkg5.ad;

import java.io.File;
//Declaro la clase pública UsaAccesoXMLSAX
public class UsaAccesoXMLSAX { 
    public static void main(String[] args) {
        //Creo un objeto File para el archivo XML llamado "Books.xml"
        File f = new File("Books.xml"); 
        //Creo una instancia de la clase AccesoXMLSAX
        AccesoXMLSAX a = new AccesoXMLSAX(); 

        try {
            //Parseo el archivo XML usando el método parsearXMLconLibrosSAXhandler
            a.parsearXMLconLibrosSAXhandler(f); 
        } catch (Exception e) {
            //Excepcion que no hace nada
        }
    }
}
