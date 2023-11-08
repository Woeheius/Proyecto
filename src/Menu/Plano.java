package Menu;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

class Plano {

    private final JPanel panel;
    private final int w;
    private final int h;
    private final int escala;


    //Contructor recibe el panel de la clase VentanaGraficar
    public Plano(JPanel panel) {

        this.escala = 20;
        this.panel = panel;
        //Ancho del panel
        w = panel.getWidth();
        //Alto del panel
        h = panel.getHeight();
        DibujarEjesYEscala();

    }

    public void DibujarEjesYEscala() {
        //crea un graphics en el panel
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
        //ejes X y Y
        g.setColor(Color.BLACK);
        g.drawLine(w / 2, 0, w / 2, h);
        g.setColor(Color.BLACK);
        g.drawLine(0, h / 2, w, h / 2);

    }

    //grafica puntos y recibe la eleccion de color
    public void graficarPorPuntos(float x, float y, JComboBox color) {
        Graphics2D g = (Graphics2D) panel.getGraphics();
        
        //color de los puntos

        //posicion de puntos
        int GraficarX = (int) (w / 2 + x * escala);
        int GraficarY = (int) (h / 2 - y * escala);
        g.fillOval((int) (GraficarX - 1), (int) (GraficarY - 1), 2, 2);

    }

    public void GraficarFuncion(String funcion, JComboBox color) {
        float y = 0;
        //evalua la funcion desde x = -15 hasta x = 15
        Evaluar e = new Evaluar();
        for (float x = -15; x < 15; x += .001) {
            e.setFuncion(funcion);
            e.setValorX(x);
            e.evaluar();
            y = (float) e.getResultadoFuncion();
            graficarPorPuntos(x, y, color);
        }

    }

    //actionListener de boton limpiar
    public void limpiar(JButton JBlimpiar) {
        Graphics2D g = (Graphics2D) panel.getGraphics();
       
        JBlimpiar.addActionListener((e) -> {

            //limpia el plano
            g.clearRect(0, 0, 600, 400);

        });

    }

}
