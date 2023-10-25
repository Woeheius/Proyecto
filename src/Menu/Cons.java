
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

public class Cons extends JFrame{
    JEditorPane editor;
    MenuPrincipal mp;
    JButton jbVolver;
    
    public Cons(MenuPrincipal obj){
        super("Area de Constitucion Politica");
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
                getClass().getResource("/imagenes/balanza.png"));
        JLabel jlTitulo = new JLabel("Area de Constitucion Politica", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 1000, 70);
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
    "<!DOCTYPE html>\n" +
    "<html>\n" +
    "    <head>\n" +
    "        <title>Mecanismos Constitucionales</title>\n" +
    "    </head>\n" +
    "    <body bgcolor=\"#181818\">\n" +
    "        <font color='white' face='Tahoma'>\n" +
    "            <center><h1><font color='white'>Mecanismos Constitucionales</font></h1></center>\n" +
    "        </font>\n" +
    "        <hr>\n" +
    "        <font color='white' face='Tahoma' size='3'>\n" +
    "            <p>Los Mecanismos de Protección Ciudadana son los instrumentos instituidos para proteger una eventual o real pérdida, vulneración o amenaza de derechos fundamentales consagrados en la Constitución Política, que se ejercen mediante acción judicial, y cuando fuere posible restituir las cosas a su estado anterior.</p>\n" +
    "            <p>Colombia cuenta con varios mecanismos de protección de los derechos humanos y las libertades de sus ciudadanos, establecidos en su Constitución y leyes.</p>\n" +
    "            <p>Algunos de los principales mecanismos de protección en Colombia:</p>\n" + 
    "            <p><font color='red'>➡</font> Acción de Tutela: La Tutela es un mecanismo fundamental en Colombia para la protección de los derechos fundamentales de las personas. Permite a los ciudadanos presentar demandas ante jueces para la protección inmediata de sus derechos, como la vida, la integridad personal, la igualdad y otros derechos fundamentales.</li>\n" + 
    "            <br>\n"+
    "            <br>\n" +
    "             <font color='red'>➡</font> Defensoría del Pueblo: La Defensoría del Pueblo es una entidad autónoma encargada de la defensa de los derechos humanos en Colombia. Actúa como un organismo de control que vela por la protección de los derechos de los ciudadanos y supervisa las acciones del gobierno en relación con los derechos humanos.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +
    "            <font color='red'>➡</font> Comisión Nacional de Derechos Humanos: Esta comisión tiene como objetivo promover y proteger los derechos humanos en Colombia, además de investigar y documentar violaciones a los derechos humanos.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +
    "            <font color='red'>➡</font>  Fiscalía General de la Nación: La Fiscalía investiga y persigue a los responsables de delitos, incluyendo aquellos que violan los derechos humanos. Trabaja para garantizar que los perpetradores sean llevados ante la justicia.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +        
    "            <font color='red'>➡</font> Jurisdicción Especial para la Paz (JEP): Establecida como parte del proceso de paz con las FARC, la JEP es un sistema judicial especial encargado de investigar y juzgar crímenes relacionados con el conflicto armado, incluyendo violaciones a los derechos humanos.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +        
    "            <font color='red'>➡</font> Acción de Reparo: Este mecanismo busca compensar a las víctimas de violaciones a los derechos humanos, proporcionándoles reparación y apoyo para la rehabilitación y reintegración a la sociedad.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +        
    "            <font color='red'>➡</font> Comisión de la Verdad: La Comisión de la Verdad es un órgano independiente encargado de investigar y documentar las violaciones de derechos humanos ocurridas en el contexto del conflicto armado en Colombia.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +
    "            <font color='red'>➡</font> Protección de Grupos Vulnerables: Colombia tiene mecanismos y políticas específicas para la protección de grupos vulnerables, como las comunidades indígenas, afrocolombianas, mujeres y niños.</li>\n" +
    "            <br>\n" +
    "            <br>\n" +
    "            <font color='red'>➡</font> Control Constitucional: La Corte Constitucional de Colombia tiene la facultad de revisar la constitucionalidad de las leyes y actos legislativos para garantizar que estén en conformidad con la Constitución y los tratados internacionales de derechos humanos.</li>\n" +
    "            <br>\n" +
    "            </ul>\n" +
    "            <br>\n"+
    "        <center><div> <img src=\"https://img.freepik.com/fotos-premium/bandera-colombia-pintada-concepto-protesta-fuerza-puno-cerrado_601748-9322.jpg\" width=\"300\"/></div>\n" +
    " </center>\n" +
    " <p>Estos son algunos de los mecanismos de protección en Colombia, la protección de los derechos humanos y las libertades es un aspecto fundamental en el marco legal del país, dada su historia de conflicto y la importancia de garantizar el respeto a los derechos fundamentales de sus ciudadanos.</p>\n" +
    " </font>\n" +
    " </body>\n" +
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
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
