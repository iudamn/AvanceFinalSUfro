package interfazGrafica;


import model.Execution;
import model.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 */
public class VentanaEntrada extends Ventana {
	private JLabel labelLoguear;
	private JButton botonLogear;
	private JButton botonReset;
	private JButton botonVolver;
	private JTextField userInputPanel;
	private JPasswordField passInputPanel;


	/**
	 *
	 */
	public VentanaEntrada() {
		super("VentanaLogin",900,700);
		generarElementosVentana();
	}

	public void generarElementosVentana() {
		generarLabel();
		generarBotonLogear();
		generarBotonReset();
		generarBotonVolver();
		generarInputPanels();
	}

	private void generarLabel() {
		String textoBienvenida = "Iniciar Sesion";
		super.generarJLabelEncabezado(this.labelLoguear, textoBienvenida,150,30,600,60);
	}

	public void generarBotonLogear() {
		String textoBoton = "Loguear";
		this.botonLogear = super.generarBoton(textoBoton,500,350,200,50);
		this.add(this.botonLogear);
		this.botonLogear.addActionListener(this);
	}

	public void generarBotonReset() {
		String textoBoton = "Resetear";
		this.botonReset = super.generarBoton(textoBoton,200,350,200,50);
		this.add(this.botonReset);
		this.botonReset.addActionListener(this);
	}

	public void generarBotonVolver() {
		String textoBoton = "Volver";
		this.botonVolver = super.generarBoton(textoBoton,100,550,200,80);
		this.add(this.botonVolver);
		this.botonVolver.addActionListener(this);
	}

	public void generarInputPanels() {
		JLabel labelUser = new JLabel("Usuario: ");
		labelUser.setBounds(100,150,200,40);
		labelUser.setForeground(Color.WHITE);
		userInputPanel = new JTextField();
		userInputPanel.setBounds(200,150,200,40);
		super.add(userInputPanel);
		super.add(labelUser);

		JLabel labelPass = new JLabel("Contraseña: ");
		labelPass.setBounds(90,250,200,40);
		labelPass.setForeground(Color.WHITE);
		passInputPanel = new JPasswordField();
		passInputPanel.setBounds(200,250,200,40);
		super.add(passInputPanel);
		super.add(labelPass);
	}

	public void actionPerformed(ActionEvent e) {
		boolean state;
		if(e.getSource() == this.botonLogear) {
			Login login = new Login(userInputPanel.getText(), String.valueOf(passInputPanel.getPassword()));
			login.logearUsuario("src\\main\\resources\\registro");
			state = login.isLoginState();
			if (!state) {
				JOptionPane.showMessageDialog(this, "Login incorrecto, intente nuevamente.");
				userInputPanel.setText("");
				passInputPanel.setText("");
			}
			else{
				Execution execution = new Execution(login.logearUsuario("src\\main\\resources\\registro"));
				VentanaJuego ventanaJuego = new VentanaJuego(execution.getMainDisplay(),
						execution.getOpcionADisplay(), execution.getOpcionBDisplay(), execution.getOpcionCDisplay(), execution.getJugador());
				this.dispose();
			}
		}
		if(e.getSource() == this.botonReset){
			userInputPanel.setText("");
			passInputPanel.setText("");
		}
		if(e.getSource() == this.botonVolver){
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			this.dispose();
		}
	}
}