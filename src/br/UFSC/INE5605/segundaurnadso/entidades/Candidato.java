/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;
import br.UFSC.INE5605.SegundaUrnaDSO.interfaces.ICandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCandidato;
/**
 *
 * @author Ismael
 */
public class Candidato extends Pessoa {

    private PartidoPolitico partido;
    private int numeroCandidato;

    public Candidato(String nome, PartidoPolitico partido, int numeroCandidato) {
        super(nome);
        this.partido = partido;
        this.numeroCandidato = numeroCandidato;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    
    
    
}
