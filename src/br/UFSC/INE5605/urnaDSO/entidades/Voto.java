/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.entidades;
import br.UFSC.INE5605.urnaDSO.entidades.Cargo;

/**
 *
 * @author Ismael
 */
public class Voto {
    
    private Candidato candidato;
    private Cargo cargo;
 
    

    public Voto(Candidato candidato, Cargo cargo) {
        this.candidato = candidato;
        this.cargo = cargo;
       
    }

    public Voto() {
        
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    
    
    
}
