/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPartido;
import br.UFSC.INE5605.segundaurnadso.entidades.PartidoPoliticoDAO;
import java.io.Serializable;


/**
 *
 * @author Ivo Guilherme
 */
public class ControladorPartido implements Serializable {
    private static ControladorPartido instancia;

    public ControladorPartido() {
        PartidoPolitico partido1 = new PartidoPolitico("PCC");
        PartidoPoliticoDAO.getInstancias().put(partido1);
        PartidoPolitico partido2 = new PartidoPolitico("TCC");
        PartidoPoliticoDAO.getInstancias().put(partido2);
        PartidoPolitico partido3 = new PartidoPolitico("BCC");
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
    public void incluiPartido(String nomePartido) {
        PartidoPolitico partido = new PartidoPolitico(nomePartido);
        PartidoPoliticoDAO.getInstancias().put(partido);
    
    }
    public void exibeMenuPrincipal() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }

    public void executaCadastroPartido() {
        System.out.println("TESTE");
        //telaPartido.setVisible(true);
    }
    
    public static ControladorPartido getInstancia(){
        if(instancia == null){
            instancia = new ControladorPartido();
        }
        return instancia;
    }
    
}
