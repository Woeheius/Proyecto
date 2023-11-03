package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Menu.PlanoCartesiano;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class VentanaFunciones extends JFrame {

    private JTextField funcion1TextField;
    private JTextField funcion2TextField;
    private PlanoCartesiano planoCartesiano;

    public VentanaFunciones(PlanoCartesiano planoCartesiano) {
        this.planoCartesiano = planoCartesiano;

        setTitle("Ingresar Funciones");
        setSize(200, 200);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocation(125, 50);
        JPanel panelFunciones = new JPanel(new GridLayout(3, 1));

        JLabel labelFuncion1 = new JLabel("Función 1:");
        funcion1TextField = new JTextField(20);
        JLabel labelFuncion2 = new JLabel("Función 2:");
        funcion2TextField = new JTextField(20);

        panelFunciones.add(labelFuncion1);
        panelFunciones.add(funcion1TextField);
        panelFunciones.add(labelFuncion2);
        panelFunciones.add(funcion2TextField);

        JButton graficarButton = new JButton("Graficar");
        graficarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graficarFunciones();
            }
        });

        add(panelFunciones, BorderLayout.NORTH);
        add(graficarButton, BorderLayout.SOUTH);
    }

    private void graficarFunciones() {
        String funcion1 = funcion1TextField.getText();
        String funcion2 = funcion2TextField.getText();
        planoCartesiano.graficarFunciones(funcion1, funcion2);
    }
}
