/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.exceções;

import javax.swing.JOptionPane;

/**
 *
 * @author Ivo Guilherme
 */
public class CampoEmBrancoException extends Exception {
    
    public CampoEmBrancoException (String texto) {
        JOptionPane.showMessageDialog(null, "Favor, preencher todos os campos!", "Erro ao Cadastrar", JOptionPane.ERROR_MESSAGE);
    }
}
