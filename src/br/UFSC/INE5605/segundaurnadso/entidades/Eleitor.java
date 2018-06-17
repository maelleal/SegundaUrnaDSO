/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

import java.io.Serializable;

/**
 *
 * @author Ismael
 */
public class Eleitor extends Pessoa implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    
    private Integer tituloEleitoral;
   // private String cidade;
    public boolean jaVotou;

    public Eleitor(Integer tituloEleitoral, String nome) {
        super(nome);
        this.tituloEleitoral = tituloEleitoral;
        this.jaVotou = false;
        //this.cidade = cidade;
    }

    public boolean getJaVotou() {
        return jaVotou;
    }

    public void setJaVotou(boolean jaVotou) {
        this.jaVotou = jaVotou;
    }
    
    public Integer getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(Integer tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    } 
}
