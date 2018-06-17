/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Eleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.EleitorDAO;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ismael
 */
public class TelaPesquisaEleitor extends JFrame {
    private static final String BOTAO_ALTERAR = "1";
    private static final String BOTAO_DELETAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private static TelaPesquisaEleitor instancia;
    private JTable tabelaEleitores;
    private JScrollPane scroll;
    private JButton voltar;
    private JButton deletar;
    private JButton alterar;
    private JLabel teste;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(150, 50);
    
    
    private TelaPesquisaEleitor() {
        super ("Eleitores Cadastrados");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        
        tabelaEleitores = new JTable();
        tabelaEleitores.setPreferredScrollableViewportSize(new Dimension(450, 200));
        tabelaEleitores.setFillsViewportHeight(true);
        constraints.gridx = 2;
        constraints.gridy = 0;
        scroll = new JScrollPane(tabelaEleitores);
        container.add(scroll, constraints);
        
        teste = new JLabel();
        teste.setText("");
        teste.setFont(fonte);
        teste.setPreferredSize(tamanhoBotao);
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(teste, constraints);
        
        alterar = new JButton();
        alterar.setText("Alterar");
        alterar.setFont(fonte);
        alterar.setActionCommand(BOTAO_ALTERAR);
        alterar.addActionListener(gerenciador);
        alterar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 1;
        constraints.gridy = 5;
        container.add(alterar, constraints);
        
        deletar = new JButton();
        deletar.setText("Deletar");
        deletar.setFont(fonte);
        deletar.setActionCommand(BOTAO_DELETAR);
        deletar.addActionListener(gerenciador);
        deletar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 2;
        constraints.gridy = 5;
        container.add(deletar, constraints);
                
        voltar = new JButton();
        voltar.setText("VOLTAR");
        voltar.setFont(fonte);
        voltar.setActionCommand(BOTAO_VOLTAR);
        voltar.addActionListener(gerenciador);
        voltar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 3;
        constraints.gridy = 5;
        container.add(voltar, constraints);
       
        
        setSize(1000, 800);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }
    
    
    public void updateData() {
        DefaultTableModel modelTabelaEleitor = new DefaultTableModel();
        modelTabelaEleitor.addColumn("Titulo");
        modelTabelaEleitor.addColumn("Nome");

        for (Eleitor eleitor : EleitorDAO.getInstancias().getList()) {
            modelTabelaEleitor.addRow(new Object[]{eleitor.getTituloEleitoral(), eleitor.getNome()});
        }
        tabelaEleitores.setModel(modelTabelaEleitor);
        this.repaint();
    }
    
  
    public class GerenciaBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            if(opcao.equals(BOTAO_VOLTAR)) {
                ControladorCadastro.getInstancia().executaTelaEleitor();
                dispose();
            }
        }
    }
    
    public static TelaPesquisaEleitor getInstancia(){
        if(instancia == null){
            instancia = new TelaPesquisaEleitor();
        }
        return instancia;
    }
}
