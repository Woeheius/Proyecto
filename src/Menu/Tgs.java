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

public class Tgs extends JFrame{
    JEditorPane editor;
    MenuPrincipal mp;
    JButton jbVolver;
    
    public Tgs(MenuPrincipal obj){
        super("Area de Teoria General de Sistemas");
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
    
    public void crearGUI(){
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/laptop.png"));
        JLabel jlTitulo = new JLabel("Area de Teoria General de Sistemas", ic, JLabel.CENTER);
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
    "<html>" +
    "<head>" +
    "<style>" +
    "body {" +
    "  background-color: #2E2E2E; /* Color de fondo proporcionado (#2E2E2E) */" +
    "  color: white; /* Color del texto en blanco */" +
    "  font-family: Arial, sans-serif;" +
    "  font-size: 14px;" +
    "}" +
    "h2 {" +
    "  color: #FFFFFF;" +
    "  background-color: #333333;" +
    "  padding: 10px;" +
    "}" +
    "p {" +
    "  margin: 10px 0;" +
    "}" +
    "</style>" +
    "</head>" +
    "<body>" +
    "<h2>Teoría General de Sistemas</h2>" +
    "<p><strong style=\"font-size: 16px;\">1. Introducción a la Teoría General de Sistemas:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - La teoría general de sistemas es un enfoque interdisciplinario que se utiliza para analizar y comprender sistemas complejos, considerando sus componentes, interacciones y su relación con su entorno. Aplicada a un proyecto, implica verlo como un sistema integral con múltiples componentes y relaciones." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - La aplicación de la teoría general de sistemas ayuda a entender cómo el proyecto se integra en el sistema educativo más amplio. Permite identificar sus subsistemas, como la aplicación en sí misma, el plan de estudios y las estrategias de enseñanza. Esta perspectiva facilita el diseño y la gestión de la aplicación al considerar sus interacciones con otros elementos del sistema educativo. Además, permite evaluar cómo cambios en un subsistema pueden afectar a otros, lo que es crucial para tomar decisiones educativas efectivas. En resumen, la teoría de sistemas proporciona una estructura y un enfoque holístico para entender y mejorar el proyecto." +
    "</p>" +
    "        <center><div>  <img src=\"https://be5c1dcd29.clvaw-cdnwnd.com/5e2fdbb6744992732d1ed8ca78424d55/200000011-c308dc4053/21139568_s%20%281%29.jpg?ph=be5c1dcd29\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">2. Elementos de un sistema:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - Los elementos de un sistema son los componentes y partes que lo conforman. En el contexto del proyecto, se pueden identificar elementos como la aplicación misma, el conocimiento de los estudiantes, los desarrolladores de software, organismos reguladores y otros aplicativos de la competencia." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - Los elementos del sistema tienen un impacto significativo en el proyecto. La aplicación es un subsistema dentro del sistema educativo más amplio, y debe integrarse de manera efectiva con otros elementos, como el plan de estudios y las instituciones educativas. El conocimiento de los estudiantes es una entrada clave, ya que el proyecto busca mejorar este conocimiento. Los desarrolladores de software son responsables de mantener y mejorar la aplicación, mientras que los organismos reguladores pueden establecer estándares y regulaciones que el proyecto debe cumplir. La competencia y otros aplicativos similares también influyen en el entorno en el que opera el proyecto. Considerar estos elementos es esencial para el diseño, la implementación y la evaluación efectiva del proyecto educativo." +
    "</p>" +
   "        <center><div>  <img src=\"https://i0.wp.com/www.ensambledeideas.com/wp-content/uploads/2020/04/brain-2029391_960_720.png?resize=300%2C269&ssl=1\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">3. Tipos de sistemas:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - Los tipos de sistemas se refieren a las clasificaciones o categorías en las que se pueden agrupar los sistemas en función de diversas características. En el contexto del proyecto, se han identificado varios tipos de sistemas según diferentes criterios, como su interacción con el ambiente, su entidad, su complejidad y su comportamiento." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - Estos tipos de sistemas proporcionan una clasificación que ayuda a comprender mejor la naturaleza de la aplicación. Por ejemplo, al considerar que el proyecto es un sistema cerrado, se entiende que su interacción principal es con los usuarios y que no intercambia materia con el ambiente. Esto influye en cómo se diseñan las funciones y características de la aplicación, centrándose en atender las necesidades de los usuarios. La clasificación según su entidad como sistema modelo refleja cómo la aplicación simplifica y representa la realidad, lo que es crucial para lograr un aprendizaje efectivo. Además, al reconocer que el proyecto es un sistema regulado, se destaca la importancia de la interacción humana para su funcionamiento, lo que influye en el diseño de la interfaz y la usabilidad. Estas clasificaciones ayudan a definir el enfoque y los objetivos del proyecto." +
    "</p>" +
    "        <center><div>  <img src=\"https://www.tecnologias-informacion.com/tipos.jpg\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">4. Propiedades de los sistemas:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - Las propiedades de los sistemas son características o atributos que describen cómo funcionan los sistemas. En el proyecto, se han identificado propiedades como la recursividad, la homeostasis, la sinergia, la entropía, la neguentropía, la permeabilidad, la centralización, la descentralización, la integración, la independencia, la adaptabilidad, la mantenibilidad, la estabilidad, la armonía, la optimización y la suboptimización." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - Cada una de estas propiedades tiene un impacto en el diseño, el funcionamiento y la gestión del proyecto. Por ejemplo, la recursividad se refleja en cómo la aplicación se considera un subsistema en el sistema educativo más amplio. La sinergia es relevante, ya que la aplicación trabaja junto con la teoría para lograr los objetivos de aprendizaje. La entropía y la neguentropía se relacionan con cómo el proyecto aborda el desorden inicial en el conocimiento de los estudiantes y lo organiza. La adaptabilidad es esencial debido a la naturaleza dinámica del sistema educativo. La estabilidad y la armonía son importantes para garantizar que la aplicación funcione de manera efectiva y sea compatible con el contexto educativo. La optimización se aplica para mejorar el rendimiento, mientras que se evita la suboptimización al replantear los objetivos si es necesario. Estas propiedades ayudan a modelar y mejorar el proyecto para lograr sus objetivos educativos." +
    "</p>" +
    "        <center><div>  <img src=\"https://0701.static.prezi.com/preview/v2/pyeksogwpdbt2q4ex7h2nx5z6d6jc3sachvcdoaizecfr3dnitcq_3_0.png\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">5. Enfoque de Sistemas para la Solución de Problemas:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - El enfoque de sistemas para la solución de problemas implica una serie de pasos para abordar un problema de manera integral, considerando múltiples variables y relaciones. Se enfoca en identificar el problema, analizar el sistema, plantear y evaluar alternativas de solución, diseñar el sistema, implementarlo, evaluarlo y mantenerlo." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - Este enfoque guía la forma en que el proyecto aborda los problemas y desafíos educativos. Ayuda a identificar el problema central, que en este caso es mejorar el aprendizaje de los estudiantes. Luego, se analiza el sistema educativo para comprender sus procesos y flujos de información. Se plantean y evalúan alternativas de solución, lo que puede incluir el diseño y desarrollo de la aplicación. La implementación se centra en garantizar que la aplicación se instale y configure de manera efectiva. La evaluación se enfoca en medir la efectividad de la aplicación y el aprendizaje de los estudiantes. El mantenimiento implica corregir errores y adaptarse a las necesidades cambiantes. Este enfoque garantiza una aproximación completa y sistemática a la mejora de la educación a través del proyecto." +
    "</p>" +
    "        <center><div>  <img src=\"https://img.freepik.com/vector-gratis/equipo-gestores-crisis-resolviendo-problemas-empresarios-empleados-bombilla-desenredando-marana-ilustracion-vector-trabajo-equipo-solucion-concepto-gestion_74855-10162.jpg?size=626&ext=jpg&ga=GA1.1.386372595.1698537600&semt=ais\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">6. Rasgos Característicos del Sistema:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - Los rasgos característicos del sistema son las cualidades distintivas que definen cómo opera y se relaciona un sistema con su entorno. En el contexto del proyecto, estos rasgos pueden incluir la cantidad de elementos, el acoplamiento, la actividad, el nivel de resolución, las transiciones, el estado, el comportamiento, el programa, entre otros." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - Cada uno de estos rasgos proporciona una comprensión más profunda del proyecto educativo. Por ejemplo, la cantidad de elementos externos, como la competencia en la industria y las relaciones con proveedores, puede influir en la adopción y el éxito del proyecto. El acoplamiento entre los componentes internos y externos es esencial para el diseño eficiente y mantenible de la aplicación. La actividad se refleja en la evolución de la matrícula estudiantil y las tasas de reprobación, lo que afecta las estrategias de enseñanza. El nivel de resolución ayuda a entender cómo se analiza la evolución de las asignaturas y el desempeño de los estudiantes. Las transiciones muestran cómo los estudiantes avanzan entre las asignaturas y la reprobación se refleja en su efecto en el proyecto. Estos rasgos característicos son fundamentales para evaluar y mejorar el proyecto educativo." +
    "</p>" +
    "        <center><div>  <img src=\"https://media.licdn.com/dms/image/C4D12AQHOmQPU0-yxnw/article-cover_image-shrink_600_2000/0/1631281660496?e=2147483647&v=beta&t=AKl87EUW_qcvO0mm15tUg9r6Q3V3n8fMugrkzH9V25w\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">7. Aplicación de la Entropía y Neguentropía:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - La entropía y la neguentropía son conceptos relacionados con el desorden y la organización en sistemas. La entropía se asocia con el desorden y la falta de organización, mientras que la neguentropía se relaciona con la organización y la reducción del desorden." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - En el proyecto, la entropía se relaciona con el estado inicial del conocimiento de los estudiantes, que a menudo es caótico y desorganizado en áreas como matemáticas, física y álgebra. La aplicación busca reducir la entropía al proporcionar estructura y enfoque en la enseñanza de estos temas. La neguentropía se logra al organizar el conocimiento de los estudiantes y proporcionar herramientas para mejorar la comprensión y reducir el desorden. Estos conceptos son relevantes para entender cómo el proyecto aborda el desorden en el aprendizaje y lo organiza de manera efectiva." +
    "</p>" +
   "        <center><div>  <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9ZH8Oyf_CMkSNGxtFmfamuYQCnNhS6z8SAw&usqp=CAU\" width=\"340\"/></div>\n" +
    "<p><strong style=\"font-size: 16px;\">8. Principio de Organicidad:</strong></p>" +
    "<p>- <em>¿Qué es?</em>" +
    "<br> - El principio de organicidad implica que el proyecto educativo debe considerar todas las interacciones y relaciones entre sus componentes, lo que contribuye a un enfoque holístico." +
    "</p>" +
    "<p>- <em>Cómo influye en el proyecto:</em>" +
    "<br> - Este principio asegura que el proyecto no solo funcione de manera aislada, sino que también mejore y se adapte al sistema educativo en su conjunto. Ayuda a considerar la interacción entre la aplicación y otros componentes, como el plan de estudios y las instituciones educativas, para lograr un impacto educativo positivo y duradero." +
    "</p>" +
   "        <center><div>  <img src=\"https://static.wikia.nocookie.net/astronomia/images/f/f2/P-l-t.jpg/revision/latest?cb=20181129011938\" width=\"340\"/></div>\n" +
   "<p><strong style=\"font-size: 16px;\">9. Elementos del Sistema (Entradas-Salidas):</strong></p>" +
"<p>- <em>¿Qué es?</em>" +
"<br> - Los elementos del sistema se refieren a las entradas (inputs) y salidas (outputs) del proyecto. Las entradas son las variables y datos que ingresan al sistema</p>" +
"<p>- <em>Cómo influye en el proyecto:</em>" +
"<br> - Los elementos del sistema, tanto las entradas como las salidas, son fundamentales para el funcionamiento del proyecto. Las entradas incluyen datos de los estudiantes, el plan de estudios, las estrategias de enseñanza y otros elementos que influyen en el aprendizaje. Las salidas reflejan los resultados, como el progreso de los estudiantes y la efectividad del proyecto. Comprender y gestionar estas entradas y salidas es esencial para lograr los objetivos educativos del proyecto." +
"<center><div><img src=\"https://www.macroscopiosistemico.com/wp-content/uploads/2016/08/abuela-cibernetica-tejiendo.jpg\" width=\"340\"/></div>\n" +
"<p><strong style=\"font-size: 16px;\">10. Cibernética y Control en el Proyecto Educativo:</strong></p>" +
"<p>- <em>¿Qué es?</em>" +
"<br> - La cibernética y el control se refieren al uso de la retroalimentación y la autorregulación para mejorar el proyecto. Implican la monitorización, la evaluación y los ajustes continuos en función de los resultados y los objetivos." +
"<p>- <em>Cómo influye en el proyecto:</em>" +
"<br> - La cibernética y el control son esenciales para garantizar que el proyecto se adapte a las necesidades cambiantes de los estudiantes y el entorno educativo. La retroalimentación de los estudiantes y los datos de rendimiento son cruciales para ajustar la aplicación y las estrategias de enseñanza. Este enfoque de autorregulación garantiza que el proyecto se mantenga relevante y efectivo a lo largo del tiempo." +
"</body>\n"

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
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
