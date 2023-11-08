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
    JButton jbVolver, jbMatrices, jbSistema, jbDeterminantes_d,jbInversa_Matriz,jbCalculadoraDeterminantes,jbd_inversa;
    GaussJordan gau = new GaussJordan(this);
    Inversa_Matriz inv = new Inversa_Matriz(this);
    Determinantes de = new Determinantes(this);

    public Alg(MenuPrincipal obj) {
        super("Area de Algebra Lineal");
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
                getClass().getResource("/imagenes/lineall.png"));
        JLabel jlTitulo = new JLabel("Area de Algebra Lineal", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.darkGray);
        jlTitulo.setForeground(Color.WHITE);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        ImageIcon i_sist = new ImageIcon(
                getClass().getResource("/imagenes/sist.png"));
        jbMatrices= new JButton("Sistema de Ecuaciones", i_sist);
        jbMatrices.setBounds(100, 300, 300, 50);
        jbMatrices.addActionListener((e) -> {
            evento_jbMatrices();
        });
        add(jbMatrices);
 
        ImageIcon i_deter = new ImageIcon(
                getClass().getResource("/imagenes/deter.png"));
        jbDeterminantes_d = new JButton("Determinantes", i_deter);
        jbDeterminantes_d.setBounds(100, 160, 300, 50);
        jbDeterminantes_d.addActionListener((e) -> {
            evento_jbDeterminantes_d();
        });
        add(jbDeterminantes_d);

        jbSistema = new JButton("Calculadora de sistema de Ecuaciones ");
        jbSistema.setBounds((1825 - 610) / 2, 310, 250, 40);
        jbSistema.addActionListener((e) -> {
            evento_jbSistema();
        });
        add(jbSistema);
        
        
        jbInversa_Matriz = new JButton("Calculadora Inversa Matriz");
        jbInversa_Matriz.setBounds((1825 - 610) / 2, 460, 250, 40);
        jbInversa_Matriz.addActionListener((e) -> {
            evento_jbInversa_Matriz();
        });
        add(jbInversa_Matriz);
        
        
        jbCalculadoraDeterminantes = new JButton("Calculadora Determinante Matriz");
        jbCalculadoraDeterminantes.setBounds((1825 - 610) / 2, 170, 250, 40);
        jbCalculadoraDeterminantes.addActionListener((e) -> {
            evento_jbCalculadoraDeterminantes();
        });
        add(jbCalculadoraDeterminantes);
        
        
        ImageIcon i_inver = new ImageIcon(
                getClass().getResource("/imagenes/inversa.png"));
        jbd_inversa= new JButton("Matriz Inversa", i_inver);
        jbd_inversa.setBounds(100, 460, 300, 50);
        jbd_inversa.addActionListener((e) -> {
            evento_jbd_inversa();
        });
        add(jbd_inversa);

    }

    public void evento_jbMatrices() {
        Matrices mt = new Matrices(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbSistema() {
        gau.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
     public void evento_jbInversa_Matriz() {
        inv.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbDeterminantes_d() {
        Determinantes_d det = new Determinantes_d(this);
        setVisible(false); // ocultar la ventana de menu principal
    }
        public void evento_jbCalculadoraDeterminantes() {
         de.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
     public void evento_jbd_inversa() {
        d_inversa inver = new d_inversa(this);
        setVisible(false); // ocultar la ventana de menu principal
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
