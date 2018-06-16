/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Eleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.SecaoEleitoral;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.EleitorDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPesquisaEleitor;
import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
public class ControladorEleitor {
    private static ControladorEleitor instancia;
    private TelaEleitor telaEleitor;
   

    public ControladorEleitor() {
    }
    
    public static ControladorEleitor getInstancia(){
        if(instancia == null) {
            instancia = new ControladorEleitor();
        }
        return instancia;
    }
    
    public void exibeMenuCadastro() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public void exibeCadastraEleitor() {
        TelaCadastraEleitor.getInstancia().setVisible(true);
    }
    
    public void incluiEleitor(Integer tituloEleitoral, String nomeEleitor){
        Eleitor eleitor = new Eleitor(tituloEleitoral, nomeEleitor);
        if(EleitorDAO.getInstancia().get(tituloEleitoral)== null) {
            EleitorDAO.getInstancia().put(eleitor);
            TelaCadastraEleitor.getInstancia().mensagemOK();
        } else {
            TelaCadastraEleitor.getInstancia().mensagemErro();
        } 
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

    public void executaTelaPesquisaEleitor() {
        TelaPesquisaEleitor.getInstancia().updateData();
        TelaPesquisaEleitor.getInstancia().setVisible(true);
        
    }

    
}
