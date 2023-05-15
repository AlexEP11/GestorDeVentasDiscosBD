package opciones.Modificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModificarPuesto extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente Nombre P.
    JLabel txtNombreP = new JLabel("Nombre P.");
    JTextField nombreP = new JTextField();

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente Salario
    JLabel txtSalario = new JLabel("Salario");
    JTextField salario = new JTextField();

    // Boton Guardar
    JPanel guardar = new JPanel(null);
    JLabel txtGuardar = new JLabel("Guardar");
    JLabel imgGuardar = new JLabel();
    ImageIcon discoGuardar = new ImageIcon("./src/imagenes/discoAgregar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");

    public ModificarPuesto() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Nombre P.
        txtNombreP.setBounds(20, 60, 120, 20);
        txtNombreP.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nombreP.setBounds(130, 57, 270, 25);
        nombreP.setForeground(Color.GRAY);
        nombreP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(440,40,60,60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Salario
        txtSalario.setBounds(30, 150, 120, 20);
        txtSalario.setFont(new Font("Roboto Black", Font.BOLD, 16));
        salario.setBounds(130, 147, 270, 25);
        salario.setForeground(Color.GRAY);
        salario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));


        // Campo boton Guardar
        guardar.setBackground(cremaHov);
        guardar.setBounds(780, 510, 160, 60);
        guardar.addMouseListener(this);
        guardar.setCursor(new Cursor(12));
        imgGuardar.setBounds(10, 5, 50, 50);
        imgGuardar.setIcon(discoGuardar);
        txtGuardar.setForeground(Color.BLACK);
        txtGuardar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtGuardar.setBounds(70, 5, 120, 50);

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

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Salario
        add(salario);
        add(txtSalario);

        // Añadiendo el boton Guardar (disquito)
        guardar.add(imgGuardar);
        guardar.add(txtGuardar);
        add(guardar);

        // Añadiendo el boton Cancelar
        cancelar.add(imgCancelar);
        cancelar.add(txtCancelar);
        add(cancelar);

        setBounds(0, 0, 960, 600);
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
