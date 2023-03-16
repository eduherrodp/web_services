package com.empresa.proyecto.ws;

import com.empresa.proyecto.bean.Alumnos;
import com.empresa.proyecto.service.AlumnoService;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "AlumnoWebService")
public class AlumnoWebService {
    AlumnoService alumnoService = new AlumnoService ();
    
    @WebMethod(operationName = "crearAlumno")
    public String crearAlumno (@WebParam(name = "nombreAlumno") String nombreAlumno, @WebParam (name = "Edad") int Edad, @WebParam( name= "gradoEscolar")String gradoEscolar){
       return alumnoService.crearAlumno (nombreAlumno, Edad, gradoEscolar);
    }
    @WebMethod(operationName = "listarAlumno")
        public List<Alumnos> listarAlumno(){
            return alumnoService.listarAlumnos();
    }
}