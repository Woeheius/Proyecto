package Menu;

import Menu.PlanoCartesiano;
import Menu.VentanaFunciones;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class PlanoCartesiano extends JFrame {

    private String funcion1;
    private String funcion2;

    public PlanoCartesiano() {
        setTitle("Plano Cartesiano");
        setSize(600, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new PlanoPanel());
    }

    public void graficarFunciones(String funcion1, String funcion2) {
        this.funcion1 = funcion1;
        this.funcion2 = funcion2;
        repaint();
    }

    private class PlanoPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Dibuja la cuadrícula
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setColor(Color.BLACK);
            int step = 10; // Espaciado de la cuadrícula
            for (int x = 0; x < getWidth(); x += step) {
                g2d.draw(new Line2D.Double(x, 0, x, getHeight()));
            }
            for (int y = 0; y < getHeight(); y += step) {
                g2d.draw(new Line2D.Double(0, y, getWidth(), y));
            }

            // Dibuja las líneas más gruesas en el centro
            g2d.setStroke(new BasicStroke(2)); // Grosor de la línea
            g2d.draw(new Line2D.Double(0, getHeight() / 2, getWidth(), getHeight() / 2));
            g2d.draw(new Line2D.Double(getWidth() / 2, 0, getWidth() / 2, getHeight()));

            // Dibuja los vértices
            int vertexSize = 5; // Tamaño de los vértices
            g2d.setStroke(new BasicStroke(1)); // Restaurar el grosor de la línea
            g2d.fillOval(getWidth() / 2 - vertexSize / 2, getHeight() / 2 - vertexSize / 2, vertexSize, vertexSize);
            g2d.drawLine(getWidth() / 2 - vertexSize, getHeight() / 2, getWidth() / 2 + vertexSize, getHeight() / 2);
            g2d.drawLine(getWidth() / 2, getHeight() / 2 - vertexSize, getWidth() / 2, getHeight() / 2 + vertexSize);

            // Dibuja las funciones 
            if (funcion1 != null && !funcion1.isEmpty()) {
                if (funcion1 != null && !funcion1.isEmpty()) {
                    g2d.setColor(Color.RED);

                    // Crear un objeto JEP para evaluar expresiones matemáticas
                    JEP jep = new JEP();
                    jep.addStandardConstants();
                    jep.addStandardFunctions();

                    // Evaluar y graficar la función 1
                    for (int x = -getWidth() / 2; x <= getWidth() / 2; x++) {
                        jep.addVariable("x", x);
                        jep.parseExpression(funcion1);

                        if (!jep.hasError()) {
                            double y = jep.getValue();

                            // Convierte las coordenadas del plano a las coordenadas del panel
                            int panelX = getWidth() / 2 + x;
                            int panelY = getHeight() / 2 - (int) y;

                            g2d.fillRect(panelX, panelY, 1, 1); // Dibuja un punto para la función 1
                        }
                    }
                }

            }

            if (funcion2 != null && !funcion2.isEmpty()) {
                if (funcion2 != null && !funcion2.isEmpty()) {
                    g2d.setColor(Color.BLUE); // Color de la línea de la función 2 (puedes cambiarlo)

                    // Crear un objeto JEP para evaluar expresiones matemáticas
                    JEP jep = new JEP();
                    jep.addStandardConstants();
                    jep.addStandardFunctions();

                    // Evaluar y graficar la función 2
                    for (int x = -getWidth() / 2; x <= getWidth() / 2; x++) {
                        jep.addVariable("x", x);
                        jep.parseExpression(funcion2);

                        if (!jep.hasError()) {
                            double y = jep.getValue();

                            // Convierte las coordenadas del plano a las coordenadas del panel
                            int panelX = getWidth() / 2 + x;
                            int panelY = getHeight() / 2 - (int) y;

                            g2d.fillRect(panelX, panelY, 1, 1); // Dibuja un punto para la función 2
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanoCartesiano plano = new PlanoCartesiano();
            VentanaFunciones ventanaFunciones = new VentanaFunciones(plano);
            plano.setVisible(true);
            ventanaFunciones.setVisible(true);
        });
    }
}
