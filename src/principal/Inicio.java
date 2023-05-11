package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import opciones.Consulta.*;

public class Inicio extends JFrame implements MouseListener {
    // Imagenes
    ImageIcon imgL = new ImageIcon("./src/imagenes/DiscoPeque.png");
    ImageIcon imgV = new ImageIcon("./src/imagenes/vender.png"); // 45 x 45
    ImageIcon imgC = new ImageIcon("./src/imagenes/comprar.png");
    ImageIcon imgD = new ImageIcon("./src/imagenes/disco.png");
    ImageIcon imgE = new ImageIcon("./src/imagenes/empleado.png");
    ImageIcon imgP = new ImageIcon("./src/imagenes/proveedor.png");
    ImageIcon imgPues = new ImageIcon("./src/imagenes/puesto.png");
    ImageIcon imgDetC = new ImageIcon("./src/imagenes/detallesCom.png");
    ImageIcon imgDetV = new ImageIcon("./src/imagenes/detallesVent.png");
    ImageIcon imgS = new ImageIcon("./src/imagenes/salir.png");

    // Panel principal
    Panel background = new Panel(null);

    // Paneles izquierdo y arriba
    JPanel verticalIzquierda = new JPanel(null);
    JPanel horizontalArriba = new JPanel(null);

    // Panel principal y card layout principal
    JPanel principal = new JPanel(null);
    CardLayout clPrincipal = new CardLayout();
    JPanel pVentas = new JPanel();
    JPanel pCompras = new JPanel();
    JPanel pDiscos = new JPanel();
    JPanel pEmpleados = new JPanel();
    JPanel pProveedores = new JPanel();
    JPanel pPuestos = new JPanel();
    JPanel pDVentas = new JPanel();
    JPanel pDCompras = new JPanel();

    // Paneles botones
    JPanel botonVentas = new JPanel(null);
    JPanel botonCompras = new JPanel(null);
    JPanel botonDiscos = new JPanel(null);
    JPanel botonEmpleado = new JPanel(null);
    JPanel botonProveedor = new JPanel(null);
    JPanel botonPuestos = new JPanel(null);
    JPanel botonDetallesCompras = new JPanel(null);
    JPanel botonDetallesVentas = new JPanel(null);
    JPanel anterior = new JPanel();

    // JLabels de botones/imagenes
    JLabel imgVentas = new JLabel();
    JLabel txtVentas = new JLabel("Gestionar Ventas");
    JLabel imgCompras = new JLabel();
    JLabel txtCompras = new JLabel("Gestionar Compras");
    JLabel imgDiscos = new JLabel();
    JLabel txtDiscos = new JLabel("Gestionar Discos");
    JLabel imgEmpleado = new JLabel();
    JLabel txtEmpleado = new JLabel("Gestionar Empleados");
    JLabel imgProveedor = new JLabel();
    JLabel txtProveedor = new JLabel("Gestionar Proveedores");
    JLabel imgPuestos = new JLabel();
    JLabel txtPuetos = new JLabel("Gestionar Puestos");
    JLabel imgDetallesCompras = new JLabel();
    JLabel txtDetallesCompras = new JLabel("Detalles Compras");
    JLabel imgDetallesVentas = new JLabel();
    JLabel txtDetallesVentas = new JLabel("Detalles Ventas");

    JLabel logo = new JLabel();
    JLabel imgSalir = new JLabel();

    // Colores
    Color negroP = new Color(23, 23, 23);
    Color cremaP = new Color(251, 205, 131);

