
package persistencia;

import entidades.Profesor;


public class ProfesorDAO extends DAO{
    
    public void guardarProfesor(Profesor profesor) throws Exception{
        try {
            if (profesor == null) {
                throw new Exception("Debe indicar un profesor");
            }
            
            String sql = "INSERT INTO profesores (id_profesor, nombre, apellido) VALUES ('" + profesor.getId() + "' , '" +profesor.getNombre() + "' , '" + profesor.getApellido() + "');";
            insertarModificarEliminar(sql);
            
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProfesor(Profesor profesor) throws Exception{
        try {
            if (profesor == null) {
                throw new Exception("Debe indicar el profesor que desea modificar");
            }

            String sql = "UPDATE profesores SET "
                    + "nombre = '" + profesor.getNombre() + "' WHERE id_profesor = '" + profesor.getId();

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }

    }  

    public void eliminarProfesor(Profesor profesor) throws Exception {
        try {

            String sql = "DELETE FROM profesores WHERE id_profesor = " + profesor.getId()+ " LIMIT 1;";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public Profesor buscarProfesorPorApellido(String apellido) throws Exception {
        try {

            String sql = "SELECT * FROM profesores WHERE apellido = '" + apellido + "'";
            consultarBase(sql);

            Profesor profesor = null;
            while (resultado.next()) {
                profesor = new Profesor();
                profesor.setId(resultado.getInt(1));
                profesor.setNombre(resultado.getString(2));
                profesor.setApellido(resultado.getString(3));
                
            }
            desconectarBase();
            return profesor;

        } catch (Exception e) {

            desconectarBase();
            throw e;

        }
    }
    
    public Profesor buscarProfesorPorID(int id) throws Exception {
        try {

            String sql = "SELECT * FROM profesores WHERE id_profesor = '" + id + "'";
            consultarBase(sql);

            Profesor profesor = null;
            while (resultado.next()) {
                profesor = new Profesor();
                profesor.setId(resultado.getInt(1));
                profesor.setNombre(resultado.getString(2));
                profesor.setApellido(resultado.getString(3));
                
            }
            desconectarBase();
            return profesor;

        } catch (Exception e) {

            desconectarBase();
            throw e;

        }
    }
}
