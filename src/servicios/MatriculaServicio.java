
package servicios;

import entidades.Alumno;
import entidades.Asignatura;
import entidades.Matricula;
import java.time.LocalDate;
import persistencia.MatriculaDAO;


public class MatriculaServicio {
    private final MatriculaDAO dao;
    
    public MatriculaServicio(){
        this.dao = new MatriculaDAO();
    }
    
    public void agregarMatricula(Alumno alumno, Asignatura asignatura, LocalDate fecha) throws Exception{
        try {

            
            Matricula matricula = new Matricula();
            matricula.setalumno(alumno);
            matricula.setasignatura(asignatura);
            matricula.setFecha(fecha);
            dao.agregarMatricula(matricula);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Matricula buscarMatriculaPorAlumno(Alumno alumno) throws Exception{
        try {
           return dao.buscarMatriculaPorAlumno(alumno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void borrarMatricula(Matricula matricula) throws Exception{
        try {
            dao.eliminarMatricula(matricula);
        } catch (Exception e) {
        }
    }
    
    
}
