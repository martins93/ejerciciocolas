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
    private double acumuladorFutbol, acumuladorBasket, acumuladorHandBall;
    private int idFila;

    
    private double rndLlegadaDeporte;
    private double tiempoEntreLlegadas;
    private double proxLlegada;
    
    private Cancha cancha1;
    private Cancha cancha2;
    
    

    
    public Fila()
    {
       
    }
    

    public Fila(String evento, double reloj, int cola, Deporte deporte,double rndDeporte, String estado)
    {
        //Constructor primera fila
        this.evento = evento;
        this.reloj = reloj;
        this.cola = cola;
        this.deporte = deporte;
        this.rndDeporte = rndDeporte;
        this.tiempoEntreLlegadas = deporte.generarTiempoEntreLlegada();
        this.rndLlegadaDeporte = deporte.getRandomProx();
        this.proxLlegada = tiempoEntreLlegadas;
        this.cancha1 = new Cancha();
        this.cancha2 = new Cancha();
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

    public void setRndDeporte(double rndDeporte) {
        this.rndDeporte = rndDeporte;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
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

    public double getProxLlegada() {
        return proxLlegada;
    }

    public void setProxLlegada(double proxLlegada) {
        this.proxLlegada = proxLlegada;
    }

    public Cancha getCancha1() {
        return cancha1;
    }

    public void setCancha1(Cancha cancha1) {
        this.cancha1 = cancha1;
    }

    public Cancha getCancha2() {
        return cancha2;
    }

    public void setCancha2(Cancha cancha2) {
        this.cancha2 = cancha2;
    }

    public int getIdFila() {
        return idFila;
    }

    public void setIdFila(int idFila) {
        this.idFila = idFila;
    }
    
    
    
    public double getCanchaMenorTiempoOcupacion()
    {
        double menor=0.0;
        
        if(cancha1!=null && cancha1.getFinOcupacion()!=0)
        {
            if(cancha2.getFinOcupacion()!=0)
            {
                if(cancha1.getFinOcupacion()<cancha2.getFinOcupacion())
                    menor = cancha1.getFinOcupacion();
                else
                    menor = cancha2.getFinOcupacion();
            }
            menor = cancha1.getFinOcupacion();
        }
        else if(cancha2!=null && cancha2.getFinOcupacion()!=0)
            menor = cancha2.getFinOcupacion();
        
        return menor;
    }
    
    public boolean estanAmbasOcupadas()
    {
        boolean flag = false;
        if(cancha1.getDeporteEnCancha()!=null && cancha2.getDeporteEnCancha()!=null)
          flag=true;
        
        return flag;
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
