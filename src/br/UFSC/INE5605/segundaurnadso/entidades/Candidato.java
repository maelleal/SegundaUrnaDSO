/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

import br.UFSC.INE5605.SegundaUrnaDSO.interfaces.ICandidato;
import java.io.Serializable;
/**
 *
 * @author Ismael
 */
public class Candidato extends Pessoa implements Serializable, ICandidato {
    private static final long serialVersionUID = 1L;
    private PartidoPolitico partido;
    private Integer numero;
    private int voto;

    public Candidato(String nome, PartidoPolitico partido, Integer numero) {
        super(nome);
        this.partido = partido;
        this.numero = numero;
        this.nome = nome;
        this.voto = 0;
    }
    public void incluiVoto() {
        this.voto++;
    }
    public int votosRecebidos (){
        return this.voto;
    }
    @Override
    public PartidoPolitico getPartido() {
        return partido;
    }
    
    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    //@Override
    public String getNome() {
        return nome;
    }
    //@Override
    public void setNome(String nome) {
        this.nome = nome;
    }  

    @Override
    public int getNumeroCandidato() {
        return numero;
    }

    
    
    
}
