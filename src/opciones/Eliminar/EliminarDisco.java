package opciones.Eliminar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EliminarDisco extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco");
    JTextField idDisco = new JTextField();

    // Componente Nom. Album
    JLabel txtNomAlbum = new JLabel("Nom. Album");
    JTextField nomAlbum = new JTextField();

    // Componente numExt
    JLabel txtnumExt = new JLabel("numExt");
    JTextField numExt = new JTextField();

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

    public EliminarDisco() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Disco
        txtIdDisco.setBounds(270, 60, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(350, 57, 270, 25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(650,40,60,60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Nom. Album
        txtNomAlbum.setBounds(20, 150, 120, 20);
        txtNomAlbum.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nomAlbum.setBounds(130, 147, 270, 25);
        nomAlbum.setForeground(Color.GRAY);
        nomAlbum.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        nomAlbum.setEditable(false);
    

        // Campo numExt
        txtnumExt.setBounds(20, 240, 120, 20);
        txtnumExt.setFont(new Font("Roboto Black", Font.BOLD, 16));
        numExt.setBounds(130, 237, 270, 25);
        numExt.setForeground(Color.GRAY);
        numExt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        numExt.setEditable(false);

        // Campo Genero
        txtGenero.setBounds(20, 330, 120, 20);
        txtGenero.setFont(new Font("Roboto Black", Font.BOLD, 16));
        genero.setBounds(130, 327, 270, 25);
        genero.setForeground(Color.GRAY);
        genero.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        genero.setEditable(false);

        // Campo Artista
        txtArtista.setBounds(520, 150, 120, 20);
        txtArtista.setFont(new Font("Roboto Black", Font.BOLD, 16));
        artista.setBounds(600, 147, 270, 25);
        artista.setForeground(Color.GRAY);
        artista.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        artista.setEditable(false);

        // Campo Costo
        txtCosto.setBounds(520, 240, 120, 20);
        txtCosto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        costo.setBounds(600, 237, 270, 25);
        costo.setForeground(Color.GRAY);
        costo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        costo.setEditable(false);

        // Campo Formato
        txtFormato.setBounds(520, 330, 120, 20);
        txtFormato.setFont(new Font("Roboto Black", Font.BOLD, 16));
        formato.setBounds(600, 327, 270, 25);
        formato.setForeground(Color.GRAY);
        formato.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        formato.setEditable(false);

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

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL ////////////////////////////////////////////////////////////////////

        // Añadiendo el campo id Disco
        add(idDisco);
        add(txtIdDisco);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Nom. Album
        add(nomAlbum);
        add(txtNomAlbum);

        // Añadiendo el campo Existenncia
        add(numExt);
        add(txtnumExt);

        // Añadiendo el campo Genero
        add(genero);
        add(txtGenero);

        // Añadiendo el campo Artista
        add(artista);
        add(txtArtista);

        // Añadiendo el campo Costo
        add(costo);
        add(txtCosto);

        // Añadiendo el campo Formato
        add(formato);
        add(txtFormato);

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
