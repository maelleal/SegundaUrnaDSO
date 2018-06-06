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
public class TelaUrna extends JFrame {
    public static final String OPCAO_CONFIRMA = "1";
    public static final String OPCAO_BRANCO = "2";
    public static final String OPCAO_VOLTAR = "3";
    public static final String OPCAO_SAIR = "4";    
    private ControladorUrna ctrlUrna;
    private JButton botaoConfirma;
    private JButton botaoVotarBranco;
    private JButton botaoVoltar;
    private JButton botaoSair;
    private JTextField numeroCandidato;
    private JLabel txtNumeroCandidato;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    
    public TelaUrna(ControladorUrna ctrlUrna){
        super("Tela Urna");
        this.ctrlUrna = ctrlUrna;
        this.botoes = new GerenciaBotoes();
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        botaoConfirma = new JButton();
        botaoConfirma.setText("CONFIRMA");
        botaoConfirma.setActionCommand(OPCAO_CONFIRMA);
        botaoConfirma.addActionListener(botoes);
        botaoConfirma.setPreferredSize(tamanhoBotao);
	constraints.gridx = 2;
	constraints.gridy = 3;
	container.add(botaoConfirma, constraints);
        
        
        botaoVotarBranco = new JButton();
        botaoVotarBranco.setText("BRANCO");
        botaoVotarBranco.setActionCommand(OPCAO_BRANCO);
        botaoVotarBranco.addActionListener(botoes);
        botaoVotarBranco.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 2;
	container.add(botaoVotarBranco, constraints);
        
        botaoVoltar = new JButton();
        botaoVoltar.setText("Voltar");
        botaoVoltar.setActionCommand(OPCAO_VOLTAR);
        botaoVoltar.addActionListener(botoes);
        botaoVoltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 3;
	container.add(botaoVoltar, constraints);
        
        botaoSair = new JButton();
        botaoSair.setText("Sair");
        botaoSair.setActionCommand(OPCAO_SAIR);
        botaoSair.addActionListener(botoes);
        botaoSair.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 4;
	container.add(botaoSair, constraints);
        
        txtNumeroCandidato = new JLabel();
        txtNumeroCandidato.setText("Digite o Numero do Candidato");
	constraints.gridx = 2;
	constraints.gridy = 1;
	container.add(txtNumeroCandidato, constraints);
        
        numeroCandidato = new JTextField();
        //numeroCandidato.setText("Numero do Candidato");
        //numeroCandidato.setActionCommand();
        numeroCandidato.addActionListener(botoes);
        numeroCandidato.setPreferredSize(tamanhoBotao);
	constraints.gridx = 2;
	constraints.gridy = 2;
	container.add(numeroCandidato, constraints);
        
        
        setSize (700, 400);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
        
       
    }
    public class GerenciaBotoes implements ActionListener {
       
    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcao = evento.getActionCommand();
        if(opcao.equals(OPCAO_CONFIRMA)) {
            
            dispose();
        }
        if(opcao.equals(OPCAO_BRANCO)) {
            
            dispose();
        }
        if(opcao.equals(OPCAO_VOLTAR)) {
            
            dispose();
        }
        if(opcao.equals(OPCAO_SAIR)) {
            JOptionPane.showMessageDialog(null, "By By!!");
            System.exit(0);
        }
        
        
    } 
}
    
}
