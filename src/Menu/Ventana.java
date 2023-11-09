/**
 * Propósito:Clase donde se representa la interfaz gráfica para la
 * simulación de caída libre.
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel lblGravedad;
    private JLabel lblPosicion;
    private JLabel lblVelocidad;
    private JTextField txtPosicion;
    private JTextField txtVelocidad;
    private JTextField txtGravedad;
    private JPanel Panel1;
    private JPanel PanelTexto;
    private JPanel PanelBotones;
    JButton btnEmpieza;

    JButton jbVolver;
    MiCanvas canvas;
    Hilo hilo;
    boolean bPausa;
    InterfazFisica i;

    /**
     * Constructor de la clase Ventana.
     *
     * @param obj Instancia de InterfazFisica asociada a la ventana.
     */
    public Ventana(InterfazFisica obj) {
        i = obj;

        this.lblGravedad = new JLabel();
        this.lblPosicion = new JLabel();
        this.lblVelocidad = new JLabel();

        this.txtGravedad = new JTextField();
        this.txtPosicion = new JTextField();
        this.txtVelocidad = new JTextField();

        this.btnEmpieza = new JButton();

        this.Panel1 = new JPanel();
        this.PanelTexto = new JPanel();
        this.PanelBotones = new JPanel();

        this.canvas = new MiCanvas(this);
        this.hilo = new Hilo(this);
        init();
    }

    /**
     * Inicializa la interfaz gráfica de la ventana.
     */
    private void init() {
        Accion accion = new Accion(this);
        ValidaDouble validadouble = new ValidaDouble();
        this.lblGravedad.setText("Gravedad");
        this.lblPosicion.setText("Posici\363n (m)");
        this.lblVelocidad.setText("Velocidad (m/s)");
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);

        jbVolver = new JButton("Volver");
        jbVolver.setBounds(615, 380, 70, 40);
        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // ocultar la ventana de Matematicas
                dispose(); // destruir la ventana de Matematicas
                i.setVisible(true); // mostrar la ventana de menu principal 
            }
        });
        add(jbVolver);
        this.txtPosicion.setColumns(5);
        this.txtPosicion.setText("200");
        this.txtPosicion.addFocusListener(validadouble);

        this.txtVelocidad.setColumns(5);
        this.txtVelocidad.setText("40");
        this.txtVelocidad.addFocusListener(validadouble);

        this.txtGravedad.setColumns(5);
        this.txtGravedad.setText("9.8");
        this.txtGravedad.addFocusListener(validadouble);

        this.btnEmpieza.addActionListener(accion);
        this.btnEmpieza.setText("Empieza");

        this.PanelTexto.setLayout(new FlowLayout());
        this.PanelTexto.add(this.lblPosicion);
        this.PanelTexto.add(this.txtPosicion);
        this.PanelTexto.add(this.lblGravedad);
        this.PanelTexto.add(this.txtGravedad);
        this.PanelTexto.add(this.lblVelocidad);
        this.PanelTexto.add(this.txtVelocidad);

        this.PanelBotones.setBackground(Color.gray);
        this.PanelBotones.setLayout(new FlowLayout());
        this.PanelBotones.add(btnEmpieza);

        this.Panel1.setBackground(new Color(192, 192, 192));
        this.Panel1.setLayout(new FlowLayout());
        this.Panel1.add(PanelTexto);
        this.Panel1.add(PanelBotones);

        setLayout(new BorderLayout(1, 1));
        setTitle("CAIDA LIBRE");
        add(Panel1, BorderLayout.SOUTH);
        add(this.canvas, BorderLayout.CENTER);
        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds((screenSize.width-550)/2, (screenSize.height-387)/2, 550, 387);
        setBounds(300, 100, 700, 450);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        this.hilo.start();
    }

    /**
     * Método que se ejecuta cuando se presiona el botón "Empieza". Obtiene los
     * valores de posición, velocidad y gravedad, y los utiliza para iniciar la
     * simulación.
     *
     * @param actionevent El evento de acción generado por el botón "Empieza".
     */
    void btnEmpieza_actionPerformed(ActionEvent actionevent) {
        //javax.swing.JOptionPane.showMessageDialog(this, "Boton Empieza","EMPIEZA",1);
        bPausa = true;
        double d = Double.valueOf(this.txtPosicion.getText().trim()).doubleValue();
        double d1 = Double.valueOf(this.txtVelocidad.getText().trim()).doubleValue();
        double d2 = Double.valueOf(this.txtGravedad.getText().trim()).doubleValue();
        canvas.setNuevo(d, d1, d2);
        hilo.putMsg(2);
    }

    /**
     * Método principal que crea una instancia de la clase Ventana y la hace
     * visible.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este
     * caso).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana ej = new Ventana(new InterfazFisica(new Fisica()));
            ej.setVisible(true);
        });
    }
}
