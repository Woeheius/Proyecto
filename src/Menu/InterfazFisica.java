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
      
public InterfazFisica(){
    super("FISICA");
    setSize(800, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
            crearGUI() ;
    
    setVisible(true);
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
                setVisible(false);
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
        INTERFAZSF INTERFAZSF = new INTERFAZSF();
        INTERFAZSF.setVisible(true);
    }

    public static void main(String[] args) {
        InterfazFisica ej = new InterfazFisica();
    }
    
}
