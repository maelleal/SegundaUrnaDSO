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
public class Voto implements Serializable{
    private static final long serialVersionUID = 1L;
    private Candidato candidato;

    
    public Voto(Candidato candidato){
        this.candidato = candidato;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }    

}
