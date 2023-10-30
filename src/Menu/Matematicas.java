package Menu;

import Menu.PlanoCartesiano;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Matematicas extends JFrame{
    
    MenuPrincipal mp;
    JButton jbVolver,jbDeri,jbFun,jbCalculadoraDerivadas,jbGrafi;
    CalculadoraDerivadas c = new CalculadoraDerivadas(this);
    PlanoCartesiano p = new PlanoCartesiano();
    VentanaFunciones v = new VentanaFunciones(p);
  
    
    public Matematicas(MenuPrincipal obj){
        super("Area de Matematicas");
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
                getClass().getResource("/imagenes/calcula.png"));
        JLabel jlTitulo = new JLabel("Area de Matematicas", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 1000, 60);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);
                
        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(400, 600, 500, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
                add(jbVolver);
   
        
        jbFun = new JButton("Funciones");
        jbFun.setBounds((1215-510)/2, 160, 300, 65);
        jbFun.addActionListener((e) -> {
            evento_jbFun();
        });
             add(jbFun);
     
        
        jbDeri = new JButton("Derivadas");
        jbDeri.setBounds((1215-510)/2, 350, 300, 65);
        jbDeri.addActionListener((e) -> {
            evento_jbDeri();
        });
        add(jbDeri);
        
       //ImageIcon i_deriv = new ImageIcon(
                //getClass().getResource("/imagenes/equipo.png"));
        jbCalculadoraDerivadas = new JButton("Calculadora");
        jbCalculadoraDerivadas.setBounds((2025-610)/2, 362, 100, 40);
        jbCalculadoraDerivadas.addActionListener((e) -> {
            evento_jbCalculadoraDerivadas();
        });
        add(jbCalculadoraDerivadas); 
        jbGrafi = new JButton("Graficadora");
       
        jbGrafi.setBounds((2025-610)/2, 172, 100, 40);
        jbGrafi.addActionListener((e) -> {
            evento_jbGraficadora();
        });
        add(jbGrafi);
    }

    
   public void evento_jbFun(){
        Fun fu = new Fun(this);
        setVisible(false); // ocultar la ventana de menu principal
    }
   public void evento_jbDeri(){
       Deri de = new Deri(this);
        setVisible(false); // ocultar la ventana de menu principal
   }
   public void evento_jbCalculadoraDerivadas(){
         c.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
   }
   public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
public void evento_jbGraficadora() {
    PlanoCartesiano plano = new PlanoCartesiano(); // crea una instancia de PlanoCartesiano
    v = new VentanaFunciones(plano); // pasa la instancia de PlanoCartesiano al constructor de VentanaFunciones
    p.setVisible(true);
    v.setVisible(true);
    setVisible(false); // ocultar la ventana de menu principal
}

   
    
    
}
    
