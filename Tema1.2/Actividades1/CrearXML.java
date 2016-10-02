package Actividades1;

import java.io.*;

import Actividades1.Actividad1.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXML {

	
	public static void main (String[] args) throws IOException, TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException{
		File fichero= new File("C://AleatorioCoche.dat");
		
		RandomAccessFile file=new RandomAccessFile(fichero, "r");
		
		int codigo;
		
		char Matricula[] = new char[10],aux;
		
		char Potencia[]= new char[10],aux1;
		
		char Plazas[]= new char[10],aux2;
		
		char NumPuertas[] =new char[10],aux3;
		
		int posicion=0;
		
		char Marca[]=new char[10],aux4;
		
		char Modelo[]=new char[10],aux5;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//try{
		
			DocumentBuilder builder=factory.newDocumentBuilder();
		
		DOMImplementation implementation = builder.getDOMImplementation();
		
		Document document = implementation.createDocument(null, "Coches", null);
		
		document.setXmlVersion("1.0");
		
		for(;;){
		
			file.seek(posicion);
		
		codigo=file.readInt();
		
		for(int i=0; i<Marca.length; i++){
		
			aux=file.readChar();
		
		Marca[i]=aux;
		
		}
		
		String marca=new String(Marca);
		
		
		
		for(int i=0; i<Modelo.length; i++){
		
			aux1=file.readChar();
		
		Modelo[i]=aux1;
		
		}
		
		String modelo =new String(Modelo);
		
		for(int i=0; i<Matricula.length; i++){
			
			aux2=file.readChar();
		
		Matricula[i]=aux2;
		
		}
		
		String matricula =new String(Matricula);
		
		for(int i=0; i<Potencia.length; i++){
			
			aux3=file.readChar();
		
		Potencia[i]=aux3;
		
		}
		
		String potencia =new String(Potencia);
		
		for(int i=0; i<Plazas.length; i++){
			
			aux4=file.readChar();
		
		Plazas[i]=aux4;
		
		}
		
		String plazas =new String(Plazas);
		
		for(int i=0; i<NumPuertas.length; i++){
			
			aux5=file.readChar();
		
		NumPuertas[i]=aux5;
		
		}
		
		String numpuertas =new String(NumPuertas);
		
		
		
		if(codigo>0){
			
		Element raiz=document.createElement("coches");
		
		document.getDocumentElement().appendChild(raiz);
		
		CrearElemento("codigo", Integer.toString(codigo), raiz, document);
		
		CrearElemento("Marca", marca.trim(), raiz, document);
		
		CrearElemento("Modelo",modelo.trim(), raiz, document);
		
		CrearElemento("Matricula", matricula.trim(), raiz, document);
		CrearElemento("Potencia", potencia.trim(), raiz, document);
		CrearElemento("Plazas", plazas.trim(), raiz, document);
	//	CrearElemento("NumPuertas", numpuertas.trim(), raiz, document);
		}
	
		posicion=posicion+36;
		
		if(file.getFilePointer()==file.length()) break;
		}
		
		
		Source source=new DOMSource(document);
		
		StreamResult result=new StreamResult(new	java.io.File("Coches.xml"));
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		
		transformer.transform(source, result);
		
	//	}catch(Exception e){ System.err.println("Error: "+e);}
		
		file.close();
		
	}
		static void CrearElemento(String datoEmple, String valor, Element raiz,Document document){
		
			Element elem = document.createElement(datoEmple);
		
			Text text = document.createTextNode(valor);
		
			raiz.appendChild(elem);
		
			elem.appendChild(text);
		
		}
		
}

