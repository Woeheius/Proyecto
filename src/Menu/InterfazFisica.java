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
import javax.swing.SwingConstants;

public class InterfazFisica extends JFrame   {

    JLabel jlTexto, jlImagen, jlTextoImg;
    JButton jbMovimiento,jbVolver; 
    Fisica fs; 
    
      
    public InterfazFisica(Fisica obj){
    super("FISICA");
    fs = obj;
    setSize(800, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setLayout(null);
    Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
            crearGUI() ;
    
    setVisible(false);
}
    public void crearGUI(){
        jlTexto = new JLabel("FISICA");
        jlTexto.setBounds(0, 0, 800, 80);
        jlTexto.setOpaque(true);
        jlTexto.setBackground(Color.BLACK);
        jlTexto.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
        jlTexto.setForeground(Color.WHITE);
        jlTexto.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlTexto);
                
        jbMovimiento = new JButton("Calculos");
        jbMovimiento.setBounds(400, 500, 100, 30);
        jbMovimiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evento_JbMovimiento();
                setVisible(false);
            }
        });
        add(jbMovimiento);
        
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(290, 500, 100, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 setVisible(false); // ocultar la ventana de Matematicas
                 dispose(); // destruir la ventana de Matematicas
                 fs.setVisible(true); // mostrar la ventana de menu principal 
            }
        });
        add(jbVolver);
        
        ImageIcon imgOriginal = new ImageIcon(getClass().getResource("/imagenes/FONDO.png"));
        ImageIcon imgScalada = new ImageIcon(imgOriginal.getImage().getScaledInstance(800,485, Image.SCALE_DEFAULT));
        jlImagen = new JLabel(imgScalada);
        jlImagen.setBounds(0, 80, 800, 485);
        add(jlImagen);
        
    }
    public void Evento_JbMovimiento(){
        INTERFAZSF INTERFAZSF = new INTERFAZSF(this);
        INTERFAZSF.setVisible(true);
    }

    public static void main(String[] args) {
        InterfazFisica ej = new InterfazFisica(new Fisica(new MenuPrincipal()));
        ej.setVisible(true);
    }
  
       
}
