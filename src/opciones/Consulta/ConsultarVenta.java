package opciones.Consulta;

import java.awt.*;
import javax.swing.*;

public class ConsultarVenta extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botones[] = new JRadioButton[4];
    public ConsultarVenta(){
        super();
        botones[0] = new JRadioButton("IdVenta");
        botones[1] = new JRadioButton("IdDisco");
        botones[2] = new JRadioButton("Cantidad");
        botones[3] = new JRadioButton("Subtotal");
        opciones.setLayout(new GridLayout(4, 0, 0, 5));
        for (int i = 0; i < botones.length; i++) {
            botones[i].setFont(new Font("Roboto Black", Font.BOLD, 18));
            grupo.add(botones[i]);
            opciones.add(botones[i]);
        }
    }
}
