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

public final class Capitulo_7 extends JFrame{
           JEditorPane editor; 
    Capitulo_7 cap7;
    Capitulos ca;
    JButton jbVolver,jbCapitulo_7;
    
    
    public Capitulo_7(Capitulos obj){
        super("Capitulo 7");
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
     
        JLabel jlTitulo = new JLabel("Capitulo 7");
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
                    "<!DOCTYPE html>\n" +
    "<html>\n" +
    "    <head>\n" +
    "        <title>Impacto de la pandemia en la pobreza</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color='WHITE' face='Tahoma'>\n" +
    "            <center>\n" +
    "                <h1>Impacto de la pandemia en la pobreza</h1>\n" +
    "            </center>\n" +
    "            <hr>\n" +
    "            <p>La pandemia de COVID-19 ha tenido un impacto significativo en Colombia, aumentando los niveles de pobreza y exacerbando las desigualdades. El confinamiento y la disminución de empleos y salarios han generado una crisis económica y social sin precedentes. El Gobierno Nacional ha implementado políticas de apoyo, como el programa Ingreso Solidario, para ayudar a la población en situación de pobreza y vulnerabilidad.</p>\n" +
    "            <p>Las microsimulaciones muestran un aumento devastador en la pobreza durante la pandemia, multiplicando la pobreza extrema y moderada en comparación con los niveles iniciales. Sin embargo, las intervenciones del Gobierno, como los giros extraordinarios de programas sociales, han contribuido eficazmente a la reducción de la pobreza.</p>\n" +
    "            <p>Varios factores han contribuido al aumento de la pobreza, incluyendo la pérdida de empleos, la disminución de ingresos y la interrupción de programas de alimentación escolar. Los trabajadores informales y por cuenta propia, que representan una gran parte de la fuerza laboral, se vieron especialmente afectados. Además, los niños que dependían de las comidas escolares perdieron acceso a estas, aumentando la inseguridad alimentaria.</p>\n" +
    "            <p>El Gobierno ha implementado medidas para mitigar el impacto en la pobreza, como programas de transferencias monetarias y apoyo a la generación de empleo, como el Programa de Apoyo al Empleo Formal (PAEF). Estos esfuerzos buscan aliviar la crisis económica y social desencadenada por la pandemia en Colombia.</p>\n" +
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
        js.setBounds(40, 90, 915, 500);
        add(js);
        
        
        
    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        ca.setVisible(true); // mostrar la ventana de menu principal 
    }   
    public void evento_jbCapitulo_6(){
           cap7.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
   }
       
      
}

