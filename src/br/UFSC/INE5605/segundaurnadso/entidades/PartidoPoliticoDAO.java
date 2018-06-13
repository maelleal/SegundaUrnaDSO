/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.entidades;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.PartidoPolitico;
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
public class PartidoPoliticoDAO {
     private HashMap<Integer, PartidoPolitico> cachePartido = new HashMap<>();
    private final String arquivoPartido = "eleitor.dat";
    
    public PartidoPolitico get(Integer idPartido){
        return cachePartido.get(idPartido);
    }
    
    public void put(PartidoPolitico partido){
        //cachePartido.put(partido.getPartido(), partido);
    }
    
    public void persist(){
        try{
           FileOutputStream fout = new FileOutputStream(arquivoPartido);
           
           ObjectOutputStream oo = new ObjectOutputStream(fout);
           oo.writeObject(cachePartido);
           
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
            FileInputStream fin = new FileInputStream(arquivoPartido);
            ObjectInputStream oi = new ObjectInputStream(fin);
        
            this.cachePartido = (HashMap<Integer, PartidoPolitico>) oi.readObject();
            
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
}
