/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.telas;

import br.UFSC.INE5605.urnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.urnaDSO.controladores.ControladorEleitor;
import br.UFSC.INE5605.urnaDSO.entidades.Eleitor;
import br.UFSC.INE5605.urnaDSO.entidades.SecaoEleitoral;
import br.UFSC.INE5605.urnaDSO.interfaces.IEleitor;
import java.util.Scanner;

/**
 *
 * @author Ismael
 */
public class TelaEleitor {
    
    private Scanner teclado;
    private ControladorEleitor ctrlEleitor;
    private TelaCadastro telaCadastro;
    private ControladorCadastro ctrlCadastro;
    private SecaoEleitoral secao;
    
    public TelaEleitor (ControladorEleitor ctrlEleitor){
        this.teclado = new Scanner(System.in);
        this.ctrlEleitor = ctrlEleitor;
    }

   
    public void exibeMenuEleitores() {
        System.out.println("==== Cadastro de Eleitor ===="); 
        System.out.println(""); 
        System.out.println("Preencha os dados a seguir"); 
        System.out.println(""); 
        System.out.println("Nome do eleitor: ");
        String nome = teclado.nextLine();
        System.out.println("Cidade: ");
        String cidade = teclado.nextLine();
        System.out.println("Numero do titulo de eleitor: ");
        int tituloEleitoral = teclado.nextInt();
        System.out.println("Numero da secao: ");
        int secaoEleitoral = teclado.nextInt();
        System.out.println("Eleitor Cadastrado com Sucesso.");
        ctrlEleitor.cadastraEleitor(tituloEleitoral, secaoEleitoral, nome, cidade);
        this.exibeEleitores();
        ctrlEleitor.exibeMenuPrincipal();
    }
 
    public void exibeEleitores() {
        for(Eleitor e : ctrlEleitor.getEleitores()){
            System.out.println("Eleitor: "+e.getNome());
        }
    }
    

    public void incluirSecao() {
        TelaCadastro telaCadastro = new TelaCadastro(ctrlCadastro);
        System.out.println("==== Cadastro de Seção ====");
        System.out.println("");
        System.out.println("Digite o numero da secao:");
        int numeroSecao = teclado.nextInt();
        System.out.println("Digite o nome da cidade: ");
        String cidade = teclado.next();
        
        ctrlEleitor.cadastraSecao(numeroSecao, cidade);
        
        ctrlEleitor.exibeMenuPrincipal();
    }
}
