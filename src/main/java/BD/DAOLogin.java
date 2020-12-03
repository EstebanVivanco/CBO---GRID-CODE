
package bd;

import MODEL.User;
import java.sql.SQLException;// import para manejar excepciones SQL


public class DAOLogin {

    private Conexion oConexion;//se crea sin inicializar el objeto como atributo de la Clase DAO
    private String sql;// se crea una variable String para almacenar la consulta temporalmente
    /*
     constructor de DAO
     Genera la conexion entregando los datos
     */
    public DAOLogin() throws SQLException {
        oConexion = new Conexion( //se inicializa el objeto conexion
                "localhost",//se entrega servidor
                "facturacion",//nombre de la base de datos       
                "root",//usuario
                ""//contraseña
        );
        
    }

 
    
    
 
}
