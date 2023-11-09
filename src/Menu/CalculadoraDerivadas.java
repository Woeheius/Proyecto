/**
 * Clase que representa una calculadora de derivadas de funciones matemáticas.
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 6/10/2023
 * Versión JDK: 12
 */
package Menu;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Clase que representa la ventana de la "Calculadora de Derivadas".
 */
public class CalculadoraDerivadas extends JFrame {

    private JButton jbVolver;
    private JButton jbLimpiar; // Botón de Limpiar
    private Matematicas mt;
    private JTextField texFuncion;
    private JTextField texFuncionSalida;

    /**
     * Constructor de la clase CalculadoraDerivadas.
     *
     * @param obj El objeto Matematicas al que pertenece esta ventana.
     */
    public CalculadoraDerivadas(Matematicas obj) {
        super("Calculadora Derivadas");
        mt = obj;
        setupFrame();
        initComponents();
    }

    /**
     * Inicializa los componentes de la interfaz gráfica de la ventana.
     */
    private void initComponents() {
        JLabel jLabel1 = new JLabel("Función a derivar");
        JLabel jLabel2 = new JLabel("Función derivada");

        texFuncion = new JTextField();
        texFuncionSalida = new JTextField();

        JButton jButton1 = new JButton("Derivar");
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(10, 220, 100, 30);
        jbVolver.addActionListener(e -> evento_jbVolver());

        // Botón de Limpiar
        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.setBounds(120, 220, 100, 30);
        jbLimpiar.addActionListener(e -> jbLimpiarActionPerformed(e));

        jLabel1.setBounds(10, 20, 120, 20);
        jLabel2.setBounds(10, 60, 120, 20);
        texFuncion.setBounds(140, 20, 300, 20);
        texFuncionSalida.setBounds(140, 60, 300, 20);
        jButton1.setBounds(450, 20, 80, 60);

        // Cambia el color del texto a blanco
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setForeground(Color.WHITE);

        add(jbVolver);
        add(jbLimpiar);
        add(jLabel1);
        add(jLabel2);
        add(texFuncion);
        add(texFuncionSalida);
        add(jButton1);
    }

    /**
     * Maneja el evento del botón "Limpiar" para borrar los campos de texto.
     *
     * @param evt El evento de acción.
     */
    private void jbLimpiarActionPerformed(ActionEvent evt) {
        // Limpia el contenido de los campos de texto
        texFuncion.setText("");
        texFuncionSalida.setText("");
    }

    /**
     * Maneja el evento del botón "Derivar" para calcular la derivada de la
     * función ingresada.
     *
     * @param evt El evento de acción.
     */
    private void jButton1ActionPerformed(ActionEvent evt) {
        String Funcion = texFuncion.getText();
        Derivadas derivada = new Derivadas();
        derivada.setFuncionADerivar(Funcion);
        derivada.derivar();
        texFuncionSalida.setText(derivada.getFuncionDerivada());
    }

    /**
     * Maneja el evento del botón "Volver" para ocultar la ventana actual y
     * mostrar la ventana de Matematicas.
     */
    public void evento_jbVolver() {
        setVisible(false);
        dispose();
        mt.setVisible(true);
    }

    /**
     * Configura las propiedades iniciales de la ventana.
     */
    private void setupFrame() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(41, 41, 41));
        Image im = new ImageIcon(getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        setLayout(null);
    }

    /**
     * Método principal para ejecutar la aplicación de la Calculadora de
     * Derivadas.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
     */
    public static void main(String args[]) {
        CalculadoraDerivadas c = new CalculadoraDerivadas(new Matematicas(new MenuPrincipal()));
        c.setVisible(true);
    }
}
