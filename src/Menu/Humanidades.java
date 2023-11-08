/*
Proposito:
Clase en la cual se podran visualzar los 10 capitulos y resolver la encuesta
Autores:
Angie Natalia Cobo Vasquez
Juan Diego Rodriguez Ortiz
Sebastian Henao Gamboa
Santiago Ospina Gonzalez

Version:
2.0
Fecha ultima actualizacion:
08/11/2023
Version JDK:
 */
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public final class Humanidades extends JFrame {

    MenuPrincipal mp;
    Inf inf;
    JButton jbVolver, jbCapitulos, jbEncuesta;

    public Humanidades(MenuPrincipal obj) {
        super("Area de Humanidades");
        mp = obj;
        setSize(1000, 700);
        //setLocation(1000, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(
                new Color(41, 41, 41));
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        setLayout(null); // asignar un diseño libre
        crearGUI();

        setVisible(true);
    }

    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/mundo.png"));
        JLabel jlTitulo = new JLabel("Area de Humanidades", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 1000, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbCapitulos = new JButton("Leer capitulos");
        jbCapitulos.setBounds((700 - 200) / 2, 200, 500, 30);
        jbCapitulos.addActionListener((e) -> {
            evento_jbCapitulos();
        });
        add(jbCapitulos);

        jbEncuesta = new JButton("Encuesta");
        jbEncuesta.setBounds((700 - 200) / 2, 300, 500, 30);
        jbEncuesta.addActionListener((e) -> {
            evento_jbEncuesta();
        });
        add(jbEncuesta);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(400, 600, 500, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }

    public void evento_jbCapitulos() {
        Capitulos ca = new Capitulos(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbEncuesta() {
        Cuestionario_ods preg = new Cuestionario_ods("CUESTIONARIO HUMANIDADES");
        setVisible(false); // ocultar la ventana de menu principal
        preg.setVisible(true);
    }

}
