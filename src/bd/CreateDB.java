/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import models.Arquivo;
import models.Cliente;
import models.Endereco;
import models.Processo;

/**
 *
 * @author Schettino
 */
public class CreateDB {

    private static Connection con;
    private static Statement comando;

    private static void conectar() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(ConFactory.MYSQL_DRIVER).newInstance();
//            String url = "jdbc:mysql://localhost/mysql";
            connection = DriverManager.getConnection(ConFactory.URL, ConFactory.USER, ConFactory.PASSWORD);

            statement = connection.createStatement();
            String hrappSQL = "CREATE DATABASE IF NOT EXISTS " + ConFactory.SCHEMA;
            statement.executeUpdate(hrappSQL);
        } catch (Exception e) {
            imprimeErro("Erro ao criar o banco.", e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    imprimeErro("Erro ao criar o banco.", e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    imprimeErro("Erro ao criar o banco.", e.getMessage());
                }
            }
        }
        try {
            con = ConFactory.conexao(ConFactory.URL_COMPLETA, ConFactory.USER, ConFactory.PASSWORD, ConFactory.MYSQL);
            comando = con.createStatement();
            System.out.println("Conectado!");
        } catch (ClassNotFoundException e) {
            imprimeErro("Erro ao carregar o driver", e.getMessage());
        } catch (SQLException e) {
            imprimeErro("Erro ao conectar", e.getMessage());
        }
    }

    private static void fechar() {
        try {
            comando.close();
            con.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            imprimeErro("Erro ao fechar conexão", e.getMessage());
        }
    }

    private static void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conectar();
        try {

            comando.executeUpdate(Query.createTable(Cliente.class));
            comando.executeUpdate(Query.createTable(Processo.class));
            comando.executeUpdate(Query.createTable(Endereco.class));
            comando.executeUpdate(Query.createTable(Arquivo.class));
        } catch (SQLException e) {
            imprimeErro("Erro ao criar tabelas.", e.getMessage());
        } finally {
            fechar();
        }
    }
}
