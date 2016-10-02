package Actividad2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
public class GestionContenido extends DefaultHandler{
	
	private String Datos="";
	
	public GestionContenido(){
		super();
		}
	public void RSAX() throws SAXException, IOException, FileNotFoundException {
	//Se crea un objeto procesador de XML
	
			XMLReader procesadorXML=XMLReaderFactory.createXMLReader();
		
			//definimos una clase que extiende de DefaultHandler donde determinamos los
		

			//Utilizamos el método setContentHandler para tratar los eventos que ocurren en
		
			//el documento
		
			procesadorXML.setContentHandler(this);
		
			//Se define el fichero XML que se va a leer
		
			InputSource fileXML=new InputSource("libros.xml");
		
			procesadorXML.parse(fileXML);
	
	}
		public void startDocument(){
		
			//System.out.println("Comienzo de Documento XML");
			Datos+="Comienzo de Documento XML";
		}
		
		public void endDocument(){
		
			//System.out.println("Final del documento XML");
			Datos+="\n Final del documento XML";
		}
		
		public void startElement(String uri, String libros, String libro, Attributes atts){
		
			//System.out.println("\tPrincipio elemento: "+ libros);
			Datos+="\t \n Principio elemento: "+ libros;
		}
		
		public void endElement(String uri, String libro, String libros){
		
			//System.out.println("\tFin Elemento: "+libro);
			Datos+="\t \n Fin Elemento: "+ libro;

		}
		
		public void characters(char[] ch, int inicio, int longitud) throws SAXException{
		
			String car=new String(ch, inicio, longitud);
		
			car= car.replaceAll("[\t\n]","");
		
		}
		
		public String getString(){
			return Datos;
			
		}
		
		
		
}
