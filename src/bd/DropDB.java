/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


/**
 *
 * @author Schettino
 */
public class DropDB {

    private static Connection con;
    private static Statement comando;

    private static void conectar() {
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
            comando.executeUpdate(Query.dropSchema(ConFactory.SCHEMA));
            
//            comando.executeUpdate(Query.dropTable("arquivos"));
//            comando.executeUpdate(Query.dropTable("enderecos"));
//            comando.executeUpdate(Query.dropTable("processos"));
//            comando.executeUpdate(Query.dropTable("clientes"));
        } catch (SQLException e) {
            imprimeErro("Erro ao apagar o banco.", e.getMessage());
        } finally {
            fechar();
        }
    }
}
