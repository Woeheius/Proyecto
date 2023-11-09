/**
 * Propósito:Clase en la cual se creara el modelo de la tabla
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

import javax.swing.table.DefaultTableModel;
/**
 * Clase personalizada que extiende DefaultTableModel para controlar el comportamiento de una tabla.
 */
public class ModeloTabla extends DefaultTableModel {
    /**
     * Constructor de la clase ModeloTabla.
     * Crea una instancia de ModeloTabla con los datos y encabezados especificados.
     *
     * @param datos      Los datos de la tabla en forma de matriz bidimensional.
     * @param encazados
     */
    public ModeloTabla(Object datos[][], Object encazados[]) {
        super(datos, encazados);
    }
    /**
     * Determina si una celda de la tabla es editable o no.
     * En este caso, se establece que todas las celdas no son editables.
     *
     * @param row    El índice de la fila.
     * @param column El índice de la columna.
     * @return false para indicar que la celda no es editable.
     */
    public boolean isCellEditable(int row, int column) {

        return false;
    }
    /**
     * Ordena los datos de la tabla en función de los puntajes en orden descendente.
     * Esto permite ordenar la tabla por puntajes de mayor a menor.
     */
    public void sortPuntajes() {
        java.util.Vector<java.util.Vector> data = getDataVector();
        data.sort((row1, row2) -> {
            Integer puntaje1 = Integer.parseInt((String) row1.get(3));
            Integer puntaje2 = Integer.parseInt((String) row2.get(3));
            return puntaje2.compareTo(puntaje1);
        });
        fireTableDataChanged();
    }
}
