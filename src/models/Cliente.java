/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import helpers.DateHelper;
import java.util.List;

/**
 *
 * @author Schettino
 */
public class Cliente {

    private int id;
    private Date dataCriacao;
    private Date ultimaAtualizacao;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String dadosAdicionais;
    private String referencias;
    private List<Processo> processos;
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public String getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(String dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }


    @Override
    public String toString() {

        return "id = " + this.id + ", nome = '" + this.getNome()
                + "', rg ='" + this.getRg() + "', cpf ='" + this.getCpf()
                + "',\n telefone ='" + this.getTelefone() + "', dados adicionais ='" + this.getDadosAdicionais()
                + "',\n referencias ='" + this.getReferencias() + "', \n data de criação = " + DateHelper.stringfy(this.dataCriacao) + ", última atualização = " + DateHelper.stringfy(this.ultimaAtualizacao);
    }

}
