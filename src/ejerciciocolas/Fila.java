/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocolas;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Martin
 */
public class Fila {
    
    private String evento;
    private double reloj;  
    private double rndDeporte;
    private Deporte deporte;  
    private int cola;
    private String estado;
    private double acumuladorFutbol, acumuladorBasket, acumuladorHandBall;

    private double rndLlegadaDeporte;
    private double tiempoEntreLlegadas;
    private double rndOcupacion;
    private double tiempoOcupacion;
    private double finOcupacion;
    private double proxLlegada;
   // private Fila[] cancha;
    
    public Fila()
    {
       
    }
    

    public Fila(String evento, double reloj, int cola, Deporte deporte,double rndDeporte, String estado)
    {
        //Constructor primera fila
        this.evento = evento;
        this.reloj = reloj;
        this.cola = cola;
        this.estado = estado;
        this.deporte = deporte;
        this.rndDeporte = rndDeporte;
        this.tiempoEntreLlegadas = deporte.generarTiempoEntreLlegada();
        this.rndLlegadaDeporte = deporte.getRandomProx();
        this.proxLlegada = tiempoEntreLlegadas;
       // this.cancha = new Fila[2];
    }

    

    //Getters and Setters

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public double getReloj() {
        return reloj;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public double getRndDeporte() {
        return rndDeporte;
    }
/*
    public Fila[] getCancha() {
        return cancha;
    }

    public void setCancha(Fila[] cancha) {
        this.cancha = cancha;
    }
    */
    

    public void setRndDeporte(double rndDeporte) {
        this.rndDeporte = rndDeporte;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getAcumuladorFutbol() {
        return acumuladorFutbol;
    }

    public void setAcumuladorFutbol(double acumuladorFutbol) {
        this.acumuladorFutbol = acumuladorFutbol;
    }

    public double getAcumuladorBasket() {
        return acumuladorBasket;
    }

    public void setAcumuladorBasket(double acumuladorBasket) {
        this.acumuladorBasket = acumuladorBasket;
    }

    public double getAcumuladorHandBall() {
        return acumuladorHandBall;
    }

    public void setAcumuladorHandBall(double acumuladorHandBall) {
        this.acumuladorHandBall = acumuladorHandBall;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public double getRndLlegadaDeporte() {
        return rndLlegadaDeporte;
    }

    public void setRndLlegadaDeporte(double rndLlegadaDeporte) {
        this.rndLlegadaDeporte = rndLlegadaDeporte;
    }

    public double getTiempoEntreLlegadas() {
        return tiempoEntreLlegadas;
    }

    public void setTiempoEntreLlegadas(double tiempoEntreLlegadas) {
        this.tiempoEntreLlegadas = tiempoEntreLlegadas;
    }

    public double getRndOcupacion() {
        return rndOcupacion;
    }

    public void setRndOcupacion(double rndOcupacion) {
        this.rndOcupacion = rndOcupacion;
    }

    public double getTiempoOcupacion() {
        return tiempoOcupacion;
    }

    public void setTiempoOcupacion(double tiempoOcupacion) {
        this.tiempoOcupacion = tiempoOcupacion;
    }

    public double getFinOcupacion() {
        return finOcupacion;
    }

    public void setFinOcupacion(double finOcupacion) {
        this.finOcupacion = finOcupacion;
    }

    public double getProxLlegada() {
        return proxLlegada;
    }

    public void setProxLlegada(double proxLlegada) {
        this.proxLlegada = proxLlegada;
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder SB = new StringBuilder();
        SB.append("Evento: \t");
        SB.append("\n");
        SB.append(this.getEvento());
        SB.append(" Reloj: \t");

        SB.append("\t");
        
        SB.append(round(this.getReloj(),2));
        SB.append(" RND Tipo Deporte: \t");
        SB.append("\t");
        SB.append(round(this.getRndDeporte(),2));
        SB.append(" Tipo Deporte: \t");
        SB.append("\t");
        SB.append(deporte.toString());
        SB.append(" Tiempo entre llegadas: \t");
        SB.append("\t");
        SB.append(round(this.getTiempoEntreLlegadas(),2));
        SB.append(" Proxima llegada: \t");
          SB.append("\t");
        SB.append(round(this.getProxLlegada(),2));
        SB.append(" COLA: \t");
          SB.append("\t");
        SB.append(this.getCola());
        SB.append(" RND Ocupacion: \t");
          SB.append("\t");
        SB.append(round(this.getRndOcupacion(),2));
        SB.append(" Tiempo Ocupacion: \t");
          SB.append("\t");
        SB.append(round(this.getTiempoOcupacion(),2));
        SB.append(" Fin Ocupacion: \t");
          SB.append("\t");
        SB.append(round(this.getFinOcupacion(),2));
        SB.append("\n");
        
        return SB.toString();
    }
    
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
    
}
