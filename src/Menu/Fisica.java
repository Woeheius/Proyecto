
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fisica extends JFrame{
    
    MenuPrincipal mp;
    JButton jbVolver, jbVectores;
    
    public Fisica(MenuPrincipal obj){
        super("Area de Fisica");
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
                getClass().getResource("/imagenes/fisicaa.png"));
        JLabel jlTitulo = new JLabel("Area de Fisica", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 1000, 80);
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
               
        
        jbVectores = new JButton("Vectores");
        jbVectores.setBounds((1215-510)/2, 160, 300, 80);
        jbVectores.addActionListener((e) -> {
            evento_jbVectores();
        });
             add(jbVectores);
    }             
    
     public void evento_jbVectores(){
        Vectores ve = new Vectores(this);
        setVisible(false); // ocultar la ventana de menu principal
   }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
