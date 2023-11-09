/**
 * Propósito:Clase la cual se mostrara informacion sobre las funciones y sus aplicaciones
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
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
/**
 * Clase que representa la ventana de información sobre Funciones Matemáticas.
 */
public final class Fun extends JFrame {
    JEditorPane editor;
    Matematicas ma;
    JButton jbVolver;
    /**
     * Constructor de la clase Fun.
     *
     * @param obj Objeto de la clase Matematicas.
     */
    public Fun(Matematicas obj) {
        super("Funciones");
        ma = obj;
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
     * Método para crear la interfaz gráfica de la ventana y cargar información sobre Funciones Matemáticas.
     */
    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Funciones");
        jlTitulo.setBounds(0, 0, 1000, 60);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(700, 630, 200, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
       
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/logo_duke.png");
        
        editor.setText(
    "<html>" +
    "<head>" +
    "<style>" +
    "body {" +
    "   background-color: #2C2C2C;" +
    "   color: white;" +
    "}" +
    "</style>" +
    "</head>" +
    "<body>" +
    "<h1>Funciones Matemáticas: Conceptos Fundamentales y Aplicaciones en la Vida Real</h1>" +
    "<p>Las funciones matemáticas son conceptos fundamentales en el ámbito de las matemáticas y tienen una amplia variedad de aplicaciones en diversas disciplinas. En términos simples, una función es una relación matemática que asigna a cada elemento de un conjunto de entrada (llamado dominio) exactamente un elemento en un conjunto de salida (llamado codominio). Estas relaciones se expresan generalmente en términos de una regla o fórmula matemática que describe cómo los elementos del dominio se relacionan con los elementos del codominio.</p>" +
    "<p>Las funciones se representan generalmente mediante una notación específica, como f(x), donde \"f\" es el nombre de la función y \"x\" es la variable de entrada. La función f(x) nos dice cómo se relaciona cada valor de \"x\" en el dominio con un valor correspondiente en el codominio.</p>" +
    "<p>Las funciones cumplen varias funciones esenciales en matemáticas y en la vida cotidiana:</p>" +
    "<ul>" +
    "   <li><strong>Modelización y representación:</strong> Las funciones se utilizan para representar y modelar una amplia gama de situaciones del mundo real. Por ejemplo, en física, las funciones se utilizan para describir el movimiento de objetos, el crecimiento de poblaciones y la propagación de ondas. En economía, se emplean para analizar relaciones de oferta y demanda, costos de producción y ganancias.</li>" +
    "   <li><strong>Resolución de ecuaciones:</strong> Las funciones son fundamentales para resolver ecuaciones. Dado que expresan relaciones entre variables, se pueden utilizar para encontrar el valor de una variable desconocida en función de otras variables conocidas. Esto es esencial en campos como la trigonometría, el cálculo y la álgebra.</li>" +
    "   <li><strong>Análisis de datos:</strong> En estadísticas, las funciones se utilizan para analizar datos y describir cómo se relacionan diferentes variables. Esto permite comprender tendencias, patrones y correlaciones en los conjuntos de datos.</li>" +
    "   <li><strong>Optimización:</strong> Las funciones son esenciales en la optimización de problemas, donde se busca maximizar o minimizar ciertas cantidades. Por ejemplo, se utilizan en la optimización de costos, la maximización de ingresos y la minimización de tiempos de viaje.</li>" +
    "   <li><strong>Programación y ciencias de la computación:</strong> En la informática, las funciones se utilizan para diseñar algoritmos y programas. Las funciones permiten modularizar el código, lo que facilita el desarrollo, la depuración y el mantenimiento de software.</li>" +
    "   <li><strong>Ingeniería y diseño:</strong> En ingeniería y diseño, las funciones son esenciales para crear modelos de sistemas y estructuras. Se utilizan para predecir el comportamiento de componentes, como puentes, circuitos eléctricos y sistemas de control.</li>" +
    "</ul>" +
    "<p>En resumen, las funciones matemáticas son un pilar fundamental en las matemáticas y tienen un impacto significativo en una amplia variedad de campos, desde la física y la economía hasta la informática y la ingeniería. Son herramientas poderosas que nos permiten comprender, modelar y resolver problemas en el mundo real, lo que las convierte en un concepto clave en la educación y la investigación matemática, así como en la vida cotidiana.</p>" +
    "</body>" +
    "</html>"
);



        editor.setEditable(false);//mostrar solo codigo HTML
         editor.setCaretPosition(0);
        editor.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(e.getURL().toURI());
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
        );
        JScrollPane js = new JScrollPane(editor);
        js.setBounds(40, 90, 915, 500);
        add(js);
    }
    /**
     * Método para manejar el evento del botón "Volver al menú principal".
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ma.setVisible(true); // mostrar la ventana de menu principal 
    }
}
