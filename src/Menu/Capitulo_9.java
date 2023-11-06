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

public final class Capitulo_9 extends JFrame {

    JEditorPane editor;
    Capitulo_9 cap9;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_9;

    public Capitulo_9(Capitulos obj) {
        super("Capitulo 9");
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

        JLabel jlTitulo = new JLabel("Capitulo 9");
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
    + "        <title>Desafíos en la Implementación del ODS 1: Erradicar la Pobreza en Todas sus Formas en el Mundo</title>\n"
    + "    </head>\n"
    + "    <body bgcolor=\"#181818\">\n"
    + "        <font color=\"white\" face=\"Tahoma\">\n"
    + "            <center><h1>Desafíos en la Implementación del ODS 1: Erradicar la Pobreza en Todas sus Formas en el Mundo</h1></center>\n"
    + "        </font>\n"
    + "        <hr>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "            <p>La implementación del ODS 1, que se centra en la erradicación de la pobreza en todas sus formas en el mundo, presenta varios desafíos y problemáticas que deben abordarse de manera efectiva.</p>\n"
    + "            <p>Uno de los principales problemas radica en la ambigüedad en los objetivos del ODS 1. Aunque el objetivo general es erradicar la pobreza en todas sus formas, se establece una meta específica de reducción a menos de la mitad de la proporción de personas en pobreza. Esta ambigüedad ha generado un debate en torno a la claridad de su enfoque. Algunos argumentan que esta contradicción puede llevar a confusiones sobre si el objetivo final es eliminar por completo la pobreza o simplemente reducirla a la mitad. Esta falta de claridad puede afectar la definición de estrategias y acciones concretas para abordar la pobreza, lo que resalta la necesidad de una interpretación precisa y unificada de los objetivos.</p>\n"
    + "            <p>Además, se plantea la crítica relacionada con la visión etnocentrista de los ODS y su enfoque en el liderazgo de los países desarrollados. Existe la preocupación de que estos objetivos puedan fortalecer desigualdades y mantener la dependencia de los países en desarrollo hacia las naciones más avanzadas. Esto resalta la importancia de adoptar un enfoque más equitativo y colaborativo en la implementación de los ODS. Se deben promover alianzas y colaboraciones genuinas entre todos los países, independientemente de su nivel de desarrollo, para garantizar que todas las naciones tengan la oportunidad de participar y contribuir de manera significativa a la erradicación de la pobreza, sin perpetuar relaciones desiguales.</p>\n"
    + "            <p>Otro desafío importante está relacionado con la falta de requisitos de transparencia, responsabilidad y respeto por estándares sociales, medioambientales y de derechos humanos fundamentales en las colaboraciones entre el sector público y privado promovidas por los ODS. Esto plantea la preocupación de que las empresas privadas no cumplan adecuadamente con su responsabilidad en la erradicación de la pobreza, lo que podría dar lugar a prácticas comerciales irresponsables y perjudiciales para las comunidades y el medio ambiente en los países en desarrollo. Es esencial establecer marcos regulatorios sólidos y mecanismos de rendición de cuentas efectivos para garantizar que las alianzas público-privadas contribuyan de manera auténtica a la lucha contra la pobreza y no comprometan la integridad de los objetivos de desarrollo sostenible.</p>\n"
    + "            <p>En resumen, la implementación del ODS 1 presenta desafíos relacionados con la ambigüedad en los objetivos, la equidad en la participación de países y la necesidad de garantizar la responsabilidad en las colaboraciones público-privadas. Estos problemas deben abordarse de manera efectiva para lograr avances significativos en la erradicación de la pobreza en todas sus formas en el mundo.</p>\n"
    + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://news.un.org/es/story/2019/10/1463292\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://revista.une.org/11/ods-1-fin-de-la-pobreza.html\">Enlace 2</a></p>\n"
    + "            <p><a href=\"http://www.lineaverdehuelva.com/lv/consejos-ambientales/conciencia-ambientual/Que-es-el-desarrollo-sostenible.asp\">Enlace 3</a></p>\n"
    + "        </font>\n"
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
        setVisible(false); // ocultar la ventana
        dispose(); // destruir la ventana 
        ca.setVisible(true); // mostrar la ventana 
    }

    public void evento_jbCapitulo_6() {
        cap9.setVisible(true);
        setVisible(false); // ocultar la ventana 
    }

}
