package com.empresa.proyecto.ws;

import javax.jws.WebParam;
import com.empresa.proyecto.bean.Datos;
import com.empresa.proyecto.operaciones.Operaciones;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "BDWS")
public class BDWS {
    Operaciones oper= new Operaciones();
    
    @WebMethod(operationName = "listar")
    public List<Datos> Listar() {
       List reg = oper.Listar();
       return reg;
    }
    
    @WebMethod(operationName = "listarID")
    public List<Datos> listarID(@WebParam(name = "id") int id) {
       List reg = oper.ListarID(id);
       return reg;
    }
    
    @WebMethod(operationName = "Agregar")
    public String Agregar(
            @WebParam(name = "id") int id,
            @WebParam(name = "User") String User,
            @WebParam(name = "Pass") String Pass,
            @WebParam(name = "Nombre") String Nombre,
            @WebParam(name = "Apellido_P") String Apellido_P,
            @WebParam(name = "Apellido_M") String Apellido_M,
            @WebParam(name = "Mail") String Mail        
    ){
        return oper.add(id, User, Pass, Nombre,Apellido_P, Apellido_M, Mail);
    }
}