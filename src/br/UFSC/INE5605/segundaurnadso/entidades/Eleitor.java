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
    
    private int tituloEleitoral;
    private String cidade;
    public boolean jaVotou;

    public Eleitor(int tituloEleitoral, String nome, String cidade) {
        super(nome);
        this.tituloEleitoral = tituloEleitoral;
        this.jaVotou = false;
        this.cidade = cidade;
    }

    public boolean getJaVotou() {
        return jaVotou;
    }

    public void setJaVotou(boolean jaVotou) {
        this.jaVotou = jaVotou;
    }
    
    public int getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(int tituloEleitoral) {
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
