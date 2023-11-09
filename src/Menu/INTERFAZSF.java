/**
 * Propósito:Clase la cual se muestra la interfaz de Fisica
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

import Menu.calculos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Clase que representa la ventana de un juego de Física con movimiento
 * parabólico.
 */
public class INTERFAZSF extends JFrame {

    JTextField jtEntero, jtEnter, jtTIEMPO;
    JLabel jlTexto, jlTextoImg, jlAltgra, jlAlcgra, jlPosixgra, jlPosiygra, jlRadianes;
    JLabel jlImagen, jlAlturaf, jlAlcancef, jlPosicionxf, jlPosicionyf, jlGrados;
    JButton jbGuardar, jbLimpiar, jbVolver;
    JTextArea jtArea;
    InterfazFisica i;

    /**
     * Constructor de la clase INTERFAZSF.
     *
     * @param obj Objeto de la clase InterfazFisica.
     */
    public INTERFAZSF(InterfazFisica obj) {
        super("Juego - Fisica");
        i = obj;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBackground(Color.yellow);
        setLayout(null);
        crearGUI();
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);

        setVisible(false);
    }

    public void crearGUI() {

        jlTexto = new JLabel("MOVIMIENTO PARABOLICO");
        jlTexto.setBounds(0, 0, 800, 80);
        jlTexto.setOpaque(true);
        jlTexto.setBackground(Color.BLACK);
        jlTexto.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
        jlTexto.setForeground(Color.WHITE);
        jlTexto.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlTexto);

        JLabel jlEntero = new JLabel("ANGULO");
        jlEntero.setBounds(105, 150, 250, 25);
        jlEntero.setForeground(Color.white);
        add(jlEntero);

        jtEntero = new JTextField();
        jtEntero.setBounds(180, 150, 100, 25);
        jtEntero.setBackground(Color.gray);
        jtEntero.setForeground(Color.white);
        add(jtEntero);

        JLabel jlEnter = new JLabel("VELOCIDAD");
        jlEnter.setBounds(105, 215, 250, 25);
        jlEnter.setForeground(Color.white);
        add(jlEnter);

        jtEnter = new JTextField();
        jtEnter.setBounds(180, 215, 100, 25);
        jtEnter.setBackground(Color.gray);
        jtEnter.setForeground(Color.white);
        add(jtEnter);

        JLabel jlTIEMPO = new JLabel("TIEMPO");
        jlTIEMPO.setBounds(105, 280, 250, 25);
        jlTIEMPO.setForeground(Color.white);
        add(jlTIEMPO);

        jtTIEMPO = new JTextField();
        jtTIEMPO.setBounds(180, 280, 100, 25);
        jtTIEMPO.setBackground(Color.gray);
        jtTIEMPO.setForeground(Color.white);
        add(jtTIEMPO);

        ImageIcon imgOriginal = new ImageIcon(getClass().getResource("/imagenes/Captura.png"));
        ImageIcon imgScalada = new ImageIcon(imgOriginal.getImage().getScaledInstance(280, 230, Image.SCALE_DEFAULT));
        jlImagen = new JLabel(imgScalada);
        jlImagen.setBounds(405, 110, 280, 230);
        add(jlImagen);

        jlGrados = new JLabel("RADIANES");
        jlGrados.setBounds(220, 315, 200, 200);
        jlGrados.setForeground(Color.WHITE);
        add(jlGrados);

        jlAlturaf = new JLabel("");
        jlAlturaf.setBounds(170, 355, 200, 200);
        add(jlAlturaf);

        jlAlcancef = new JLabel("");
        jlAlcancef.setBounds(170, 375, 200, 200);
        add(jlAlcancef);

        jlPosicionxf = new JLabel("");
        jlPosicionxf.setBounds(170, 395, 200, 200);
        add(jlPosicionxf);

        jlPosicionyf = new JLabel("");
        jlPosicionyf.setBounds(170, 415, 200, 200);
        add(jlPosicionyf);

        jlRadianes = new JLabel("GRADOS");
        jlRadianes.setBounds(470, 315, 200, 200);
        jlRadianes.setForeground(Color.WHITE);
        add(jlRadianes);

        jlAltgra = new JLabel("");
        jlAltgra.setBounds(420, 355, 200, 200);
        add(jlAltgra);

        jlAlcgra = new JLabel("");
        jlAlcgra.setBounds(420, 375, 200, 200);
        add(jlAlcgra);

        jlPosixgra = new JLabel("");
        jlPosixgra.setBounds(420, 395, 200, 200);
        add(jlPosixgra);

        jlPosiygra = new JLabel("");
        jlPosiygra.setBounds(420, 415, 200, 200);
        add(jlPosiygra);

        jbGuardar = new JButton("MOSTRAR");
        jbGuardar.setBounds(80, 320, 100, 30);
        jbGuardar.setMnemonic('G');
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGuardar();
            }
        });
        add(jbGuardar);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(640, 520, 100, 30);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // ocultar la ventana de Matematicas
                dispose(); // destruir la ventana de Matematicas
                i.setVisible(true); // mostrar la ventana de menu principal

            }
        });
        add(jbVolver);

        jbLimpiar = new JButton("LIMPIAR");
        jbLimpiar.setBounds(200, 320, 100, 30);
        jbLimpiar.setMnemonic('L');
        jbLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbLimpiar();
            }

            /**
             * Método para manejar el evento del botón "Limpiar".
             */
            private void evento_jbLimpiar() {
                jtEntero.setText("");
                jtEnter.setText("");
                jtTIEMPO.setText("");
                jlAlturaf.setText("");
                jlAlcancef.setText("");
                jlPosicionxf.setText("");
                jlPosicionyf.setText("");
                jlAltgra.setText("");
                jlAlcgra.setText("");
                jlPosixgra.setText("");
                jlPosiygra.setText("");
            }
        });
        add(jbLimpiar);

        JPanel jp = new JPanel();
        jp.setBounds(65, 100, 250, 250);
        jp.setBackground(Color.DARK_GRAY);
        add(jp);

        JPanel jpf = new JPanel();
        jpf.setBounds(370, 100, 350, 250);
        jpf.setBackground(Color.DARK_GRAY);
        add(jpf);

        JPanel jpft = new JPanel();
        jpft.setBounds(150, 400, 200, 150);
        jpft.setBackground(Color.DARK_GRAY);
        add(jpft);

        JPanel jpftd = new JPanel();
        jpftd.setBounds(400, 400, 200, 150);
        jpftd.setBackground(Color.DARK_GRAY);
        add(jpftd);

        JPanel jpfg = new JPanel();
        jpfg.setBounds(0, 0, 800, 600);
        jpfg.setBackground(Color.black);
        add(jpfg);
    }

    /**
     * Método para manejar el evento del botón "Guardar".
     */
    public void evento_jbGuardar() {
        calculos obj = new calculos();
        String entero = jtEntero.getText();
        String enter = jtEnter.getText();
        String tiempo = jtTIEMPO.getText();

        //guardar datos
        float valor = Float.parseFloat(entero);
        float enterr = Float.parseFloat(enter);
        float tiempo1 = Float.parseFloat(tiempo);

        // obj.setAltura(valor);
        float alturaafinal = obj.calcularaltura(valor, enterr, tiempo1);
        jlAlturaf.setText("Altura Maxima: " + alturaafinal);
        jlAlturaf.setForeground(Color.CYAN);

        float alcancefinal = obj.calcularalcance(valor, enterr, tiempo1);
        jlAlcancef.setText("Alcance Maximo: " + alcancefinal);
        jlAlcancef.setForeground(Color.CYAN);

        float posicionxfinal = obj.calcularposicionx(valor, enterr, tiempo1);
        jlPosicionxf.setText("Espacio Horizontal: " + posicionxfinal);
        jlPosicionxf.setForeground(Color.CYAN);

        float posicionyfinal = obj.calcularposiciony(valor, enterr, tiempo1);
        jlPosicionyf.setText("Altura " + posicionyfinal);
        jlPosicionyf.setForeground(Color.CYAN);

        float alturagra = obj.calcularaltgrados(valor, enterr, tiempo1);
        jlAltgra.setText("Altura Maxima: " + alturagra);
        jlAltgra.setForeground(Color.CYAN);

        float alcancegra = obj.calcularalcgrados(valor, enterr, tiempo1);
        jlAlcgra.setText("Alcance Maximo: " + alcancegra);
        jlAlcgra.setForeground(Color.CYAN);

        float posicionxgra = obj.calcularposixgra(valor, enterr, tiempo1);
        jlPosixgra.setText("Espacio Horizontal: " + posicionxgra);
        jlPosixgra.setForeground(Color.CYAN);

        float posicionygra = obj.calcularposiygra(valor, enterr, tiempo1);
        jlPosiygra.setText("Altura: " + posicionygra);
        jlPosiygra.setForeground(Color.CYAN);

    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
     */
    public static void main(String[] args) {

        INTERFAZSF ej = new INTERFAZSF(new InterfazFisica(new Fisica()));
        ej.setVisible(true);
    }

}
