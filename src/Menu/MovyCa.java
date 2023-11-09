/**
 * Propósito:Clase donde se mostrará información sobre los vectores,que son y aplicaciones
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
 * Clase que representa la ventana de "Vectores".
 */
public final class MovyCa extends JFrame {

    JEditorPane editor;
    Fisica fi;
    JButton jbVolver;

    public MovyCa(Fisica obj) {
        super("Movimiento Parabolico y caida libre");
        fi = obj;
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

        setVisible(true);//a
    }

    public void crearGUI() {
        JLabel jlTitulo = new JLabel("Mov.Parabolico y Caida libre");
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
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <title>Movimiento Parabólico y Caída Libre</title>\n"
                + "</head>\n"
                + "<body bgcolor=\"#181818\">\n"
                + "    <h1><font color='white'>¿Qué es el Movimiento Parabólico?</font></h1>\n"
                + "    <p><font color='white'>El movimiento parabólico es un tipo de movimiento en el que un objeto sigue una trayectoria en forma de parábola bajo la influencia de la gravedad. Este tipo de movimiento se observa comúnmente en lanzamientos de proyectiles, como pelotas arrojadas o disparos de cañones.</font></p>\n"
                + "    <h1><font color='white'>¿Qué es la Caída Libre?</font></h1>\n"
                + "    <p><font color='white'>La caída libre es un caso especial de movimiento parabólico en el que un objeto se mueve solo bajo la influencia de la gravedad, sin ninguna fuerza externa que lo frene. Durante la caída libre, un objeto solo experimenta la aceleración debida a la gravedad, lo que resulta en un movimiento vertical hacia abajo.</font></p>\n"
                + "    <h1><font color='white'>¿Para qué sirve el Movimiento Parabólico y la Caída Libre?</font></h1>\n"
                + "    <p><font color='white'>Estos conceptos tienen diversas aplicaciones en la física y la ingeniería:</font></p>\n"
                + "    <ol style=\"color:white;\">\n"
                + "        <li><font color='white'>Proyectiles: El conocimiento del movimiento parabólico es esencial para calcular y predecir la trayectoria de proyectiles lanzados, como balas o cohetes.</font></li>\n"
                + "        <li><font color='white'>Diseño de parques de atracciones: Las montañas rusas y otras atracciones a menudo utilizan principios de caída libre y movimiento parabólico para crear emocionantes experiencias.</font></li>\n"
                + "        <li><font color='white'>Deporte: En deportes como el lanzamiento de proyectiles, como el lanzamiento de bala o jabalina, se aplican conceptos de movimiento parabólico.</font></li>\n"
                + "        <li><font color='white'>Ingeniería aeroespacial: En el diseño de trayectorias de vuelo para cohetes y naves espaciales, se considera el movimiento parabólico para lograr misiones exitosas.</font></li>\n"
                + "    </ol>\n"
                + "</body>\n"
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

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        fi.setVisible(true); // mostrar la ventana de menu principal 
    }
}
