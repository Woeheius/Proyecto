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

public final class Capitulo_1 extends JFrame {

    JEditorPane editor;
    Capitulo_1 cap1;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_1;

    public Capitulo_1(Capitulos obj) {
        super("Capitulo 1");
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

    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Capitulo 1");
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
    + "        <font color=\"white\" face=\"Tahoma\"> <center><h1>Problemas en la implementación del ODS 1: Erradicar la pobreza en todas sus formas en el mundo</h1></center>\n"
    + "        <hr>\n"
    + "        <h2>Capitulo 4:</h2></font>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\"><h3>Revisa las opciones métricas disponibles para medir la pobreza multidimensional y lograr que el Objetivo de Desarrollo Sostenible 1 de la Agenda 2030 sea universal y comprometa a todos los países. Se destaca la importancia de superar las limitaciones de la tradicional línea de pobreza monetaria y se presenta la metodología de Alkire y Foster como una alternativa flexible y completa.</h3></font>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "        <p>La metodología de Alkire y Foster se basa en la identificación de las dimensiones relevantes para medir la pobreza multidimensional, como la educación, la salud y el nivel de vida. A partir de estas dimensiones, se establecen umbrales que determinan si una persona es considerada pobre o no en cada una de ellas. Se aplican ponderaciones a cada dimensión para reflejar su importancia relativa en la medición de la pobreza. Finalmente, se utiliza una línea de corte para determinar si una persona es considerada pobre multidimensionalmente.</p></font>\n"
    + "    <br>\n"
    + "    <center><div>  <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_WjhmmH4JA50hzsgxN9YD-gHf7ezDXXvCig&usqp=CAU\" width=\"340\"/></div>\n"
    + "</center>\n"
    + "<font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "<p>Además de la metodología de Alkire y Foster, se presentan otras opciones métricas para medir la pobreza multidimensional, como el Índice de Pobreza Multidimensional (IPM) utilizado en América Latina y el Índice de Privación Material Severa (IPMS) utilizado en Europa. Estos índices también tienen en cuenta diferentes dimensiones y aplican diferentes metodologías para calcular la pobreza multidimensional. Se mencionan experiencias de medición de pobreza multidimensional en América Latina y Europa. En América Latina, se destaca la experiencia de México, que ha implementado el Índice de Pobreza Multidimensional (IPM) adaptado a su contexto nacional. Este índice considera diferentes dimensiones, como la educación, la salud y el nivel de vida, y ha permitido una mejor comprensión de la pobreza en el país.</p>\n"
    + "<br>\n"
    + "<center><img src=\"https://www.nueva-iso-14001.com/wp-content/uploads/2020/03/ODS.jpg\" width=\"440\"></center>\n"
    + "<br>\n"
    + "<br>\n"
    + "<p>La medición de la pobreza multidimensional es esencial para comprender la complejidad de este problema y diseñar estrategias efectivas. Al considerar diversas dimensiones, como la salud, la educación y el nivel de vida, se obtiene una imagen más completa de la pobreza y se pueden tomar decisiones informadas.</p>\n"
    + "<p>La erradicación de la pobreza es un objetivo global que requiere la colaboración de gobiernos, organizaciones internacionales y la sociedad civil. El ODS 1 de la Agenda 2030 es un llamado a la acción para abordar esta cuestión fundamental y mejorar la calidad de vida de las personas en todo el mundo.</p>\n"
    + "<p><strong>Recursos adicionales:</strong></p>\n"
    + "<p><a href=\"https://www.un.org/esa/socdev/unpfii/documents/2016/Docs-updates/SPANISH_Backgrounder_2030_Agenda.pdf\">Enlace 1</a></p>\n"
    + "<p><a href=\"https://elpais.com/elpais/2019/08/10/3500_millones/1565448989_143006.html\">Enlace 2</a></p>\n"
    + "<p><a href=\"https://www.iwgia.org/es/ip-i-mi/3776-mi-2020-ods.html\">Enlace 3</a></p>\n"
    + "</font>\n"
    + "</body>\n"
    + "</html>"
);

        editor.setEditable(false);//mostrar solo codigo HTML

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

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        ca.setVisible(true); // mostrar la ventana 
    }

    public void evento_jbCapitulo_1() {
        cap1.setVisible(true);
        setVisible(false); // ocultar la ventana 
    }

}
