/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.telas;

import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorCandidato;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorPrincipal;
import br.UFSC.INE5605.SegundaUrnaDSO.controladores.ControladorUrna;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Voto;
import br.UFSC.INE5605.segundaurnadso.entidades.VotoDAO;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
/**
 *
 * @author Ismael
 */
public class TelaUrna extends JFrame {
    private static TelaUrna instancia;
    public static final String	BOTAO_UM = "1";
    public static final String	BOTAO_DOIS = "2";
    public static final String	BOTAO_TRES = "3";
    public static final String	BOTAO_QUATRO = "4";
    public static final String	BOTAO_CINCO = "5";
    public static final String	BOTAO_SEIS = "6";
    public static final String	BOTAO_SETE = "7";
    public static final String	BOTAO_OITO = "8";
    public static final String	BOTAO_NOVE = "9";
    public static final String	BOTAO_ZERO = "0";
    public static final String OPCAO_ESCOLHIDA = "";
    public static final String OPCAO_CONFIRMA = "A";
    public static final String OPCAO_BRANCO = "B";
    public static final String OPCAO_CORRIGE = "C";
    public static final String OPCAO_VOLTAR = "D";    
    private ControladorUrna ctrlUrna;
    private JButton botaoConfirma;
    private JButton botaoVotarBranco;
    private JButton botaoVoltar;
    private JButton botaoSair;
    private JButton botaoUm;
    private JButton botaoDois;
    private JButton botaoTres;
    private JButton botaoQuatro;
    private JButton botaoCinco;
    private JButton botaoSeis;
    private JButton botaoSete;
    private JButton botaoOito;
    private JButton botaoNove;
    private JButton botaoZero;
    private JTextField numeroCandidato;
    private JLabel txtNumeroCandidato;
    private JLabel txtCandidatoEscolhido;
    private GerenciaBotoes botoes;
    private Dimension tamanhoBotao = new Dimension(100, 30);
    private Dimension tamanhoBotao2 = new Dimension(100, 30);
    private boolean validador = false;
    
    
    //adicionar dois paineis dentre de um painel
    
