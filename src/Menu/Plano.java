/**
 * Propósito:Clase en la cual se creara el plano cartesiano y se graficara
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
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
/**
 * La clase Plano se utiliza para dibujar un plano cartesiano en un panel de Java Swing
 * y graficar puntos en él.
 */
class Plano {

    private final JPanel panel;
    private final int w;
    private final int h;
    private final int escala;


    /**
     * Constructor de la clase Plano.
     * 
     * @param panel El panel en el que se dibujará el plano.
     */
    public Plano(JPanel panel) {

        this.escala = 20;
        this.panel = panel;
        //Ancho del panel
        w = panel.getWidth();
        //Alto del panel
        h = panel.getHeight();
        DibujarEjesYEscala();

    }
    /**
     * Dibuja los ejes del plano cartesiano y la escala.
     */
    public void DibujarEjesYEscala() {
        Graphics2D g = (Graphics2D) panel.getGraphics();

        //crea lineas en posicion del x
        int nx = w / 2;
        for (int x = w / 2; x < w; x += escala) {
            g.setColor(Color.GRAY);
            g.drawLine(x, 0, x, h);
            g.drawLine(nx, 0, nx, h);
            nx = nx - escala;

        }

        //crea lineas en posicion de y
        int ny = h / 2;
        for (int y = h / 2; y < h; y += escala) {
            g.setColor(Color.GRAY);
            g.drawLine(0, y, w, y);
            g.drawLine(0, ny, w, ny);
            ny = ny - escala;

        }
        //ejes
        g.setColor(Color.BLACK);
        g.drawLine(w / 2, 0, w / 2, h);
        g.setColor(Color.BLACK);
        g.drawLine(0, h / 2, w, h / 2);

    }

    /**
     * Grafica un punto en el plano cartesiano en la posición (x, y) con el color especificado.
     * 
     * @param x     Coordenada x del punto.
     * @param y     Coordenada y del punto.
     */
    public void graficarPorPuntos(float x, float y) {
        Graphics2D g = (Graphics2D) panel.getGraphics();
        //posicion de puntos
        int GraficarX = (int) (w / 2 + x * escala);
        int GraficarY = (int) (h / 2 - y * escala);
        g.fillOval((int) (GraficarX - 1), (int) (GraficarY - 1), 2, 2);

    }
    /**
     * Grafica una función en el plano cartesiano.
     * 
     * @param funcion La función a graficar..
     */
    public void GraficarFuncion(String funcion) {
        float y = 0;
        //evalua la funcion desde x = -15 hasta x = 15
        Evaluar e = new Evaluar();
        for (float x = -15; x < 15; x += .001) {
            e.setFuncion(funcion);
            e.setValorX(x);
            e.evaluar();
            y = (float) e.getResultadoFuncion();
            graficarPorPuntos(x, y);
        }

    }

    /**
     * Limpia el plano cuando se presiona un botón para limpiar.
     * 
     * @param JBlimpiar Botón utilizado para limpiar el plano.
     */
    public void limpiar(JButton JBlimpiar) {
        Graphics2D g = (Graphics2D) panel.getGraphics();
       
        JBlimpiar.addActionListener((e) -> {

            //limpia el plano
            g.clearRect(0, 0, 600, 400);

        });

    }

}
