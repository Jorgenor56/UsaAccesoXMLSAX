
package practica.pkg1.pkg5.ad;

import java.io.File;

public class UsaAccesoXMLSAX {
    public static void main(String[] args) {
        File f = new File("Libros.xml");
        AccesoXMLSAX a = new AccesoXMLSAX();
        try {
            a.parsearXMLconLibrosSAXhandler(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





