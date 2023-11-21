package servicios;

import entidades.Alumno;
import java.time.LocalDate;
import persistencia.AlumnoDAO;

public class AlumnoServicio {

    private final AlumnoDAO dao;

    public AlumnoServicio() {
        this.dao = new AlumnoDAO();
    }

    public void crearAlumno(String nombre, String apellido, LocalDate fecha_nacimiento, int dni) throws Exception {
        try {

            if (!nombre.matches("^[A-Za-z][a-z]+")) {
                throw new Exception("Nombre invalido");
            }
            if (!apellido.matches("^[A-Za-z][a-z]+")) {
                throw new Exception("Apellido invalido");
            }
            if (BuscarAlumnoPorDni(dni) != null) {
                throw new Exception("Ya existe un alumno con el dni " + dni);
            }
            if (dni<10000000 || dni>99999999) {
                throw new Exception("El numero dni no es valido");
            }

            Alumno alumno = new Alumno();
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.setNacimiento(fecha_nacimiento);
            alumno.setDni(dni);
            dao.guardarAlumno(alumno);

        } catch (Exception e) {
            throw e;
        }
    }

    public Alumno BuscarAlumnoPorDni(int dni) throws Exception {

        try {
            return dao.buscarAlumnoPorDni(dni);

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarAlumno(Alumno alumno) throws Exception {
        try {
            dao.eliminarAlumno(alumno);
        } catch (Exception e) {
        }
    }

}
