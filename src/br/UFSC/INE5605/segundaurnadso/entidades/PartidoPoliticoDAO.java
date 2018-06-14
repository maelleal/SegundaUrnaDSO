/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.SegundaUrnaDSO.entidades;

import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Ismael
 */
public class PartidoPoliticoDAO implements Serializable {
    private static PartidoPoliticoDAO instancia;
    private HashMap<Integer, PartidoPolitico> cachePartidos = new HashMap<>();
    private final String fileName = "partidos.ppl";

    private PartidoPoliticoDAO() {
        load();
    }
    
    
    public PartidoPolitico get(Integer codigo){
        return cachePartidos.get(codigo);
    }
    
    public void put(PartidoPolitico partido){
        cachePartidos.put(partido.getCodigo(), partido);
    }
    public void removePartido(Integer codigo) {
        this.cachePartidos.remove(codigo);
        this.persist();
    }
    public Collection<PartidoPolitico> getList() {
        return cachePartidos.values();
    }
    public void persist(){
        try{
           FileOutputStream fout = new FileOutputStream(fileName);
           ObjectOutputStream oo = new ObjectOutputStream(fout);
           oo.writeObject(cachePartidos);
           
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
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oi = new ObjectInputStream(fin);
        
            this.cachePartidos = (HashMap<Integer, PartidoPolitico>) oi.readObject();
            
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
    public static PartidoPoliticoDAO getInstancias(){
        if(instancia == null ){
            instancia = new PartidoPoliticoDAO();
        }
        return instancia;
    }
}
