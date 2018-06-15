/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author ismael
 */
public class TelaPartido extends JFrame {
    private static TelaPartido instancia;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(280, 80);

    private TelaPartido() {
        super("Tela de Cadastro de Partido");
        this.botoes = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 17);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
                
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_CADASTRAR);
        cadastrar.addActionListener(botoes);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(cadastrar, constraints);
                
        pesquisar = new JButton();
        pesquisar.setText("Pesquisar");
	pesquisar.setFont(fonte);
	pesquisar.setActionCommand(BOTAO_PESQUISAR);
	pesquisar.addActionListener(botoes);
	pesquisar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 2;
	container.add(pesquisar, constraints);
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(botoes);
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
                ControladorPartido.getInstancia().exibeCadastraPartido();
                dispose();
            }
          
            if(opcao.equals(BOTAO_VOLTAR)) {
                TelaCadastro.getInstancia().setVisible(true);
                dispose();
            }
        }
    }
    
    public static TelaPartido getInstancia(){
        if(instancia == null){
            instancia = new TelaPartido();
        }
        return instancia;
    }
}
