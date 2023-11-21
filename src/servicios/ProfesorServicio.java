
package servicios;

import entidades.Profesor;
import persistencia.ProfesorDAO;


public class ProfesorServicio{
    private final ProfesorDAO dao;
    
    public ProfesorServicio(){
        this.dao = new ProfesorDAO();
    }
    
    
        public void crearProfesor(String nombre, String apellido) throws Exception {
        try {
            
            if (!nombre.matches("^[A-Za-z][a-z]+")) {
                throw new Exception("Nombre invalido");
            }
            if (!apellido.matches("^[A-Za-z][a-z]+")) {
                throw new Exception("Apellido invalido");
            }
            

            Profesor profesor = new Profesor();
            profesor.setNombre(nombre);
            profesor.setApellido(apellido);
            dao.guardarProfesor(profesor);

        } catch (Exception e) {
            throw e;
        }
    }

    public Profesor BuscarProfesorPorApellido(String apellido) throws Exception {

        try {
            return dao.buscarProfesorPorApellido(apellido);

        } catch (Exception e) {
            throw e;
        }

    }
    
    public Profesor BuscaProfesorPorID(int id) throws Exception{
        try {
           return dao.buscarProfesorPorID(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProfesor(Profesor profesor) throws Exception {
        try {
            dao.eliminarProfesor(profesor);
        } catch (Exception e) {
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
