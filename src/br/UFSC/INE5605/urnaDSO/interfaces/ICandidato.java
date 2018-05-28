/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.urnaDSO.interfaces;

import br.UFSC.INE5605.urnaDSO.entidades.Candidato;
import br.UFSC.INE5605.urnaDSO.entidades.Cargo;
import br.UFSC.INE5605.urnaDSO.entidades.PartidoPolitico;
import java.util.ArrayList;

/**
 *
 * @author Ivo Guilherme
 */
public interface ICandidato {
    
    public Cargo getCargo();
    public PartidoPolitico getPartido();
    public int  getNumeroCandidato();
}
