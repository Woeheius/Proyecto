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

public final class Capitulo_9 extends JFrame{
        JEditorPane editor; 
    Capitulo_9 cap9;
    Capitulos ca;
    JButton jbVolver,jbCapitulo_9;
    
    
    public Capitulo_9(Capitulos obj){
        super("Capitulo 9");
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
        
        JLabel jlTitulo = new JLabel("Capitulo 9");
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
    "        <title>Problemas en la Implementación del ODS 1</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color=\"white\" face=\"Tahoma\">\n" +
    "            <center><h1>Problemas en la Implementación del ODS 1: Erradicar la pobreza en todas sus formas en el mundo</h1></center>\n" +
    "        </font>\n" +
    "        <hr>\n" +
    "        <font color=\"white\" face=\"Tahoma\" size=\"2\">\n" +
    "            <p>La ambigüedad en los objetivos del ODS 1, que busca erradicar la pobreza en todas sus formas, pero establece una meta específica de reducción a menos de la mitad de la proporción de personas en pobreza, ha generado un debate sobre la claridad de su enfoque. Algunos argumentan que esta contradicción puede llevar a confusiones sobre si el objetivo final es eliminar por completo la pobreza o simplemente reducirla a la mitad. Esta falta de claridad puede afectar la definición de estrategias y acciones concretas para abordar la pobreza.</p>\n" +
    "            <p>Además, las críticas relacionadas con la visión etnocentrista de los ODS y su enfoque en el liderazgo de los países desarrollados destacan la preocupación de que estos objetivos puedan fortalecer desigualdades y mantener la dependencia de los países en desarrollo hacia las naciones más avanzadas. Esto plantea la necesidad de un enfoque más equitativo y colaborativo en la implementación de los ODS para garantizar que todas las naciones tengan la oportunidad de participar y contribuir de manera significativa a la erradicación de la pobreza, sin perpetuar relaciones desiguales.</p>\n" +
    "            <p>En relación a la falta de requisitos de transparencia, responsabilidad y respeto por estándares sociales, medioambientales y de derechos humanos fundamentales en las colaboraciones entre el sector público y privado promovidas por los ODS, esta inquietud destaca la importancia de establecer salvaguardias y sistemas efectivos de supervisión. Sin tales salvaguardias, existe el riesgo de que las empresas privadas no cumplan adecuadamente con su responsabilidad en la erradicación de la pobreza, lo que podría dar lugar a prácticas comerciales irresponsables y perjudiciales para las comunidades y el medio ambiente en los países en desarrollo. Por tanto, resulta esencial desarrollar marcos regulatorios sólidos y mecanismos de rendición de cuentas efectivos para asegurar que las alianzas público-privadas realmente contribuyan de manera auténtica a la lucha contra la pobreza y no comprometan la integridad de los objetivos de desarrollo sostenible.</p>\n" +
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
           cap9.setVisible(true);
        setVisible(false); // ocultar la ventana 
   }
       
      
}

