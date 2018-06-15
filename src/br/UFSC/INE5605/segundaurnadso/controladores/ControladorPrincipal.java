
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPrincipal;

/**
 *
 * @author rodri
 */
public class ControladorPrincipal {
    private static ControladorPrincipal instancia;
    
    private ControladorPrincipal() {
        
    }
     
    public static ControladorPrincipal getInstancia (){
        if (instancia == null) {
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }
    
    
    public void abreTelaCadastro () {
        TelaCadastro.getInstancia().setVisible(true);
    }

    public void abreTelaPrincipal() {
        TelaPrincipal.getInstancia().setVisible(true);
    }
    
    
}   


   