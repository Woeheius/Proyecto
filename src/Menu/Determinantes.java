package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Determinantes extends JFrame {

    /*Aquí se declaran las variables y componentes 
    que se utilizarán en la ventana, como botones, matrices, campos de entrada y áreas de texto.*/
    
    JButton jbVolver;
    Alg al;

    int n; // Tamaño de la matriz
    double[][] a; // Matriz para la que se calculará el determinante
    private JTextField[][] matrixFields; // Campos de entrada para la matriz
    private JTextArea resultArea; // Área para mostrar el resultado
    private DecimalFormat decimalFormat; // Formateador de números decimales

    /*Este es el constructor de la clase DeterminanteMatriz, que toma a
      Alg como argumento, que se utiliza para volver a la ventana del menú principal cuando sea necesario.*/
   
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
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        

        /*Se configura un formato decimal para mostrar los resultados con dos decimales. Luego, se crean 
        campos de entrada en forma de una matriz de JTextField para que el usuario ingrese los coeficientes de la matriz.*/
        
        decimalFormat = new DecimalFormat("#.##"); // Establece el formato a dos decimales

        JPanel matrixPanel = new JPanel(new GridLayout(n, n));
        matrixFields = new JTextField[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        /* Se crea un botón que, cuando se hace clic, ejecuta las acciones 
        de leer la matriz, calcular el determinante y mostrar el resultado*/

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
            evento_jbVolver();
        });
        add(jbVolver);

        /*Se crea un área de texto que se utiliza para mostrar el resultado, 
        y se configura como no editable para que el usuario no pueda modificarlo.*/
        
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        // Crear un panel para el botón de calcular determinante
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(determinantButton);

        // Agregar los componentes a la ventana
        add(matrixPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultArea, BorderLayout.NORTH);
    }

    // Este método se utiliza para leer la matriz desde los campos de entrada y almacenarla en la matriz a.
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

   // Este método calcula el determinante de la matriz utilizando el método de eliminación de Gauss.
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


    // Este método muestra el determinante calculado en el área de resultados con un formato específico.

    public void displayDeterminant(double determinant) {
        resultArea.setText("Determinante de la Matriz: " + decimalFormat.format(determinant));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Determinantes frame = new Determinantes(new Alg(new MenuPrincipal()));
            frame.setVisible(true);
        });
    }

    public void evento_jbVolver() {
        setVisible(false); // Ocultar la ventana de Matemáticas
        dispose(); // Destruir la ventana de Matemáticas
        al.setVisible(true); // Mostrar la ventana del menú principal
    }
}
