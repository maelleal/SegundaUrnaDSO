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
    /*
    public Eleitor encontraEleitorPeloTitulo(int titulo){
        Eleitor a = null;
        for(Eleitor e : eleitores){
            if(e.getTituloEleitoral() == titulo){
                a = e;
            }      
        }
        return a;
    }
    
    public SecaoEleitoral encontraSecaoPeloNumero(int secaoEleitoral){
        SecaoEleitoral a = null;
        for(SecaoEleitoral s : secoes){
            if(s.getSecao() == secaoEleitoral){
                a = s;
            }      
        }
        return a;
    }
    */
    
    public void cadastraEleitor(int tituloEleitoral, String nome){
        Eleitor eleitor = new Eleitor(tituloEleitoral, nome);
        if(EleitorDAO.getInstancia().get(tituloEleitoral)== null){
            EleitorDAO.getInstancia().put(eleitor);
            TelaCadastraEleitor.getInstancia().mensagemOK();
        } else {
            TelaCadastraEleitor.getInstancia().mensagemErro();
        }
        
    }
  
    public void incluiEleitor(Eleitor eleitor){
        EleitorDAO.getInstancia().put(eleitor);
    }
    
    public void excluirEleitor(Eleitor e){
        EleitorDAO.getInstancia().remove(e);
        //TODO tratar exceções
    }
    
    public void exibeTelaPesquisaEleitor() {
        TelaPesquisaEleitor.getInstancia().updateData();
        TelaPesquisaEleitor.getInstancia().setVisible(true);
    }
    public void exibeTelaEleitor() {
        TelaEleitor.getInstancia().setVisible(true);
    }
    public void exibeTelaCadastraEleitor() {
        TelaCadastraEleitor.getInstancia().setVisible(true);
    }

    public void exibeTelaPrincipal() {
        ControladorPrincipal.getInstancia().exibeTelaPrincipal();
    }
    public static ControladorEleitor getInstancia(){
        if(instancia == null) {
            instancia = new ControladorEleitor();
        }
        return instancia;
    }
    
}
