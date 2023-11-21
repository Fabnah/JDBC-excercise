
package servicios;

import entidades.Asignatura;
import entidades.Profesor;
import persistencia.AsignaturaDAO;


public class AsignaturaServicio {
    
    private final AsignaturaDAO dao;
    
    public AsignaturaServicio(){
        this.dao = new AsignaturaDAO();
    }
    
    
    public void agregarAsignatura(String nombre, Profesor profesor) throws Exception{
        try {

            if (!nombre.matches("^[A-Za-z][a-z]+")) {
                throw new Exception("nombre invalido");
            }
            
            Asignatura asignatura = new Asignatura();
            asignatura.setNombre(nombre);
            asignatura.setId_profesor(profesor);
            dao.crearAsignatura(asignatura);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProfesorDeAsignatura(Asignatura asignatura, Profesor profesor) throws Exception{
        try {
            dao.modificarAsignatura(asignatura, profesor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Asignatura buscarAsignaturaPorProfesor(Profesor profesor) throws Exception{
        try {
           return dao.buscarAsignaturaPorProfesor(profesor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Asignatura buscarAsignaturaPorID(int id) throws Exception{
        try {
            return dao.buscarAsignaturaPorID(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void borrarAsignatura(Asignatura asignatura) throws Exception{
        try {
            dao.eliminarAsignatura(asignatura);
        } catch (Exception e) {
        }
    }
}
