package Actividad2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerDOM {

	public LeerDOM(){
		super();
		}
	
	public String Datos="";
	
	public void LeerDOM(){
		
		Actividad2 act2 = new Actividad2();
		
		
		//creamos una instancia de DocumentBuilderFactory para construir el parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try{
		
			DocumentBuilder builder = factory.newDocumentBuilder();
		
			//cargamos el documento con el método parse
		
			Document document = builder.parse(new File("libros.xml"));
		
			document.getDocumentElement().normalize();
		
			
			Datos+="Elemento raiz: "+document.getDocumentElement().getNodeName()+" \n ";
		
			//Obtenemos la lista de nodos con nombre empleado de todo el documento
		
			NodeList libro = document.getElementsByTagName("libro");	
			
			for (int j = 0; j < libro.getLength(); j++) {
				
		
				Node libros = libro.item(j); //Obtener un nodo
		
				
				if(libros.getNodeType()==Node.ELEMENT_NODE){ //tipo de nodo
		
					//Obtenemos los elementos del nodo
		
					Element elemento =(Element) libros;
					
			
					Datos+="Libros"+j+"\n"+"========"+"\n Título: " +getNodo("titulo", elemento)+"\n Autor: " +getNodo("autor", elemento)+"\n Año:"+getNodo("anyo", elemento)+"\n Editorial: "+getNodo("editorial", elemento)+"\n"+"\n";
				
				}
			}
			
			}catch(Exception e){ e.printStackTrace();}
			
		}
			
		
		//obtener la información de un nodo
		
		private static String getNodo(String etiqueta, Element elem){
		
			NodeList nodo =	elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		
			Node valornodo=(Node) nodo.item(0);
		
			return valornodo.getNodeValue(); //devuelve el valor del nodo
		}
		
		
		public String getString(){
			return Datos;
			
		}
		
		
		}


