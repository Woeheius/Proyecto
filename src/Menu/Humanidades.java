/**
 * Propósito:Clase la cual se mostrará el menú del área de Humanidades y sus botones.
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 8/11/2023
 * Versión JDK: 12
 */
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Clase que representa la ventana de la "Área de Humanidades" en una aplicación
 * educativa.
 */
public final class Humanidades extends JFrame {

    MenuPrincipal mp;
    Inf inf;
    JButton jbVolver, jbCapitulos, jbEncuesta;

    /**
     * Constructor de la clase Humanidades.
     *
     * @param obj Objeto de la clase MenuPrincipal.
     */
    public Humanidades(MenuPrincipal obj) {
        super("Area de Humanidades");
        mp = obj;
        setSize(900, 600);
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

    /**
     * Método para crear la interfaz gráfica de la ventana.
     */
    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/mundo.png"));
        JLabel jlTitulo = new JLabel("Area de Humanidades", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        ImageIcon i_cap = new ImageIcon(
                getClass().getResource("/imagenes/libros.png"));
        jbCapitulos = new JButton("Leer capitulos", i_cap);
        jbCapitulos.setBounds((670 - 200) / 2, 170, 500, 50);
        jbCapitulos.addActionListener((e) -> {
            evento_jbCapitulos();
        });
        add(jbCapitulos);

        ImageIcon i_enc = new ImageIcon(
                getClass().getResource("/imagenes/encuesta.png"));
        jbEncuesta = new JButton("Encuesta", i_enc);
        jbEncuesta.setBounds((670 - 200) / 2, 320, 500, 50);
        jbEncuesta.addActionListener((e) -> {
            evento_jbEncuesta();
        });
        add(jbEncuesta);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }

    /**
     * Método para manejar el evento del botón "Volver".
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }

    /**
     * Método para manejar el evento del botón "Leer Capítulos".
     */
    public void evento_jbCapitulos() {
        Capitulos ca = new Capitulos(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    /**
     * Método para manejar el evento del botón "Encuesta".
     */
    public void evento_jbEncuesta() {
        Cuestionario_ods preg = new Cuestionario_ods("CUESTIONARIO DE HUMANIDADES");
        setVisible(false); // ocultar la ventana de menu principal
        preg.setVisible(true);
    }

}
