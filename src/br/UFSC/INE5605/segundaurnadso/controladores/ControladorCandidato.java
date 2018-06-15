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
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.CandidatoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPoliticoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPesquisaCandidato;
import java.util.ArrayList;

/**
 *
 * @author Ivo Guilherme
 */
public class ControladorCandidato{
    private static ControladorCandidato instancia;
    private CandidatoDAO candidatoDAO;
    
    private ControladorCandidato() {
        
        Candidato candidato1 = new Candidato("Ismael Leal", PartidoPoliticoDAO.getInstancias().get(88), 01);
        CandidatoDAO.getInstancia().put(candidato1);
        Candidato candidato2 = new Candidato("Ivo Guilherme", PartidoPoliticoDAO.getInstancias().get(88), 02);
        CandidatoDAO.getInstancia().put(candidato2);
        Candidato candidato3 = new Candidato("Jean VouRodar", PartidoPoliticoDAO.getInstancias().get(88), 03);
        CandidatoDAO.getInstancia().put(candidato3);
    }
    
    
    public void cadastraCandidato(String nome, PartidoPolitico partido, int numeroCandidato) {
           Candidato candidato = new Candidato(nome, partido, numeroCandidato);
           candidatoDAO.put(candidato);
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
            if(e.getNumero()== numeroCandidato){
                cand = e;
            }      
        }
        return cand;
    }

    
}
