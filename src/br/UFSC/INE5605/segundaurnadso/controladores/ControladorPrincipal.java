
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPrincipal;

/**
 *
 * @author rodri
 */
public class ControladorPrincipal {
    private static ControladorPrincipal instancia;
    
    private ControladorPrincipal() {
        
    }
    
    public void exibeTelaPrincipal() {
        TelaPrincipal.getInstancia().setVisible(true);
    }
    public void exibeTelaEleitor() {
        TelaEleitor.getInstancia().setVisible(true);   
    }
    public void exibeTelaCandidato() {
        TelaCandidato.getInstancia().setVisible(true);   
    }
    public void exibeTelaPartido() {
        TelaPartido.getInstancia().setVisible(true);
    }
    public void exibeTelaCadastro() {
        TelaCadastro.getInstancia().setVisible(true);
    }
    public void exibeTelaUrna() {
        ControladorUrna.getInstancia().executaTelaUrna();
    }
    public static ControladorPrincipal getInstancia (){
        if (instancia == null) {
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }
}   


   