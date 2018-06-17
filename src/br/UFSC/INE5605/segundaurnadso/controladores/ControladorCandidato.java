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
import javax.swing.JComboBox;

/**
 *
 * @author Ivo Guilherme
 */
public class ControladorCandidato{
    private static ControladorCandidato instancia;
    private CandidatoDAO candidatoDAO;
    private JComboBox<Object> partidoCandidato;
    
    private ControladorCandidato() {
        
    }
    
    
    public void incluiCandidato(String nome, PartidoPolitico partido, Integer numeroCandidato) {
           Candidato candidato = new Candidato(nome, partido, numeroCandidato);
           if(CandidatoDAO.getInstancia().get(numeroCandidato) == null){
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
            if(e.getNumero()== numeroCandidato){
                cand = e;
            }      
        }
        return cand;
    }
    
}
