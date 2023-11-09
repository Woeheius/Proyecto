/**
 * Propósito:Clase donde se mostrara la interfaz de la graficadora de funciones
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * La clase VentanaGraficar se utiliza para graficar funciones matemáticas en una ventana de Java Swing.
 */
public class VentanaGraficar extends JFrame {
    
    Matematicas mt;
    JTextField Texfuncion;
    JButton jbVolver, graficar, limpiar,jbpuntos;
    JPanel panel;
    /**
     * Constructor de la clase VentanaGraficar.
     * @param obj Una instancia de la clase Matematicas para gestionar la navegación.
     */
    public VentanaGraficar(Matematicas obj) {
        super("Graficar Funciones");
        mt = obj;
        setSize(600, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(44, 44, 44));
        setLayout(null);
        setVisible(false);
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        crearGUI();
    }
    /**
     * Crea la interfaz gráfica de la ventana de graficación de funciones.
     */
    public void crearGUI() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 400);
        add(panel);

        JLabel jl = new JLabel("F(X)=");
        jl.setBounds(120, 420, 160, 20);
        jl.setForeground(Color.WHITE);
        add(jl);

        Texfuncion = new JTextField();
        Texfuncion.setBounds(160, 420, 200, 20);
        add(Texfuncion);

        graficar = new JButton("Graficar");
        graficar.setBounds(10, 450, 165, 30);
        graficar.addActionListener((e) -> {
            String funcion = Texfuncion.getText();
            // Manda el panel
            Plano p = new Plano(panel);
            // Manda la función
            p.GraficarFuncion(funcion); 
        });
        add(graficar);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(200, 450, 165, 30);
        limpiar.addActionListener((e) -> {
        panel.removeAll();  // Elimina todos los componentes del panel
        panel.repaint();     // Vuelve a pintar el panel vacío
        Texfuncion.setText("");
        });

        add(limpiar);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(400, 450, 165, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
            setVisible(false);
            dispose();
        });
        add(jbVolver);
        
        jbpuntos = new JButton("Puntos criticos"); 
        jbpuntos.setBounds(390, 420, 165, 20);
        add(jbpuntos);
    }
        /**
     * Evento al presionar el botón "Volver".
     */
     public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mt.setVisible(true); // mostrar la ventana de menu principal

    }
}
