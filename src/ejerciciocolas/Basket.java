/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocolas;


/**
 *
 * @author Martin
 */
public class Basket implements Deporte{
    private double randomProx;
    private double randomTiempo;
    
      
    private double tiempoEntreLlegada;
    private double tiempoDeOcupacion;
    
    public Basket()
    {
         
    }
    

    @Override
    public double generarTiempoEntreLlegada() {

        double rnd1;
        double rnd2;

        rnd1 = Math.random();
        rnd2 = Math.random();

        randomProx = Math.sqrt(-2 * Math.log10(rnd1)) * Math.cos(2 * (Math.PI) * rnd2);

        tiempoEntreLlegada = 8 + (randomProx * 2);
        
        return tiempoEntreLlegada;
    }

    @Override
    public double generarTiempoDeOcupacion() {

        double rnd1;
        double rnd2;

        rnd1 = Math.random();
        rnd2 = Math.random();

        randomTiempo = Math.sqrt(-2 * Math.log10(rnd1)) * Math.cos(2 * (Math.PI) * rnd2);

        tiempoDeOcupacion = (100.0/60.0) + (randomTiempo * (30.0/60.0));

        return tiempoDeOcupacion;
    }

    
    //Getters and Setters
    
    public double getRandomProx() {
        return randomProx;
    }

    public void setRandomProx(double randomProx) {
        this.randomProx = randomProx;
    }

    public double getRandomTiempo() {
        return randomTiempo;
    }

    public void setRandomTiempo(double randomTiempo) {
        this.randomTiempo = randomTiempo;
    }

    public double getTiempoEntreLlegada() {
        return tiempoEntreLlegada;
    }

    public void setTiempoEntreLlegada(double tiempoEntreLlegada) {
        this.tiempoEntreLlegada = tiempoEntreLlegada;
    }

    public double getTiempoDeOcupacion() {
        return tiempoDeOcupacion;
    }

    public void setTiempoDeOcupacion(double tiempoDeOcupacion) {
        this.tiempoDeOcupacion = tiempoDeOcupacion;
    }
    
    
        
   @Override
    public String toString()
    {
        StringBuilder SB = new StringBuilder();
        SB.append("Basket");
        
        return SB.toString();
    }
     
}
