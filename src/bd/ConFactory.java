/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

//Exemplo create table
//create table pessoa(  
//   id int not null auto_increment,  
//   nome varchar(20) not null,  
//   idade int(2) not null,   
//   cidade varchar(20) not null,  
//   estado varchar(2) not null,  
//   primary key(id)         
//);  

/**
 *
 * @author Schettino
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

    public static final String URL = "jdbc:mysql://localhost/";
    public static final String SCHEMA = "processos";
    public static final String URL_COMPLETA = URL + SCHEMA;
    
    public static final String USER = "root";
    public static final String PASSWORD = "tzzk7662";
    public static final int MYSQL = 0;
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    public static Connection conexao(String url, String nome, String senha,
            int banco) throws ClassNotFoundException, SQLException {
        switch (banco) {
            case MYSQL:
                Class.forName(MYSQL_DRIVER);
                break;
        }
        return DriverManager.getConnection(url, nome, senha);
    }
}
