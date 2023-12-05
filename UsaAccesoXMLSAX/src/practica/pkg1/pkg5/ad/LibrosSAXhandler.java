package practica.pkg1.pkg5.ad;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
//Extiende DefaultHandler, una clase base para manejar eventos SAX
public class LibrosSAXhandler extends DefaultHandler {
    //Contador para el número de libros
    private int contadorLibros = 0;
    //Booleano para saber si se está actualmente procesando un libro
    private boolean dentroDeLibro = false;
    //Almacena la etiqueta XML actual
    private String etiquetaActual = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        //Asigno el nombre de la etiqueta actual (qName) a etiquetaActual
        etiquetaActual = qName; 
        //Inicio un switch basado en el nombre de la etiqueta
        switch (qName) { 
            //En caso de que la etiqueta sea "book"
            case "book" -> { 
                //Establece que estamos dentro de un elemento libro
                dentroDeLibro = true; 
                //Incrementa el contador de libros
                contadorLibros++; 
                //Imprime el número del libro actual
                System.out.println("Libro nº " + contadorLibros);
            }
            default -> { //Para cualquier otra etiqueta
                System.out.print("\n" + etiquetaActual + ": "); //Imprime el nombre de la etiqueta
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Un if con codicion que la etiqueta que finaliza es book
        if (qName.equals("book")) { 
            //Indica que ya no estamos dentro de un libro
            dentroDeLibro = false; 
            //Imprime una línea de separación
            System.out.println("\n-----------------------"); 
        }
        etiquetaActual = ""; //Deja en blanco la etiqueta actual
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //Extrae y limpia el texto dentro de la etiqueta actual
        String car = new String(ch, start, length).trim(); 
        //Elimino los tabuladores del texto
        car = car.replaceAll("\t", ""); 
        //Elimino los saltos de línea del texto
        car = car.replaceAll("\n", ""); 
        //Si hay texto y estamos dentro de un libro
        if (!car.isEmpty() && dentroDeLibro) { 
            System.out.print(car); //Imprime el texto
        }
    }
}
