
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

public final class Derechos extends JFrame {

    JEditorPane editor;
    Cons co;
    JButton jbVolver;

    public Derechos(Cons obj) {
        super("Derechos Fundamentales");
        co = obj;
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

    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Derechos Fundamentales");
        jlTitulo.setBounds(0, 0, 1000, 70);
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
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Derechos Fundamentales</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color=\"white\" face=\"Tahoma\">\n"
                + "            <center><h1><font color=\"white\">Definición</font></h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
                + "            <p>Los derechos fundamentales, también conocidos como derechos humanos, son derechos inherentes a todas las personas debido a su condición de seres humanos. Estos derechos son universales, inalienables e indivisibles, lo que significa que se aplican a todas las personas, no pueden ser transferidos ni vendidos, y están interrelacionados e interdependientes. Los derechos fundamentales son una parte fundamental de la ley internacional de derechos humanos y se encuentran reflejados en muchas constituciones nacionales y documentos internacionales.</p>\n"
                + "            <p>Los derechos que pertenecen de manera inherente a toda persona en razón a su dignidad humana sin distinción de raza, condición, sexo o religión y cuentan con una protección judicial reforzada.</p>\n"
                + "            <p>Algunos ejemplos de derechos fundamentales incluyen:</p>\n"
                + "            <p><font color=\"red\">•</font> Derecho a la vida: Todas las personas tienen el derecho a la vida y a la protección contra la pena de muerte, la tortura y otros tratos crueles, inhumanos o degradantes.</p>\n"
                + "            <p><font color=\"red\">•</font> Derecho a la libertad y la seguridad: Las personas tienen el derecho a la libertad y la seguridad personales, lo que implica que no pueden ser detenidas arbitrariamente.</p>\n"
                + "            <p><font color=\"red\">•</font> Derecho a la igualdad: Todas las personas tienen derecho a la igualdad ante la ley y a la protección contra la discriminación por motivos de raza, género, religión, orientación sexual, etc.</p>\n"
                + "            <p><font color=\"red\">•</font> Libertad de expresión: Las personas tienen el derecho a la libertad de expresión, lo que incluye la libertad de opinión y la libertad de recibir y comunicar información.</p>\n"
                + "            <p><font color=\"red\">•</font> Derecho a la educación: Todas las personas tienen derecho a la educación y a la igualdad de oportunidades en el acceso a la educación.</p>\n"
                + "            <br>\n"
                + "            <br>\n"
                + " <center><div> <img src=\"https://www.almendron.com/tribuna/wp-content/uploads/2023/03/los-derechos-fundamentales-en-el-estado-de-derecho.jpg\" width=\"340\"/></div>\n"
                + " <br>\n"
                + " </center>\n"
                + "      <p>Estos son solo algunos ejemplos, y hay muchos otros derechos fundamentales reconocidos en la ley internacional y las constituciones nacionales. La protección y promoción de los derechos fundamentales es fundamental para garantizar la dignidad y el bienestar de todas las personas en una sociedad justa y democrática.</p>\n"
                + "        <h3><p>Información extra sobre el tema</p></h3>\n"
                + "        <br>\n"
                + "        <a target=\"_blank\" href=\"https://www.personeriabogota.gov.co/images/ABC/ABC-Derechos-fundamentales.pdf\"\n>Derechos</a>\n"
                + "        <br>\n"
                + "        <br>\n"
                + "        <a target=\"_blank\" href=\"https://www.mininterior.gov.co/direccion-de-derechos-humanos/derechos-fundamentales\">Derechos Fundamentales</a>\n"
                + "      </font>\n"
                + "    </body>\n"
                + "</html>");

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

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        co.setVisible(true); // mostrar la ventana  
    }
}

