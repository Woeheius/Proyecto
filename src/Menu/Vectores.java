/**
 * Propósito:Clase donde se mostrara informacion sobre los vectores,que son y aplicaciones
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
public final class Vectores extends JFrame {

    JEditorPane editor;
    Fisica fi;
    JButton jbVolver;
    
    public Vectores(Fisica obj) {
        super("Vectores");
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
        JLabel jlTitulo = new JLabel("Vectores");
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
                + "    <title>Vectores en Física</title>\n"
                + "</head>\n"
                + "<body bgcolor=\"#181818\">\n"
                + "    <h1><font color='white'>¿Qué son los vectores?</font></h1>\n"
                + "    <p><font color='white'>Los vectores son conceptos fundamentales en la física que se utilizan para representar cantidades que tienen magnitud y dirección. En contraste con las cantidades escalares, como la masa o la temperatura, que solo tienen magnitud, los vectores incorporan información sobre la dirección en la que actúa la cantidad medida. Los vectores son esenciales para describir el movimiento y las interacciones entre objetos en el mundo físico.</font></p>\n"
                + "    <h2><font color='white'>¿Qué son los vectores?</font></h2>\n"
                + "    <p><font color='white'>Los vectores son entidades matemáticas que constan de dos componentes principales: magnitud y dirección. La magnitud se refiere al valor numérico de la cantidad que se está midiendo, como la velocidad en kilómetros por hora o la fuerza en newtons. La dirección especifica hacia dónde apunta el vector en el espacio tridimensional. Por ejemplo, un vector de velocidad puede tener una magnitud de 30 km/h y apuntar hacia el norte.</font></p>\n"
                + "<center><div><img src=\"https://2.bp.blogspot.com/-wZCSm6FFL5Y/Wp8tkpLjneI/AAAAAAAAVQs/1XE9LlKfxF8cjElPF_kCGxmfBR0e6_k0QCLcBGAs/s1600/1.png\" width=\"400\"/></div>\n"
                + "    <h2><font color='white'>¿Para qué sirven los vectores en física?</font></h2>\n"
                + "    <p><font color='white'>Los vectores se utilizan en la física para describir una amplia variedad de fenómenos. Algunos ejemplos de su aplicación incluyen:</font></p>\n"
                + "    <ol style=\"color:white;\">\n"
                + "        <li><font color='white'>Descripción del movimiento: Los vectores de posición y velocidad se utilizan para describir el movimiento de objetos en el espacio. La posición de un objeto en un momento dado se representa como un vector desde un punto de referencia, y la velocidad se describe como la tasa de cambio de la posición.</font></li>\n"
                + "        <li><font color='white'>Fuerzas: Las fuerzas son vectores que describen la interacción entre objetos. Las leyes de Newton se expresan en términos de vectores de fuerza, lo que permite predecir el movimiento de los cuerpos.</font></li>\n"
                + "        <li><font color='white'>Momento lineal: El momento lineal, que es el producto de la masa de un objeto y su velocidad, se representa como un vector. Esto es esencial para entender la conservación del momento lineal en colisiones y otras interacciones.</font></li>\n"
                + "        <li><font color='white'>Campos vectoriales: Los vectores se utilizan para describir campos físicos como el campo eléctrico, el campo magnético y el campo de gravedad. Estos campos tienen magnitud y dirección en cada punto del espacio.</font></li>\n"
                + "    </ol>\n"
                + "<center><div><img src=\"https://ik.imagekit.io/smdxc0e2g3/userscontent2-endpoint/images/0d888b8d-0226-4eda-bf52-463aa7c0dcc9/0ce4120c-48a8-4af9-a7ab-38a858afe07ajpeg?tr=w-280,rt-0\" width=\"400\"/></div>\n"
                + "    <h2><font color='white'>¿Cómo graficar vectores en física?</font></h2>\n"
                + "    <p><font color='white'>Graficar vectores en física es una forma de representar visualmente estas cantidades. Para hacerlo, sigue estos pasos:</font></p>\n"
                + "    <ol style=\"color:white;\">\n"
                + "        <li><font color='white'>Determine la magnitud y dirección del vector: Asegúrate de tener valores numéricos para la magnitud y una descripción clara de la dirección del vector en términos de ángulos o coordenadas.</font></li>\n"
                + "        <li><font color='white'>Elige una escala: Decide una escala adecuada para tu dibujo. Por ejemplo, podrías acordar que un centímetro en el papel representa una cierta cantidad de unidades de magnitud en tu vector.</font></li>\n"
                + "        <li><font color='white'>Dibuja una línea recta: Dibuja una línea recta en la dirección del vector. Esta línea será la flecha del vector.</font></li>\n"
                + "        <li><font color='white'>Etiqueta el vector: En el extremo de la línea, coloca una etiqueta que indique la magnitud y la dirección del vector.</font></li>\n"
                + "        <li><font color='white'>Añade un sistema de coordenadas: Si es necesario, dibuja un sistema de coordenadas que te ayude a ubicar el vector en un contexto espacial.</font></li>\n"
                + "        <li><font color='white'>Puedes usar un transportador o un compás para medir y dibujar ángulos con precisión si es necesario.</font></li>\n"
                + "    </ol>\n"
                + "    <p><font color='white'>Graficar vectores es una herramienta fundamental en física, ya que proporciona una representación visual de las cantidades vectoriales, lo que facilita la comprensión de los conceptos y la resolución de problemas físicos.</font></p>\n"
                + "<center><div><img src=\"https://i.ytimg.com/vi/w05zw7JdZz8/maxresdefault.jpg\" width=\"400\"/></div>\n"
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
