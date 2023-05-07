package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class Inicio extends JFrame implements MouseListener {
    // Imagenes
    ImageIcon imgL = new ImageIcon("./src/imagenes/DiscoPeque.png");
    ImageIcon imgV = new ImageIcon("./src/imagenes/vender.png"); // 45 x 45
    ImageIcon imgC = new ImageIcon("./src/imagenes/comprar.png"); 
    ImageIcon imgD = new ImageIcon("./src/imagenes/disco.png"); 
    ImageIcon imgE = new ImageIcon("./src/imagenes/empleado.png"); 
    ImageIcon imgP = new ImageIcon("./src/imagenes/proveedor.png");
    ImageIcon imgS = new ImageIcon("./src/imagenes/salir.png");
    
    // Panel principal
    Panel background = new Panel(null);

    // Paneles izquierdo y arriba
    JPanel verticalIzquierda = new JPanel(null);
    JPanel horizontalArriba = new JPanel(null);

    // Paneles botones
    JPanel botonVentas = new JPanel(null);
    JPanel botonCompras = new JPanel(null);
    JPanel botonDiscos = new JPanel(null);
    JPanel botonEmpleado = new JPanel(null);
    JPanel botonProveedor = new JPanel(null);

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
        logo.setBounds(80,10,80,80);
        logo.setIcon(imgL);
        logo.setCursor(new Cursor(HAND_CURSOR));
        logo.setToolTipText("Cerrar sesion");
        logo.addMouseListener(this);

        // Bara crema superior
        horizontalArriba.setBackground(cremaP);
        horizontalArriba.setBounds(240, 0, 1000, 100);

        // Boton ventas
        botonVentas.setBackground(negroP);
        botonVentas.setBounds(0, 100, 240, 50);
        botonVentas.addMouseListener(this);
        botonVentas.setCursor(new Cursor(HAND_CURSOR));
        imgVentas.setBounds(0,0,50,50);
        imgVentas.setIcon(imgV);
        txtVentas.setForeground(Color.WHITE);
        txtVentas.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtVentas.setBounds(70, 0, 180, 50);

        // Boton compras
        botonCompras.setBackground(negroP);
        botonCompras.setBounds(0, 180, 240, 50);
        botonCompras.addMouseListener(this);
        botonCompras.setCursor(new Cursor(HAND_CURSOR));
        imgCompras.setBounds(5,0,50,50);
        imgCompras.setIcon(imgC);
        txtCompras.setForeground(Color.WHITE);
        txtCompras.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtCompras.setBounds(70, 0, 180, 50);

        // Boton discos
        botonDiscos.setBackground(negroP);
        botonDiscos.setBounds(0, 260, 240, 50);
        botonDiscos.addMouseListener(this);
        botonDiscos.setCursor(new Cursor(HAND_CURSOR));
        imgDiscos.setBounds(5,0,50,50);
        imgDiscos.setIcon(imgD);
        txtDiscos.setForeground(Color.WHITE);
        txtDiscos.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtDiscos.setBounds(70, 0, 180,50);

        // Boton empleado
        botonEmpleado.setBackground(negroP);
        botonEmpleado.setBounds(0, 340, 240, 50);
        botonEmpleado.addMouseListener(this);
        botonEmpleado.setCursor(new Cursor(HAND_CURSOR));
        imgEmpleado.setBounds(5,0,50,50);
        imgEmpleado.setIcon(imgE);
        txtEmpleado.setForeground(Color.WHITE);
        txtEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtEmpleado.setBounds(70, 0, 180,50);

        // Boton proveedor
        botonProveedor.setBackground(negroP);
        botonProveedor.setBounds(0, 420, 240, 50);
        botonProveedor.addMouseListener(this);
        botonProveedor.setCursor(new Cursor(HAND_CURSOR));
        imgProveedor.setBounds(5,0,50,50);
        imgProveedor.setIcon(imgP);
        txtProveedor.setForeground(Color.WHITE);
        txtProveedor.setFont(new Font("Roboto Black", Font.BOLD, 15));
        txtProveedor.setBounds(70, 0, 180,50);

        // Boton salir
        imgSalir.setBounds(170,640,45,45);
        imgSalir.setIcon(imgS);
        imgSalir.setCursor(new Cursor(HAND_CURSOR));
        imgSalir.addMouseListener(this);


        // Añadiendo logo
        verticalIzquierda.add(logo);

        // Añadiendo el boton salir
        verticalIzquierda.add(imgSalir);

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

        // Añadiendo el menu izquierdo y borde superior
        background.add(horizontalArriba);
        background.add(verticalIzquierda);

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
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
        }
    }

    public static void main(String[] args) {
        new Inicio();
    }
}