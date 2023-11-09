/**
 * Propósito:Clase en la cual se realizá el cálculo de la derivada de la función ingresada por el usuario.
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

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 * Clase que representa la ventana de "Derivadas".
 */
public class Derivadas {

    private String funcion = "";
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;

    /**
     * Constructor de la clase Derivadas.
     */
    public Derivadas() {

    }

    /**
     * Establece la función a derivar.
     *
     * @param funcion La función matemática en formato de cadena.
     */
    public void setFuncionADerivar(String funcion) {
        this.funcion = funcion;
    }

    /**
     * Obtiene la función que se va a derivar.
     *
     * @return La función matemática en formato de cadena.
     */
    public String getFuncionDerivada() {
        return this.funcion;
    }

    /**
     * Realiza el cálculo de la derivada de la función con respecto a la
     * variable 'x'.
     */
    public void derivar() {
        try {
            this.djep = new DJep();
            this.djep.addStandardFunctions();
            this.djep.addStandardConstants();
            this.djep.addComplex();
            this.djep.setAllowUndeclared(true);
            this.djep.setAllowAssignment(true);
            this.djep.setImplicitMul(true);
            this.djep.addStandardDiffRules();
            this.nodoFuncion = this.djep.parse(this.funcion);
            Node diff = this.djep.differentiate(nodoFuncion, "x");
            this.nodoDerivada = this.djep.simplify(diff);
            this.funcion = this.djep.toString(this.nodoDerivada);
        } catch (ParseException e) {
            System.out.println("Error" + e.getErrorInfo());
        }
    }
}
