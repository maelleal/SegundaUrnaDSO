/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.controladores;

import br.UFSC.INE5605.urnaDSO.entidades.PartidoPolitico;
import br.UFSC.INE5605.urnaDSO.telas.TelaPartido;
import java.util.ArrayList;

/**
 *
 * @author Ivo Guilherme
 */
public class ControladorPartido {

    private ArrayList<PartidoPolitico> partidos;
    private TelaPartido telaPartido;
    private ControladorCadastro ctrlCadastro;

    public ControladorPartido(ControladorCadastro ctrlCadastro) {
        this.partidos = new ArrayList();
        this.telaPartido = new TelaPartido(this);
        this.ctrlCadastro = ctrlCadastro;
        
        
    }

    public ArrayList<PartidoPolitico> getPartidos() {
        return partidos;
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
    public void exibeMenuPartido(){
        telaPartido.exibeMenuPartido();
    }
    

    public void incluiPartido(String nomePartido) {
        PartidoPolitico partido = new PartidoPolitico(nomePartido);
        partidos.add(partido);
        
    
    }
    public void exibeMenuPrincipal() {
        ctrlCadastro.iniciaCadastro();
    }
    
    
}
