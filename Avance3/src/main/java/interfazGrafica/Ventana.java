package interfazGrafica;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase padre de todas las ventanas utilizadas
 *
 *@author Òscar
 */
public class Ventana extends JFrame implements ActionListener {
    private final Font fuenteTitulo;
    private final Font fuenteTexto;
    /**
     *@param nombre Es el nombre de la ventana
     *@param largoX Es el ancho de la ventana
     *@param largoY Es el alto de la ventana
     */
    protected Ventana(String nombre, int largoX, int largoY){
        super(nombre);
        super.setVisible(true);
        getContentPane().setBackground(Color.black);
        //Al cerrar la ventana finaliza la aplicacion
        super.setDefaultCloseOperation(3);
        super.setSize(largoX,largoY);
        //Componentes centrados
        super.setLocationRelativeTo(null);
        //ventana no puede extenderse
        super.setResizable(false);
        //indica que se debe asignar manualmente la posicion de cada componente
        this.setLayout(null);
        this.fuenteTitulo = new Font("Calibri",3,50);
        this.fuenteTexto = new Font("Calibri",1,15);
    }
    /**
     *
     * @param label Es una etiqueta para añadirle el texto que estimemos conveniente
     * @param texto Es el texto
     * @param posicionX Coordenada de ancho para ver desde què lugar se abre la ventana
     * @param posicionY Coordenada de alto para ver desde què lugar se abre la ventana
     * @param largoX Es el ancho de la ventana
     * @param largoY Es el alto de la ventana
     */
    protected void generarJLabelEncabezado(JLabel label, String texto, int posicionX, int posicionY, int largoX,
                                           int largoY){
        label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setBounds(posicionX,posicionY,largoX,largoY);
        label.setFont(this.fuenteTitulo);
        this.add(label);
    }
    /**
     *
     * @param texto Es el texto que està dentro del botòn que se genera
     * @param posicionX Es la coordenada de ancho para ver desde què lugar se abre la ventana
     * @param posicionY Es la coordenada de alto para ver desde què lugar se abre la ventana
     * @param largoX Es el ancho de la ventana
     * @param largoY Es el alto de la ventana
     * @return Regresa el botòn ya listo por si debe interactuar con otro mètodo
     */
    protected JButton generarBoton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JButton boton = new JButton(texto);
        boton.setBounds(posicionX,posicionY,largoX,largoY);
        boton.setFont(this.fuenteTexto);
        boton.setBackground(Color.GREEN);
        boton.setForeground(Color.DARK_GRAY);
        return boton;
    }
    /**
     *
     * @param label Es una etiqueta para añadirle el texto que estimemos conveniente
     * @param texto Es el texto que està dentro del botòn que se genera
     * @param posicionX Es la coordenada de ancho para ver desde què lugar se abre la ventana
     * @param posicionY Es la coordenada de altura para ver desde què lugar se abre la ventana
     * @param largoX Es el ancho de la ventana
     * @param largoY Es el alto de la ventana
     */
    protected void generarJLabel(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY){
        label = new JLabel(texto);
        label.setBounds(posicionX,posicionY,largoX,largoY);
        label.setFont(this.fuenteTexto);
        this.add(label);
    }
    /**
     *
     * @param formato pide el formato de la ventana
     * @param posicionX Es la coordenada de ancho para ver desde què lugar se abre la ventana
     * @param posicionY Es la coordenada de altura para ver desde què lugar se abre la ventana
     * @param largoX Es el ancho de la ventana
     * @param largoY Es el alto de la ventana
     * @return devuelve el formato
     */
    //Entrada de texto, que restringe datos dependiendo del formato que se le dé
    protected JFormattedTextField generarJFormattedTextField(InternationalFormatter formato, int posicionX,
                                                             int posicionY, int largoX, int largoY){
        JFormattedTextField textField = new JFormattedTextField(formato);
        textField.setBounds(posicionX,posicionY,largoX,largoY);
        return textField;
    }
    /**
     *
     * @param minimo tamaño
     * @return devuelve el formato
     */
    //Formato para JformattedTextField con un entero
    protected InternationalFormatter generarFormato(int minimo){
        InternationalFormatter formato = new InternationalFormatter();
        formato.setMinimum(minimo);
        return formato;
    }
    /**
     *
     * @param minimo tamaño
     * @param maximo tamaño
     * @return devuelve el formato calculado
     */
    //Formato para JFormattedTextField en un intervalo de enteros
    protected InternationalFormatter generarFormato(int minimo, int maximo){
        InternationalFormatter formato = new InternationalFormatter();
        formato.setMinimum(minimo);
        formato.setMaximum(maximo);
        return formato;
    }
    /**
     *
     * @param posicionX Es la coordenada de ancho para ver desde què lugar se abre la ventana
     * @param posicionY Es la coordenada de altura para ver desde què lugar se abre la ventana
     * @param largoX Es el ancho de la ventana
     * @param largoY Es el alto de la ventana
     * @return Devuelve el texto
     */
    protected JTextField generarJTextField(int posicionX, int posicionY, int largoX, int largoY){
        JTextField textField = new JTextField();
        textField.setBounds(posicionX,posicionY,largoX,largoY);
        return textField;
    }
    /**
     *
     * @param texto Pide el texto a utilizar
     * @param posicionX Es la coordenada de ancho para ver desde què lugar se abre la ventana
     * @param posicionY Es la coordenada de altura para ver desde què lugar se abre la ventana
     * @param largoX Es el ancho de la ventana
     * @param largoY Es el alto de la ventana
     * @return devuelve el valor
     */
    protected JRadioButton generarJRadioButton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JRadioButton boton = new JRadioButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        return boton;
    }
    /**
     *
     * @param e Actionevent
     */
    @Override
    public void actionPerformed(ActionEvent e){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}