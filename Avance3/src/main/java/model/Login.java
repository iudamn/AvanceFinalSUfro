package model;

import data.DataUpdater;
import data.FileReader;

import java.util.ArrayList;
/**
 * Clase encargada de procesar el inicio de sesión de un usuario y el registro de usuarios nuevos
 * @author Joaquin, Leandro, Gustavo, Camila
 */
public class Login {
	private String user;
	private String pass;
	private boolean loginState = false;
	/**
	 *
	 * @param user dato de usuario
	 * @param pass dato de contraseña
	 */
	public Login(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	/**
	 * busca en el archivo registro para anotar el nuevo usuario
	 */
	public void registrarUsuario() {
		int newId = FileReader.leerArchivo("src\\main\\resources\\registro").size() + 1;
		DataUpdater.guardarUsuario(this.user, this.pass, "src\\main\\resources\\registro", newId);
	}
	/**
	 *
	 * @param filepath direcciòn que serà utilizada para leer
	 * @return regresa la variable del usuario que ya INICIÒ sesiòn despuès de cumplir con las condiciones
	 */
	public String[] logearUsuario(String filepath) {
		ArrayList<String> registros = FileReader.leerArchivo(filepath);
		this.loginState = false;
		String[] usuarioLogeado = new String[6];
		for (int i = 0; i < registros.size(); i++) {
			String[] temp = registros.get(i).split(",");
			if (this.user.equalsIgnoreCase(temp[0]) && this.pass.equalsIgnoreCase(temp[1])) {
				this.loginState = true;
				usuarioLogeado = temp;
			}
		}
		return usuarioLogeado;
	}
	/**
	 *
	 * @return devuelve loginState
	 */
	public boolean registroCheck(String filepath) {
		ArrayList<String> registros = FileReader.leerArchivo(filepath);
		this.loginState = false;
		for (String registro : registros) {
			String[] temp = registro.split(",");
			if (this.user.equalsIgnoreCase(temp[0])) {
				this.loginState = true;
				break;
			}
		}
		return this.loginState;
	}
	/**
	 *
	 * @return devuelve loginState
	 */
	public boolean isLoginState() {
		return loginState;
	}

	public String getUser() {
		return this.user;
	}
	/**
	 *
	 * @param user puede sustituirse el usuario
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 *
	 * @return devuelve la contraseña
	 */
	public String getPass() {
		return this.pass;
	}
	/**
	 *
	 * @param pass puede sustituirse la contraseña
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
}