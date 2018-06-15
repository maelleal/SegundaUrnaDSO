/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPrincipal;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Ismael
 */
public class TelaUrna extends JFrame {
    private static TelaUrna instancia;
    private Candidato candidato;
    public static final String	BOTAO_UM = "1";
    public static final String	BOTAO_DOIS = "2";
    public static final String	BOTAO_TRES = "3";
    public static final String	BOTAO_QUATRO = "4";
    public static final String	BOTAO_CINCO = "5";
    public static final String	BOTAO_SEIS = "6";
    public static final String	BOTAO_SETE = "7";
    public static final String	BOTAO_OITO = "8";
    public static final String	BOTAO_NOVE = "9";
    public static final String	BOTAO_ZERO = "0";
    public static final String OPCAO_ESCOLHIDA = "";
    public static final String OPCAO_CONFIRMA = "A";
    public static final String OPCAO_BRANCO = "B";
    public static final String OPCAO_CORRIGE = "C";
    public static final String OPCAO_VOLTAR = "D";    
    private ControladorUrna ctrlUrna;
    private JButton botaoConfirma;
    private JButton botaoVotarBranco;
    private JButton botaoVoltar;
    private JButton botaoSair;
    private JButton botaoUm;
    private JButton botaoDois;
    private JButton botaoTres;
    private JButton botaoQuatro;
    private JButton botaoCinco;
    private JButton botaoSeis;
    private JButton botaoSete;
    private JButton botaoOito;
    private JButton botaoNove;
    private JButton botaoZero;
    private JTextField numeroCandidato;
    private JLabel txtNumeroCandidato;
    private JLabel txtCandidatoEscolhido;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(100, 30);
    private Dimension tamanhoBotao2 = new Dimension(100, 30);
    
    
    //adicionar dois paineis dentre de um painel
    
    private TelaUrna(){
        super("Tela Urna");
        this.ctrlUrna = ctrlUrna;
        this.botoes = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 35);
        Font fonte2 = new Font("Courier New", Font.BOLD, 15);
        
        JPanel containerPrincipal = new JPanel();
        containerPrincipal.setLayout(new GridBagLayout());
        containerPrincipal.setSize(820, 720);
        GridBagConstraints constraints = new GridBagConstraints();
        
        JPanel containerTeclado = new JPanel();
        containerTeclado.setSize(400, 350);
        containerTeclado.setLayout(new GridBagLayout());
        
        JPanel containerVisor = new JPanel();
        containerVisor.setSize(400, 350);
        containerVisor.setLayout(new GridBagLayout());
        
        getContentPane().add( containerTeclado, BorderLayout.EAST );
	getContentPane().add( containerVisor, BorderLayout.WEST );
        
        
        botaoUm = new JButton();
        botaoUm.setText("1");
        botaoUm.setActionCommand(BOTAO_UM);
        botaoUm.addActionListener(botoes);
        botaoUm.setPreferredSize(tamanhoBotao);
        botaoUm.setBackground(Color.black);
        botaoUm.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 4;
	containerTeclado.add(botaoUm, constraints);
        
        botaoDois = new JButton();
        botaoDois.setText("2");
        botaoDois.setActionCommand(BOTAO_DOIS);
        botaoDois.addActionListener(botoes);
        botaoDois.setPreferredSize(tamanhoBotao);
        botaoDois.setBackground(Color.black);
        botaoDois.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 4;
	containerTeclado.add(botaoDois, constraints);
        
        botaoTres = new JButton();
        botaoTres.setText("3");
        botaoTres.setActionCommand(BOTAO_TRES);
        botaoTres.addActionListener(botoes);
        botaoTres.setPreferredSize(tamanhoBotao);
        botaoTres.setBackground(Color.black);
        botaoTres.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 4;
	containerTeclado.add(botaoTres, constraints);
        
        botaoQuatro = new JButton();
        botaoQuatro.setText("4");
        botaoQuatro.setActionCommand(BOTAO_QUATRO);
        botaoQuatro.addActionListener(botoes);
        botaoQuatro.setPreferredSize(tamanhoBotao);
        botaoQuatro.setBackground(Color.black);
        botaoQuatro.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 5;
	containerTeclado.add(botaoQuatro, constraints);
        
        botaoCinco = new JButton();
        botaoCinco.setText("5");
        botaoCinco.setActionCommand(BOTAO_CINCO);
        botaoCinco.addActionListener(botoes);
        botaoCinco.setPreferredSize(tamanhoBotao);
        botaoCinco.setBackground(Color.black);
        botaoCinco.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 5;
	containerTeclado.add(botaoCinco, constraints);
        
        botaoSeis = new JButton();
        botaoSeis.setText("6");
        botaoSeis.setActionCommand(BOTAO_SEIS);
        botaoSeis.addActionListener(botoes);
        botaoSeis.setPreferredSize(tamanhoBotao);
        botaoSeis.setBackground(Color.black);
        botaoSeis.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 5;
	containerTeclado.add(botaoSeis, constraints);
        
        botaoSete = new JButton();
        botaoSete.setText("7");
        botaoSete.setActionCommand(BOTAO_SETE);
        botaoSete.addActionListener(botoes);
        botaoSete.setPreferredSize(tamanhoBotao);
        botaoSete.setBackground(Color.black);
        botaoSete.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 6;
	containerTeclado.add(botaoSete, constraints);
        
        botaoOito = new JButton();
        botaoOito.setText("8");
        botaoOito.setActionCommand(BOTAO_OITO);
        botaoOito.addActionListener(botoes);
        botaoOito.setPreferredSize(tamanhoBotao);
        botaoOito.setBackground(Color.black);
        botaoOito.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 6;
	containerTeclado.add(botaoOito, constraints);
        
