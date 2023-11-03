package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraficVectores extends JFrame {

    // Lista para almacenar los vectores ingresados por el usuario
    private ArrayList<Vector> vectors = new ArrayList<>();

    // Vector para almacenar el resultado de la suma de vectores
    private Vector sumVector = null;

    private JPanel drawingPanel; // Panel de dibujo
    private JTextField xField; // Campo de entrada para la coordenada X
    private JTextField yField; // Campo de entrada para la coordenada Y
    private int gridSize = 10; // Tamaño de la cuadrícula

    public GraficVectores() {
        setTitle("Plano Cartesiano");
        setSize(600, 600);
        setResizable(false); // La ventana no se puede redimensionar
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Panel de dibujo personalizado
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g); // Dibujar la cuadrícula
                drawVectors(g); // Dibujar los vectores ingresados
                drawSumVector(g); // Dibujar el vector suma (si existe)
            }
        };
        drawingPanel.setPreferredSize(new Dimension(600, 500));
        drawingPanel.setBackground(Color.white);

        JPanel inputPanel = new JPanel();
        xField = new JTextField(5);
        yField = new JTextField(5);
        JButton drawButton = new JButton("Graficar");
        JButton sumButton = new JButton("Sumar Vectores");

        // ActionListener para el botón "Graficar"
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(xField.getText());
                    double y = Double.parseDouble(yField.getText());
                    Vector vector = new Vector(x * gridSize, y * gridSize);
                    vectors.add(vector); // Agregar el vector a la lista
                    sumVector = null; // Reiniciar el vector suma
                    drawingPanel.repaint(); // Redibujar el panel
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese coordenadas válidas.");
                }
            }
        });

        // ActionListener para el botón "Sumar Vectores"
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vectors.size() >= 2) {
                    sumVector = Vector.sum(vectors); // Calcular el vector suma
                    drawingPanel.repaint(); // Redibujar el panel
                } else {
                    JOptionPane.showMessageDialog(null, "Se requieren al menos dos vectores para sumar.");
                }
            }
        });

        inputPanel.add(new JLabel("X:"));
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:"));
        inputPanel.add(yField);
        inputPanel.add(drawButton);
        inputPanel.add(sumButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(drawingPanel, BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    // Método para dibujar la cuadrícula
    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < 600; x += gridSize) {
            g.drawLine(x, 0, x, 500);
        }
        for (int y = 0; y < 500; y += gridSize) {
            g.drawLine(0, y, 600, y);
        }
        g.setColor(Color.BLACK);
        g.drawLine(300, 0, 300, 500); // Eje Y
        g.drawLine(0, 250, 600, 250); // Eje X
    }

    // Método para dibujar los vectores ingresados
    private void drawVectors(Graphics g) {
        for (Vector vector : vectors) {
            int x1 = 300 + (int) vector.getStartX();
            int y1 = 250 - (int) vector.getStartY();
            int x2 = 300 + (int) vector.getEndX();
            int y2 = 250 - (int) vector.getEndY();

            g.setColor(Color.RED);
            g.drawLine(x1, y1, x2, y2);

            g.setColor(Color.BLACK);
            String coords = "(" + vector.getEndX() / gridSize + "," + vector.getEndY() / gridSize + ")";
            g.drawString(coords, x2, y2 - 5);
        }
    }

    // Método para dibujar el vector suma
    private void drawSumVector(Graphics g) {
        if (sumVector != null) {
            int x1 = 300;
            int y1 = 250;
            int x2 = 300 + (int) sumVector.getEndX();
            int y2 = 250 - (int) sumVector.getEndY();

            g.setColor(Color.BLUE);
            g.drawLine(x1, y1, x2, y2);

            g.setColor(Color.BLACK);
            String coords = "(" + sumVector.getEndX() / gridSize + "," + sumVector.getEndY() / gridSize + ")";
            g.drawString(coords, x2, y2 - 5);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraficVectores().setVisible(true);
            }
        });
    }
}

class Vector {

    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Vector(double x, double y) {
        this.startX = 0;
        this.startY = 0;
        this.endX = x;
        this.endY = y;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    // Método estático para sumar varios vectores
    public static Vector sum(ArrayList<Vector> vectors) {
        double sumX = 0;
        double sumY = 0;
        for (Vector vector : vectors) {
            sumX += vector.getEndX();
            sumY += vector.getEndY();
        }
        return new Vector(sumX, sumY);
    }
}
