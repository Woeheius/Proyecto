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

public final class Matrices extends JFrame {

    JEditorPane editor;
    Alg al;
    JButton jbVolver;

    public Matrices(Alg obj) {
        super("Sistema de Ecuaciones");
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

    public void crearGUI() {

        JLabel jlTitulo = new JLabel("Sistema de Ecuaciones");
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
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Sistemas de Ecuaciones</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#181818\">\n"
                + "        <font color=\"white\" face=\"Tahoma\">\n"
                + "            <center><h1><font color=\"white\">Definición</font></h1></center>\n"
                + "        </font>\n"
                + "        <hr>\n"
                + "        <font color=\"white\" face=\"Tahoma\" size=\"3\">\n"
                + "            <p>Un sistema de ecuaciones es un conjunto de ecuaciones algebraicas que se utilizan para representar una serie de relaciones matemáticas entre varias incógnitas o variables. En otras palabras, es un conjunto de ecuaciones en el que estamos tratando de encontrar los valores desconocidos de ciertas variables que satisfacen todas las ecuaciones simultáneamente.</p>\n"
                + "            <p>Un sistema de ecuaciones puede resolverse de varias formas, el método que elijas dependerá, en su mayoría, de tus preferencias personales y tu experiencia.</p>\n"
                + "            <p>Hay algunos métodos comunes para resolver sistemas de ecuaciones y estos son:</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de sustitución: En este método, resuelves una de las ecuaciones para una de las variables y luego sustituyes esta expresión en las otras ecuaciones.</p>\n"
                + "            <p><font color=\"red\">✔</font> Eliminación: También conocido como el método de suma/resta, consiste en sumar o restar múltiplos adecuados de las ecuaciones para eliminar una de las variables. Esto simplifica el sistema, dejando una ecuación con una sola variable que puedes resolver.</p>\n"
                + "            <p><font color=\"red\">✔</font> Matrices y determinantes: Puedes utilizar matrices y determinantes para resolver sistemas de ecuaciones lineales. Puedes expresar el sistema en forma matricial y utilizar la inversa de una matriz o la regla de Cramer para encontrar las soluciones.</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de Gauss-Jordán: Este método utiliza operaciones elementales de fila para reducir la matriz aumentada del sistema a una forma escalonada.</p>\n"
                + "            <p><font color=\"red\">✔</font> Método de la regla de Cramer: Este método se aplica a sistemas de ecuaciones lineales cuyas matrices de coeficientes sean cuadradas y tengan un determinante distinto de cero. Permite resolver cada variable de manera independiente utilizando determinantes y matrices adjuntas.</p>\n"
                + "            <br>\n"
                + "            <br>\n"
                + " <center><div> <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTr6LvwY0SDIvMy9VyJ8B0JNhf0JS4hNZLZfg&usqp=CAU\" width=\"340\"/></div>\n"
                + " <br>\n"
                + " </center>\n"
                + "      <p>Estos son algunos de los métodos más comunes y utilizados para resolver sistemas de ecuaciones. Con cualquiera de estos métodos, puedes solucionar el sistema de ecuaciones. La elección del método depende de tu decisión y preferencia al desarrollar un sistema de ecuaciones.</p>\n"
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

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        al.setVisible(true); // mostrar la ventana de menu principal 
    }
}
