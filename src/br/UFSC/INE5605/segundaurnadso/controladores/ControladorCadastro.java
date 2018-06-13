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
/**
 *
 * @author rodri
 */
public class ControladorCadastro {
    private static ControladorCadastro instancia;
    

    private ControladorCadastro() {
        ControladorPartido.getInstancia();
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
    
    public void executaCadastroEleitor() {
        TelaEleitor.getInstancia().setVisible(true);   
    }
    
    public void executaCadastroCandidato() {
        TelaCandidato.getInstancia().setVisible(true);   
    }
    
    public void executaCadastroPartido() {
        TelaPartido.getInstancia().setVisible(true);
    }
}
