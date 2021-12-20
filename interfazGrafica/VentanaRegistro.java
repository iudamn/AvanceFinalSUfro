package interfazGrafica;

import model.Execution;
import model.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends Ventana {
	private JLabel labelRegistro;
	private JButton botonRegistrar;
	private JButton botonReset;
	private JButton botonVolver;
	private JTextField userInputPanel;
	private JPasswordField passInputPanel;
	private JPasswordField passConfirmationInputPanel;

	public VentanaRegistro() {
		super("VentanaRegistro", 900, 700);
		generarElementosVentana();
	}

	public void generarElementosVentana() {
		generarLabel();
		generarBotonRegistrar();
		generarBotonReset();
		generarBotonVolver();
		generarInputPanels();
	}

	private void generarLabel() {
		String textoBienvenida = "Registrarse";
		super.generarJLabelEncabezado(this.labelRegistro, textoBienvenida, 150, 30, 600, 60);

	}


	public void generarBotonRegistrar() {
		String textoBoton = "Registrarse";
		this.botonRegistrar = super.generarBoton(textoBoton, 500, 450, 200, 50);
		this.add(this.botonRegistrar);
		this.botonRegistrar.addActionListener(this);
	}

	public void generarBotonReset() {
		String textoBoton = "Resetear";
		this.botonReset = super.generarBoton(textoBoton, 200, 450, 200, 50);
		this.add(this.botonReset);
		this.botonReset.addActionListener(this);
	}

	public void generarBotonVolver() {
		String textoBoton = "Volver";
		this.botonVolver = super.generarBoton(textoBoton, 100, 550, 200, 80);
		this.add(this.botonVolver);
		this.botonVolver.addActionListener(this);
	}

	public void generarInputPanels() {
		JLabel labelUser = new JLabel("Usuario: ");
		labelUser.setBounds(100, 150, 200, 40);
		labelUser.setForeground(Color.WHITE);
		this.userInputPanel = new JTextField();
		userInputPanel.setBounds(200, 150, 200, 40);
		super.add(userInputPanel);
		super.add(labelUser);

		JLabel labelPass = new JLabel("Contraseña: ");
		labelPass.setBounds(90, 250, 200, 40);
		labelPass.setForeground(Color.WHITE);
		this.passInputPanel = new JPasswordField();
		passInputPanel.setBounds(200, 250, 200, 40);
		super.add(passInputPanel);
		super.add(labelPass);

		JLabel labelPassVerify = new JLabel("Confirmar Contraseña: ");
		labelPassVerify.setBounds(50, 350, 200, 40);
		labelPassVerify.setForeground(Color.WHITE);
		this.passConfirmationInputPanel = new JPasswordField();
		passConfirmationInputPanel.setBounds(200, 350, 200, 40);
		super.add(passConfirmationInputPanel);
		super.add(labelPassVerify);
	}

	public void resetText() {
		userInputPanel.setText("");
		passInputPanel.setText("");
		passConfirmationInputPanel.setText("");
	}

	public void registrarUsuario(String user, String pass, String confirmation) {
		if (!user.isEmpty() && !pass.isEmpty()) {
			if (pass.equalsIgnoreCase(confirmation)) {
				Login login = new Login(user, pass);
				if(!login.registroCheck("src\\main\\resources\\registro")) {
					login.registrarUsuario();
					JOptionPane.showMessageDialog(this, "Registro exitoso.");
					Execution execution = new Execution(login.logearUsuario("src\\main\\resources\\registro"));
					VentanaJuego ventanaJuego = new VentanaJuego(execution.getMainDisplay(),
							execution.getOpcionADisplay(), execution.getOpcionBDisplay(), execution.getOpcionCDisplay(), execution.getJugador());
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this, "Nombre de usuario ya registrado, intente uno diferente.");
					resetText();
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Registro no exitoso, intente nuevamente.");
				resetText();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Registro no exitoso, intente nuevamente.");
			resetText();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String user = userInputPanel.getText();
		String pass = String.valueOf(passInputPanel.getPassword());
		String confirmation = String.valueOf(passConfirmationInputPanel.getPassword());
		if (e.getSource() == this.botonRegistrar) {
			registrarUsuario(user, pass, confirmation);
		}
		if (e.getSource() == this.botonReset) {
			resetText();
		}
		if (e.getSource() == this.botonVolver) {
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			this.dispose();
		}
	}
}
