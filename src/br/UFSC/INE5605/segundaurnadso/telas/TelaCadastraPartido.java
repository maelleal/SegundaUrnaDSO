/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.telas.TelaPartido;
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
import javax.swing.JTextField;

/**
 *
 * @author Ismael
 */
public class TelaCadastraPartido extends JFrame{
    private static TelaCadastraPartido instancia;
    private static final String BOTAO_SALVAR = "1";
    private static final String BOTAO_VOLTAR = "2";
    private JButton salvar;
    private JButton voltar;
    private JTextField nomePartido;
    private JTextField codigoPartido;
    private JLabel txtNome;
    private JLabel txtcodigoPartido;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(280, 80);
    
    private TelaCadastraPartido() {
        super("Tela de Cadastro de Partido");
        this.botoes = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txtNome = new JLabel();
        txtNome.setText("Nome do Partido:");
        txtNome.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 1;
        container.add(txtNome, constraints);
        
        nomePartido = new JTextField(10);
        nomePartido.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 2;
        container.add(nomePartido, constraints);
        
        txtcodigoPartido = new JLabel();
        txtcodigoPartido.setFont(fonte);
        txtcodigoPartido.setText("Codigo:");
        constraints.gridx = 0;
	constraints.gridy = 3;
        container.add(txtcodigoPartido, constraints);
        
        codigoPartido = new JTextField(10);
        codigoPartido.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 4;
        container.add(codigoPartido, constraints);
        
        salvar = new JButton();
        salvar.setText("SALVAR");
        salvar.setFont(fonte);
        salvar.setActionCommand(BOTAO_SALVAR);
        salvar.addActionListener(botoes);
        salvar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 0;
        constraints.gridy = 5;
        container.add(salvar, constraints);
        
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(botoes);
	voltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 6;
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
            if(opcao.equals(BOTAO_SALVAR)) {
                try {
                    int numero = Integer.parseInt(codigoPartido.getText());
                    if(numero < 0 && numero > 99 ){
                        JOptionPane.showMessageDialog(null, "Código apenas com números inteiros de 1 a 99!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
                    }
                    if(nomePartido.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Favor, preencher todos os campos!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
                    } else {
                        ControladorPartido.getInstancia().incluiPartido(nomePartido.getText(), numero);
                    }
                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(null, "Código apenas com números inteiros de 1 a 99!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(opcao.equals(BOTAO_VOLTAR)) {
                TelaPartido.getInstancia().setVisible(true);
                dispose();
            }
        }
    }
    
    public static TelaCadastraPartido getInstancia(){
        if(instancia == null){
            instancia = new TelaCadastraPartido();
        }
        return instancia;
    }
}
