
package bd;

import MODEL.Cliente;
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

 
     public  boolean Login(User oUser) throws SQLException{
        
       sql="SELECT * FROM LOGIN WHERE pass = '"+oUser.getPass()+"' and usuario = '"+oUser.getUser()+"'";
       oConexion.ejecutarSelect(sql);
       System.out.println(sql);     
       
         if (oConexion.rs.next()) {
             return true;
         }else{
             return false;
         }
       
  }
    
 
}
