/**
 * Propósito: Clase que representa el capitulo sobre la tecnologia en la lucha contra la pobreza.
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
 * Clase que representa la ventana del "Capítulo 5".
 */
public final class Capitulo_5 extends JFrame {

    JEditorPane editor;
    Capitulo_5 cap5;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_5,jbsig,jbant;
    /**
     * Constructor de la clase Capitulo_5.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_5(Capitulos obj) {
        super("Capitulo 5");
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

        JLabel jlTitulo = new JLabel("Capiulo 5");
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
    + "        <title>Innovación Social y Tecnológica en la Lucha Contra la Pobreza</title>\n"
    + "    </head>\n"
    + "    <body bgcolor=\"#181818\">\n"
    + "        <font color=\"white\" face=\"Tahoma\">\n"
    + "            <center><h1>Innovación Social y Tecnológica en la Lucha Contra la Pobreza</h1></center>\n"
    + "        </font>\n"
    + "        <hr>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "            <p>La innovación social y tecnológica ha demostrado ser una herramienta poderosa en la lucha contra la pobreza y en la mejora de las condiciones de vida de las comunidades más vulnerables. En un mundo cada vez más digitalizado, la tecnología se ha convertido en un vehículo clave para abordar los desafíos sociales y económicos.</p>\n"
    + "            <p>Un ejemplo destacado de esta sinergia entre innovación social y tecnología es el proyecto 'Dos Pasos por Delante' en Córdoba, España. Este proyecto ilustra cómo la innovación social puede utilizar la tecnología para anticiparse a las necesidades de la comunidad, identificar recursos y optimizar la ayuda a través de una plataforma en línea. Esto ha permitido una respuesta más eficiente y oportuna a las demandas de la población afectada por la pandemia de la COVID-19.</p>\n"
    + "            <p>La relación entre innovación social y tecnología se ha vuelto cada vez más estrecha, y ha surgido el término 'innovación social tecnológica' para describir esta forma de abordar los problemas sociales. En este enfoque, la tecnología se convierte en un elemento central de las soluciones, siendo indispensable para su comprensión y aplicación.</p>\n"
    + "            <p>Un ejemplo concreto de innovación social tecnológica es la empresa social Koiki. Esta empresa utiliza la tecnología para proporcionar servicios de transporte sostenible y personalizado, al mismo tiempo que promueve la integración laboral de personas con barreras a la inclusión. A través de una aplicación móvil, los usuarios pueden realizar compras en línea y seleccionar como lugar de entrega la dirección de un 'koiki' de su barrio. Estos repartidores, utilizando medios de transporte sostenibles como caminar o andar en bicicleta, se encargan de recibir los paquetes y entregarlos a los destinatarios en el momento indicado. Koiki no solo ofrece un servicio eficiente, sino que también contribuye a mejorar la calidad de vida en los barrios al reducir el tráfico, el ruido y las emisiones de CO2, lo que tiene un impacto positivo en el medio ambiente y en la comunidad.</p>\n"
    + "            <p>En resumen, la combinación de innovación social y tecnología tiene el potencial de abordar problemas sociales y económicos de manera más efectiva, proporcionando soluciones creativas y sostenibles. Estos ejemplos demuestran cómo la tecnología puede ser utilizada para el beneficio de las comunidades y cómo la innovación social tecnológica puede marcar la diferencia en la lucha contra la pobreza y la promoción de la inclusión social.</p>\n"
    + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://puentesdigitales.com/2017/05/06/tecnologia-para-acabar-con-el-hambre-y-la-pobreza/\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://www.un.org/es/desa/forum-science-technology-innovation\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://www.bbva.com/es/como-usar-la-tecnologia-para-luchar-contra-la-pobreza-y-exclusion-social/\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://youtu.be/bafvyuddZ8c?si=9a4Pe8BrnvQ8DoZy\">VIDEO</a></p>\n"         
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

    public void evento_jbCapitulo_5() {
        cap5.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 6" y ocultar la ventana actual.
     */
        public void evento_jbsig(){
        Capitulo_6 Capitulo_6 = new Capitulo_6(ca);
        Capitulo_6.setVisible(true);
        setVisible(false);
    }
            /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 4" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_4 Capitulo_4 = new Capitulo_4(ca);
        Capitulo_4.setVisible(true);
        setVisible(false);
    }
}
