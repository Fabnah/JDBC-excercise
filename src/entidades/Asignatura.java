
package entidades;


public class Asignatura {
    
    
    private int id_asignatura;
    private String nombre;
    private Profesor profesor;

    public Asignatura() {
    }

    public Asignatura(int id_asignatura, String nombre, Profesor profesor) {
        this.id_asignatura = id_asignatura;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getprofesor() {
        return profesor;
    }

    public void setId_profesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "asignatura{" + "id_asignatura=" + id_asignatura + ", nombre=" + nombre + ", id_profesor=" + profesor.getId() + '}';
    }
    
    
}
