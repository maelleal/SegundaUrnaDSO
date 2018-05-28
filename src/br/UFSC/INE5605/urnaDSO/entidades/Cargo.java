/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.entidades;

/**
 *
 * @author ismael
 */
public enum Cargo {
    
    
    GOVERNADOR(01),
    DEPUTADO(02);
    
    public int cargo;
        Cargo (int cargoPolitico) {
            cargo = cargoPolitico;
        }
   
}