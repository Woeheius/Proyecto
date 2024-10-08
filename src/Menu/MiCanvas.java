/**
 * Propósito:La clase MiCanvas extiende la clase Canvas y se utiliza para dibujar la
 * animación y gráficos en la ventana.
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

import java.awt.*;
import javax.swing.ImageIcon;


public class MiCanvas extends Canvas {

    private static final long serialVersionUID = 1L;

    private double x;
    private double x0 = 200D;
    private double v0;
    private double v;
    private double t;
    private double dt;
    private /*final*/ double G = 9.8D;
    private int wAncho;//ancho de la ventana
    private int wAlto;//alto de la ventana
    private int cAlto;//alto de caracter
    private int cAncho;//ancho de carcater
    private double escalaY;//escala de linea vertical
    private double escalaX;//escala de linea horizontal
    private int orgX;//org x linea vertical segunda (cantidad a la derecha)
    private int orgXX;//org x linea vertical primera (cantidad a la derecha)
    private int orgY;//altura de la linea horizontal
    private int y1;
    private Polygon pol;
    private Graphics gBuffer;
    private Dimension dim;
    private Ventana caidalibre;
    private Image imag;
    private ImageIcon imag2;
    private ImageIcon pasto;
    private ImageIcon edificio;

    /**
     * Constructor predeterminado de la clase MiCanvas.
     */
    public MiCanvas() {
    }

    /**
     * Constructor que recibe una instancia de Ventana para asociarla con el
     * canvas.
     *
     * @param caidalibre La instancia de Ventana asociada al canvas.
     */
    public MiCanvas(Ventana caidalibre) {

        this.caidalibre = caidalibre;
        t = 0.0D;
        dt = 0.08D; //modifica esto para cambiar la velocidad de frameRate
        pol = new Polygon();
        setBackground(Color.WHITE);
        this.imag2 = new ImageIcon("/src/imagenes/balon.gif");//ojo que hay que cambiar esto para que slaga la imagen en el jar
        this.pasto = new ImageIcon("/src/imagenes/pasto.jpg");//ojo que hay que cambiar esto para que slaga la imagen en el jar
        this.edificio = new ImageIcon("/src/imagenes/edificio.gif");//ojo que hay que cambiar esto para que slaga la imagen en el jar
    }

    /**
     * Inicializa las variables relacionadas con las escalas y la posición de
     * los ejes.
     *
     * @param g El objeto Graphics utilizado para obtener información de la
     * fuente y dimensiones.
     */
    public void origenEscalas(Graphics g) {
        cAlto = g.getFontMetrics().getHeight();
        cAncho = g.getFontMetrics().stringWidth("0");
        wAncho = getSize().width;
        wAlto = getSize().height;
        orgX = 12 * 4 * cAncho;
        orgXX = 4 * cAncho;
        orgY = (7 * wAlto) / 10;
        escalaY = (double) wAlto / (double) 500;
        escalaX = (double) (wAncho - orgX) / (double) 20;
    }

    /**
     * Dibuja el primer eje y los rótulos asociados.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    void dibujaEjeAnimacion(Graphics g) {//dibuja el primer eje y los rotulos
        g.setColor(Color.black);
        g.drawString("x(m)", orgXX + 2, cAlto);
        g.drawLine(orgXX, wAlto, orgXX, 0);
        for (int k = -100; k < 400; k += 100) {
            int i = orgXX - g.getFontMetrics().stringWidth(String.valueOf(k)) - cAncho / 2;
            int j = (orgY - (int) ((double) k * escalaY)) + cAlto / 2;
            g.drawString(String.valueOf(k), i, j);
            j = orgY - (int) ((double) k * escalaY);
            g.drawLine(orgXX - 2, j, orgXX + 2, j);
            j = orgY - (int) ((double) (k + 50) * escalaY);
            g.drawLine(orgXX - 1, j, orgXX + 1, j);
        }

    }

    /**
     * Dibuja los ejes de la gráfica.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    void dibujaEjes(Graphics g) { //dibuja los ejes de la grafica
        g.setColor(Color.black);
        g.drawLine(orgX, 0, orgX, wAlto);
        g.drawLine(orgX, orgY, wAncho, orgY);
        g.drawString("t(s)", wAncho - g.getFontMetrics().stringWidth("t(s)"), orgY - 2);
        for (int j = 5; j < 20; j += 5) {
            int i = orgX + (int) ((double) j * escalaX);
            g.drawLine(i, orgY - 4, i, orgY + 4);
            i = (orgX + (int) ((double) j * escalaX)) - g.getFontMetrics().stringWidth(String.valueOf(j)) / 2;
            g.drawString(String.valueOf(j), i, orgY + cAlto);
            i = orgX + (int) (((double) j - 2.5D) * escalaX);
            g.drawLine(i, orgY - 2, i, orgY + 2);
        }

    }

    /**
     * Muestra los valores de tiempo, posición, velocidad y aceleración en el
     * canvas.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    void muestraValores(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(orgX + 3 * cAncho, 0, wAncho - orgX - 3 * cAncho, cAlto + cAlto / 2);
        g.setColor(Color.black);
        String s = "t: " + String.valueOf((double) Math.round(t * (double) 100) / (double) 100);
        g.drawString(s, orgX + 4 * cAncho, cAlto);
        s = "x: " + String.valueOf((double) Math.round(x * (double) 10) / (double) 10);
        g.drawString(s, (wAncho - orgX) / 4 + orgX + 4 * cAncho, cAlto);
        s = "v: " + String.valueOf((double) Math.round(v * (double) 10) / (double) 10);
        g.drawString(s, (wAncho - orgX) / 2 + orgX + 4 * cAncho, cAlto);
        s = "a: " + String.valueOf((double) Math.round(-G * 10/*100D*/) / (double) 10);
        g.drawString(s, (3 * (wAncho - orgX)) / 4 + orgX + 4 * cAncho, cAlto);
        g.setColor(Color.black);
        g.drawString("Vectores:", orgX + cAncho, wAlto - cAlto / 4);
        g.setColor(Color.yellow);
        g.fillRect(orgX + 9 * cAncho, wAlto - cAlto / 2, 2 * cAncho, cAlto / 4);
        g.setColor(Color.black);
        g.drawString("aceleraci\363n", orgX + 12 * cAncho, wAlto - cAlto / 4);
        g.setColor(Color.green);
        g.fillRect(orgX + 27 * cAncho, wAlto - cAlto / 2, 2 * cAncho, cAlto / 4);
        g.setColor(Color.black);
        g.drawString("velocidad", orgX + 30 * cAncho, wAlto - cAlto / 4);
    }

    @Override
    /**
     * Método sobrescrito para dibujar en el canvas.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    public void paint(Graphics g) {
        origenEscalas(g);
        dibujaEjes(g);
        dibujaEjeAnimacion(g);
        dibujaAmbiente(g);
        muestraValores(g);
    }

    /**
     * Dibuja el ambiente, incluyendo imágenes de edificio y pasto.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    public void dibujaAmbiente(Graphics g) {
        g.drawImage(this.edificio.getImage(), this.orgXX + 3, this.orgY - (int) (this.x0 * this.escalaY), this);
        g.drawImage(this.pasto.getImage(), orgXX + 3, orgY, this.orgX - 33, this.wAlto, this);

    }

    /**
     * Establece nuevos valores para las variables de posición inicial,
     * velocidad inicial y gravedad.
     *
     * @param d Nueva posición inicial.
     * @param d1 Nueva velocidad inicial.
     * @param d2 Nueva gravedad.
     */
    void setNuevo(double d, double d1, double d2) {
        x0 = d;
        v0 = d1;
        G = d2;
        t = 0.0D;
        pol.npoints = 0;
        repaint();
    }

    /**
     * Actualiza la posición y velocidad en cada paso de la animación.
     */
    void mover() {
        v = v0 - G/*10D*/ * t;
        x = (x0 + v0 * t) - (/*10D*/G * t * t) / (double) 2;
        int i = orgX + (int) (t * escalaX);
        y1 = orgY - (int) (x * escalaY);
        pol.addPoint(i, y1);
        repaint();
        if (y1 > orgY/*wAlto*/) {
            this.caidalibre.hilo.putMsg(0);
        }
        t += dt;
    }

    /**
     * Dibuja una flecha que representa la velocidad en el canvas.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    void flechaVelocidad(Graphics g) {
        int i = orgXX + 11 * cAncho;
        byte byte0 = ((byte) (v <= (double) 0 ? -1 : 1));
        int j = (int) ((v * (double) 4 * (double) cAlto) / (double) 100);
        Polygon polygon = new Polygon();
        polygon.addPoint(i + 2, y1);
        polygon.addPoint(i + 2, y1 - j);
        polygon.addPoint(i + 4, y1 - j);
        polygon.addPoint(i, y1 - j - 4 * byte0);
        polygon.addPoint(i - 4, y1 - j);
        polygon.addPoint(i - 2, y1 - j);
        polygon.addPoint(i - 2, y1);
        g.setColor(Color.green);
        g.fillPolygon(polygon);
    }

    /**
     * Dibuja una flecha que representa la aceleración en el canvas.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    void flechaAceleracion(Graphics g) {
        int i = orgXX + 8 * cAncho;
        byte byte0 = -1;
        int j = 2 * cAlto * byte0;
        Polygon polygon = new Polygon();
        polygon.addPoint(i + 2, y1);
        polygon.addPoint(i + 2, y1 - j);
        polygon.addPoint(i + 4, y1 - j);
        polygon.addPoint(i, y1 - j - 4 * byte0);
        polygon.addPoint(i - 4, y1 - j);
        polygon.addPoint(i - 2, y1 - j);
        polygon.addPoint(i - 2, y1);
        g.setColor(Color.yellow);
        g.fillPolygon(polygon);
    }

    @Override
    /**
     * Método sobrescrito para actualizar el canvas.
     *
     * @param g El objeto Graphics utilizado para dibujar en el canvas.
     */
    public void update(Graphics g) {
        Dimension dimension = getSize();
        if (gBuffer == null || dimension.width != dim.width || dimension.height != dim.height) {
            dim = dimension;
            imag = createImage(dimension.width, dimension.height);
            gBuffer = imag.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, dimension.width, dimension.height);
        gBuffer.setColor(Color.black);
        dibujaEjes(gBuffer);
        dibujaEjeAnimacion(gBuffer);
        dibujaAmbiente(gBuffer);
        muestraValores(gBuffer);
        gBuffer.fillOval(orgXX + 2 * cAncho, y1 - cAncho / 2, cAncho, cAncho);
        gBuffer.drawImage(this.imag2.getImage(), orgXX + 8 * cAncho, y1 - this.imag2.getIconHeight(), this);
        flechaVelocidad(gBuffer);
        flechaAceleracion(gBuffer);
        gBuffer.setColor(Color.black);
        gBuffer.drawPolyline(pol.xpoints, pol.ypoints, pol.npoints);
        g.drawImage(imag, 0, 0, null);
    }
}
