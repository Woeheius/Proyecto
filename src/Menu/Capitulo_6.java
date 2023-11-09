/**
 * Propósito: Clase que representa el capitulo medicion de la pobreza a nivel mundial.
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
 * Clase que representa la ventana del "Capítulo 6".
 */
public final class Capitulo_6 extends JFrame {

    JEditorPane editor;
    Capitulo_6 cap6;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_6,jbsig,jbant;
    /**
     * Constructor de la clase Capitulo_6.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_6(Capitulos obj) {
        super("Capitulo 6");
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

        JLabel jlTitulo = new JLabel("Capitulo 6");
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
    + "        <title>Medición de la Pobreza Multidimensional y Alternativas Métricas</title>\n"
    + "    </head>\n"
    + "    <body bgcolor=\"#181818\">\n"
    + "        <font color=\"white\" face=\"Tahoma\">\n"
    + "            <center><h1>Medición de la Pobreza Multidimensional y Alternativas Métricas</h1></center>\n"
    + "        </font>\n"
    + "        <hr>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "            <p>La medición de la pobreza multidimensional y la búsqueda de alternativas métricas son fundamentales para lograr el Objetivo de Desarrollo Sostenible 1 de la Agenda 2030, que se enfoca en la erradicación de la pobreza en todas sus formas y en todo el mundo. Superar las limitaciones de la tradicional línea de pobreza monetaria es esencial para captar de manera más precisa la complejidad de la pobreza y garantizar que se aborde de manera efectiva.</p>\n"
    + "            <p>En este contexto, se destacan varias opciones métricas, siendo la metodología de Alkire y Foster una alternativa flexible y completa.</p>\n"
    + "            <p>La metodología de Alkire y Foster se basa en la identificación de dimensiones relevantes para medir la pobreza multidimensional, como la educación, la salud y el nivel de vida. A partir de estas dimensiones, se establecen umbrales que determinan si una persona es considerada pobre o no en cada una de ellas. Se aplican ponderaciones a cada dimensión para reflejar su importancia relativa en la medición de la pobreza. Finalmente, se utiliza una línea de corte para determinar si una persona es considerada pobre multidimensionalmente. Esta metodología proporciona una visión más integral de la pobreza al considerar diversas dimensiones de bienestar.</p>\n"
    + "            <p>Además de la metodología de Alkire y Foster, existen otras opciones métricas para medir la pobreza multidimensional. Por ejemplo, en América Latina se utiliza el Índice de Pobreza Multidimensional (IPM), que considera dimensiones como la salud, la educación y el nivel de vida, y ha demostrado ser una herramienta efectiva para comprender la pobreza en la región. En Europa, se utiliza el Índice de Privación Material Severa (IPMS), que se enfoca en la privación de necesidades materiales básicas.</p>\n"
    + "            <p>La medición de la pobreza multidimensional no se limita a la teoría, ya que se han implementado diversas experiencias en América Latina y Europa. Un ejemplo destacado es México, que ha adaptado y aplicado el Índice de Pobreza Multidimensional (IPM) a su contexto nacional. Esta medida ha permitido una comprensión más precisa de la pobreza en el país y ha servido como base para la formulación de políticas más efectivas y orientadas a la reducción de la pobreza en sus múltiples dimensiones.</p>\n"
    + "            <p>En resumen, la medición de la pobreza multidimensional y la exploración de alternativas métricas son fundamentales para avanzar en la erradicación de la pobreza en el marco de la Agenda 2030. La metodología de Alkire y Foster, junto con otros índices utilizados en diferentes regiones, ofrecen herramientas efectivas para comprender y abordar la pobreza en todas sus dimensiones, lo que es esencial para promover un desarrollo sostenible y equitativo a nivel global.</p>\n"
    + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://expeditiorepositorio.utadeo.edu.co/bitstream/handle/20.500.12010/24662/Catherine%20Valencia%20Final.pdf?sequence=1&isAllowed=y\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://www.fundacioncarolina.es/wp-content/uploads/2020/05/DT_FC_Especial2.pdf\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://ayudaenaccion.org/blog/solidaridad/como-se-mide-la-pobreza/\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://youtu.be/VcRN2H-rPu0?si=hbtvCcbovq0Pq-zR\">VIDEO</a></p>\n"
            
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

    public void evento_jbCapitulo_6() {
        cap6.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 7" y ocultar la ventana actual.
     */
        public void evento_jbsig(){
        Capitulo_7 Capitulo_7 = new Capitulo_7(ca);
        Capitulo_7.setVisible(true);
        setVisible(false);
    }
            /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 5" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_5 Capitulo_5 = new Capitulo_5(ca);
        Capitulo_5.setVisible(true);
        setVisible(false);
    }

}
