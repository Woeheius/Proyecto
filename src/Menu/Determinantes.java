package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Determinantes extends JFrame {
    private JTextField[][] matrixFields;// Matriz de campos de texto para ingresar valores
    private JTextArea resultArea; // Área de texto para mostrar el resultado del cálculo
    JButton jbVolver;// Botón "Volver"
    Alg al; // Referencia a la ventana anterior


    public Determinantes(Alg obj) {
        setTitle("Calculadora de Determinante");
        al = obj; // Asigna la referencia a la ventana anterior
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Configura el comportamiento al cerrar
        setSize(700, 600); // Establece el tamaño de la ventana
        setLocation(330, 70); // Establece la ubicación inicial de la ventana
        setResizable(false); // Evita que la ventana se pueda redimensionar
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        

        JPanel inputPanel = new JPanel(); // Panel para la entrada de datos
        int n = 5; // Tamaño de la matriz, puedes ajustarlo
        matrixFields = new JTextField[n][n]; // Matriz de campos de texto
        inputPanel.setLayout(new GridLayout(n, n)); // Establece un diseño de cuadrícula

         // En este ciclo anidado, se crean los campos de texto y se agregan al inputPanel, 
         //formando una cuadrícula de campos de texto.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                inputPanel.add(matrixFields[i][j]);
            }
        }
       // Se crea un botón llamado calculateButton con el texto "Calcular Determinante" y se configura su tamaño.
       JButton calculateButton = new JButton("Calcular Determinante"); // Botón para calcular el determinante
        calculateButton.setPreferredSize(new Dimension(120, 35)); // Ajusta el tamaño del botón
        resultArea = new JTextArea(5, 20); // Área de texto para mostrar el resultado
        resultArea.setEditable(false); // Hace que el área de texto sea de solo lectura

         // Configura un oyente de acción para el botón "Calcular Determinante"
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDeterminante();
            }
        }); 

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(550, 543, 110, 25);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        add(inputPanel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
        add(new JScrollPane(resultArea), BorderLayout.NORTH);
    }

     // Método para calcular el determinante
    private void calcularDeterminante() {
        int n = matrixFields.length;
        double[][] matriz = new double[n][n];

        // Lee los valores de los campos de texto y los almacena en una matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                try {
                    matriz[i][j] = Double.parseDouble(matrixFields[i][j].getText());
                } catch (NumberFormatException ex) {
                    matriz[i][j] = 0.0; // Maneja entrada inválida como cero
                }
            }
        }

        double determinante = calcularDeterminante(matriz);
        resultArea.setText("Determinante: " + determinante);
    }
   //Este método calcula el determinante de una matriz utilizando el método de cofactores.
    public double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;

        if (n == 1) {
            return matriz[0][0];
        }

        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        double determinante = 0;

        for (int j = 0; j < n; j++) {
            determinante += matriz[0][j] * cofactor(matriz, 0, j) * Math.pow(-1, j);
        }

        return determinante;
    }
   // Este método crea y devuelve una submatriz de la matriz original eliminando la fila y columna especificadas.

    private double[][] submatriz(double[][] matriz, int fila, int columna) {
        int n = matriz.length;
        double[][] submat = new double[n - 1][n - 1];
        int subi = 0;
        for (int i = 0; i < n; i++) {
            if (i == fila) continue;
            int subj = 0;
            for (int j = 0; j < n; j++) {
                if (j == columna) continue;
                submat[subi][subj] = matriz[i][j];
                subj++;
            }
            subi++;
        }
        return submat;
    }
    //Este método calcula el cofactor de un elemento de la matriz utilizando el método de cofactores.
    private double cofactor(double[][] matriz, int fila, int columna) {
        double[][] submat = submatriz(matriz, fila, columna);
        return calcularDeterminante(submat);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Determinantes frame = new Determinantes(new Alg(new MenuPrincipal()));
             frame.setVisible(true);
        });
    }
    public void evento_jbVolver() {
        setVisible(false); 
        dispose(); 
        al.setVisible(true); 
    }
}
