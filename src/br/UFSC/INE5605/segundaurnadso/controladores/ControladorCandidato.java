/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;


import br.UFSC.INE5605.SegundaUrnaDSO.interfaces.ICandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCandidato;
import br.UFSC.INE5605.segundaurnadso.entidades.CandidatoDAO;
import java.util.ArrayList;

/**
 *
 * @author Ivo Guilherme
 */
public class ControladorCandidato{
    private static ControladorCandidato instancia;
    private CandidatoDAO candidatoDAO;
    private ControladorCandidato() {
       
    }
   
    public void incluiCandidato(){
        //telaCandidato.exibeCadastroCandidato();
        
    }
    void abreTelaCandidato() {
        TelaCandidato.getInstancia().setVisible(true);
    }
    public void cadastraCandidato(String nome, PartidoPolitico partido, int numeroCandidato) {
           Candidato governador = new Candidato(nome, partido, numeroCandidato);
           candidatoDAO.put(governador);
          // telaCandidato.incluiGovernador();
    }
    
    public void exibeMenuPrincipal() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public static ControladorCandidato getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCandidato();
        }
        return instancia;
    }
    /*
        try {
            while (candidato.getNumeroCandidato() < 01 || candidato.getNumeroCandidato() > 98 ) {            
            Candidato candidato = new Candidato(candidato.getCargo(), candidato.getPartido(), 
                candidato.getNumeroCandidato(), candidato.getNome());
        
            if (candidato.getCargo(Cargo.DEPUTADO)) { // Corrigir lógica
                if(!deputados.contains(candidato)) {
                    deputados.add(candidato);
                    telaCandidato.incluiDeputado();
                } else {
                    telaCandidato.candidatoExistente();
                }
            } else {
                if(!governadores.contains(candidato)) {
                governadores.add(candidato);
                telaCandidato.incluiGovernador();
                }
                telaCandidato.candidatoExistente();
            }
            
            }
            
        } catch (Exception e) {
            
        }
        
                
    }
    public void excluiCandidato (Candidato candidato){
        candidato.getNome();
        if(deputados.contains(candidato)){
            deputados.remove(candidato);
            telaCandidato.excluiDeputado();            
        } else if(governadores.contains(candidato)) {
            governadores.remove(candidato);
            telaCandidato.excluiGovernador();
        } else {
            telaCandidato.candidatoInexistente();
        }
    }
    
    public Candidato encontraDeputadoPeloNumero (int numeroCandidato){
        for (int i = 1; i < deputados.size(); i++) {
            Candidato candidato = deputados.get(i);
            if (numeroCandidato == candidato.getNumeroCandidato()) {
                return candidato;
            } 
        }
        return null;
    }
    public Candidato encontraGovernadorPeloNumero (int numeroCandidato){
        for (int i = 1; i < governadores.size(); i++) {
            Candidato candidato = governadores.get(i);
            if (numeroCandidato == candidato.getNumeroCandidato()) {
                return candidato;
            } 
        }
        return null;
    }
    */

    
    
}
