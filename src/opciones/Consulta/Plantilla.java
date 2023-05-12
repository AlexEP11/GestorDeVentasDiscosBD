package opciones.Consulta;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
public class Plantilla extends JPanel {
    public Color cremaP = new Color(251, 205, 131);
    //Espacio de la tabla
    public JPanel tabla = new JPanel(null);
    public JTable table;
    
    //Espacio de los radioButtons
    public JPanel opciones = new JPanel();
    public ButtonGroup grupo = new ButtonGroup();

    //Entrada
    public JTextField entrada = new JTextField("Buscar",20);

    //Botones
    public JPanel botones = new JPanel();
    public JButton limpiar = new JButton();
    public JButton buscar = new JButton(); 

    public Plantilla(){
        setLayout(null);
        tabla.setBounds(390, 50, 550, 500);
        tabla.setLayout(null);
        add(tabla);
        opciones.setBounds(40, 50, 320, 350);
        add(opciones);
        entrada.setBounds(40, 430, 320, 30);
        entrada.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        add(entrada);
        botones.setLayout(new GridLayout(1, 2, 50, 0));
        botones.setBounds(100, 500, 180, 60);
        botones.add(limpiar);
        botones.add(buscar);
        add(botones);
        limpiar.setBackground(cremaP);
        buscar.setBackground(cremaP);
        setBounds(0,0,960, 600);
        setVisible(true);
    }

}
