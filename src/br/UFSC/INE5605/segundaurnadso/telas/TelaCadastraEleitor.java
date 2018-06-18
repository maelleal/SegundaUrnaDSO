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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;

/**
 *
 * @author Ismael
 */
public class TelaCadastraEleitor extends JFrame {
    private static TelaCadastraEleitor instancia;
    private static final String BOTAO_SALVAR = "1";
    private static final String BOTAO_VOLTAR = "2";
    private JButton cadastrar;
    private JButton voltar;
    private JTextField nomeEleitor;
    private JTextField tituloEleitor;
    private JLabel txtNomeEleitor;
    private JLabel txtTituloEleitor;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(280, 80);

    private TelaCadastraEleitor() {
        super("Tela de Cadastro de Eleitor");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 15);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txtNomeEleitor = new JLabel();
        txtNomeEleitor.setText("Nome do Eleitor:");
        txtNomeEleitor.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 0;
        container.add(txtNomeEleitor, constraints);
        
        nomeEleitor = new JTextField(10);
        nomeEleitor.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 1;
        container.add(nomeEleitor, constraints);
        
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
        
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_SALVAR);
        cadastrar.addActionListener(gerenciador);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(cadastrar, constraints);
        
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
    
    public void mensagemOK() {
        JOptionPane.showMessageDialog(null, "Eleitor Cadastrado com sucesso!", "Cadastro Salvo", JOptionPane.DEFAULT_OPTION);
        TelaEleitor.getInstancia().setVisible(true);
            dispose();
    }

    public void mensagemErro() {
        JOptionPane.showMessageDialog(null, "Eleitor já existe!", "Erro ao salvar o cadastro", JOptionPane.ERROR_MESSAGE);
    }
    
    public class GerenciaBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String opcao = evento.getActionCommand();
            String nomeDigitado = nomeEleitor.getText();
            if(opcao.equals(BOTAO_SALVAR)) {
                try {
                    int numero = Integer.parseInt(tituloEleitor.getText());
                    if (numero < 0 || numero > 999999999){
                        JOptionPane.showMessageDialog(null, "Código apenas com números inteiros de 1 a 99999999!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
                        tituloEleitor.setText("");
                        //apaga o que está no campo de numeroCandidato
                    }
                    if(nomeEleitor.getText().equals("")) {
                        nomeEleitor.setText("");
                        JOptionPane.showMessageDialog(null, "Favor, preencher todos os campos!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
                    }else {
                        ControladorEleitor.getInstancia().cadastraEleitor(numero, nomeDigitado);
                        ControladorEleitor.getInstancia().exibeTelaEleitor();
                        nomeEleitor.setText("");
                        tituloEleitor.setText("");
                        dispose();
                    }
                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(null, "Somente numeros entre 1 e 99999999!", "Erro ao Cadastrar", ERROR_MESSAGE);
                }
            }
            
            if(opcao.equals(BOTAO_VOLTAR)) {
                nomeEleitor.setText("");
                tituloEleitor.setText("");
                ControladorEleitor.getInstancia().exibeTelaEleitor();
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
