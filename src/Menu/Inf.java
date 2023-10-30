package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public final class Inf extends JFrame{
    
    MenuPrincipal mp;
    JButton jbVolver;
    
    public Inf(MenuPrincipal obj){
        super("Integrantes del equipo de trabajo");
        mp = obj;
        setSize(900, 700);
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
    
    public void crearGUI(){
        JLabel jlTitulo = new JLabel("Equipo de Trabajo");
        jlTitulo.setBounds(0, 0, 800, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(new Color(41, 41, 41));
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Castellar", Font.BOLD, 35));
        add(jlTitulo);

        // Miembro 1
        JLabel miembro1 = new JLabel("Miembro 1:");
        miembro1.setBounds(100, 120, 150, 30);
        miembro1.setForeground(Color.white);
        add(miembro1);

        JLabel nombreMiembro1 = new JLabel("- Nombre: Angie Natalia Cobo Vásquez");
        nombreMiembro1.setBounds(120, 150, 600, 30);
        nombreMiembro1.setForeground(Color.white);
        add(nombreMiembro1);

        JLabel codigoMiembro1 = new JLabel("- Código: 230222011");
        codigoMiembro1.setBounds(120, 180, 600, 30);
        codigoMiembro1.setForeground(Color.white);
        add(codigoMiembro1);

        JLabel correoMiembro1 = new JLabel("- Correo: angiecobo0308@gmail.com");
        correoMiembro1.setBounds(120, 210, 600, 30);
        correoMiembro1.setForeground(Color.white);
        add(correoMiembro1);

        JLabel semestreMiembro1 = new JLabel("- Semestre: 3");
        semestreMiembro1.setBounds(120, 240, 600, 30);
        semestreMiembro1.setForeground(Color.white);
        add(semestreMiembro1);

        JLabel telefonoMiembro1 = new JLabel("- Teléfono: 3153185992");
        telefonoMiembro1.setBounds(120, 270, 600, 30);
        telefonoMiembro1.setForeground(Color.white);
        add(telefonoMiembro1);

        // Miembro 2
        JLabel miembro2 = new JLabel("Miembro 2:");
        miembro2.setBounds(450, 120, 150, 30);
        miembro2.setForeground(Color.white);
        add(miembro2);

        JLabel nombreMiembro2 = new JLabel("- Nombre: Sebastian Henao Gamboa");
        nombreMiembro2.setBounds(470, 150, 600, 30);
        nombreMiembro2.setForeground(Color.white);
        add(nombreMiembro2);

        JLabel codigoMiembro2 = new JLabel("- Código: 230231021");
        codigoMiembro2.setBounds(470, 180, 600, 30);
        codigoMiembro2.setForeground(Color.white);
        add(codigoMiembro2);

        JLabel correoMiembro2 = new JLabel("- Correo: sebastian.henao03@uceva.edu.co");
        correoMiembro2.setBounds(470, 210, 600, 30);
        correoMiembro2.setForeground(Color.white);
        add(correoMiembro2);

        JLabel semestreMiembro2 = new JLabel("- Semestre: 2");
        semestreMiembro2.setBounds(470, 240, 600, 30);
        semestreMiembro2.setForeground(Color.white);
        add(semestreMiembro2);

        JLabel telefonoMiembro2 = new JLabel("- Teléfono: 3176831604");
        telefonoMiembro2.setBounds(470, 270, 600, 30);
        telefonoMiembro2.setForeground(Color.white);
        add(telefonoMiembro2);

        // Miembro 3
        JLabel miembro3 = new JLabel("Miembro 3:");
        miembro3.setBounds(100, 320, 150, 30);
        miembro3.setForeground(Color.white);
        add(miembro3);

        JLabel nombreMiembro3 = new JLabel("- Nombre: Santiago Ospina Gonzalez");
        nombreMiembro3.setBounds(120, 350, 600, 30);
        nombreMiembro3.setForeground(Color.white);
        add(nombreMiembro3);

        JLabel codigoMiembro3 = new JLabel("- Código: 230231040");
        codigoMiembro3.setBounds(120, 380, 600, 30);
        codigoMiembro3.setForeground(Color.white);
        add(codigoMiembro3);

        JLabel correoMiembro3 = new JLabel("- Correo: santiago.ospina03@uceva.edu.co");
        correoMiembro3.setBounds(120, 410, 600, 30);
        correoMiembro3.setForeground(Color.white);
        add(correoMiembro3);

        JLabel semestreMiembro3 = new JLabel("- Semestre: 2");
        semestreMiembro3.setBounds(120, 440, 600, 30);
        semestreMiembro3.setForeground(Color.white);
        add(semestreMiembro3);

        JLabel telefonoMiembro3 = new JLabel("- Teléfono: 3017723966");
        telefonoMiembro3.setBounds(120, 470, 600, 30);
        telefonoMiembro3.setForeground(Color.white);
        add(telefonoMiembro3);

        // Miembro 4
        JLabel miembro4 = new JLabel("Miembro 4:");
        miembro4.setBounds(450, 320, 150, 30);
        miembro4.setForeground(Color.white);
        add(miembro4);

        JLabel nombreMiembro4 = new JLabel("- Nombre: Juan Diego Rodriguez Ortiz");
        nombreMiembro4.setBounds(470, 350, 600, 30);
        nombreMiembro4.setForeground(Color.white);
        add(nombreMiembro4);

        JLabel codigoMiembro4 = new JLabel("- Código: 230231020");
        codigoMiembro4.setBounds(470, 380, 600, 30);
        codigoMiembro4.setForeground(Color.white);
        add(codigoMiembro4);

        JLabel correoMiembro4 = new JLabel("- Correo: juan.rodriguez16@uceva.edu.co");
        correoMiembro4.setBounds(470, 410, 600, 30);
        correoMiembro4.setForeground(Color.white);
        add(correoMiembro4);

        JLabel semestreMiembro4 = new JLabel("- Semestre: 2");
        semestreMiembro4.setBounds(470, 440, 600, 30);
        semestreMiembro4.setForeground(Color.white);
        add(semestreMiembro4);

        JLabel telefonoMiembro4 = new JLabel("- Teléfono: 3175158403");
        telefonoMiembro4.setBounds(470, 470, 600, 30);
        telefonoMiembro4.setForeground(Color.white);
        add(telefonoMiembro4);
        
        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(400, 600, 500, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }
    
    public void evento_jbVolver(){
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
}
