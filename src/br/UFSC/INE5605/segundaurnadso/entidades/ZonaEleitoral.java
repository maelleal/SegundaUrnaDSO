/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
public class ZonaEleitoral {
    
    private int numeroZona;
    private String cidade;
    private ArrayList<SecaoEleitoral>secoes;

    public ZonaEleitoral(int numeroZona, String cidade) {
        this.numeroZona = numeroZona;        
        this.secoes = new ArrayList();
        this.cidade = cidade;
    }

    public int getNumeroZona() {
        return numeroZona;
    }

    public void setZona(int numeroZona) {
        this.numeroZona = numeroZona;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public ArrayList<SecaoEleitoral> getSecoes(){
        return secoes;
    }
    
}
