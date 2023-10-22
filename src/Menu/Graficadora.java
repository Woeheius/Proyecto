package Menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graficadora extends JPanel {
    public void paintCuadrantes(Graphics g){
       super.paint(g); 
       Graphics2D g2d = (Graphics2D)g;
       BasicStroke grosor1 = new BasicStroke(3);
       g2d.setStroke(grosor1);
       g2d.setColor(Color.red);
       g2d.drawLine(0,350,700, 350);
       g2d.setColor(Color.red);
       g2d.drawLine(350,0,350, 700);

    }
    public static void main(String[]args){
        JFrame ventana = new JFrame("Graficadora");
        Graficadora Objeto = new Graficadora();
        ventana.add(Objeto);
        ventana.setSize(700, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
    }
}
