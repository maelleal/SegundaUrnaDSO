/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorEleitor;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPrincipal;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorUrna;
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

/**
 *
 * @author rodri
 */
public class TelaPrincipal extends JFrame{
    
    private static TelaPrincipal instancia;
    public static final String OPCAO_CADASTRO = "1";
    public static final String OPCAO_VOTACAO = "2";
    public static final String OPCAO_RESULTADOS = "3";
    public static final String OPCAO_SAIR = "4";
    private JButton cadastros;
    private JButton votacao;
    private JButton resultado;
    private JButton sair;
    private JLabel txt;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(280, 80);
    
    
    private TelaPrincipal() {
        super("Tela Principal");
        this.botoes = new GerenciaBotoes();
        
        Font fonte = new Font("Courier New", Font.BOLD, 17);    
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txt = new JLabel();
        txt.setText("Escolha uma das Opções:");
        txt.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 0;
        container.add(txt, constraints);
        
        sair = new JButton();
        sair.setText("Sair");
        sair.setFont(fonte);
        sair.setActionCommand(OPCAO_SAIR);
        sair.setPreferredSize(tamanhoBotao);
        sair.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 5;
        container.add(sair, constraints);
        
        cadastros = new JButton();
        cadastros.setText("Cadastros");
        cadastros.setFont(fonte);
	cadastros.setActionCommand(OPCAO_CADASTRO);
	cadastros.setPreferredSize(tamanhoBotao);
        cadastros.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 1;
        container.add(cadastros, constraints);
	
		
        votacao = new JButton();
        votacao.setText("Votação");
        votacao.setFont(fonte);
        votacao.setActionCommand(OPCAO_VOTACAO);
        votacao.setPreferredSize(tamanhoBotao);
        votacao.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 2;
        container.add(votacao, constraints);
        
        
        resultado = new JButton();
        resultado.setText("Resultado do Pleito");
        resultado.setFont(fonte);
        resultado.setActionCommand(OPCAO_RESULTADOS);
        resultado.setPreferredSize(tamanhoBotao);
        resultado.addActionListener(botoes);
        constraints.gridx = 0;
	constraints.gridy = 3;
        container.add(resultado, constraints);
    
        setSize (400, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
        
    }
public class GerenciaBotoes implements ActionListener {
       
    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcao = evento.getActionCommand();
        if(opcao.equals(OPCAO_CADASTRO)) {
            ControladorPrincipal.getInstancia().exibeTelaCadastro();
            dispose();
        }
        if(opcao.equals(OPCAO_VOTACAO)) {
            ControladorEleitor.getInstancia().exibeTelaVerificaEleitor();
            dispose();
        }
        if(opcao.equals(OPCAO_RESULTADOS)) {
            ControladorUrna.getInstancia().resultadoDoPleito();
            dispose();
        }
        if(opcao.equals(OPCAO_SAIR)) {
            JOptionPane.showMessageDialog(null, "By By!!");
            System.exit(0);
        }
        
        
    } 
}
   
    public static TelaPrincipal getInstancia(){
        if(instancia == null){
            instancia = new TelaPrincipal();
        }
        return instancia;
    }
        
       
}
