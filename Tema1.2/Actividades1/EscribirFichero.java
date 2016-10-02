

package Actividades1;

import java.io.*;

public class EscribirFichero {

	public static void main(String[] args) throws IOException{
		
		File fichero=new File("C://AleatorioCoche.dat");
		RandomAccessFile file= new RandomAccessFile(fichero, "rw");
		
		String Marca[ ]={"Peugeot", "Ford", "BMW", "Toyota" ,"Renault", "Ferrari", "Mercedes"};
		
		String Modelo[]={"Solver", "Escort", "X6", "Cyprus", "Kangoo", "Testa Rosa", "Clase C"};
		
		String Matricula[ ]={"345533", "6545234", "645234", "150056", "22000", "143587", "220000"};
		
		String Potencia[ ]={"345", "254", "145", "150", "220", "143", "200"};
		
		String Plazas[ ]={"3", "6", "6", "5", "2", "4", "2"};
		
		String NumPuertas[ ]={"5", "3", "5", "3", "3", "5", "3"};
		
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
		
	}
		
}