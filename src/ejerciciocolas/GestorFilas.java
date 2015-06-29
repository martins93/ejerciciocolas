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
    Fila nueva;
    Fila[] cancha = new Fila[2];

    public GestorFilas() {

        rndDeporte = Math.random();
        Deporte aux = generarNuevoDeporte(rndDeporte);

        listaFilas = new ArrayList<>();
        colaLlegadas = new ArrayList<>();
        fila = new Fila("Inicio", 0, 0, aux, rndDeporte, "Libre");

        listaFilas.add(fila);
    }

    public void generarNuevoEvento() {
        nueva = new Fila();
        Fila filaAnterior = listaFilas.get(listaFilas.size() - 1);
       
        {
            if (filaAnterior.getEvento().equals("Inicio") || (cancha[0].getFinOcupacion() == 0 || filaAnterior.getProxLlegada() < cancha[0].getFinOcupacion())) {
                //Llegada
                
                this.generarNuevaLlegada(filaAnterior);
            } else {
                //Fin Ocupacion
                 cancha = filaAnterior.getCancha();
                this.generarNuevoFin(filaAnterior);
            }

            listaFilas.add(nueva);
        }
    }

    public void generarNuevaLlegada(Fila filaAnterior) {
        Deporte nuevoDeporte;
        rndDeporte = Math.random();
        double tiempoReloj;
        double tiempoProx;

        tiempoReloj = filaAnterior.getProxLlegada();

        nueva.setEvento("Llegada equipo" + colaLlegadas.size() + 1);
        nueva.setReloj(tiempoReloj);
        nuevoDeporte = generarNuevoDeporte(rndDeporte);
        nueva.setDeporte(nuevoDeporte);
        nueva.setRndDeporte(rndDeporte);
        tiempoProx = nuevoDeporte.generarTiempoEntreLlegada();
        nueva.setRndLlegadaDeporte(nuevoDeporte.getRandomProx());
        nueva.setTiempoEntreLlegadas(tiempoProx);
        nueva.setProxLlegada(tiempoProx + tiempoReloj);
        cancha = filaAnterior.getCancha();

        if (cancha[0] != null) 
        {
            //Si la cancha esta ocupada por alguien
            if (filaAnterior.getDeporte().getNombre().equals("Basket") && colaLlegadas.isEmpty() && cancha[0].getDeporte().getNombre().equals("Basket")) 
            {
                nueva.setTiempoOcupacion(nuevoDeporte.generarTiempoDeOcupacion());
                nueva.setRndOcupacion(nuevoDeporte.getRandomTiempo());
                nueva.setFinOcupacion(tiempoReloj + nuevoDeporte.getTiempoDeOcupacion());
                nueva.setEstado("Ocupada - 2");

                if (cancha[0].getFinOcupacion() < nueva.getFinOcupacion()) 
                {
                    cancha[1] = nueva;
                } else 
                {
                    Fila aux;
                    aux = cancha[0];
                    cancha[0] = nueva;
                    cancha[1] = aux;
                }
                nueva.setCancha(cancha);
            } 
            else 
            {                
                Fila[] f = filaAnterior.getCancha();
                
                nueva.setEstado(filaAnterior.getEstado());
                nueva.setCola(filaAnterior.getCola() + 1);
                nueva.setFinOcupacion(f[0].getFinOcupacion());
                nueva.setCancha(cancha);
                colaLlegadas.add(nueva);
            }
        } 
        else 
        {
            if (filaAnterior.getDeporte().getNombre().equals("Basket")) 
            {
                nueva.setEstado("Ocupada - 1");
            } 
            else 
            {
                nueva.setEstado("Ocupada Completa");
            }

            nueva.setTiempoOcupacion(nuevoDeporte.generarTiempoDeOcupacion());
            nueva.setRndOcupacion(nuevoDeporte.getRandomTiempo());
            nueva.setFinOcupacion(tiempoReloj + nuevoDeporte.getTiempoDeOcupacion());
            cancha[0] = nueva;
            nueva.setCancha(cancha);

        }
    }

    public void generarNuevoFin(Fila filaAnterior) {
        rndDeporte = Math.random();
        double tiempoReloj;
        cancha = filaAnterior.getCancha();
        tiempoReloj = filaAnterior.getFinOcupacion();

        nueva.setEvento("Fin Ocupacion");
        nueva.setReloj(tiempoReloj);
        nueva.setProxLlegada(filaAnterior.getProxLlegada());

        int sizeCola = filaAnterior.getCola();

        if (cancha[1] != null) {
            if (sizeCola == 0) {
               nueva.setFinOcupacion(cancha[1].getFinOcupacion());
               nueva.setEstado("Ocupado - 1");
               
                cancha[0] = cancha[1];
                cancha[1] = null;
                
                nueva.setCancha(cancha);
            } else {   //cola no vacia
                if (colaLlegadas.get(0).getDeporte().getNombre().equals("Basket")) {
                    Deporte aux;

                    nueva.setEstado("Ocupada - 1");
                    filaOcupacion = colaLlegadas.remove(0);
                    aux = filaOcupacion.getDeporte();

                    nueva.setTiempoOcupacion(aux.generarTiempoDeOcupacion());
                    nueva.setRndOcupacion(aux.getRandomTiempo());
                    nueva.setFinOcupacion(tiempoReloj + nueva.getTiempoOcupacion());

                    nueva.setCola(filaAnterior.getCola() - 1);

                    if (cancha[1].getFinOcupacion() > nueva.getFinOcupacion()) {
                        cancha[0] = nueva;
                    } else {
                        Fila aux2;
                        aux2 = cancha[1];
                        cancha[1] = nueva;
                        cancha[0] = aux2;
                    }
                    nueva.setCancha(cancha);
                } else {
                    nueva.setFinOcupacion(cancha[1].getFinOcupacion());
                    nueva.setEstado("Ocupado - 1");

                    cancha[0] = cancha[1];
                    cancha[1] = null;
                    
                    nueva.setCancha(cancha);
                }
            }
        } else {//cancha vacia
            if (sizeCola != 0) {
                if (sizeCola > 1) {
                    if (colaLlegadas.get(0).getDeporte().getNombre().equals("Basket")) {
                        if (colaLlegadas.get(1).getDeporte().getNombre().equals("Basket")) {
                            Fila aux1;
                            Fila aux2;
                            Deporte dep1;
                            Deporte dep2;

                            aux1 = colaLlegadas.remove(0);
                            aux2 = colaLlegadas.remove(1);
                            dep1 = aux1.getDeporte();
                            dep2 = aux2.getDeporte();

                            aux1.setTiempoOcupacion(dep1.generarTiempoDeOcupacion());
                            aux1.setRndOcupacion(dep1.getRandomTiempo());
                            aux1.setFinOcupacion(tiempoReloj + dep1.getTiempoDeOcupacion());

                            aux2.setTiempoOcupacion(dep2.generarTiempoDeOcupacion());
                            aux2.setRndOcupacion(dep2.getRandomTiempo());
                            aux2.setFinOcupacion(tiempoReloj + dep2.getTiempoDeOcupacion());

                            if (aux1.getFinOcupacion() < aux2.getFinOcupacion()) {
                                cancha[0] = aux1;
                                cancha[1] = aux2;
                            } else {
                                cancha[0] = aux2;
                                cancha[1] = aux1;
                            }

                            nueva.setEstado("Ocupada - 2");
                            nueva.setTiempoOcupacion(cancha[0].getTiempoOcupacion());
                            nueva.setFinOcupacion(tiempoReloj + cancha[0].getTiempoOcupacion());
                            nueva.setRndOcupacion(cancha[0].getRndOcupacion());
                            nueva.setCancha(cancha);

                        }
                        else
                        {
                            Fila aux = colaLlegadas.remove(1);
                            Deporte dep1 = aux.getDeporte();
                            aux.setTiempoOcupacion(dep1.generarTiempoDeOcupacion());
                            aux.setRndOcupacion(dep1.getRandomTiempo());
                            aux.setFinOcupacion(tiempoReloj + dep1.getTiempoDeOcupacion());
                            
                            cancha[0] = aux;
                            cancha[1] = null;
                            nueva.setEstado("Ocupada Completa");
                            nueva.setTiempoOcupacion(cancha[0].getTiempoOcupacion());
                            nueva.setFinOcupacion(tiempoReloj + cancha[0].getTiempoOcupacion());
                            nueva.setRndOcupacion(cancha[0].getRndOcupacion());
                            nueva.setCancha(cancha);
                        }
                    }
                    else {
                        Fila aux = colaLlegadas.remove(0);
                        Deporte dep1 = aux.getDeporte();
                        aux.setTiempoOcupacion(dep1.generarTiempoDeOcupacion());
                        aux.setRndOcupacion(dep1.getRandomTiempo());
                        aux.setFinOcupacion(tiempoReloj + dep1.getTiempoDeOcupacion());

                        cancha[0] = aux;
                        cancha[1] = null;
                        nueva.setEstado("Ocupada - 1");
                        nueva.setTiempoOcupacion(cancha[0].getTiempoOcupacion());
                        nueva.setFinOcupacion(tiempoReloj + cancha[0].getTiempoOcupacion());
                        nueva.setRndOcupacion(cancha[0].getRndOcupacion());
                        nueva.setCancha(cancha);
                    }                    
                }
                else
                {
                    Fila aux = colaLlegadas.remove(0);
                    Deporte dep1 = aux.getDeporte();
                    aux.setTiempoOcupacion(dep1.generarTiempoDeOcupacion());
                    aux.setRndOcupacion(dep1.getRandomTiempo());
                    aux.setFinOcupacion(tiempoReloj + dep1.getTiempoDeOcupacion());

                    cancha[0] = aux;
                    cancha[1] = null;
                    if(dep1.getNombre().equals("Basket"))
                        nueva.setEstado("Ocupada - 1");
                    else
                        nueva.setEstado("Ocupada Completa");
                    
                    nueva.setTiempoOcupacion(cancha[0].getTiempoOcupacion());
                    nueva.setFinOcupacion(tiempoReloj + cancha[0].getTiempoOcupacion());
                    nueva.setRndOcupacion(cancha[0].getRndOcupacion());
                    nueva.setCancha(cancha);
                }
            }
            else
            {
                nueva.setEstado("Libre");
                cancha[0] = null;
                cancha[1] = null;
                nueva.setCancha(cancha);
//                nueva.setCancha(cancha);
            }
        }
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
