/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.interfaces;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;

/**
 *
 * @author Ivo Guilherme
 */
public interface ICandidato {
    
    public PartidoPolitico getPartido();
    public int  getNumeroCandidato();
}
