

package Menu;

/**
 * La clase Hilo extiende la clase Thread y se utiliza para controlar el hilo de
 * ejecución en la aplicación.
 */
public class Hilo extends Thread {

    /**
     * Constructor de la clase Hilo.
     *
     * @param caidalibre La instancia de Ventana asociada al hilo.
     */
    public Hilo(Ventana caidalibre) {
        msg = 0;
        pause = true;
        parent = caidalibre;
    }

    /**
     * Método run, que se ejecuta cuando se inicia el hilo.
     */
    public void run() {
        long l = System.currentTimeMillis();
        do {
            int i = getMsg();
            parent.canvas.mover();
            if (i == 1) {
                pause = true;
            }
            try {//detencion del hilo durante cierto tiempo
                Thread.sleep(Math.max(20L, l - System.currentTimeMillis()));
            } catch (InterruptedException interruptedexception) {
                return;
            }
        } while (true);
    }

    /**
     * Método sincronizado que obtiene el mensaje del hilo.
     *
     * @return El mensaje actual del hilo.
     */
    public synchronized int getMsg() {
        while (pause) {
            try {
                wait(1000L);
            } catch (InterruptedException interruptedexception) {
            }
        }
        return msg;
    }

    /**
     * Método sincronizado que establece el mensaje del hilo y actualiza la
     * bandera de pausa.
     *
     * @param i El nuevo mensaje del hilo.
     */
    public synchronized void putMsg(int i) {
        msg = i;
        pause = msg != 2 ? msg != 1 : false;
        notify();
    }

    Ventana parent;
    public static final int PAUSE = 0;
    public static final int STEP = 1;
    public static final int RUN = 2;
    int msg;
    boolean pause;
}
