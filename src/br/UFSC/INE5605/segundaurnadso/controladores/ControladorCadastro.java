/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraPartido;
/**
 *
 * @author rodri
 */
public class ControladorCadastro {
    private static ControladorCadastro instancia;
    

    private ControladorCadastro() {
        
    }
    
    public static ControladorCadastro getInstancia(){
        if (instancia == null) {
            instancia = new ControladorCadastro();
        }
        return instancia;
    }
    
    public void iniciaCadastro() {
        TelaCadastro.getInstancia().setVisible(true);   
    }
    
    public void executaTelaEleitor() {
        TelaEleitor.getInstancia().setVisible(true);   
    }
    
    public void executaTelaCandidato() {
        TelaCandidato.getInstancia().setVisible(true);   
    }
    
    public void executaTelaPartido() {
        TelaPartido.getInstancia().setVisible(true);
    }
    public void executaCadastroEleitor() {
        TelaCadastraEleitor.getInstancia().setVisible(true);   
    }
    
    public void executaCadastroCandidato() {
        TelaCadastraCandidato.getInstancia().setVisible(true);   
    }
    
    public void executaCadastroPartido() {
        TelaCadastraPartido.getInstancia().setVisible(true);
    }
    
    
}
