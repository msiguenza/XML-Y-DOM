package Actividad2;

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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.Toolkit;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JTextArea;

	public class Actividad2 extends JFrame {

		//DECLARACIÓN DE VARIABLES
		public JPanel contentPane;
		
		public JButton btnSAX;
		public JButton btnDOM;
		
		JScrollPane scrollPane;
		
		JMenuBar menuBar;
		JMenu mnArchivo;
		JMenuItem mntmSalir;
		JLabel labelfondo;
		
		JTextArea textArea;
		 
	   
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Actividad2 frame = new Actividad2();
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
		public Actividad2() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("Tema1.2\\images\\estrellaoro.png")); //IMAGEN DEL ICONO DE LA APLICACIÓN
			
			
			
			setTitle("Manejo de Archivos");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 540,  574);
			
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
			
			btnDOM = new JButton("DOM");
			btnDOM.setIcon(new ImageIcon("Tema1.2\\images\\Notas.png"));
			btnDOM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
								
					LeerDOM leerdom = new LeerDOM();
					leerdom.LeerDOM();
					
					textArea.setText("");
					
					
					textArea.append(leerdom.getString());
					
					
					
				}
			});
			
			JLabel lblElijaLaOpcin = new JLabel("Elija la opci\u00F3n con la que desea ver el fichero XML :");
			lblElijaLaOpcin.setFont(new Font("Tarzan", Font.PLAIN, 13));
			lblElijaLaOpcin.setBounds(22, 32, 462, 14);
			contentPane.add(lblElijaLaOpcin);
			btnDOM.setBounds(46, 144, 142, 45);
			contentPane.add(btnDOM);
			
			btnSAX = new JButton("SAX");
			btnSAX.setIcon(new ImageIcon("Tema1.2\\images\\notes.png"));
			btnSAX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				    GestionContenido gestCon = new GestionContenido();
					
				    try {
						gestCon.RSAX();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    textArea.setText("");
				   
					textArea.append(gestCon.getString()); 
				}

			});

				
			btnSAX.setBounds(342, 144, 142, 45);
			contentPane.add(btnSAX);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 274, 512, 234);
			contentPane.add(scrollPane);
			
			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			
			labelfondo = new JLabel("");
			labelfondo.setIcon(new ImageIcon("Tema1.2\\images\\fondoabstracto.jpg")); //IMAGEN DE FONDO DE LA APLICACIÓN
			labelfondo.setBounds(0, 0, 534, 528);
			contentPane.add(labelfondo);
		}
		
		//METODOS ---------------------------------------------------------------------------------------------------------------------
		
		public void Salir(){
			
			JOptionPane.showMessageDialog(null, "Va a salir de la aplicación, gracias por utilizar nuestro servicio","¡Hasta Pronto!",JOptionPane.WARNING_MESSAGE);

			System.exit(0); //CIERRA LA APLICACIÓN
		}
	}
		

