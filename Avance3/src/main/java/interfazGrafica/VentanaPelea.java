package interfazGrafica;

import model.Enemigo;
import model.Execution;
import model.FightExecution;
import model.Estudiante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 * Clase destinada a crear una ventana donde se le muestre al usuario su enfrentamiento con la encarnación del miedo
 * que le corresponde
 * @author Joaquin, Leandro, Gustavo, Camila
 */
public class VentanaPelea extends Ventana{
    private JLabel labelPelea;
    private JButton botonOpcionA;
    private JButton botonOpcionB;
    private JButton botonSalida;
    private JTextArea mainDisplay;
    private JTextField opcionADisplay;
    private JTextField opcionBDisplay;
    private JTextField vidaUsuario;
    private JTextField vidaEnemigo;
    private ImageIcon imagen;
    private Estudiante jugador;
    private Enemigo enemigo;
    private String imagenLocation;
    /**
     * constructor
     * @param jugador de la clase Estudiante
     * @param enemigo de la clase Enemigo
     */
    public VentanaPelea(Estudiante jugador, Enemigo enemigo){
        super("VentanaPelea",950,650);
        this.jugador=jugador;
        this.enemigo=enemigo;
        this.imagenLocation=enemigo.getUbicacionImagen();
        String main = "Derrota la manifestación de tus miedos para ganar.";
        generarElementosVentana(main);
    }
    /**
     * Constructor
     * @param jugador de la clase Estudiante
     * @param enemigo de la clase Enemigo
     * @param A recorrido de la historia
     */
    public VentanaPelea(Estudiante jugador, Enemigo enemigo, String A){
        super("VentanaPelea",950,650);
        this.jugador=jugador;
        this.enemigo=enemigo;
        this.imagenLocation=enemigo.getUbicacionImagen();
        generarElementosVentana(A);
    }
    /**
     *
     * @param mainDisplay es el recorrido de la historia
     */
    public void generarElementosVentana(String mainDisplay) {
        generarlabelPelea();
        generarBotonAtaque();
        generarBotonDefensa();
        generarBotonSalir();
        generarMainDisplay(mainDisplay);
        generarTextoAtaque();
        generarTextoDefensa();
        generarTextoVidaUsuario();
        generarTextoVidaEnemigo();
        generarImagen();
    }
    /**
     *genera la etiqueta que darà inicio a la pelea
     */
    private void generarlabelPelea() {
        String textoBienvenida = "¡Se manifiestan tus miedos!";
        super.generarJLabelEncabezado(this.labelPelea, textoBienvenida,50,10,600,60);
    }
    /**
     * genera el botòn para atacar
     */
    public void generarBotonAtaque() {
        String textoBoton = "Atacar: ";
        this.botonOpcionA = super.generarBoton(textoBoton,50,400,150,40);
        this.add(this.botonOpcionA);
        this.botonOpcionA.addActionListener(this);
    }
    /**
     * genera el botòn para defenderse
     */
    public void generarBotonDefensa() {
        String textoBoton = "Defenderse: ";
        this.botonOpcionB = super.generarBoton(textoBoton,50,450,150,40);
        this.add(this.botonOpcionB);
        this.botonOpcionB.addActionListener(this);
    }
    /**
     * genera el botòn para salir del programa
     */
    public void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton,750,550,150,40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    /**
     *
     * @param mainDisplay es el recorrido de la historia
     */
    public void generarMainDisplay(String mainDisplay){
        this.mainDisplay = new JTextArea(mainDisplay);
        this.mainDisplay.setBackground(Color.red);
        this.mainDisplay.setBounds(50,100,400,200);
        this.mainDisplay.setFont(new Font("Calibri",2,40));
        this.mainDisplay.setColumns(1);
        this.mainDisplay.setRows(15);
        this.mainDisplay.setEditable(false);
        this.mainDisplay.setLineWrap(true);
        this.mainDisplay.setWrapStyleWord(true);
        super.add(this.mainDisplay);
    }
    /**
     * genera el texto posterior al ataque hecho por el usuario
     */
    public void generarTextoAtaque(){
        this.opcionADisplay = new JTextField("Realiza un ataque fuerte; "+this.jugador.getMoral()+" de daño.");
        this.opcionADisplay.setBounds(235,400,650,40);
        this.opcionADisplay.setEditable(false);
        super.add(this.opcionADisplay);
    }
    /**
     * genera el texto posterior a la defensa llevada a cabo por el usuario
     */
    public void generarTextoDefensa(){
        this.opcionBDisplay = new JTextField("Disminuye el daño recibido en el próximo ataque y realiza un ataque débil.");
        this.opcionBDisplay.setBounds(235,450,650,40);
        this.opcionBDisplay.setEditable(false);
        super.add(this.opcionBDisplay);
    }
    /**
     * genera el puntaje de vida del usuario en el instante
     */
    public void generarTextoVidaUsuario(){
        this.vidaUsuario = new JTextField("HP: "+String.valueOf(this.jugador.getHp()));
        this.vidaUsuario.setBackground(Color.cyan);
        this.vidaUsuario.setBounds(135,320,150,40);
        this.vidaUsuario.setEditable(false);
        super.add(this.vidaUsuario);
    }
    /**
     * genera el puntaje de vida del enemigo
     */
    public void generarTextoVidaEnemigo(){
        this.vidaEnemigo = new JTextField("HP Enemigo: "+String.valueOf(this.enemigo.getHp()));
        this.vidaEnemigo.setBackground(Color.cyan);
        this.vidaEnemigo.setBounds(305,320,150,40);
        this.vidaEnemigo.setEditable(false);
        super.add(this.vidaEnemigo);
    }
    /**
     * genera la imagen representativa
     */
    public void generarImagen(){
        this.imagen=new ImageIcon(this.imagenLocation);
        JLabel imagen = new JLabel(this.imagen);
        imagen.setBounds(550, 100, 250, 250);
        imagen.setVisible(true);
        super.add(imagen);
    }
    /**
     * genera el botòn a
     */
    public void botonA(){
        FightExecution fightExecution = new FightExecution(this.jugador,this.enemigo,0);
        if(this.jugador.getCoordenada() != 68 && this.jugador.getCoordenada() != 69) {
            VentanaPelea ventanaPelea = new VentanaPelea(this.jugador, this.enemigo, fightExecution.getMainDisplay());
        }
        else{
            Execution execution = new Execution(this.jugador, 0);
            VentanaJuego ventanaJuego = new VentanaJuego(execution.getMainDisplay(),
                    execution.getOpcionADisplay(), execution.getOpcionBDisplay(), execution.getOpcionCDisplay(), this.jugador);
        }
        this.dispose();
    }
    /**
     * genera el boton b
     */
    public void botonB(){
        FightExecution fightExecution = new FightExecution(this.jugador, this.enemigo, 1);
        if(this.jugador.getCoordenada() != 68 && this.jugador.getCoordenada() != 69) {
            VentanaPelea ventanaPelea = new VentanaPelea(this.jugador, this.enemigo, fightExecution.getMainDisplay());
        }
        else{
            Execution execution = new Execution(this.jugador, 0);
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
        if(e.getSource() == this.botonOpcionA){
            botonA();
        }
        if(e.getSource() == this.botonOpcionB) {
            botonB();
        }
        if(e.getSource() == this.botonSalida){
            String textoBienvenida = "Se perderá el progreso no guardado.";
            this.dispose();
            System.exit(0);
        }
    }
}