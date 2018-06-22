/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.controladores;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.CandidatoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Voto;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.VotoDAO;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Ismael
 */
public class ControladorUrna {
    private static ControladorUrna instancia;
    private Candidato candidato;  
    private Integer k = 0;
    private ControladorUrna() {
        
    } 
        
    public void capturaVoto(int numeroDigitado){
        candidato = ControladorCandidato.getInstancia().buscaCandidatoPeloNumero(numeroDigitado);
        Voto votoComputado = new Voto(candidato);
        VotoDAO.getInstancia().put(k, votoComputado);
        k++;
        
    }
    
    
    public void contagemVotos(){
        
        for (Candidato candidato : ControladorCandidato.getInstancia().getListaCandidatos()) {
            for (Voto voto : VotoDAO.getInstancia().getList()) {
                if (candidato.equals(voto.getCandidato())) {
                    candidato.incluiVoto();
                }
            }
        }
        for (int i = 0; i < CandidatoDAO.getInstancia().getList().size()-1; i++) {
            
            candidato.votosRecebidos();
            
        }
    }
    public void resultadoDoPleito(){
        int candidatoVice = 0;
        int candidatoVencedor = 0;
        Candidato vencedor = null;
        Candidato nulos = null;
        for (Candidato candidato : ControladorCandidato.getInstancia().getListaCandidatos()) {
            for (Voto voto : VotoDAO.getInstancia().getList()) {
                if (candidato.equals(voto.getCandidato())) {
                    candidato.incluiVoto();
                }
            }
            if(candidato.votosRecebidos() < candidatoVencedor){
                   candidatoVice = candidato.votosRecebidos();
               } else {
                  candidatoVencedor = candidato.votosRecebidos();
                  vencedor = candidato;
                  
               }
        }
        nulos = ControladorCandidato.getInstancia().buscaCandidatoPeloNumero(0);
        int votosNaoValidos = nulos.votosRecebidos();
        String CandidatoEleito = ControladorCandidato.getInstancia().getNome(vencedor);
        JOptionPane.showMessageDialog(null, "Com "+candidatoVencedor+" votos \n"+"O candidato "+CandidatoEleito+" está eleito \nVotos BRANCOS / NULOS = "+votosNaoValidos, "Resultado do pleito", ERROR_MESSAGE);
        
    }
    public void executaTelaUrna() {
        TelaUrna.getInstancia().setVisible(true);
    }
    
    public void exibeTelaPrincipal() {
        ControladorPrincipal.getInstancia().exibeTelaPrincipal();
    }
    
    public static ControladorUrna getInstancia(){
        if (instancia == null) {
            instancia = new ControladorUrna();
        }
        return instancia;
    }
    public void cadastraBrancoNulo (){
        ControladorCandidato.getInstancia().cadastraNulo();
        
        
    }
}
