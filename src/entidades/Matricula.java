
package entidades;

import java.time.LocalDate;

public class Matricula {
    
    
    private Alumno alumno;
    private Asignatura asignatura;
    private LocalDate fecha;


    public Matricula() {
    }

    public Matricula(Alumno alumno, Asignatura asignatura, LocalDate fecha) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fecha = fecha;
    }

    public Alumno getalumno() {
        return alumno;
    }

    public void setalumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getasignatura() {
        return asignatura;
    }

    public void setasignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "matricula{" + "id_alumno=" + alumno.getId() + ", id_asignatura=" + asignatura.getNombre() + ", fecha=" + fecha  + '}';
    }
    
    
}
