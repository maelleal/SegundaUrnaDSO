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
    
    public static final int OPCAO_ELEITORES = 4;
    private static ControladorCadastro instancia;
    private TelaCadastro telaCadastro;
    private ControladorPrincipal ctrlPrincipal;
    private ControladorEleitor ctrlEleitor; 
    private ControladorCandidato ctrlCandidato;
    private ControladorPartido ctrlPartido;
    private TelaEleitor telaEleitor;
    private TelaPartido telaPartido;
    

    private ControladorCadastro() {
       
        
        this.telaEleitor = new TelaEleitor(this.ctrlEleitor);
        this.telaPartido = new TelaPartido(this.ctrlPartido);
        
    }
    
    public static ControladorCadastro getInstancia(){
        if (instancia == null) {
            instancia = new ControladorCadastro();
        }
        return instancia;
    }
    
    public void iniciaCadastro() {
        telaCadastro.setVisible(true);   
    }
    
    public void executaCadastroEleitor() {
        telaEleitor.setVisible(true);   
    }
    
    public void executaCadastroCandidato() {
        TelaCandidato.getInstancia().setVisible(true);   
    }
    
    public void executaCadastroPartido() {
        telaPartido.setVisible(true);
    }
}
