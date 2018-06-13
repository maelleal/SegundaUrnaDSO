/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.UFSC.INE5605.segundaurnadso.entidades;
import br.UFSC.INE5605.SegundaUrnaDSO.entidades.Eleitor;
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
public class EleitorDAO {
    private static EleitorDAO instancia;
    private HashMap<Integer, Eleitor> cacheEleitor = new HashMap<>();
    private final String arquivoEleitor = "eleitor.dat";
    
    private EleitorDAO (){
        
    }
    
    public Eleitor get(Integer idEleitor){
        return cacheEleitor.get(idEleitor);
    }
    
    public void put(Eleitor eleitor){
        cacheEleitor.put(eleitor.getTituloEleitoral(), eleitor);
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
            FileInputStream fin = new FileInputStream(arquivoEleitor);
            ObjectInputStream oi = new ObjectInputStream(fin);
        
            this.cacheEleitor = (HashMap<Integer, Eleitor>) oi.readObject();
            
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
    
    public static EleitorDAO getInstancia(){
        if(instancia == null){
            instancia = new EleitorDAO();
        }
        return instancia;
    }
}
