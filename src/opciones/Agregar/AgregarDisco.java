package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgregarDisco extends JPanel implements MouseListener{ 
    // Colores
    Color cremaHov = new Color(242,190,107);

    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco");
    JTextField idDisco = new JTextField();

    // Componente Nom. Album
    JLabel txtNomAlbum = new JLabel("Nom. Album");
    JTextField nomAlbum = new JTextField();

    // Componente Existencia
    JLabel txtExistencia = new JLabel("Existencia");
    JTextField existencia = new JTextField();

    // Componente Genero
    JLabel txtGenero = new JLabel("Genero");
    JTextField genero = new JTextField();

    // Componente Artista
    JLabel txtArtista = new JLabel("Artista");
    JTextField artista = new JTextField();

    // Componente Costo
    JLabel txtCosto = new JLabel("Costo");
    JTextField costo = new JTextField();

    // Componente Formato
    JLabel txtFormato = new JLabel("Formato");
    JTextField formato = new JTextField();

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


    public AgregarDisco() {  
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Disco
        txtIdDisco.setBounds(270, 60, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(350,57,270,25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

        // Campo Nom. Album
        txtNomAlbum.setBounds(20, 150, 120, 20);
        txtNomAlbum.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nomAlbum.setBounds(130,147,270,25);
        nomAlbum.setForeground(Color.GRAY);
        nomAlbum.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));


        // Campo boton Agregar
        agregar.setBackground(cremaHov);
        agregar.setBounds(780,510,160,60);
        agregar.addMouseListener(this);
        agregar.setCursor(new Cursor(12));
        imgAgregar.setBounds(10,5,50,50);
        imgAgregar.setIcon(discoAgregar);
        txtAgregar.setForeground(Color.BLACK);
        txtAgregar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtAgregar.setBounds(70,5,120,50);


        // Campo boton Cancelar
        cancelar.setBackground(cremaHov);
        cancelar.setBounds(600,510,160,60);
        cancelar.addMouseListener(this);
        cancelar.setCursor(new Cursor(12));
        imgCancelar.setBounds(10,5,50,50);
        imgCancelar.setIcon(equisCancelar);
        txtCancelar.setForeground(Color.BLACK);
        txtCancelar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtCancelar.setBounds(70,5,120,50);
        
        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL //////////////////////////////////////////////

        // Añadiendo el campo id Disco
        add(idDisco);
        add(txtIdDisco);

        // Añadiendo el campo Nom. Album
        add(nomAlbum);
        add(txtNomAlbum);
        


        // Añadiendo el boton Agregar (disquito)
        agregar.add(imgAgregar);
        agregar.add(txtAgregar);
        add(agregar);

        // Añadiendo el boton Cancelar
        cancelar.add(imgCancelar);
        cancelar.add(txtCancelar);
        add(cancelar);

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
