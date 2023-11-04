
package Menu;

import org.nfunk.jep.JEP;
//Evalua funciones sengun el x
//usada por la clase VentaGraficar
public class Evaluar {
    
     private String funcion = "";
    private double resultado = 0.0;
    private double valorX = 0.0;    
    private String error = "";
    
    JEP jep;
    
    
    public void setFuncion(String funcion){
        this.funcion = funcion;
    }
    
    public void setValorX(double valorX){
        this.valorX = valorX;
    }
    
    public double getResultadoFuncion(){
        return this.resultado;
    }
    
    public String getError(){
        return this.error;
    }
    
    
    public void evaluar(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError())? "Existe un error.":"No hay error.";
    }
    
}
