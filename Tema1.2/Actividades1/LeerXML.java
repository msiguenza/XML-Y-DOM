package Actividades1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Actividad4.Actividad4;

public class LeerXML extends JFrame {

//DECLARACIÓN DE VARIABLES
public JPanel contentPane;
public JButton btnTransformarXML;

String path="";
File f;



JScrollPane scrollPane;
TextArea textArea;

JMenuBar menuBar;
JMenu mnArchivo;
JMenuItem mntmSalir;
JLabel labelfondo;



public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				
				LeerXML frame = new LeerXML();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * 
 */
 //Constructor
public LeerXML() {
	setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\estrellaoro.png")); //IMAGEN DEL ICONO DE LA APLICACIÓN
	
	
	
	setTitle("Manejo de Archivos");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 461,  694);
	
	menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	mnArchivo = new JMenu("Archivo");
	menuBar.add(mnArchivo);
	//DECLARACIÓN DE LA CLASE JFILECHOOSER.

	
	mntmSalir = new JMenuItem("Salir");
	mntmSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Salir(); //LLAMADA AL METODO Salir, EJECUTANDO LA ACCIÓN DE SALIDA DE LA APLICACIÓN
			
			
		}
	});
	mnArchivo.add(mntmSalir);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	btnTransformarXML = new JButton("Leer XML");
	btnTransformarXML.setIcon(new ImageIcon("src\\images\\Notas.png"));
	btnTransformarXML.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a) {
			
			LeerXML();
		
			
			
		}
	});
	btnTransformarXML.setBounds(139, 89, 174, 45);
	contentPane.add(btnTransformarXML);
	
	scrollPane = new JScrollPane();
	scrollPane.setBounds(12, 328, 423, 244);
	contentPane.add(scrollPane);
	
	textArea = new TextArea();
	textArea.setBounds(12, 328, 423, 244);
	contentPane.add(textArea);
	textArea.setEnabled(false);
	textArea.setEditable(false);
	
	labelfondo = new JLabel("");
	labelfondo.setIcon(new ImageIcon("src\\images\\fondito.png")); //IMAGEN DE FONDO DE LA APLICACIÓN
	labelfondo.setBounds(0, 0, 445, 635);
	contentPane.add(labelfondo);
}


	public void Salir(){
	
	JOptionPane.showMessageDialog(null, "Va a salir de la aplicación, gracias por utilizar nuestro servicio","¡Hasta Pronto!",JOptionPane.WARNING_MESSAGE);

	System.exit(0); //CIERRA LA APLICACIÓN
	}


	public void LeerXML(){
	
		  try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(new File("C://Articulos.xml"));
			  doc.getDocumentElement().normalize();

			 textArea.append("El elemento raíz es: " + doc.getDocumentElement().getNodeName());
			  NodeList listaPersonas = doc.getElementsByTagName("DatosArticulos");

			  for (int i = 0; i < listaPersonas.getLength(); i ++) {

			    Node persona = listaPersonas.item(i);

			    if (persona.getNodeType() == Node.ELEMENT_NODE) {

		            Element elemento = (Element) persona;

		            System.out.println("Titulo : " + elemento.getElementsByTagName("titulo").item(0).getTextContent());

		           // textArea.append(" DatosArticulos: " + getTagValue("DatosArticulos", elemento));

			    }
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }

		
		  
		 
		  
	}
	
	 public  String getTagValue(String sTag, Element eElement){
	 	  NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 	  Node valor = (Node) nlList.item(0);

	 	  return valor.getNodeValue();

	  }
	

	}
