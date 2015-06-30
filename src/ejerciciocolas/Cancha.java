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
public class Cancha {
    
    private Deporte deporteEnCancha;
    private double rndOcupacion;
    private double tiempoOcupacion;
    private double finOcupacion;
    private String estado;
    
    public Cancha()
    {
     
    }

    public Deporte getDeporteEnCancha() {
        return deporteEnCancha;
    }

    public void ponerloAJugar(Deporte deporteEnCancha, double tiempoReloj) {
        this.deporteEnCancha = deporteEnCancha;
        this.setTiempoOcupacion(deporteEnCancha.generarTiempoDeOcupacion());
        this.setRndOcupacion(deporteEnCancha.getRandomTiempo());
        this.setFinOcupacion(tiempoReloj + deporteEnCancha.getTiempoDeOcupacion());
    }

    public void setDeporteEnCancha(Deporte deporteEnCancha) {
        this.deporteEnCancha = deporteEnCancha;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean estaOcupada() {
        boolean flag = false;

        if (this.estado!=null && "Ocupada".equals(estado)) {
            flag = true;
   
        }

        return flag;
    }
    
    
            
    
}
