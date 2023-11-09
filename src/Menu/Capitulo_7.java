/**
 * Propósito: Clase que representa el capítulo sobre el impacto de la pandemia en la pobreza.
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
 * Clase que representa la ventana del "Capítulo 7".
 */

public final class Capitulo_7 extends JFrame {

    JEditorPane editor;
    Capitulo_7 cap7;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_7, jbsig, jbant;

    /**
     * Constructor de la clase Capitulo_7.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_7(Capitulos obj) {
        super("Capitulo 7");
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

        JLabel jlTitulo = new JLabel("Capitulo 7");
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
                + "        <title>Impacto de la Pandemia de COVID-19 en los Niveles de Pobreza/title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color=\"white\" face=\"Tahoma\">\n"
                + "            <center><h1>Impacto de la Pandemia de COVID-19 en los Niveles de Pobreza en Colombia</h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
                + "            <p>La pandemia de COVID-19 ha tenido un impacto significativo en Colombia, generando un aumento en los niveles de pobreza y agravando las desigualdades existentes. El confinamiento y la reducción de empleos y salarios han provocado una crisis económica y social sin precedentes en el país.</p>\n"
                + "            <p>El Gobierno Nacional ha respondido a esta crisis implementando políticas de apoyo, como el programa Ingreso Solidario, con el objetivo de brindar ayuda a la población en situación de pobreza y vulnerabilidad. Estos programas de transferencias monetarias y ayudas excepcionales han sido fundamentales para mitigar los efectos adversos de la pandemia en los sectores más afectados.</p>\n"
                + "            <p>Las microsimulaciones realizadas han revelado un impacto devastador en los niveles de pobreza durante la pandemia, con un notable aumento tanto en la pobreza extrema como en la moderada en comparación con los niveles previos a la crisis. Sin embargo, las intervenciones del Gobierno, como los giros extraordinarios de programas sociales, han demostrado ser eficaces en la reducción de la pobreza y en la protección de los hogares más vulnerables.</p>\n"
                + "            <p>Varios factores han contribuido al aumento de la pobreza en este contexto. La pérdida de empleos, la disminución de los ingresos y la interrupción de programas de alimentación escolar han tenido un impacto negativo en las condiciones de vida de muchas familias. Los trabajadores informales y por cuenta propia, que constituyen una parte significativa de la fuerza laboral en Colombia, se vieron particularmente afectados por la pérdida de ingresos y empleos.</p>\n"
                + "            <p>Además, la suspensión de los programas de alimentación escolar ha aumentado la inseguridad alimentaria, ya que muchos niños dependían de estas comidas como fuente importante de nutrición. La falta de acceso a una alimentación adecuada ha sido un desafío adicional que ha afectado a numerosas familias, especialmente a aquellas en situación de vulnerabilidad.</p>\n"
                + "            <p>El Gobierno ha implementado una serie de medidas para mitigar el impacto en la pobreza, que incluyen programas de transferencias monetarias, apoyo a la generación de empleo, como el Programa de Apoyo al Empleo Formal (PAEF), y otras iniciativas destinadas a aliviar la crisis económica y social desencadenada por la pandemia en Colombia.</p>\n"
                + "            <p>En resumen, la pandemia de COVID-19 ha tenido un profundo impacto en los niveles de pobreza en Colombia, con un aumento significativo en la pobreza extrema y moderada. Sin embargo, las políticas de apoyo implementadas por el Gobierno, incluyendo los programas de transferencias monetarias y el apoyo al empleo, han sido esenciales para amortiguar los efectos negativos en la población más vulnerable y para abordar los desafíos económicos y sociales derivados de la pandemia.</p>\n"
                + "            <p><strong>Recursos adicionales:</strong></p>\n"
                + "            <p><a href=\"https://www.bancomundial.org/es/news/feature/2021/12/20/year-2021-in-review-the-inequality-pandemic\">Enlace 1</a></p>\n"
                + "            <p><a href=\"https://www.cepal.org/es/comunicados/pandemia-provoca-aumento-niveles-pobreza-sin-precedentes-ultimas-decadas-impacta#:~:text=Temas-,Pandemia%20provoca%20aumento%20en%20los%20niveles%20de%20pobreza%20sin%20precedentes,la%20desigualdad%20y%20el%20empleo&text=En%20un%20nuevo%20informe%20anual,m%C3%A1s%20que%20el%20a%C3%B1o%20anterior\">Enlace 2</a></p>\n"
                + "            <p><a href=\"https://www.cidob.org/articulos/anuario_internacional_cidob/2022/el_impacto_de_la_pandemia_sobre_la_pobreza_mayor_gravedad_y_por_mas_tiempo\">Enlace 3</a></p>\n"
                + "<p><strong>Video relacionado:</strong></p>\n"
                + "            <p><a href=\"https://www.youtube.com/watch?v=OSco5uIVaj0\">VIDEO</a></p>\n"
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
     * Maneja el evento del botón "Volver" para ocultar la ventana actual y
     * mostrar la ventana de Capitulos.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ca.setVisible(true); // mostrar la ventana de menu principal 
    }

    public void evento_jbCapitulo_6() {
        cap7.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }

    /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del
     * "Capítulo 8" y ocultar la ventana actual.
     */
    public void evento_jbsig() {
        Capitulo_8 Capitulo_8 = new Capitulo_8(ca);
        Capitulo_8.setVisible(true);
        setVisible(false);
    }

    /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo
     * 6" y ocultar la ventana actual.
     */
    public void evento_jbant() {
        Capitulo_6 Capitulo_6 = new Capitulo_6(ca);
        Capitulo_6.setVisible(true);
        setVisible(false);
    }

}
