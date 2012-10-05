/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import bd.ClienteDao;
import java.util.ArrayList;


/**
 *
 * @author Schettino
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDao cDao = new ClienteDao();
        Cliente cliente = new Cliente();
//        cliente.setBairro("Inga");
//        cliente.setCidade("Niteroi");
//        cliente.setComplemento("apt 1406");
        cliente.setCpf("11920604740");
        cliente.setDadosAdicionais("Dados Adicionais do manolo");
//        cliente.setEstado("Rio de Janeiro");
        cliente.setNome("Bruno Schet");
//        cliente.setNumero("78");
        cliente.setReferencias("Amiguinho do Nevs");
        cliente.setRg("25797135-8");
//        cliente.setRua("Engenheiro Martins Romeo");
        cliente.setTelefone("88964987");
        cDao.insere(cliente);
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) cDao.buscarTodos();
        cliente = clientes.get(0);
        System.out.println("clientes.size " + clientes.size());
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Cliente "+ clientes.get(i).getId() + " : " + clientes.get(i));
            cDao.apagar(clientes.get(i).getId());
        }
//        Cliente c = new Cliente();
//        for (Iterator<Cliente> it = clientes.iterator(); it.hasNext(); c = it.next()) {
//            System.out.println("Cliente "+ c.id + " : " + c);
//            
//        }
        
//        cDao.apagar(cliente.getId());
    
    }
}
