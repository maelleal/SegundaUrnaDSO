/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPrincipal;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorUrna;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class TelaPrincipal extends JFrame{
    
    
    public static final String OPCAO_CADASTRO = "1";
    public static final String OPCAO_VOTACAO = "2";
    public static final String OPCAO_RESULTADOS = "3";
    public static final String OPCAO_SAIR = "4";
    private JButton cadastros;
    private JButton votacao;
    private JButton resultado;
    private JButton sair;
    private JLabel txt;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    
    public TelaPrincipal(ControladorPrincipal ctrlPrincipal) {
        super("Tela Principal");
        this.botoes = new GerenciaBotoes();
        
              
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txt = new JLabel();
        txt.setText("Escolha uma das Opções:       ");
        constraints.gridx = 0;
	constraints.gridy = 0;
        container.add(txt, constraints);
        
        sair = new JButton();
        sair.setText("Sair");
        sair.setActionCommand(OPCAO_SAIR);
        sair.setPreferredSize(tamanhoBotao);
        sair.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 2;
        container.add(sair, constraints);
        
        cadastros = new JButton();
        cadastros.setText("Cadastros");
	cadastros.setActionCommand(OPCAO_CADASTRO);
	cadastros.setPreferredSize(tamanhoBotao);
        cadastros.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 4;
        container.add(cadastros, constraints);
	
		
        votacao = new JButton();
        votacao.setText("Votação");
        votacao.setActionCommand(OPCAO_VOTACAO);
        votacao.setPreferredSize(tamanhoBotao);
        votacao.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 6;
        container.add(votacao, constraints);
        
        
        resultado = new JButton();
        resultado.setText("Resultado do Pleito");
        resultado.setActionCommand(OPCAO_RESULTADOS);
        resultado.setPreferredSize(tamanhoBotao);
        resultado.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 8;
        container.add(resultado, constraints);
    
        setSize (300, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
        
    }
public class GerenciaBotoes implements ActionListener {
       
    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcao = evento.getActionCommand();
        if(opcao.equals(OPCAO_CADASTRO)) {
            ControladorPrincipal.getInstancia().abreTelaCadastro();
            dispose();
        }
        if(opcao.equals(OPCAO_VOTACAO)) {
            ControladorUrna.getInstancia().abreTelaUrna();
            dispose();
        }
        if(opcao.equals(OPCAO_RESULTADOS)) {
            ControladorUrna.getInstancia().resultadoGov();
            dispose();
        }
        if(opcao.equals(OPCAO_SAIR)) {
            JOptionPane.showMessageDialog(null, "By By!!");
            System.exit(0);
        }
        
        
    } 
}
   
    
        
       
}
