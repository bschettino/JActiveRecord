/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Schettino
 */

//create table clientes(  
//   id int not null auto_increment,
//   data_criacao date not null,
//   ultima_atualizacao date not null,
//   nome varchar(256) not null,  
//   rg varchar(20) not null,  
//   cpf varchar(12) not null,  
//   telefone varchar(20),  
//   dados_adicionais varchar(256),   
//   referencias varchar(256),   
//   estado varchar(50),   
//   cidade varchar(50),   
//   bairro varchar(50),   
//   rua varchar(50),   
//   numero varchar(50),   
//   complemento varchar(50),   
//   primary key(id)         
//);  


import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.List;  
  
import javax.swing.JOptionPane;  
  
import models.Cliente;  
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
  
public class ClienteDao {  
   // Configura essas variáveis de acordo com o seu banco  
  
   private Connection con;  
   private Statement comando;  
  
   public void apagar(int id) {  
      conectar();  
      try {  
         comando  
               .executeUpdate("DELETE FROM clientes WHERE id = '" + id  
                     + "';");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao apagar Cliente", e.getMessage());  
      } finally {  
         fechar();  
      }  
   }  
  
   public List<Cliente> buscarTodos() {  
      conectar();  
      List<Cliente> resultados = new ArrayList<Cliente>();  
      ResultSet rs;  
      try {  
         rs = comando.executeQuery("SELECT * FROM clientes");  
         while (rs.next()) {  
            Cliente temp = new Cliente();  
            // pega todos os atributos da Cliente  
            
            temp.setId(rs.getInt("id"));
            temp.setDataCriacao(Date.valueOf(rs.getString("data_criacao")));  
            temp.setUltimaAtualizacao(Date.valueOf(rs.getString("ultima_atualizacao")));  
            temp.setNome(rs.getString("nome"));  
            temp.setRg(rs.getString("rg"));  
            temp.setCpf(rs.getString("cpf"));  
            temp.setTelefone(rs.getString("telefone"));  
            temp.setDadosAdicionais(rs.getString("dados_adicionais"));  
            temp.setReferencias(rs.getString("referencias"));  
            resultados.add(temp);  
         }  
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar Clientes", e.getMessage());  
         return null;  
      }  
   }  
  
   public void atualizar(Cliente cliente) {  
      conectar();
      Date data = new Date(Calendar.getInstance().getTime().getTime());
      String com = "UPDATE clientes SET nome = '" + cliente.getNome()  
            + "', rg =" + cliente.getRg() + "', cpf ='" + cliente.getCpf()
            + "', telefone ='" + cliente.getTelefone() +  "', dados_adicionais ='" + cliente.getDadosAdicionais()
            + "', referencias ='" + cliente.getReferencias() 
            + "', ultima_atualizacao ='" + data  
            + "' WHERE  id = " + cliente.getId() + " ;";  
      try {  
         comando.executeUpdate(com);  
      System.out.println("Cliente Atualizado!");  
      } catch (SQLException e) {  
         e.printStackTrace();  
      } finally {  
         fechar();  
      }  
   }  
  
   public Cliente buscar(int id) {  
      conectar();  
      List<Cliente> resultados = new ArrayList<Cliente>();  
      ResultSet rs;  
      try {  
         rs = comando.executeQuery("SELECT * FROM clientes WHERE id = "  
               + id + " ;");  
         while (rs.next()) {  
            Cliente temp = new Cliente();  
            // pega todos os atributos da Cliente  
            temp.setId(rs.getInt("id"));
            temp.setDataCriacao(Date.valueOf(rs.getString("data_criacao")));  
            temp.setUltimaAtualizacao(Date.valueOf(rs.getString("ultima_atualizacao")));  
            temp.setNome(rs.getString("nome"));  
            temp.setRg(rs.getString("rg"));  
            temp.setCpf(rs.getString("cpf"));  
            temp.setTelefone(rs.getString("telefone"));  
            temp.setDadosAdicionais(rs.getString("dados_adicionais"));  
            temp.setReferencias(rs.getString("referencias"));  
            resultados.add(temp);  
         }  
         return resultados.get(0);  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar Cliente", e.getMessage());  
         return null;  
      }  
  
   }  
  
   public void insere(Cliente cliente){  
      conectar();  
      try {
          Date data = new Date(Calendar.getInstance().getTime().getTime());
         comando.executeUpdate("INSERT INTO clientes (nome, rg, cpf, telefone, dados_adicionais,"
                 + " referencias, estado, cidade, bairro, rua, numero, complemento, data_criacao, ultima_atualizacao) " 
                 + "VALUES('" + cliente.getNome() + "', '" + cliente.getRg() + "', '" + cliente.getCpf() + "', "
                 + "'" + cliente.getTelefone() + "', '" +  cliente.getDadosAdicionais() + "', "
                 + "'" + cliente.getReferencias() + "', '" +  "', '"  + data + "', '"  + data + "')");
         System.out.println("Inserido!");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao inserir Cliente", e.getMessage());  
      } finally {  
         fechar();  
      }  
   }  
  
   private void conectar() {  
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
  
   private void fechar() {  
      try {  
         comando.close();  
         con.close();  
         System.out.println("Conexão Fechada");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao fechar conexão", e.getMessage());  
      }  
   }  
  
   private void imprimeErro(String msg, String msgErro) {  
      JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);  
      System.err.println(msg);  
      System.out.println(msgErro);  
      System.exit(0);  
   }  
}  