/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Alumno;
/**
 *
 * @author erik
 */
public class AlumnoDAO {
    
    ConexionJDBC conexion;
    
    public boolean agregarAlumno(Alumno alumno){
        boolean res = false;
        
        String sql = "INSERT INTO Alumnos VALUES('"+alumno.getNumControl()+"','"
                +alumno.getNombre()+"','"
                +alumno.getPrimerAp()+"','"
                +alumno.getSegundoAp()+"',"
                +alumno.getEdad()+","
                +alumno.getSemestre()+",'"
                +alumno.getCarrera()+"')";
        
        conexion = new ConexionJDBC();
        
        return conexion.ejecutarInstruccionSQL(sql);
    }
    
    public boolean eliminarAlumno(Alumno alumno){
         boolean res = false;
        
        String sql = "DELETE FROM Alumnos WHERE NumControl = "+"'"+alumno.getNumControl()+"'";
                /*+alumno.getNombre()+"','"
                +alumno.getPrimerAp()+"','"
                +alumno.getSegundoAp()+"',"
                +alumno.getEdad()+","
                +alumno.getSemestre()+",'"
                +alumno.getCarrera()+"')";*/
        
        conexion = new ConexionJDBC();
        
        return conexion.ejecutarInstruccionSQL(sql);
    }
    
    public boolean modificarAlumno(Alumno alumno){
        boolean res = false;
        
        String sql = "UPDATE Alumnos SET NumControl = "+"'"+alumno.getNumControl()+"'"+
                ",Nombre = "+"'"+alumno.getNombre()+"'"+
                ",PrimerAp = "+"'"+alumno.getPrimerAp()+"'"+
                ",SegundoAp = "+"'"+alumno.getSegundoAp()+"'"+
                ",Edad = "+alumno.getEdad()+
                ",Semestre = "+alumno.getSemestre()+
                ",Carrera = "+"'"+alumno.getCarrera()+"'"+
                "WHERE NumControl = "+"'"+alumno.getNumControl()+"'";
        
        conexion = new ConexionJDBC();
        
        return conexion.ejecutarInstruccionSQL(sql);
    }
    
    public boolean buscarAlumno(String alumno){
        return false;
    }
    
}
