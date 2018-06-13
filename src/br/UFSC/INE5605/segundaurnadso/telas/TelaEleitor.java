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
public class TelaEleitor extends JFrame {
    private static TelaEleitor instancia;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private ControladorEleitor ctrlEleitor;
    private TelaCadastro telaCadastro;
    private ControladorCadastro ctrlCadastro;
    private SecaoEleitoral secao;
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomeEleitor;
    private JTextField tituloEleitor;
    private JTextField pesquisaEleitor;
    private JLabel txtNomeEleitor;
    private JLabel txtPesquisaEleitor;
    private JTextField txtNome = new JTextField();
    private JTextField txtTitulo = new JTextField();
    private JTextField txtPesquisaTitulo = new JTextField();
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    public TelaEleitor () {
        super("Tela do Eleitor");
        this.ctrlEleitor = ctrlEleitor;
        Font fonte = new Font("Courier New", Font.BOLD, 10);
        Font fonte2 = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        /*
        cadastrar = new JButton();
        pesquisar = new JButton();
        voltar = new JButton();
        nomeEleitor = new JTextField();
        tituloEleitor = new JTextField();
        pesquisaTitulo = new JTextField("Pesquisa Eleitor");
        
        txtNome.setText("Insira o nome do Eleitor");
        txtTitulo.setText("Insira o Titulo de eleitor");       
        txtPesquisaTitulo.setText("Insira o Titulo de Eleitor para Pesquisa");
        
        container.add(cadastrar);
        container.add(pesquisar);
        container.add(voltar);
        container.add(nomeEleitor);
        container.add(tituloEleitor);
        container.add(pesquisaTitulo);
        container.add(txtNome);
        container.add(txtTitulo);
        container.add(txtPesquisaTitulo);
        */
        
        txtNomeEleitor = new JLabel();
        txtNomeEleitor.setText("Nome do Eleitor: ");
        txtNomeEleitor.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 0;
        container.add(txtNomeEleitor, constraints);
        
        nomeEleitor = new JTextField(10);
        nomeEleitor.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 1;
        container.add(nomeEleitor, constraints);
        
        JLabel txtCidadeEleitor = new JLabel();
        txtCidadeEleitor.setText("Cidade do Eleitor: ");
        txtCidadeEleitor.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 2;
        container.add(txtCidadeEleitor, constraints);
        
        JTextField cidadeEleitor = new JTextField(10);
        cidadeEleitor.setFont(fonte2);
        constraints.gridx = 2;
        constraints.gridy = 3;
        container.add(cidadeEleitor, constraints);
        
        JLabel txtTituloEleitor = new JLabel();
        txtTituloEleitor.setText("Numero do Titulo de Eleitor: ");
        txtTituloEleitor.setFont(fonte2);
        constraints.gridx = 2;
	constraints.gridy = 4;
        container.add(txtTituloEleitor, constraints);
        
        JTextField tituloEleitor = new JTextField(10);
        tituloEleitor.setFont(fonte2);
        constraints.gridx = 2;
        constraints.gridy = 5;
        container.add(tituloEleitor, constraints);
        
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_CADASTRAR);
        cadastrar.addActionListener(gerenciador);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 2;
        constraints.gridy = 6;
        container.add(cadastrar, constraints);
        
        txtPesquisaEleitor = new JLabel();
        txtPesquisaEleitor.setFont(fonte2);
        txtPesquisaEleitor.setText("Pesquisar Eleitor: ");
        constraints.gridx = 4;
	constraints.gridy = 1;
        container.add(txtPesquisaEleitor, constraints);
        
        pesquisaEleitor = new JTextField(10);
        pesquisaEleitor.setFont(fonte2);
        constraints.gridx = 4;
	constraints.gridy = 2;
        container.add(pesquisaEleitor, constraints);
        
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
	constraints.gridx = 3;
	constraints.gridy = 7;
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
                ctrlCadastro.executaCadastroCandidato();
                dispose();
            }
        }
    }

    public static TelaEleitor getInstancia(){
        if(instancia == null){
            instancia = new TelaEleitor();
        }
        return instancia;
    }
}



