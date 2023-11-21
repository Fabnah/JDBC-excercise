
package persistencia;

import entidades.Alumno;
import entidades.Asignatura;
import entidades.Matricula;
import java.time.LocalDate;


public class MatriculaDAO extends DAO{

    private final AlumnoDAO daoAlumno;
    private final AsignaturaDAO daoAsignatura;
    
    public MatriculaDAO(){
        this.daoAlumno = new AlumnoDAO();
        this.daoAsignatura = new AsignaturaDAO();
    }
    
    
    public void agregarMatricula(Matricula matricula) throws Exception{
        try {
            if (matricula == null) {
                throw new Exception("Debe indicar una matricula");
            }
            String sql = "insert into matriculas (alumno, asignatura, fecha) values ('" + matricula.getalumno().getId() + "' , '" + matricula.getasignatura().getId_asignatura() + "' , '" + matricula.getFecha() + "');";
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Matricula buscarMatriculaPorAlumno(Alumno alumno) throws Exception{
        try {
            
            String sql = "select * from matriculas where alumno = " + alumno.getId();
            consultarBase(sql);
            
            Matricula matric = new Matricula();
            while (resultado.next()) {
            Integer idAlumno = resultado.getInt(1);
            Alumno alum = daoAlumno.buscarAlumnoPorID(idAlumno);
            matric.setalumno(alum);
            Integer idAsign = resultado.getInt(2);
            Asignatura asig = daoAsignatura.buscarAsignaturaPorID(idAsign);
            matric.setasignatura(asig);
            java.sql.Date fechaSQL = resultado.getDate(3);
            LocalDate localDateFecha = fechaSQL.toLocalDate();
            matric.setFecha(localDateFecha);
            }
            desconectarBase();
            return matric;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarMatricula(Matricula matricula) throws Exception{
        try {
            String sql = "delete from matriculas where alumno = " + matricula.getalumno().getId() + " and asignatura = " + matricula.getasignatura().getId_asignatura();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
