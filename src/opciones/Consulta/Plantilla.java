package opciones.Consulta;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;
public class Plantilla extends JPanel implements ActionListener {
    //Variables de la conexion
    Connection connection = null; //se almacena la conexion
    Statement statement = null;
    ResultSet resultSet = null;
    String bdname = "GestorVentasDiscos";//nombre  de la base de datos
    String user = "admin";//usuario de la base de datos
    String pass = "123456";//contraseña de usuario
    String sql;
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
    public MyTableModel mtb;

    //Entrada
    public JTextField entrada = new JTextField("Buscar",20);
    public String hover = "Buscar";
    public String atri = "";
    public String tablaN = "";

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
        entrada.setForeground(Color.lightGray);
        entrada.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e){
                if(entrada.getText().equals("")){
                    entrada.setText(hover);
                    entrada.setForeground(Color.lightGray);
                }
            }

            @Override
            public void focusGained(FocusEvent e){
                if(entrada.getText().equals(hover)){
                    entrada.setText("");
                    entrada.setForeground(Color.black);
                }
            }
        });
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
            entrada.setText("Buscar");
            hover = "Buscar";
            entrada.setForeground(Color.gray);
            sql = "Select * from " + tablaN;
        }else if(e.getSource() == buscar){
            sql = "Select * from "+tablaN+" where " + atri + "= '" + entrada.getText() + "'";
        }
    }

    
}
