/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.telas;

import br.UFSC.INE5605.urnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.urnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.urnaDSO.entidades.PartidoPolitico;
import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class TelaPartido {
    private TelaCadastro telaCadastro;
    private ControladorCadastro ctrlCadastro;
    private ControladorPartido ctrlPartido;
    private Scanner teclado;

    public TelaPartido(ControladorPartido ctrlPartido) {
        this.ctrlPartido = ctrlPartido;
        this.teclado = new Scanner(System.in);
    }

    
    public void adicionaPartido(){
        System.out.println("Partido Adicionado com Sucesso");
    }
    public void excluiPartido(){
        System.out.println("Partido Excluído com Sucesso");
    }
    public void partidoExistente(){
        System.out.println("Partido Existente");
    }
    public void partidoInexistente() {
        System.out.println("Partido Inexistente");
    }
    public void partidoTeste() {
        System.out.println("Partido Inexistente");
    }
    public void listaPartidos() {
        for (PartidoPolitico partido : ctrlPartido.getPartidos()) {
            System.out.println("Partidos Cadastrados: "+ partido.getPartido());
        }
    }
   

    public void exibeMenuPartido() {
        TelaCadastro telaCadastro = new TelaCadastro(ctrlCadastro);
        System.out.println("==== Cadastro de Partido ===="); 
        System.out.println(""); 
        System.out.println("Preencha os dados a seguir"); 
        System.out.println(""); 
        System.out.println("Nome do Partido: ");
        String nome = teclado.nextLine();
        ctrlPartido.incluiPartido(nome);
        this.adicionaPartido();
        this.listaPartidos();   

        ctrlPartido.exibeMenuPrincipal();

    }

    
}
