package Menu;

import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Datos extends JFrame {

    JTextField jtNombre, jtApellido, jtCorreo, jtCodigo;
    JComboBox<Object> jcCarrera;
    JButton jbVolver, jbLimpiar, jbGuardar, jbSiguiente, jbAtras;
    private static final long serialVersionUID = 1L;

    public Datos() {
        super("Ingreso datos");
        setSize(600, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); //asignar un diseño libre
        crearGUI();
        setVisible(false);
    }

    public void crearGUI() {
        JLabel jlApellido = new JLabel("Apellido");
        jlApellido.setBounds(40, 70, 120, 30);
        add(jlApellido);
        jtApellido = new JTextField();
        jtApellido.setBounds(160, 70, 200, 30);
        add(jtApellido);
        JLabel jlNombre = new JLabel("Nombre");
        jlNombre.setBounds(40, 130, 120, 30);
        add(jlNombre);
        jtNombre = new JTextField();
        jtNombre.setBounds(160, 130, 200, 30);
        add(jtNombre);
        JLabel jlCodigo = new JLabel("Codigo");
        jlCodigo.setBounds(40, 190, 120, 30);
        add(jlCodigo);
        jtCodigo = new JTextField();
        jtCodigo.setBounds(160, 190, 200, 30);
        add(jtCodigo);
        JLabel jlCorreo = new JLabel("Correo");
        jlCorreo.setBounds(40, 250, 120, 30);
        add(jlCorreo);
        jtCorreo = new JTextField();
        jtCorreo.setBounds(160, 250, 200, 30);
        add(jtCorreo);
        jcCarrera = new JComboBox<>();
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
        jcCarrera.setBounds(40, 310, 300, 30);
        add(jcCarrera);
        jbGuardar = new JButton("Guardar");
        jbGuardar.addActionListener((e) -> {
            evento_jbGuardar();
        });
        jbGuardar.setBounds(40, 370, 150, 30);
        add(jbGuardar);
        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.addActionListener((e) -> {
            evento_jbLimpiar();
        });
        jbLimpiar.setBounds(200, 370, 150, 30);
        add(jbLimpiar);
        jbVolver = new JButton("Volver al menu");
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        jbVolver.setBounds(360, 370, 150, 30);
        add(jbVolver);
    }

    private void evento_jbLimpiar() {
        jtApellido.setText("");
        jtNombre.setText("");
        jtCodigo.setText("");
        jtCorreo.setText("");
        jcCarrera.setSelectedIndex(0);
        jtApellido.requestFocus();
    }

    private void evento_jbGuardar() {
        FileWriter fw = null;
        boolean error = false;
        try {
            fw = new FileWriter("Datos.csv", true);
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error al crear o abrri el archivo Datos.csv");
        }
        if (!error) {
            try {
                fw.write(jtApellido.getText() + ";" + jtNombre.getText() + ";" + jtCodigo.getText() + ";" + jtCorreo.getText() + ";" + jcCarrera.getSelectedItem() + "\r\n");
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

            Util util = new Util();
            util.guardar_datos(jtNombre.getText(), jtApellido.getText(), jtCorreo.getText(), jtCodigo.getText(), jcCarrera.getSelectedItem().toString());
            Cuestionario_ods c = new Cuestionario_ods("CUESTIONARIO HUMANIDADES");
            c.setVisible(true);
            dispose();
        }
    }

    private void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
    }

    public static void main(String[] args) {
        Datos d = new Datos();
        d.setVisible(true);
    }
}
