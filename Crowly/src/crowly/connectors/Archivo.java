package crowly.connectors;

import java.io.*;

public class Archivo {
	
	public String leerArchivo ( String direccion ){
		String texto = "";
		try{
			BufferedReader bf = new BufferedReader( new FileReader( direccion ) );
			String temp = "";
			String bfRead;
			while ( ( bfRead = bf.readLine( ) ) != null ){
				temp = temp + bfRead + "\n"; 
			}
			texto = temp;
			bf.close();// Esto se puede borrar
		}catch( Exception e ){
			System.err.println( "ERROR: Archivo no encontrado" );
			return "";
		}
		return texto.trim();
	}

}