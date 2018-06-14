/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.telas;

import javax.swing.JFrame;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.segundaurnadso.entidades.EleitorDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ismael
 */
public class TelaCadastraEleitor extends JFrame {
    private static TelaCadastraEleitor instancia;
    private EleitorDAO eleitorDAO;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomeEleitor;
    private JTextField tituloEleitor;
    private JTextField pesquisaEleitor;
    private JLabel txtNomeEleitor;
    private JLabel txtPesquisaEleitor;
    private JTable tabelaEleitores;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(280, 80);

    private TelaCadastraEleitor() {
        super("Tela do Eleitor");
        Font fonte2 = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
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
        cadastrar.setFont(fonte2);
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
	pesquisar.setFont(fonte2);
	pesquisar.setActionCommand(BOTAO_PESQUISAR);
	pesquisar.addActionListener(gerenciador);
	pesquisar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 4;
	constraints.gridy = 3;
	container.add(pesquisar, constraints);
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte2);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(gerenciador);
	voltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 3;
	constraints.gridy = 7;
	container.add(voltar, constraints);
        
        tabelaEleitores = new JTable();
        tabelaEleitores.setPreferredScrollableViewportSize(new Dimension(150,100));
        tabelaEleitores.setFillsViewportHeight(true);
        constraints.fill = GridBagConstraints.WEST;
        constraints.gridheight = 3;
        constraints.gridwidth = 3;
        constraints.gridx = 6;
        constraints.gridy = 2;
        JScrollPane rolagem = new JScrollPane(tabelaEleitores);
        container.add(rolagem, constraints);
       
        setSize(400, 500);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    /*
    private void updateData(){
        DefaultTableModel modelTbItens = new DefaultTableModel();
        modelTbItens.addColumn("Numero do Titulo");
        modelTbItens.addColumn("Nome");
        modelTbItens.addColumn("Cidade");
        
        for (Eleitor eleitor : eleitorDAO.getList()){
            modelTbItens.addRow(new Object[]{eleitor.getTituloEleitoral(), eleitor.getSecaoEleitoral(),
                eleitor.getNome(), eleitor.getCidade});
        }
        tabelaEleitores.setModel(modelTbItens);
        this.repaint();
        
    }
    */
    public class GerenciaBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            if(opcao.equals(BOTAO_CADASTRAR)) {
                ControladorCadastro.getInstancia().executaCadastroCandidato();
                dispose();
            }
            if(opcao.equals(BOTAO_PESQUISAR)) {
                ControladorCadastro.getInstancia().executaCadastroCandidato();
                dispose();
            }
            if(opcao.equals(BOTAO_VOLTAR)) {
                ControladorCandidato.getInstancia().exibeMenuPrincipal();
                dispose();
            }
        }
    }

    public static TelaCadastraEleitor getInstancia(){
        if(instancia == null){
            instancia = new TelaCadastraEleitor();
        }
        return instancia;
    }
    
    
}
