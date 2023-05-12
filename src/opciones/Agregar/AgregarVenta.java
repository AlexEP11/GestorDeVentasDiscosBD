package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgregarVenta extends JPanel implements MouseListener{ 

    // Componentes id Empleado
    JLabel txtIdEmpleado = new JLabel("Id Empleado");
    JTextField idEmpleado = new JTextField();

    // Componente Fecha
    JLabel txtFecha = new JLabel("Fecha");
    JTextField fecha = new JTextField();

    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco");
    JTextField idDisco = new JTextField();

    // Componente Cantidad
    JLabel txtCantidad = new JLabel("Cantidad");
    JTextField cantidad = new JTextField();


    public AgregarVenta() {  
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Empleado
        txtIdEmpleado.setBounds(25, 60, 120, 20);
        txtIdEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idEmpleado.setBounds(135,57,270,25);
        idEmpleado.setForeground(Color.GRAY);
        idEmpleado.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        idEmpleado.setAlignmentX(15);

        // Campo Fecha
        txtFecha.setBounds(500, 60, 120, 20);
        txtFecha.setFont(new Font("Roboto Black", Font.BOLD, 16));
        fecha.setBounds(575,57,270,25);
        fecha.setForeground(Color.GRAY);
        fecha.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        fecha.setHorizontalAlignment(JTextField.CENTER);

        // Campo Id Disco
        txtIdDisco.setBounds(40, 200, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(135,197,270,25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        idDisco.setHorizontalAlignment(JTextField.CENTER);

        // Campo Cantidad
        txtCantidad.setBounds(40, 340, 120, 20);
        txtCantidad.setFont(new Font("Roboto Black", Font.BOLD, 16));
        cantidad.setBounds(135,337,270,25);
        cantidad.setForeground(Color.GRAY);
        cantidad.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        cantidad.setHorizontalAlignment(JTextField.CENTER);

        
        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL //////////////////////////////////////////////

        // Añadiendo el campo id Empleado
        add(idEmpleado);
        add(txtIdEmpleado);

        // Añadiendo el campo Fecha
        add(fecha);
        add(txtFecha);

        // Añadiendo el campo id Disco
        add(idDisco);
        add(txtIdDisco);

        // Añadiendo el campo cantidad
        add(cantidad);
        add(txtCantidad);

        setBounds(0,0,960,600);
        setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
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
