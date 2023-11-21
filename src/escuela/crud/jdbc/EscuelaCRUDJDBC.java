package escuela.crud.jdbc;

import entidades.Alumno;
import entidades.Asignatura;
import entidades.Matricula;
import entidades.Profesor;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import servicios.AlumnoServicio;
import servicios.AsignaturaServicio;
import servicios.MatriculaServicio;
import servicios.ProfesorServicio;

public class EscuelaCRUDJDBC {

    public static void main(String[] args) throws ParseException, Exception {

        // I call the entities services
        AlumnoServicio as = new AlumnoServicio();
        ProfesorServicio ps = new ProfesorServicio();
        AsignaturaServicio ass = new AsignaturaServicio();
        MatriculaServicio ms = new MatriculaServicio();

        int dia = 20;
        int mes = 9;
        int anio = 2023;
        LocalDate fechaDate = LocalDate.of(anio, mes, dia);

        /*
        // --STUDENTS--
        
        // create a student
        as.crearAlumno("Pablo", "Aimar", fechaDate, 31564584);

        // search a student
        Alumno alum = as.BuscarAlumnoPorDni(31564584);
        System.out.println(alum);
        
        // delete a student
        as.eliminarAlumno(alum);
         */
 /*
        // --TEACHERS--
        
        // create a teacher
        ps.crearProfesor("Lionel", "Escaloni");
        ps.crearProfesor("Jorge", "Grondona");
        ps.crearProfesor("Cristiano", "Ronaldo");
        ps.crearProfesor("Carlos", "Bianchi");
        
        // search a teacher
        Profesor profe = ps.BuscaProfesorPorID(1);
        System.out.println(profe);
        
        Profesor profe2 = ps.BuscarProfesorPorApellido("Grondona");
        System.out.println(profe2);
        
        // delete a teacher
        ps.eliminarProfesor(profe2);
         */
 
         /*
        // --SUBJECTS--
        
        // create a subject
        
        Profesor profeAsignatura = ps.BuscaProfesorPorID(1);
        //ass.agregarAsignatura("literatura", profeAsignatura);

        
        // search a subject
        Asignatura asig = ass.buscarAsignaturaPorID(2);
        System.out.println(asig);
        
        Asignatura asig2 = ass.buscarAsignaturaPorProfesor(profeAsignatura);
        System.out.println(asig2);
        
        // change the subject's teacher (now the teacher of the subject ID=2 is teacher ID=1)
        ass.modificarProfesorDeAsignatura(asig, profeAsignatura);
        
        // delete subject
        ass.borrarAsignatura(asig2);
        */
         
         /*
         // --TUITION--
         
         // create tuition
         Alumno alum = as.BuscarAlumnoPorDni(31564584);
         Asignatura asig = ass.buscarAsignaturaPorID(1);
         //ms.agregarMatricula(alum, asig, fechaDate);
         
         // search tuition 
         Matricula matri = ms.buscarMatriculaPorAlumno(alum);
         System.out.println(matri);
         
         // delete tuition
         ms.borrarMatricula(matri);
        */
    }
}
