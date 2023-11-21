
package entidades;

import java.time.LocalDate;

public class Alumno {
    
    private int id;
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private int dni;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido, LocalDate nacimiento, int dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.dni = dni;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

        public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    @Override
    public String toString() {
        return "alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nacimiento=" + nacimiento + ", dni=" + dni +'}';
    }
    
    
    
    
}
