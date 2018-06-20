/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.exceções;

/**
 *
 * @author Ivo Guilherme
 */
public class CaracterNaoEhInteiroException extends Exception {
    
    public CaracterNaoEhInteiroException (String texto) {
        super(texto);
    }
}
