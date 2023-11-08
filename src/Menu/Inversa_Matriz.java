package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.nio.file.Files.size;
import java.text.DecimalFormat;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Inversa_Matriz extends JFrame {

    JButton jbVolver;
    Alg al;

/*Se declaran las variables de clase que se utilizarán en toda la clase, 
    como botones, matrices, campos de entrada y áreas de texto*/
    
    int n; // Tamaño de la matriz
    double[][] a; // Matriz a la que se calculará la inversa
    double[][] invA; // Matriz inversa
    private JTextField[][] matrixFields; // Campos de entrada para la matriz
    private JTextArea resultArea; // Área para mostrar los resultados
    private DecimalFormat decimalFormat; // Formateador de números decimales

     
//Este es el constructor de la clase Inversa_Matriz, que toma un objeto de tipo Alg como argumento. La clase Alg parece estar relacionada con el manejo de la interfaz de usuario.
    public Inversa_Matriz(Alg obj) {
        super("Inversa de una Matriz");
        al = obj;
        int size = 5; // Cambia el tamaño de la matriz según tus necesidades
        n = size;
        a = new double[n][n];
        invA = new double[n][n];
    
/*En esta sección, se configura la ventana de la aplicación. Se establece el título, el tamaño, la ubicación, la 
imagen del ícono y otras propiedades de la ventana. También se inicializa la matriz a y invA con el tamaño especificado.*/
        
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(700, 600);
        setLocation(330, 70);
        setResizable(false);
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        setLayout(new BorderLayout());

        decimalFormat = new DecimalFormat("#.##"); // Establece el formato a dos decimales

        /* Se crean campos de entrada en forma de una matriz de JTextField para que el usuario 
        pueda ingresar los coeficientes de la matriz. Estos campos se organizan en una cuadrícula utilizando un panel.*/
        
        JPanel matrixPanel = new JPanel(new GridLayout(n, n));
        matrixFields = new JTextField[n][n];
     
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixFields[i][j] = new JTextField(5);
                matrixPanel.add(matrixFields[i][j]);
            }
        }

        /*Se crea un botón llamado "Calcular Inversa" que, cuando se hace clic, ejecuta una serie de acciones, 
        como leer la matriz desde los campos de entrada, calcular la inversa y mostrar el resultado.*/
        
        JButton inverseButton = new JButton("Calcular Inversa");
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

        /* Se crea un área de texto que se utilizará para mostrar los resultados de los cálculos, 
        y se configura como no editable para que el usuario no pueda modificarlo*/
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        // Crear un panel para el botón de calcular inversa
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inverseButton);

        /*En esta sección, se organizan y agregan todos los componentes (matriz de entrada, botones y área de resultados) 
        en la ventana utilizando un diseño de BorderLayout.*/
        add(matrixPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultArea, BorderLayout.NORTH);
    }

    /*Este método se utiliza para leer los valores ingresados 
    por el usuario en los campos de entrada y almacenarlos en la matriz a.*/
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

    
    //Este método realiza los cálculos para calcular la inversa de la matriz utilizando el método de Gauss-Jordan.
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


    // Este método muestra la inversa calculada en el área de texto de resultados con un formato específico.
    public void displayInverse() {
        resultArea.setText("Inversa de la Matriz:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultArea.append(decimalFormat.format(invA[i][j]) + " ");
            }
            resultArea.append("\n");
        }
    }
/*El método main es la entrada principal de la aplicación. 
 Se crea una instancia de Inversa_Matriz y se hace visible para que el usuario pueda interactuar con la ventana.*/
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            Inversa_Matriz frame = new Inversa_Matriz(new Alg(new MenuPrincipal()));
            frame.setVisible(true);
        });
    }
//Este método se ejecuta cuando se presiona el botón "Volver".
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        al.setVisible(true); // mostrar la ventana 
    }
}
