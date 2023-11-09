/**
 * Propósito: Clase que representa el capitulo sobre que es el ODS 1.
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
 * Clase que representa la ventana del "Capítulo 1".
 */
public final class Capitulo_1 extends JFrame {

    JEditorPane editor;
    Capitulo_1 cap1;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_1,jbsig,jbant;
    /**
     * Constructor de la clase Capitulo_1.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
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
    /**
     * Crea y configura la interfaz gráfica de la ventana.
     */
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
    "<html>"
    + "<head>"
    + "<title>Objetivo de Desarrollo Sostenible 1: Erradicar la Pobreza</title>"
    + "</head>"
    + "<body bgcolor=\"#181818\" style=\"color: white;\">"
    + "<font face=\"Tahoma\">"
    + "<h1>Objetivo de Desarrollo Sostenible 1: Erradicar la Pobreza</h1>"
    + "<p>El ODS 1 se trata sobre la erradicación en todas sus formas de la pobreza y cuenta con ciertas metas, como las siguientes:</p>"
    + "<ol>"
    + "<li>Para 2030, erradicar la pobreza extrema para todas las personas en el mundo, actualmente medida por un ingreso por persona inferior a 1,25 dólares al día.</li>"
    + "<li>Para 2030, reducir al menos a la mitad la proporción de hombres, mujeres y niños y niñas de todas las edades que viven en la pobreza en todas sus dimensiones con arreglo a las definiciones nacionales.</li>"
    + "<li>Poner en práctica a nivel nacional sistemas y medidas apropiadas de protección social para todos y, para 2030, lograr una amplia cobertura de los pobres y los más vulnerables.</li>"
    + "<li>Para 2030, garantizar que todos los hombres y mujeres, en particular los pobres y los más vulnerables, tengan los mismos derechos a los recursos económicos, así como acceso a los servicios básicos, la propiedad y el control de las tierras y otros bienes, la herencia, los recursos naturales, las nuevas tecnologías y los servicios económicos, incluida la microfinanciación.</li>"
    + "<li>Para 2030, fomentar la resiliencia de los pobres y las personas que se encuentran en situaciones vulnerables y reducir su exposición y vulnerabilidad a los fenómenos extremos relacionados con el clima y a otros desastres económicos, sociales y ambientales.</li>"
    + "<li>Garantizar una movilización importante de recursos procedentes de diversas fuentes, incluso mediante la mejora de la cooperación para el desarrollo, a fin de proporcionar medios suficientes y previsibles para los países en desarrollo, en particular los países menos adelantados, para poner en práctica programas y políticas encaminados a poner fin a la pobreza en todas sus dimensiones.</li>"
    + "<li>Crear marcos normativos sólidos en el ámbito nacional, regional e internacional, sobre la base de estrategias de desarrollo en favor de los pobres que tengan en cuenta las cuestiones de género, a fin de apoyar la inversión acelerada en medidas para erradicar la pobreza.</li>"
    + "<p><strong>Recursos adicionales:</strong></p>\n"
    + "<p><a href=\"https://www.pactomundial.org/ods/1-fin-de-la-pobreza/#:~:text=%C2%BFEn%20qu%C3%A9%20consiste%20el%20Objetivo%20de%20Desarrollo%20Sostenible%201%3F&text=El%20ODS%201%20pretende%20acabar,con%20el%2036%25%20en%201990\" style=\"color: white;\">Enlace 1</a></p>\n"
    + "<p><a href=\"https://www.un.org/sustainabledevelopment/es/poverty/\" style=\"color: white;\">Enlace 2</a></p>\n"
    + "<p><a href=\"https://www.undp.org/es/sustainable-development-goals/fin-pobreza\" style=\"color: white;\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://www.youtube.com/watch?v=20saxk4DU2s\"style=\"color: white;\">VIDEO</a></p>\n"
                + "</ol>"
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

    public void evento_jbCapitulo_1() {
        cap1.setVisible(true);
        setVisible(false); // ocultar la ventana 
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 2" y ocultar la ventana actual.
     */
            public void evento_jbsig(){
        Capitulo_2 Capitulo_2 = new Capitulo_2(ca);
        Capitulo_2.setVisible(true);
        setVisible(false);
    }
                /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 10" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_10 Capitulo_10 = new Capitulo_10(ca);
        Capitulo_10.setVisible(true);
        setVisible(false);
    }

}
