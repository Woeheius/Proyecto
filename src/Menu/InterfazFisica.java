/**
 * Propósito:Clase la cual se muestra la interfaz de Física con sus respectivos botones
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
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Clase que representa la ventana de la sección de Física en la aplicación.
 * Permite acceder a cálculos y volver al menú principal.
 */

public class InterfazFisica extends JFrame {

    // Etiqueta para mostrar el título de la sección de Física
    JLabel jlTexto, jlImagen, jlTextoImg;
    // Botones para realizar cálculos y volver al menú principal
    JButton jbMovimiento, jbVolver, jbCaida;
    // Referencia a la ventana del menú principal
    Fisica fs;

    /**
     * Constructor de la clase InterfazFisica.
     *
     * @param obj La ventana del menú principal.
     */
    public InterfazFisica(Fisica obj) {
        super("FISICA");
        fs = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        crearGUI();

        setVisible(false);
    }

    /**
     * Crea y configura la interfaz gráfica de la ventana.
     */
    public void crearGUI() {
        jlTexto = new JLabel("FISICA");
        jlTexto.setBounds(0, 0, 800, 80);
        jlTexto.setOpaque(true);
        jlTexto.setBackground(Color.BLACK);
        jlTexto.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
        jlTexto.setForeground(Color.WHITE);
        jlTexto.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlTexto);

        jbMovimiento = new JButton("Calculos");
        jbMovimiento.setBounds(200, 500, 100, 30);
        jbMovimiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_JbMovimiento();
                setVisible(false);
            }
        });
        add(jbMovimiento);

        jbCaida = new JButton("Caida Libre");
        jbCaida.setBounds(498, 500, 100, 30);
        jbCaida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_JbCaida();
                setVisible(false);
            }
        });
        add(jbCaida);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(348, 500, 100, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // ocultar la ventana de Matematicas
                dispose(); // destruir la ventana de Matematicas
                fs.setVisible(true); // mostrar la ventana de menu principal 
            }
        });
        add(jbVolver);

        ImageIcon imgOriginal = new ImageIcon(getClass().getResource("/imagenes/FONDO.png"));
        ImageIcon imgScalada = new ImageIcon(imgOriginal.getImage().getScaledInstance(800, 485, Image.SCALE_DEFAULT));
        jlImagen = new JLabel(imgScalada);
        jlImagen.setBounds(0, 80, 800, 485);
        add(jlImagen);

    }

    /**
     * Maneja el evento del botón "Cálculos", abre la ventana de cálculos y la
     * hace visible.
     */
    public void Evento_JbMovimiento() {
        INTERFAZSF INTERFAZSF = new INTERFAZSF(this);
        INTERFAZSF.setVisible(true);
    }

    public void Evento_JbCaida() {
        Ventana Ventana = new Ventana(this);
        Ventana.setVisible(true);
    }

    public static void main(String[] args) {
        InterfazFisica ej = new InterfazFisica(new Fisica(new MenuPrincipal()));
        ej.setVisible(true);
    }

}
