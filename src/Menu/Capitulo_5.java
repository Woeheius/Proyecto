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

public final class Capitulo_5 extends JFrame{
    JEditorPane editor;
    Capitulo_5 cap5;
    Capitulos ca;
    JButton jbVolver,jbCapitulo_5;
    
    
    public Capitulo_5(Capitulos obj){
        super("Capitulo 5");
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
        
        JLabel jlTitulo = new JLabel("Capiulo 5");
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
    "<!DOCTYPE html>\n" +
    "<html>\n" +
    "    <head>\n" +
    "        <title>Innovación social y tecnológica en la lucha contra la pobreza</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color='white' face='Tahoma'>\n" +
    "            <center><h1>Innovación social y tecnológica en la lucha contra la pobreza</h1></center>\n" +
    "        </font>\n" +
    "        <hr>\n" +
    "        <font color='white' face='Tahoma' size='2'>\n" +
    "            <p>La innovación social y tecnológica ha demostrado ser una herramienta poderosa en la lucha contra la pobreza. En un mundo cada vez más digitalizado, la tecnología se ha convertido en un vehículo clave para abordar los desafíos sociales y económicos que enfrentan las comunidades más vulnerables.</p>\n" +
    "            <p>Un ejemplo destacado de esta sinergia entre innovación social y tecnología es el proyecto 'Dos Pasos por Delante', una iniciativa que surgió durante la crisis de la COVID-19 en Córdoba, España. Este proyecto, liderado por profesionales del ámbito digital y tecnológico, se propuso anticiparse a las necesidades de la comunidad, identificando, canalizando y optimizando los recursos y la ayuda a través de una plataforma en línea. De esta manera, se logró una respuesta más eficiente y oportuna a las demandas de la población afectada por la pandemia.</p>\n" +
    "            <p>La relación entre innovación social y tecnología se ha vuelto cada vez más estrecha, al punto de que se ha acuñado el término 'innovación social tecnológica'. Esta forma de innovación social se centra en el uso de la tecnología como elemento central de las soluciones, siendo indispensable para su comprensión y aplicación.</p>\n" +
    "            <p>Un ejemplo concreto de innovación social tecnológica es la empresa social Koiki. Esta empresa proporciona servicios de transporte sostenible y personalizado, al tiempo que promueve la integración laboral de personas con barreras a la inclusión. A través de una aplicación móvil, los usuarios pueden realizar compras en línea y seleccionar como lugar de entrega la dirección de un 'koiki' de su barrio. Estos repartidores, utilizando medios de transporte sostenibles como caminar o andar en bicicleta, se encargan de recibir los paquetes y entregarlos a los destinatarios en el momento indicado. De esta manera, Koiki contribuye a mejorar la calidad de vida en los barrios, reduciendo el tráfico, el ruido y las emisiones de CO2.</p>\n" +
                        
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
    public void evento_jbCapitulo_5(){
           cap5.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
   }
       
      
}

