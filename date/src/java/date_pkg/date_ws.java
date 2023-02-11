/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package date_pkg;

import java.time.LocalDateTime;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eduhe
 */
@WebService(serviceName = "date_ws")
public class date_ws {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        LocalDateTime locaDate = LocalDateTime.now();
        int day = locaDate.getDayOfMonth();
        int month = locaDate.getMonthValue();
        int year = locaDate.getYear();
        return "Helloo " + txt + " ! " + "Fecha actual : " + day  + "/"+ month + "/" + year;
    }
}
