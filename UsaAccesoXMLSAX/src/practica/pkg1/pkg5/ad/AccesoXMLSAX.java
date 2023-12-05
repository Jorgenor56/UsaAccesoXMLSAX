package practica.pkg1.pkg5.ad;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File; 
import java.io.IOException; 
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class AccesoXMLSAX { 
    //Declaro una variable privada de tipo SAXParser
    private SAXParser parser;

    //Método que parsee un archivo XML usando un SAX handler
    public int parsearXMLconLibrosSAXhandler(File f) {
        try {
            //Creo una nueva instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //Creo un nuevo SAXParser
            parser = factory.newSAXParser();
            //Crea una instancia de LibrosSAXhandler
            LibrosSAXhandler sh = new LibrosSAXhandler();
            //Parseo el archivo XML usando el handler sh
            parser.parse(f, sh);
            return 0; //Retorno 0
        } catch (IOException e) {
            //Manejo las excepciones de entrada y salida
            System.err.println("Error de E/S: " + e.getMessage());
            return -1; //Retorna -1 si hay error
        } catch (ParserConfigurationException e) {
            //Manejo las excepciones de configuración del parser
            System.err.println("Error de configuración del parser: " + e.getMessage());
            return -1; //Retorna -1 si hay error
        } catch (SAXException e) {
            //Manejo las excepciones relacionadas con SAX
            System.err.println("Error SAX: " + e.getMessage());
            return -1; //Retorna -1 si hay error
        }
    }
}
