package interfazGrafica;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clase destinada a crear una ventana en la que se muestre el fragmento del juego en el que se encuentra el usuario
 * recibe a través de los botones la decisión del usuario
 * @author Joaquin, Leandro, Gustavo, Camila
 */
public class VentanaJuego extends Ventana {
	private JButton botonOpcionA;
	private JButton botonOpcionB;
	private JButton botonOpcionC;
	private JButton botonGuardar;
	private JButton botonSalida;
	private JTextArea mainDisplay;
	private JTextField opcionADisplay;
	private JTextField opcionBDisplay;
	private JTextField opcionCDisplay;
	private Estudiante jugador;
	/**
	 * constructor
	 * @param main String
	 * @param opcionA opcion
	 * @param opcionB opcion
	 * @param opcionC opcion
	 * @param jugador Estudiante
	 */
	public VentanaJuego(String main, String opcionA, String opcionB, String opcionC, Estudiante jugador) {
		super("VentanaJuego",950,650);
		this.jugador=jugador;
		generarElementosVentana(main,opcionA,opcionB,opcionC);
	}
	/**
	 *
	 * @param mainDisplay el recorrido de la historia
	 * @param opcionA la opciòn elegida por el usuario
	 * @param opcionB la opciòn elegida por el usuario
	 * @param opcionC la opciòn elegida por el usuario
	 */
	public void generarElementosVentana(String mainDisplay, String opcionA, String opcionB, String opcionC) {
		generarBotonOpcionA();
		generarBotonOpcionB();
		generarBotonOpcionC();
		generarBotonGuardar();
		generarBotonSalir();
		generarMainDisplay(mainDisplay);
		generarOpcionA(opcionA);
		generarOpcionB(opcionB);
		generarOpcionC(opcionC);
	}
	/**
	 * genera el botòn de la primera opciòn
	 */
	public void generarBotonOpcionA() {
		String textoBoton = "Opcion A: ";
		this.botonOpcionA = super.generarBoton(textoBoton,50,300,150,40);
		this.add(this.botonOpcionA);
		this.botonOpcionA.addActionListener(this);
	}
	/**
	 *  genera el botòn de la segunda opciòn
	 */
	public void generarBotonOpcionB() {
		String textoBoton = "Opcion B: ";
		this.botonOpcionB = super.generarBoton(textoBoton,50,350,150,40);
		this.add(this.botonOpcionB);
		this.botonOpcionB.addActionListener(this);
	}
	/**
	 * genera el botòn de la tercera opciòn
	 */
	public void generarBotonOpcionC() {
		String textoBoton = "Opcion C: ";
		this.botonOpcionC = super.generarBoton(textoBoton,50,400,150,40);
		this.add(this.botonOpcionC);
		this.botonOpcionC.addActionListener(this);
	}
	/**
	 * genera el botòn para guardar la opciòn elegida
	 */
	public void generarBotonGuardar() {
		String textoBoton = "Guardar";
		this.botonGuardar = super.generarBoton(textoBoton,50,550,150,40);
		this.add(this.botonGuardar);
		this.botonGuardar.addActionListener(this);
	}
	/**
	 * genera el botòn de salida
	 */
	public void generarBotonSalir() {
		String textoBoton = "Salir";
		this.botonSalida = super.generarBoton(textoBoton,750,550,150,40);
		this.add(this.botonSalida);
		this.botonSalida.addActionListener(this);
	}
	/**
	 *
	 * @param mainDisplay recorrido de la historia
	 */
	public void generarMainDisplay(String mainDisplay){
		this.mainDisplay = new JTextArea(mainDisplay);
		this.mainDisplay.setBounds(50,50,800,200);
		this.mainDisplay.setFont(new Font("Calibri",2,40));
		this.mainDisplay.setColumns(1);
		this.mainDisplay.setRows(15);
		this.mainDisplay.setEditable(false);
		this.mainDisplay.setLineWrap(true);
		this.mainDisplay.setWrapStyleWord(true);
		super.add(this.mainDisplay);
	}
	/**
	 *
	 * @param opcionA la primera opciòn
	 */
	public void generarOpcionA(String opcionA){
		this.opcionADisplay = new JTextField(opcionA);
		this.opcionADisplay.setBounds(235,300,650,40);
		this.opcionADisplay.setEditable(false);
		super.add(this.opcionADisplay);
	}
	/**
	 *
	 * @param opcionB la segunda opciòn
	 */
	public void generarOpcionB(String opcionB){
		this.opcionBDisplay = new JTextField(opcionB);
		this.opcionBDisplay.setBounds(235,350,650,40);
		this.opcionBDisplay.setEditable(false);
		super.add(this.opcionBDisplay);
	}
	/**
	 *
	 * @param opcionC la tercera opciòn
	 */
	public void generarOpcionC(String opcionC){
		this.opcionCDisplay = new JTextField(opcionC);
		this.opcionCDisplay.setBounds(235,400,650,40);
		this.opcionCDisplay.setEditable(false);
		super.add(this.opcionCDisplay);
	}
	/**
	 * genera el boton A
	 */
	public void botonA(){
		Execution execution = new Execution(this.jugador, 0);
		if (execution.getJugador().getCoordenada() == 9997) {
			if(execution.getJugador().getConocimientos() >= 60){
				VentanaPelea ventanaPelea = new VentanaPelea(this.jugador,new Enemigo("Perro Ansiedad.",14,165,"src/main/resources/perro.png"));
			}
			else{
				VentanaPelea ventanaPelea = new VentanaPelea(this.jugador,new Enemigo("Profesor del terror",15,565,"src/main/resources/profesor.png"));
			}
		}
		else if(execution.getJugador().getCoordenada() == 420){
			execution.inicializarJugador();
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		}
		else {
			VentanaJuego ventanaJuego = new VentanaJuego(execution.getMainDisplay(),
					execution.getOpcionADisplay(), execution.getOpcionBDisplay(), execution.getOpcionCDisplay(), this.jugador);
		}
		this.dispose();
	}
	/**
	 * genera el boton B
	 */
	public void botonB(){
		Execution execution = new Execution(this.jugador, 1);
		if (execution.getJugador().getCoordenada() == 9997) {
			if(execution.getJugador().getConocimientos() >= 60){
				VentanaPelea ventanaPelea = new VentanaPelea(this.jugador,new Enemigo("Perro Ansiedad",14,165,"src/main/resources/perro.png"));
			}
			else{
				VentanaPelea ventanaPelea = new VentanaPelea(this.jugador,new Enemigo("Profesor del terror",15,565,"src/main/resources/profesor.png"));
			}
		}
		else if(execution.getJugador().getCoordenada() == 420){
			execution.inicializarJugador();
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		}
		else {
			VentanaJuego ventanaJuego = new VentanaJuego(execution.getMainDisplay(),
					execution.getOpcionADisplay(), execution.getOpcionBDisplay(), execution.getOpcionCDisplay(), this.jugador);
		}
		this.dispose();
	}
	/**
	 * genera el boton C
	 */
	public void botonC(){
		Execution execution = new Execution(this.jugador, 2);
		if (execution.getJugador().getCoordenada() == 9997) {
			if(execution.getJugador().getConocimientos() >= 60){
				VentanaPelea ventanaPelea = new VentanaPelea(this.jugador,new Enemigo("Perro Ansiedad",14,165,"src/main/resources/perro.png"));
			}
			else{
				VentanaPelea ventanaPelea = new VentanaPelea(this.jugador,new Enemigo("Profesor del terror.",15,565,"src/main/resources/profesor.png"));
			}
		}
		else if(execution.getJugador().getCoordenada() == 420){
			execution.inicializarJugador();
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		}
		else {
			VentanaJuego ventanaJuego = new VentanaJuego(execution.getMainDisplay(),
					execution.getOpcionADisplay(), execution.getOpcionBDisplay(), execution.getOpcionCDisplay(), this.jugador);
		}
		this.dispose();
	}
	/**
	 *
	 * @param e Actionevent
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonOpcionA) {
			botonA();
		}
		if(e.getSource() == this.botonOpcionB) {
			botonB();
		}
		if(e.getSource() == this.botonOpcionC) {
			botonC();
		}
		if(e.getSource() == this.botonGuardar){
			Execution execution = new Execution(this.jugador,3);
		}
		if(e.getSource() == this.botonSalida){
			this.dispose();
			System.exit(0);
		}
	}
}