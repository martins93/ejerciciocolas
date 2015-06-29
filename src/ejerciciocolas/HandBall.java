/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocolas;

import ejerciciocolas.Deporte;

/**
 *
 * @author Martin
 */
public class HandBall implements Deporte{
    private String nombre = "Handball";
    
    private double randomProx;
    private double randomTiempo;
    
    private double tiempoEntreLlegada;
    private double tiempoDeOcupacion;
    
    public HandBall()
    {
   
    }

    @Override
    public double generarTiempoEntreLlegada() {
    

        double rnd1;
        double rnd2;


        rnd1 = Math.random();
        rnd2 = Math.random();

        randomProx = Math.sqrt(-2 * Math.log10(rnd1)) * Math.cos(2 * (Math.PI) * rnd2);

        tiempoEntreLlegada = 12 + (randomProx * 2);

        
        return tiempoEntreLlegada;
    }

    @Override
    public double generarTiempoDeOcupacion() {

        double rnd1;
        double rnd2;

        rnd1 = Math.random();
        rnd2 = Math.random();

        randomTiempo = Math.sqrt(-2 * Math.log10(rnd1)) * Math.cos(2 * (Math.PI) * rnd2);

        tiempoDeOcupacion = (80.0/60.0) + (randomTiempo * (20.0/60.0));

        return tiempoDeOcupacion;
    }
    
    
    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    
    
    @Override
    public double getRandomProx() {
        return randomProx;
    }

    public void setRandomProx(double randomProx) {
        this.randomProx = randomProx;
    }

    @Override
    public double getRandomTiempo() {
        return randomTiempo;
    }

    public void setRandomTiempo(double randomTiempo) {
        this.randomTiempo = randomTiempo;
    }

    @Override
    public double getTiempoEntreLlegada() {
        return tiempoEntreLlegada;
    }

    public void setTiempoEntreLlegada(double tiempoEntreLlegada) {
        this.tiempoEntreLlegada = tiempoEntreLlegada;
    }

    @Override
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
        SB.append("HandBall");
        
        return SB.toString();
    }
    
    
}
