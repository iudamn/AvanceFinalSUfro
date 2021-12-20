package interfazGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * Ventana principal del juego, deriva a las ventanas para registrarse y loguear.
 * @author Joaquin, Leandro, Gustavo, Camila
 */
public class VentanaPrincipal extends Ventana {
	private JLabel bienvenida;
	private JButton botonManual;
	private JButton botonRegistro;
	private JButton botonLogin;
	private JButton botonSalida;
	/**
	 * representa la ventana principal
	 */
	public VentanaPrincipal() {

		super("VentanaPrincipal",900,700);
		generarElementosVentana();

	}
	/**
	 * Llama a los demàs mètodos por motivos de orden
	 */
	public void generarElementosVentana() {
		generarMensajeBienvenida();
		generarBotonManual();
		generarBotonRegistro();
		generarBotonLogin();
		generarBotonSalida();
	}
	/**
	 * plasma el mensaje de bienvenida
	 */
	public void generarMensajeBienvenida() {
		String textoBienvenida = "Bienvenido a Surviving Ufro";
		super.generarJLabelEncabezado(this.bienvenida, textoBienvenida,150,30,600,60);

	}
	/**
	 * genera botòn manual que guia a las instrucciones
	 */
	public void generarBotonManual() {
		String textoBoton = "Manual";
		this.botonManual = super.generarBoton(textoBoton,350,150,200,80);
		this.add(this.botonManual);
		this.botonManual.addActionListener(this);
	}
	/**
	 * genera el botòn de registro
	 */
	public void generarBotonRegistro() {
		String textoBoton = "Registrarse";
		this.botonRegistro = super.generarBoton(textoBoton,350,250,200,80);
		this.add(this.botonRegistro);
		this.botonRegistro.addActionListener(this);
	}
	/**
	 * genera el botòn para iniciar sesiòn
	 */
	public void generarBotonLogin() {
		String textoBoton = "Loguear";
		this.botonLogin = super.generarBoton(textoBoton,350,350,200,80);
		this.add(this.botonLogin);
		this.botonLogin.addActionListener(this);
	}
	/**
	 * genera el botòn para que se cierre el programa
	 */
	public void generarBotonSalida() {
		String textoBoton = "Salir";
		this.botonSalida = super.generarBoton(textoBoton,650,550,200,80);
		this.add(this.botonSalida);
		this.botonSalida.addActionListener(this);
	}
	/**
	 *
	 * @param e Actionevent
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonManual){
			JOptionPane.showMessageDialog(this,"Crea un usuario y navega el juego utilizando" +
					" los botones en pantalla, buena suerte.");
		}
		if(e.getSource() == this.botonRegistro){
			VentanaRegistro ventanaRegistro = new VentanaRegistro();
			this.dispose();
		}
		if(e.getSource() == this.botonLogin){
			VentanaEntrada ventanaLogin = new VentanaEntrada();
			this.dispose();
		}
		if(e.getSource() == this.botonSalida){
			this.dispose();
			System.exit(0);
		}
	}
}