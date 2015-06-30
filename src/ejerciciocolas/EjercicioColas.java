/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocolas;

import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class EjercicioColas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         GestorFilas listaFilas;    
        
        listaFilas = new GestorFilas();
      
        
        for (int i = 0; i < 5; i++) {
                listaFilas.generarNuevoEvento(); 
        }
       
        ArrayList<Fila> filas = new ArrayList<>();
              filas = listaFilas.getListaFilas();
              
              for (int i = 0; i < 5; i++) {
                  
                  System.out.println(filas.get(i).toString());
            
        }
        
        
    }
    
}
