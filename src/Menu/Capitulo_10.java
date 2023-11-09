/**
 * Propósito: Clase que representa el capitulo sobre el ODS 1 en america latina.
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 3/10/2023
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
 * Clase que representa la ventana del "Capítulo 10".
 */
public final class Capitulo_10 extends JFrame {

    JEditorPane editor;
    Capitulo_10 cap10;
    Capitulos ca;
    JButton jbVolver, jbCapitulo_10,jbsig,jbant,jbencuesta;
    /**
     * Constructor de la clase Capitulo_10.
     *
     * @param obj El objeto Capitulos al que pertenece esta ventana.
     */
    public Capitulo_10(Capitulos obj) {
        super("Capitulo 10");
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

        JLabel jlTitulo = new JLabel("Capitulo 10");
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
        jbencuesta = new JButton("Encuesta");
        jbencuesta.setBounds(570, 630, 100, 30);
        jbencuesta.addActionListener((e) -> {
            evento_jbEncuesta();
        });
        add(jbencuesta);
        
        editor = new JEditorPane();
        editor.setContentType("text/html");

        URL url = getClass().getResource("imagenes/logo_duke.png");

editor.setText(
    "<!DOCTYPE html>\n"
    + "<html>\n"
    + "    <head>\n"
    + "        <title>Implementación del Primer ODS en América Latina</title>\n"
    + "    </head>\n"
    + "    <body bgcolor=\"#181818\">\n"
    + "        <font color=\"white\" face=\"Tahoma\">\n"
    + "            <center><h1>Implementación del Primer ODS en América Latina - Erradicar la Pobreza Extrema y el Hambre</h1></center>\n"
    + "        </font>\n"
    + "        <hr>\n"
    + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
    + "            <p>La implementación del primer Objetivo de Desarrollo Sostenible (ODS) en América Latina, que se enfoca en erradicar la pobreza extrema y el hambre, implica una serie de estrategias y acciones clave que han sido fundamentales para abordar estos desafíos.</p>\n"
    + "            <p>Uno de los enfoques más comunes ha sido la implementación de programas de transferencia de efectivo directo a familias en situación de pobreza. Estos programas ofrecen un sustento económico esencial para las poblaciones más vulnerables y les permiten satisfacer sus necesidades básicas. A través de estos programas, se busca no solo aliviar la pobreza extrema inmediata, sino también proporcionar a las familias los recursos necesarios para mejorar su calidad de vida a largo plazo, como acceder a una mejor alimentación, educación y atención médica.</p>\n"
    + "            <p>El fomento de la agricultura sostenible se ha convertido en una pieza clave en la lucha contra el hambre en América Latina. La capacitación de agricultores en prácticas sostenibles y el apoyo a la producción de alimentos han contribuido a mejorar la seguridad alimentaria en la región. La promoción de prácticas agrícolas respetuosas con el medio ambiente no solo garantiza una fuente sostenible de alimentos, sino que también reduce la presión sobre los recursos naturales y ayuda a mitigar el cambio climático.</p>\n"
    + "            <p>El acceso a una educación de calidad y a servicios de salud asequibles es esencial para romper el ciclo de la pobreza. Varios países han desarrollado programas que buscan eliminar las barreras que impiden a las poblaciones marginadas acceder a estos servicios fundamentales. Esto no solo mejora la calidad de vida de las personas, sino que también las empodera al proporcionarles las herramientas necesarias para participar plenamente en la sociedad y la economía.</p>\n"
    + "            <p>La creación de empleo y el fomento del emprendimiento se han convertido en motores para el crecimiento económico y la reducción de la pobreza en América Latina. Políticas y programas destinados a promover la inversión, mejorar el entorno empresarial y apoyar a las pequeñas y medianas empresas han sido cruciales para este fin. Estas iniciativas generan oportunidades laborales y fomentan el espíritu emprendedor, lo que a su vez contribuye al crecimiento económico y a la disminución de la pobreza.</p>\n"
    + "            <p>La desigualdad económica y social es un obstáculo clave en la erradicación de la pobreza extrema. Este desafío se aborda mediante la implementación de medidas que buscan reducir la brecha entre los estratos sociales, como reformas fiscales progresivas, políticas de inclusión social y programas de transferencia condicionada que benefician a los grupos más vulnerables. Estos esfuerzos buscan garantizar que los beneficios del desarrollo lleguen a todos los sectores de la sociedad, reduciendo así las disparidades económicas y sociales.</p>\n"
    + "            <p>La implementación del primer ODS en América Latina es un proceso complejo y diverso que varía de un país a otro. La colaboración entre organizaciones internacionales, gobiernos y la sociedad civil desempeña un papel crucial en el camino hacia la erradicación de la pobreza extrema y el hambre en esta región dinámica y diversa. La coordinación de esfuerzos entre estos actores es esencial para maximizar el impacto de las políticas y programas implementados.</p>\n"
    + "            <p>El compromiso con la igualdad de género y la inclusión de grupos marginados es esencial en la lucha contra la pobreza extrema. Se han implementado políticas y programas específicos para empoderar a las mujeres, promover su participación en la fuerza laboral y eliminar la discriminación de género. El empoderamiento de las mujeres no solo es un objetivo en sí mismo, sino que también contribuye a reducir la pobreza, ya que las mujeres desempeñan un papel fundamental en el desarrollo económico y social de la región.</p>\n"
    + "            <p>La sostenibilidad ambiental es otro aspecto clave en la implementación del ODS. América Latina ha realizado esfuerzos significativos para proteger sus recursos naturales y reducir la huella ecológica en la región. Esto incluye la promoción de prácticas agrícolas sostenibles, la conservación de áreas naturales y la inversión en energías renovables para reducir la dependencia de combustibles fósiles.</p>\n"
    + "            <p>La cooperación internacional desempeña un papel crucial en el apoyo a los esfuerzos de América Latina para erradicar la pobreza extrema. Se han establecido alianzas con organizaciones internacionales y otros países para compartir buenas prácticas, recursos financieros y conocimientos técnicos. Esta colaboración internacional fortalece la capacidad de los países de la región para abordar desafíos complejos a nivel regional y global.</p>\n"
    + "            <p>La medición de los avances hacia la erradicación de la pobreza y el hambre es fundamental. En este sentido, se utilizan indicadores específicos y métodos de evaluación para medir el progreso en la región y ajustar las políticas y programas en consecuencia. La disponibilidad de datos confiables y la evaluación constante son esenciales para garantizar que se estén logrando avances significativos hacia la consecución de los objetivos.</p>\n"
    + "            <p>En resumen, la implementación del primer ODS en América Latina es un proceso multifacético que requiere la colaboración de múltiples actores y enfoques. A pesar de los desafíos, la región avanza hacia la erradicación de la pobreza extrema y el hambre, marcando un hito en su desarrollo sostenible. La combinación de políticas integrales, la inclusión de todos los sectores de la sociedad y la cooperación a nivel nacional e internacional son esenciales para lograr este objetivo.</p>\n"
    + "            <p><strong>Recursos adicionales:</strong></p>\n"
 + "            <p><a href=\"https://mexico.un.org/es/229749-am%C3%A9rica-latina-y-el-caribe-en-la-mitad-del-camino-hacia-2030-avances-y-propuestas-de\">Enlace 1</a></p>\n"
    + "            <p><a href=\"https://www.rimisp.org/wp-content/files_mf/1516211535DocumentodePosicionIRFfinalESP.pdf\">Enlace 2</a></p>\n"
    + "            <p><a href=\"https://repositorio.cepal.org/server/api/core/bitstreams/cb30a4de-7d87-4e79-8e7a-ad5279038718/content\">Enlace 3</a></p>\n"
    + "<p><strong>Video relacionado:</strong></p>\n"
    + "            <p><a href=\"https://www.youtube.com/watch?v=-8srmzpYU9g\">VIDEO</a></p>\n"
            
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

    public void evento_jbCapitulo_6() {
        cap10.setVisible(true);
        setVisible(false); // ocultar la ventana 
    }
        /**
     * Maneja el evento del botón "Siguiente" para abrir la ventana del "Capítulo 1" y ocultar la ventana actual.
     */
    public void evento_jbsig(){
        Capitulo_1 Capitulo_1 = new Capitulo_1(ca);
        Capitulo_1.setVisible(true);
        setVisible(false);
    }
        /**
     * Maneja el evento del botón "Anterior" para abrir la ventana del "Capítulo 9" y ocultar la ventana actual.
     */
    public void evento_jbant(){
        Capitulo_9 Capitulo_9 = new Capitulo_9(ca);
        Capitulo_9.setVisible(true);
        setVisible(false);
    }
        /**
     * Maneja el evento del botón "Encuesta" para abrir la ventana de Datos y ocultar la ventana actual.
     */
    public void evento_jbEncuesta() {
        Cuestionario_ods preg = new Cuestionario_ods("CUESTIONARIO DE HUMANIDADES");
        setVisible(false); // ocultar la ventana de menu principal
        preg.setVisible(true);
    }

}
