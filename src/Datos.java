//Encapsulamiento y metodos accesores (getters y setters)
public class Datos {
    private String nombre, apellido, genero;
    private int edad;

    public Datos (String nombre, String apellido, String genero, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getGenero(){
        return genero;
    }

    public int getEdad(){
        return edad;
    }
}