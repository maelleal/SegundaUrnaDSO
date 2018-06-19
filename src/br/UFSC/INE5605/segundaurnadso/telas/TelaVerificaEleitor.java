/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.telas;


import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPrincipal;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorEleitor;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ivo Guilherme
 */
public class TelaVerificaEleitor extends JFrame {
    private static TelaVerificaEleitor instancia; 
    private static final String BOTAO_VALIDAR = "1";
    private static final String BOTAO_VOLTAR = "2";
    private JButton voltar;
    private JButton validar;
    private JTextField tituloEleitor;
    private JLabel txtTituloEleitor;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(280, 80);
    
    
    private TelaVerificaEleitor() {
        super("Tela de Verificacao de Eleitor");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
  
        txtTituloEleitor = new JLabel();
        txtTituloEleitor.setText("Numero do Titulo de Eleitor: ");
        txtTituloEleitor.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 2;
        container.add(txtTituloEleitor, constraints);
        
        tituloEleitor = new JTextField(10);
        tituloEleitor.setFont(fonte);
        constraints.gridx = 0;
        constraints.gridy = 3;
        container.add(tituloEleitor, constraints);
        
        validar = new JButton();
        validar.setText("Validar");
        validar.setFont(fonte);
        validar.setActionCommand(BOTAO_VALIDAR);
        validar.addActionListener(gerenciador);
        validar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(validar, constraints);
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(gerenciador);
	voltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 5;
	container.add(voltar, constraints);
       
        setSize(500, 600);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
        
    public class GerenciaBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            
            if(opcao.equals(BOTAO_VALIDAR)) {
                dispose();
            }
            if(opcao.equals(BOTAO_VOLTAR)) {
                ControladorPrincipal.getInstancia().exibeTelaPrincipal();
                dispose();
            }
        }
    }
    
    public static TelaVerificaEleitor getInstancia(){
        if(instancia == null){
            instancia = new TelaVerificaEleitor();
        }
        return instancia;
    }

}
