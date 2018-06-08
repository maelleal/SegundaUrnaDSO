/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Eleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.SecaoEleitoral;
import br.UFSC.INE5605.SegundaUrnaDSO.interfaces.IEleitor;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Scanner;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author Ismael
 */
public class TelaEleitor extends JFrame {
    private ControladorEleitor ctrlEleitor;
    private TelaCadastro telaCadastro;
    private ControladorCadastro ctrlCadastro;
    private SecaoEleitoral secao;
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomeEleitor;
    private JTextField tituloEleitor;
    private JTextField pesquisaTitulo;
    private JLabel txtNome;
    private JLabel txtTitulo;
    private JLabel txtPesquisaTitulo;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    public TelaEleitor (ControladorEleitor ctrlEleitor) {
        super("Tela do Eleitor");
        this.ctrlEleitor = ctrlEleitor;
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txtNome = new JLabel();
        txtNome.setText("Insira o nome do Eleitor");
        
        
        
        
        cadastrar = new JButton();
        pesquisar = new JButton();
        voltar = new JButton();
        nomeEleitor = new JTextField();
        tituloEleitor = new JTextField();
        pesquisaTitulo = new JTextField("Pesquisa Eleitor");
        
        
        txtTitulo.setText("Insira o Titulo de eleitor");       
        txtPesquisaTitulo.setText("Insira o Titulo de Eleitor para Pesquisa");
        
        
        setSize (300, 600);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
    }

   
    public void exibeMenuEleitores() {
        
    }
 /*
    public void exibeEleitores() {
        for(Eleitor e : ctrlEleitor.getEleitores()){
            System.out.println("Eleitor: "+e.getNome());
        }
    }
    

    public void incluirSecao() {
        //TelaCadastro telaCadastro = new TelaCadastro(ctrlCadastro);
        System.out.println("==== Cadastro de Seção ====");
        System.out.println("");
        System.out.println("Digite o numero da secao:");
        int numeroSecao = teclado.nextInt();
        System.out.println("Digite o nome da cidade: ");
        String cidade = teclado.next();
        
        ctrlEleitor.cadastraSecao(numeroSecao, cidade);
        
        ctrlEleitor.exibeMenuPrincipal();
    }
*/
}
