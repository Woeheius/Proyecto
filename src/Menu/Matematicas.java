/**
 * Propósito:Clase la cual se mostrará el menú de Matemáticas y sus funciones
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
 * Esta clase representa la ventana principal del módulo de Matemáticas. Permite
 * acceder a diversas funcionalidades relacionadas con matemáticas.
 */
public class Matematicas extends JFrame {

    MenuPrincipal mp;
    JButton jbVolver, jbDeri, jbFun, jbCalculadoraDerivadas, jbGrafi;
    CalculadoraDerivadas c = new CalculadoraDerivadas(this);
    VentanaGraficar ven = new VentanaGraficar(this);

    /**
     * Constructor de la clase Matematicas.
     *
     * @param obj Instancia de la clase MenuPrincipal. Representa la ventana
     * principal del programa.
     */
    public Matematicas(MenuPrincipal obj) {
        super("Area de Matematicas");
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
     * Crea y configura la interfaz gráfica de la ventana de Matemáticas.
     * Incluye botones para acceder a las funcionalidades de Funciones,
     * Derivadas, Calculadora de Derivadas y Graficadora, así como un botón para
     * volver al menú principal.
     */
    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/calcula.png"));
        JLabel jlTitulo = new JLabel("Area de Matematicas", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 60);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        ImageIcon i_func = new ImageIcon(
                getClass().getResource("/imagenes/func.png"));
        jbFun = new JButton("Funciones", i_func);
        jbFun.setBounds(100, 160, 300, 50);
        jbFun.addActionListener((e) -> {
            evento_jbFun();
        });
        add(jbFun);

        ImageIcon i_deriv = new ImageIcon(
                getClass().getResource("/imagenes/deriv.png"));
        jbDeri = new JButton("Derivadas", i_deriv);
        jbDeri.setBounds(100, 350, 300, 50);
        jbDeri.addActionListener((e) -> {
            evento_jbDeri();
        });
        add(jbDeri);

        //ImageIcon i_deriv = new ImageIcon(
        //getClass().getResource("/imagenes/equipo.png"));
        jbCalculadoraDerivadas = new JButton("Calculadora");
        jbCalculadoraDerivadas.setBounds((2025 - 610) / 2, 362, 100, 40);
        jbCalculadoraDerivadas.addActionListener((e) -> {
            evento_jbCalculadoraDerivadas();
        });
        add(jbCalculadoraDerivadas);

        jbGrafi = new JButton("Graficadora");
        jbGrafi.setBounds((2025 - 610) / 2, 172, 100, 40);
        jbGrafi.addActionListener((e) -> {
            evento_jbGraficadora();
        });
        add(jbGrafi);
    }

    /**
     * Maneja el evento cuando se hace clic en el botón "Funciones". Abre una
     * nueva ventana de Funciones y oculta la ventana de Matemáticas.
     */
    public void evento_jbFun() {
        Fun fu = new Fun(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    /**
     * Maneja el evento cuando se hace clic en el botón "Derivadas". Abre una
     * nueva ventana de Derivadas y oculta la ventana de Matemáticas.
     */
    public void evento_jbDeri() {
        Deri de = new Deri(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    /**
     * Maneja el evento cuando se hace clic en el botón "Calculadora". Abre una
     * nueva ventana de Calculadora de Derivadas y oculta la ventana de
     * Matemáticas.
     */
    public void evento_jbCalculadoraDerivadas() {
        c.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }

    /**
     * Maneja el evento cuando se hace clic en el botón "Volver al menú
     * principal". Oculta la ventana de Matemáticas y muestra la ventana del
     * menú principal.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }

    /**
     * Maneja el evento cuando se hace clic en el botón "Graficadora". Abre una
     * nueva ventana de Graficadora y oculta la ventana de Matemáticas.
     */
    public void evento_jbGraficadora() {
        ven.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
}
