/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.ZonaEleitoral;
/**
 *
 * @author rodri
 */
public class ControladorCadastro {
    
    private TelaCadastro telaCadastro;
    private ControladorPrincipal ctrlPrincipal;
    private ControladorEleitor ctrlEleitor;
    private ControladorCandidato ctrlCandidato;
    private ControladorPartido ctrlPartido;
    private ZonaEleitoral zonaEleitoral;

    public ControladorCadastro(ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.telaCadastro = new TelaCadastro(this);
    }
    
    public void iniciaCadastro() {
        telaCadastro.exibeMenuCadastro();
        
    }
    public void inicializa() {
        
    }
    
    public void executaOpcaoCadastro(int opcaoCadastro){
        ControladorEleitor ctrlEleitor = new ControladorEleitor(this);
        ControladorCandidato ctrlCandidato = new ControladorCandidato(this);
        ControladorPartido ctrlPartido = new ControladorPartido(this);
        ControladorPrincipal ctrlPrincipal = new ControladorPrincipal();
        if (opcaoCadastro == 3) {
            ctrlEleitor.incluiSecao();
        }
        if (opcaoCadastro == 4) {
           ctrlEleitor.exibeMenuEleitores();
        }
        if (opcaoCadastro == 5) {
           ctrlCandidato.incluiCandidato();
        }
        if (opcaoCadastro == 6) {
           ctrlPartido.exibeMenuPartido();
        }
        if (opcaoCadastro == 7) {
            ctrlPrincipal.inicializa();
        }
        if (opcaoCadastro == 0) {
            ctrlPrincipal.mensagemFim();
        }
        
        
    }
  
}
