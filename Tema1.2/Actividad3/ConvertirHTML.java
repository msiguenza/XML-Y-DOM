package Actividad3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JMenu;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.awt.Toolkit;

public class ConvertirHTML extends JFrame  implements Serializable{

	 //DECLARACIÓN DE VARIABLES
	 public JPanel contentPane;
	 
	 public JButton btnMostrar;
	 
	 String path="";
	 File f;
	 
	 javax.swing.JFileChooser j= new javax.swing.JFileChooser(); 
	 JFileChooser filechooser;
	 
	 JMenuBar menuBar;
	 JMenu mnArchivo;
	 JMenuItem mntmCargarXML;
	 JMenuItem mntmSalir;
	 JLabel labelfondo;
	 private JMenuItem menuCargarXSL;
	 
	 Source xslDoc;
	 Source xmlDoc;
	 
	    //MAIN PRINCIPAL PARA ARRANCAR LA APLICACIÓN
	 public static void main(String[] args) {
	  EventQueue.invokeLater(new Runnable() {
	   public void run() {
	    try {
	    	JOptionPane.showMessageDialog(null, "Debe cargar un xml correspondiente a xsl y viceversa \n si no la aplicación no realizará correctamente \n el archivo HTML \n No puede almacenar los ficheros en el directorio raíz","¡AVISO!",JOptionPane.WARNING_MESSAGE);
	     ConvertirHTML frame = new ConvertirHTML();
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
	 public ConvertirHTML() {
	  setIconImage(Toolkit.getDefaultToolkit().getImage("Tema1.2\\images\\estrellaoro.png")); //IMAGEN DEL ICONO DE LA APLICACIÓN
	  
	  
	  
	  setTitle("Manejo de Archivos");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setBounds(100, 100, 352,  371);
	  
	  menuBar = new JMenuBar();
	  setJMenuBar(menuBar);
	  
	  mnArchivo = new JMenu("Archivo");
	  menuBar.add(mnArchivo);
	  
	  mntmCargarXML = new JMenuItem("Cargar XML");
	  mntmCargarXML.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
	    
	    try {
	     CargarXML(); //LLAMADA AL METODO Abrir QUE SELECCIONA EL ARCHIVO EN EL DIRECTORIO DESEADO
	        //PARA SU POSTERIOR LECTURA Y CARGA DE FICHERO.
	    } catch (ClassNotFoundException e) {
	     
	     e.printStackTrace();
	    } catch (IOException e) {
	     
	     e.printStackTrace();
	    }
	    
	   }
	  });
	  
	  
	  
	  mnArchivo.add(mntmCargarXML);
	  //DECLARACIÓN DE LA CLASE JFILECHOOSER.
	  filechooser=new JFileChooser();
	  
	  mntmSalir = new JMenuItem("Salir");
	  mntmSalir.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
	    
	    Salir(); //LLAMADA AL METODO Salir, EJECUTANDO LA ACCIÓN DE SALIDA DE LA APLICACIÓN
	    
	    
	   }
	  });
	  
	  menuCargarXSL = new JMenuItem("Cargar XSL");
	  mnArchivo.add(menuCargarXSL);
	  mnArchivo.add(mntmSalir);
	  contentPane = new JPanel();
	  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	  setContentPane(contentPane);
	  contentPane.setLayout(null);
	  menuCargarXSL.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
	    
	    try {
	     CargarXSL(); //LLAMADA AL METODO XSL PARA CARGAR EL ARCHIVO
	    } catch (ClassNotFoundException e) {
	     
	     e.printStackTrace();
	    } catch (IOException e) {
	     
	     e.printStackTrace();
	    }
	    
	   }
	  });
	  
	  
	  
	  btnMostrar = new JButton("Generar Archivo HTML");
	  btnMostrar.setIcon(new ImageIcon("Tema1.2\\images\\notes.png"));
	  btnMostrar.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    
	       GenerarHTML();
	   }
	  });

	   
	  btnMostrar.setBounds(55, 137, 224, 45);
	  contentPane.add(btnMostrar);
	  
	  labelfondo = new JLabel("");
	  labelfondo.setIcon(new ImageIcon("Tema1.2\\images\\fondoabstracto.jpg")); //IMAGEN DE FONDO DE LA APLICACIÓN
	  labelfondo.setBounds(0, 0, 336, 312);
	  contentPane.add(labelfondo);
	 }
	 
	 //METODOS ---------------------------------------------------------------------------------------------------------------------
	 

	 
	 public  void CargarXML() throws IOException, ClassNotFoundException{
	  
	  
	     // Método que abre un fichero ya creado y muestra los datos de este en
	     // el textArea
	     try {
	      j.showOpenDialog(j);
	      // Recoge la ruta del fichero
	      
	      path = j.getSelectedFile().getAbsolutePath();
	      // Solo admite ficheros de los 2 tipos siguientes
	      if (path.endsWith("xml")) {
	              
	       JOptionPane.showMessageDialog(null, "Carga de archivo XML con éxito","¡GREAT!",JOptionPane.WARNING_MESSAGE);

	       
	       xmlDoc = new StreamSource(path);
	      
	      } else {
	      
	       JOptionPane.showMessageDialog(null, "Solo se pueden cargar archivos de extensión XML");

	      }
	      } catch (Exception e) {

	     }

	    }
	 
	 
	 public  void CargarXSL() throws IOException, ClassNotFoundException{
	  
	    // Método que abre un fichero ya creado y muestra los datos de este en
	    // el textArea
	    try {
	     j.showOpenDialog(j);
	     // Recoge la ruta del fichero
	     
	     path = j.getSelectedFile().getAbsolutePath();
	     // Solo admite ficheros de los 2 tipos siguientes
	     if (path.endsWith("xsl")) {
	             
	      JOptionPane.showMessageDialog(null, "Carga de archivo XSL con éxito","¡GREAT!",JOptionPane.WARNING_MESSAGE);

	      
	      xslDoc = new StreamSource(path);
	     
	     } else {
	     
	      JOptionPane.showMessageDialog(null, "Solo se pueden cargar archivos de extensión XSL");

	     }
	     
	     } catch (Exception e) {

	    }

	   }
	 
	 public  void GenerarHTML() {
	  
	     try {
	       TransformerFactory tFactory = TransformerFactory.newInstance();

	       String outputFileName = "C:/actividad3.html";
	       OutputStream htmlFile = new FileOutputStream(outputFileName);

	       Transformer transformer = tFactory.newTransformer(xslDoc);
	       transformer.transform(xmlDoc, new StreamResult(htmlFile));
	       
	       JOptionPane.showMessageDialog(null, "Documento HTML generado con éxito por defecto en C:/");

	       
	      } catch (Exception e) {
	       e.printStackTrace();
	       JOptionPane.showMessageDialog(null, "Debe primero elegir los archivos xsl y xml");
	      }
	     
	    }
	  
	  
	  
	 
	 public void Salir(){
	  
	  JOptionPane.showMessageDialog(null, "Va a salir de la aplicación, gracias por utilizar nuestro servicio","¡Hasta Pronto!",JOptionPane.WARNING_MESSAGE);

	  System.exit(0); //CIERRA LA APLICACIÓN
	 }
	 
	 public void Mostrar(){
	  
	 }
	}
