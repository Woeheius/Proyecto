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

public final class Capitulo_6 extends JFrame{
        JEditorPane editor;
    Capitulo_6 cap6;
    Capitulos ca;
    JButton jbVolver,jbCapitulo_6;
    
    
    public Capitulo_6(Capitulos obj){
        super("Capitulo 6");
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
        
        JLabel jlTitulo = new JLabel("Capitulo 6");
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
    "        <title>Capítulo 11: Medición de la Pobreza Multidimensional</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color=\"white\" face=\"Tahoma\">\n" +
    "            <center><h1>Medición de la Pobreza Multidimensional y Alternativas Métricas para el Objetivo de Desarrollo Sostenible 1 de la Agenda 2030</h1></center>\n" +
    "        </font>\n" +
    "        <hr>\n" +
    "        <font color=\"white\" face=\"Tahoma\" size=\"2\">\n" +
    "            <p>Revisa las opciones métricas disponibles para medir la pobreza multidimensional y lograr que el Objetivo de Desarrollo Sostenible 1 de la Agenda 2030 sea universal y comprometa a todos los países. Se destaca la importancia de superar las limitaciones de la tradicional línea de pobreza monetaria y se presenta la metodología de Alkire y Foster como una alternativa flexible y completa.</p>\n" +
    "            <p>La metodología de Alkire y Foster se basa en la identificación de las dimensiones relevantes para medir la pobreza multidimensional, como la educación, la salud y el nivel de vida. A partir de estas dimensiones, se establecen umbrales que determinan si una persona es considerada pobre o no en cada una de ellas. Se aplican ponderaciones a cada dimensión para reflejar su importancia relativa en la medición de la pobreza. Finalmente, se utiliza una línea de corte para determinar si una persona es considerada pobre multidimensionalmente.</p>\n" +
    "            <p>Además de la metodología de Alkire y Foster, se presentan otras opciones métricas para medir la pobreza multidimensional, como el Índice de Pobreza Multidimensional (IPM) utilizado en América Latina y el Índice de Privación Material Severa (IPMS) utilizado en Europa. Estos índices también tienen en cuenta diferentes dimensiones y aplican diferentes metodologías para calcular la pobreza multidimensional.</p>\n" +
    "            <p>Se mencionan experiencias de medición de pobreza multidimensional en América Latina y Europa. En América Latina, se destaca la experiencia de México, que ha implementado el Índice de Pobreza Multidimensional (IPM) adaptado a su contexto nacional. Este índice considera diferentes dimensiones, como la educación, la salud y el nivel de vida, y ha permitido una mejor comprensión de la pobreza en el país.</p>\n" +
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
           cap6.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
   }
       
      
}

