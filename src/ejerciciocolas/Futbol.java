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
public class Futbol implements Deporte {

    private String nombre = "Futbol";

    private double randomProx;
    private double randomTiempo;

    private double tiempoEntreLlegada;
    private double tiempoDeOcupacion;

    public Futbol() {

    }

    @Override
    public double generarTiempoEntreLlegada() {

        randomProx = Math.random();
        tiempoEntreLlegada = -(Math.log(1 - randomProx) * 10);

        return (tiempoEntreLlegada);
    }

    @Override
    public double generarTiempoDeOcupacion() {

        double rnd1;
        double rnd2;

        rnd1 = Math.random();
        rnd2 = Math.random();

        randomTiempo = Math.sqrt(-2 * Math.log10(rnd1)) * Math.cos(2 * (Math.PI) * rnd2);

        //tiempoDeOcupacion = (90.0/60.0) + (randomTiempo * (10.0/60.0));
        tiempoDeOcupacion = 20.0;

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

    public void setTiempoDeOcupacion(double valorTiempoOcupacion) {
        this.tiempoDeOcupacion = valorTiempoOcupacion;
    }

    //ToStrings
    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        SB.append("Futbol");

        return SB.toString();
    }

}
