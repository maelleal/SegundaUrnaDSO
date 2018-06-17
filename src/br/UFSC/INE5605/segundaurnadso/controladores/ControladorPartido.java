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
        if(PartidoPoliticoDAO.getInstancias().get(codigoPartido) == null){
            PartidoPoliticoDAO.getInstancias().put(partido);
            TelaCadastraPartido.getInstancia().mensagemOK();
        } else {
            TelaCadastraPartido.getInstancia().mensagemErro();
        }
    }
    
    public void exibeMenuCadastro() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }
    public void exibeCadastraPartido() {
        TelaCadastraPartido.getInstancia().setVisible(true);
    }
   
    public static ControladorPartido getInstancia(){
        if(instancia == null){
            instancia = new ControladorPartido();
        }
        return instancia;
    }

    public void abreTelaPesquisaPartido() {
        TelaPesquisaPartido.getInstancia().updateData();
        TelaPesquisaPartido.getInstancia().setVisible(true);
    }
    
}
