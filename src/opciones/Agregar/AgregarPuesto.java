package opciones.Agregar;

import javax.swing.*;

import principal.Login;
import principal.SQLDatabaseConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AgregarPuesto extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente Nombre P.
    JLabel txtNombreP = new JLabel("Nombre P.");
    JTextField nombreP = new JTextField();

    // Componente Salario
    JLabel txtSalario = new JLabel("Salario");
    JTextField salario = new JTextField();

    // Boton Agregar
    JPanel agregar = new JPanel(null);
    JLabel txtAgregar = new JLabel("Agregar");
    JLabel imgAgregar = new JLabel();
    ImageIcon discoAgregar = new ImageIcon("./src/imagenes/discoAgregar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");

    public AgregarPuesto() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Nombre P.
        txtNombreP.setBounds(20, 60, 120, 20);
        txtNombreP.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nombreP.setBounds(130, 57, 270, 25);
        nombreP.setForeground(Color.GRAY);
        nombreP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Salario
        txtSalario.setBounds(30, 150, 120, 20);
        txtSalario.setFont(new Font("Roboto Black", Font.BOLD, 16));
        salario.setBounds(130, 147, 270, 25);
        salario.setForeground(Color.GRAY);
        salario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));


        // Campo boton Agregar
        agregar.setBackground(cremaHov);
        agregar.setBounds(780, 510, 160, 60);
        agregar.addMouseListener(this);
        agregar.setCursor(new Cursor(12));
        imgAgregar.setBounds(10, 5, 50, 50);
        imgAgregar.setIcon(discoAgregar);
        txtAgregar.setForeground(Color.BLACK);
        txtAgregar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtAgregar.setBounds(70, 5, 120, 50);

        // Campo boton Cancelar
        cancelar.setBackground(cremaHov);
        cancelar.setBounds(600, 510, 160, 60);
        cancelar.addMouseListener(this);
        cancelar.setCursor(new Cursor(12));
        imgCancelar.setBounds(10, 5, 50, 50);
        imgCancelar.setIcon(equisCancelar);
        txtCancelar.setForeground(Color.BLACK);
        txtCancelar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtCancelar.setBounds(70, 5, 120, 50);

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL ///////////////////////////////////////////////////////////////////

        // Añadiendo el campo Nombre P.
        add(nombreP);
        add(txtNombreP);

        // Añadiendo el campo Salario
        add(salario);
        add(txtSalario);

        // Añadiendo el boton Agregar (disquito)
        agregar.add(imgAgregar);
        agregar.add(txtAgregar);
        add(agregar);

        // Añadiendo el boton Cancelar
        cancelar.add(imgCancelar);
        cancelar.add(txtCancelar);
        add(cancelar);

        setBounds(0, 0, 960, 600);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == agregar) {
            String Agregar = "INSERT INTO Puestos (NPuesto, Salario) VALUES (?, ?)";
            try {
                PreparedStatement statement = SQLDatabaseConnection.connection.prepareStatement(Agregar);
                statement.setString(1, nombreP.getText());
                statement.setFloat(2, Float.parseFloat(salario.getText()));

                int pene = statement.executeUpdate();
                if (pene > 0) {
                    System.out.println("Pene jalo");
                }
            } catch (Exception s) {
                System.out.println("No jalo " + s.getMessage());
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
