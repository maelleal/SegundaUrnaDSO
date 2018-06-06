
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPrincipal;

/**
 *
 * @author rodri
 */
public class ControladorPrincipal {
    
    private TelaPrincipal telaPrincipal;
    private ControladorCadastro ctrlCadastro;
    private ControladorUrna ctrlUrna;
    private ControladorCandidato ctrlCandidato;
    private TelaCadastro telaCadastro;

    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.ctrlCadastro = new ControladorCadastro(this);
        this.ctrlUrna = new ControladorUrna();
        this.telaCadastro = new TelaCadastro(this.ctrlCadastro);
    }
     
    
    public void abreTelaCadastro () {
        telaCadastro.setVisible(true);
    }
    
    
}   


   