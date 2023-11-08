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

public class Sem extends JFrame {

    JEditorPane editor;
    MenuPrincipal mp;
    JButton jbVolver;

    public Sem(MenuPrincipal obj) {
        super("Area de Semenario Universidad");
        mp = obj;
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
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/sully.png"));
        JLabel jlTitulo = new JLabel("Area de Seminario Universidad", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 1000, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(400, 600, 500, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/logo_duke.png");

        editor.setText(
                "<html>\n"
                + "    <head>\n"
                + "        <title>capitulo e </title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color='white' face='Tahoma'>  <center><h1>MATRIZ PESTEL</h1></center>\n"
                + "        <hr>\n"
                + "             <font color='white' face='Tahoma' size ='3'> \n"
                + "             <p>La matriz PESTEL (también conocida como PESTLE o PEST) es una herramienta de análisis estratégico utilizada para evaluar el entorno externo en el que opera una organización. PESTEL es un acrónimo que representa los siguientes factores:</p></font>\n"
                + "        <br>\n"
                + "        <center><div>  <img src=\"https://sumalemarketing.com/wp-content/uploads/2021/04/ANALISIS-PESTEL.png\" width=\"340\"/></div>\n"
                + "        </center>\n"
                + "        <font color='white' face='Tahoma' size ='3'>\n"
                + "        <p>1. Políticos: Se refiere a los aspectos relacionados con el entorno político, como la estabilidad gubernamental, regulaciones, políticas fiscales y comerciales, y la influencia de los gobiernos en los negocios."
                + "        <p>    2. Económicos: Incluye factores económicos que pueden afectar a una organización, como tasas de interés, inflación, tasas de cambio, condiciones económicas globales y locales, entre otros."
                + "        <p>    3. Sociales: Considera aspectos socioculturales, demográficos y de comportamiento de los consumidores que pueden influir en la empresa, como tendencias culturales, cambios en la población y actitudes hacia productos o servicios.</p>"
                + "        <p>    4. Tecnológicos: Se centra en avances tecnológicos, innovación, adopción de tecnología y la velocidad de cambio tecnológico en la industria."
                + "        <p>    5. Ambientales: Aborda cuestiones medioambientales, como regulaciones ambientales, sostenibilidad, conciencia ambiental y la presión para reducir el impacto ambiental."
                + "        <p>    6. Legales: Incluye consideraciones legales que pueden afectar a la organización, como regulaciones laborales, leyes de propiedad intelectual, normativas de seguridad, etc."
                + "        <p>    Al utilizar la matriz PESTEL, las empresas pueden identificar oportunidades y amenazas en su entorno externo, lo que les permite tomar decisiones estratégicas informadas y adaptarse a las condiciones cambiantes del mercado."
                + "                <br>\n"
                + "        <h3><p>Informacion extra sobre el tema</p></h3>\n"
                + "        <a target=\"_blank\" href=\"https://incp.org.co/el-analisis-pest-una-herramienta-para-planificar-tu-estrategia/\">El analisis PEST\n"
                + "una herramienta para planificar tu estrategia</a>\n"
                + "        <br>\n"
                + "        <br>\n"
                + "        <a target=\"_blank\" href=\"https://hbr.org/2008/01/mastering-the-management-system\">Mastering the Management System</a>\n"
                + "        <br>\n"
                + "        <br>\n"
                + "        <a target=\"_blank\" href=\"https://es.eserp.com/articulos/que-es-analisis-pestel/\">Analisis PESTEL.\n"
                + "\n"
                + "</a>\n"
                + "        <h3><p>Video Explicativo</p></h3>\n"
                + "            <a target=\"_blank\" href=\"https://www.youtube.com/watch?app=desktop&v=YuQHEAwaj6c&ab_channel=DanielPerez\"></a>\n"
                + "    </font>\n"
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
        js.setBounds(40, 90, 900, 500);
        add(js);
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
