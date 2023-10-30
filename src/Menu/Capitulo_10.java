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

public final class Capitulo_10 extends JFrame{
    
    JEditorPane editor;
    Capitulo_10 cap10;
    Capitulos ca;
    JButton jbVolver,jbCapitulo_10;
    
    
    public Capitulo_10(Capitulos obj){
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
    
    public void crearGUI(){
     
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
        editor = new JEditorPane();
        editor.setContentType("text/html");
        
        URL url = getClass().getResource("imagenes/logo_duke.png");
        
        editor.setText(
                    "<!DOCTYPE html>\n" +
    "<html>\n" +
    "    <head>\n" +
    "        <title>Implementación del Primer ODS en América Latina</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color=\"white\" face=\"Tahoma\">\n" +
    "            <center><h1>Implementación del Primer ODS en América Latina - Erradicar la Pobreza Extrema y el Hambre</h1></center>\n" +
    "        </font>\n" +
    "        <hr>\n" +
    "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n" +
    "            <p>La región de América Latina ha enfrentado desafíos significativos en su búsqueda por alcanzar el primer Objetivo de Desarrollo Sostenible (ODS) de las Naciones Unidas: Erradicar la pobreza extrema y el hambre. Este capítulo se adentra en las diversas estrategias y acciones implementadas en la región para abordar esta cuestión fundamental.</p>\n" +
    "            <p>Uno de los enfoques más comunes ha sido la implementación de programas de transferencia de efectivo directo a familias en situación de pobreza. Estos programas ofrecen un sustento económico esencial para las poblaciones más vulnerables y les permiten satisfacer sus necesidades básicas.</p>\n" +
    "            <p>El fomento de la agricultura sostenible se ha convertido en una pieza clave en la lucha contra el hambre en América Latina. La capacitación de agricultores en prácticas sostenibles y el apoyo a la producción de alimentos han contribuido a mejorar la seguridad alimentaria en la región.</p>\n" +
    "            <p>El acceso a una educación de calidad y a servicios de salud asequibles es esencial para romper el ciclo de la pobreza. En este capítulo, exploramos cómo varios países han desarrollado programas para garantizar el acceso a estos servicios fundamentales.</p>\n" +
    "            <p>La creación de empleo y el fomento del emprendimiento se han convertido en motores para el crecimiento económico y la reducción de la pobreza en América Latina. Analizaremos las políticas y programas que han impulsado estas áreas.</p>\n" +
    "            <p>La desigualdad económica y social es un obstáculo clave para la erradicación de la pobreza extrema. Este capítulo examina las medidas adoptadas para abordar este desafío y promover una mayor equidad en la región.</p>\n" +
    "            <p>La implementación del primer ODS en América Latina es un proceso complejo y diverso que varía de un país a otro. La colaboración entre organizaciones internacionales, gobiernos y la sociedad civil desempeña un papel crucial en el camino hacia la erradicación de la pobreza extrema y el hambre en esta región dinámica y diversa.</p>\n" +
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
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        ca.setVisible(true); // mostrar la ventana  
    }   
    public void evento_jbCapitulo_6(){
           cap10.setVisible(true);
        setVisible(false); // ocultar la ventana 
   }
       
      
}

