/**
 * Propósito:Clase en la cual---------.
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
/**
 * Esta clase representa una ventana que muestra una encuesta.
 * Permite a los usuarios responder preguntas y proporcionar retroalimentación.
 */
public final class Encuesta extends JFrame {

    // Humanidades hu = new Humanidades (this);
    Humanidades hu;
    JButton jbVolver;
    /**
     * Constructor de la ventana Encuesta.
     *
     * @param obj Objeto de la clase Humanidades, que permite volver al menú principal.
     */
    public Encuesta(Humanidades obj) {
        super("Encuesta");
        hu = obj;
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
     * Crea la interfaz gráfica de la ventana de la encuesta.
     */
    public void crearGUI() {
        JLabel jlTitulo = new JLabel("Encuesta");
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(700, 600, 200, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }
    /**
     * Maneja el evento de volver. Oculta la ventana actual y muestra la ventana del menú principal de Humanidades.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        hu.setVisible(true); // mostrar la ventana de menu principal 
    }
}
