/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPartido;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ivo Guilherme
 */
public class ControladorPartido implements Serializable {
    private static ControladorPartido instancia;
    private ArrayList<PartidoPolitico> partidos;
    private PartidoPolitico partido;

    
    
    public ArrayList<PartidoPolitico> getPartidos() {
        return partidos;
    }
    
    public static ControladorPartido getInstancia(){
        if(instancia == null){
            instancia = new ControladorPartido();
        }
        return instancia;
    }
    
    public PartidoPolitico encontraPartidoPeloNome(String nome){
        PartidoPolitico a = null;
        for(PartidoPolitico e : partidos){
            if(e.getPartido() == nome){
                a = e;
            }      
        }
        return a;
    }
    
    

    public void incluiPartido(String nomePartido) {
        PartidoPolitico partido = new PartidoPolitico(nomePartido);
        partidos.add(partido);
        
    
    }
    public void exibeMenuPrincipal() {
        ControladorCadastro.getInstancia().iniciaCadastro();
    }

    

    public void executaCadastroPartido() {
        System.out.println("TESTE");
        //telaPartido.setVisible(true);
    }
    
    
}
