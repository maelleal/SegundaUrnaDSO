/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public static final String OPCAO_VOLTAR = "4";
    private JButton botaoEleitor;
    private JButton botaoPartido;
    private JButton botaoCandidato;
    private JButton botaoSair;
    private JLabel txt;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(280, 80);

    private TelaCadastro() {
        super("Tela de Cadastros");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 17);
        
        GridBagConstraints constraints = new GridBagConstraints();
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        txt = new JLabel();
        txt.setText("Escolha uma das Opções:");
        txt.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 0;
	container.add(txt, constraints);
        
       
        botaoSair = new JButton();
        botaoSair.setText("VOLTAR");
        botaoSair.setFont(fonte);
        botaoSair.addActionListener(gerenciador);
        botaoSair.setActionCommand(OPCAO_VOLTAR);
        botaoSair.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 5;
	container.add(botaoSair, constraints);
        
        botaoEleitor = new JButton();
        botaoEleitor.setText("Cadastro de Eleitores");
        botaoEleitor.setFont(fonte);
        botaoEleitor.addActionListener(gerenciador);
        botaoEleitor.setActionCommand(OPCAO_ELEITOR);
        botaoEleitor.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 1;
	container.add(botaoEleitor, constraints);
        
        botaoPartido = new JButton();
        botaoPartido.setText("Cadastro de Partidos");
        botaoPartido.setFont(fonte);
        botaoPartido.addActionListener(gerenciador);
        botaoPartido.setActionCommand(OPCAO_PARTIDO);
        botaoPartido.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 2;
	container.add(botaoPartido, constraints);
        
        botaoCandidato = new JButton();
        botaoCandidato.setText("Cadastro de Candidatos");
        botaoCandidato.setFont(fonte);
        botaoCandidato.addActionListener(gerenciador);
        botaoCandidato.setActionCommand(OPCAO_CANDIDATO);
        botaoCandidato.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 3;
	container.add(botaoCandidato, constraints);
        
        setSize (400, 500);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
    }
    public class GerenciaBotoes implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            if(opcao.equals(OPCAO_ELEITOR)) {
                ControladorCadastro.getInstancia().executaTelaEleitor();
                dispose();
            }
            if(opcao.equals(OPCAO_PARTIDO)) {
                ControladorCadastro.getInstancia().executaTelaPartido();
                dispose();
            }
            if(opcao.equals(OPCAO_CANDIDATO)) {
                ControladorCadastro.getInstancia().executaTelaCandidato();
                dispose();
            }
            if(opcao.equals(OPCAO_VOLTAR)) {
                TelaPrincipal.getInstancia().setVisible(true);
                dispose();
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

    