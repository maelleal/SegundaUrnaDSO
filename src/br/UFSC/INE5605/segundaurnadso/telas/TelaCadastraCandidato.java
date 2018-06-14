/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.segundaurnadso.entidades.CandidatoDAO;
import br.UFSC.INE5605.segundaurnadso.entidades.PartidoPoliticoDAO;
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
public class TelaCadastraCandidato extends JFrame {
    private static TelaCadastraCandidato instancia;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomeCandidato;
    private JTextField numeroCandidato;
    private JComboBox<PartidoPoliticoDAO> partidoCandidato;
    private JTable tabelaCandidatos;
    private JLabel txtNomeCandidato;
    private JLabel txtPartidoCandidato;
    private JLabel txtNumeroCandidato;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(200, 60);

    private TelaCadastraCandidato() {
        super ("Tela de Candidato");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txtNomeCandidato = new JLabel();
        txtNomeCandidato.setText("Nome do Candidato: ");
        txtNomeCandidato.setFont(fonte);
        constraints.gridx = 2;
	constraints.gridy = 0;
        container.add(txtNomeCandidato, constraints);
        
        nomeCandidato = new JTextField(10);
        nomeCandidato.setFont(fonte);
        constraints.gridx = 2;
	constraints.gridy = 1;
        container.add(nomeCandidato, constraints);
        
        txtPartidoCandidato = new JLabel();
        txtPartidoCandidato.setText("Partido do Candidato: ");
        txtPartidoCandidato.setFont(fonte);
        constraints.gridx = 2;
	constraints.gridy = 2;
        container.add(txtPartidoCandidato, constraints);
        
        partidoCandidato = new JComboBox();
        constraints.gridx = 2;
        constraints.gridy = 3;
        container.add(partidoCandidato, constraints);
        
        txtNumeroCandidato = new JLabel();
        txtNumeroCandidato.setText("Numero do Candidato: ");
        txtNumeroCandidato.setFont(fonte);
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(txtNumeroCandidato, constraints);
        
        numeroCandidato = new JTextField(2);
        numeroCandidato.setFont(fonte);
        constraints.gridx = 2;
        constraints.gridy = 5;
        container.add(numeroCandidato, constraints);
        
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_CADASTRAR);
        cadastrar.addActionListener(gerenciador);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 2;
        constraints.gridy = 6;
        container.add(cadastrar, constraints);
        
        pesquisar = new JButton();
        pesquisar.setText("Pesquisar");
	pesquisar.setFont(fonte);
	pesquisar.setActionCommand(BOTAO_PESQUISAR);
	pesquisar.addActionListener(gerenciador);
	pesquisar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 6;
	constraints.gridy = 6;
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
        
        tabelaCandidatos = new JTable();
        tabelaCandidatos.setPreferredScrollableViewportSize(new Dimension(150, 100));
        tabelaCandidatos.setFillsViewportHeight(true);
        constraints.fill = GridBagConstraints.WEST;
        constraints.gridheight = 3;
        constraints.gridwidth = 3;
        constraints.gridx = 6;
        constraints.gridy = 2;
        JScrollPane rolagem = new JScrollPane(tabelaCandidatos);
        container.add(rolagem, constraints);
        
       
        setSize(400, 500);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    
    private void updateData(){
        DefaultTableModel modelTbItens = new DefaultTableModel();
        modelTbItens.addColumn("Nome");
        modelTbItens.addColumn("Partido");
        modelTbItens.addColumn("Numero");
        
        for (Candidato candidato : CandidatoDAO.getInstancia().getList()){
            modelTbItens.addRow(new Object[]{candidato.getNome(), candidato.getPartido(),
                candidato.getNumero()});
        }
        tabelaCandidatos.setModel(modelTbItens);
        this.repaint();
    }
    
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
    
    public static TelaCadastraCandidato getInstancia(){
        if(instancia == null){
            instancia = new TelaCadastraCandidato();
        }
        return instancia;
    }
    
    
    
    
    
    
    
    
}
