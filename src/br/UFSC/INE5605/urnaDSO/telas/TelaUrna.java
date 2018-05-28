/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.telas;

import java.util.Scanner;
import br.UFSC.INE5605.urnaDSO.controladores.ControladorUrna;
import br.UFSC.INE5605.urnaDSO.entidades.Candidato;
/**
 *
 * @author Ismael
 */
public class TelaUrna {
    
    private Scanner votoGov;
    private ControladorUrna ctrlUrna;
    
    public TelaUrna(ControladorUrna ctrlUrna){
        this.ctrlUrna = ctrlUrna;
        this.votoGov = new Scanner(System.in);
    }
    
    public void exibeMenuVotacao() {
        System.out.println("Iniciando Votacao:");
        System.out.println("");
        System.out.println("Digite o Numero do Candidato a Governador:");
        votoGov.nextInt();
        //System.out.println("1 - Confirma");
        //System.out.println("2 - Corrige");
    
    }
    /*
    public void votoRealizado() {
        System.out.println("Voto realizado com sucesso!");
    }
    
    public void eleitorJaVotou() {
        System.out.println("Eleitor já votou.");
    }*/
}
