package practica.pkg1.pkg5.ad;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class LibrosSAXhandler extends DefaultHandler {
    private int contadorLibros = 0;
    private boolean dentroDeLibro = false;
    private String etiquetaActual = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        etiquetaActual = qName;
        switch (qName) {
            case "book" -> {
                dentroDeLibro = true;
                contadorLibros++;
                System.out.println("Libro nº " + contadorLibros);
            }
            default -> {
                System.out.print("\n" + etiquetaActual + ": ");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            dentroDeLibro = false;
            System.out.println("\n-----------------------");
        }
        etiquetaActual = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length).trim();
        car = car.replaceAll("\t", ""); // quita todos los tabuladores
        car = car.replaceAll("\n", "");
        if (!car.isEmpty() && dentroDeLibro) {
            System.out.print(car);
        }
    }
}



