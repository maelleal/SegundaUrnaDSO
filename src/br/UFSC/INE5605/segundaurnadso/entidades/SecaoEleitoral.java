/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.entidades;

import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
public class SecaoEleitoral {
    
    private int secao;
    private ArrayList<Eleitor> eleitores;
    private String cidade;

    public SecaoEleitoral(int secao, String cidade) {
        this.secao = secao;
        this.eleitores = new ArrayList();
        this.cidade = cidade;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public ArrayList<Eleitor> getEleitores() {
        return eleitores;
    }
    
    
    
    
}
