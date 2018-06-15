/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Urna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Voto;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPrincipal;
import br.UFSC.INE5605.segundaurnadso.entidades.VotoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ismael
 */
public class ControladorUrna {
    private static ControladorUrna instancia;
    Candidato candidato;
    //private int votoGov;
    

    private ControladorUrna() {
        
        
    } 
    
    public static ControladorUrna getInstancia(){
        if (instancia == null) {
            instancia = new ControladorUrna();
        }
        return instancia;
    }
    
    public void iniciarVotacao(){
       
    }
    
    public void capturaVoto(int numeroDigitado){
        candidato = ControladorCandidato.getInstancia().buscaCandidatoPeloNumero(numeroDigitado);
        Voto votoComputado = new Voto(candidato);
        //VotoDAO.getInstancia().put(votoComputado);
    }
    
    
    
    public void resultadoGov(){
        JOptionPane.showMessageDialog(null, "Resultado é secreto!");
        System.exit(0);
    }
    

    public void abreTelaUrna() {
        TelaUrna.getInstancia().setVisible(true);
    }
}
