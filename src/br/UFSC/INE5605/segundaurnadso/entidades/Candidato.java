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
public class Candidato extends Pessoa implements Serializable {

    private PartidoPolitico partido;
    private int numero;

    public Candidato(String nome, PartidoPolitico partido, int numero) {
        super(nome);
        this.partido = partido;
        this.numero = numero;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
