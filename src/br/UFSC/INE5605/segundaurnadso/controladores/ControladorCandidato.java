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
    private Candidato candidato;
    
    private ControladorCandidato() {
     
    }
    
    public void cadastraCandidato(String nome, PartidoPolitico partido, int numeroCandidato) {
           Candidato candidato = new Candidato(nome, partido, numeroCandidato);
           if(CandidatoDAO.getInstancia().get(numeroCandidato) == null ){
               CandidatoDAO.getInstancia().put(candidato);
               TelaCadastraCandidato.getInstancia().mensagemOK();
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
        return PartidoPoliticoDAO.getInstancias().getList();
    }

    public String getNome(Candidato candidato) {
        return candidato.getNome();
    }
    public static ControladorCandidato getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCandidato();
        }
        return instancia;
    }

    

}
