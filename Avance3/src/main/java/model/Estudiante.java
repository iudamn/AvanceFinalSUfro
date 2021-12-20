package model;

/**
 *
 * Clase para instanciar un objeto del tipo Estudiante.
 * Cumple funciones de usuario como almacenar user y pass
 *
 * @author Joaquín Ortiz Castillo
 *
 * */
public class Estudiante {
	private final String user;
	private final String pass;
	private int coordenada;
	private int conocimientos;
	private int moral;
	private int hp;
	private int id;
	/**
	 *
	 * @param user Corresponde al usuario registrado, logueado, con el que se crea el objeto Estudiante
	 * @param pass Corresponde a la contraseña registrada, logueada, con la que se crea el objeto Estudiante
	 * @param coordenada Coordenada del usuario dentro del archivo que contiene el juego.
	 * @param conocimientos Estadística de conocimientos del usuario.
	 * @param moral Estadística de moral del usuario.
	 * @param hp Número que indica la vida del usuario.
	 * @param id Como el archivo se lee completo, se le indica la posición del ArrayList en la que se encuentran
	 * 	                     los datos del usuario.
	 */
	public Estudiante(String user, String pass, int coordenada, int conocimientos, int moral, int hp, int id){
		this.user=user;
		this.pass=pass;
		this.coordenada=coordenada;
		this.conocimientos =conocimientos;
		this.moral=moral;
		this.hp=hp;
		this.id=id;
	}
	/**
	 *
	 * @return devuelve usuario
	 */
	public String getUser() {
		return user;
	}
	/**
	 *
	 * @return devuelve contraseña
	 */
	public String getPass() {
		return pass;
	}
	/**
	 *
	 * @return devuelve coordenadas
	 */
	public int getCoordenada() {
		return this.coordenada;
	}
	/**
	 *
	 * @param coordenada sustituye coordenadas
	 */
	public void setCoordenada(int coordenada) {
		this.coordenada = coordenada;
	}
	/**
	 *
	 * @return devuelve conocimientos
	 */
	public int getConocimientos() {
		return conocimientos;
	}
	/**
	 *
	 * @param conocimientos sustituye conocimientos
	 */
	public void setConocimientos(int conocimientos) {
		this.conocimientos = conocimientos;
	}
	/**
	 *
	 * @return devuelve moral
	 */
	public int getMoral() {
		return moral;
	}
	/**
	 *
	 * @param moral sustituye moral
	 */
	public void setMoral(int moral) {
		this.moral = moral;
	}
	/**
	 *
	 * @return devuelve hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 *
	 * @param hp sustituye hp
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	/**
	 *
	 * @return devuelve id
	 */
	public int getId() {
		return this.id;
	}
}