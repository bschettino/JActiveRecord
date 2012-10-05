/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import helpers.DateHelper;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import bd.ClienteDao;

/**
 *
 * @author Schettino
 */
public class Processo {

    private int id;
    private Date dataCriacao;
    private Date ultimaAtualizacao;
    private int numProcesso;
    private int natureza;
    private String vara;
    private String fase;
    private Date dataAudiencia;
    private Date prazo;
    private BigDecimal preco;
    private int clienteId;
    private Cliente cliente;
    private List<Arquivo> arquivos;

    public List<Arquivo> getArquivos() {
        if (arquivos == null) {
        }
        return arquivos;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Date getDataAudiencia() {
        return dataAudiencia;
    }

    public void setDataAudiencia(Date dataAudiencia) {
        this.dataAudiencia = dataAudiencia;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNatureza() {
        return natureza;
    }

    public void setNatureza(int natureza) {
        this.natureza = natureza;
    }

    public int getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(int numProcesso) {
        this.numProcesso = numProcesso;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public Cliente getCliente() {
        if (this.cliente == null) {
            ClienteDao clDao = new ClienteDao();
            this.cliente = clDao.buscar(this.clienteId);
        }
        return this.cliente;
    }

    public Cliente reloadCliente() {
        ClienteDao clDao = new ClienteDao();
        return clDao.buscar(this.clienteId);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {

        return "id = " + this.id + ", # processo = '" + this.getNumProcesso()
                + "', natureza =" + this.getNatureza() + "', vara ='" + this.getVara()
                + "', fase ='" + this.getFase() + "', data da audiência ='" + this.getDataAudiencia()
                + "', prazo ='" + this.getPrazo() + "', preco ='" + this.getPreco() + "', \n data de criação = " + DateHelper.stringfy(this.dataCriacao) + ", última atualização = " + DateHelper.stringfy(this.ultimaAtualizacao);
    }

}
