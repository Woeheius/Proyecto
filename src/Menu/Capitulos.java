/**
 * Clase que representa la seccion con los capitulos de el ods 1.
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 31/10/2023
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
 * Clase que representa la ventana de "Capitulos".
 */
public final class Capitulos extends JFrame {

    Humanidades hu;
    JButton jbVolver, jbCapitulo_1, jbCapitulo_2, jbCapitulo_3, jbCapitulo_4, jbCapitulo_5, jbCapitulo_6, jbCapitulo_7, jbCapitulo_8, jbCapitulo_9, jbCapitulo_10;
    Capitulo_1 cap = new Capitulo_1(this);
    Capitulo_2 cap2 = new Capitulo_2(this);
    Capitulo_3 cap3 = new Capitulo_3(this);
    Capitulo_4 cap4 = new Capitulo_4(this);
    Capitulo_5 cap5 = new Capitulo_5(this);
    Capitulo_6 cap6 = new Capitulo_6(this);
    Capitulo_7 cap7 = new Capitulo_7(this);
    Capitulo_8 cap8 = new Capitulo_8(this);
    Capitulo_9 cap9 = new Capitulo_9(this);
    Capitulo_10 cap10 = new Capitulo_10(this);
    /**
     * Constructor de la clase Capitulos.
     *
     * @param obj El objeto Humanidades al que pertenece esta ventana.
     */
    public Capitulos(Humanidades obj) {
        super("Capitulos");
        hu = obj;
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
    /**
     * Crea y configura la interfaz gráfica de la ventana.
     */
    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Capitulos ODS 1");
        jlTitulo.setBounds(0, 0, 1000, 60);
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

        jbCapitulo_1 = new JButton("Capitulo 1");
        jbCapitulo_1.setBounds(180, 100, 300, 30);
        jbCapitulo_1.addActionListener((e) -> {
            evento_jbCapitulo_1();
        });
        add(jbCapitulo_1);

        jbCapitulo_2 = new JButton("Capitulo 2");
        jbCapitulo_2.setBounds(520, 100, 300, 30);
        jbCapitulo_2.addActionListener((e) -> {
            evento_jbCapitulo_2();
        });
        add(jbCapitulo_2);

        jbCapitulo_3 = new JButton("Capitulo 3");
        jbCapitulo_3.setBounds(180, 200, 300, 30);
        jbCapitulo_3.addActionListener((e) -> {
            evento_jbCapitulo_3();
        });
        add(jbCapitulo_3);

        jbCapitulo_4 = new JButton("Capitulo 4");
        jbCapitulo_4.setBounds(520, 200, 300, 30);
        jbCapitulo_4.addActionListener((e) -> {
            evento_jbCapitulo_4();
        });
        add(jbCapitulo_4);

        jbCapitulo_5 = new JButton("Capitulo 5");
        jbCapitulo_5.setBounds(180, 300, 300, 30);
        jbCapitulo_5.addActionListener((e) -> {
            evento_jbCapitulo_5();
        });
        add(jbCapitulo_5);

        jbCapitulo_6 = new JButton("Capitulo 6");
        jbCapitulo_6.setBounds(520, 300, 300, 30);
        jbCapitulo_6.addActionListener((e) -> {
            evento_jbCapitulo_6();
        });
        add(jbCapitulo_6);

        jbCapitulo_7 = new JButton("Capitulo 7");
        jbCapitulo_7.setBounds(180, 400, 300, 30);
        jbCapitulo_7.addActionListener((e) -> {
            evento_jbCapitulo_7();
        });
        add(jbCapitulo_7);

        jbCapitulo_8 = new JButton("Capitulo 8");
        jbCapitulo_8.setBounds(520, 400, 300, 30);
        jbCapitulo_8.addActionListener((e) -> {
            evento_jbCapitulo_8();
        });
        add(jbCapitulo_8);

        jbCapitulo_9 = new JButton("Capitulo 9");
        jbCapitulo_9.setBounds(180, 500, 300, 30);
        jbCapitulo_9.addActionListener((e) -> {
            evento_jbCapitulo_9();
        });
        add(jbCapitulo_9);

        jbCapitulo_10 = new JButton("Capitulo 10");
        jbCapitulo_10.setBounds(520, 500, 300, 30);
        jbCapitulo_10.addActionListener((e) -> {
            evento_jbCapitulo_10();
        });
        add(jbCapitulo_10);
    }
    /**
     * Maneja el evento del botón "Volver al menú principal" para ocultar la ventana actual y mostrar la ventana de Humanidades.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        hu.setVisible(true); // mostrar la ventana 
    }
    /**
     * Maneja el evento del botón "Capitulo 1" para abrir la ventana del "Capítulo 1" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_1() {
        cap.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
    /**
     * Maneja el evento del botón "Capitulo 2" para abrir la ventana del "Capítulo 2" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_2() {
        cap2.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 3" para abrir la ventana del "Capítulo 3" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_3() {
        cap3.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 4" para abrir la ventana del "Capítulo 4" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_4() {
        cap4.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 5" para abrir la ventana del "Capítulo 5" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_5() {
        cap5.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 6" para abrir la ventana del "Capítulo 6" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_6() {
        cap6.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 7" para abrir la ventana del "Capítulo 7" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_7() {
        cap7.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 8" para abrir la ventana del "Capítulo 8" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_8() {
        cap8.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 9" para abrir la ventana del "Capítulo 9" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_9() {
        cap9.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }
    /**
     * Maneja el evento del botón "Capitulo 10" para abrir la ventana del "Capítulo 10" y ocultar la ventana actual.
     */
    public void evento_jbCapitulo_10() {
        cap10.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal

    }

}
