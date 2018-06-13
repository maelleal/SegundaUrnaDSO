/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author Ismael
 */
public class TelaCandidato extends javax.swing.JFrame {
    private static TelaCandidato instancia;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomeCandidato;
    private JTextField txtNumero;
    private JTextField partidoCandidato;
    private JComboBox partidos;
    private JButton botaoOk;
    private JLabel txtNomeCandidato;
    private JLabel txtPartidoCandidato;
    private JLabel txt;
    private JTextField pesquisaCandidato;
    private JLabel txtPesquisaCandidato;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    
    private TelaCandidato (){
        super ("Tela de Candidato");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 10);
        Font fonte2 = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        /*
        txt = new JLabel();
        txtNomeCandidato = new JTextField();
        txtNumero = new JTextField();
        botaoOk = new JButton();
        //partidos = new JComboBox((ComboBoxModel) ctrlPartido.getPartidos());
                
        txt.setText("Insira os dados do Candidato");
        txtNome.setText("Nome");
        txtNumero.setText("Numero");
        //partidos.setText("Escolha um Partido");
        botaoOk.setText("Cadastrar");
        
        container.add(txt);
        container.add(txtNome);
        container.add(txtNumero);
        container.add(botaoOk);
        //container.add(partidos);
        */
        txtNomeCandidato = new JLabel();
        txtNomeCandidato.setText("Nome do Candidato: ");
        txtNomeCandidato.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 0;
        container.add(txtNomeCandidato, constraints);
        
        nomeCandidato = new JTextField(10);
        nomeCandidato.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 1;
        container.add(nomeCandidato, constraints);
        
        txtPartidoCandidato = new JLabel();
        txtPartidoCandidato.setText("Partido do Candidato: ");
        txtPartidoCandidato.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 2;
        container.add(txtPartidoCandidato, constraints);
        
        partidoCandidato = new JTextField(10);
        partidoCandidato.setFont(fonte2);
        constraints.gridx = 2;
        constraints.gridy = 3;
        container.add(partidoCandidato, constraints);
        
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_CADASTRAR);
        cadastrar.addActionListener(gerenciador);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(cadastrar, constraints);
        
        txtPesquisaCandidato = new JLabel();
        txtPesquisaCandidato.setFont(fonte2);
        txtPesquisaCandidato.setText("Pesquisar Candidato: ");
        constraints.gridx = 4;
	constraints.gridy = 1;
        container.add(txtPesquisaCandidato, constraints);
        
        pesquisaCandidato = new JTextField(10);
        pesquisaCandidato.setFont(fonte2);
        constraints.gridx = 4;
	constraints.gridy = 2;
        container.add(pesquisaCandidato, constraints);
        
        pesquisar = new JButton();
        pesquisar.setText("Pesquisar");
	pesquisar.setFont(fonte);
	pesquisar.setActionCommand(BOTAO_PESQUISAR);
	pesquisar.addActionListener(gerenciador);
	pesquisar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 4;
	constraints.gridy = 3;
	container.add(pesquisar, constraints);
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(gerenciador);
	voltar.setPreferredSize(tamanhoBotao);
        //constraints.ipady = 2;
        //constraints.weightx = 0.0;
        //constraints.gridwidth = 3;
	constraints.gridx = 3;
	constraints.gridy = 5;
	container.add(voltar, constraints);
       
        setSize(900, 600);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    
    public class GerenciaBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            if(opcao.equals("")) {
                ControladorCadastro.getInstancia().executaCadastroCandidato();
                dispose();
            }
        }
    }
    
    public static TelaCandidato getInstancia(){
        if(instancia == null){
            instancia = new TelaCandidato();
        }
        return instancia;
    }

}
