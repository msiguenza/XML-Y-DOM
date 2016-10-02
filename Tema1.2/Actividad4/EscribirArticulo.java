package Actividad4;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.*;




public class EscribirArticulo{
	Actividad4 act4 = new Actividad4();
	
	public void EscribirArticuloXML() throws IOException,ClassNotFoundException {


		File fichero = new File("C:\\FichArticulo.dat");

		if (fichero.exists()) {
		
		FileInputStream filein = new FileInputStream(fichero); // flujo de
																// entrada

		// Conecta el flujo de bytes al flujo de datos

		ObjectInputStream dataIS = new ObjectInputStream(filein);

		System.out
				.println("Comienza el proceso de creación del fichero a XML…");

		// creamos un objeto de Lista de personas

		List<articulo> lista1= new ArrayList<articulo>();

		try {

			while (true) {
			lista1 = (ArrayList<articulo>) dataIS.readObject();

			}

		} catch (EOFException eo) {
		}

		dataIS.close();

		try {

			XStream xstream = new XStream();

			// cambiar de nombre a las etiquetas XML

			// insertar los objetos en el XML

			xstream.toXML(lista1, new FileOutputStream("C:\\Articulos.xml"));

			JOptionPane.showMessageDialog(null,
					"Creado fichero XML… (C:\\Articulos.xml)", "¡Succeful!",JOptionPane.WARNING_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else{
			
			JOptionPane.showMessageDialog(null, "No existe el fichero 'FichArticulo.dat'");
			
		}
		
}
	
}
	

	