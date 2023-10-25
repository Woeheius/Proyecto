package Menu;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    String resultado = "Resultados";
    // creando jFrame con radioButton y JButton

    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Siguiente");
        btnBookmark = new JButton("Marcador");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        //radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    //manejar todas las acciones basadas en el evento
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check()) {
                count = count + 1;
            }
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText(resultado);
            }
        }
        if (e.getActionCommand().equals("Marcador")) {
            JButton bk = new JButton("Marcador" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) {
                btnBookmark.setText(resultado);
            }
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Marcador" + y)) {
                if (check()) {
                    count = count + 1;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals(resultado)) {
            if (check()) {
                count = count + 1;
            }
            current++;
            JOptionPane.showMessageDialog(this, "Respuestas correctas= " + count);
            System.exit(0);
        }
    }

    // Seteando preguntas con sus respuestas
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Pregunta 1: ¿Cual de estos animales esta extinto?");
            radioButton[0].setText("Cebra de las llanuras");
            radioButton[1].setText("Barracuda");
            radioButton[2].setText("Perro Domestico");
            radioButton[3].setText("Elefantes");
        }
        if (current == 1) {
            label.setText("Pregunta 2:  ¿Cual es el animal, que el macho da a luz a las crías?");
            radioButton[0].setText("Gato");
            radioButton[1].setText("Caballito de mar");
            radioButton[2].setText("Pez globo");
            radioButton[3].setText("Mantis religiosa");
        }
        if (current == 2) {
            label.setText("Pregunta 3: ¿Cual es el tiburón mas grande en el mundo?.");
            radioButton[0].setText("Tiburón blanco");
            radioButton[1].setText("Tiburón ballena");
            radioButton[2].setText("Tiburón de Groenlandia");
            radioButton[3].setText("Tiburón martillo");
        }
        if (current == 3) {
            label.setText("Pregunta 4: ¿Cual es el animal que mata más personas al año?");
            radioButton[0].setText("Hipopótamo");
            radioButton[1].setText("Mosquito");
            radioButton[2].setText("Leon");
            radioButton[3].setText("Cobra");
        }
        if (current == 4) {
            label.setText("Pregunta 5:  ¿Cual de estos animales es endémico de Guatemala?");
            radioButton[0].setText("Perro");
            radioButton[1].setText("Pato poc");
            radioButton[2].setText("Alcon peregrino");
            radioButton[3].setText("Quetzal");
        }
        if (current == 5) {
            label.setText("Pregunta 6: ¿Cual es el pez que puede cambiar de genero ?");
            radioButton[0].setText("Pez payaso");
            radioButton[1].setText("Pez angel");
            radioButton[2].setText("Pez dorado");
            radioButton[3].setText("Pez globo");
        }
        if (current == 6) {
            label.setText("Pregunta 7:  ¿Cual de estos animales fue descubierto en el lago de Atitlán?");
            radioButton[0].setText("Pez betta");
            radioButton[1].setText("Águila real");
            radioButton[2].setText("Pato poc");
            radioButton[3].setText("Iguana negra");
        }
        if (current == 7) {
            label.setText("Pregunta 8:  ¿Cual es la diferencia entre león hembra y macho?");
            radioButton[0].setText("Ojos");
            radioButton[1].setText("Patas");
            radioButton[2].setText("Melena");
            radioButton[3].setText("El tamaño");
        }
        if (current == 8) {
            label.setText("Pregunta 9: ¿Cual de estos animales se reproduce asexualmente?");
            radioButton[0].setText("Perro");
            radioButton[1].setText("Estrella de mar");
            radioButton[2].setText("Pájaro");
            radioButton[3].setText("Rana dorada");
        }
        if (current == 9) {
            label.setText("Pregunta 10: ¿Cual es la raza de perro originaria de Guatemala?");
            radioButton[0].setText("Pastor aleman");
            radioButton[1].setText("Dogo guatemalteco");
            radioButton[2].setText("Xoloitzcuintle");
            radioButton[3].setText("French");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButton[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    //defino las respuestas correctas de las preguntas
    boolean check() {
        if (current == 0) {
            return (radioButton[0].isSelected());
        }
        if (current == 1) {
            return (radioButton[1].isSelected());
        }
        if (current == 2) {
            return (radioButton[1].isSelected());
        }
        if (current == 3) {
            return (radioButton[1].isSelected());
        }
        if (current == 4) {
            return (radioButton[1].isSelected());
        }
        if (current == 5) {
            return (radioButton[0].isSelected());
        }
        if (current == 6) {
            return (radioButton[2].isSelected());
        }
        if (current == 7) {
            return (radioButton[2].isSelected());
        }
        if (current == 8) {
            return (radioButton[1].isSelected());
        }
        if (current == 9) {
            return (radioButton[1].isSelected());
        }
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Cuestionario de Ciencias Naturales, Copyrith © 2021 Todos los derechos reservados a Jorge Escobar");
    }

}
