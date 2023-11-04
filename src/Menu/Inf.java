package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public final class Inf extends JFrame {

    MenuPrincipal mp;
    JButton jbVolver;

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

    public void crearGUI() {
        JLabel jlTitulo = new JLabel("Equipo de Trabajo");
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(new Color(41, 41, 41));
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Castellar", Font.BOLD, 35));
        add(jlTitulo);


        JLabel nombreMiembro1 = new JLabel("Angie Natalia Cobo Vásquez");
        nombreMiembro1.setBounds(120, 150, 600, 30);
        nombreMiembro1.setForeground(Color.white);
        add(nombreMiembro1);

        JLabel codigoMiembro1 = new JLabel("230222011");
        codigoMiembro1.setBounds(120, 180, 600, 30);
        codigoMiembro1.setForeground(Color.white);
        add(codigoMiembro1);

        JLabel correoMiembro1 = new JLabel("angiecobo0308@gmail.com");
        correoMiembro1.setBounds(120, 210, 600, 30);
        correoMiembro1.setForeground(Color.white);
        add(correoMiembro1);


        // Miembro 2
        JLabel nombreMiembro2 = new JLabel("Sebastian Henao Gamboa");
        nombreMiembro2.setBounds(470, 150, 600, 30);
        nombreMiembro2.setForeground(Color.white);
        add(nombreMiembro2);

        JLabel codigoMiembro2 = new JLabel("230231021");
        codigoMiembro2.setBounds(470, 180, 600, 30);
        codigoMiembro2.setForeground(Color.white);
        add(codigoMiembro2);

        JLabel correoMiembro2 = new JLabel("sebastian.henao03@uceva.edu.co");
        correoMiembro2.setBounds(470, 210, 600, 30);
        correoMiembro2.setForeground(Color.white);
        add(correoMiembro2);


        JLabel nombreMiembro3 = new JLabel("Santiago Ospina Gonzalez");
        nombreMiembro3.setBounds(120, 350, 600, 30);
        nombreMiembro3.setForeground(Color.white);
        add(nombreMiembro3);

        JLabel codigoMiembro3 = new JLabel("230231040");
        codigoMiembro3.setBounds(120, 380, 600, 30);
        codigoMiembro3.setForeground(Color.white);
        add(codigoMiembro3);

        JLabel correoMiembro3 = new JLabel("santiago.ospina03@uceva.edu.co");
        correoMiembro3.setBounds(120, 410, 600, 30);
        correoMiembro3.setForeground(Color.white);
        add(correoMiembro3);


        JLabel nombreMiembro4 = new JLabel("Juan Diego Rodriguez Ortiz");
        nombreMiembro4.setBounds(470, 350, 600, 30);
        nombreMiembro4.setForeground(Color.white);
        add(nombreMiembro4);

        JLabel codigoMiembro4 = new JLabel("230231020");
        codigoMiembro4.setBounds(470, 380, 600, 30);
        codigoMiembro4.setForeground(Color.white);
        add(codigoMiembro4);

        JLabel correoMiembro4 = new JLabel("juan.rodriguez16@uceva.edu.co");
        correoMiembro4.setBounds(470, 410, 600, 30);
        correoMiembro4.setForeground(Color.white);
        add(correoMiembro4);


        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }

    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
