/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Urna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Voto;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ismael
 */
public class ControladorUrna {
    private static ControladorUrna instancia;
    private ArrayList<Voto>listaVotosGovernadores;
    private int votoGov;
    

    private ControladorUrna() {
        this.listaVotosGovernadores = new ArrayList();
        
    } 
    
    public static ControladorUrna getInstancia(){
        if (instancia == null) {
            instancia = new ControladorUrna();
        }
        return instancia;
    }
    
    public void iniciarVotacao(){
       
    }
    
    public void resultadoGov(){
        JOptionPane.showMessageDialog(null, "Resultado é secreto!");
        System.exit(0);
    }
    

    public void abreTelaUrna() {
        TelaUrna.getInstancia().setVisible(true);
    }
}
