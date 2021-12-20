package interfazGrafica;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ventana extends JFrame implements ActionListener {
    private final Font fuenteTitulo;
    private final Font fuenteTexto;

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

    protected void generarJLabelEncabezado(JLabel label, String texto, int posicionX, int posicionY, int largoX,
                                           int largoY){
        label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setBounds(posicionX,posicionY,largoX,largoY);
        label.setFont(this.fuenteTitulo);
        this.add(label);
    }

    protected JButton generarBoton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JButton boton = new JButton(texto);
        boton.setBounds(posicionX,posicionY,largoX,largoY);
        boton.setFont(this.fuenteTexto);
        boton.setBackground(Color.GREEN);
        boton.setForeground(Color.DARK_GRAY);
        return boton;
    }

    protected void generarJLabel(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY){
        label = new JLabel(texto);
        label.setBounds(posicionX,posicionY,largoX,largoY);
        label.setFont(this.fuenteTexto);
        this.add(label);
    }

    //Entrada de texto, que restringe datos dependiendo del formato que se le dé
    protected JFormattedTextField generarJFormattedTextField(InternationalFormatter formato, int posicionX,
                                                             int posicionY, int largoX, int largoY){
        JFormattedTextField textField = new JFormattedTextField(formato);
        textField.setBounds(posicionX,posicionY,largoX,largoY);
        return textField;
    }

    //Formato para JformattedTextField con un entero
    protected InternationalFormatter generarFormato(int minimo){
        InternationalFormatter formato = new InternationalFormatter();
        formato.setMinimum(minimo);
        return formato;
    }

    //Formato para JFormattedTextField en un intervalo de enteros
    protected InternationalFormatter generarFormato(int minimo, int maximo){
        InternationalFormatter formato = new InternationalFormatter();
        formato.setMinimum(minimo);
        formato.setMaximum(maximo);
        return formato;
    }

    protected JTextField generarJTextField(int posicionX, int posicionY, int largoX, int largoY){
        JTextField textField = new JTextField();
        textField.setBounds(posicionX,posicionY,largoX,largoY);
        return textField;
    }

    protected JRadioButton generarJRadioButton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JRadioButton boton = new JRadioButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        return boton;
    }

    //Se genera la interaccion con los botones en este metodo
    @Override
    public void actionPerformed(ActionEvent e){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}