/**
 * Propósito: Clase que representa el capitulo que habla sobre la relacion entre la educacion y 
 * la pobreza.
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 3/11/2023
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
 * Clase que representa la ventana del "Capítulo 8".
 */
public final class Capitulo_8 extends JFrame {

    JEditorPane editor;
    Capitulo_8 cap8;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_8,jbsig,jbant;
    /**
     * Constructor de la clase Capitulo_8.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_8(Capitulos obj) {
        super("Capitulo 8");
        ca = obj;
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

        setVisible(false);
    }
    /**
     * Crea y configura la interfaz gráfica de la ventana.
     */
    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Capitulo 8");
        jlTitulo.setBounds(0, 0, 1000, 70);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(700, 630, 200, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
        
        
        jbsig = new JButton("Siguiente");
        jbsig.setBounds(350, 630, 200, 30);
        jbsig.addActionListener((e) -> {
            evento_jbsig();
        });
        add(jbsig);
        jbant = new JButton("Anterior");
        jbant.setBounds(100, 630, 200, 30);
        jbant.addActionListener((e) -> {
            evento_jbant();
        });
        add(jbant);
        
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/logo_duke.png");

editor.setText(
    "<!DOCTYPE html>\n"
    + "<html>\n"
    + "    <head>\n"
    + "        <title>La relación entre educación y pobreza</title>\n"
    + "    </head>\n"
    + "    <body bgcolor=\"#181818\">\n"
    + "        <font color=\"white\" face=\"Tahoma\">\n"
    + "            <center><h1>La relación entre educación y pobreza</h1></center>\n"
    + "        </font>\n"
    + "        <hr>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "            <p>La relación entre educación y pobreza es un tema de gran relevancia y ha sido ampliamente discutido en la investigación educativa y en el desarrollo social. Aunque no se puede afirmar de manera categórica que la educación sea la única solución para sacar a las personas de la pobreza, es innegable que desempeña un papel crucial en la lucha contra la pobreza y la mejora de las condiciones de vida.</p>\n"
    + "            <font color=\"white\">\n"
    + "            <p>1. Acceso a oportunidades:</p> <p>La educación brinda a las personas acceso a un conjunto más amplio de oportunidades. Proporciona habilidades y conocimientos que son valiosos en el mercado laboral, lo que aumenta las posibilidades de obtener empleo y, por lo tanto, de aumentar los ingresos.</p>\n"
    + "            <p>2. Romper el ciclo de la pobreza:</p> <p>La educación tiene el potencial de romper el ciclo de la pobreza intergeneracional. Cuando las personas tienen acceso a una educación de calidad, están en mejores condiciones de proporcionar a sus hijos un entorno más favorable para su desarrollo y educación, lo que puede ayudar a romper el ciclo de la pobreza.</p>\n"
    + "            <p>3. Empoderamiento y movilidad social:</p> <p>La educación no formal y popular, aunque no necesariamente se traduce en un aumento inmediato de los ingresos, puede empoderar a las personas y darles la capacidad de participar de manera más activa en la sociedad. Esto puede conducir a una mayor movilidad social y al cambio de su realidad.</p>\n"
    + "            <p>4. Igualdad de oportunidades:</p> <p>La educación contribuye a la creación de una sociedad más equitativa al proporcionar a las personas igualdad de oportunidades para desarrollar su potencial. Ayuda a superar las barreras socioeconómicas y culturales que pueden limitar el acceso a una vida mejor.</p>\n"
    + "            <p>5. Desafíos en la educación:</p> <p>La relación entre educación y pobreza también está influenciada por factores como la calidad de la educación, la distribución de recursos educativos, y la capacitación y desempeño de los maestros. Para que la educación sea un motor efectivo en la lucha contra la pobreza, es necesario abordar estos desafíos y garantizar que la educación sea accesible y de alta calidad.</p>\n"
    + "            </font>\n"
    + "            <p><strong>Recursos adicionales:</strong></p>\n"
    + "            <p><a href=\"https://biblioteca.clacso.edu.ar/clacso/gt/20101029064158/6ziccardi.pdf\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://www.educo.org/blog/claves-para-acabar-pobreza-con-educacion\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://www.un.org/es/chronicle/article/acabar-con-la-pobreza-mediante-la-educacion-el-desafio-de-la-educacion-para-todos\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://youtu.be/brNGKoSTEqA?si=zJx-ZN84l2XkT6se\">VIDEO</a></p>\n"
            
    + "        </font>\n"
    + "    </body>\n"
    + "</html>"
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
     * Maneja el evento del botón "Volver" para ocultar la ventana actual y mostrar la ventana de Capitulos.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ca.setVisible(true); // mostrar la ventana de menu principal 
    }
    /**
     * Maneja el evento del botón "Capitulo_8" para abrir la ventana del "Capítulo 8" y ocultar la ventana actual. (Nota: El nombre del método y su funcionalidad parecen estar duplicados).
     */
    public void evento_jbCapitulo_6() {
        cap8.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 9" y ocultar la ventana actual.
     */
            public void evento_jbsig(){
        Capitulo_9 Capitulo_9 = new Capitulo_9(ca);
        Capitulo_9.setVisible(true);
        setVisible(false);
    }
                /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 7" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_7 Capitulo_7 = new Capitulo_7(ca);
        Capitulo_7.setVisible(true);
        setVisible(false);
    }

}
