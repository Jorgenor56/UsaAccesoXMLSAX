
package practica.pkg1.pkg5.ad;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class AccesoXMLSAX {
    private SAXParser parser;

    public int parsearXMLconLibrosSAXhandler(File f) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            LibrosSAXhandler sh = new LibrosSAXhandler();
            parser.parse(f, sh);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}



