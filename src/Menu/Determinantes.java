/**
 * Propósito:Clase en la cual se realiza el cálculo para obtener la determinante de el sistema ingresado
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 8/11/2023
 * Versión JDK: 12
 */
package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Clase que representa la ventana de "Determinantes".
 */
public class Determinantes extends JFrame {

    JButton jbVolver;
    Alg al;
    JComboBox<Integer> nComboBox; // ComboBox para seleccionar el tamaño de la matriz

    int n; // Tamaño de la matriz
    double[][] a; // Matriz para calcular el determinante
    private JTextField[][] matrixFields; // Campos de entrada para la matriz
    private JTextArea resultArea; // Área para mostrar el resultado
    private DecimalFormat decimalFormat; // Formateador de números decimales

    // Constructor de la ventana
    /**
     * Constructor de la ventana Determinantes.
     *
     * @param obj Objeto de la clase Alg, que permite volver al menú principal.
     */
    public Determinantes(Alg obj) {
        super("Determinante de una Matriz");
        al = obj;
        int size = 5; // Cambia el tamaño de la matriz según tus necesidades
        n = size;
        a = new double[n][n];

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 600);
        setLocation(330, 70);
        setResizable(false);
        Image im = new ImageIcon(getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);

        decimalFormat = new DecimalFormat("#.##"); // Establece el formato a dos decimales

        // Panel para organizar los campos de entrada en una cuadrícula
        JPanel matrixPanel = new JPanel(new GridLayout(n, n));
        matrixFields = new JTextField[n][n];

        nComboBox = new JComboBox<>(new Integer[]{2, 3, 4, 5}); // Valores disponibles para el tamaño de la matriz
        nComboBox.setSelectedItem(n);
        nComboBox.setBounds(100, 545, 110, 20);
        nComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = (int) nComboBox.getSelectedItem();
                rebuildUI(); // Reconstruir la interfaz con el nuevo tamaño de matriz
            }
        });
        add(nComboBox);

        // Crear campos de entrada para la matriz en una cuadrícula
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        JButton determinantButton = new JButton("Calcular Determinante");
        determinantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readMatrix(); // Leer la matriz desde los campos de texto
                double determinant = calculateDeterminant(); // Calcular el determinante de la matriz
                displayDeterminant(determinant); // Mostrar el determinante en el área de resultados
            }
        });

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(550, 545, 110, 20);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver(); // Manejar el evento de volver
        });
        add(jbVolver);

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(determinantButton);

        // Agregar los componentes a la ventana
        add(nComboBox); // Agregar el ComboBox
        add(matrixPanel, BorderLayout.CENTER); // Agregar los campos de entrada
        add(buttonPanel, BorderLayout.SOUTH); // Agregar el botón para calcular
        add(resultArea, BorderLayout.NORTH); // Agregar el área de resultados
    }

    /*Este método se utiliza para leer los valores de la matriz desde los campos de entrada 
    y almacenarlos en la matriz a. Itera a través de los campos de entrada y maneja las entradas inválidas como cero.*/
    /**
     * Lee los valores de la matriz desde los campos de entrada y los almacena
     * en la matriz a. Itera a través de los campos de entrada y maneja las
     * entradas inválidas como cero.
     */
    public void readMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                try {
                    a[i][j] = Double.parseDouble(matrixFields[i][j].getText());
                } catch (NumberFormatException ex) {
                    a[i][j] = 0.0; // Manejar entrada inválida como cero
                }
            }
        }
    }

    /*Este método calcula el determinante de la matriz utilizando el método de eliminación de Gauss. Itera a través de la matriz y realiza operaciones para llevar 
  la matriz a una forma triangular superior, y luego calcula el determinante a partir de los elementos de la diagonal.*/
    /**
     * Calcula el determinante de la matriz utilizando el método de eliminación
     * de Gauss. Itera a través de la matriz y realiza operaciones para llevar
     * la matriz a una forma triangular superior, y luego calcula el
     * determinante a partir de los elementos de la diagonal.
     *
     * @return El valor del determinante calculado.
     */
    public double calculateDeterminant() {
        double determinant = 1.0;

        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                double factor = a[i][j] / a[j][j];

                for (int k = j; k < n; k++) {
                    a[i][k] -= factor * a[j][k];
                }
            }
            determinant *= a[j][j];
        }

        return determinant;
    }

    /**
     * Muestra el determinante calculado en el área de resultados con un formato
     * específico. Utiliza el decimalFormat para mostrar el valor con dos
     * decimales.
     *
     * @param determinant El valor del determinante a mostrar.
     */
    public void displayDeterminant(double determinant) {
        resultArea.setText("Determinante de la Matriz: " + decimalFormat.format(determinant));
    }

    // Método main para iniciar la aplicación Swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Determinantes frame = new Determinantes(new Alg(new MenuPrincipal()));
            frame.setVisible(true); // Hacer visible la ventana
        });
    }

    /**
     * Maneja el evento de volver. Oculta la ventana actual y muestra la ventana
     * del menú principal.
     */
    public void evento_jbVolver() {
        setVisible(false);
        dispose(); // Ocultar y destruir la ventana actual
        al.setVisible(true); // Mostrar la ventana del menú principal
    }

    /**
     * Reconstruye la interfaz gráfica cuando cambia el valor seleccionado en el
     * ComboBox. Elimina y recrea los campos de entrada y otros componentes
     * según el nuevo tamaño de la matriz seleccionado. Luego, vuelve a validar
     * y repintar la ventana para reflejar los cambios.
     */
    private void rebuildUI() {
        getContentPane().removeAll();
        getContentPane().invalidate();
        getContentPane().revalidate();
        getContentPane().repaint();

        decimalFormat = new DecimalFormat("#.##");

        // Panel para organizar los campos de entrada en una cuadrícula
        JPanel matrixPanel = new JPanel(new GridLayout(n, n));
        matrixFields = new JTextField[n][n];

        // Crear campos de entrada para la matriz en una cuadrícula
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        JButton determinantButton = new JButton("Calcular Determinante");
        determinantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readMatrix();
                double determinant = calculateDeterminant();
                displayDeterminant(determinant);
            }
        });

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(550, 545, 110, 20);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(determinantButton);

        // Agregar los componentes actualizados a la ventana
        add(nComboBox);
        add(matrixPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultArea, BorderLayout.NORTH);

        revalidate(); // Vuelve a validar la ventana
        repaint(); // Vuelve a pintar la ventana
    }
}
