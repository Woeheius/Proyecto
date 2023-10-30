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
import javax.swing.plaf.ColorUIResource;

public final class Determinantes extends JFrame{
    
    JEditorPane editor;
    Alg al;
    JButton jbVolver; 
    
    
    public Determinantes(Alg obj){
        super("Area Determinantes");
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
    
    public void crearGUI(){
        JLabel jlTitulo = new JLabel("Area Determinantes");
        jlTitulo.setBounds(0, 0, 1000, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.darkGray);
        jlTitulo.setForeground(Color.WHITE);
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
                
  "<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Sistemas de Ecuaciones</title>\n" +
"    </head>\n" +
"    <body bgcolor=\"#181818\">\n" +
"        <font color=\"white\" face=\"Tahoma\">\n" +
"            <center><h1><font color=\"white\">Determinantes</font></h1></center>\n" +
"        </font>\n" +
"        <hr>\n" +
"        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n" +
"            <p>Es un proceso matemático que se calcula a un matriz cuadrada y da como resultado un número. Si el número es igual a 0 se concluye que el sistema de la matriz es linealmente dependiente, una o varias ecuaciones es un múltiplo escalar de la otra o combinación lineal..</p>\n" +
"            <p>En matemáticas, los determinantes son útiles para determinar ciertas propiedades de las matrices y se utilizan en una variedad de aplicaciones, como la resolución de sistemas de ecuaciones lineales, el cálculo de áreas y volúmenes, y la inversión de matrices.</p>\n" +
"            <p>El determinante de una matriz cuadrada (una matriz con el mismo número de filas y columnas) se denota comúnmente como \"det(A)\" o \"|A|\" y se calcula mediante una fórmula específica que depende del tamaño de la matriz. Para una matriz de 2x2, el determinante se calcula de la siguiente manera::</p>\n" +
"            <br>\n" +
" <center><div> <img src=\"https://www.neurochispas.com/wp-content/uploads/2023/03/Formula-de-determinante-de-matriz-2x2-1.png\" width=\"340\"/></div>\n" +
"            <p>Para una matriz de 3x3, el determinante se calcula utilizando la Regla de Sarrus:</p>\n" +          
"            <br>\n" +          
" <center><div> <img src=\"https://images.hive.blog/DQmZwPokzAJLUki2kfqw4oHSbYxtQD22hjVztbXJv74vMao/image.png\" width=\"340\"/></div>\n" +          
"            <p>Para matrices de tamaño mayor, se utilizan métodos como la expansión por cofactores o el método de gauss buscando los ceros por debajo.</p>\n" +
"            <br>\n" +           
" <center><div> <img src=\"https://math.libretexts.org/@api/deki/files/65056/clipboard_ef2e398c710707025a9bab7d277a444b6.png\" width=\"340\"/></div>\n" +
"        </font>\n" +
" </center>\n" +
"  <p>Propiedades de los determinantes: Las propiedades de los determinantes son reglas matemáticas que se aplican a las matrices cuadradas (matrices con el mismo número de filas y columnas) para calcular y simplificar el valor de su determinante, que es un número que se asocia a la matriz y proporciona información importante sobre la misma. Estas propiedades son útiles para facilitar el cálculo de determinantes de matrices más grandes o para realizar operaciones algebraicas en problemas matriciales. Algunas de las propiedades más importantes de los determinantes incluyen:</p>\n" + 
"            <br>\n" + 
"            <p><font color=\"red\">✔</font> El determinante de una matriz es un número real o complejo.</p>\n" +
"            <p><font color=\"red\">✔</font> Si el determinante de una matriz cuadrada es igual a cero, se dice que la matriz es singular. Esto significa que la matriz no tiene inversa.</p>\n" +
"            <p><font color=\"red\">✔</font> Intercambiar dos filas de una matriz cambia el signo del determinante.</p>\n" +
"            <p><font color=\"red\">✔</font> Si dos filas de una matriz son iguales, el determinante es cero.</p>\n" +
"            <p><font color=\"red\">✔</font> Si se multiplica una fila de una matriz por un escalar, el determinante se multiplica por ese mismo escalar.</p>\n" +
"            <p><font color=\"red\">✔</font> El determinante de una matriz triangular (donde todos los elementos por encima o por debajo de la diagonal principal son cero) es el producto de los elementos de la diagonal principal.</p>\n" +
"            <br>\n"+
"            <br>\n" +
" <center><div> <img src=\"https://static.eduboom.es/eduboom_es/uploads/vidimgs/21062021-Ejercicio-Propiedades-de-los-determinantes.jpg\" width=\"340\"/></div>\n" +
" <br>\n"+
"      <p>Estos son algunos de los métodos más comunes y utilizados para calcular determinantes:</p>\n" +
"            <p><font color=\"red\">✔</font> Regla de Sarrus: Utilizado para matrices 3x3, como se mostró anteriormente.</p>\n" +
"            <p><font color=\"red\">✔</font> Expansión por cofactores: Este método se utiliza para matrices de cualquier tamaño y se basa en la relación entre los determinantes de una matriz y sus submatrices más pequeñas.</p>\n" +
"            <p><font color=\"red\">✔</font> Método de Laplace: Similar a la expansión por cofactores, este método se utiliza para matrices de cualquier tamaño y consiste en expresar el determinante en términos de determinantes más pequeños.</p>\n" +
"            <p><font color=\"red\">✔</font> Diagonalización de matrices: Para matrices diagonalizables, el determinante es el producto de los autovalores de la matriz.</p>\n" +
"      </font>\n" +
"    </body>\n" +
"</html>");

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
        al.setVisible(true); // mostrar la ventana de menu principal 
    }
}
     