/**
 * Propósito:Clase donde se mostrara informacion sobre la matriz inversa
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
 * La clase `d_inversa` representa una ventana que proporciona información sobre matrices inversas.
 * Permite al usuario aprender sobre el concepto de matriz inversa y los métodos para calcularla.
 */
public final class d_inversa extends JFrame {

    JEditorPane editor;
    Alg al;
    JButton jbVolver;
    /**
     * Constructor de la clase `d_inversa`.
     * @param obj Un objeto de la clase `Alg` que representa la ventana principal.
     */
    public d_inversa(Alg obj) {
        super("Matriz Inversa");
        al = obj;
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
    /**
     * Crea la interfaz de usuario de la ventana.
     */
    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Matriz Inversa");
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
                + "        <title>Matriz Inversa</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color=\"white\" face=\"Tahoma\">\n"
                + "            <center><h1><font color=\"white\">Definición</font></h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
                + "            <p>La matriz inversa es un concepto importante en álgebra lineal, una matriz inversa es una matriz que cuando se multiplica por la matriz original produce la matriz identidad. En otras palabras, si A es una matriz y A^(-1) es su inversa, entonces A * A^(-1) = I, donde I es la matriz identidad.</p>\n"
                + "            <p>No todas las matrices tienen una inversa, y para que una matriz sea invertible (también conocida como no singular), debe cumplir ciertas condiciones, como ser cuadrada (tener el mismo número de filas y columnas) y tener un determinante diferente de cero.</p>\n"
                + "            <p>Existen varios métodos para calcular la matriz inversa de una matriz cuadrada, algunos de los métodos más comunes incluyen:</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de la adjunta (adjugada) y el determinante: Este método implica calcular la matriz adjunta de la matriz original y luego dividirla por el determinante de la matriz original. La matriz adjunta se obtiene reemplazando cada elemento de la matriz por su cofactor transpuesto. Es un método efectivo, pero puede ser computacionalmente costoso para matrices grandes debido a la necesidad de calcular los cofactores.</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de GaussJordan: Este método utiliza operaciones de fila para llevar la matriz original a su forma escalonada reducida por filas y luego a su forma escalonada reducida por filas canónica (la matriz identidad). En cada paso, se aplica la misma operación a la matriz original y a una matriz de identidad, lo que permite obtener la inversa al final del proceso.</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de la matriz aumentada: Este método consiste en formar una matriz aumentada que combine la matriz original y la matriz identidad. Luego, se utiliza la eliminación de Gauss para llevar la mitad izquierda de la matriz aumentada a la forma de la matriz identidad, mientras que la mitad derecha se transforma en la inversa de la matriz original.</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de Gauss-Jordán: Este método utiliza operaciones elementales de fila para reducir la matriz aumentada del sistema a una forma escalonada.</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de cofactores y adjuntas: Este método implica calcular los cofactores de la matriz original y luego construir la matriz adjunta. Finalmente, la matriz inversa se obtiene dividiendo la matriz adjunta por el determinante de la matriz original.</p>\n"
                + "            <br>\n"
                + "            <br>\n"
                + " <center><div> <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1Pie8KwdoKARXjgGFeEKnOqZqx5O5t2Mxew&usqp=CAU\" width=\"340\"/></div>\n"
                + " <br>\n"
                + " </center>\n"
                + "      <p>La elección del método a utilizar depende del tamaño de la matriz y la eficiencia computacional requerida. En la práctica, para matrices pequeñas, el método de adjunta y determinante es comúnmente utilizado, mientras que para matrices más grandes, los métodos de eliminación de Gauss-Jordan o la matriz aumentada suelen ser más eficientes.</p>\n"
                + " <br>\n"
                + " <center><div> <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0JrNm85TwBfXTpIsJU6n7mSihx4Dyy5yM8Q&usqp=CAU\" width=\"340\"/></div>\n"
                + " <br>\n"
                + "      <p>Es importante recordar que no todas las matrices tienen inversas, y las condiciones para que una matriz sea invertible son que sea cuadrada y que su determinante sea distinto de cero.</p>\n"
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
    /**
     * Maneja el evento de "Volver" cuando se presiona el botón.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        al.setVisible(true); // mostrar la ventana de menu principal 
    }
}
