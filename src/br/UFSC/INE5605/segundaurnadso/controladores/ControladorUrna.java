/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Voto;
import br.UFSC.INE5605.segundaurnadso.entidades.VotoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Ismael
 */
public class ControladorUrna {
    private static ControladorUrna instancia;
    Candidato candidato;  

    private ControladorUrna() {
        
    } 
    public void iniciarVotacao(){
       
    }
    
    public void capturaVoto(int numeroDigitado){
        candidato = ControladorCandidato.getInstancia().buscaCandidatoPeloNumero(numeroDigitado);
        Voto votoComputado = new Voto(candidato);
        //VotoDAO.getInstancia().put(votoComputado);
    }
    
    public void resultadoDoPleito(){
        JOptionPane.showMessageDialog(null, "Resultado é secreto!");
        System.exit(0);
    }

    public void executaTelaUrna() {
        TelaUrna.getInstancia().setVisible(true);
    }
    public static ControladorUrna getInstancia(){
        if (instancia == null) {
            instancia = new ControladorUrna();
        }
        return instancia;
    }

    public void exibeTelaPrincipal() {
        ControladorPrincipal.getInstancia().exibeTelaPrincipal();
    }
    public void contagemVotos(){
        int contMaisVotado = 0;
        int contTemp = 0;
        //fazer um for em getList no DAO
        //fazer um procura candidato pelo Voto
        //se for tal nome, conta 1
        //contMais votado é o max entre eles
    }
}
