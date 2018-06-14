/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.CandidatoDAO;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPoliticoDAO;
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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
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
    private static final String BOTAO_SALVAR = "1";
    private static final String BOTAO_VOLTAR = "3";
    private JButton cadastrar;
    private JButton voltar;
    private JTextField nomeCandidato;
    private JTextField numeroCandidato;
    private JComboBox<PartidoPoliticoDAO> partidoCandidato;
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
        txtNomeCandidato.setText("Nome do Candidato:");
        txtNomeCandidato.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 0;
        container.add(txtNomeCandidato, constraints);
        
        nomeCandidato = new JTextField(15);
        nomeCandidato.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 1;
        container.add(nomeCandidato, constraints);
        
        txtPartidoCandidato = new JLabel();
        txtPartidoCandidato.setText("Partido do Candidato: ");
        txtPartidoCandidato.setFont(fonte);
        constraints.gridx = 0;
	constraints.gridy = 2;
        container.add(txtPartidoCandidato, constraints);
        
        partidoCandidato = new JComboBox();
        constraints.gridx = 0;
        constraints.gridy = 3;
        partidoCandidato.setPreferredSize(new Dimension(175, 30));
        container.add(partidoCandidato, constraints);
        
        txtNumeroCandidato = new JLabel();
        txtNumeroCandidato.setText("Numero do Candidato: ");
        txtNumeroCandidato.setFont(fonte);
        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(txtNumeroCandidato, constraints);
        
        numeroCandidato = new JTextField(15);
        numeroCandidato.setFont(fonte);
        constraints.gridx = 0;
        constraints.gridy = 5;
        container.add(numeroCandidato, constraints);
        
        cadastrar = new JButton();
        cadastrar.setText("SALVAR");
        cadastrar.setFont(fonte);
        cadastrar.setActionCommand(BOTAO_SALVAR);
        cadastrar.addActionListener(gerenciador);
        cadastrar.setPreferredSize(tamanhoBotao);
        constraints.gridx = 0;
        constraints.gridy = 6;
        container.add(cadastrar, constraints);
        
        voltar = new JButton();
        voltar.setText("VOLTAR");
	voltar.setFont(fonte);
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(gerenciador);
	voltar.setPreferredSize(tamanhoBotao);
	constraints.gridx = 0;
	constraints.gridy = 7;
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
                    int numero = Integer.parseInt(numeroCandidato.getText());
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
    
    public static TelaCadastraCandidato getInstancia(){
        if(instancia == null){
            instancia = new TelaCadastraCandidato();
        }
        return instancia;
    }
    
    
    
    
    
    
    
    
}
