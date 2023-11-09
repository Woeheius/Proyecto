/**
 * Propósito: Clase que representa el capitulo que habla sobre los problemas en la implementacion de
 * el ODS 1.
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
 * Clase que representa la ventana del "Capítulo 3".
 */
public final class Capitulo_3 extends JFrame {

    JEditorPane editor;
    Capitulo_3 cap3;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_3,jbsig,jbant;
    /**
     * Constructor de la clase Capitulo_3.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_3(Capitulos obj) {
        super("Capitulo 3");
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

        JLabel jlTitulo = new JLabel("Capitulo 3");
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
                + "        <title>capitulo e</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color='white' face='Tahoma'> <center><h1>Problemas en la implementación del ODS 1: Erradicar la pobreza en todas sus formas en el mundo</h1></center>\n"
                + "        <hr>\n"
                + "        <font color='white' face='Tahoma' size='3'><h3><font color='white'>Revisa las opciones métricas disponibles para medir la pobreza multidimensional y lograr que el Objetivo de Desarrollo Sostenible 1 de la Agenda 2030 sea universal y comprometa a todos los países. Se destaca la importancia de superar las limitaciones de la tradicional línea de pobreza monetaria y se presenta la metodología de Alkire y Foster como una alternativa flexible y completa.</font></h3></font>\n"
                + "        <font color='white' face='Tahoma' size='3'>\n"
                + "        <p>La metodología de Alkire y Foster se basa en la identificación de las dimensiones relevantes para medir la pobreza multidimensional, como la educación, la salud y el nivel de vida. A partir de estas dimensiones, se establecen umbrales que determinan si una persona es considerada pobre o no en cada una de ellas. Se aplican ponderaciones a cada dimensión para reflejar su importancia relativa en la medición de la pobreza. Finalmente, se utiliza una línea de corte para determinar si una persona es considerada pobre multidimensionalmente.</p></font>\n"
                + "        <br>\n"
                + "        <center><div>  <img src=\"https://cdn.pixabay.com/photo/2017/12/25/22/36/poverty-3030389_960_720.jpg\" width=\"340\"/></div>\n"
                + "        </center>\n"
                + "        <font color='white' face='Tahoma' size='3'>\n"
                + "        <p>Además de la metodología de Alkire y Foster, se presentan otras opciones métricas para medir la pobreza multidimensional, como el Índice de Pobreza Multidimensional (IPM) utilizado en América Latina y el Índice de Privación Material Severa (IPMS) utilizado en Europa. Estos índices también tienen en cuenta diferentes dimensiones y aplican diferentes metodologías para calcular la pobreza multidimensional. Se mencionan experiencias de medición de pobreza multidimensional en América Latina y Europa. En América Latina, se destaca la experiencia de México, que ha implementado el Índice de Pobreza Multidimensional (IPM) adaptado a su contexto nacional. Este índice considera diferentes dimensiones, como la educación, la salud y el nivel de vida, y ha permitido una mejor comprensión de la pobreza en el país.</p></font>\n"
                + "        <br>\n"
                + "        <center><img src=\"https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg\" width=\"440\"></center>\n"
                + "        <br>\n"
                + "        <br>\n"
                         + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://news.un.org/es/story/2019/10/1463292\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://https://canaltrece.com.co/noticias/algunos-obstaculos-de-los-objetivos-de-desarrollo-sostenible-en-america-latina-y-colombia/\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://canaltrece.com.co/noticias/algunos-obstaculos-de-los-objetivos-de-desarrollo-sostenible-en-america-latina-y-colombia/\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://youtu.be/CLq6tykbIrk?si=HSlf1spwZ5DYjIO-\">VIDEO</a></p>\n"
            
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
        setVisible(false); // ocultar la ventana
        dispose(); // destruir la ventana 
        ca.setVisible(true); // mostrar la ventana  
    }

    public void evento_jbCapitulo_3() {
        cap3.setVisible(true);
        setVisible(false); // ocultar la ventana 
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 4" y ocultar la ventana actual.
     */
    public void evento_jbsig(){
        Capitulo_4 Capitulo_4 = new Capitulo_4(ca);
        Capitulo_4.setVisible(true);
        setVisible(false);
    }
        /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 2" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_2 Capitulo_2 = new Capitulo_2(ca);
        Capitulo_2.setVisible(true);
        setVisible(false);
    }
}
