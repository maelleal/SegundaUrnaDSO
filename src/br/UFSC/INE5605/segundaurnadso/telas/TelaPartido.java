/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
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
 * @author ismael
 */
public class TelaPartido extends JFrame {
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private TelaCadastro telaCadastro;
    private ControladorCadastro ctrlCadastro;
    private ControladorPartido ctrlPartido;
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomePartido;
    private JTextField pesquisaPartido;
    private JLabel txtNome;
    private JLabel txtPesquisaPartido;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(200, 60);

    public TelaPartido(ControladorPartido ctrlPartido) {
        super("Tela de Cadastro de Partido");
        this.ctrlPartido = ctrlPartido;
        this.botoes = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 10);
        Font fonte2 = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txtNome = new JLabel();
        txtNome.setText("Cadastrar Partido: ");
        txtNome.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 1;
        container.add(txtNome, constraints);
        
        nomePartido = new JTextField(10);
        nomePartido.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 2;
        container.add(nomePartido, constraints);
        
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_CADASTRAR);
        cadastrar.addActionListener(botoes);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 2;
        constraints.gridy = 3;
        container.add(cadastrar, constraints);
        
        txtPesquisaPartido = new JLabel();
        txtPesquisaPartido.setFont(fonte2);
        txtPesquisaPartido.setText("Pesquisar partido: ");
        constraints.gridx = 4;
	constraints.gridy = 1;
        container.add(txtPesquisaPartido, constraints);
        
        pesquisaPartido = new JTextField(10);
        pesquisaPartido.setFont(fonte2);
        constraints.gridx = 4;
	constraints.gridy = 2;
        container.add(pesquisaPartido, constraints);
        
        pesquisar = new JButton();
        pesquisar.setText("Pesquisar");
	pesquisar.setFont(fonte);
	pesquisar.setActionCommand(BOTAO_PESQUISAR);
	pesquisar.addActionListener(botoes);
	pesquisar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 4;
	constraints.gridy = 3;
	container.add(pesquisar, constraints);
        
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(botoes);
	voltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 3;
	constraints.gridy = 4;
	container.add(voltar, constraints);
       
        setSize(900, 600);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        this.ctrlPartido = ctrlPartido;
    }
    public class GerenciaBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            if(opcao.equals("")) {
                ctrlCadastro.executaCadastroEleitor();
                dispose();
            }
        }
    }
}
