package practica.pkg1.pkg5.ad;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class LibrosSAXhandler extends DefaultHandler {
    private int contadorLibros = 0;
    private boolean dentroDeLibro = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        switch (qName) {
            case "Libro" -> {
                dentroDeLibro = true;
                contadorLibros++;
                System.out.println("Libro nº " + contadorLibros);
                System.out.println("Publicado en: " + atts.getValue(atts.getQName(0)));
            }
            case "Titulo" -> System.out.print("\nEl título es: ");
            case "Autor" -> System.out.print("\nEl autor es: ");
            default -> {
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Libro")) {
            dentroDeLibro = false;
            System.out.println("\n-----------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("\t", ""); // quita todos los tabuladores
        car = car.replaceAll("\n", "");
        if (dentroDeLibro) {
            System.out.print(car);
        }
    }
}



