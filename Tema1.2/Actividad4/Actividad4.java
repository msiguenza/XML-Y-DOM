package Actividad4;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.thoughtworks.xstream.XStream;
import java.awt.Toolkit;

	public class Actividad4 extends JFrame {

		//DECLARACIÓN DE VARIABLES
		public JPanel contentPane;
		
		public JButton btnLeerDat;
		public JButton btnTransformarXML;
		
		File f;
		
		ArrayList<articulo> lista = new ArrayList<articulo>();
		
		JScrollPane scrollPane;
		TextArea textArea;
		
		JMenuBar menuBar;
		JMenu mnArchivo;
		JMenuItem mntmSalir;
		JLabel labelfondo;
		
		
		public JLabel lblTitulo;
		public JLabel labeldescripcion;
		public JLabel lblTextoTexto;
		public JLabel labelImagen;
		public JTextField textFieldTitulo;
		public JTextField textFieldDescripcion;
		public JTextField textFieldTexto;
		public JTextField textFieldImagen;
		public JButton buttonAgregar; 
	   
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						Actividad4 frame = new Actividad4();
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
		public Actividad4() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("Tema1.2\\images\\estrellaoro.png")); //IMAGEN DEL ICONO DE LA APLICACIÓN
			
			
			
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
			btnTransformarXML.setIcon(new ImageIcon("Tema1.2\\images\\Notas.png"));
			btnTransformarXML.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					
					EscribirArticulo EscrArt= new EscribirArticulo();
					
					try {
					
						EscrArt.EscribirArticuloXML();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			btnTransformarXML.setBounds(33, 353, 174, 45);
			contentPane.add(btnTransformarXML);
			
			btnLeerDat = new JButton("Leer el Fichero .DAT");
			btnLeerDat.setIcon(new ImageIcon("Tema1.2\\images\\notes.png"));
			btnLeerDat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						LeerFichObj();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			});

				
			btnLeerDat.setBounds(276, 353, 195, 45);
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
			
			lblTitulo = new JLabel("Titulo :");
			lblTitulo.setBounds(21, 80, 58, 14);
			contentPane.add(lblTitulo);
			
			labeldescripcion = new JLabel("Descripci\u00F3n :");
			labeldescripcion.setBounds(21, 138, 81, 14);
			contentPane.add(labeldescripcion);
			
			lblTextoTexto = new JLabel("Texto :");
			lblTextoTexto.setBounds(21, 202, 81, 14);
			contentPane.add(lblTextoTexto);
			
			labelImagen = new JLabel("Imagen :");
			labelImagen.setBounds(21, 259, 58, 14);
			contentPane.add(labelImagen);
			
			textFieldTitulo = new JTextField();
			textFieldTitulo.setBounds(106, 77, 215, 20);
			contentPane.add(textFieldTitulo);
			textFieldTitulo.setColumns(10);
			
			textFieldDescripcion = new JTextField();
			textFieldDescripcion.setColumns(10);
			textFieldDescripcion.setBounds(106, 135, 215, 20);
			contentPane.add(textFieldDescripcion);
			
			textFieldTexto = new JTextField();
			textFieldTexto.setColumns(10);
			textFieldTexto.setBounds(106, 199, 215, 20);
			contentPane.add(textFieldTexto);
			
			textFieldImagen = new JTextField();
			textFieldImagen.setColumns(10);
			textFieldImagen.setBounds(106, 256, 215, 20);
			contentPane.add(textFieldImagen);
			
			buttonAgregar = new JButton("Escribir Generar DAT");
			buttonAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					try {
						EscribObjFich();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
			});
			buttonAgregar.setBounds(340, 134, 174, 45);
			contentPane.add(buttonAgregar);
			
			labelfondo = new JLabel("");
			labelfondo.setIcon(new ImageIcon("Tema1.2\\images\\fondito.png")); //IMAGEN DE FONDO DE LA APLICACIÓN
			labelfondo.setBounds(0, 0, 534, 763);
			contentPane.add(labelfondo);
		}
		
		//METODOS ---------------------------------------------------------------------------------------------------------------------
		
		
		
		 public void EscribObjFich() throws IOException{
		 		
			 articulo art1 = new articulo();
				art1.setTitulo(textFieldTitulo.getText());
				art1.setDescripcion(textFieldDescripcion.getText());
				art1.setTexto(textFieldTexto.getText());
				art1.setImagen(textFieldImagen.getText());

				if (art1.getTitulo().equals("") || art1.getDescripcion().equals("")
						|| art1.getTexto().equals("") || art1.getImagen().equals("")) {

					JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
				} else {
					JOptionPane.showMessageDialog(null, "Contacto agregado");
					lista.add(art1);
				}
				try {
					File fichero = new File("C:\\FichArticulo.dat");
					
					
					FileOutputStream fileout = new FileOutputStream(fichero);
					ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
					// writeObject serializa los objetos del ArrayList y los guarda
					// en el fichero
					dataOS.writeObject(lista);
					dataOS.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		 public void LeerFichObj () throws IOException, ClassNotFoundException {
			 
		
					try {
						File fichero = new File("C:/FichArticulo.dat");
						
							FileInputStream fileout = new FileInputStream(fichero);
							ObjectInputStream ois = new ObjectInputStream(fileout);
							lista = (ArrayList<articulo>) ois.readObject();
							textArea.setText(lista.toString());
		
					}catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					
			}
			 
	 
		public void Salir(){
			
			JOptionPane.showMessageDialog(null, "Va a salir de la aplicación, gracias por utilizar nuestro servicio","¡Hasta Pronto!",JOptionPane.WARNING_MESSAGE);

			System.exit(0); //CIERRA LA APLICACIÓN
		}
	}
		

