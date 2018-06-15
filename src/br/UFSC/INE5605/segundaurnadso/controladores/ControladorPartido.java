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
       
      PartidoPolitico partido1 = new PartidoPolitico("PCC", 88);
      PartidoPoliticoDAO.getInstancias().put(partido1);
      PartidoPolitico partido2 = new PartidoPolitico("TPC", 77);
      PartidoPoliticoDAO.getInstancias().put(partido2);
      PartidoPolitico partido3 = new PartidoPolitico("BCC", 66);
      PartidoPoliticoDAO.getInstancias().put(partido3);
    }
    
    /*
    public PartidoPolitico encontraPartidoPeloNome(String nome){
        PartidoPolitico a = null;
        for(PartidoPolitico e : PartidoPoliticoDAO.getInstancias().get(Integer.valueOf(nome))){
            if(e.getPartido() == nome){
                a = e;
            }      
        }
        return a;
    }
    */
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
