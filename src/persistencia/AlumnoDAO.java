package persistencia;

import entidades.Alumno;
import java.time.LocalDate;

public final class AlumnoDAO extends DAO {

    public void guardarAlumno(Alumno alumno) throws Exception {

        try {

            if (alumno == null) {
                throw new Exception("Debe indicar un alumno");
            }

            String sql = "INSERT INTO alumnos (nombre, apellido, fecha_nacimiento, DNI)"
                    + "VALUES ( '" + alumno.getNombre() + "' , '" + alumno.getApellido() + "' , '" + alumno.getNacimiento() + "' , '" + alumno.getDni() + "' );";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAlumno(Alumno alumno) throws Exception {
        try {
            if (alumno == null) {
                throw new Exception("Debe indicar el alumno que desea modificar");
            }

            String sql = "UPDATE alumnos SET "
                    + "nombre = '" + alumno.getNombre() + "' WHERE DNI = '" + alumno.getDni();

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarAlumno(Alumno alumno) throws Exception {
        try {

            String sql = "DELETE FROM alumnos WHERE DNI = " + alumno.getDni() + " LIMIT 1;";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public Alumno buscarAlumnoPorDni(int dni) throws Exception {
        try {

            String sql = "SELECT * FROM alumnos WHERE DNI = '" + dni + "'";
            consultarBase(sql);

            Alumno alumno = null;
            while (resultado.next()) {
                alumno = new Alumno();
                alumno.setId(resultado.getInt(1));
                alumno.setNombre(resultado.getString(2));
                alumno.setApellido(resultado.getString(3));
                // Obtener el valor de la columna 4 como java.sql.Date para luego usar el formato LocalDate
                java.sql.Date fechaSQL = resultado.getDate(4);

                // Convertir java.sql.Date a LocalDate
                LocalDate fechaLocalDate = fechaSQL.toLocalDate();

                alumno.setNacimiento(fechaLocalDate);
                alumno.setDni(resultado.getInt(5));
            }
            desconectarBase();
            return alumno;

        } catch (Exception e) {

            desconectarBase();
            throw e;

        }
    }
    
    public Alumno buscarAlumnoPorID(int id) throws Exception {
        try {

            String sql = "SELECT * FROM alumnos WHERE id_alumno = '" + id + "'";
            consultarBase(sql);

            Alumno alumno = null;
            while (resultado.next()) {
                alumno = new Alumno();
                alumno.setId(resultado.getInt(1));
                alumno.setNombre(resultado.getString(2));
                alumno.setApellido(resultado.getString(3));
                // Obtener el valor de la columna 4 como java.sql.Date para luego usar el formato LocalDate
                java.sql.Date fechaSQL = resultado.getDate(4);

                // Convertir java.sql.Date a LocalDate
                LocalDate fechaLocalDate = fechaSQL.toLocalDate();

                alumno.setNacimiento(fechaLocalDate);
                alumno.setDni(resultado.getInt(5));
            }
            desconectarBase();
            return alumno;

        } catch (Exception e) {

            desconectarBase();
            throw e;

        }
    }
}
