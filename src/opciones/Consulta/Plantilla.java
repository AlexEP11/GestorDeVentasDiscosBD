package opciones.Consulta;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
public class Plantilla extends JPanel {
    public Color cremaP = new Color(251, 205, 131);
    //Espacio de la tabla
    public JPanel tabla = new JPanel(null);
    
    //Espacio de los radioButtons
    public JPanel opciones = new JPanel();

    //Entrada
    public JTextField entrada = new JTextField("Buscar",20);

    //Botones
    public JPanel botones = new JPanel();
    public JButton limpiar = new JButton();
    public JButton buscar = new JButton(); 

    public Plantilla(){
        setLayout(null);
        tabla.setBounds(390, 50, 550, 500);
        tabla.setBackground(Color.gray);
        add(tabla);
        opciones.setBounds(40, 50, 320, 350);
        opciones.setBackground(Color.cyan);
        add(opciones);
        entrada.setBounds(40, 430, 320, 30);
        
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
