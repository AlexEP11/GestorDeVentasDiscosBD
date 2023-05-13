package opciones.Consulta;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Plantilla extends JPanel implements ActionListener {
    //Colores
    public Color cremaP = new Color(251, 205, 131);

    //Espacio de la tabla
    public JPanel tabla = new JPanel(null);
    
    //Imagenes
    ImageIcon buscarImg = new ImageIcon("./src/imagenes/consultar.png");
    ImageIcon limpiarImg = new ImageIcon("./src/imagenes/limpiar.png");

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
        setBackground(Color.white);
        //Area de la tabla
        setLayout(null);
        tabla.setBounds(390, 50, 550, 500);
        tabla.setLayout(null);
        add(tabla);

        //Area de las opciones
        opciones.setBounds(80, 50, 260, 250);
        add(opciones);
        entrada.setBounds(65, 350, 250, 30);
        entrada.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        entrada.setHorizontalAlignment(SwingConstants.CENTER);
        opciones.setBackground(Color.white);
        add(entrada);

        //Area de los botones
        botones.setLayout(new GridLayout(1, 2, 50, 0));
        botones.setBounds(100, 420, 180, 60);
        botones.setBackground(Color.white);
        limpiar.setIcon(limpiarImg);
        buscar.setIcon(buscarImg);
        botones.add(limpiar);
        botones.add(buscar);
        add(botones);
        limpiar.setBackground(cremaP);
        buscar.setBackground(cremaP);
        
        //Configuraciones por defecto
        setBounds(0,0,960, 600);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == limpiar){
            grupo.clearSelection();
        }
    }

}
