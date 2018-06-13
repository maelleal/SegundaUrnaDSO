/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.entidades;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Candidato;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Ismael
 */
public class CandidatoDAO {
    private static CandidatoDAO instancia;
    private HashMap<Integer, Candidato> cacheCandidatos = new HashMap<>();
    private final String arquivoCandidato = "candidatos.dat";
    
    private CandidatoDAO(){
        
    }
    public Candidato get(Integer idCandidato){
        
        return cacheCandidatos.get(idCandidato);
    }
    
    public void put(Candidato candidato){
        cacheCandidatos.put(candidato.getNumero(), candidato);
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
            oo = null;
            fout = null;
            
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
}
