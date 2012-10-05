/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Schettino
 */

//create table processos(  
//   id int not null auto_increment,
//   data_criacao date not null,
//   ultima_atualizacao date not null,
//   numProcesso int not null,
//   natureza int not null,
//   vara varchar(256) not null,  
//   fase varchar(256) not null,  
//   data_audiencia date,
//   prazo date,
//   preco decimal,
//   primary key(id)         
//);  


import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.List;  
  
import javax.swing.JOptionPane;  
  
import models.Processo;  
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
  
public class ProcessoDao {  
   // Configura essas variáveis de acordo com o seu banco  
  
   private Connection con;  
   private Statement comando;  
  
   public void apagar(int id) {  
      conectar();  
      try {  
         comando.executeUpdate("DELETE FROM processos WHERE id = '" + id  
                     + "';");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao apagar Processo", e.getMessage());  
      } finally {  
         fechar();  
      }  
   }  
  
   public List<Processo> buscarTodos() {  
      conectar();  
      List<Processo> resultados = new ArrayList<Processo>();  
      ResultSet rs;  
      try {  
         rs = comando.executeQuery("SELECT * FROM processos");  
         while (rs.next()) {  
            Processo temp = new Processo();  
            // pega todos os atributos da Processo  
            
            temp.setId(rs.getInt("id"));
            temp.setDataCriacao(Date.valueOf(rs.getString("data_criacao")));  
            temp.setUltimaAtualizacao(Date.valueOf(rs.getString("ultima_atualizacao")));  
            temp.setNumProcesso(rs.getInt("num_processo"));
            temp.setNatureza(rs.getInt("natureza"));
            temp.setVara(rs.getString("vara"));  
            temp.setFase(rs.getString("fase"));  
            temp.setDataAudiencia(Date.valueOf(rs.getString("data_audiencia")));  
            temp.setPrazo(Date.valueOf(rs.getString("prazo")));  
            temp.setPreco(rs.getBigDecimal("preco"));
            resultados.add(temp);  
         }  
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar Clientes", e.getMessage());  
         return null;  
      }  
   }  
  
   public void atualizar(Processo processo) {  
      conectar();
      Date data = new Date(Calendar.getInstance().getTime().getTime());
      String com = "UPDATE processos SET num_processo = '" + processo.getNumProcesso()  
            + "', natureza =" + processo.getNatureza() + "', vara ='" + processo.getVara()
            + "', fase ='" + processo.getFase() +  "', data_audiencia ='" + processo.getDataAudiencia()
            + "', prazo ='" + processo.getPrazo() + "', preco ='" + processo.getPreco()  
            + "', ultima_atualizacao ='" + data  
            + "' WHERE  id = " + processo.getId() + " ;";  
      try {  
         comando.executeUpdate(com);  
      System.out.println("Processo Atualizado!");  
      } catch (SQLException e) {  
         e.printStackTrace();  
      } finally {  
         fechar();  
      }  
   }  
  
   public Processo buscar(int id) {  
      conectar();  
      List<Processo> resultados = new ArrayList<Processo>();  
      ResultSet rs;  
      try {  
         rs = comando.executeQuery("SELECT * FROM processos WHERE id = "  
               + id + " ;");  
         while (rs.next()) {  
            Processo temp = new Processo();  
            // pega todos os atributos da Processo  
            temp.setId(rs.getInt("id"));
            temp.setDataCriacao(Date.valueOf(rs.getString("data_criacao")));  
            temp.setUltimaAtualizacao(Date.valueOf(rs.getString("ultima_atualizacao")));  
            temp.setNumProcesso(rs.getInt("num_processo"));
            temp.setNatureza(rs.getInt("natureza"));
            temp.setVara(rs.getString("vara"));  
            temp.setFase(rs.getString("fase"));  
            temp.setDataAudiencia(Date.valueOf(rs.getString("data_audiencia")));  
            temp.setPrazo(Date.valueOf(rs.getString("prazo")));  
            temp.setPreco(rs.getBigDecimal("preco"));
            resultados.add(temp);
         }  
         return resultados.get(0);  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar Processo", e.getMessage());  
         return null;  
      }  
  
   }  
  
   public void insere(Processo processo){  
      conectar();  
      try {
          Date data = new Date(Calendar.getInstance().getTime().getTime());
         comando.executeUpdate("INSERT INTO processos (num_processo, natureza, vara, fase, data_audiencia,"
                 + " prazo, preco, cidade, bairro, rua, numero, complemento, data_criacao, ultima_atualizacao) " 
                 + "VALUES('" + processo.getNumProcesso() + "', '" + processo.getNatureza() + "', '" + processo.getVara() + "', "
                 + "'" + processo.getFase() + "', '" +  processo.getDataAudiencia() + "', "
                 + "'" + processo.getPrazo() + "', '" +  processo.getPreco() + "', "
                 + data + "', '"  + data + "')");
         System.out.println("Inserido!");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao inserir Processo", e.getMessage());  
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