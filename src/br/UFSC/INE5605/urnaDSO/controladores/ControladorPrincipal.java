
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.controladores;

import br.UFSC.INE5605.urnaDSO.telas.TelaPrincipal;

/**
 *
 * @author rodri
 */
public class ControladorPrincipal {
    
    private TelaPrincipal telaPrincipal;
    private ControladorCadastro ctrlCadastro;
    private ControladorUrna ctrlUrna;
    private ControladorCandidato ctrlCandidato;

    public ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.ctrlCadastro = new ControladorCadastro(this);
        this.ctrlUrna = new ControladorUrna();
        
    }
    
    public void inicializa() {
        telaPrincipal.exibeMenuPrincipal();
    }
    
    public void executaOpcao(int opcao) {
        if (opcao == 1) {
           ctrlCadastro.iniciaCadastro();
        }
        if (opcao == 2) {
            ctrlUrna.iniciarVotacao();
        } 
        if (opcao == 0) {
            this.mensagemFim();
        }
    }

    public void mensagemFim() {
        telaPrincipal.mensagemFim();
    }
}   


   