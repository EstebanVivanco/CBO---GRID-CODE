package bd;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection; // heredar desde aca y crear una estructura correcta de conexion
import java.sql.Statement; // Clase para enviar consultas SQL (Query)
import java.sql.ResultSet; // Clase para obtener los datos o resultados de
                           // un select
import java.sql.SQLException; // Para manejar excepciones de SQL

public class Conexion {
    private Connection con;
    public Statement sen;
    public ResultSet rs;
    
    public Conexion(String server, String bd, String user, String pass) throws SQLException{
        MysqlDataSource mysql = new MysqlDataSource();
        
        mysql.setServerName(server);
        mysql.setDatabaseName(bd);
        mysql.setUser(user);
        mysql.setPassword(pass);
        
        con = mysql.getConnection();
    }
    
    /**
    
    @param sql - Puede ser un Delete, Update o Insert 
     * @throws java.sql.SQLException 
    */
    public void ejecutar(String sql) throws SQLException{
        sen = con.createStatement();
        sen.executeUpdate(sql);
        sen.close();
    }
    
    /**
    
    @param select consulta select
    @return un objeto del Tipo ResultSet
    @throws SQLException 
    */
    public ResultSet ejecutarSelect(String select) throws SQLException{
        sen = con.createStatement();
        rs = sen.executeQuery(select);
        return rs;
    }
}

