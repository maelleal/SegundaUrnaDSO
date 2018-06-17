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
       
        Candidato candidato1 = new Candidato("Ismael Leal", PartidoPoliticoDAO.getInstancias().get(88), 11);
        CandidatoDAO.getInstancia().put(candidato1);
        Candidato candidato2 = new Candidato("Ivo Guilherme", PartidoPoliticoDAO.getInstancias().get(88), 22);
        CandidatoDAO.getInstancia().put(candidato2);
        Candidato candidato3 = new Candidato("Jean VouRodar", PartidoPoliticoDAO.getInstancias().get(88), 81);
        CandidatoDAO.getInstancia().put(candidato3);
       
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
    
    public static ControladorCandidato getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCandidato();
        }
        return instancia;
    }

    public void exibeMenuCandidato() {
        TelaCandidato.getInstancia().setVisible(true);
    }
    public void exibeMenuCadastro() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public void exibeCadastraCandidato() {
        TelaCadastraCandidato.getInstancia().setVisible(true);
    }
    void exibeTelaCandidato() {
        TelaCandidato.getInstancia().setVisible(true);
    }
     public void exibeMenuPrincipal() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public void abreTelaPesquisaCandidato() {
        TelaPesquisaCandidato.getInstancia().updateData();
        TelaPesquisaCandidato.getInstancia().setVisible(true);
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

    public void executaCadastroCandidato() {
        TelaCadastraCandidato.getInstancia().setVisible(true);  
    }

    public Iterable<PartidoPolitico> getLista() {
        return PartidoPoliticoDAO.getInstancias().getList();
    }

    public String getNome(Candidato candidato) {
        return candidato.getNome();
    }

    
}
