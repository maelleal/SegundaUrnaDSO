/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCadastro;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPartido;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Scanner;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author ismael
 */
public class TelaPartido extends JFrame {
    private TelaCadastro telaCadastro;
    private ControladorCadastro ctrlCadastro;
    private ControladorPartido ctrlPartido;
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton voltar;
    private JTextField nomePartido;
    private JTextField pesquisaPartido;
    private JLabel txtNome;
    private JLabel txtPesquisaPartido;
    private Dimension tamanhoBotao = new Dimension(200, 60);

    public TelaPartido(ControladorPartido ctrlPartido) {
        super("Tela de Cadastro de Partido");
        this.ctrlPartido = ctrlPartido;
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        cadastrar = new JButton();
        pesquisar = new JButton();
        voltar = new JButton();
        nomePartido = new JTextField();
        pesquisaPartido = new JTextField();
        txtNome = new JLabel();
        txtPesquisaPartido = new JLabel();
        
        container.add(cadastrar);
        container.add(pesquisar);
        container.add(voltar);
        container.add(nomePartido);
        container.add(pesquisaPartido);
        container.add(txtNome);
        container.add(txtPesquisaPartido);
        
        setSize(300, 400);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        this.ctrlPartido = ctrlPartido;
    }
}
