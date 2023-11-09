/**
 * Propósito: En esta clase se implementa la interfaz ActionListener para manejar eventos de acción.
 *
 * Autores:
 * - Angie Natalia Cobo Vásquez
 * - Juan Diego Rodríguez Ortiz
 * - Sebastián Henao Gamboa
 * - Santiago Ospina González
 *
 * Versión: 2.0
 * Fecha última actualización: 9/10/2023
 * Versión JDK: 12
 */
package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Accion implements ActionListener {

    Ventana applet;

    /**
     * Constructor que recibe una instancia de Ventana y la asigna a la variable
     * de instancia applet.
     *
     * @param caidaLibre La instancia de Ventana a asociar con la acción.
     */
    public Accion(Ventana caidaLibre) {
        applet = caidaLibre;
    }

    /**
     * Método actionPerformed, implementado de la interfaz ActionListener, se
     * ejecuta cuando se produce un evento de acción.
     *
     * @param actionevent El evento de acción que desencadena la llamada a este
     * método.
     */
    public void actionPerformed(ActionEvent actionevent) {
        String s = actionevent.getActionCommand();
        if (s.equals("Empieza")) {
            applet.btnEmpieza_actionPerformed(actionevent);
        } else if (s.equals("Paso")) {

        } else {
        }
    }

}
