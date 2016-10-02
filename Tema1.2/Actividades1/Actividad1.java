package Actividades1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.io.EOFException;
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
import java.io.RandomAccessFile;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;

import PROYECTO1.Contactos;
import java.awt.Toolkit;

	public class Actividad1 extends JFrame {

		//DECLARACIÓN DE VARIABLES
		public JPanel contentPane;
		
		public JButton btnLeerDat;
		public JButton btnTransformarXML;
		
		String path="";
		File f;
		
		
		
		JScrollPane scrollPane;
		TextArea textArea;
		
		JMenuBar menuBar;
		JMenu mnArchivo;
		JMenuItem mntmSalir;
		JLabel labelfondo;
		
		
		public JLabel lblMarca;
		public JLabel labelModelo;
		public JLabel lblMatricula;
		public JLabel labelPotencia;
		public JTextField textFieldMarca;
		public JTextField textFieldModelo;
		public JTextField textFieldMatricula;
		public JTextField textFieldPotencia;
		public JTextField textFieldPlazas;
		public JTextField textFieldNumPuertas;
		 
		JButton buttonAgregar;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						Actividad1 frame = new Actividad1();
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
		public Actividad1() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\estrellaoro.png")); //IMAGEN DEL ICONO DE LA APLICACIÓN
			
			
			
			setTitle("Manejo de Archivos");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550,  822);
			
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
			
			btnTransformarXML = new JButton("Escribir a XML");
			btnTransformarXML.setIcon(new ImageIcon("src\\images\\Notas.png"));
			btnTransformarXML.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					
					try {
						CrearXML();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerFactoryConfigurationError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			btnTransformarXML.setBounds(33, 395, 174, 45);
			contentPane.add(btnTransformarXML);
			
			btnLeerDat = new JButton("Leer el Fichero .DAT");
			btnLeerDat.setIcon(new ImageIcon("src\\images\\notes.png"));
			btnLeerDat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						LeerFichero();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			});

				
			btnLeerDat.setBounds(276, 395, 195, 45);
			contentPane.add(btnLeerDat);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 478, 512, 234);
			contentPane.add(scrollPane);
			
			textArea = new TextArea();
			textArea.setEnabled(false);
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			
			JLabel lblEligeUnaOpcin = new JLabel("Elige una opci\u00F3n :");
			lblEligeUnaOpcin.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 14));
			lblEligeUnaOpcin.setBounds(10, 24, 180, 14);
			contentPane.add(lblEligeUnaOpcin);
			
			lblMarca = new JLabel("Marca :");
			lblMarca.setBounds(21, 80, 58, 14);
			contentPane.add(lblMarca);
			
			labelModelo = new JLabel("Modelo :");
			labelModelo.setBounds(21, 126, 81, 14);
			contentPane.add(labelModelo);
			
			lblMatricula = new JLabel("Matricula :");
			lblMatricula.setBounds(21, 173, 81, 14);
			contentPane.add(lblMatricula);
			
			labelPotencia = new JLabel("Potencia :");
			labelPotencia.setBounds(21, 215, 58, 14);
			contentPane.add(labelPotencia);
			
			JLabel labelPlazas = new JLabel("Plazas :");
			labelPlazas.setBounds(21, 259, 58, 14);
			contentPane.add(labelPlazas);
			
			JLabel lblNumPuertas = new JLabel("Num Puertas :");
			lblNumPuertas.setBounds(21, 301, 99, 14);
			contentPane.add(lblNumPuertas);
			
			textFieldMarca = new JTextField();
			textFieldMarca.setBounds(106, 77, 215, 20);
			contentPane.add(textFieldMarca);
			textFieldMarca.setColumns(10);
			
			textFieldModelo = new JTextField();
			textFieldModelo.setColumns(10);
			textFieldModelo.setBounds(106, 123, 215, 20);
			contentPane.add(textFieldModelo);
			
			textFieldMatricula = new JTextField();
			textFieldMatricula.setColumns(10);
			textFieldMatricula.setBounds(106, 170, 215, 20);
			contentPane.add(textFieldMatricula);
			
			textFieldPotencia = new JTextField();
			textFieldPotencia.setColumns(10);
			textFieldPotencia.setBounds(106, 212, 215, 20);
			contentPane.add(textFieldPotencia);
			
			buttonAgregar = new JButton("Escribir Generar DAT");
			buttonAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						EscribirFichero();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
			});
			
			textFieldPlazas = new JTextField();
			textFieldPlazas.setBounds(106, 256, 215, 20);
			contentPane.add(textFieldPlazas);
			textFieldPlazas.setColumns(10);
			
			textFieldNumPuertas = new JTextField();
			textFieldNumPuertas.setColumns(10);
			textFieldNumPuertas.setBounds(106, 298, 215, 20);
			contentPane.add(textFieldNumPuertas);
			buttonAgregar.setBounds(340, 134, 174, 45);
			contentPane.add(buttonAgregar);
			
			labelfondo = new JLabel("");
			labelfondo.setIcon(new ImageIcon("src\\images\\fondito.png")); //IMAGEN DE FONDO DE LA APLICACIÓN
			labelfondo.setBounds(0, 0, 534, 763);
			contentPane.add(labelfondo);
		}
		
		//METODOS ---------------------------------------------------------------------------------------------------------------------
		
		public void EscribirFichero() throws IOException{
		
			File fichero=new File("C://AleatorioCoche.dat");
			RandomAccessFile file= new RandomAccessFile(fichero, "rw");
			
			String Marca[ ]={textFieldMarca.getText()};
			
			String Modelo[]={textFieldModelo.getText()};
			
			String Matricula[ ]={textFieldMatricula.getText()};
			
			String Potencia[ ]={textFieldPotencia.getText()};
			
			String Plazas[ ]={textFieldPlazas.getText()};
			
			String NumPuertas[ ]={textFieldNumPuertas.getText()};
			
			StringBuffer buffer=null;
			
			int n=Marca.length;
			
			for(int i=0; i<n; i++){
			
				file.writeInt(i+1);
			
				buffer= new StringBuffer(Marca[i]);
			
				buffer.setLength(10);
			
				file.writeChars(buffer.toString());
				//----
				
				buffer= new StringBuffer(Modelo[i]);
				
				buffer.setLength(10);
			
				file.writeChars(Modelo[i]);
				//---

				buffer= new StringBuffer(Matricula[i]);
				
				buffer.setLength(10);
			
				file.writeChars(Matricula[i]);
				
				// ---
				
				buffer= new StringBuffer(Potencia[i]);
				
				buffer.setLength(10);
			
				file.writeChars(Potencia[i]);
				//-----------
				buffer= new StringBuffer(Plazas[i]);
				
				buffer.setLength(10);
			
				file.writeChars(Plazas[i]);
				// ---
				buffer= new StringBuffer(NumPuertas[i]);
				
				buffer.setLength(10);
			
				file.writeChars(NumPuertas[i]);

			}
			
			file.close();
		
			
			JOptionPane.showMessageDialog(null, "Fichero .DAT generado con éxito","¡EXITO!",JOptionPane.WARNING_MESSAGE);

			
		}
		
		
		public void LeerFichero() throws IOException{
			
			File fichero= new File("C:\\AleatorioCoche.dat");
			RandomAccessFile file=new RandomAccessFile(fichero, "r");
			int codigo, posicion=0;
			char Matricula[]= new char[10];
			char Marca[ ]= new char[10], aux;
			char Modelo[ ]= new char[10];
			char Potencia []=new char[10];
			char Plazas []=new char[10];
			char NumPuertas[]=new char[10];
			for(;;){
		
				file.seek(posicion);
				codigo=file.readInt();
				
				for(int i=0; i< Marca.length; i++){
				aux=file.readChar();
				Marca[i]=aux;
				}
				String marca=new String(Marca);
				
				for(int i=0; i< Modelo.length; i++){
					aux=file.readChar();
					Modelo[i]=aux;
				}
				String modelo=new String(Modelo);
				
				
				for(int i=0; i< Potencia.length; i++){
					aux=file.readChar();
					Potencia[i]=aux;
					}
					String potencia=new String(Potencia);
				
				for(int i=0; i< Matricula.length; i++){
						aux=file.readChar();
						Matricula[i]=aux;
						}
						String matricula=new String(Matricula);	
					
				for(int i=0; i< Plazas.length; i++){
						aux=file.readChar();
						Plazas[i]=aux;
					}
					String plazas=new String(Plazas);
					
				for(int i=0; i< NumPuertas.length; i++){
						aux=file.readChar();
						NumPuertas[i]=aux;
						}
						String numpuertas=new String(NumPuertas);
						
						
				
				textArea.appendText("\n Código Coche: "+codigo+"\n , Marca: "+marca+"\n, Modelo: "+modelo+" \n ,Matricula:"+matricula+ "\n ,Potencia: "+ potencia+"\n , Plazas:"+plazas+"\n ,Numero de Puertas: "+numpuertas);
				posicion=posicion+36;
				
				if(file.getFilePointer()==file.length()) break;
					}
				
					file.close();
			
			
		}
		
		
		public void CrearXML() throws IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
			
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
			
		public void Salir(){
			
			JOptionPane.showMessageDialog(null, "Va a salir de la aplicación, gracias por utilizar nuestro servicio","¡Hasta Pronto!",JOptionPane.WARNING_MESSAGE);

			System.exit(0); //CIERRA LA APLICACIÓN
		}
	}
		

