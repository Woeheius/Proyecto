/**
 * Propósito: Clase que representa el capitulo sobre el impacto de el ODS 1 en comunidades indigenas.
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
 * Clase que representa la ventana del "Capítulo 4".
 */
public final class Capitulo_4 extends JFrame {

    JEditorPane editor;
    Capitulo_4 cap4;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_4,jbsig,jbant;
    /**
     * Constructor de la clase Capitulo_4.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_4(Capitulos obj) {
        super("Capitulo 4");
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
        JLabel jlTitulo = new JLabel("Capitulo 4");
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
                + "        <title>Desarrollo sostenible en comunidades indígenas</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color='white' face='Tahoma'>\n"
                + "            <center><h1>Desarrollo sostenible en comunidades indígenas</h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color='white' face='Tahoma' size='3'>\n"
                + "            <p>El desarrollo sostenible en comunidades indígenas es un enfoque que busca promover el bienestar de estas comunidades, al mismo tiempo que se protege y conserva su entorno natural y cultural. A través de programas y proyectos específicos, se busca fortalecer la participación y el liderazgo de los pueblos indígenas en la toma de decisiones que afectan sus vidas y territorios.</p>\n"
                + "            <p>Conservación y gestión sostenible del medio ambiente:</p>\n"
                + "            <p>Las comunidades indígenas han demostrado una capacidad única para adaptarse a entornos ecológicamente frágiles y han desarrollado conocimientos profundos sobre los recursos naturales que los rodean. Estos conocimientos se han traducido en prácticas y técnicas complejas para gestionar su hábitat de manera sostenible. Además, los pueblos indígenas consideran que son parte integral de la naturaleza y promueven la conservación y restauración de sus medios naturales como condición previa para participar en otros esfuerzos de desarrollo.</p>\n"
                + "            <p>Desarrollo culturalmente adecuado:</p>\n"
                + "            <p>El desarrollo sostenible en comunidades indígenas también implica respetar y valorar su cultura, tradiciones y formas de vida. Esto implica reconocer y fortalecer su identidad cultural, promover la participación activa de los pueblos indígenas en la toma de decisiones y garantizar que los proyectos y programas de desarrollo sean culturalmente apropiados y respeten sus derechos.</p>\n"
                + "            <p>Participación y empoderamiento de las comunidades indígenas:</p>\n"
                + "            <p>Para lograr un desarrollo sostenible en comunidades indígenas, es fundamental promover la participación y el empoderamiento de estas comunidades. Esto implica garantizar su acceso a recursos y servicios básicos, fortalecer sus capacidades y habilidades, y fomentar su participación activa en la planificación, implementación y evaluación de proyectos y programas de desarrollo.</p>\n"
                + "            <p>Apoyo institucional y financiero:</p>\n"
                + "            <p>El desarrollo sostenible en comunidades indígenas requiere de un apoyo institucional y financiero adecuado.</p>\n"
                    + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://www.iwgia.org/es/ip-i-mi/3776-mi-2020-ods.html\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://elpais.com/elpais/2019/08/10/3500_millones/1565448989_143006.html\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://www.un.org/esa/socdev/unpfii/documents/2016/Docs-updates/SPANISH_Backgrounder_2030_Agenda.pdf\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://youtu.be/NnUGRANj8o4?si=2Jjw2YCzRO7uTQJ8\">VIDEO</a></p>\n"
            
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

    public void evento_jbCapitulo_4() {
        cap4.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 5" y ocultar la ventana actual.
     */
    public void evento_jbsig(){
        Capitulo_5 Capitulo_5 = new Capitulo_5(ca);
        Capitulo_5.setVisible(true);
        setVisible(false);
    }
        /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 3" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_3 Capitulo_3 = new Capitulo_3(ca);
        Capitulo_3.setVisible(true);
        setVisible(false);
    }

}
