/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import java.util.Scanner;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import static br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPrincipal.OPCAO_SAIR;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class TelaUrna extends JFrame {
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
    public static final String OPCAO_VOLTAR = "C";
    public static final String OPCAO_SAIR = "D";    
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
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(180, 90);
    private Dimension tamanhoBotao2 = new Dimension(300, 200);
    
    
    public TelaUrna(ControladorUrna ctrlUrna){
        super("Tela Urna");
        this.ctrlUrna = ctrlUrna;
        this.botoes = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 50);
        Font fonte2 = new Font("Courier New", Font.BOLD, 30);
        Font fonte3 = new Font("Courier New", Font.BOLD, 30);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        botaoUm = new JButton();
        botaoUm.setText("1");
        botaoUm.setFont(fonte);
        botaoUm.setActionCommand(BOTAO_UM);
        botaoUm.addActionListener(botoes);
        botaoUm.setPreferredSize(tamanhoBotao);
        botaoUm.setBackground(Color.black);
        botaoUm.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 3;
	container.add(botaoUm, constraints);
        
        botaoDois = new JButton();
        botaoDois.setText("2");
        botaoDois.setFont(fonte);
        botaoDois.setActionCommand(BOTAO_DOIS);
        botaoDois.addActionListener(botoes);
        botaoDois.setPreferredSize(tamanhoBotao);
        botaoDois.setBackground(Color.black);
        botaoDois.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 3;
	container.add(botaoDois, constraints);
        
        botaoTres = new JButton();
        botaoTres.setText("3");
        botaoTres.setFont(fonte);
        botaoTres.setActionCommand(BOTAO_TRES);
        botaoTres.addActionListener(botoes);
        botaoTres.setPreferredSize(tamanhoBotao);
        botaoTres.setBackground(Color.black);
        botaoTres.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 3;
	container.add(botaoTres, constraints);
        
        botaoQuatro = new JButton();
        botaoQuatro.setText("4");
        botaoQuatro.setFont(fonte);
        botaoQuatro.setActionCommand(BOTAO_QUATRO);
        botaoQuatro.addActionListener(botoes);
        botaoQuatro.setPreferredSize(tamanhoBotao);
        botaoQuatro.setBackground(Color.black);
        botaoQuatro.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 4;
	container.add(botaoQuatro, constraints);
        
        botaoCinco = new JButton();
        botaoCinco.setText("5");
        botaoCinco.setFont(fonte);
        botaoCinco.setActionCommand(BOTAO_CINCO);
        botaoCinco.addActionListener(botoes);
        botaoCinco.setPreferredSize(tamanhoBotao);
        botaoCinco.setBackground(Color.black);
        botaoCinco.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 4;
	container.add(botaoCinco, constraints);
        
        botaoSeis = new JButton();
        botaoSeis.setText("6");
        botaoSeis.setFont(fonte);
        botaoSeis.setActionCommand(BOTAO_SEIS);
        botaoSeis.addActionListener(botoes);
        botaoSeis.setPreferredSize(tamanhoBotao);
        botaoSeis.setBackground(Color.black);
        botaoSeis.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 4;
	container.add(botaoSeis, constraints);
        
        botaoSete = new JButton();
        botaoSete.setText("7");
        botaoSete.setFont(fonte);
        botaoSete.setActionCommand(BOTAO_SETE);
        botaoSete.addActionListener(botoes);
        botaoSete.setPreferredSize(tamanhoBotao);
        botaoSete.setBackground(Color.black);
        botaoSete.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 5;
	container.add(botaoSete, constraints);
        
        botaoOito = new JButton();
        botaoOito.setText("8");
        botaoOito.setFont(fonte);
        botaoOito.setActionCommand(BOTAO_OITO);
        botaoOito.addActionListener(botoes);
        botaoOito.setPreferredSize(tamanhoBotao);
        botaoOito.setBackground(Color.black);
        botaoOito.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 5;
	container.add(botaoOito, constraints);
        
        botaoNove = new JButton();
        botaoNove.setText("9");
        botaoNove.setFont(fonte);
        botaoNove.setActionCommand(BOTAO_NOVE);
        botaoNove.addActionListener(botoes);
        botaoNove.setPreferredSize(tamanhoBotao);
        botaoNove.setBackground(Color.black);
        botaoNove.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 5;
	container.add(botaoNove, constraints);
        
        botaoZero = new JButton();
        botaoZero.setText("0");
        botaoZero.setFont(fonte);
        botaoZero.setActionCommand(BOTAO_ZERO);
        botaoZero.addActionListener(botoes);
        botaoZero.setPreferredSize(tamanhoBotao);
        botaoZero.setBackground(Color.black);
        botaoZero.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 6;
	container.add(botaoZero, constraints);
        
        botaoConfirma = new JButton();
        botaoConfirma.setText("CONFIRMA");
        botaoConfirma.setFont(fonte2);
        botaoConfirma.setActionCommand(OPCAO_CONFIRMA);
        botaoConfirma.addActionListener(botoes);
        botaoConfirma.setPreferredSize(tamanhoBotao);
        botaoConfirma.setBackground(Color.green);
	constraints.gridx = 3;
	constraints.gridy = 7;
	container.add(botaoConfirma, constraints);
        
        
        botaoVotarBranco = new JButton();
        botaoVotarBranco.setText("BRANCO");
        botaoVotarBranco.setFont(fonte2);
        botaoVotarBranco.setActionCommand(OPCAO_BRANCO);
        botaoVotarBranco.addActionListener(botoes);
        botaoVotarBranco.setPreferredSize(tamanhoBotao);
        botaoVotarBranco.setBackground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 7;
	container.add(botaoVotarBranco, constraints);
        
        botaoVoltar = new JButton();
        botaoVoltar.setText("CORRIGE");
        botaoVoltar.setFont(fonte2);
        botaoVoltar.setActionCommand(OPCAO_VOLTAR);
        botaoVoltar.addActionListener(botoes);
        botaoVoltar.setPreferredSize(tamanhoBotao);
        botaoVoltar.setBackground(Color.yellow);
	constraints.gridx = 2;
	constraints.gridy = 7;
	container.add(botaoVoltar, constraints);
        
        botaoSair = new JButton();
        botaoSair.setText("SAIR");
        botaoSair.setFont(fonte2);
        botaoSair.setActionCommand(OPCAO_SAIR);
        botaoSair.addActionListener(botoes);
        botaoSair.setPreferredSize(tamanhoBotao);
	constraints.gridx = 2;
	constraints.gridy = 8;
	container.add(botaoSair, constraints);
        
        txtNumeroCandidato = new JLabel();
        txtNumeroCandidato.setText("DIGITE O NUMERO DO CANDIDADTO");
        txtNumeroCandidato.setFont(fonte3);
	constraints.gridx = 2;
	constraints.gridy = 0;
	container.add(txtNumeroCandidato, constraints);
        
        numeroCandidato = new JTextField(2);
        //numeroCandidato.setText("Numero do Candidato");
        //numeroCandidato.setActionCommand();
        numeroCandidato.addActionListener(botoes);
        numeroCandidato.setFont(fonte);
        numeroCandidato.setPreferredSize(tamanhoBotao2);
	constraints.gridx = 0;
	constraints.gridy = 4;
	container.add(numeroCandidato, constraints);
        
        
        
        
        setSize (1400, 1200);
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
            
            break;
        case BOTAO_DOIS:
            
            break;
        case BOTAO_TRES:
            
            break;
        case BOTAO_QUATRO:
            
            break;
        case BOTAO_CINCO:
            
            break;
        case BOTAO_SEIS:
            
            break;
        case BOTAO_SETE:
            
            break;
        case BOTAO_OITO:
            
            break;
        case BOTAO_NOVE:
            
            break;
        case BOTAO_ZERO:
            
            break;
        case OPCAO_CONFIRMA:
            
            break;
        case OPCAO_BRANCO:
            
            break;
        case OPCAO_VOLTAR:
            
            break;
        case OPCAO_SAIR:
            JOptionPane.showMessageDialog(null, "Bye Bye!!");
            System.exit(0);
            break;
        default:
            break;
        }
        
        
    } 
}
    
}
/*
public void actionPerformed(ActionEvent e) {
			String opcao = e.getActionCommand();
			switch(opcao) {
			case "AlugaVeiculo":
				claviculario.abreTelaAlugaVeiculo();
				break;
			case "DevolveVeiculo":
				claviculario.abreTelaDevolveVeiculo();
				break;
			case "ListaEmprestimo":
				claviculario.abreTelaListaEmprestimo();
				break;
			case "ControleVeiculo":
				claviculario.getCtrlVeiculo().abreControleVeiculo();
				break;
			case "ControleFuncionario":
				claviculario.getCtrlFuncionario().inicia();
				break;
			case "ListaLogs":
				claviculario.getCtrlLogs().inicia();
				break;
			default:
				break;
			}
		}
*/