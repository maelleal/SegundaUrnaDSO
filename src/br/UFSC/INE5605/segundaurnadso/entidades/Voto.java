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
public class Voto {
    
    private Candidato candidato;
 
    public Voto(Candidato candidato){
        this.candidato = candidato;
    }

    public Voto() {
        
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }    

}