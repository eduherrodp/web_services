package ws;

import com.empresa.examen.db_pkg.ProductoDAO;
import com.empresa.examen.db_pkg.Producto;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public class db_ws {
    @WebMethod
    public String obtenerProductoPorId(@WebParam(name="id") int id) throws SQLException, ClassNotFoundException {
        Producto producto = ProductoDAO.getById(id);
        StringBuilder sb = new StringBuilder();
        sb.append("\n{");
        sb.append(producto.getId()).append(" |");
        sb.append(producto.getNombre()).append(" |");
        sb.append(producto.getPrecio()).append(" |");
        sb.append(producto.getFabricante()).append(" }");
        
        return sb.toString();
    }
    
    
    @WebMethod
    public String obtenerTodosLosProductos() throws SQLException, ClassNotFoundException {
        List<Producto> productos = ProductoDAO.getAll();
        StringBuilder sb = new StringBuilder();
        for (Producto producto : productos) {
            sb.append("\n{");
            sb.append(producto.getId()).append("| ");
            sb.append(producto.getNombre()).append("| ");
            sb.append(producto.getPrecio()).append("| ");
            sb.append(producto.getFabricante());
            sb.append("}\n");
        }
        return sb.toString();
    }
}
