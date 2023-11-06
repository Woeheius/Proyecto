
package Menu;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;


public class calculos {
    
    int velocidad, angulo, tiempo;

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        
        this.velocidad = velocidad;
    }
    

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        
        this.angulo = angulo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public float calcularaltura(float altura, float enterrr, float time1){
  
      float alturafinal = (float) ((float) pow(enterrr,2)*pow(sin(altura),2)/(2*9.81));
     
      return alturafinal;
    }
    
    public float calcularalcance(float altura, float enterrr, float time1){
  
      float alcancefinal = (float) (pow(enterrr,2)*sin(2*altura)/9.81);
     
      return alcancefinal;
    }
    
    public float calcularposicionx(float altura, float enterrr, float time1){
  
      float posicionxfinal = (float) ((enterrr) * cos(altura)*(time1));
     
      return posicionxfinal;
    }
   
     public float calcularposiciony(float altura, float enterrr, float time1){
  
      float posicionyfinal = (float) ((enterrr) * sin(altura)*(time1)-((9.81)*(pow(time1,2))/2));
     
      return posicionyfinal;
    }
    
     public float calcularaltgrados(float altura, float enterrr, float time1){
         
     float alturagra = (float) ((float) pow(enterrr,2)*pow(sin(Math.toRadians(altura)),2)/(2*9.81));
     
      return alturagra;
    }
    
     public float calcularalcgrados(float altura, float enterrr, float time1){
  
      float alcancegra = (float) (pow(enterrr,2)*sin(2*Math.toRadians(altura))/9.81);
     
      return alcancegra;
    }
     
     public float calcularposixgra(float altura, float enterrr, float time1){
  
      float posicionxgra = (float) ((enterrr) * cos(Math.toRadians(altura))*(time1));
     
      return posicionxgra;
    }
     
      public float calcularposiygra(float altura, float enterrr, float time1){
  
      float posicionygra = (float) ((enterrr) * sin(Math.toRadians(altura))*(time1)-((9.81)*(pow(time1,2))/2));
     
      return posicionygra;
    }
}
