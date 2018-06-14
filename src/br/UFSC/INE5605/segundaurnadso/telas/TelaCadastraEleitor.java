/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;


import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
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
        super("Tela do Eleitor");
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
                    int numero = Integer.parseInt(tituloEleitor.getText());
                    if (numero < 0 || numero > 99){
                        //apaga o que está no campo de numeroCandidato
                    }else {
                        ControladorCadastro.getInstancia().executaCadastroCandidato();
                        dispose();
                    }
                } catch (Exception e) {
                   
                    JOptionPane.showMessageDialog(null, "Somente numeros entre 1 e 99!", "Erro ao Cadastrar", ERROR_MESSAGE);

                }
                
            }
            if(opcao.equals(BOTAO_VOLTAR)) {
                ControladorCandidato.getInstancia().exibeMenuCandidato();
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
