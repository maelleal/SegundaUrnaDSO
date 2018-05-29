/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import java.util.Scanner;

/**
 *
 * @author Ismael
 */
public class TelaCandidato {
    private Scanner cadastroCandidato;
    private ControladorCandidato ctrlCandidato;
    private ControladorCadastro ctrlCadastro;
    
    public TelaCandidato (ControladorCandidato ctrlCandidato){
        this.cadastroCandidato = new Scanner(System.in);
        this.ctrlCandidato = ctrlCandidato;
    }
    
    public void exibeCadastroCandidato(){
        TelaCadastro telaCadastro = new TelaCadastro(ctrlCadastro);
        System.out.println("==== Cadastro de Candidato ===="); 
        System.out.println(""); 
        System.out.println("Preencha os dados a seguir"); 
        System.out.println(""); 
        System.out.println("digite o nome");
        String nome = cadastroCandidato.nextLine();
        System.out.println("escolha o partido");
       // int partidos = cadastroCandidato.nextInt();
        System.out.println("digite o numero do candidato");
        int numeroCandidato = cadastroCandidato.nextInt();
        ctrlCandidato.cadastraCandidato(nome, partido, numeroCandidato);
        System.out.println("Candidato cadastrado com sucesso.");
        ctrlCandidato.exibeMenuPrincipal();           
    }
    
    public void incluiGovernador () {
        System.out.println("Candidato a Governador Adcicionado com Sucesso");
    }
    public void candidatoExistente() {
        System.out.println("Candidato Existente");
    }
    public void excluiGovernador () {
        System.out.println("Candidato a Governador Excluído com Sucesso");
    }
    public void candidatoInexistente() {
        System.out.println("Candidato Inexistente");
    }

    public void exibeCandidato(Candidato candidato) {
        System.out.println("Candidato: "+ candidato.getNome());
    }
    
  
}
