/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;


import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.CandidatoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPoliticoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPesquisaCandidato;

/**
 *
 * @author Ivo Guilherme
 */
public class ControladorCandidato{
    private static ControladorCandidato instancia;
    
    
    private ControladorCandidato() {
        
    }
    public void cadastraNulo(){
        Candidato candidatoNaoValidos = new Candidato("Votos Não Válidos", new PartidoPolitico("", 00), 00);
        CandidatoDAO.getInstancia().put(candidatoNaoValidos);
        
    }
    
    public void cadastraCandidato(String nome, PartidoPolitico partido, int numeroCandidato) {
           Candidato candidato = new Candidato(nome, partido, numeroCandidato);
           if(CandidatoDAO.getInstancia().get(numeroCandidato) == null ){
               CandidatoDAO.getInstancia().put(candidato);
           } else {
               TelaCadastraCandidato.getInstancia().mensagemErro();
           }
    }
    
    
    public void excluiCandidato(int codigoCandidato) {
        CandidatoDAO.getInstancia().remove(codigoCandidato);
    }
    
    public void exibeTelaCandidato() {
        TelaCandidato.getInstancia().setVisible(true);
    }
    public void exibeTelaCadastraCandidato() {
        TelaCadastraCandidato.getInstancia().setVisible(true);
    }
    
    public void exibeTelaPesquisaCandidato() {
        TelaPesquisaCandidato.getInstancia().updateData();
        TelaPesquisaCandidato.getInstancia().setVisible(true);
    }
    public void exibeTelaPrincipal() {
        ControladorPrincipal.getInstancia().exibeTelaPrincipal();
    }
    public Candidato buscaCandidatoPeloNumero(int numeroCandidato){
        Candidato cand = null;
        for(Candidato e : CandidatoDAO.getInstancia().getList()){
            if(e.getNumeroCandidato()== numeroCandidato){
                cand = e;
            }      
        }
        return cand;
    }
    
    public Iterable<PartidoPolitico> getLista() {
        return PartidoPoliticoDAO.getInstancia().getList();
    }
    public Iterable<Candidato> getListaCandidatos() {
        return CandidatoDAO.getInstancia().getList();
    }

    public static ControladorCandidato getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCandidato();
        }
        return instancia;
    }

    public void exibeTelaCadastro() {
        ControladorPrincipal.getInstancia().exibeTelaCadastro();
    }

    public void alteraCandidato(Candidato candidato) {
        TelaCadastraCandidato.getInstancia().alteraCandidato(candidato.getNumeroCandidato());
        TelaCadastraCandidato.getInstancia().setVisible(true);
        
    }
    
    public String getNome(Candidato candidato) {
        return candidato.getNome();
    }

    public Integer getNumero(Candidato candidato) {
        return candidato.getNumeroCandidato();
    }
}
