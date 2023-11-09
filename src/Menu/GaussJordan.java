/**
 * Propósito:Clase la cual se mostrara la interfaz para ingresar los valores de el sistema de ecuaciones y se resuelve
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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
/**
 * Clase que representa la resolución de sistemas de ecuaciones mediante el método de Gauss-Jordan.
 */
public class GaussJordan extends JFrame {

    JButton jbVolver;
    Alg al;
    JComboBox<Integer> nComboBox; // Agrega un JComboBox para seleccionar "n"
    //int n = 3; // Tamaño de la matriz (3x3)
    //double[][] a = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}; // Matriz aumentada (coeficientes + resultados)
    //double[] x = new double[n + 1]; // Soluciones
      
    //int n = 4; // Tamaño de la matriz (4x4)
    //double[][] a = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}; // Matriz aumentada (coeficientes + resultados)
    //double[] x = new double[n]; // Soluciones
    
    int n = 5; // Tamaño de la matriz (5x5)
    double[][] a = {{1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1}}; // Matriz aumentada (coeficientes + resultados)
    double[] x = new double[n]; // Soluciones
    
    private JTextField[][] matrixFields; // Campos de entrada para la matriz
    private JTextArea resultArea; // Área para mostrar los resultados
    private DecimalFormat decimalFormat; // Formateador de números decimales

    /*Se declaran las variables de clase que se utilizarán en toda la clase, 
    como botones, matrices, campos de entrada y áreas de texto*/
    
        /**
     * Constructor de la clase GaussJordan.
     *
     * @param obj Objeto de la clase Alg.
     */
    public GaussJordan(Alg obj) {
        super("Sistema de Ecuaciones");
        al = obj;
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
        JPanel matrixPanel = new JPanel(new GridLayout(n, n + 1));
        matrixFields = new JTextField[n][n + 1];
        
        // Crear un JComboBox 
        nComboBox = new JComboBox<>(new Integer[] { 2, 3, 4, 5 });
        nComboBox.setSelectedItem(n); // Establecer el valor inicial
        nComboBox.setBounds(100, 545, 110, 20);
        nComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = (int) nComboBox.getSelectedItem();
                // Limpia la interfaz gráfica y reconstruye los campos de entrada y resultados
                rebuildUI();
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        // Crear un botón para resolver el sistema
        JButton solveButton = new JButton("Resolver");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readMatrix(); // Leer la matriz desde los campos de texto
                solve(); // Resolver el sistema de ecuaciones
                displayResults(); // Mostrar las soluciones en el área de resultados
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

        // Crear un panel para el botón de resolver
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);

        // Agregar los componentes a la ventana
        add(nComboBox);
        add(matrixPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultArea, BorderLayout.NORTH);
    }

    // Leer la matriz de los campos de texto
    
        /**
     * Método para leer la matriz de los campos de texto.
     */
    public void readMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                try {
                    a[i][j] = Double.parseDouble(matrixFields[i][j].getText());
                } catch (NumberFormatException ex) {
                    a[i][j] = 0.0; // Manejar entrada inválida como cero
                }
            }
        }
    }

    /**
     * Método para realizar el proceso de eliminación de Gauss-Jordan y resolver el sistema de ecuaciones.
     */
    public void solve() {
        for (int i = 0; i < n; i++) {
            pivot(i);
        }
        sustitucion();
    }    /**
     * Método para aplicar la operación de pivote en la fila i y hacer ceros en las columnas debajo del elemento diagonal actual.
     *
     * @param i Índice de la fila.
     */
    public void pivot(int i) {
        for (int j = i + 1; j < n; j++) {
            if (Math.abs(a[i][i]) < Math.abs(a[j][i])) {
                for (int k = i; k <= n; k++) {
                    double tmp = a[i][k];
                    a[i][k] = a[j][k];
                    a[j][k] = tmp;
                }
            }
        }

        double cte = 1.0 / a[i][i];

        for (int k = i; k <= n; k++) {
            a[i][k] *= cte;
        }

        for (int k = i + 1; k < n; k++) {
            double factor = a[k][i];
            for (int j = i; j <= n; j++) {
                a[k][j] -= factor * a[i][j];
            }
        }
    }

    /**
     * Método para realizar la sustitución hacia atrás y obtener las soluciones.
     */
    public void sustitucion() {
        x[n - 1] = a[n - 1][n];

        for (int k = n - 2; k >= 0; k--) {
            double suma = 0;
            for (int j = k + 1; j < n; j++) {
                suma += a[k][j] * x[j];
            }
            x[k] = a[k][n] - suma;
        }
    }

    /**
     * Método para mostrar las soluciones en el área de texto de resultados con formato.
     */
    public void displayResults() {
        resultArea.setText("Resultados:\n");
        for (int i = 0; i < n; i++) {
            resultArea.append("x[" + (i + 1) + "] = " + decimalFormat.format(x[i]) + "\n");
        }
    }

       /**
     * Punto de entrada del programa para crear una instancia de la clase GaussJordan y ejecutarla en el hilo de la interfaz de usuario.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GaussJordan frame = new GaussJordan(new Alg(new MenuPrincipal()));
            frame.setVisible(true);
        });
    }
    /**
     * Método para manejar el evento del botón "Volver".
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        al.setVisible(true); // mostrar la ventana de menu principal 
    }
    /**
     * Método para reconstruir la interfaz gráfica cuando cambia el valor de "n".
     */
private void rebuildUI() {
    getContentPane().removeAll(); // Elimina todos los componentes
    getContentPane().invalidate();
    getContentPane().revalidate();
    getContentPane().repaint();
    
    // Ahora, vuelva a construir la interfaz con el nuevo valor de "n"
    decimalFormat = new DecimalFormat("#.##");

    JPanel matrixPanel = new JPanel(new GridLayout(n, n + 1));
    matrixFields = new JTextField[n][n + 1];
// Crear un JComboBox 
        nComboBox = new JComboBox<>(new Integer[] { 2, 3, 4, 5 });
        nComboBox.setSelectedItem(n); // Establecer el valor inicial
        nComboBox.setBounds(100, 545, 110, 20);
        nComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = (int) nComboBox.getSelectedItem();
                // Limpia la interfaz gráfica y reconstruye los campos de entrada y resultados
                rebuildUI();
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        // Crear un botón para resolver el sistema
        JButton solveButton = new JButton("Resolver");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readMatrix(); // Leer la matriz desde los campos de texto
                solve(); // Resolver el sistema de ecuaciones
                displayResults(); // Mostrar las soluciones en el área de resultados
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

        // Crear un panel para el botón de resolver
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);

    // Agregar los componentes actualizados a la ventana
    add(nComboBox);
    add(matrixPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    add(resultArea, BorderLayout.NORTH);

    revalidate(); // Vuelve a validar la ventana
    repaint(); // Vuelve a pintar la ventana
}

}
