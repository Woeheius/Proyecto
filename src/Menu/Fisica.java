package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Fisica extends JFrame {

   MenuPrincipal mp;
    JButton jbVolver, jbVectores, jbGraficadora,jbJuego;
    GraficVectores g = new GraficVectores(this);

    public Fisica(MenuPrincipal obj) {
        super("Area de Fisica");
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

    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/fisicaa.png"));
        JLabel jlTitulo = new JLabel("Area de Fisica", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
        
         ImageIcon i_vect = new ImageIcon(
                getClass().getResource("/imagenes/vect.png"));
        jbVectores = new JButton("Vectores", i_vect);
        jbVectores.setBounds(100, 160, 300, 50);
        jbVectores.addActionListener((e) -> {
            evento_jbVectores();
        });
        add(jbVectores);
        
        
        jbGraficadora = new JButton("Graficadora");
        jbGraficadora.setBounds((2025 - 610) / 2, 168, 100, 40);
        jbGraficadora.addActionListener((e) -> {
            evento_jbGraficadora();
        });
        add(jbGraficadora);
        
        jbJuego = new JButton("Juego");
        jbJuego.setBounds((2025-610)/2, 375, 100, 40);
        jbJuego.addActionListener((e) -> {
            InterfazFisica InterfazFisica = new InterfazFisica();
            setVisible(false);
        });
        add(jbJuego);
    }

    public void evento_jbVectores() {
        Vectores ve = new Vectores(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }

    public void evento_jbGraficadora() {
        g.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
}
