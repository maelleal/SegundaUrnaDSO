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
public class EleitorDAO {
    private static EleitorDAO instancia;
    private HashMap<Integer, Eleitor> cacheEleitor = new HashMap<>();
    private final String arquivoEleitor = "eleitores.dat";
    
    private EleitorDAO (){
        load();
    }
    
    public Eleitor get(Integer idEleitor){
        return cacheEleitor.get(idEleitor);
    }
    
    public void put(Eleitor eleitor){
        cacheEleitor.put(eleitor.getTituloEleitoral(), eleitor);
        this.persist();
    }
    
    public void remove(Eleitor eleitor){
	cacheEleitor.remove(eleitor);
	persist();
    }
    
    public void persist(){
        try{
           FileOutputStream fout = new FileOutputStream(arquivoEleitor);
           ObjectOutputStream oo = new ObjectOutputStream(fout);
           oo.writeObject(cacheEleitor);
           
           oo.flush();
           fout.flush();
            
           oo.close();
           fout.close();
           
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            persist();
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void load () {
        try {
            FileInputStream fin = new FileInputStream(arquivoEleitor);
            ObjectInputStream oi = new ObjectInputStream(fin);
        
            this.cacheEleitor = (HashMap<Integer, Eleitor>) oi.readObject();
            
            oi.close();
            fin.close();
        
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            persist();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static EleitorDAO getInstancia(){
        if(instancia == null){
            instancia = new EleitorDAO();
        }
        return instancia;
    }
    
    public Collection<Eleitor> getList(){
	return cacheEleitor.values();
    }
}
