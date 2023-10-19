/*
Proposito: Menu que contiene todos los botones y apartados de cada asignatura
que trata la aplicacion.
Autores:
Angie Natalia Cobo Vasquez
Juan Diego Rodriguez Ortiz
Sebastian Henao Gamboa
Santiago Ospina Gonzalez

Version: 2.0
Fecha ultima actualizacion:10/10/2023 
Version JDK:
*/
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MenuPrincipal extends JFrame{
    
    JButton jbMate, jbFisica, jbHuma, jbTgs , jbAlg, jbCons,jbSem,jbInf;
        
    public MenuPrincipal(){
        super("Proyecto Integrador");
        setSize(900, 600);
        //setLocation(1200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(26, 26, 26));
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        setLayout(null); // asignar un diseño libre
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png"));
        JLabel jlTitulo = new JLabel("Menu principal", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(new Color(41, 41, 41));
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Castellar", Font.BOLD, 35));
        add(jlTitulo);
        
        ImageIcon i_mate = new ImageIcon(
                getClass().getResource("/imagenes/eeee.png"));
        jbMate = new JButton("Matematicas", i_mate);
        jbMate.setBounds((700-510)/2, 120, 300, 60);
        jbMate.addActionListener((e) -> {
            evento_jbMate();
        });
        add(jbMate);
        
        ImageIcon i_fis = new ImageIcon(
                getClass().getResource("/imagenes/compas.png"));
        jbFisica = new JButton("Fisica", i_fis);
        jbFisica.setBounds((700-510)/2, 230, 300, 60);
        jbFisica.addActionListener((e) -> {
            evento_jbFisica();
        });
        add(jbFisica);
        
        ImageIcon i_huma= new ImageIcon(
                getClass().getResource("/imagenes/Huma.png"));
        jbHuma = new JButton("Humanidades", i_huma);
        jbHuma.setBounds((700+300)/2, 120, 300, 60);
        jbHuma.addActionListener((e) -> {
            evento_jbHuma();
        });
        add(jbHuma);
        
        ImageIcon i_tgs= new ImageIcon(
                getClass().getResource("/imagenes/Tgs.png"));
        jbTgs = new JButton("Teoria General de Sistemas", i_tgs);
        jbTgs.setBounds((700+300)/2, 230, 300, 60);
        jbTgs.addActionListener((e) -> {
           evento_jbTgs();
        });
        add(jbTgs);
                
        ImageIcon i_alg = new ImageIcon(
                getClass().getResource("/imagenes/al.png"));
        jbAlg = new JButton("Algebra Lineal", i_alg);
        jbAlg.setBounds((700-510)/2, 340, 300, 60);
        jbAlg.addActionListener((e) -> {
            evento_jbAlg();
        });
        add(jbAlg);
        
        ImageIcon i_cons = new ImageIcon(
                getClass().getResource("/imagenes/constitucion.png"));
        jbCons = new JButton("Constitucion Politica", i_cons);
        jbCons.setBounds((700+300)/2, 340, 300, 60);
        jbCons.addActionListener((e) -> {
            evento_jbCons();
        });
        add(jbCons);
        
                ImageIcon i_sem = new ImageIcon(
                getClass().getResource("/imagenes/sem.png"));
        jbSem = new JButton("Seminario Universidad", i_sem);
        jbSem.setBounds((700-510)/2, 450, 300, 60);
        jbSem.addActionListener((e) -> {
            evento_jbSem();
        });
        add(jbSem);
                ImageIcon i_info = new ImageIcon(
                getClass().getResource("/imagenes/equipo.png"));
        jbInf = new JButton("Informacion Equipo", i_info);
        jbInf.setBounds((700+300)/2, 450, 300, 60);
        jbInf.addActionListener((e) -> {
            evento_jbInf();
        });
        add(jbInf);
        
    }
    
    public void evento_jbFisica(){
        Fisica fs = new Fisica(this);
        setVisible(false); // ocultar la ventana de menu principal
    }
    
    public void evento_jbMate(){
        Matematicas mt = new Matematicas(this);
        setVisible(false); // ocultar la ventana de menu principal
    }
    public void evento_jbHuma(){
        Humanidades hu = new Humanidades(this);
        setVisible(false); // ocultar la ventana de menu princip
    }
    public void evento_jbTgs(){
        Tgs tg = new Tgs(this);
        setVisible(false); // ocultar la ventana de menu princip
    }
    public void evento_jbAlg(){
        Alg al = new Alg(this);
        setVisible(false); // ocultar la ventana de menu princip
    }
     public void evento_jbCons(){
        Cons co = new Cons(this);
        setVisible(false); // ocultar la ventana de menu princip
    }
          public void evento_jbSem(){
        Sem se = new Sem(this);
        setVisible(false); // ocultar la ventana de menu princip
    }
              public void evento_jbInf(){
        Inf ia = new Inf(this);
        setVisible(false); // ocultar la ventana de menu principal
    }
               
       public void evento_jbCalculadoraDerivadas(){
        CalculadoraDerivadas c = new CalculadoraDerivadas(new Matematicas(this));
        setVisible(false); // ocultar la ventana de menu principal
    }
           
    
  public static void main(String[] args) {
        //setDefaultLookAndFeelDecorated(true);
        String look = "";

        try {
            look = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
            //look = "com.jtattoo.plaf.aero.AeroLookAndFeel";
            //look = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            //look = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
            //look = "com.jtattoo.plaf.fast.FastLookAndFeel";
            //look = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
            //look = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
            //look = "com.jtattoo.plaf.luna.LunaLookAndFeel";
            //look = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
            //look = "com.jtattoo.plaf.mint.MintLookAndFeel";
            //look = "com.jtattoo.plaf.noire.NoireLookAndFeel";
            //look = "com.jtattoo.plaf.smart.SmartLookAndFeel";
            //look = "com.jtattoo.plaf.texture.TextureLookAndFeel";
            UIManager.setLookAndFeel(look);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al tratar de cargar el paquete '" + look + "'.\n\n"
                    + "Se tomara el LookAndFeel por defecto.", "Error de paquete", JOptionPane.WARNING_MESSAGE);

            JFrame.setDefaultLookAndFeelDecorated(false);
            look = "";
        }
        
        MenuPrincipal ej = new MenuPrincipal();
    }
}
