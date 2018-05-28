/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.entidades;
import br.UFSC.INE5605.urnaDSO.interfaces.ICandidato;
import br.UFSC.INE5605.urnaDSO.entidades.Cargo;
import br.UFSC.INE5605.urnaDSO.entidades.Candidato;
import br.UFSC.INE5605.urnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.urnaDSO.telas.TelaCandidato;
/**
 *
 * @author Ismael
 */
public class Candidato extends Pessoa {

    
    
    
    private String cargo;
    private String partido;
    private int numeroCandidato;

    public Candidato(String nome, String cargo, String partido, int numeroCandidato) {
        super(nome);
        this.cargo = cargo;
        this.partido = partido;
        this.numeroCandidato = numeroCandidato;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
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
