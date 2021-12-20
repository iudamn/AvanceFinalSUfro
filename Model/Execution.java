package model;

import data.DataUpdater;
import data.FileReader;

import java.util.ArrayList;
/**
 * Modifica los valores del objeto jugador para que así avance el juego en la ventana juego
 * @author Joaquin, Leandro, Gustavo, Camila
 */
public class Execution {
	private String mainDisplay;
	private String opcionADisplay;
	private String opcionBDisplay;
	private String opcionCDisplay;
	private Estudiante jugador;
	private ArrayList<String> historia;

	/**
	 *
	 * @param userData se piden datos que luego se intervendràn para entregàrselos a la clase Usuario
	 */
	public Execution(String[] userData) {
		this.historia = FileReader.leerArchivo("src\\main\\resources\\juegoActual");
		this.jugador = new Estudiante(userData[0],userData[1],Integer.parseInt(userData[2]),
				Integer.parseInt(userData[3]), Integer.parseInt(userData[4]),
				Integer.parseInt(userData[5]), Integer.parseInt(userData[6]));
		asignaciones();
	}

	/**
	 *
	 * @param jugador se llama a la clase Estudiante
	 * @param opcion se especifica la opcion elegida por dicho Estudiante
	 */
	public Execution(Estudiante jugador, int opcion){
		this.historia = FileReader.leerArchivo("src\\main\\resources\\juegoActual");
		this.jugador=jugador;
		setStats(opcion);
	}
	/**
	 *
	 * @return devuelve el valor jugador
	 */
	public Estudiante getJugador() {
		return jugador;
	}
	/**
	 *
	 * @return devuelve el valor mainDisplay que hace representaciòn a la historia
	 */
	public String getMainDisplay() {
		return mainDisplay;
	}
	/**
	 *
	 * @return devuelve la opciòn A de la historia
	 */
	public String getOpcionADisplay() {
		return opcionADisplay;
	}
	/**
	 *
	 * @return devuelve la opciòn B de la historia
	 */
	public String getOpcionBDisplay() {
		return opcionBDisplay;
	}
	/**
	 *
	 * @return devuelve la opciòn C de la historia
	 */
	public String getOpcionCDisplay() {
		return opcionCDisplay;
	}
	/**
	 * se ve en què lugar va cada opciòn
	 */
	public void asignaciones(){
		String[] event = this.historia.get(this.jugador.getCoordenada()).split(";");
		this.mainDisplay=event[1];
		this.opcionADisplay=event[2];
		this.opcionBDisplay=event[3];
		this.opcionCDisplay=event[4];
	}

	/**
	 * se le asignan las opciones a los atributos
	 */
	public void asignarJugadorStatOpcionA(){
		String[] event = this.historia.get(this.jugador.getCoordenada()).split(";");
		this.jugador.setCoordenada(Integer.parseInt(event[5]));
		this.jugador.setConocimientos(this.jugador.getConocimientos()+Integer.parseInt(event[6]));
		this.jugador.setMoral(this.jugador.getMoral()+Integer.parseInt(event[7]));
		this.jugador.setHp(this.jugador.getHp()+Integer.parseInt(event[8]));
	}
	/**
	 * se le asignan las opciones a los atributos
	 */
	public void asignarJugadorStatOpcionB(){
		String[] event = this.historia.get(this.jugador.getCoordenada()).split(";");
		this.jugador.setCoordenada(Integer.parseInt(event[9]));
		this.jugador.setConocimientos(this.jugador.getConocimientos()+Integer.parseInt(event[10]));
		this.jugador.setMoral(this.jugador.getMoral()+Integer.parseInt(event[11]));
		this.jugador.setHp(this.jugador.getHp()+Integer.parseInt(event[12]));
	}
	/**
	 * 	 se le asignan las opciones a los atributos
	 */
	public void asignarJugadorStatOpcionC(){
		String[] event = this.historia.get(this.jugador.getCoordenada()).split(";");
		this.jugador.setCoordenada(Integer.parseInt(event[13]));
		this.jugador.setConocimientos(this.jugador.getConocimientos()+Integer.parseInt(event[14]));
		this.jugador.setMoral(this.jugador.getMoral()+Integer.parseInt(event[15]));
		this.jugador.setHp(this.jugador.getHp()+Integer.parseInt(event[16]));
	}
	/**
	 * al iniciar el juego se le entregan datos en especìfico
	 */
	public void inicializarJugador(){
		this.jugador.setCoordenada(0);
		this.jugador.setConocimientos(50);
		this.jugador.setMoral(50);
		this.jugador.setHp(100);
		actualizarUsuario();
	}

	/**
	 *
	 * @param opcion dependiendo de la opcion se le entregaràn las estadìsticas o la modificaciòn de las mismas
	 */
	public void setStats(int opcion){
		if (opcion == 0){
			asignarJugadorStatOpcionA();
		}
		if (opcion == 1){
			asignarJugadorStatOpcionB();
		}
		if (opcion == 2){
			asignarJugadorStatOpcionC();
		}
		if (opcion == 3){
			actualizarUsuario();
		}
		if(this.jugador.getCoordenada() != 420 && this.jugador.getCoordenada() != 9997) { //coordenada que indica que se acabo el juego o hay una pelea
			asignaciones();
		}
	}
	/**
	 * se actualizan las estadìsticas del usuario dependiendo de sus elecciones
	 */
	public void actualizarUsuario(){
		DataUpdater.actualizarUsuario(this.jugador.getUser(),this.jugador.getPass(),this.jugador.getCoordenada(),
				this.jugador.getConocimientos(),this.jugador.getMoral(),this.jugador.getHp(),
				"src\\main\\resources\\registro", this.jugador.getId());
	}
}