    private TelaUrna(){
        super("Tela Urna");
        this.ctrlUrna = ctrlUrna;
        this.botoes = new GerenciaBotoes();
        Font fonte = new Font("Courier New", Font.BOLD, 40);
        Font fonte2 = new Font("Courier New", Font.BOLD, 23);
        Font fonte3 = new Font("Courier New", Font.BOLD, 15);
        Font fonte4 = new Font("Courier New", Font.BOLD, 20);
        
        Container containerPrincipal = getContentPane();
        containerPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraints constraints2 = new GridBagConstraints();
        GridBagConstraints constraints3 = new GridBagConstraints();
        
        
        JPanel containerTeclado = new JPanel();
        containerTeclado.setSize(400, 350);
        containerTeclado.setLayout(new GridBagLayout());
        
        JPanel containerVisor = new JPanel();
        containerVisor.setSize(400, 350);
        containerVisor.setLayout(new FlowLayout());
        
        containerPrincipal.add(containerTeclado, constraints3);
	containerPrincipal.add(containerVisor, constraints3);
        
        
        botaoUm = new JButton();
        botaoUm.setText("1");
        botaoUm.getMouseListeners();
        botaoUm.setFont(fonte2);
        botaoUm.setActionCommand(BOTAO_UM);
        botaoUm.addActionListener(botoes);
        botaoUm.setPreferredSize(tamanhoBotao);
        botaoUm.setBackground(Color.black);
        botaoUm.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 4;
	containerTeclado.add(botaoUm, constraints);
        
        botaoDois = new JButton();
        botaoDois.setText("2");
        botaoDois.setFont(fonte2);
        botaoDois.setActionCommand(BOTAO_DOIS);
        botaoDois.addActionListener(botoes);
        botaoDois.setPreferredSize(tamanhoBotao);
        botaoDois.setBackground(Color.black);
        botaoDois.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 4;
	containerTeclado.add(botaoDois, constraints);
        
        botaoTres = new JButton();
        botaoTres.setText("3");
        botaoTres.setFont(fonte2);
        botaoTres.setActionCommand(BOTAO_TRES);
        botaoTres.addActionListener(botoes);
        botaoTres.setPreferredSize(tamanhoBotao);
        botaoTres.setBackground(Color.black);
        botaoTres.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 4;
	containerTeclado.add(botaoTres, constraints);
        
        botaoQuatro = new JButton();
        botaoQuatro.setText("4");
        botaoQuatro.setFont(fonte2);
        botaoQuatro.setActionCommand(BOTAO_QUATRO);
        botaoQuatro.addActionListener(botoes);
        botaoQuatro.setPreferredSize(tamanhoBotao);
        botaoQuatro.setBackground(Color.black);
        botaoQuatro.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 5;
	containerTeclado.add(botaoQuatro, constraints);
        
        botaoCinco = new JButton();
        botaoCinco.setText("5");
        botaoCinco.setFont(fonte2);
        botaoCinco.setActionCommand(BOTAO_CINCO);
        botaoCinco.addActionListener(botoes);
        botaoCinco.setPreferredSize(tamanhoBotao);
        botaoCinco.setBackground(Color.black);
        botaoCinco.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 5;
	containerTeclado.add(botaoCinco, constraints);
        
        botaoSeis = new JButton();
        botaoSeis.setText("6");
        botaoSeis.setFont(fonte2);
        botaoSeis.setActionCommand(BOTAO_SEIS);
        botaoSeis.addActionListener(botoes);
        botaoSeis.setPreferredSize(tamanhoBotao);
        botaoSeis.setBackground(Color.black);
        botaoSeis.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 5;
	containerTeclado.add(botaoSeis, constraints);
        
        botaoSete = new JButton();
        botaoSete.setText("7");
        botaoSete.setFont(fonte2);
        botaoSete.setActionCommand(BOTAO_SETE);
        botaoSete.addActionListener(botoes);
        botaoSete.setPreferredSize(tamanhoBotao);
        botaoSete.setBackground(Color.black);
        botaoSete.setForeground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 6;
	containerTeclado.add(botaoSete, constraints);
        
        botaoOito = new JButton();
        botaoOito.setText("8");
        botaoOito.setFont(fonte2);
        botaoOito.setActionCommand(BOTAO_OITO);
        botaoOito.addActionListener(botoes);
        botaoOito.setPreferredSize(tamanhoBotao);
        botaoOito.setBackground(Color.black);
        botaoOito.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 6;
	containerTeclado.add(botaoOito, constraints);
        
        botaoNove = new JButton();
        botaoNove.setText("9");
        botaoNove.setFont(fonte2);
        botaoNove.setActionCommand(BOTAO_NOVE);
        botaoNove.addActionListener(botoes);
        botaoNove.setPreferredSize(tamanhoBotao);
        botaoNove.setBackground(Color.black);
        botaoNove.setForeground(Color.white);
	constraints.gridx = 3;
	constraints.gridy = 6;
	containerTeclado.add(botaoNove, constraints);
        
        botaoZero = new JButton();
        botaoZero.setText("0");
        botaoZero.setFont(fonte2);
        botaoZero.setBorderPainted(rootPaneCheckingEnabled);
        botaoZero.setActionCommand(BOTAO_ZERO);
        botaoZero.addActionListener(botoes);
        botaoZero.setPreferredSize(tamanhoBotao);
        botaoZero.setBackground(Color.black);
        botaoZero.setForeground(Color.white);
	constraints.gridx = 2;
	constraints.gridy = 7;
	containerTeclado.add(botaoZero, constraints);
        
        botaoConfirma = new JButton();
        botaoConfirma.setText("CONFIRMA");
        botaoConfirma.setFont(fonte3);
        botaoConfirma.setBorder(new LineBorder(Color.DARK_GRAY));
        botaoConfirma.setActionCommand(OPCAO_CONFIRMA);
        botaoConfirma.addActionListener(botoes);
        botaoConfirma.setPreferredSize(tamanhoBotao);
        botaoConfirma.setBackground(Color.green);
	constraints.gridx = 3;
	constraints.gridy = 8;
	containerTeclado.add(botaoConfirma, constraints);
        
        
        botaoVotarBranco = new JButton();
        botaoVotarBranco.setText("BRANCO");
        botaoVotarBranco.setFont(fonte3);
        botaoVotarBranco.setBorder(new LineBorder(Color.DARK_GRAY));
        botaoVotarBranco.setActionCommand(OPCAO_BRANCO);
        botaoVotarBranco.addActionListener(botoes);
        botaoVotarBranco.setPreferredSize(tamanhoBotao);
        botaoVotarBranco.setBackground(Color.white);
	constraints.gridx = 1;
	constraints.gridy = 8;
	containerTeclado.add(botaoVotarBranco, constraints);
        
        botaoVoltar = new JButton();
        botaoVoltar.setText("CORRIGE");
        botaoVoltar.setFont(fonte3);
        botaoVoltar.setActionCommand(OPCAO_CORRIGE);
        botaoVoltar.addActionListener(botoes);
        botaoVoltar.setPreferredSize(tamanhoBotao);
        botaoVoltar.setBackground(Color.yellow);
	constraints.gridx = 2;
	constraints.gridy = 8;
	containerTeclado.add(botaoVoltar, constraints);
        
        botaoSair = new JButton();
        botaoSair.setText("SAIR");
        botaoSair.setFont(fonte3);
        botaoSair.setBorder(new LineBorder(Color.BLACK));
        botaoSair.setActionCommand(OPCAO_VOLTAR);
        botaoSair.addActionListener(botoes);
        botaoSair.setPreferredSize(tamanhoBotao);
	constraints.gridx = 2;
	constraints.gridy = 9;
	containerTeclado.add(botaoSair, constraints);
        
        txtNumeroCandidato = new JLabel();
        txtNumeroCandidato.setFont(fonte4);
        txtNumeroCandidato.setText("DIGITE O NUMERO DO CANDIDATO");
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
	constraints.gridx = 1;
	constraints.gridy = 0;
	containerTeclado.add(txtNumeroCandidato, constraints);
        
        numeroCandidato = new JTextField(15);
        numeroCandidato.addActionListener(botoes);
        numeroCandidato.setPreferredSize(tamanhoBotao);
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
       	constraints.gridx = 1;
	constraints.gridy = 1;
	containerTeclado.add(numeroCandidato, constraints);
        
        txtCandidatoEscolhido = new JLabel();
        txtCandidatoEscolhido.setFont(fonte);
        txtCandidatoEscolhido.setText("");
        constraints.gridheight = 10;
        constraints.gridwidth = 10;
	constraints.gridx = 2;
	constraints.gridy = 0;
        getContentPane().add( txtCandidatoEscolhido, constraints2);
        
        JLabel temp = new JLabel();
        temp.setFont(fonte);
        temp.setText("");
        constraints.gridheight = 10;
        constraints.gridwidth = 10;
	constraints.gridx = 1;
	constraints.gridy = 0;
        getContentPane().add( temp, constraints2);
        
        
        setSize (950, 700);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLocationRelativeTo(null);
        
        
        
    }
    
    
    private void capturaDigitacao (){
        Candidato candidato = null;
        String digitado = numeroCandidato.getText();
        
        int stringToNumero = Integer.parseInt(digitado);
        if(numeroCandidato.getText().length() == 2) {
            validador = true;
            candidato = ControladorCandidato.getInstancia().buscaCandidatoPeloNumero(stringToNumero);
            txtCandidatoEscolhido.setText(ControladorCandidato.getInstancia().getNome(candidato));
        }
    }
    public static TelaUrna getInstancia(){
        if(instancia == null){
            instancia = new TelaUrna();
        }
        return instancia;
    }
    public void incluiVoto (Voto voto){
        //VotoDAO.getInstancia().put(voto);
    }

    
    
    
    public class GerenciaBotoes implements ActionListener {
       
