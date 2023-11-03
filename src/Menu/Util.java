package Menu;

public class Util {

    private String nombre;
    private String apellido;
    private String correo;
    private String codigo;
    private String carrera;

    public void guardar_datos(String nombre, String apellido, String correo, String codigo, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCarrera() {
        return carrera;
    }

}
