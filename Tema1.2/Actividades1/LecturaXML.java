package Actividades1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args){
		//creamos una instancia de DocumentBuilderFactory para construir el parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
		DocumentBuilder builder = factory.newDocumentBuilder();
		//cargamos el documento con el método parse
		Document document = builder.parse(new File("Coches.xml"));
		document.getDocumentElement().normalize();
	
		System.out.println("Elemento raiz: "+document.getDocumentElement().getNodeName());
				//Obtenemos la lista de nodos con nombre empleado de todo el documento
				NodeList coches = document.getElementsByTagName("Coches");
				for(int i=0; i<coches.getLength(); i++){
				Node emple = coches.item(i); //Obtener un nodo
				if(emple.getNodeType()==Node.ELEMENT_NODE){ //tipo de nodo
				//Obtenemos los elementos del nodo
				Element elemento =(Element) emple;
				System.out.println("Código Coche: " + getNodo("codigo", elemento));
				System.out.println("Marca: " +getNodo("marca", elemento));
				System.out.println("Modelo:"+getNodo("modelo", elemento));
				System.out.println("Matricula: " + getNodo("matricula: ", elemento));
				System.out.println("Potencia: " + getNodo("potencia: ", elemento));
				System.out.println("Plazas: " + getNodo("plazas: ", elemento));
				System.out.println("NumPuertas: " + getNodo("numpuertas: ", elemento));
				}
				
				}
				
		}catch(Exception e){ e.printStackTrace();}
				
		}
				//obtener la información de un nodo
				private static String getNodo(String etiqueta, Element elem){
				NodeList nodo =elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
				Node valornodo=(Node) nodo.item(0);
				return valornodo.getNodeValue(); //devuelve el valor del nodo
				
				}
				
		}
	
