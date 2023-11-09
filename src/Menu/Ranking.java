/**
 * Propósito:Clase donde se llenara la tabla y se organizara en forma descendente segun las respuestas correctas
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
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * La clase Ranking se utiliza para mostrar un ranking de puntajes en una
 * ventana de JavaSwing.
 */
public class Ranking extends JFrame {

    JButton jb_Volver;
    ModeloTabla mt;
    JTable tabla;

    /**
     * Constructor de la clase Ranking.
     */
    public Ranking() {
        super("RANKING");
        setSize(700, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(
                new Color(41, 41, 41));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); //asignar un diseño libre
        crearGUI();
        llenar();
        setVisible(false);
    }

    /**
     * Crea la interfaz gráfica de la ventana de ranking.
     */
    public void crearGUI() {
        JLabel jlMejores = new JLabel("Los mejores puntajes son:", (int) CENTER_ALIGNMENT);
        jlMejores.setBounds(600 / 2 - 500 / 2, 0, 600, 30);
        jlMejores.setBackground(Color.DARK_GRAY);
        jlMejores.setForeground(Color.WHITE);
        jlMejores.setFont(new Font("Tahoma", Font.BOLD, 25) {
        });
        add(jlMejores);

        String encabezados[] = {"Nombre", "Codigo", "Correo", "Puntaje"}; //Encabezados que llevara la tabla
        String datos[][] = {{"", "", "", ""}};

        mt = new ModeloTabla(datos, encabezados);
        tabla = new JTable(mt);

        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);

        DefaultTableCellRenderer tc1 = new DefaultTableCellRenderer();
        tc1.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(tc1);

        DefaultTableCellRenderer tc2 = new DefaultTableCellRenderer();
        tc2.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(1).setCellRenderer(tc2);

        DefaultTableCellRenderer tc3 = new DefaultTableCellRenderer();
        tc1.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(2).setCellRenderer(tc3);

        JScrollPane obj = new JScrollPane(tabla); //se añade un scroll por si la tabla es muy amplia
        obj.setBounds(20, 60, 550, 280);

        add(obj);
        jb_Volver = new JButton("Volver al menu");
        jb_Volver.setBounds(600 - 190, 420, 160, 30);
        jb_Volver.addActionListener((e) -> {
            evento_Jbvolver();
        });
        add(jb_Volver);
    }

    /**
     * Llena la tabla con los datos de los puntajes.
     */
    public void llenar() { //se lee el archivo para llenar la tabla
        FileReader datosFileReader = null;
        FileReader puntajesFileReader = null;
        boolean error = false;

        try {
            datosFileReader = new FileReader("Datos.csv");
            puntajesFileReader = new FileReader("Puntajes.csv"); // Reemplaza "Puntajes.csv" con el nombre de tu archivo de puntajes
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error al abrir uno de los archivos CSV");
        }

        if (!error) {
            BufferedReader datosBr = new BufferedReader(datosFileReader);
            BufferedReader puntajesBr = new BufferedReader(puntajesFileReader);
            mt.removeRow(0);

            try {
                String datosLinea;
                String puntajesLinea;

                while ((datosLinea = datosBr.readLine()) != null && (puntajesLinea = puntajesBr.readLine()) != null) {
                    String datosTokens[] = datosLinea.split(";");
                    String puntajeToken = puntajesLinea.split(";")[0];

                    if (datosTokens.length < 3) {
                    } else {
                        String rowData[] = {datosTokens[0], datosTokens[1], datosTokens[2], puntajeToken};
                        mt.addRow(rowData);
                    }
                }
                //se ordenan los datos de mayor a menos segun el puntaje obtenido
                mt.sortPuntajes();
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "Error al leer uno de los archivos CSV");
            }

            try {
                datosFileReader.close();
                puntajesFileReader.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al tratar de cerrar uno de los archivos CSV");
            }
        }
    }

    /**
     * Evento al presionar el botón "Volver al menú".
     */
    private void evento_Jbvolver() {
        Fin_Cuestionario f = new Fin_Cuestionario();
        setVisible(false); // ocultar la ventana 
        dispose(); // destruir la ventana 
        f.setVisible(true); // mostrar la ventana de menu principal 
    }

    /**
     * Método principal para ejecutar la ventana de ranking.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Ranking r = new Ranking();
        r.setVisible(true);
    }

}