        botaoNove = new JButton();
        botaoNove.setText("9");
        botaoNove.setActionCommand(BOTAO_NOVE);
        botaoNove.addActionListener(botoes);
        botaoNove.setPreferredSize(tamanhoBotao);
        botaoNove.setBackground(Color.black);
        botaoNove.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 6;
	containerTeclado.add(botaoNove, constraints);
        
        botaoZero = new JButton();
        botaoZero.setText("0");
        botaoZero.setActionCommand(BOTAO_ZERO);
        botaoZero.addActionListener(botoes);
        botaoZero.setPreferredSize(tamanhoBotao);
        botaoZero.setBackground(Color.black);
        botaoZero.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 7;
	containerTeclado.add(botaoZero, constraints);
        
        botaoConfirma = new JButton();
        botaoConfirma.setText("CONFIRMA");
        botaoConfirma.setActionCommand(OPCAO_CONFIRMA);
        botaoConfirma.addActionListener(botoes);
        botaoConfirma.setPreferredSize(tamanhoBotao);
        botaoConfirma.setBackground(Color.green);
	constraints.gridx = 3;
	constraints.gridy = 8;
	containerTeclado.add(botaoConfirma, constraints);
        
        
        botaoVotarBranco = new JButton();
        botaoVotarBranco.setText("BRANCO");
        botaoVotarBranco.setActionCommand(OPCAO_BRANCO);
        botaoVotarBranco.addActionListener(botoes);
        botaoVotarBranco.setPreferredSize(tamanhoBotao);
        botaoVotarBranco.setBackground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 8;
	containerTeclado.add(botaoVotarBranco, constraints);
        
        botaoVoltar = new JButton();
        botaoVoltar.setText("CORRIGE");
        botaoVoltar.setActionCommand(OPCAO_CORRIGE);
        botaoVoltar.addActionListener(botoes);
        botaoVoltar.setPreferredSize(tamanhoBotao);
        botaoVoltar.setBackground(Color.yellow);
	constraints.gridx = 2;
	constraints.gridy = 8;
	containerTeclado.add(botaoVoltar, constraints);
        
        botaoSair = new JButton();
        botaoSair.setText("SAIR");
        botaoSair.setActionCommand(OPCAO_VOLTAR);
        botaoSair.addActionListener(botoes);
        botaoSair.setPreferredSize(tamanhoBotao);
	constraints.gridx = 2;
	constraints.gridy = 9;
	containerTeclado.add(botaoSair, constraints);
        
        txtNumeroCandidato = new JLabel();
        txtNumeroCandidato.setFont(fonte2);
        txtNumeroCandidato.setText("DIGITE O NUMERO DO CANDIDADTO");
	constraints.gridx = 2;
	constraints.gridy = 0;
	containerTeclado.add(txtNumeroCandidato, constraints);
        
        txtCandidatoEscolhido = new JLabel();
        txtCandidatoEscolhido.setFont(fonte);
        txtCandidatoEscolhido.setText("");
        constraints.gridheight = 10;
        constraints.gridwidth = 10;
	constraints.gridx = 2;
	constraints.gridy = 0;
        getContentPane().add( txtCandidatoEscolhido, BorderLayout.CENTER );
        
        numeroCandidato = new JTextField(15);
        numeroCandidato.addActionListener(botoes);
        numeroCandidato.setPreferredSize(tamanhoBotao);
        constraints.gridheight = 2;
        constraints.gridwidth = 6;
       	constraints.gridx = 1;
	constraints.gridy = 1;
	containerTeclado.add(numeroCandidato, constraints);
        
        
        
        
        
        setSize (840, 740);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
        
       
    }
    public class GerenciaBotoes implements ActionListener {
       
    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcao = evento.getActionCommand();
        switch(opcao) {
        case BOTAO_UM:
            numeroCandidato.setText(numeroCandidato.getText()+"1");
            break;
        case BOTAO_DOIS:
            numeroCandidato.setText(numeroCandidato.getText()+"2");
            break;
        case BOTAO_TRES:
            numeroCandidato.setText(numeroCandidato.getText()+"3");
            break;
        case BOTAO_QUATRO:
            numeroCandidato.setText(numeroCandidato.getText()+"4");
            break;
        case BOTAO_CINCO:
            numeroCandidato.setText(numeroCandidato.getText()+"5");
            break;
        case BOTAO_SEIS:
            numeroCandidato.setText(numeroCandidato.getText()+"6");
            break;
        case BOTAO_SETE:
            numeroCandidato.setText(numeroCandidato.getText()+"7");
            break;
        case BOTAO_OITO:
            numeroCandidato.setText(numeroCandidato.getText()+"8");
            break;
        case BOTAO_NOVE:
            numeroCandidato.setText(numeroCandidato.getText()+"9");
            break;
        case BOTAO_ZERO:
            numeroCandidato.setText(numeroCandidato.getText()+"0");
            break;
        case OPCAO_CONFIRMA:
            //containerVisor.add(txtNumeroCandidato, constraints);
            break;
        case OPCAO_BRANCO:
            
            break;
        case OPCAO_CORRIGE:
            numeroCandidato.setText("");
            break;
        case OPCAO_VOLTAR:
            ControladorPrincipal.getInstancia().abreTelaPrincipal();
            dispose();
            break;
        default:
            break;
            
        
    
        }
        
        
    }
    
}
    
    public static TelaUrna getInstancia(){
        if(instancia == null){
            instancia = new TelaUrna();
        }
        return instancia;
    }
    
}
