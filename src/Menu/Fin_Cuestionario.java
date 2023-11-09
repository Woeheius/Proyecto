/**
 * Propósito:Clase la cual se mostrara al finalizar el cuestionario donde el usuario podra visualizar el ranking y podra volver a responder las preguntas
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

import java.awt.Color;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase representa la ventana final del cuestionario de humanidades. Aquí,
 * el usuario puede ver su calificación, volver a jugar, guardar su calificación
 * y ver el ranking de calificaciones.
 */
public class Fin_Cuestionario extends JFrame {

    JButton jb_Volver, jb_Calificar, jb_Jugar, jb_guardar, jb_Ranking;
    JTextField Calif;
    int calificacion;

    /**
     * Constructor de la ventana de fin de cuestionario.
     */
    public Fin_Cuestionario() {
        super("CUESTIONARIO DE HUMANIDADES");
        setSize(700, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(
                new Color(41, 41, 41));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); //asignar un diseño libre
        crearGUI();
        setVisible(false);
    }

    /**
     * Crea la interfaz gráfica de la ventana de fin de cuestionario.
     */
    public void crearGUI() {
        JLabel jlFin = new JLabel("Has termanidao el cuestionario, gracias por participar");
        jlFin.setBounds(150, 10, 350, 150);
        jlFin.setBackground(Color.DARK_GRAY);
        jlFin.setForeground(Color.white);
        add(jlFin);
        JLabel jlConf = new JLabel("Deseas volver a jugar?");
        jlConf.setBounds(255, 50, 350, 150);
        //jlConf.setOpaque(true);
        jlConf.setBackground(Color.DARK_GRAY);
        jlConf.setForeground(Color.white);
        add(jlConf);
        jb_Jugar = new JButton("Volver a jugar");
        jb_Jugar.addActionListener((e) -> {
            evento_jbJugar();
        });
        jb_Jugar.setBounds(230, 150, 150, 30);
        add(jb_Jugar);
        jb_Volver = new JButton("Volver al menu");
        jb_Volver.addActionListener((e) -> {
            evento_jbVolver();
        });
        jb_Volver.setBounds(50, 300, 150, 30);
        add(jb_Volver);
        jb_Calificar = new JButton("Calificar el cuestionario");
        jb_Calificar.addActionListener((e) -> {
            evento_jbCalificar();
        });
        jb_Calificar.setBounds(390, 300, 200, 30);
        add(jb_Calificar);
        JLabel Calificacion = new JLabel("Ingrese la calificacion del cuestionario de 0 a 5");
        Calificacion.setBounds(10, 220, 340, 30);
        //Calificacion.setOpaque(true);
        Calificacion.setBackground(Color.DARK_GRAY);
        Calificacion.setForeground(Color.white);
        add(Calificacion);
        Calif = new JTextField("");
        Calif.setBounds(300, 220, 160, 30);
        Calif.setEditable(false);
        add(Calif);
        jb_guardar = new JButton("Guardar");
        jb_guardar.addActionListener((e) -> {
            evento_jbguardar();
        });
        jb_guardar.setBounds(490, 220, 150, 30);
        jb_guardar.setEnabled(false);
        add(jb_guardar);
        jb_Ranking = new JButton("Ranking");
        jb_Ranking.addActionListener((e) -> {
            evento_jbRanking();
        });
        jb_Ranking.setBounds(220, 300, 150, 30);
        add(jb_Ranking);
    }

    /**
     * Maneja el evento de volver a jugar el cuestionario.
     */
    private void evento_jbJugar() {
        Cuestionario_ods preg = new Cuestionario_ods("CUESTIONARIO DE HUMANIDADES");
        setVisible(false);
        dispose();
        preg.setVisible(true);
    }

    /**
     * Maneja el evento de volver al menú principal.
     */
    private void evento_jbVolver() {
        MenuPrincipal mp = new MenuPrincipal();
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }

    /**
     * Maneja el evento de calificar el cuestionario.
     */
    private void evento_jbCalificar() {
        Calif.setEditable(true);
        jb_Jugar.setEnabled(false);
        jb_Calificar.setEnabled(false);
        jb_Ranking.setEnabled(false);
        jb_guardar.setEnabled(true);
    }

    /**
     * Maneja el evento de guardar la calificación del usuario.
     */

    private void evento_jbguardar() { //se guarda la calificacion que de el usuario
        if (Calif.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes rellenar este campo con valores entre 0 y 5", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            calificacion = Integer.parseInt(Calif.getText());
            if (calificacion < 0 || calificacion > 5) {
                JOptionPane.showMessageDialog(null, "Debes rellenar este campo con valores entre 0 y 5", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                FileWriter fw = null;
                boolean error = false;
                try {
                    fw = new FileWriter("Calificacion.csv", true);
                } catch (Exception e) {
                    error = true;
                    JOptionPane.showMessageDialog(null, "Error al crear o abrri el archivo Calificacion.csv");
                }
                if (!error) {
                    try {
                        fw.write(calificacion + "\r\n");
                        JOptionPane.showMessageDialog(null, "Se guardo con exito el registro");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Calificacion.csv");
                    }
                    try {
                        fw.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al cerrar el archivo Calificacion.csv");
                    }
                    setVisible(true);
                    jb_Jugar.setEnabled(true);
                }
            }
        }

    }

    /**
     * Maneja el evento de ver el ranking de calificaciones.
     */
    private void evento_jbRanking() {
        Ranking r = new Ranking();
        setVisible(false); //ocultar la ventana
        r.setVisible(true);
    }

    public static void main(String[] args) {
        Fin_Cuestionario f = new Fin_Cuestionario();
        f.setVisible(true);
    }

}