
package bd;

import MODEL.Cliente;
import java.sql.SQLException;// import para manejar excepciones SQL
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DAOClientes {

    private Conexion oConexion;//se crea sin inicializar el objeto como atributo de la Clase DAO
    private String sql;// se crea una variable String para almacenar la consulta temporalmente
    /*
     constructor de DAO
     Genera la conexion entregando los datos
     */
    public DAOClientes() throws SQLException {
        oConexion = new Conexion( //se inicializa el objeto conexion
                "localhost",//se entrega servidor
                "facturacion",//nombre de la base de datos       
                "root",//usuario
                ""//contraseña
        );
        
    }

    
    
    
 public  void crearCliente(Cliente oCliente) throws SQLException{
        
       sql="INSERT INTO clientes VALUES (null, '"+oCliente.getNombre()+"')";
       oConexion.ejecutar(sql);
       System.out.println(sql);     
       
  }
 
  public  void updateCliente(Cliente oCliente) throws SQLException{
        
       sql=" UPDATE clientes SET nombre = '"+oCliente.getNombre()+"' ";
       oConexion.ejecutar(sql);
       System.out.println(sql);     
       
  }
  
  
  public  void deleteCliente(Cliente oCliente) throws SQLException{
        
       sql=" DELETE FROM clientes WHERE ID = '"+oCliente.getId()+"' ";
       oConexion.ejecutar(sql);
       System.out.println(sql);     
       
  }
  
    public DefaultComboBoxModel llenar_combobox() throws SQLException{
  
    sql="SELECT ID FROM clientes";
    oConexion.ejecutarSelect(sql);
    System.out.println(sql);
      
    DefaultComboBoxModel cbo_modelo = new DefaultComboBoxModel();
    cbo_modelo.addElement("Selecciona el ID: ");
    
    try {
            while (oConexion.rs.next()) {
                cbo_modelo.addElement(oConexion.rs.getInt("id"));
            }
            oConexion.rs.close();
    } catch (SQLException e) {
          System.out.println(e);
    }
    
    return cbo_modelo;
  
  
  
  }
 
    public DefaultTableModel ShowClientes() throws SQLException{
  
    sql="SELECT * FROM Clientes";
    oConexion.ejecutarSelect(sql);
    System.out.println(sql);
       
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"ID","Nombre"});
    try {
        while (oConexion.rs.next()) {
        modelo.addRow(new Object[]{oConexion.rs.getString("ID"),oConexion.rs.getString("nombre")});
        }
        return modelo;
    } catch (SQLException e) {
        System.out.println(e);
    }
        return null;
  
  
  }
    
    
    public void sett_cliente(Cliente oCliente) throws SQLException{
  
    sql="SELECT nombre FROM clientes WHERE id='"+oCliente.getId()+"' ";
    oConexion.ejecutarSelect(sql);
    
    while (oConexion.rs.next()) {
         oCliente.setNombre(oConexion.rs.getString("Nombre"));
         
    }
    
  
  }

    
    
    
 
}
