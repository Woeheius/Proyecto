/**
 * Propósito:Clase la cual se mostrará la interfaz para obtener la inversa de una matriz y se hace el proceso.
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
import static java.nio.file.Files.size;
import java.text.DecimalFormat;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Clase que representa la ventana de cálculo de la inversa de una matriz.
 * Permite al usuario ingresar una matriz y calcula su inversa utilizando el
 * método de Gauss-Jordan.
 */
public class Inversa_Matriz extends JFrame {

    JButton jbVolver;
    Alg al;
    JComboBox<Integer> nComboBox;

    int n; // Tamaño de la matriz
    double[][] a; // Matriz a la que se calculará la inversa
    double[][] invA; // Matriz inversa
    private JTextField[][] matrixFields; // Campos de entrada para la matriz
    private JTextArea resultArea; // Área para mostrar los resultados
    private DecimalFormat decimalFormat; // Formateador de números decimales

    /**
     * Constructor de la clase Inversa_Matriz.
     *
     * @param obj La ventana principal de la aplicación.
     */
    public Inversa_Matriz(Alg obj) {
        super("Inversa de una Matriz");
        al = obj;
        int size = 5; // Cambia el tamaño de la matriz según tus necesidades
        n = size;
        a = new double[n][n];
        invA = new double[n][n];

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(700, 600);
        setLocation(330, 70);
        setResizable(false);
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        setLayout(new BorderLayout());

        decimalFormat = new DecimalFormat("#.##"); // Establece el formato a dos decimales

        // Crear una matriz de campos de texto para ingresar los coeficientes
        JPanel matrixPanel = new JPanel(new GridLayout(n, n));
        matrixFields = new JTextField[n][n];

        // Agregar un JComboBox para seleccionar "n"
        nComboBox = new JComboBox<>(new Integer[]{2, 3, 4, 5});
        nComboBox.setSelectedItem(n);
        nComboBox.setBounds(100, 545, 110, 20);
        nComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = (int) nComboBox.getSelectedItem();
                rebuildUI();
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        // Crear un botón para calcular la inversa
        JButton inverseButton = new JButton("Calcular Inversa");
        inverseButton.setBounds(220, 545, 110, 20);
        inverseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readMatrix(); // Leer la matriz desde los campos de texto
                calculateInverse(); // Calcular la inversa de la matriz
                displayInverse(); // Mostrar la inversa en el área de resultados
            }
        });

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(550, 545, 110, 20);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        // Crear un área de texto para mostrar los resultados
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        // Crear un panel para el botón de calcular inversa
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inverseButton);

        // Agregar los componentes a la ventana
        add(nComboBox);
        add(matrixPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultArea, BorderLayout.NORTH);
    }

    // Leer la matriz de los campos de texto
    /**
     * Lee los valores de la matriz desde los campos de texto en la interfaz.
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

    /**
     * Calcula la inversa de la matriz utilizando el método de Gauss-Jordan.
     */
    public void calculateInverse() {
        // Copia la matriz original a la matriz de trabajo 'invA'
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, invA[i], 0, n);
        }

        // Crea una matriz identidad 'I' del mismo tamaño
        double[][] I = new double[n][n];
        for (int i = 0; i < n; i++) {
            I[i][i] = 1.0;
        }

        // Aplica el método de Gauss-Jordan para transformar 'invA' en la inversa
        for (int i = 0; i < n; i++) {
            // Encuentra el pivote actual
            double pivot = invA[i][i];

            // Divide la fila actual por el pivote para tener un 1 en la diagonal
            for (int j = 0; j < n; j++) {
                invA[i][j] /= pivot;
                I[i][j] /= pivot;
            }

            // Actualiza las otras filas para tener ceros debajo del pivote
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = invA[k][i];
                    for (int j = 0; j < n; j++) {
                        invA[k][j] -= factor * invA[i][j];
                        I[k][j] -= factor * I[i][j];
                    }
                }
            }
        }

        // 'invA' ahora contiene la inversa de la matriz original
        for (int i = 0; i < n; i++) {
            System.arraycopy(I[i], 0, invA[i], 0, n);
        }
    }

    /**
     * Muestra la matriz inversa en el área de resultados con formato.
     */
    public void displayInverse() {
        resultArea.setText("Inversa de la Matriz:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultArea.append(decimalFormat.format(invA[i][j]) + " ");
            }
            resultArea.append("\n");
        }
    }

    /**
     * Método principal que crea una instancia de la clase Inversa_Matriz y la
     * hace visible.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Inversa_Matriz frame = new Inversa_Matriz(new Alg(new MenuPrincipal()));
            frame.setVisible(true);
        });
    }

    /**
     * Maneja el evento del botón "Volver" para regresar al menú principal.
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        al.setVisible(true); // mostrar la ventana de menu principal 
    }

    /**
     * Reconstruye la interfaz gráfica de la ventana cuando se cambia el valor
     * de "n", actualizando los campos de entrada para la matriz y los
     * componentes relacionados. Permite al usuario cambiar el tamaño de la
     * matriz y preparar la interfaz para realizar nuevos cálculos de la
     * inversa.
     */
    private void rebuildUI() {
        getContentPane().removeAll(); // Elimina todos los componentes
        getContentPane().invalidate();
        getContentPane().revalidate();
        getContentPane().repaint();

        // Ahora, vuelva a construir la interfaz con el nuevo valor de "n"
        int size = (int) nComboBox.getSelectedItem(); // Nuevo valor de "n"
        n = size;
        a = new double[n][n];
        invA = new double[n][n];

        JPanel matrixPanel = new JPanel(new GridLayout(n, n));
        matrixFields = new JTextField[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }
        JButton inverseButton = new JButton("Calcular Inversa");
        inverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readMatrix();
                calculateInverse();
                displayInverse();
            }
        });

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(550, 545, 110, 20);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inverseButton);

        add(jbVolver);
        add(nComboBox);
        add(matrixPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(new JScrollPane(resultArea), BorderLayout.NORTH);
        revalidate(); // Vuelve a validar la ventana
        repaint(); // Vuelve a pintar la ventana
    }

}
