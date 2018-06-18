/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPoliticoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastraPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPesquisaPartido;
import java.io.Serializable;


/**
 *
 * @author Ivo Guilherme
 */
public class ControladorPartido {
    private static ControladorPartido instancia;

    public ControladorPartido() {
    
    }
    public void incluiPartido(String nomePartido, int codigoPartido) {
        PartidoPolitico partido = new PartidoPolitico(nomePartido, codigoPartido);
        if(PartidoPoliticoDAO.getInstancia().get(codigoPartido) == null){
            PartidoPoliticoDAO.getInstancia().put(partido);
            TelaCadastraPartido.getInstancia().mensagemOK();
        } else {
            TelaCadastraPartido.getInstancia().mensagemErro();
        }
    }
    
    public void excluiPartido(int codigoPartido) {
        PartidoPoliticoDAO.getInstancia().removePartido(codigoPartido);
    }
    
    public PartidoPolitico buscaPartidoPeloCodigo(int codigoPartido){
        PartidoPolitico partido = null;
        for(PartidoPolitico e : PartidoPoliticoDAO.getInstancia().getList()){
            if(e.getCodigo()== codigoPartido){
                partido = e;
            }      
        }
        return partido;
    }
    
    public void exibeTelaPartido() {
        TelaPartido.getInstancia().setVisible(true);
    }
    public void exibeTelaCadastraPartido() {
        TelaCadastraPartido.getInstancia().setVisible(true);
    }
    public void exibeTelaPesquisaPartido() {
        TelaPesquisaPartido.getInstancia().updateData();
        TelaPesquisaPartido.getInstancia().setVisible(true);
    }
    public void exibeTelaPrincipal() {
        ControladorPrincipal.getInstancia().exibeTelaPrincipal();
    }

    

    
    

    
    public static ControladorPartido getInstancia(){
        if(instancia == null){
            instancia = new ControladorPartido();
        }
        return instancia;
    }

    public void exibeTelaCadastro() {
        ControladorPrincipal.getInstancia().exibeTelaCadastro();
    }

    

    
}
