/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.segundaurnadso.entidades.CandidatoDAO;
import br.UFSC.INE5605.segundaurnadso.entidades.PartidoPoliticoDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ismael
 */
public class TelaCandidato extends JFrame {
    private static TelaCandidato instancia;
    private static final String BOTAO_CADASTRAR = "1";
    private static final String BOTAO_PESQUISAR = "2";
    private static final String BOTAO_VOLTAR = "3";
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private GerenciaBotoes gerenciador;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    private TelaCandidato (){
        super ("Tela de Candidato");
        this.gerenciador = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 20);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        
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
	voltar.setActionCommand(BOTAO_VOLTAR);
	voltar.addActionListener(gerenciador);
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
    
    public static TelaCandidato getInstancia(){
        if(instancia == null){
            instancia = new TelaCandidato();
        }
        return instancia;
    }

}
