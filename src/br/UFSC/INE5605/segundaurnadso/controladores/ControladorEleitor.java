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
import br.UFSC.INE5605.segundaurnadso.telas.TelaVerificaEleitor;


/**
 *
 * @author Ismael
 */
public class ControladorEleitor {
    private static ControladorEleitor instancia;
   

    public ControladorEleitor() {
        
    }
    
    public void cadastraEleitor(int tituloEleitoral, String nome){
        Eleitor eleitor = new Eleitor(tituloEleitoral, nome);
        if(EleitorDAO.getInstancia().get(tituloEleitoral)== null){
            EleitorDAO.getInstancia().put(eleitor);
        } else {
            TelaCadastraEleitor.getInstancia().mensagemErro();
        }
        
    }
  
    public void incluiEleitor(Eleitor eleitor){
        EleitorDAO.getInstancia().put(eleitor);
    }
    
    public void excluiEleitor(int codigoEleitor){
        EleitorDAO.getInstancia().remove(codigoEleitor);
        
    }
    public Eleitor buscaEleitorPeloTitulo(int tituloEleitor){
        Eleitor eleitor = null;
        for(Eleitor e : EleitorDAO.getInstancia().getList()){
            if(e.getTituloEleitoral() == tituloEleitor){
                eleitor = e;
            }      
        }
        return eleitor;
    }
    
    public boolean validaEleitor(int tituloEleitor){
        Eleitor eleitor = ControladorEleitor.getInstancia().buscaEleitorPeloTitulo(tituloEleitor);
        if(eleitor == null)  {
            TelaVerificaEleitor.getInstancia().mensagemErro();
            return false;
        } else if (eleitor.jaVotou == true){
            TelaVerificaEleitor.getInstancia().mensagemJaVotou();
            return false;
        }
        ControladorPrincipal.getInstancia().exibeTelaUrna();  
        eleitor.jaVotou = true;
        return true;
        
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

    public void exibeTelaCadastro() {
        ControladorPrincipal.getInstancia().exibeTelaCadastro();
    }

    public void exibeTelaVerificaEleitor() {
        TelaVerificaEleitor.getInstancia().setVisible(true);
    }

    public void alteraEleitor(Eleitor eleitor) {
        TelaCadastraEleitor.getInstancia().alteraEleitor(eleitor.getTituloEleitoral());
        TelaCadastraEleitor.getInstancia().setVisible(true);
        
    }
    
    public String getNome(Eleitor eleitor) {
        return eleitor.getNome();
    }
    public Integer getTituloEleitoral(Eleitor eleitor) {
        return eleitor.getTituloEleitoral();
    }
    
    
}
