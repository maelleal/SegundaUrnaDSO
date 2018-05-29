/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPrincipal;
import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class TelaPrincipal {
    
    private ControladorPrincipal ctrlPrincipal;
    private Scanner teclado;

    public TelaPrincipal(ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.teclado = new Scanner(System.in);
    }
    
    public void exibeMenuPrincipal() {
        System.out.println("==== URNA ELETRONICA ====");
        System.out.println("");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Votacao");
        System.out.println("3 - Resultado");
        System.out.println();
        System.out.println("Escolha a opcao: ");
        
        int opcao = teclado.nextInt();
        
        ctrlPrincipal.executaOpcao(opcao);
    }
    public void mensagemFim() {
        System.out.println("Encerrando Sistema...");
        System.out.println("");
        System.out.println("Sistema Encerrado.");
        
        System.exit(0);
    }
    
}
        /*
        int var = teclado.nextInt();
        
        switch(var){
            case 1: 
                ctrlPrincipal.iniciarCadastro();
                break;
            case 2: 
                ctrlPrincipal.iniciarVotacao();
                break;
            case 3: 
                ctrlPrincipal.exibeResultado();
        }
    }
    
    
}
*/