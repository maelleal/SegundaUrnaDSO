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
    
    private static final long serialVersionUID = 1L;
            
    private String nome;
    private Integer codigo;
    
    public PartidoPolitico(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
