/**
 * Propósito:Clase en la cual el usuario ingresara sus datos
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
/**
 * Clase que representa la ventana "Datos".
 */
public class Datos extends JFrame {

    JTextField jtNombre, jtCorreo, jtCodigo;
    JComboBox<Object> jcCarrera;
    JButton jbVolver, jbLimpiar, jbGuardar;
    Cuestionario_ods preg;
    private static final long serialVersionUID = 1L;
    /**
     * Constructor de la clase Datos que crea una ventana para ingresar datos.
     */
    public Datos() {
        super("Ingreso datos");
        setSize(600, 350);
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
     * Crea la interfaz gráfica de la ventana de ingreso de datos.
     */
    public void crearGUI() {
        JLabel jlNombre = new JLabel("Nombre y apellido");
        jlNombre.setBounds(40, 30, 120, 30);
        jlNombre.setOpaque(true);
        jlNombre.setBackground(Color.DARK_GRAY);
        jlNombre.setForeground(Color.white);
        add(jlNombre);
        jtNombre = new JTextField();
        jtNombre.setBounds(160, 30, 200, 30);
        add(jtNombre);
        JLabel jlCodigo = new JLabel("Codigo");
        jlCodigo.setBounds(40, 90, 120, 30);
        jlCodigo.setOpaque(true);
        jlCodigo.setBackground(Color.DARK_GRAY);
        jlCodigo.setForeground(Color.white);
        add(jlCodigo);
        jtCodigo = new JTextField();
        jtCodigo.setBounds(160, 90, 200, 30);
        add(jtCodigo);
        JLabel jlCorreo = new JLabel("Correo");
        jlCorreo.setBounds(40, 150, 120, 30);
        jlCorreo.setOpaque(true);
        jlCorreo.setBackground(Color.DARK_GRAY);
        jlCorreo.setForeground(Color.white);
        add(jlCorreo);
        jtCorreo = new JTextField();
        jtCorreo.setBounds(160, 150, 200, 30);
        add(jtCorreo);
        jcCarrera = new JComboBox<>(); //combobox para elegir la carrera
        jcCarrera.addItem("Seleccione su programa academico");
        jcCarrera.addItem("Licenciatura en ciencias sociales");
        jcCarrera.addItem("Licenciatura en educacion fisica");
        jcCarrera.addItem("Licenciatura en lenguas extranjeras");
        jcCarrera.addItem("Psicologia");
        jcCarrera.addItem("Derecho");
        jcCarrera.addItem("Medicina");
        jcCarrera.addItem("Enfermeria");
        jcCarrera.addItem("Ingenieria biomedica");
        jcCarrera.addItem("Ingenieria ambiental");
        jcCarrera.addItem("Ingenieria industrial");
        jcCarrera.addItem("Ingenieria de sistemas");
        jcCarrera.addItem("Ingenieria electronica");
        jcCarrera.addItem("Ingenieria agropecuaria");
        jcCarrera.addItem("Contaduria publica");
        jcCarrera.addItem("Comercio internacional");
        jcCarrera.addItem("Administracion de empresas");
        jcCarrera.setBounds(40, 210, 300, 30);
        add(jcCarrera);
        jbGuardar = new JButton("Guardar");
        jbGuardar.addActionListener((e) -> {
            evento_jbGuardar();
        });
        jbGuardar.setBounds(40, 270, 150, 30);
        add(jbGuardar);
        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.addActionListener((e) -> {
            evento_jbLimpiar();
        });
        jbLimpiar.setBounds(200, 270, 150, 30);
        add(jbLimpiar);
        jbVolver = new JButton("Volver al menu");
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        jbVolver.setBounds(360, 270, 150, 30);
        add(jbVolver);
    }
    /**
     * Maneja el evento de limpiar los campos de ingreso de datos.
     */
    private void evento_jbLimpiar() { //si se da click en el boton limpiar, los jtextField quedaran en balco y el combobox en su primera pocision
        jtNombre.setText("");
        jtCodigo.setText("");
        jtCorreo.setText("");
        jcCarrera.setSelectedIndex(0);
        jtNombre.requestFocus();
    }
    /**
     * Maneja el evento de guardar los datos ingresados en un archivo CSV.
     */
    private void evento_jbGuardar() { //se guardan los datos ingresados en un archivo .csv
        if (jtNombre.getText().isEmpty() || jtCodigo.getText().isEmpty() || jtCorreo.getText().isEmpty() || jcCarrera.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "DEBES COMPLETAR TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String codigo = jtCodigo.getText();
            int contadorCodigo = 0;

            // Lee el archivo para contar cuántas veces aparece el código
            try {
                BufferedReader br = new BufferedReader(new FileReader("Datos.csv"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] campos = linea.split(";");
                    if (campos.length >= 4 && codigo.equals(campos[2])) {
                        contadorCodigo++;
                        if (contadorCodigo >= 2) {
                            JOptionPane.showMessageDialog(null, "Lo siento, este codigo ya alcanzo el maximo de veces digitado", "ERROR", JOptionPane.ERROR_MESSAGE);
                            br.close();
                            return;
                        }
                    }
                }

                br.close();
            } catch (Exception e) {
            }
            FileWriter fw = null;
            boolean error = false;
            try {
                fw = new FileWriter("Datos.csv", true);
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "Error al crear o abrir el archivo Datos.csv");
            }
            if (!error) {
                try {
                    fw.write(jtNombre.getText() + ";" + jtCodigo.getText() + ";" + jtCorreo.getText() + ";" + jcCarrera.getSelectedItem() + "\r\n");
                    JOptionPane.showMessageDialog(null, "Se guardo con exito el registro");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Datos.csv");
                }
                try {
                    fw.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar el archivo Datos.csv");
                }
                setVisible(true);
                Correo co = new Correo();
                co.test3();
                Fin_Cuestionario f = new Fin_Cuestionario();
                dispose();
                f.setVisible(true);
            }

        }
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
     * Método principal para ejecutar la ventana de ingreso de datos.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Datos d = new Datos();
        d.setVisible(true);
    }
}