    public Inicio() {

        setIconImage(new ImageIcon("./src/imagenes/DiscoLogo.png").getImage());
        this.setUndecorated(true);
        background.setBackground(Color.WHITE);
        add(background);

        // Barra negra con logo
        verticalIzquierda.setBackground(negroP);
        verticalIzquierda.setBounds(0, 0, 240, 700);
        logo.setBounds(80, 10, 80, 80);
        logo.setIcon(imgL);
        logo.setCursor(new Cursor(12));
        logo.setToolTipText("Cerrar sesion");
        logo.addMouseListener(this);

        // Bara crema superior
        horizontalArriba.setBackground(cremaP);
        horizontalArriba.setBounds(240, 0, 1000, 100);

        // Boton ventas
        botonVentas.setBackground(Color.black);
        botonVentas.setBounds(0, 100, 240, 50);
        botonVentas.addMouseListener(this);
        botonVentas.setCursor(new Cursor(12));
        imgVentas.setBounds(0, 0, 50, 50);
        imgVentas.setIcon(imgV);
        txtVentas.setForeground(Color.WHITE);
        txtVentas.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtVentas.setBounds(70, 0, 180, 50);
        anterior = botonVentas;

        // Boton compras
        botonCompras.setBackground(negroP);
        botonCompras.setBounds(0, 180, 240, 50);
        botonCompras.addMouseListener(this);
        botonCompras.setCursor(new Cursor(12));
        imgCompras.setBounds(5, 0, 50, 50);
        imgCompras.setIcon(imgC);
        txtCompras.setForeground(Color.WHITE);
        txtCompras.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtCompras.setBounds(70, 0, 180, 50);

        // Boton discosz
        botonDiscos.setBackground(negroP);
        botonDiscos.setBounds(0, 260, 240, 50);
        botonDiscos.addMouseListener(this);
        botonDiscos.setCursor(new Cursor(12));
        imgDiscos.setBounds(5, 0, 50, 50);
        imgDiscos.setIcon(imgD);
        txtDiscos.setForeground(Color.WHITE);
        txtDiscos.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtDiscos.setBounds(70, 0, 180, 50);

        // Boton empleado
        botonEmpleado.setBackground(negroP);
        botonEmpleado.setBounds(0, 340, 240, 50);
        botonEmpleado.addMouseListener(this);
        botonEmpleado.setCursor(new Cursor(12));
        botonEmpleado.setCursor(new Cursor(HAND_CURSOR));
        imgEmpleado.setBounds(5, 0, 50, 50);
        imgEmpleado.setIcon(imgE);
        txtEmpleado.setForeground(Color.WHITE);
        txtEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtEmpleado.setBounds(70, 0, 180, 50);

        // Boton proveedor
        botonProveedor.setBackground(negroP);
        botonProveedor.setBounds(0, 420, 240, 50);
        botonProveedor.addMouseListener(this);
        botonProveedor.setCursor(new Cursor(12));
        imgProveedor.setBounds(5, 0, 50, 50);
        imgProveedor.setIcon(imgP);
        txtProveedor.setForeground(Color.WHITE);
        txtProveedor.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtProveedor.setBounds(70, 0, 180, 50);

        // Boton puestos
        botonPuestos.setBackground(negroP);
        botonPuestos.setBounds(0, 500, 240, 50);
        botonPuestos.addMouseListener(this);
        botonPuestos.setCursor(new Cursor(12));
        imgPuestos.setBounds(5, 0, 50, 50);
        imgPuestos.setIcon(imgPues);
        txtPuetos.setForeground(Color.WHITE);
        txtPuetos.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtPuetos.setBounds(70, 0, 180, 50);

        // Boton detalles compras
        botonDetallesCompras.setBackground(negroP);
        botonDetallesCompras.setBounds(0, 580, 240, 50);
        botonDetallesCompras.addMouseListener(this);
        botonDetallesCompras.setCursor(new Cursor(12));
        imgDetallesCompras.setBounds(5, 0, 50, 50);
        imgDetallesCompras.setIcon(imgDetC);
        txtDetallesCompras.setForeground(Color.WHITE);
        txtDetallesCompras.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtDetallesCompras.setBounds(70, 0, 180, 50);

        // Boton detalles ventas
        botonDetallesVentas.setBackground(negroP);
        botonDetallesVentas.setBounds(0, 655, 240, 50);
        botonDetallesVentas.addMouseListener(this);
        botonDetallesVentas.setCursor(new Cursor(12));
        imgDetallesVentas.setBounds(5, 0, 50, 50);
        imgDetallesVentas.setIcon(imgDetV);
        txtDetallesVentas.setForeground(Color.WHITE);
        txtDetallesVentas.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtDetallesVentas.setBounds(70, 0, 180, 50);

        // Boton salir
        imgSalir.setBounds(850, 25, 45, 45);

        // Boton salir
        imgSalir.setBounds(850, 25, 45, 45);
        imgSalir.setIcon(imgS);
        imgSalir.setCursor(new Cursor(12));
        imgSalir.addMouseListener(this);

        // Añadiendo logo
        verticalIzquierda.add(logo);

        // Añadiendo el boton salir
        horizontalArriba.add(imgSalir);

        // Añadiendo el boton de ventas
        botonVentas.add(imgVentas);
        botonVentas.add(txtVentas);
        verticalIzquierda.add(botonVentas);

        // Añadiendo el boton de compras
        botonCompras.add(imgCompras);
        botonCompras.add(txtCompras);
        verticalIzquierda.add(botonCompras);

        // Añadiendo el boton disco
        botonDiscos.add(imgDiscos);
        botonDiscos.add(txtDiscos);
        verticalIzquierda.add(botonDiscos);

        // Añadiendo el boton empleado
        botonEmpleado.add(imgEmpleado);
        botonEmpleado.add(txtEmpleado);
        verticalIzquierda.add(botonEmpleado);

        // Añadiendo el boton proveedor
        botonProveedor.add(imgProveedor);
        botonProveedor.add(txtProveedor);
        verticalIzquierda.add(botonProveedor);

        // Añadiendo el boton puestos
        botonPuestos.add(imgPuestos);
        botonPuestos.add(txtPuetos);
        verticalIzquierda.add(botonPuestos);

        // Añadiendo el boton detalles compras
        botonDetallesCompras.add(imgDetallesCompras);
        botonDetallesCompras.add(txtDetallesCompras);
        verticalIzquierda.add(botonDetallesCompras);

        // Añadiendo el boton detalles ventas
        botonDetallesVentas.add(imgDetallesVentas);
        botonDetallesVentas.add(txtDetallesVentas);
        verticalIzquierda.add(botonDetallesVentas);

        // Añadiendo el menu izquierdo y borde superior
        background.add(horizontalArriba);
        background.add(verticalIzquierda);

        // Principal
        principal.setBounds(240, 100, 960, 600);
        principal.setLayout(clPrincipal);
        // Agregar los paneles correspondientes
        JPanel a = new Plantilla();
        pVentas.setLayout(null);
        pVentas.setBounds(240,100,960, 600);
        pVentas.add(a);
        principal.add(pVentas, "Ventas");
        pCompras.add(new JLabel("Compras"));
        principal.add(pCompras, "Compras");
        pDiscos.add(new JLabel("Discos"));
        principal.add(pDiscos, "Discos");
        pEmpleados.add(new JLabel("Empleados"));
        principal.add(pEmpleados, "Empleados");
        pProveedores.add(new JLabel("Proveedores"));
        principal.add(pProveedores, "Proveedores");
        pPuestos.add(new JLabel("Puestos"));
        principal.add(pPuestos, "Puestos");
        pDCompras.add(new JLabel("Detalles compras"));
        principal.add(pDCompras, "DCompras");
        pDVentas.add(new JLabel("Detalles ventas"));
        principal.add(pDVentas, "DVentas");
        background.add(principal);

        // Ajustes necesarios
        setSize(1200, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == logo) {
            new Login();
            dispose();
        } else if (e.getSource() == imgSalir) {
            System.exit(0);
        } else {
            anterior.setBackground(negroP);
            if (e.getSource() == botonVentas) {
                botonVentas.setBackground(Color.black);
                anterior = botonVentas;
                clPrincipal.show(principal, "Ventas");
            } else if (e.getSource() == botonCompras) {
                botonCompras.setBackground(Color.black);
                anterior = botonCompras;
                clPrincipal.show(principal, "Compras");
            } else if (e.getSource() == botonDiscos) {
                botonDiscos.setBackground(Color.black);
                anterior = botonDiscos;
                clPrincipal.show(principal, "Discos");
            } else if (e.getSource() == botonEmpleado) {
                botonEmpleado.setBackground(Color.black);
                anterior = botonEmpleado;
                clPrincipal.show(principal, "Empleados");
            } else if (e.getSource() == botonProveedor) {
                botonProveedor.setBackground(Color.black);
                anterior = botonProveedor;
                clPrincipal.show(principal, "Proveedores");
            }else if (e.getSource() == botonPuestos) {
                clPrincipal.show(principal, "Puestos");
            } else if (e.getSource() == botonDetallesCompras) {
                clPrincipal.show(principal, "DCompras");
            } else if (e.getSource() == botonDetallesVentas) {
                clPrincipal.show(principal, "DVentas");
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
        if (e.getSource() == botonVentas) {
            botonVentas.setBackground(Color.BLACK);
        } else if (e.getSource() == botonCompras) {
            botonCompras.setBackground(Color.BLACK);
        } else if (e.getSource() == botonDiscos) {
            botonDiscos.setBackground(Color.BLACK);
        } else if (e.getSource() == botonEmpleado) {
            botonEmpleado.setBackground(Color.BLACK);
        } else if (e.getSource() == botonProveedor) {
            botonProveedor.setBackground(Color.BLACK);
        } else if (e.getSource() == botonPuestos) {
            botonPuestos.setBackground(Color.BLACK);
        } else if (e.getSource() == botonDetallesCompras) {
            botonDetallesCompras.setBackground(Color.BLACK);
        } else if (e.getSource() == botonDetallesVentas) {
            botonDetallesVentas.setBackground(Color.BLACK);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == anterior){
            return;
        }
        if (e.getSource() == botonVentas) {
            botonVentas.setBackground(negroP);
        } else if (e.getSource() == botonCompras) {
            botonCompras.setBackground(negroP);
        } else if (e.getSource() == botonDiscos) {
            botonDiscos.setBackground(negroP);
        } else if (e.getSource() == botonEmpleado) {
            botonEmpleado.setBackground(negroP);
        } else if (e.getSource() == botonProveedor) {
            botonProveedor.setBackground(negroP);
        } else if (e.getSource() == botonPuestos) {
            botonPuestos.setBackground(negroP);
        } else if (e.getSource() == botonDetallesCompras) {
            botonDetallesCompras.setBackground(negroP);
        } else if (e.getSource() == botonDetallesVentas) {
            botonDetallesVentas.setBackground(negroP);
        }
    }

    public static void main(String[] args) {
        new Inicio();
    }
}