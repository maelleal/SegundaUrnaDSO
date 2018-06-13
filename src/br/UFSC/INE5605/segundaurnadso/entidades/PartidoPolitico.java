/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

import java.io.Serializable;

/**
 *
 * @author Ismael
 */
public class PartidoPolitico implements Serializable {
    private String nome;

    public PartidoPolitico(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return nome;
    }

    public void setPartido(String partido) {
        this.nome = nome;
    }

   
    
}
