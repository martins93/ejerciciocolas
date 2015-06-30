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
    Fila filaAnterior;
    private int contadorFutbol, contadorBasket, contadorHandBall;
    private int idFila;

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
        
        filaAnterior = listaFilas.get(listaFilas.size() - 1);
        

        {
            if (filaAnterior.getEvento().equals("Inicio"))
            {
                this.generarNuevaLlegada(filaAnterior);
            }
            else
            {
                if(filaAnterior.getCanchaMenorTiempoOcupacion()==0 || (filaAnterior.getProxLlegada()<filaAnterior.getCanchaMenorTiempoOcupacion()))
                {
                    this.generarNuevaLlegada(filaAnterior);
                }
                else
                {
                    this.generarNuevoFin(filaAnterior);
                }
            }
            
            listaFilas.add(nueva);
        }
    }

    public void generarNuevaLlegada(Fila filaAnterior) {
        
        idFila++;
        Deporte nuevoDeporte;
        rndDeporte = Math.random();
        double tiempoReloj;
        double tiempoProx;
        Cancha canchaux1 = new Cancha();
        Cancha canchaux2 = new Cancha();

        tiempoReloj = filaAnterior.getProxLlegada();

        
        nueva.setEvento("Llegada equipo " + idFila);
        nueva.setIdFila(idFila);
        nueva.setReloj(tiempoReloj);
        nuevoDeporte = generarNuevoDeporte(rndDeporte);
        nueva.setDeporte(nuevoDeporte);
        nueva.setRndDeporte(rndDeporte);
        tiempoProx = nuevoDeporte.generarTiempoEntreLlegada();
        nueva.setRndLlegadaDeporte(nuevoDeporte.getRandomProx());
        nueva.setTiempoEntreLlegadas(tiempoProx);
        nueva.setProxLlegada(tiempoProx + tiempoReloj);
        
        nueva.setAcumuladorBasket(filaAnterior.getAcumuladorBasket());
        nueva.setAcumuladorFutbol(filaAnterior.getAcumuladorFutbol());
        nueva.setAcumuladorHandBall(filaAnterior.getAcumuladorHandBall());

        if (filaAnterior.getCancha1().estaOcupada()==false) 
        {
            //Si la cancha no esta ocupada
            if (colaLlegadas.isEmpty())
            {
                //Si la cola esta vacia
                if (filaAnterior.getDeporte().getNombre().equals("Basket")) 
                {
                    //Si el deporte que esta llegando es Basket
                    
                    canchaux1.setEstado("Ocupada");
                    canchaux1.ponerloAJugar(filaAnterior.getDeporte(), tiempoReloj);
                    nueva.setCancha1(canchaux1);
                    nueva.setCancha2(filaAnterior.getCancha2());
                    
                } 
                else 
                {
                    //Si el deporte que esta llegando no es Basket
                    if(filaAnterior.getCancha2().estaOcupada()==false)
                    {
                        canchaux1.setEstado("Ocupada");
                        canchaux1.ponerloAJugar(filaAnterior.getDeporte(), tiempoReloj);
                        canchaux2 = canchaux1;
                        nueva.setCancha1(canchaux1);
                        nueva.setCancha2(canchaux2);
                    }
                    else
                    {
                        nueva.setCancha1(filaAnterior.getCancha1());
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCola(colaLlegadas.size() + 1);
                        colaLlegadas.add(filaAnterior);
                    }
                }
            }
            else
            {
                nueva.setCancha1(filaAnterior.getCancha1());
                nueva.setCancha2(filaAnterior.getCancha2());
                nueva.setCola(colaLlegadas.size() + 1);
                colaLlegadas.add(filaAnterior);
            }
            
        } 
        else 
        {
           if(!filaAnterior.getCancha1().equals(filaAnterior.getCancha2()))
           {
               //O hay un basket en alguna de las canchas, o hay basket en las 2
            if (!filaAnterior.getCancha2().estaOcupada()) 
            {
                //Si cancha2 no esta ocupada
                if (colaLlegadas.isEmpty()) 
                {
                    //Si la cola esta vacia
                   
                    if (filaAnterior.getDeporte().getNombre().equals("Basket"))
                    {
                        //Si el proximo en jugar es basket
                        canchaux2.setEstado("Ocupada");
                        canchaux2.ponerloAJugar(filaAnterior.getDeporte(), tiempoReloj);
                        nueva.setCancha1(filaAnterior.getCancha1());
                        nueva.setCancha2(canchaux2);
                    } 
                    else 
                    {
                        //Si el proximo no es basket
                        nueva.setCancha1(filaAnterior.getCancha1());
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCola(colaLlegadas.size() + 1);
                        colaLlegadas.add(filaAnterior);
                    }
                }
                else
                {
                    nueva.setCancha1(filaAnterior.getCancha1());
                    nueva.setCancha2(filaAnterior.getCancha2());
                    nueva.setCola(colaLlegadas.size() + 1);
                    colaLlegadas.add(filaAnterior); 
                }
            }
            else
            {
                if(!filaAnterior.getCancha1().estaOcupada())
                {
                    //Si la cancha no 1 esta ocupada
                  if(colaLlegadas.isEmpty())
                  {
                    if (filaAnterior.getDeporte().getNombre().equals("Basket"))
                    {
                        //Si el deporte que llega es basket
                        
                        canchaux1.setEstado("Ocupada");
                        canchaux1.ponerloAJugar(filaAnterior.getDeporte(), tiempoReloj);
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCancha1(canchaux1);
                    } 
                    else 
                    {
                        //Si el deporte que llega es otro
                        nueva.setCancha1(filaAnterior.getCancha1());
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCola(colaLlegadas.size() + 1);
                        colaLlegadas.add(filaAnterior);
                    }
                  }
                 else
                  {
                        nueva.setCancha1(filaAnterior.getCancha1());
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCola(colaLlegadas.size() + 1);
                        colaLlegadas.add(filaAnterior);   
                  }
                }
                else
                {
                    nueva.setCancha1(filaAnterior.getCancha1());
                    nueva.setCancha2(filaAnterior.getCancha2());
                    nueva.setCola(colaLlegadas.size() + 1);
                    colaLlegadas.add(filaAnterior);
                }
             
            }
          }
           else
           {
                //Si cancha 1 es igual a cancha 2
               
                nueva.setCancha1(filaAnterior.getCancha1());
                nueva.setCancha2(filaAnterior.getCancha2());
                nueva.setCola(colaLlegadas.size() + 1);
                colaLlegadas.add(filaAnterior);  
           }
        }
        

    }

    public void generarNuevoFin(Fila filaAnterior) {
        int idFin;
        
        double tiempoReloj;
        
        Cancha canchaux1 = new Cancha();
        Cancha canchaux2 = new Cancha();
        //hacerlo aca al id
        
        tiempoReloj = filaAnterior.getCanchaMenorTiempoOcupacion();
        
        //idFin = this.obtenerIdFin(filaAnterior);
        

        nueva.setEvento("Fin Ocupacion ");
        nueva.setReloj(tiempoReloj);
        nueva.setProxLlegada(filaAnterior.getProxLlegada());
        nueva.setDeporte(filaAnterior.getDeporte());
        
        
        nueva.setAcumuladorBasket(filaAnterior.getAcumuladorBasket());
        nueva.setAcumuladorFutbol(filaAnterior.getAcumuladorFutbol());
        nueva.setAcumuladorHandBall(filaAnterior.getAcumuladorHandBall());

        int sizeCola = colaLlegadas.size();
        
        if(filaAnterior.estanAmbasOcupadas())
        {
            if(filaAnterior.getCancha1().getFinOcupacion()==filaAnterior.getCancha2().getFinOcupacion())
            {
                //Estan ambas canchas ocupadas por un Futbol/Handball
                if(sizeCola!=0)
                {
                    if(sizeCola>1)
                    {
                        //Hay dos o mas en la cola
                          if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                          {
                              if("Basket".equals(colaLlegadas.get(1).getDeporte().getNombre()))
                              {
                                  //Son los dos basket en la cola
                                  filaOcupacion = colaLlegadas.remove(0);
                                  
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  
                                  canchaux1.setEstado("Ocupada");
                                  canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  filaOcupacion = colaLlegadas.remove(0);
                                  
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  
                                  canchaux2.setEstado("Ocupada");
                                  canchaux2.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  
                                  
                            
                                  nueva.setCancha1(canchaux1);
                                  nueva.setCancha2(canchaux2);
                                  nueva.setCola(colaLlegadas.size());
                              }
                              else
                              {
                                  //El primero es basket y el segundo no, en la cola
                                  filaOcupacion = colaLlegadas.remove(1);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  canchaux1.setEstado("Ocupada");
                                  canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  canchaux2 = canchaux1;
                                  
                                  nueva.setCancha1(canchaux1);
                                  nueva.setCancha2(canchaux2);
                                  nueva.setCola(colaLlegadas.size());
                              }
                          }
                          else
                          {
                              //El primero primero no Basket de la cola
                              
                              filaOcupacion = colaLlegadas.remove(0);
                              this.acumular(filaOcupacion, tiempoReloj);
                              this.contar(filaOcupacion);
                              canchaux1.setEstado("Ocupada");
                              canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                              canchaux2 = canchaux1;

                              nueva.setCancha1(canchaux1);
                              nueva.setCancha2(canchaux2);
                              nueva.setCola(colaLlegadas.size());
                          }
                    }
                    else
                    {
                       //Solo hay uno en la cola 
                        if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                        {
                            //y es basket
                            
                            filaOcupacion = colaLlegadas.remove(0);
                            this.acumular(filaOcupacion, tiempoReloj);
                            this.contar(filaOcupacion);
                            canchaux1.setEstado("Ocupada");
                            canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            canchaux2.setEstado("Libre");

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                        }
                        else
                        {
                            //y no es basket
                            
                            filaOcupacion = colaLlegadas.remove(0);
                            this.acumular(filaOcupacion, tiempoReloj);
                            this.contar(filaOcupacion);
                            canchaux1.setEstado("Ocupada");
                            canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            canchaux2 = canchaux1;

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                        }
                        
                    }
                }
                else
                {
                            canchaux1.setEstado("Libre");
                            canchaux2.setEstado("Libre");

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                }
                
            }
       
            //Las dos canchas estan ocupadas pero son distintas entre si
            else
            {   
                
                
                if(filaAnterior.getCancha1().getFinOcupacion()==tiempoReloj)
                {
                    
                    //Sale cancha1 y cancha2 tiene a alguein
                 if(sizeCola!=0)
                 {
                    if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                    {
                        //El primero en la cola es un Basket debe entrar en cancha 1
                        filaOcupacion = colaLlegadas.remove(0);
                        this.acumular(filaOcupacion, tiempoReloj);
                        this.contar(filaOcupacion);
                        canchaux1.setEstado("Ocupada");
                        canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                        nueva.setCancha1(canchaux1);
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCola(colaLlegadas.size()); 
                    }
                    else
                    {
                        canchaux1.setEstado("Libre");
                        nueva.setCancha1(canchaux1);
                        nueva.setCancha2(filaAnterior.getCancha2());
                        nueva.setCola(filaAnterior.getCola());
                    }
                }
                else
                {
                    //No hay nadie esperando en cola
                    canchaux1.setEstado("Libre");
                    nueva.setCancha1(canchaux1);
                    nueva.setCancha2(filaAnterior.getCancha2());
                    nueva.setCola(filaAnterior.getCola());
                }
                
                }
                else
                {
                   
                    //Sale cancha2 y cancha1 tiene a alguein
                     if(sizeCola!=0)
                     {
                        if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                        {
                            //El primero en la cola es un Basket debe entrar en cancha 2
                            filaOcupacion = colaLlegadas.remove(0);
                            this.acumular(filaOcupacion, tiempoReloj);
                            this.contar(filaOcupacion);
                            canchaux2.setEstado("Ocupada");
                            canchaux2.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            nueva.setCancha1(filaAnterior.getCancha1());
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size()); 
                        }
                        else
                        {
                            canchaux2.setEstado("Libre");
                            nueva.setCancha2(canchaux2);
                            nueva.setCancha1(filaAnterior.getCancha1());
                            nueva.setCola(filaAnterior.getCola());
                        }
                    }
                    else
                    {
                    //No hay nadie esperando en cola
                        canchaux2.setEstado("Libre");
                        nueva.setCancha2(canchaux2);
                        nueva.setCancha1(filaAnterior.getCancha1());
                        nueva.setCola(filaAnterior.getCola());
                    }
                }
            }
        }
        else
        {
            //No estan ambas ocupadas - Hay que determinar cual de ellas
            if(filaAnterior.getCancha1().estaOcupada())
            {
                //El que sale es cancha1 quedando toda la cancha libre
                if(sizeCola!=0)
                {
                    if(sizeCola>1)
                    {
                        //Hay dos o mas en la cola
                          if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                          {
                              if("Basket".equals(colaLlegadas.get(1).getDeporte().getNombre()))
                              {
                                  //Son los dos basket en la cola
                                  filaOcupacion = colaLlegadas.remove(0);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  canchaux1.setEstado("Ocupada");
                                  canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  
                                  filaOcupacion = colaLlegadas.remove(0);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  canchaux2.setEstado("Ocupada");
                                  canchaux2.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  
                                  nueva.setCancha1(canchaux1);
                                  nueva.setCancha2(canchaux2);
                                  nueva.setCola(colaLlegadas.size());
                              }
                              else
                              {
                                  //El primero es basket y el segundo no, en la cola
                                  filaOcupacion = colaLlegadas.remove(1);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  canchaux1.setEstado("Ocupada");
                                  canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  canchaux2 = canchaux1;
                                  
                                  nueva.setCancha1(canchaux1);
                                  nueva.setCancha2(canchaux2);
                                  nueva.setCola(colaLlegadas.size());
                              }
                          }
                          else
                          {
                              //El primero primero no Basket de la cola
                              
                              filaOcupacion = colaLlegadas.remove(0);
                              this.acumular(filaOcupacion, tiempoReloj);
                              this.contar(filaOcupacion);
                              canchaux1.setEstado("Ocupada");
                              canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                              canchaux2 = canchaux1;

                              nueva.setCancha1(canchaux1);
                              nueva.setCancha2(canchaux2);
                              nueva.setCola(colaLlegadas.size());
                          }
                    }
                    else
                    {
                       //Solo hay uno en la cola 
                        if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                        {
                            //y es basket
                            
                            filaOcupacion = colaLlegadas.remove(0);
                            this.acumular(filaOcupacion, tiempoReloj);
                            this.contar(filaOcupacion);
                            canchaux1.setEstado("Ocupada");
                            canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            canchaux2.setEstado("Libre");

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                        }
                        else
                        {
                            //y no es basket
                            
                            filaOcupacion = colaLlegadas.remove(0);
                            this.acumular(filaOcupacion, tiempoReloj);
                            this.contar(filaOcupacion);
                            canchaux1.setEstado("Ocupada");
                            canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            canchaux2 = canchaux1;

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                        }
                        
                    }
                }
                else
                {
                    //Queda toda la cancha libre y no hay cola
                    
                    canchaux2.setEstado("Libre");
                    canchaux1 = canchaux2;
                    nueva.setCancha2(canchaux2);
                    nueva.setCancha1(canchaux1);
                    nueva.setCola(filaAnterior.getCola());
                }
            }
            else
            {
                //El que sale es cancha2 quedando toda la cancha libre
                if(sizeCola!=0)
                {
                    if(sizeCola>1)
                    {
                        //Hay dos o mas en la cola
                          if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                          {
                              if("Basket".equals(colaLlegadas.get(1).getDeporte().getNombre()))
                              {
                              
                                  filaOcupacion = colaLlegadas.remove(0);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  canchaux1.setEstado("Ocupada");
                                  canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  
                                  filaOcupacion = colaLlegadas.remove(0);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                                  canchaux2.setEstado("Ocupada");
                                  canchaux2.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  
                                  nueva.setCancha1(canchaux1);
                                  nueva.setCancha2(canchaux2);
                                  nueva.setCola(colaLlegadas.size());
                              }
                              else
                              {
                                  filaOcupacion = colaLlegadas.remove(1);
                                        this.acumular(filaOcupacion, tiempoReloj);
                                        this.contar(filaOcupacion);
                                  canchaux1.setEstado("Ocupada");
                                  canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                                  canchaux2 = canchaux1;
                                  
                                  nueva.setCancha1(canchaux1);
                                  nueva.setCancha2(canchaux2);
                                  nueva.setCola(colaLlegadas.size());
                              }
                          }
                          else
                          {
                              filaOcupacion = colaLlegadas.remove(0);
                                    this.acumular(filaOcupacion, tiempoReloj);
                                    this.contar(filaOcupacion);
                              canchaux1.setEstado("Ocupada");
                              canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                              canchaux2 = canchaux1;

                              nueva.setCancha1(canchaux1);
                              nueva.setCancha2(canchaux2);
                              nueva.setCola(colaLlegadas.size());
                          }
                    }
                    else
                    {
                       //Solo hay uno en la cola 
                        if("Basket".equals(colaLlegadas.get(0).getDeporte().getNombre()))
                        {
                            //y es basket
                            
                            filaOcupacion = colaLlegadas.remove(0);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                            canchaux2.setEstado("Ocupada");
                            canchaux2.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            canchaux1.setEstado("Libre");

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                        }
                        else
                        {
                            //y no es basket
                            
                            filaOcupacion = colaLlegadas.remove(0);
                                  this.acumular(filaOcupacion, tiempoReloj);
                                  this.contar(filaOcupacion);
                            canchaux1.setEstado("Ocupada");
                            canchaux1.ponerloAJugar(filaOcupacion.getDeporte(), tiempoReloj);
                            canchaux2 = canchaux1;

                            nueva.setCancha1(canchaux1);
                            nueva.setCancha2(canchaux2);
                            nueva.setCola(colaLlegadas.size());
                        }
                        
                    }
                }
                else
                {
                    //Quedo toda la cancha libre y no hay cola
                    canchaux2.setEstado("Libre");
                    canchaux1 = canchaux2;
                    nueva.setCancha2(canchaux2);
                    nueva.setCancha1(canchaux1);
                    nueva.setCola(filaAnterior.getCola());
                }
                
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
    
    private void acumular(Fila fila, double reloj)
    {
        if(null != fila.getDeporte().getNombre())
        switch (fila.getDeporte().getNombre()) {
            case ("Basket"): {nueva.setAcumuladorBasket(nueva.getAcumuladorBasket()+(reloj-fila.getProxLlegada()));
                break;}
            case ("HandBall"):{nueva.setAcumuladorHandBall(nueva.getAcumuladorHandBall()+(reloj-fila.getProxLlegada()));
                break;}
            case ("Futbol"):{nueva.setAcumuladorFutbol(nueva.getAcumuladorFutbol()+(reloj-fila.getProxLlegada()));
                break;}
        }
    }
    
    public void contar(Fila fila)
    {
        if(null != fila.getDeporte().getNombre())
        switch (fila.getDeporte().getNombre()) {
            case ("Basket"): {contadorBasket++;
                break;}
            case ("HandBall"):{contadorHandBall++;
                break;}
            case ("Futbol"):{contadorFutbol++;
                break;}
        }
    }


    public int getContadorFutbol() {
        return contadorFutbol;
    }

    public int getContadorBasket() {
        return contadorBasket;
    }

    public int getContadorHandBall() {
        return contadorHandBall;
    }

    public int getIdFila() {
        return idFila;
    }

    public void setIdFila(int idFila) {
        this.idFila = idFila;
    }

    
    
    
    public ArrayList<Fila> getListaFilas() {
        return listaFilas;
    }
    
    public int obtenerIdFin(Fila filaAnterior)
    {
        int id = 0;
        int cont = (listaFilas.size()-1);
        Fila Punta = new Fila();
        Fila Cola = new Fila();
        
        boolean flag = false;
        
        do
        {
            
            Punta = listaFilas.get(cont-1);
            if(!flag)
            {
                Cola = filaAnterior;
                flag = true;
            }
            
            Cola = listaFilas.get(cont);
            
            cont --;           
        
        }while(Punta.getCanchaMenorTiempoOcupacion() != Cola.getCanchaMenorTiempoOcupacion());
        
        id = Cola.getIdFila();
        return id;
    }

}
