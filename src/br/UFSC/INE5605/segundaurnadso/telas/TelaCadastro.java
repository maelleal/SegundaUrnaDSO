/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class TelaCadastro extends JFrame {
    private static TelaCadastro instancia;
    
    public static final String OPCAO_ELEITOR = "1";
    public static final String OPCAO_PARTIDO = "2";
    public static final String OPCAO_CANDIDATO = "3";
    public static final String OPCAO_SAIR = "4";
    
    //private ControladorEleitor ctrlEleitor;
    //private ControladorCandidato ctrlCandidato;
    private JButton botaoEleitor;
    private JButton botaoPartido;
    private JButton botaoCandidato;
    private JButton botaoSair;
    private JLabel txt;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    private Dimension tamanhoBotao2 = new Dimension(400, 60);

    private TelaCadastro() {
        super("Tela de Cadastros");
        this.gerenciador = new GerenciaBotoes();
        GridBagConstraints constraints = new GridBagConstraints();
        
        //texto dentro da tela
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        txt = new JLabel();
        txt.setText("Escolha uma das Opções:");
        constraints.gridx = 0;
	constraints.gridy = 0;
	container.add(txt, constraints);
        
       
        botaoSair = new JButton();
        botaoSair.setText("Sair");
        botaoSair.addActionListener(gerenciador);
        botaoSair.setActionCommand(OPCAO_SAIR);
        botaoSair.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 2;
	container.add(botaoSair, constraints);
        
        botaoEleitor = new JButton();
        botaoEleitor.setText("Cadastro de Eleitores");
        botaoEleitor.addActionListener(gerenciador);
        botaoEleitor.setActionCommand(OPCAO_ELEITOR);
        botaoEleitor.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 4;
	container.add(botaoEleitor, constraints);
        
        botaoPartido = new JButton();
        botaoPartido.setText("Cadastro de Partidos");
        botaoPartido.addActionListener(gerenciador);
        botaoPartido.setActionCommand(OPCAO_PARTIDO);
        botaoPartido.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 6;
	container.add(botaoPartido, constraints);
        
        botaoCandidato = new JButton();
        botaoCandidato.setText("Cadastro de Candidatos");
        botaoCandidato.addActionListener(gerenciador);
        botaoCandidato.setActionCommand(OPCAO_CANDIDATO);
        botaoCandidato.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 8;
	container.add(botaoCandidato, constraints);
        
        setSize (300, 500);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
    }
public class GerenciaBotoes implements ActionListener {
       
    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcao = evento.getActionCommand();
        if(opcao.equals(OPCAO_ELEITOR)) {
            ControladorCadastro.getInstancia().executaCadastroEleitor();
            dispose();
        }
        if(opcao.equals(OPCAO_PARTIDO)) {
            ControladorCadastro.getInstancia().executaCadastroPartido();
            dispose();
        }
        if(opcao.equals(OPCAO_CANDIDATO)) {
            ControladorCadastro.getInstancia().executaCadastroCandidato();
            dispose();
        }
        if(opcao.equals(OPCAO_SAIR)) {
            JOptionPane.showMessageDialog(null, "By By!!");
            System.exit(0);
        }
    }
    
    
}
    
    public static TelaCadastro getInstancia() {
        if(instancia == null){
            instancia = new TelaCadastro();
        }
        return instancia;
    }
}

    