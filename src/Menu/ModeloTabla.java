/*
Proposito:
Clase en la cual se creara el modelo de la tabla
Autores:
Angie Natalia Cobo Vasquez
Juan Diego Rodriguez Ortiz
Sebastian Henao Gamboa
Santiago Ospina Gonzalez

Version:
2.0
Fecha ultima actualizacion:
08/11/2023 
Version JDK:
 */
package Menu;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

    public ModeloTabla(Object datos[][], Object encazados[]) {
        super(datos, encazados);
    }

    public boolean isCellEditable(int row, int column) {

        return false;
    }

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
