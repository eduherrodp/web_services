package com.empresa.proyecto.service;

import com.empresa.proyecto.bean.Alumnos;
import java.util.ArrayList;
import java.util.List;

public class AlumnoService {
    
    List<Alumnos> ListaAlumnos = new ArrayList<>();
    
    public AlumnoService() {}
    
    public String crearAlumno(String nombreAlumno, int Edad, String gradoEscolar){
        Alumnos a = new Alumnos();
        a.setIdAlumnos(ListaAlumnos.size() +1);
        a.setNombreAlumno(nombreAlumno);
        a.setEdad(Edad);
        a.setGradoEscolar(gradoEscolar);
        
        ListaAlumnos.add(a);
        return "Se Agrego el Alumno " + a.getNombreAlumno();
    }
   
    public List<Alumnos> listarAlumnos(){
        return ListaAlumnos;
    }    
     
    public String eliminarAlumnos(int id) {
        String msg = "";
        Alumnos a;
        
            for (int i=0; 1 < ListaAlumnos.size(); i++) {
                a = ListaAlumnos.get(i);
                if (a.getIdAlumnos()==id) {
                    msg = "Se elimino el Alumno con el Id = " + id;
                    ListaAlumnos.remove(i);
                    break;
                }
                else {
                     msg= "El ID no existe ";
                }
            }
      return msg;
    }
    
    public String modificarAlumno(int id, String nombreAlumno, int Edad, String gradoEscolar) {
        String msg = "";
        Alumnos a = new Alumnos();
        Alumnos b;
        
        a.setIdAlumnos(id);
        a.setNombreAlumno(nombreAlumno);
        a.setEdad(Edad);
        a.setGradoEscolar(gradoEscolar);
        
        for (int i=0; 1 < ListaAlumnos.size(); i++) {
            b = ListaAlumnos.get(i);
            if (b.getIdAlumnos() == id){
                msg = "Se modifico el Alumno con el ID = " + id;
                ListaAlumnos.set(i, a);
                break;
            }
            else{
                msg = "El ID no existe ";
            }
        }
        return msg;
    }
}