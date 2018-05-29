/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

/**
 *
 * @author Ismael
 */
public class Eleitor extends Pessoa {
    
    private int tituloEleitoral;
    private SecaoEleitoral secaoEleitoral;
    private String cidade;
    public boolean jaVotou;

    public Eleitor(int tituloEleitoral, SecaoEleitoral secaoEleitoral, String nome, String cidade) {
        super(nome);
        this.tituloEleitoral = tituloEleitoral;
        this.secaoEleitoral = secaoEleitoral;
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

    public SecaoEleitoral getSecaoEleitoral() {
        return secaoEleitoral;
    }

    public void setSecaoEleitoral(SecaoEleitoral secaoEleitoral) {
        this.secaoEleitoral = secaoEleitoral;
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