    @Override
    public void actionPerformed(ActionEvent evento) {
        String opcao = evento.getActionCommand();
        switch(opcao) {
        case BOTAO_UM:
            numeroCandidato.setText(numeroCandidato.getText()+"1");
            capturaDigitacao();
            break;
        case BOTAO_DOIS:
            numeroCandidato.setText(numeroCandidato.getText()+"2");
            capturaDigitacao();
            break;
        case BOTAO_TRES:
            numeroCandidato.setText(numeroCandidato.getText()+"3");
            capturaDigitacao();
            break;
        case BOTAO_QUATRO:
            numeroCandidato.setText(numeroCandidato.getText()+"4");
            capturaDigitacao();
            break;
        case BOTAO_CINCO:
            numeroCandidato.setText(numeroCandidato.getText()+"5");
            capturaDigitacao();
            break;
        case BOTAO_SEIS:
            numeroCandidato.setText(numeroCandidato.getText()+"6");
            capturaDigitacao();
            break;
        case BOTAO_SETE:
            numeroCandidato.setText(numeroCandidato.getText()+"7");
            capturaDigitacao();
            break;
        case BOTAO_OITO:
            numeroCandidato.setText(numeroCandidato.getText()+"8");
            capturaDigitacao();
            break;
        case BOTAO_NOVE:
            numeroCandidato.setText(numeroCandidato.getText()+"9");
            capturaDigitacao();
            break;
        case BOTAO_ZERO:
            numeroCandidato.setText(numeroCandidato.getText()+"0");
            capturaDigitacao();
            break;
        case OPCAO_CONFIRMA:
            //tratar os numeros sem candidato//tratar os numeros sem candidato//tratar os numeros sem candidato//tratar os numeros sem candidato//tratar os numeros sem candidato
            /*
            try {
                    int numero = Integer.parseInt(numeroCandidato.getText());
                    if (!validador){
                        JOptionPane.showMessageDialog(null, "Favor, preencher todos os campos!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
                        //apaga o que está no campo de numeroCandidato
                        numeroCandidato.setText("");
                    } else {
                        ControladorUrna.getInstancia().;
                        dispose();
                    }
                } catch (Exception e) {
                    nomeCandidato.setText("");
                    numeroCandidato.setText("");
                    JOptionPane.showMessageDialog(null, "Somente numeros entre 1 e 99!", "Erro ao Cadastrar", ERROR_MESSAGE);

                }
            */
            break;
        case OPCAO_BRANCO:
            
            break;
        case OPCAO_CORRIGE:
            numeroCandidato.setText("");
            txtCandidatoEscolhido.setText("");
            break;
        case OPCAO_VOLTAR:
            numeroCandidato.setText("");
            txtCandidatoEscolhido.setText("");
            ControladorPrincipal.getInstancia().abreTelaPrincipal();
            dispose();
            break;
        default:
            break;
        }
    }
    public void mensagemOK() {
        JOptionPane.showMessageDialog(null, "Voto realizado com sucesso!", "FIM", JOptionPane.ERROR_MESSAGE);
        TelaPrincipal.getInstancia().setVisible(true);
        dispose();
    }

    public void mensagemErro() {
        JOptionPane.showMessageDialog(null, "Candidato não existente!", "Erro realizar o voto", JOptionPane.ERROR_MESSAGE);
    }
    
}
}