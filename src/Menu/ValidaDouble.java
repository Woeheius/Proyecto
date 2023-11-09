/**
 * Propósito: La clase ValidaDouble lleava a FocusAdapter y se utiliza para validar la
 * entrada en campos de texto asegurándose de que el valor introducido sea un
 * número double.
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

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.EventObject;
import javax.swing.JTextField;

class ValidaDouble extends FocusAdapter {

    /**
     * Constructor predeterminado de la clase ValidaDouble.
     */
    ValidaDouble() {
    }

    @Override
    /**
     * Método que se ejecuta cuando se pierde el foco en un campo de texto.
     * Verifica si el contenido del campo es un número double; si no lo es,
     * vuelve a colocar el foco en el campo y selecciona todo el texto para su
     * fácil edición.
     *
     * @param focusevent El evento de foco perdido.
     */
    public void focusLost(FocusEvent focusevent) {
        JTextField textfield = (JTextField) focusevent.getSource();
        try {
            Double.valueOf(textfield.getText()).doubleValue();
        } catch (NumberFormatException numberformatexception) {
            textfield.requestFocus();
            textfield.selectAll();
        }
    }
}
