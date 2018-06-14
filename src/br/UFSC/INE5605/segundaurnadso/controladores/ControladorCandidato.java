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
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraCandidato;
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
    public void exibeMenuCadastro() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public void exibeCadastraCandidato() {
        TelaCadastraCandidato.getInstancia().setVisible(true);
    }
    void exibeTelaCandidato() {
        TelaCandidato.getInstancia().setVisible(true);
    }
    public void cadastraCandidato(String nome, PartidoPolitico partido, int numeroCandidato) {
           Candidato candidato = new Candidato(nome, partido, numeroCandidato);
           candidatoDAO.put(candidato);
         
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

    public void exibeMenuCandidato() {
        TelaCandidato.getInstancia().setVisible(true);
    }
}
