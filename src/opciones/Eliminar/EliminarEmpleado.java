package opciones.Eliminar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EliminarEmpleado extends JPanel implements MouseListener {
    Color cremaHov = new Color(242, 190, 107);

    // Componente id Empleado
    JLabel txtIdEmpleado = new JLabel("Id Empleado");
    JTextField idEmpleado = new JTextField();

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente Nombre
    JLabel txtNombre = new JLabel("Nombre");
    JTextField nombre = new JTextField();

    // Componente Apellido P.
    JLabel txtApellidoP = new JLabel("Apellido P.");
    JTextField apellidoP = new JTextField();

    // Componente Apellido M.
    JLabel txtApellidoM = new JLabel("Apellido M.");
    JTextField apellidoM = new JTextField();

    // Componente id Puesto
    JLabel txtIdPuesto = new JLabel("Id Puesto");
    JTextField idPuesto = new JTextField();

    // Componente Tel. F.
    JLabel txtTelF = new JLabel("Tel. F.");
    JTextField telF = new JTextField();

    // Componente Tel. C.
    JLabel txtTelC = new JLabel("Tel. C.");
    JTextField telC = new JTextField();

    // Componente Turno
    JLabel txtTurno = new JLabel("Turno");
    JTextField turno = new JTextField();

    // Boton Eliminar
    JPanel eliminar = new JPanel(null);
    JLabel txtEliminar = new JLabel("Eliminar");
    JLabel imgEliminar = new JLabel();
    ImageIcon iconoEliminar = new ImageIcon("./src/imagenes/borrar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");

    public EliminarEmpleado() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Empleado
        txtIdEmpleado.setBounds(20, 60, 120, 20);
        txtIdEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idEmpleado.setBounds(130, 57, 270, 25);
        idEmpleado.setForeground(Color.GRAY);
        idEmpleado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(430, 40, 60, 60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Id Puesto
        txtIdPuesto.setBounds(20, 150, 120, 20);
        txtIdPuesto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idPuesto.setBounds(130, 147, 270, 25);
        idPuesto.setForeground(Color.GRAY);
        idPuesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        idPuesto.setEditable(false);

        // Campo Nombre
        txtNombre.setBounds(20, 240, 120, 20);
        txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nombre.setBounds(130, 237, 270, 25);
        nombre.setForeground(Color.GRAY);
        nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        nombre.setEditable(false);

        // Campo Apellido P.
        txtApellidoP.setBounds(20, 330, 120, 20);
        txtApellidoP.setFont(new Font("Roboto Black", Font.BOLD, 16));
        apellidoP.setBounds(130, 327, 270, 25);
        apellidoP.setForeground(Color.GRAY);
        apellidoP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        apellidoP.setEditable(false);

        // Campo Apellido M.
        txtApellidoM.setBounds(20, 420, 120, 20);
        txtApellidoM.setFont(new Font("Roboto Black", Font.BOLD, 16));
        apellidoM.setBounds(130, 417, 270, 25);
        apellidoM.setForeground(Color.GRAY);
        apellidoM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        apellidoM.setEditable(false);

        // Campo Tel. F.
        txtTelF.setBounds(520, 150, 120, 20);
        txtTelF.setFont(new Font("Roboto Black", Font.BOLD, 16));
        telF.setBounds(630, 147, 270, 25);
        telF.setForeground(Color.GRAY);
        telF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        telF.setEditable(false);

        // Campo Tel. C.
        txtTelC.setBounds(520, 240, 120, 20);
        txtTelC.setFont(new Font("Roboto Black", Font.BOLD, 16));
        telC.setBounds(630, 237, 270, 25);
        telC.setForeground(Color.GRAY);
        telC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        telC.setEditable(false);

        // Campo Turno
        txtTurno.setBounds(520, 330, 120, 20);
        txtTurno.setFont(new Font("Roboto Black", Font.BOLD, 16));
        turno.setBounds(630, 327, 270, 25);
        turno.setForeground(Color.GRAY);
        turno.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        turno.setEditable(false);

        // Campo boton Eliminar
        eliminar.setBackground(cremaHov);
        eliminar.setBounds(780, 510, 160, 60);
        eliminar.addMouseListener(this);
        eliminar.setCursor(new Cursor(12));
        imgEliminar.setBounds(10, 5, 50, 50);
        imgEliminar.setIcon(iconoEliminar);
        txtEliminar.setForeground(Color.BLACK);
        txtEliminar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtEliminar.setBounds(70, 5, 120, 50);

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

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL //////////////////////////////////// 

        // Añadiendo el campo id Disco
        add(idEmpleado);
        add(txtIdEmpleado);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Nombre
        add(nombre);
        add(txtNombre);

        // Añadiendo el campo Apellido P.
        add(apellidoP);
        add(txtApellidoP);

        // Añadiendo el campo Apellido M.
        add(apellidoM);
        add(txtApellidoM);

        // Añadiendo el campo id Puesto
        add(idPuesto);
        add(txtIdPuesto);

        // Añadiendo el campo Tel. F.
        add(telF);
        add(txtTelF);

        // Añadiendo el campo Tel. C.
        add(telC);
        add(txtTelC);

        // Añadiendo el campo Turno
        add(turno);
        add(txtTurno);

        // Añadiendo el boton Eliminar
        eliminar.add(imgEliminar);
        eliminar.add(txtEliminar);
        add(eliminar);

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
