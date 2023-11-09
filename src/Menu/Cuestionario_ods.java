/**
 * Propósito: Clase en la cual sera presentado el cuestionario de 5 preguntas sobre el ODS 1
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
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

class Cuestionario_ods extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton jbSiguiente, jbVolver, jbAtras;
    ButtonGroup bg;
    int correctas = 0, pregunta = 0, cant_preg = 1;
    float porcentaje;
    int m[] = new int[10];
    private String[] guardar = new String[6];
    boolean[] salio = new boolean[30]; //arreglo para controlar las preguntas que salen
    /**
     * Constructor de la clase Cuestionario_ods.
     *
     * @param s Título de la ventana del cuestionario.
     */
    Cuestionario_ods(String s) {
        super("CUESTIONARIO DE HUMANIDADES");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(
                new Color(41, 41, 41));
        label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.white);
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        jbSiguiente = new JButton("Siguiente");
        jbSiguiente.addActionListener(this);
        add(jbSiguiente);
        jbAtras = new JButton("Atras");
        jbAtras.addActionListener((e) -> {
            if (cant_preg > 1) {
                cant_preg--; //reducir contador de preguntas si se acciona el boton atras
                label.setText(guardar[cant_preg - 1]);
                guardar[cant_preg] = null;
            } else {
                JOptionPane.showMessageDialog(null, "No puede retroceder ya que esta es la primera pregunta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        });
        add(jbAtras);
        jbVolver = new JButton("Volver al menu principal");
        jbVolver.setBounds(370, 240, 200, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);

        set(); //se crea el tamaño de los radiobttons y el label que sera presentado en cada pregunta
        label.setBounds(10, 40, 4500, 20);
        radioButton[0].setBounds(50, 80, 60000, 20);
        radioButton[1].setBounds(50, 110, 60000, 20);
        radioButton[2].setBounds(50, 140, 60000, 20);
        radioButton[3].setBounds(50, 170, 60000, 20);
        jbSiguiente.setBounds(210, 240, 100, 30);
        jbAtras.setBounds(50, 240, 100, 30);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setLocation(400, 100);
        setVisible(false);
        setSize(700, 350);
    }

    //manejar todas las acciones basadas en el evento
        /**
     * Maneja las acciones basadas en eventos, principalmente para el botón "Siguiente".
     *
     * @param e Evento de acción.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbSiguiente && cant_preg <= 6) {
            if (check()) {
                correctas++; //se llama la funcion check, donde si la pregunta coincide con el boton seleccionado, correctas aumentara
            }
            cant_preg++; //cantidad de preguntas aumentara
            set();
            if (cant_preg == 6) {
                Datos d = new Datos();
                setVisible(false);
                porcentaje = (float) correctas / 5 * 100;
                DecimalFormat df = new DecimalFormat("#0.0"); //funcion para que porcentaje solo tenga dos decimales
                String porce = df.format(porcentaje);
                JOptionPane.showMessageDialog(null, "Las correctas: " + correctas + "\n" + "Tu porcentaje de correctas es de: " + porce + "%");
                guardar();
                d.setVisible(true);
                guardar = new String[6];
            }
        }
    }

    // Seteando preguntas con sus respuestas
        /**
     * Controla la configuración de las preguntas y respuestas, mostrándolas en la interfaz gráfica.
     */
    private void set() {
        do {
            pregunta = (int) (Math.random() * 30);//la variable pregunta sera aleatoria, y el numero que salga sera la pregunta con sus respuestas que se muestre
        } while (salio[pregunta]);
        salio[pregunta] = true;
        radioButton[4].setSelected(true);
        if (pregunta == 0) {
            label.setText("La metodología de Alkire y Foster mide la pobreza multidimensional como:");
            radioButton[0].setText("Educacion");
            radioButton[1].setText("Salud");
            radioButton[2].setText("Nivel de vida");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 1) {
            label.setText("¿Que se utiliza para saber si una persona es considerada pobre multidimensionalmente?");
            radioButton[0].setText("Linea de corte");
            radioButton[1].setText("Encuestas");
            radioButton[2].setText("Preguntandole a otros");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 2) {
            label.setText("Donde se utiliza el indice de pobreza multidimensional (IPM)");
            radioButton[0].setText("Europa");
            radioButton[1].setText("Asia");
            radioButton[2].setText("Africa");
            radioButton[3].setText("America latina");
        }
        if (pregunta == 3) {
            label.setText("¿Cual es el ODS que puede ayudar a que el ODS 1 (fin de la pobreza) sea cumplido");
            radioButton[0].setText("ODS 3");
            radioButton[1].setText("ODS 7");
            radioButton[2].setText("ODS 10");
            radioButton[3].setText("ODS 8");
        }
        if (pregunta == 4) {
            label.setText("¿Que políticas y programas orientados a promover la inclusión laboral y mejorar las condiciones de trabajo se han implementado en Colombia?");
            radioButton[0].setText("Igualdad de oportunidades en el mercado laboral");
            radioButton[1].setText("Promocion del empleo formal");
            radioButton[2].setText("Proteccion de los derechos laborales");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 5) {
            label.setText("¿En que otros ODS puede contribuir el ODS 1?");
            radioButton[0].setText("ODS 2");
            radioButton[1].setText("ODS 5");
            radioButton[2].setText("ODS 3");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 6) {
            label.setText("¿Que genero la pandemia del covid-19 en el ODS 1?");
            radioButton[0].setText("Aumento las posibilidades de lograr este objetivo");
            radioButton[1].setText("Sigue de la misma manera que antes de que llegara la pandemia");
            radioButton[2].setText("Aumento de la pobreza y exacerbando las desigualdades");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 7) {
            label.setText("¿Que programas creo el gobierno nacional de Colombia para mitigar el aumento de la pobreza durante la pandemia?");
            radioButton[0].setText("Ingreso solidario y programa de apoyo al empleo formal (PAEF)");
            radioButton[1].setText("No creo ningun programa");
            radioButton[2].setText("Programa de apoyo al empleo informal");
            radioButton[3].setText("Servicio nacional de aprendizaje");
        }
        if (pregunta == 8) {
            label.setText("¿Porque se aumento la inseguridad alimentaria en los niños al estar presente la pandemia?");
            radioButton[0].setText("No se aumento, siguió igual");
            radioButton[1].setText("Con la pandemia la inseguridad se vio en disminución");
            radioButton[2].setText("No podían contar con los alimentos que les brindaban las escuelas ya que por la pandemia estas estaban cerradas");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 9) {
            label.setText("¿Los indígenas al considerarse parte fundamental de la naturaleza, que logran hacer?");
            radioButton[0].setText("Conservación del medio");
            radioButton[1].setText("Restauración del medio ambiente");
            radioButton[2].setText("No afectan en nada ");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 10) {
            label.setText("¿Que implica el desarrollo sostenible en comunidades indígenas?");
            radioButton[0].setText("Respetar y valorar su cultura");
            radioButton[1].setText("Reconocer y fortalecer su cultura");
            radioButton[2].setText("A y B son correctas");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 11) {
            label.setText("¿Que se necesita para lograr un desarrollo sostenible en comunidades indígenas?");
            radioButton[0].setText("Promover su participación");
            radioButton[1].setText("Fortalecer sus capacidades y habilidades");
            radioButton[2].setText("Fomentar su participación en planeación");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 12) {
            label.setText("¿Que proyecto se genero en Córdoba, España a causa del covid-19?");
            radioButton[0].setText("Un paso por delante");
            radioButton[1].setText("Dos pasos al frente");
            radioButton[2].setText("Dos pasos por delante");
            radioButton[3].setText("Dos pasos arriba");
        }
        if (pregunta == 13) {
            label.setText("¿Que termino se ha acuñado por la relacion que existe entre la innovación social y la tecnología?");
            radioButton[0].setText("No tienen ninguna relacion");
            radioButton[1].setText("Innovación sociotecnologica");
            radioButton[2].setText("Innovación tecno-social");
            radioButton[3].setText("Innovación social tecnologica");
        }
        if (pregunta == 14) {
            label.setText("¿Que ejemplo se menciona de la innovación social tecnológica?");
            radioButton[0].setText("Empresa Koiki");
            radioButton[1].setText("Google");
            radioButton[2].setText("Facebook");
            radioButton[3].setText("Youtube");
        }
        if (pregunta == 15) {
            label.setText("¿Para que año esta esta planeado que los objetivos de desarrollo sostenible sean cumplidos?");
            radioButton[0].setText("2050");
            radioButton[1].setText("2020");
            radioButton[2].setText("2030");
            radioButton[3].setText("2100");
        }
        if (pregunta == 16) {
            label.setText("¿Que pais de america latina ha implementado la IPM?");
            radioButton[0].setText("Argentina");
            radioButton[1].setText("Colombia");
            radioButton[2].setText("Mexico");
            radioButton[3].setText("Uruguay");
        }
        if (pregunta == 17) {
            label.setText("¿Que metodología se considera la mas flexible y completa para cumplir el ODS 1?");
            radioButton[0].setText("Metodología de Gauss");
            radioButton[1].setText("Metodología de Alkire y Foster");
            radioButton[2].setText("Metodología de Einstein");
            radioButton[3].setText("Metodología de Sarrus");
        }
        if (pregunta == 18) {
            label.setText("La educación logra que los individuos sean:");
            radioButton[0].setText("Creativos");
            radioButton[1].setText("Autonomos");
            radioButton[2].setText("Participativos");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 19) {
            label.setText("La educación es un factor determinante en:");
            radioButton[0].setText("Adquisición de empleo");
            radioButton[1].setText("No es un factor determinante");
            radioButton[2].setText("Mejora de condiciones de vida");
            radioButton[3].setText("A y C son correctas");
        }
        if (pregunta == 20) {
            label.setText("¿Que objetivo tienen la educación popular y la educación no formal?");
            radioButton[0].setText("Ningun objetivo");
            radioButton[1].setText("Lograr que los estudiantes no aprendan");
            radioButton[2].setText("Mejorar las condiciones de vida de los educandos");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 21) {
            label.setText("¿Porque se genera un debate frente al ODS 1?");
            radioButton[0].setText("Se piensa que el objetivo es solo eliminar la pobreza a la mitad");
            radioButton[1].setText("Para implementar estrategias");
            radioButton[2].setText("No se genera ningún debate");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 22) {
            label.setText("¿Que podría llegar a pasar si no se presentan salvaguardas?");
            radioButton[0].setText("No pasaría nada");
            radioButton[1].setText("Los salvaguardas no afectan al ODS 1");
            radioButton[2].setText("Existe el riesgo de que las empresas privadas no cumplan con su responsabilidad");
            radioButton[3].setText("Se haría mas rápido el cumplimiento del ODS 1");
        }
        if (pregunta == 23) {
            label.setText("¿Que se debe desarrollar para asegurar las alianzas publico-privadas?");
            radioButton[0].setText("marcos regulatorios sólidos y mecanismos de rendición de cuentas");
            radioButton[1].setText("Una reunion ");
            radioButton[2].setText("Un incentivo del gobierno");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 24) {
            label.setText("¿Que es esencial para romper el ciclo de la pobreza?");
            radioButton[0].setText("El acceso a una educación de calidad");
            radioButton[1].setText("No se puede romper este ciclo");
            radioButton[2].setText("Acceso a servicios de salud asequibles");
            radioButton[3].setText("A y C son correctas");
        }
        if (pregunta == 25) {
            label.setText("¿Cual es un obstáculo frente a la erradicación de la pobreza?");
            radioButton[0].setText("No existen obstáculos");
            radioButton[1].setText("La desigualdad económica y social");
            radioButton[2].setText("Los gobiernos");
            radioButton[3].setText("Ninguna de las anteriores");
        }
        if (pregunta == 26) {
            label.setText("¿Cuales se consideran motores para el crecimiento económico?");
            radioButton[0].setText("Creación de empleo");
            radioButton[1].setText("Fomento de emprendimiento");
            radioButton[2].setText("Desigualdad social");
            radioButton[3].setText("A y B son correctas");
        }
        if (pregunta == 27) {
            label.setText("¿El ODS 1 quiere crear marcos normativos en?");
            radioButton[0].setText("Ámbito nacional");
            radioButton[1].setText("Ámbito regional ");
            radioButton[2].setText("Ámbito internacional");
            radioButton[3].setText("Todas las anteriores");
        }
        if (pregunta == 28) {
            label.setText("¿De que se trata el ODS 1?");
            radioButton[0].setText("Erradicar la energía contaminante");
            radioButton[1].setText("Tener igualdad de género");
            radioButton[2].setText("Conseguir ciudades sostenibles");
            radioButton[3].setText("Eliminar la pobreza en cualquiera de sus formas");
        }
        if (pregunta == 29) {
            label.setText("¿Que medida por ingreso tiene una persona considerada pobre actualmente ?");
            radioButton[0].setText("3 dólares al día");
            radioButton[1].setText("1.60 dólares al día");
            radioButton[2].setText("Menos de 1.25 dólares al día");
            radioButton[3].setText("Mil dólares al dia");
        }
        label.setBounds(10, 40, 4500, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButton[j].setBounds(50, 80 + i, 60000, 20);
        }
        guardar[cant_preg - 1] = label.getText();
    }

    //defino las respuestas correctas de las preguntas
        /**
     * Comprueba si las respuestas seleccionadas son correctas y aumenta el contador de respuestas correctas.
     *
     * @return `true` si la respuesta seleccionada es correcta, de lo contrario `false`.
     */
    boolean check() {
        if (pregunta == 0) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 1) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 2) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 3) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 4) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 5) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 6) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 7) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 8) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 9) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 10) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 11) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 12) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 13) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 14) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 15) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 16) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 17) {
            return (radioButton[1].isSelected());
        }
        if (pregunta == 18) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 19) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 20) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 21) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 22) {
            return (radioButton[2].isSelected());
        }
        if (pregunta == 23) {
            return (radioButton[0].isSelected());
        }
        if (pregunta == 24) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 25) {
            return (radioButton[1].isSelected());
        }
        if (pregunta == 26) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 27) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 28) {
            return (radioButton[3].isSelected());
        }
        if (pregunta == 29) {
            return (radioButton[2].isSelected());
        }
        return false;
    }
    /**
     * Maneja el evento de volver al menú principal.
     */
    public void evento_jbVolver() {
        MenuPrincipal mp = new MenuPrincipal();
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        mp.setVisible(true); // mostrar la ventana de menu principal 
    }
    /**
     * Guarda el puntaje obtenido en un archivo CSV.
     */
    private void guardar() {
        FileWriter fw = null;
        boolean error = false;
        try {
            fw = new FileWriter("Puntajes.csv", true);
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error al crear o abrri el archivo Puntajes.csv");
        }
        if (!error) {

            try {
                fw.write(correctas + ";" + porcentaje + "\r\n");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Puntajes.csv");
            }
            try {
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo Puntajes.csv");
            }
        }
    }
    /**
     * Método principal para ejecutar el cuestionario.
     *
     * @param s Arreglo de argumentos de cadena.
     */
    public static void main(String s[]) {
        Cuestionario_ods preg = new Cuestionario_ods("Cuestionario de humanidades");
        preg.setVisible(true);
    }

}
