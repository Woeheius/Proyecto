package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public final class Humanidades extends JFrame {

    MenuPrincipal mp;
    Inf inf;
    JButton jbVolver, jbCapitulos, jbEncuesta;

    public Humanidades(MenuPrincipal obj) {
        super("Area de Humanidades");
        mp = obj;
        setSize(900, 600);
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

    Humanidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/mundo.png"));
        JLabel jlTitulo = new JLabel("Area de Humanidades", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);
        
        ImageIcon i_cap = new ImageIcon(
                getClass().getResource("/imagenes/libros.png"));
        jbCapitulos = new JButton("Leer capitulos", i_cap);
         jbCapitulos.setBounds((670 - 200) / 2, 170, 500, 50);
        jbCapitulos.addActionListener((e) -> {
            evento_jbCapitulos();
        });
        add(jbCapitulos);
        
        
        ImageIcon i_enc = new ImageIcon(
                getClass().getResource("/imagenes/encuesta.png"));
        jbEncuesta = new JButton("Encuesta", i_enc);
        jbEncuesta.setBounds((670 - 200) / 2, 320, 500, 50);
        jbEncuesta.addActionListener((e) -> {
            evento_jbEncuesta();
        });
        add(jbEncuesta);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }

    public void evento_jbCapitulos() {
        Capitulos ca = new Capitulos(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbEncuesta() {
        Datos d = new Datos();
        setVisible(false); // ocultar la ventana de menu principal
        d.setVisible(true);
    }

}
