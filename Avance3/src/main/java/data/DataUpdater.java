package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Clase encargada de la edición de los archivos de texto utilizados en el programa.
 *
 * @author Joaquín Ortiz Castillo
 *
 * */
public class DataUpdater {
	/**
	 *
	 * @param usuario Nombre del usuario logueado para guardar sus nuevos datos.
	 * @param pass Contraseña del usuario logueado para guardar sus nuevos datos.
	 * @param filepath Path reference del archivo a editar.
	 * @param id Como el archivo se lee completo, se le indica la posición del ArrayList en la que se encuentran
	 *                 los datos del usuario
	 */
	public static void guardarUsuario(String usuario, String pass, String filepath, int id){
		BufferedWriter bw = null;
		FileWriter fichero = null;

		try {
			File file = new File(filepath);
			fichero = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fichero);
			if(id == 1){
				bw.write(usuario+","+pass+",0,50,50,100,"+(0));
			}
			else {
				bw.write("\n" + usuario + "," + pass + ",0,50,50,100," + (id - 1));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//Cierra instancias de FileWriter y BufferedWriter
				if (bw != null)
					bw.close();
				if (fichero != null)
					fichero.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @param usuario Nombre del usuario logueado para guardar sus nuevos datos.
	 * @param pass Contraseña del usuario logueado para guardar sus nuevos datos.
	 * @param coordenada Coordenada del usuario dentro del archivo que contiene el juego.
	 * @param conocimientos Estadística de conocimientos del usuario.
	 * @param moral Estadística de moral del usuario.
	 * @param hp Número que indica la vida del usuario.
	 * @param filepath Path reference del archivo a editar.
	 * @param id Como el archivo se lee completo, se le indica la posición del ArrayList en la que se encuentran
	 *                    los datos del usuario.
	 */
	public static void actualizarUsuario(String usuario, String pass, int coordenada, int conocimientos,
										 int moral, int hp, String filepath, int id){
		ArrayList<String> registro = FileReader.leerArchivo(filepath);
		BufferedWriter bw = null;
		FileWriter fichero = null;
		registro.set(id,usuario+","+pass+","
				+coordenada+","+conocimientos+
				","+moral+","+hp+","+id);
		try {
			File file = new File(filepath);
			fichero = new FileWriter(file.getAbsoluteFile(), false);
			bw = new BufferedWriter(fichero);
			int i=0;
			while(i<registro.size()){
				if (i == registro.size()-1){
					bw.write(registro.get(i));
					i++;
				}
				else{
				bw.write(registro.get(i)+"\n");}
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//Cierra instancias de FileWriter y BufferedWriter
				if (bw != null)
					bw.close();
				if (fichero != null)
					fichero.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}