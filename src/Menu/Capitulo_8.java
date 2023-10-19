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

public final class Capitulo_8 extends JFrame{
    JEditorPane editor; 
    Capitulo_8 cap8;
    Capitulos ca;
    JButton jbVolver,jbCapitulo_8;
    
    
    public Capitulo_8(Capitulos obj){
        super("Capitulo 8");
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
    
    public void crearGUI(){
        
        JLabel jlTitulo = new JLabel("Capitulo 8");
        jlTitulo.setBounds(0, 0, 1000, 80);
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
                       "<!DOCTYPE html>\n" +
    "<html>\n" +
    "    <head>\n" +
    "        <title>La Importancia de la Educación en la Lucha Contra la Pobreza</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color=\"white\" face=\"Tahoma\">\n" +
    "            <center><h1>La Importancia de la Educación en la Lucha Contra la Pobreza</h1></center>\n" +
    "        </font>\n" +
    "        <hr>\n" +
    "        <font color=\"white\" face=\"Tahoma\" size=\"2\">\n" +
    "            <p>La relación entre educación y pobreza es un tema ampliamente discutido en la investigación educativa. Aunque no se puede afirmar que la educación \"saque\" a los pobres de la pobreza, tampoco se puede prescindir de la educación en el combate contra la pobreza. Si bien no existe evidencia empírica que demuestre cómo la educación contribuye al aumento de los ingresos de una persona, se sabe que en forma mayoritaria los pobres carecen de educación o tienen acceso a una educación deficiente.</p>\n" +
    "            <p>La educación popular y la educación no formal tienen como objetivo mejorar las condiciones de vida de los educandos, aunque no hay evidencia empírica de que esto se traduzca en un aumento de los ingresos o en una mayor movilidad ocupacional [3]. Sin embargo, es importante destacar que la educación no formal y popular buscan cambiar la sociedad y acceder a un contexto más igualitario, lo que podría generar una cierta movilidad social y una forma de vida mejor.</p>\n" +
    "            <p>La relación entre educación y pobreza se encuentra en dos coordenadas. Por un lado, está determinada por el contexto socioeconómico del país, como la distribución del ingreso que limita las posibilidades de los niños mexicanos para asistir a la escuela. Por otro lado, se encuentra en las características internas del sistema educacional, como el deficiente desempeño de los maestros en atender situaciones de riesgo de exclusión en el aula.</p>\n" +
    "            <p>La importancia de la educación en la lucha contra la pobreza radica en su capacidad para contribuir a la formación de individuos autónomos, creativos y participativos, así como al mejoramiento del nivel de vida de la sociedad en su conjunto. Aunque no exista una evidencia concluyente sobre cómo la educación se relaciona con el ingreso, se reconoce que la educación es un factor determinante en la adquisición de empleo y en la mejora de las condiciones de vida.</p>\n" +
    "        </font>\n" +
    "    </body>\n" +
    "</html>"
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
        js.setBounds(40, 90, 900, 500);
        add(js);
        
        
        
    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ca.setVisible(true); // mostrar la ventana de menu principal 
    }   
    public void evento_jbCapitulo_6(){
           cap8.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
   }
       
      
}

