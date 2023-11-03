package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    private JPanel jPanel1;
    private JTextField texFuncion;
    private JTextField texFuncionSalida;
    private JButton jButton1;

    public Interfaz() {
        super("My Form");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(18, 18, 18));
        jPanel1.setLayout(new BorderLayout());

        JLabel jLabel1 = new JLabel("Funcion a derivar");
        jPanel1.add(jLabel1, BorderLayout.NORTH);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());

        texFuncion = new JTextField(20);
        jPanel2.add(texFuncion);

        jButton1 = new JButton("Derivar");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2, BorderLayout.CENTER);

        JLabel jLabel2 = new JLabel("Funcion derivada");
        jPanel1.add(jLabel2, BorderLayout.SOUTH);

        texFuncionSalida = new JTextField(20);
        jPanel1.add(texFuncionSalida, BorderLayout.SOUTH);

        add(jPanel1);

        pack();
        setVisible(true);
    }

    public void jButton1ActionPerformed(ActionEvent e) {
        // Agregar la lógica para la acción del botón "Derivar" aquí
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interfaz();
            }
        });
    }
}
