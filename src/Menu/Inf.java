/**
 * Propósito:Clase la cual se mostrara la informacion de el equipo de el proyecto(The best equipo)
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
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
/**
 * Clase que representa la ventana de información sobre el equipo de trabajo.
 */
public final class Inf extends JFrame {

    MenuPrincipal mp;
    JButton jbVolver;
    /**
     * Constructor de la clase Inf.
     *
     * @param obj Objeto de la clase MenuPrincipal.
     */
    public Inf(MenuPrincipal obj) {
        super("Integrantes del equipo de trabajo");
        mp = obj;
        setSize(900, 600);
        //setLocation(1000, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(
                new Color(41, 41, 41));
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/team.png")).getImage();
        setIconImage(im);
        setLayout(null); // asignar un diseño libre
        crearGUI();

        setVisible(true);
    }
/**
 * Método para crear la interfaz gráfica de la ventana de información sobre el equipo de trabajo.
 */
    public void crearGUI() {
        JLabel jlTitulo = new JLabel("Equipo de Trabajo");
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(new Color(41, 41, 41));
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Castellar", Font.BOLD, 35));
        add(jlTitulo);
        
        JLabel imagenMiembro1 = new JLabel();
        imagenMiembro1.setBounds(100, 150, 120, 120);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/Angie.jpeg")); // Ruta de la imagen de Angie
        img1 = new ImageIcon(img1.getImage().getScaledInstance(imagenMiembro1.getWidth(), imagenMiembro1.getHeight(), Image.SCALE_DEFAULT));
        imagenMiembro1.setIcon(img1);
        add(imagenMiembro1);
        
        JLabel nombreMiembro1 = new JLabel("Angie Natalia Cobo Vásquez");
        nombreMiembro1.setBounds(230, 150, 600, 30);
        nombreMiembro1.setForeground(Color.white);
        add(nombreMiembro1);

        JLabel codigoMiembro1 = new JLabel("230222011");
        codigoMiembro1.setBounds(230, 180, 600, 30);
        codigoMiembro1.setForeground(Color.white);
        add(codigoMiembro1);

        JLabel correoMiembro1 = new JLabel("angiecobo0308@gmail.com");
        correoMiembro1.setBounds(230, 210, 600, 30);
        correoMiembro1.setForeground(Color.white);
        add(correoMiembro1);

        JLabel imagenMiembro2 = new JLabel();
        imagenMiembro2.setBounds(500, 150, 120, 120);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/imagenes/Sebastian.jpeg")); // Ruta de la imagen de Sebastian
        img2 = new ImageIcon(img2.getImage().getScaledInstance(imagenMiembro2.getWidth(), imagenMiembro2.getHeight(), Image.SCALE_DEFAULT));
        imagenMiembro2.setIcon(img2);
        add(imagenMiembro2);
        
        JLabel nombreMiembro2 = new JLabel("Sebastian Henao Gamboa");
        nombreMiembro2.setBounds(640, 150, 600, 30);
        nombreMiembro2.setForeground(Color.white);
        add(nombreMiembro2);

        JLabel codigoMiembro2 = new JLabel("230231021");
        codigoMiembro2.setBounds(640, 180, 600, 30);
        codigoMiembro2.setForeground(Color.white);
        add(codigoMiembro2);

        JLabel correoMiembro2 = new JLabel("sebastian.henao03@uceva.edu.co");
        correoMiembro2.setBounds(640, 210, 600, 30);
        correoMiembro2.setForeground(Color.white);
        add(correoMiembro2);

        JLabel imagenMiembro3 = new JLabel();
        imagenMiembro3.setBounds(100, 350, 120, 120);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/imagenes/Santiago.jpeg")); // Ruta de la imagen de Santiago
        img3 = new ImageIcon(img3.getImage().getScaledInstance(imagenMiembro3.getWidth(), imagenMiembro3.getHeight(), Image.SCALE_DEFAULT));
        imagenMiembro3.setIcon(img3);
        add(imagenMiembro3);
        
        JLabel nombreMiembro3 = new JLabel("Santiago Ospina Gonzalez");
        nombreMiembro3.setBounds(230, 350, 600, 30);
        nombreMiembro3.setForeground(Color.white);
        add(nombreMiembro3);

        JLabel codigoMiembro3 = new JLabel("230231040");
        codigoMiembro3.setBounds(230, 380, 600, 30);
        codigoMiembro3.setForeground(Color.white);
        add(codigoMiembro3);

        JLabel correoMiembro3 = new JLabel("santiago.ospina03@uceva.edu.co");
        correoMiembro3.setBounds(230, 410, 600, 30);
        correoMiembro3.setForeground(Color.white);
        add(correoMiembro3);

        JLabel imagenMiembro4 = new JLabel();
        imagenMiembro4.setBounds(500, 350, 120, 120);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/imagenes/Juan.jpeg")); // Ruta de la imagen de Juan
        img4 = new ImageIcon(img4.getImage().getScaledInstance(imagenMiembro4.getWidth(), imagenMiembro4.getHeight(), Image.SCALE_DEFAULT));
        imagenMiembro4.setIcon(img4);
        add(imagenMiembro4);
        
        JLabel nombreMiembro4 = new JLabel("Juan Diego Rodriguez Ortiz");
        nombreMiembro4.setBounds(640, 350, 600, 30);
        nombreMiembro4.setForeground(Color.white);
        add(nombreMiembro4);

        JLabel codigoMiembro4 = new JLabel("230231020");
        codigoMiembro4.setBounds(640, 380, 600, 30);
        codigoMiembro4.setForeground(Color.white);
        add(codigoMiembro4);

        JLabel correoMiembro4 = new JLabel("juan.rodriguez16@uceva.edu.co");
        correoMiembro4.setBounds(640, 410, 600, 30);
        correoMiembro4.setForeground(Color.white);
        add(correoMiembro4);


        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }
    /**
     * Método para manejar el evento del botón "Volver".
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
