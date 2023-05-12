package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import opciones.Agregar.AgregarCompra;
import opciones.Agregar.AgregarVenta;
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
    ImageIcon imgAgreg = new ImageIcon("./src/imagenes/agregar.png");
    ImageIcon imgMod = new ImageIcon("./src/imagenes/cambiar.png");
    ImageIcon imgElim = new ImageIcon("./src/imagenes/eliminar.png");

    // Panel principal
    Panel background = new Panel(null);

    // Paneles izquierdo y arriba
    JPanel verticalIzquierda = new JPanel(null);
    JPanel horizontalArriba = new JPanel(null);

    // Panel principal y card layout principal
    JPanel principal = new JPanel(null);
    CardLayout clPrincipal = new CardLayout();
    CardLayout clSecundario = new CardLayout();
    CardLayout clVentas = new CardLayout();
    CardLayout clCompras = new CardLayout();
    CardLayout clDiscos = new CardLayout();
    CardLayout clEmpleado = new CardLayout();
    CardLayout clProveedores = new CardLayout();
    CardLayout clPuestos = new CardLayout();
    CardLayout clDVentas = new CardLayout();
    CardLayout clDCompras = new CardLayout();

    JPanel pVentas = new JPanel();
    JPanel actual = new JPanel();
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
    JPanel botonAgregar = new JPanel(null);
    JPanel botonModificar = new JPanel(null);
    JPanel botonEliminar = new JPanel(null);
    JPanel anterior = new JPanel();
    JPanel anterior2 = new JPanel();

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
    JLabel imgAgregar = new JLabel();
    JLabel txtAgregar = new JLabel("Agregar");
    JLabel imgModificar = new JLabel();
    JLabel txtModificar = new JLabel("Modificar");
    JLabel imgEliminar = new JLabel();
    JLabel txtEliminar = new JLabel("Eliminar");

    JLabel logo = new JLabel();
    JLabel imgSalir = new JLabel();

    // Colores
    Color negroP = new Color(23, 23, 23);
    Color cremaP = new Color(251, 205, 131);
    Color cremaHov = new Color(242, 190, 107);

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

        // Boton Agregar
        botonAgregar.setBackground(cremaP);
        botonAgregar.setBounds(40, 25, 180, 50);
        botonAgregar.addMouseListener(this);
        botonAgregar.setCursor(new Cursor(12));
        imgAgregar.setBounds(10, 0, 50, 50);
        imgAgregar.setIcon(imgAgreg);
        txtAgregar.setForeground(Color.BLACK);
        txtAgregar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtAgregar.setBounds(80, 0, 120, 50);

        // Boton Modificar
        botonModificar.setBackground(cremaP);
        botonModificar.setBounds(300, 25, 180, 50);
        botonModificar.addMouseListener(this);
        botonModificar.setCursor(new Cursor(12));
        imgModificar.setBounds(10, 0, 50, 50);
        imgModificar.setIcon(imgMod);
        txtModificar.setForeground(Color.BLACK);
        txtModificar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtModificar.setBounds(80, 0, 120, 50);

        // Boton Eliminar
        botonEliminar.setBackground(cremaP);
        botonEliminar.setBounds(560, 25, 180, 50);
        botonEliminar.addMouseListener(this);
        botonEliminar.setCursor(new Cursor(12));
        imgEliminar.setBounds(10, 0, 50, 50);
        imgEliminar.setIcon(imgElim);
        txtEliminar.setForeground(Color.BLACK);
        txtEliminar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtEliminar.setBounds(80, 0, 120, 50);

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
        botonEmpleado.setCursor(new Cursor(12));
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
        imgSalir.setIcon(imgS);
        imgSalir.setCursor(new Cursor(12));
        imgSalir.addMouseListener(this);

        ////////////////////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL
        ////////////////////////////////////////////////// /////////////////////////////////////////////////////

        // Añadiendo logo
        verticalIzquierda.add(logo);

        // Añadiendo el boton agregar
        botonAgregar.add(imgAgregar);
        botonAgregar.add(txtAgregar);
        horizontalArriba.add(botonAgregar);

        // Añadiendo el boton modificar
        botonModificar.add(imgModificar);
        botonModificar.add(txtModificar);
        horizontalArriba.add(botonModificar);

        // Añadiendo el boton modificar
        botonEliminar.add(imgEliminar);
        botonEliminar.add(txtEliminar);
        horizontalArriba.add(botonEliminar);

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
        pVentas.setLayout(null);
        pVentas.setBounds(240,100,960, 600);
        principal.add(pVentas, "Ventas");
        actual = pVentas;
        clSecundario = clVentas;
        pCompras.setBounds(240, 100, 960, 600);
        principal.add(pCompras, "Compras");
        pDiscos.setBounds(240, 100, 960, 600);
        principal.add(pDiscos, "Discos");
        pEmpleados.setBounds(240, 100, 960, 600);
        principal.add(pEmpleados, "Empleados");
        pProveedores.setBounds(240, 100, 960, 600);
        principal.add(pProveedores, "Proveedores");
        pPuestos.setBounds(240, 100, 960, 600);
        principal.add(pPuestos, "Puestos");
        pDCompras.setBounds(240, 100, 960, 600);
        principal.add(pDCompras, "DCompras");
        pDVentas.setBounds(240, 100, 960, 600);
        principal.add(pDVentas, "DVentas");
        background.add(principal);
        iniClSecundario();
        anterior2 = botonAgregar;
        // Ajustes necesarios
        setSize(1200, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Metodo de inicializacion de ClSecundario
    public void iniClSecundario() {
        pVentas.setLayout(clVentas);
        pCompras.setLayout(clCompras);
        pDiscos.setLayout(clDiscos);
        pEmpleados.setLayout(clEmpleado);
        pProveedores.setLayout(clProveedores);
        pPuestos.setLayout(clPuestos);
        pDCompras.setLayout(clDCompras);
        pDVentas.setLayout(clDVentas);

        // Aqui colocar los respectivos jPaneles modificados
        // Ventas
        // Consultas
        JPanel cVentas = new ConsultarVenta();
        pVentas.add(cVentas, "Consulta");
        // Agregar
        JPanel aVentas = new AgregarVenta();
        aVentas.add(new JLabel("aVentas"));
        pVentas.add(aVentas, "Agregar");
        // Modificar
        JPanel mVentas = new JPanel();
        mVentas.add(new JLabel("mVentas"));
        pVentas.add(mVentas, "Modificar");
        // Eliminar
        JPanel eVentas = new JPanel();
        eVentas.add(new JLabel("eVentas"));
        pVentas.add(eVentas, "Eliminar");

        // Compras
        // Consultas
        JPanel cCompras = new Plantilla();
        pCompras.add(cCompras, "Consulta");
        // Agregar
        JPanel aCompras = new AgregarCompra();
        aCompras.add(new JLabel("aCompras"));
        pCompras.add(aCompras, "Agregar");
        // Modificar
        JPanel mCompras = new JPanel();
        mCompras.add(new JLabel("mCompras"));
        pCompras.add(mCompras, "Modificar");
        // Eliminar
        JPanel eCompras = new JPanel();
        eCompras.add(new JLabel("eCompras"));
        pCompras.add(eCompras, "Eliminar");

        // Discos
        // Consultas
        JPanel cDiscos = new Plantilla();
        pDiscos.add(cDiscos, "Consulta");
        // Agregar
        JPanel aDiscos = new JPanel();
        aDiscos.add(new JLabel("aDiscos"));
        pDiscos.add(aDiscos, "Agregar");
        // Modificar
        JPanel mDiscos = new JPanel();
        mDiscos.add(new JLabel("mDiscos"));
        pDiscos.add(mDiscos, "Modificar");
        // Eliminar
        JPanel eDiscos = new JPanel();
        eDiscos.add(new JLabel("eDiscos"));
        pDiscos.add(eDiscos, "Eliminar");

        // Empleados
        // Consultas
        JPanel cEmpleados = new Plantilla();
        pEmpleados.add(cEmpleados, "Consulta");
        // Agregar
        JPanel aEmpleados = new JPanel();
        aEmpleados.add(new JLabel("aEmpleados"));
        pEmpleados.add(aEmpleados, "Agregar");
        // Modificar
        JPanel mEmpleados = new JPanel();
        mEmpleados.add(new JLabel("mEmpleados"));
        pEmpleados.add(mEmpleados, "Modificar");
        // Eliminar
        JPanel eEmpleados = new JPanel();
        eEmpleados.add(new JLabel("eEmpleados"));
        pEmpleados.add(eEmpleados, "Eliminar");

        // Proeedores
        // Consultas
        JPanel cProveedores = new Plantilla();
        pProveedores.add(cProveedores, "Consulta");
        // Agregar
        JPanel aProveedores = new JPanel();
        aProveedores.add(new JLabel("aProveedores"));
        pProveedores.add(aProveedores, "Agregar");
        // Modificar
        JPanel mProveedores = new JPanel();
        mProveedores.add(new JLabel("mProveedores"));
        pProveedores.add(mProveedores, "Modificar");
        // Eliminar
        JPanel eProveedores = new JPanel();
        eProveedores.add(new JLabel("eProveedores"));
        pProveedores.add(eProveedores, "Eliminar");

        // Puestos
        // Consultas
        JPanel cPuestos = new Plantilla();
        pPuestos.add(cPuestos, "Consulta");
        // Agregar
        JPanel aPuestos = new JPanel();
        aPuestos.add(new JLabel("aPuestos"));
        pPuestos.add(aPuestos, "Agregar");
        // Modificar
        JPanel mPuestos = new JPanel();
        mPuestos.add(new JLabel("mPuestos"));
        pPuestos.add(mPuestos, "Modificar");
        // Eliminar
        JPanel ePuestos = new JPanel();
        ePuestos.add(new JLabel("ePuestos"));
        pPuestos.add(ePuestos, "Eliminar");

        // DCompras
        // Consultas
        JPanel cDCompras = new Plantilla();
        pDCompras.add(cDCompras, "Consulta");
        // Agregar
        JPanel aDCompras = new JPanel();
        aDCompras.add(new JLabel("aDCompras"));
        pDCompras.add(aDCompras, "Agregar");
        // Modificar
        JPanel mDCompras = new JPanel();
        mDCompras.add(new JLabel("mDCompras"));
        pDCompras.add(mDCompras, "Modificar");
        // Eliminar
        JPanel eDCompras = new JPanel();
        eDCompras.add(new JLabel("eDCompras"));
        pDCompras.add(eDCompras, "Eliminar");

        // DVentas
        // Consultas
        JPanel cDVentas = new Plantilla();
        pDVentas.add(cDVentas, "Consulta");
        // Agregar
        JPanel aDVentas = new JPanel();
        aDVentas.add(new JLabel("aDVentas"));
        pDVentas.add(aDVentas, "Agregar");
        // Modificar
        JPanel mDVentas = new JPanel();
        mDVentas.add(new JLabel("mDVentas"));
        pDVentas.add(mDVentas, "Modificar");
        // Eliminar
        JPanel eDVentas = new JPanel();
        eDVentas.add(new JLabel("eDVentas"));
        pDVentas.add(eDVentas, "Eliminar");
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
            anterior2.setBackground(cremaP);
            if (e.getSource() == botonVentas) {
                botonVentas.setBackground(Color.black);
                anterior = botonVentas;
                actual = pVentas;
                clSecundario = clVentas;
                clPrincipal.show(principal, "Ventas");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonCompras) {
                botonCompras.setBackground(Color.black);
                anterior = botonCompras;
                actual = pCompras;
                clSecundario = clCompras;
                clPrincipal.show(principal, "Compras");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonDiscos) {
                botonDiscos.setBackground(Color.black);
                anterior = botonDiscos;
                actual = pDiscos;
                clSecundario = clDiscos;
                clPrincipal.show(principal, "Discos");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonEmpleado) {
                botonEmpleado.setBackground(Color.black);
                anterior = botonEmpleado;
                actual = pEmpleados;
                clSecundario = clEmpleado;
                clPrincipal.show(principal, "Empleados");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonProveedor) {
                botonProveedor.setBackground(Color.black);
                anterior = botonProveedor;
                actual = pProveedores;
                clSecundario = clProveedores;
                clPrincipal.show(principal, "Proveedores");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonPuestos) {
                botonPuestos.setBackground(Color.black);
                anterior = botonPuestos;
                actual = pPuestos;
                clSecundario = clPuestos;
                clPrincipal.show(principal, "Puestos");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonDetallesCompras) {
                botonDetallesCompras.setBackground(Color.black);
                anterior = botonDetallesCompras;
                actual = pDCompras;
                clSecundario = clDCompras;
                clPrincipal.show(principal, "DCompras");
                clSecundario.show(actual, "Consulta");
            } else if (e.getSource() == botonDetallesVentas) {
                botonDetallesVentas.setBackground(Color.black);
                anterior = botonDetallesVentas;
                actual = pDVentas;
                clSecundario = clDVentas;
                clPrincipal.show(principal, "DVentas");
                clSecundario.show(actual, "Consulta");
            } else {
                anterior.setBackground(Color.black);
                if (e.getSource() == botonAgregar) {
                    clSecundario.show(actual, "Agregar");
                    anterior2 = botonAgregar;
                    botonAgregar.setBackground(cremaHov);
                } else if (e.getSource() == botonModificar) {
                    clSecundario.show(actual, "Modificar");
                    anterior2 = botonModificar;
                    botonModificar.setBackground(cremaHov);
                } else if (e.getSource() == botonEliminar) {
                    clSecundario.show(actual, "Eliminar");
                    anterior2 = botonEliminar;
                    botonEliminar.setBackground(cremaHov);
                }
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
        } else if (e.getSource() == botonAgregar) {
            botonAgregar.setBackground(cremaHov);
        } else if (e.getSource() == botonModificar) {
            botonModificar.setBackground(cremaHov);
        } else if (e.getSource() == botonEliminar) {
            botonEliminar.setBackground(cremaHov);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == anterior || e.getSource() == anterior2) {
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
        } else if (e.getSource() == botonAgregar) {
            botonAgregar.setBackground(cremaP);
        } else if (e.getSource() == botonModificar) {
            botonModificar.setBackground(cremaP);
        } else if (e.getSource() == botonEliminar) {
            botonEliminar.setBackground(cremaP);
        }
    }

    public static void main(String[] args) {
        new Inicio();
    }
}