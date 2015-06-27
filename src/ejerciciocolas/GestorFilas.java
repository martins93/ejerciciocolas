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
public class GestorFilas {
    
        ArrayList<Fila> listaFilas;
        ArrayList<Fila> colaLlegadas;
        Fila fila;
        Fila filaOcupacion;
        double rndDeporte;


    public GestorFilas()
    {
        rndDeporte = Math.random();
        Deporte aux = generarNuevoDeporte(rndDeporte);
        
        listaFilas = new ArrayList<>();
        colaLlegadas = new ArrayList<>();
        fila = new Fila("Inicio",0,0,aux,rndDeporte,"Libre");
        
        listaFilas.add(fila);
    }
    
    public void generarNuevaFila()
    {
        Fila nueva = new Fila();
        Deporte nuevoDeporte;
        rndDeporte = Math.random();
        double tiempoReloj;
        double tiempoProx;
        
        Fila filaAnterior = listaFilas.get(listaFilas.size()-1);
        
        if((filaAnterior.getFinOcupacion() == 0 || filaAnterior.getProxLlegada()<filaAnterior.getFinOcupacion()) || filaAnterior.getEvento().equals("Inicio"))
        {
            //Fila Llegada
            
            tiempoReloj = filaAnterior.getProxLlegada();
            
            nueva = new Fila();
            nueva.setEvento("Llegada equipo" +  colaLlegadas.size()+1);
            nueva.setReloj(tiempoReloj);
            nuevoDeporte = generarNuevoDeporte(rndDeporte);
            nueva.setDeporte(nuevoDeporte);
            nueva.setRndDeporte(rndDeporte);
            tiempoProx = nuevoDeporte.generarTiempoEntreLlegada();
            nueva.setRndLlegadaDeporte(nuevoDeporte.getRandomProx());
            nueva.setTiempoEntreLlegadas(tiempoProx);
            nueva.setProxLlegada(tiempoProx+tiempoReloj);
            
            if(filaAnterior.getEstado()=="Ocupado")
            {
                nueva.setEstado(filaAnterior.getEstado());
                nueva.setCola(filaAnterior.getCola()+1);
                nueva.setFinOcupacion(filaAnterior.getFinOcupacion());
                colaLlegadas.add(nueva);
            }
            else
            {
              if(filaAnterior.getCola()!=0)
              {
                  nueva.setCola(filaAnterior.getCola()+1);
                  nueva.setFinOcupacion(filaAnterior.getFinOcupacion());
                  colaLlegadas.add(nueva);
                  
              }
              else
              {
                  nueva.setEstado("Ocupado");
                  nueva.setTiempoOcupacion(nuevoDeporte.generarTiempoDeOcupacion());
                  nueva.setRndOcupacion(nuevoDeporte.getRandomTiempo());
                  nueva.setFinOcupacion(tiempoReloj + nuevoDeporte.getTiempoDeOcupacion());
                  filaOcupacion = nueva;
                  
              }
                
            } 
          
        }
        else
        {
           tiempoReloj = filaAnterior.getFinOcupacion();
           
           nueva.setEvento("Fin Ocupacion");
           nueva.setReloj(tiempoReloj);
           
           nueva.setProxLlegada(filaAnterior.getProxLlegada());
           
           if(filaAnterior.getCola()!=0)
           {
              Deporte aux;
               
              nueva.setEstado("Ocupado");
              filaOcupacion = colaLlegadas.remove(0);
              aux = filaOcupacion.getDeporte();
              
              nueva.setTiempoOcupacion(aux.generarTiempoDeOcupacion());
              nueva.setRndOcupacion(aux.getRandomTiempo());
              nueva.setFinOcupacion(tiempoReloj + nueva.getTiempoOcupacion());
              
              nueva.setCola(filaAnterior.getCola()-1);
           }
           else
           {
               nueva.setEstado("Libre");
           }
        }
         listaFilas.add(nueva); 
    }

    
     private Deporte generarNuevoDeporte(double random) {
       
        Deporte aux = null;
        

        if (random < 0.33) {
            aux = new Futbol();
        } else if (random > 0.33 && random < 0.66) {
            aux = new Basket();
        } else if (random > 0.66) {
            aux = new HandBall();
        }

        return aux;
    }
     
     
   public ArrayList<Fila> getListaFilas()
   {
       return listaFilas;
   }

}
