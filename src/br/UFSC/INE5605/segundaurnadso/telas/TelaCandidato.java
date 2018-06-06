/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Ismael
 */
public class TelaCandidato extends javax.swing.JFrame {
    private Scanner cadastroCandidato;
    private ControladorCandidato ctrlCandidato;
    private ControladorPartido ctrlPartido;
    private ControladorCadastro ctrlCadastro;
    private JTextField txtNome;
    private JTextField txtNumero;
    private JComboBox partidos;
    private JButton botaoOk;
    private JLabel txt;
    private Dimension tamanhoBotao = new Dimension(200, 60);
    
    
    public TelaCandidato (ControladorCandidato ctrlCandidato){
        super ("Cadastro de Candidato");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        txt = new JLabel();
        txtNome = new JTextField();
        txtNumero = new JTextField();
        botaoOk = new JButton();
        //partidos = new JComboBox((ComboBoxModel) ctrlPartido.getPartidos());
                
        txt.setText("Insira os dados do Cancidato");
        txtNome.setText("Nome");
        txtNumero.setText("Numero");
        //partidos.setText("Escolha um Partido");
        botaoOk.setText("Cadastrar");
        
        container.add(txt);
        container.add(txtNome);
        container.add(txtNumero);
        container.add(botaoOk);
        //container.add(partidos);
        setSize (600, 400);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
           
        this.cadastroCandidato = new Scanner(System.in);
        this.ctrlCandidato = ctrlCandidato;
    }

}
