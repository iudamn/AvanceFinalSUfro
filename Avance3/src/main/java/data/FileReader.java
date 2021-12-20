package data;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * Clase encargada de la lectura de los archivos de texto utilizados en el programa.
 *
 * @author Joaquín Ortiz Castillo
 *
 * */
public class FileReader {
	/**
	 *
	 * @param filepath Path reference del archivo a leer.
	 * @return ArrayList de Strings que contiene el archivo completo separado por líneas.
	 */
	public static ArrayList<String> leerArchivo(String filepath) {
			String line=null;
			ArrayList<String> lines = new ArrayList<>();
			try {
				File archivo = new File(filepath);
				java.io.FileReader fr = new java.io.FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				while((line = br.readLine()) != null){
					lines.add(line);
				}
				fr.close();
			} catch (Exception e) {
				System.out.println("Documento no disponible, por favor contactar con administrador.");
			}
			return lines;
		}
}