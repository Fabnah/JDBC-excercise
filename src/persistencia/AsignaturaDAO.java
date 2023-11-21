package persistencia;

import entidades.Asignatura;
import entidades.Profesor;

public class AsignaturaDAO extends DAO {
    
    private final ProfesorDAO daoProfe;
    
    public AsignaturaDAO(){
        this.daoProfe = new ProfesorDAO();
    }

    public void crearAsignatura(Asignatura asignatura) throws Exception {
        try {

            if (asignatura == null) {
                throw new Exception("Debe asignar una asignatura");
            }

            String sql = "INSERT INTO asignaturas (id_asignatura, nombre, profesor) VALUES ('" + asignatura.getId_asignatura() + "' , '" + asignatura.getNombre() + "' , '" + asignatura.getprofesor().getId() + "');";
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAsignatura(Asignatura asignatura, Profesor profesor) throws Exception {
        try {
            if (asignatura == null) {
                throw new Exception("Debe elegir una asignatura");
            }
            String sql = "UPDATE asignaturas SET profesor = " + profesor.getId() + " WHERE id_asignatura = " + asignatura.getId_asignatura();

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Asignatura buscarAsignaturaPorProfesor(Profesor profesor)throws Exception{
        try {
            String sql = "select a.* from asignaturas a join profesores p on a.profesor=p.id_profesor where p.id_profesor=" + profesor.getId() +";";
            consultarBase(sql);
            
            Asignatura asignatura = null;
            while (resultado.next()) {
                asignatura = new Asignatura();
                asignatura.setId_asignatura(resultado.getInt(1));
                asignatura.setNombre(resultado.getString(2));
                //consigo el id del profesor encargado en la DB
                Integer idProfe = resultado.getInt(3);
                //en una variable de tipo profesor busco al mismo con la funcion buscarProfesor de ProfesorDAO
                Profesor profe = daoProfe.buscarProfesorPorID(idProfe);
                //y luego lo seteo
                asignatura.setId_profesor(profe);
            }
            desconectarBase();
            return asignatura;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Asignatura buscarAsignaturaPorID(int id_asignatura)throws Exception{
        try {
            String sql = "select * from asignaturas where id_asignatura = " + id_asignatura +";";
            consultarBase(sql);
            
            Asignatura asignatura = null;
            while (resultado.next()) {
                asignatura = new Asignatura();
                asignatura.setId_asignatura(resultado.getInt(1));
                asignatura.setNombre(resultado.getString(2));
                //consigo el id del profesor encargado en la DB
                Integer idProfe = resultado.getInt(3);
                //en una variable de tipo profesor busco al mismo con la funcion buscarProfesor de ProfesorDAO
                Profesor profe = daoProfe.buscarProfesorPorID(idProfe);
                //y luego lo seteo
                asignatura.setId_profesor(profe);
            }
            desconectarBase();
            return asignatura;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public void eliminarAsignatura(Asignatura asignatura) throws Exception{
        try {
            String sql = "DELETE FROM asignaturas WHERE id_asignatura = " + asignatura.getId_asignatura()+ " LIMIT 1;";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

}
