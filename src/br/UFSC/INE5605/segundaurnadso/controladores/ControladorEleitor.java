/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Eleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.EleitorDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPesquisaEleitor;

/**
 *
 * @author Ismael
 */
public class ControladorEleitor {
    private static ControladorEleitor instancia;

    public ControladorEleitor() {
        
    }
    
    public void incluiEleitor(Integer tituloEleitoral, String nomeEleitor){
        Eleitor eleitor = new Eleitor(tituloEleitoral, nomeEleitor);
        if(EleitorDAO.getInstancias().get(tituloEleitoral)== null) {
            EleitorDAO.getInstancias().put(eleitor);
            TelaCadastraEleitor.getInstancia().mensagemOK();
        } else {
            TelaCadastraEleitor.getInstancia().mensagemErro();
        } 
    }
    
    public void exibeMenuCadastro() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public void exibeCadastraEleitor() {
        TelaCadastraEleitor.getInstancia().setVisible(true);
    }
    
    /*
    public void incluiEleitor(Eleitor eleitor){
        EleitorDAO.getInstancia().put(eleitor);
    }
    
    public void excluirEleitor(Eleitor e){
        //EleitorDAO.getInstancia().remove();
    //TODO tratar exceções
    }
    
    */
    
    public static ControladorEleitor getInstancia(){
        if(instancia == null) {
            instancia = new ControladorEleitor();
        }
        return instancia;
    }

    public void abreTelaPesquisaEleitor() {
        TelaPesquisaEleitor.getInstancia().updateData();
        TelaPesquisaEleitor.getInstancia().setVisible(true);
        
    }
    
}
