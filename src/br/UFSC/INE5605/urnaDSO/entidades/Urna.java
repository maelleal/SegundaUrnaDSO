/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.entidades;

/**
 *
 * @author Ismael
 */
public class Urna {
    
    private SecaoEleitoral secao;
    private static int numeroUrna;

    public Urna(SecaoEleitoral secao) {
        this.secao = secao;
        Urna.numeroUrna++;
        this.numeroUrna = Urna.numeroUrna;
               
        
    }

    public SecaoEleitoral getSecao() {
        return secao;
    }

    public void setSecao(SecaoEleitoral secao) {
        this.secao = secao;
    }   
    
}
