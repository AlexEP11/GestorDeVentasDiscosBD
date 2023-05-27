package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements MouseListener {
    /* Imagenen del panel izquierdo */
    ImageIcon img = new ImageIcon("./src/imagenes/InterfazDisco.png");
    /* Imagen del panel derecho (logo pequeño) */
    ImageIcon img2 = new ImageIcon("./src/imagenes/nota.png");

    /* Fondo blanco que abarca todo el JFrame */
    Panel background = new Panel(null);

    /* JPanel izquierdo (color negro) */
    JPanel izquierda = new JPanel(null);
    /* JPanel derecho (color blanco) */
    JPanel derecha = new JPanel(null);
    /* JPanel del logo chiquito */
    JPanel logo = new JPanel(null);

    JLabel imgIzquierda = new JLabel();
    JLabel imgLogo = new JLabel();
    JLabel titulo = new JLabel();
    JLabel titulo2 = new JLabel();
    JLabel login = new JLabel();
    JLabel usernameTag = new JLabel();
    JLabel passwordTag = new JLabel();
    JLabel entrar = new JLabel("ENTRAR");
    JLabel salir = new JLabel("SALIR");

    JTextField username = new JTextField(30);
    JPasswordField password = new JPasswordField(30);

    public Login() {
        setIconImage(new ImageIcon("./src/imagenes/DiscoLogo.png").getImage());
        this.setUndecorated(true);
        background.setBackground(Color.WHITE);
        add(background);

        izquierda.setBounds(0, 0, 290, 500);
        izquierda.setBackground(new Color(23, 23, 23));

        imgIzquierda.setOpaque(false);
        imgIzquierda.setBounds(0, 0, 290, 500);
        imgIzquierda.setIcon(img);

        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Roboto Black", Font.BOLD, 27));
        titulo.setText("Sistema De Ventas");
        titulo.setBounds(25, 220, 350, 150);

        titulo2.setForeground(new Color(255, 255, 255));
        titulo2.setFont(new Font("Roboto Black", Font.BOLD, 27));
        titulo2.setText("Musical");
        titulo2.setBounds(90, 260, 350, 150);

        derecha.setBounds(290, 0, 510, 500);
        derecha.setBackground(new Color(255, 255, 255));

        logo.setBounds(120, 50, 50, 50);
        logo.setBackground(new Color(255, 255, 255));

        imgLogo.setOpaque(false); // true
        imgLogo.setBounds(100, 50, 50, 50);
        imgLogo.setIcon(img2);

        login.setForeground(new Color(1, 2, 1));
        login.setFont(new Font("Roboto Black", Font.BOLD, 24));
        login.setText("INICIAR SESION");
        login.setBounds(180, 25, 300, 100);

        usernameTag.setForeground(new Color(234, 39, 33));
        usernameTag.setFont(new Font("Roboto Black", Font.BOLD, 20));
        usernameTag.setText("USUARIO");
        usernameTag.setBounds(100, 120, 100, 100);

        passwordTag.setForeground(new Color(234, 39, 33));
        passwordTag.setFont(new Font("Roboto Black", Font.BOLD, 20));
        passwordTag.setText("CONTRASEÑA");
        passwordTag.setBounds(100, 230, 260, 100);

        username.setBounds(100, 200, 260, 25);
        username.setForeground(Color.GRAY);
        username.setFont(new Font("Roboto", Font.PLAIN, 12));
        username.setText("Ingrese su nombre de usuario");
        username.selectAll();
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
        username.addMouseListener(this);

        password.setBounds(100, 310, 260, 25);
        password.setForeground(Color.GRAY);
        password.setText("***********");
        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
        password.addMouseListener(this);

        entrar.setOpaque(true);
        entrar.setBounds(240, 370, 120, 40);
        entrar.setBackground(new Color(251, 208, 131));
        entrar.setFont(new Font("Roboto Black", Font.BOLD, 20));
        entrar.setCursor(new Cursor(12));
        entrar.setHorizontalAlignment(SwingConstants.CENTER);
        entrar.addMouseListener(this);

        salir.setOpaque(true);
        salir.setBounds(100, 370, 120, 40);
        salir.setBackground(new Color(251, 208, 131));
        salir.setFont(new Font("Roboto Black", Font.BOLD, 20));
        salir.setCursor(new Cursor(12));
        salir.setHorizontalAlignment(SwingConstants.CENTER);
        salir.addMouseListener(this);

        izquierda.add(titulo);
        izquierda.add(titulo2);
        izquierda.add(imgIzquierda);

        logo.add(imgLogo);

        derecha.add(imgLogo);
        derecha.add(logo);
        derecha.add(login);
        derecha.add(usernameTag);
        derecha.add(username);
        derecha.add(passwordTag);
        derecha.add(password);

        derecha.add(entrar);
        derecha.add(salir);

        background.add(izquierda);
        background.add(derecha);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == salir) {
            System.exit(0);
        }
        
        if (e.getSource() == entrar ) {
            if((username.getText().equals("admin") && String.valueOf(password.getPassword()).equals("admin111132"))||(username.getText().equals("empleado") && String.valueOf(password.getPassword()).equals("123456"))){
                new Inicio(username.getText());
                dispose();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == username) {
            if (username.getText().equals("Ingrese su nombre de usuario")) {
                username.setText("");
                username.setForeground(Color.BLACK);
            }
            if (String.valueOf(password.getPassword()).isEmpty()) {
                password.setText("***********");
                password.setForeground(Color.GRAY);
            }
        } else {
            if (String.valueOf(password.getPassword()).equals("***********")) {
                password.setText("");
                password.setForeground(Color.BLACK);
            }
            if (username.getText().isEmpty()) {
                username.setText("Ingrese su nombre de usuario");
                username.setForeground(Color.GRAY);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == salir) {
            salir.setBackground(new Color(220, 179, 98));
        } else if (e.getSource() == entrar) {
            entrar.setBackground(new Color(220, 179, 98));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == salir) {
            salir.setBackground(new Color(251, 208, 131));
        } else {
            entrar.setBackground(new Color(251, 208, 131));
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}