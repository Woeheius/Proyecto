package Menu;
//
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

public final class Capitulo_2 extends JFrame {

    JEditorPane editor;
    Capitulo_2 cap2;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_2,jbsig,jbant;

    public Capitulo_2(Capitulos obj) {
        super("Capitulo 2");
        ca = obj;
        setSize(1000, 700);
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

        JLabel jlTitulo = new JLabel("Capitulo 2");
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
                + "        <title>Relación del ODS 1 con otros Objetivos de Desarrollo Sostenible en Colombia</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color='white' face='Tahoma'>\n"
                + "            <center><h1>Relación del ODS 1 con otros Objetivos de Desarrollo Sostenible en Colombia</h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color='white' face='Tahoma' size='3'>\n"
                + "            <p>La relación del ODS 1, \"Fin de la pobreza\", con otros Objetivos de Desarrollo Sostenible (ODS) en Colombia es fundamental para comprender cómo el progreso en la reducción de la pobreza tiene un impacto significativo en el desarrollo sostenible del país. Uno de los vínculos más notables se encuentra con el ODS 8, \"Trabajo Decente y Crecimiento Económico\". La reducción de la pobreza está intrínsecamente relacionada con la creación de empleo digno y el fomento de un crecimiento económico sostenible.</p>\n"
                + "            <p>En Colombia, se han implementado políticas y programas orientados a promover la inclusión laboral y mejorar las condiciones de trabajo. Esto incluye la promoción del empleo formal, la protección de los derechos laborales y la igualdad de oportunidades en el mercado laboral. Al reducir la pobreza y proporcionar oportunidades de trabajo digno, se crea un entorno propicio para el crecimiento económico y el desarrollo sostenible. Las personas que salen de la pobreza tienen más recursos para invertir en educación y salud, lo que a su vez contribuye a alcanzar otros ODS, como el ODS 4 (Educación de Calidad) y el ODS 3 (Salud y Bienestar).</p>\n"
                + "            <p>Además, la reducción de la pobreza tiene un impacto positivo en otros ODS, como el ODS 2 (Hambre Cero), al mejorar la capacidad de las personas para acceder a alimentos nutritivos, y el ODS 5 (Igualdad de Género), al empoderar a las mujeres y niñas en situaciones de pobreza. En resumen, el ODS 1 actúa como un catalizador para el logro de múltiples Objetivos de Desarrollo Sostenible en Colombia, creando un efecto positivo y sinérgico en la agenda de desarrollo del país.</p>\n"
                    + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://www.un.org/sustainabledevelopment/es/sustainable-development-goals/#:~:text=Los%20Objetivos%20de%20desarrollo%20sostenible%20son%20el%20plan%20maestro%20para,la%20paz%20y%20la%20justicia\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://www.dnp.gov.co/Prensa_/Noticias/Paginas/colombia-avanza-en-mas-del-72-de-cumplimiento-de-los-ods.aspx\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://minciencias.gov.co/sites/default/files/objetivos_de_desarrollo_sostenible_y_aporte_a_la_cti_v_3.5.pdf\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://www.youtube.com/watch?v=YuQHEAwaj6c&t=168s\"style=\"color: white;\">VIDEO</a></p>\n"
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

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ca.setVisible(true); // mostrar la ventana de menu principal 
    }

    public void evento_jbCapitulo_2() {
        cap2.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
        public void evento_jbsig(){
        Capitulo_3 Capitulo_3 = new Capitulo_3(ca);
        Capitulo_3.setVisible(true);
        setVisible(false);
    }
    public void evento_jbant(){
        Capitulo_1 Capitulo_1 = new Capitulo_1(ca);
        Capitulo_1.setVisible(true);
        setVisible(false);
    }

}
