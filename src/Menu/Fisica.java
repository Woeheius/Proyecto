/**
 * Propósito:Clase la cual se mostrara el menu de el area de fisica
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
 * Clase que representa la ventana del área de Física.
 */
public class Fisica extends JFrame {

   MenuPrincipal mp;
    JButton jbVolver, jbVectores, jbGraficadora,jbJuego;
    GraficVectores g = new GraficVectores(this);
    InterfazFisica i = new InterfazFisica(this);
    
    
    /**
     * Constructor de la clase Fisica.
     *
     * @param obj Objeto de la clase MenuPrincipal.
     */
    public Fisica(MenuPrincipal obj) {
        super("Area de Fisica");
        mp = obj;
        setSize(900, 600);
        //setLocation(1000, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setResizable(false);
        getContentPane().setBackground(
                new Color(41, 41, 41));
        Image im = new ImageIcon(
                getClass().getResource("/imagenes/aaaa.png")).getImage();
        setIconImage(im);
        setLayout(null); // asignar un diseño libre
        crearGUI();

        setVisible(true);
    }

    Fisica() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    /**
     * Método para crear la interfaz gráfica de la ventana.
     */
    public void crearGUI() {
        ImageIcon ic = new ImageIcon(
                getClass().getResource("/imagenes/fisicaa.png"));
        JLabel jlTitulo = new JLabel("Area de Fisica", ic, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 900, 80);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.DARK_GRAY);
        jlTitulo.setForeground(Color.white);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
        add(jlTitulo);

        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(570, 530, 300, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
        
         ImageIcon i_vect = new ImageIcon(
                getClass().getResource("/imagenes/vect.png"));
        jbVectores = new JButton("Vectores", i_vect);
        jbVectores.setBounds(100, 160, 300, 50);
        jbVectores.addActionListener((e) -> {
            evento_jbVectores();
        });
        add(jbVectores);
        
        
        jbGraficadora = new JButton("Graficadora");
        jbGraficadora.setBounds((2025 - 610) / 2, 168, 100, 40);
        jbGraficadora.addActionListener((e) -> {
            evento_jbGraficadora();
        });
        add(jbGraficadora);
        
        jbJuego = new JButton("Juego");
        jbJuego.setBounds((2025-610)/2, 375, 100, 40);
        jbJuego.addActionListener((e) -> {
            evento_jbJuego();
            InterfazFisica InterfazFisica = new InterfazFisica(this);
            setVisible(false);
            
           });
        add(jbJuego);
    }
    /**
     * Método para manejar el evento del botón "Vectores".
     */
    public void evento_jbVectores() {
        Vectores ve = new Vectores(this);
        setVisible(false); // ocultar la ventana de menu principal
    }
    /**
     * Método para manejar el evento del botón "Volver al menú principal".
     */
    public void evento_jbVolver() {
        setVisible(false); // ocultar la ventana de Matematicas
        dispose(); // destruir la ventana de Matematicas
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
    /**
     * Método para manejar el evento del botón "Graficadora".
     */
    public void evento_jbGraficadora() {
        g.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
        /**
     * Método para manejar el evento del botón "Juego".
     */
    public void evento_jbJuego() {
        i.setVisible(true);
        setVisible(false); // ocultar la ventana de menu principal
    }
    
   
}

  