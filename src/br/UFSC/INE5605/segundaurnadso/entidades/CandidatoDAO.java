/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Ismael
 */
public class CandidatoDAO {
    private static CandidatoDAO instancia;
    private HashMap<Integer, Candidato> cacheCandidatos = new HashMap<>();
    private final String arquivoCandidato = "candidatos.dat";
    
    private CandidatoDAO() {
        load();
    }
    public Candidato get(Integer idCandidato){
        return cacheCandidatos.get(idCandidato);
    }
    
    public void put(Candidato candidato){
        cacheCandidatos.put(candidato.getNumero(), candidato);
        this.persist();
    }
    
    public void persist(){
        try{
            FileOutputStream fout = new FileOutputStream(arquivoCandidato);
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheCandidatos);
            
            oo.flush();
            fout.flush();
            
            oo.close();
            fout.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void load () {
        try {
            FileInputStream fin = new FileInputStream(arquivoCandidato);
            ObjectInputStream oi = new ObjectInputStream(fin);
        
            this.cacheCandidatos = (HashMap<Integer, Candidato>) oi.readObject();
        
            oi.close();
            fin.close();
            oi = null;
            fin = null;
        
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            persist();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
       
    }
    
    public static CandidatoDAO getInstancia (){
        if(instancia == null){
            instancia = new CandidatoDAO();
        }
        return instancia;
    }
    
    public void remove(Integer idCandidato){
	cacheCandidatos.remove(idCandidato);
	persist();
    }
    public Collection<Candidato> getList(){
	return cacheCandidatos.values();
    }
}
