/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import models.Cliente;


/**
 *
 * @author Schettino
 */
public class ManipulaDB {

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
    public static void main(String[] args) throws SQLException {
        conectar();
        try {
            con.setAutoCommit(false);
            Cliente cliente = new Cliente();
            cliente.setNome("Bruno");
            cliente.setRg("254242424242");
            cliente.setCpf("1918282828272");
            cliente.setTelefone("88765432");
            cliente.setDadosAdicionais("Very Crazy guy");
            cliente.setReferencias("Conheci na rua");
            comando.executeUpdate(Query.insert(cliente));
            cliente.setId(1);
            cliente.setCpf("Mudei o cpf!!!");
            comando.executeUpdate(Query.update(cliente));
        } catch (SQLException e) {
            con.rollback();
            imprimeErro("Erro ao inserir cliente.", e.getMessage());
        } finally {
            fechar();
        }
    }
}
