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

public final class Deri extends JFrame {

    JEditorPane editor;
    Matematicas ma;
    JButton jbVolver;

    public Deri(Matematicas obj) {
        super("Derivadas");
        ma = obj;
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

        JLabel jlTitulo = new JLabel("Derivadas");
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
                + "        <title>Aplicaciones de Derivadas</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color='white' face='Tahoma'>\n"
                + "            <center><h1>Aplicaciones de Derivadas</h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color='white' face='Tahoma' size='3'>\n"
                + "            <p>Casi cualquier situación en la que una o varias variables cambien con el tiempo y las causas de dicha variación sean conocidas, la manera de relacionar el efecto con la causa usa derivadas. Por ejemplo, en el ámbito de la investigación de accidentes de tráfico, las ecuaciones establecidas por Newton y Euler hace más de 2 siglos pueden utilizarse para analizar las posibles causas de un accidente.</p>\n"
                + "            <p>A veces, el pavimento presenta un desgaste inadecuado, la presencia de agua o aceite de motor puede reducir el agarre. El uso de derivadas permite plantear ecuaciones para determinar si la causa del accidente estuvo relacionada con el agarre del pavimento, la velocidad inadecuada y otros factores. Las derivadas son herramientas esenciales en la investigación de accidentes, incluso cuando solo se conoce la posición final de los vehículos y las condiciones previas de manera imprecisa.</p>\n"
                + "            <p>En el diseño y lanzamiento de productos o elementos de seguridad, se requiere garantizar resistencia y márgenes de seguridad. El cálculo del comportamiento de estos elementos en diferentes situaciones incluye la simulación del comportamiento bajo condiciones conocidas, donde las derivadas son útiles.</p>\n"
                + "            <p>Actualmente, en casi todas las ingenierías y la mayoría de las ciencias naturales, se requieren derivadas para cálculos ordinarios y para predecir el comportamiento de sistemas bajo condiciones específicas. En economía, se utilizan derivadas para mejorar la visualización de los razonamientos, aunque su papel puede no ser fundamental en modelos preliminares.</p>\n"
                + "            <p>Las derivadas de una función indican en qué intervalos dicha función es creciente o decreciente. Se pueden aplicar a cualquier magnitud que dependa de otra, como el volumen de un gas en función de su temperatura, las ganancias de una empresa en función de su inversión, entre otros. Las derivadas también se utilizan para encontrar los valores de la variable independiente donde la función alcanza máximos o mínimos, lo que es útil, por ejemplo, para determinar la inversión que maximiza las ganancias de una empresa.</p>\n"
                + "        </font>\n"
                + "            <br>\n"
                + "        <center><div> <img src=\"https://matematicasconmuchotruco.files.wordpress.com/2015/02/1.png\" width=\"400\"/></div>\n"
                + " </center>\n"
                + "    </body>\n"
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
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ma.setVisible(true); // mostrar la ventana de menu principal 
    }
}
