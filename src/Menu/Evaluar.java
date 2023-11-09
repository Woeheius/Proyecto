/**
 * Propósito:Clase en la cual se realiza para evaluar la función ingresada por el usuario en la graficadora.
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

import org.nfunk.jep.JEP;
//Evalua funciones sengun el x
//usada por la clase VentaGraficar

/**
 * Esta clase se utiliza para evaluar funciones matemáticas según un valor 'x'
 * proporcionado. Se basa en la librería JEP (Java Expression Parser) para
 * realizar las evaluaciones.
 */
public class Evaluar {

    private String funcion = "";
    private double resultado = 0.0;
    private double valorX = 0.0;
    private String error = "";

    JEP jep;

    /**
     * Establece la función matemática que se evaluará.
     *
     * @param funcion La función matemática a evaluar.
     */
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    /**
     * Establece el valor de 'x' que se utilizará en la evaluación de la
     * función.
     *
     * @param valorX El valor de 'x' a utilizar en la evaluación.
     */
    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    /**
     * Obtiene el resultado de la evaluación de la función.
     *
     * @return El resultado de la evaluación.
     */
    public double getResultadoFuncion() {
        return this.resultado;
    }

    /**
     * Obtiene información sobre cualquier error que ocurra durante la
     * evaluación.
     *
     * @return Un mensaje de error si ocurre un error, de lo contrario, un
     * mensaje indicando que no hay error.
     */
    public String getError() {
        return this.error;
    }

    /**
     * Realiza la evaluación de la función matemática con el valor de 'x'
     * proporcionado. Utiliza la librería JEP para realizar la evaluación.
     */
    public void evaluar() {
        jep = new JEP();

        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();

        this.error = (this.jep.hasError()) ? "Existe un error." : "No hay error.";
    }

}
