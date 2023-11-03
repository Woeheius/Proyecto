package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.plaf.ColorUIResource;

public final class Alg extends JFrame {

    MenuPrincipal mp;
    JButton jbVolver, jbMatrices, jbSistema, jbDeterminantes;
    GaussJordan gau = new GaussJordan(this);

    public Alg(MenuPrincipal obj) {
        super("Area de Algebra Lineal");
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

    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/lineall.png"));
        JLabel jlTitulo = new JLabel("Area de Algebra Lineal", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 1000, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.darkGray);
        jlTitulo.setForeground(Color.WHITE);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(400, 600, 500, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        jbMatrices = new JButton("Sistema de Ecuaciones");
        jbMatrices.setBounds((1015 - 510) / 2, 160, 300, 80);
        jbMatrices.addActionListener((e) -> {
            evento_jbMatrices();
        });
        add(jbMatrices);

        jbDeterminantes = new JButton("Determinantes");
        jbDeterminantes.setBounds((1015 - 510) / 2, 350, 300, 80);
        jbDeterminantes.addActionListener((e) -> {
            evento_jbDeterminantes();
        });
        add(jbDeterminantes);

        jbSistema = new JButton("Calculadora de sistema de Ecuaciones ");
        jbSistema.setBounds((1825 - 610) / 2, 180, 250, 40);
        jbSistema.addActionListener((e) -> {
            evento_jbSistema();
        });
        add(jbSistema);

    }

    public void evento_jbMatrices() {
        Matrices mt = new Matrices(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbSistema() {
        gau.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbDeterminantes() {
        Determinantes det = new Determinantes(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
