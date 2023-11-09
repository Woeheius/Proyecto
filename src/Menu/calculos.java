/**
 * Propósito:Clase donde se hacen los calculos para los datos de tiro parabolico
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

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * La clase calculos proporciona métodos para realizar cálculos relacionados con la física de un proyectil en movimiento.
 */
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
        /**
     * Calcula la altura final de un proyectil en movimiento.
     * @param altura El ángulo de tiro en radianes.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return La altura final en metros.
     */
    public float calcularaltura(float altura, float enterrr, float time1){
  
      float alturafinal = (float) ((float) pow(enterrr,2)*pow(sin(altura),2)/(2*9.81));
     
      return alturafinal;
    }
        /**
     * Calcula el alcance final de un proyectil en movimiento.
     * @param altura El ángulo de tiro en radianes.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return El alcance final en metros.
     */
    public float calcularalcance(float altura, float enterrr, float time1){
  
      float alcancefinal = (float) (pow(enterrr,2)*sin(2*altura)/9.81);
     
      return alcancefinal;
    }
        /**
     * Calcula la posición en el eje X de un proyectil en movimiento.
     * @param altura El ángulo de tiro en radianes.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return La posición en el eje X en metros.
     */
    public float calcularposicionx(float altura, float enterrr, float time1){
  
      float posicionxfinal = (float) ((enterrr) * cos(altura)*(time1));
     
      return posicionxfinal;
    }
       /**
     * Calcula la posición en el eje Y de un proyectil en movimiento.
     * @param altura El ángulo de tiro en radianes.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return La posición en el eje Y en metros.
     */
     public float calcularposiciony(float altura, float enterrr, float time1){
  
      float posicionyfinal = (float) ((enterrr) * sin(altura)*(time1)-((9.81)*(pow(time1,2))/2));
     
      return posicionyfinal;
    }
        /**
     * Calcula la altura final de un proyectil en movimiento utilizando ángulos en grados.
     * @param altura El ángulo de tiro en grados.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return La altura final en metros.
     */
     public float calcularaltgrados(float altura, float enterrr, float time1){
         
     float alturagra = (float) ((float) pow(enterrr,2)*pow(sin(Math.toRadians(altura)),2)/(2*9.81));
     
      return alturagra;
    }
        /**
     * Calcula el alcance final de un proyectil en movimiento utilizando ángulos en grados.
     * @param altura El ángulo de tiro en grados.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return El alcance final en metros.
     */
     public float calcularalcgrados(float altura, float enterrr, float time1){
  
      float alcancegra = (float) (pow(enterrr,2)*sin(2*Math.toRadians(altura))/9.81);
     
      return alcancegra;
    }
         /**
     * Calcula la posición en el eje X de un proyectil en movimiento utilizando ángulos en grados.
     * @param altura El ángulo de tiro en grados.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return La posición en el eje X en metros.
     */
     public float calcularposixgra(float altura, float enterrr, float time1){
  
      float posicionxgra = (float) ((enterrr) * cos(Math.toRadians(altura))*(time1));
     
      return posicionxgra;
    }
         /**
     * Calcula la posición en el eje Y de un proyectil en movimiento utilizando ángulos en grados.
     * @param altura El ángulo de tiro en grados.
     * @param enterrr La velocidad inicial del proyectil.
     * @param time1 El tiempo en segundos.
     * @return La posición en el eje Y en metros.
     */
      public float calcularposiygra(float altura, float enterrr, float time1){
  
      float posicionygra = (float) ((enterrr) * sin(Math.toRadians(altura))*(time1)-((9.81)*(pow(time1,2))/2));
     
      return posicionygra;
    }
}
