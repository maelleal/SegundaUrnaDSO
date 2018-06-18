/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorEleitor;
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


/**
 *
 * @author Ismael
 */
public class TelaEleitor extends JFrame {
    private static TelaEleitor instancia;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private JLabel txt;
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(280, 80);
    
    private TelaEleitor () {
        super("Tela do Eleitor");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txt = new JLabel();
        txt.setText("Escolha uma das Opções:");
        txt.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 0;
	container.add(txt, constraints);
                
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_CADASTRAR);
        cadastrar.addActionListener(gerenciador);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(cadastrar, constraints);
        
        pesquisar = new JButton();
        pesquisar.setText("Pesquisar");
	pesquisar.setFont(fonte);
	pesquisar.setActionCommand(BOTAO_PESQUISAR);
	pesquisar.addActionListener(gerenciador);
	pesquisar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 2;
	container.add(pesquisar, constraints);
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
        voltar.addActionListener(gerenciador);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 3;
	container.add(voltar, constraints);
        
        setSize(400, 500);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public class GerenciaBotoes implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            if(opcao.equals(BOTAO_CADASTRAR)) {
                ControladorEleitor.getInstancia().exibeTelaCadastraEleitor();
                dispose();
            }
            
            if(opcao.equals(BOTAO_PESQUISAR)) {
                ControladorEleitor.getInstancia().exibeTelaPesquisaEleitor();
                dispose();
            }
            if(opcao.equals(BOTAO_VOLTAR)) {
                ControladorEleitor.getInstancia().exibeTelaCadastro();
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