/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.entidades;

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
public class VotoDAO {
    private static VotoDAO instancia;
    private HashMap<Integer, Voto> cacheVotos = new HashMap<>();
    private final String arquivoVotos = "votos.dat";

    private VotoDAO() {
        load();
    }
    
    
    public Voto get(Voto voto){
        return cacheVotos.get(voto);
    }
    
    public void put(Voto voto){
        cacheVotos.put(voto);
    }
    
    public Collection<Voto> getList() {
        return cacheVotos.values();
    }
    public void persist(){
        try{
           FileOutputStream fout = new FileOutputStream(arquivoVotos);
           ObjectOutputStream oo = new ObjectOutputStream(fout);
           oo.writeObject(cacheVotos);
           
           oo.flush();
           fout.flush();
            
           oo.close();
           fout.close();
           
        } catch (FileNotFoundException ex) {
            load();
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void load () {
        try {
            FileInputStream fin = new FileInputStream(arquivoVotos);
            ObjectInputStream oi = new ObjectInputStream(fin);
        
            this.cacheVotos = (HashMap<Integer, Voto>) oi.readObject();
            
            oi.close();
            fin.close();
            
        
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            
        } catch (FileNotFoundException ex) {
            persist();
            System.out.println(ex);
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public static VotoDAO getInstancia(){
        if(instancia == null ){
            instancia = new VotoDAO();
        }
        return instancia;
    }
}
