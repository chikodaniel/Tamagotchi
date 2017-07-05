/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Tio Ranchero
 */
public class Mascota {
    protected String clase;
    protected String nombre;
    protected String status;
    protected int vida;
    protected int tristeza;
    protected int suciedad;
    protected double acelerador = 1;
    protected double velocidad;
    protected Timer timerVida = new Timer();
    protected Timer timerTristeza = new Timer();
    protected Timer timerSuciedad = new Timer();   
    protected Timer timerStatus = new Timer();
    protected Timer timerAcelerador = new Timer();
    protected TimerTask taskVida = new TimerTask(){
        public void run() {
            decrementar("vida", (int)Math.ceil(1 * velocidad));
        }
    };
    protected TimerTask taskTristeza = new TimerTask(){
        public void run() {
            incrementar("tristeza",(int)Math.ceil(2 * velocidad));
        }
    };
    protected TimerTask taskSuciedad = new TimerTask(){
        public void run() {
            incrementar("suciedad",(int)Math.ceil(2 * velocidad));
        }
    };
    
    protected TimerTask taskStatus = new TimerTask(){
        public void run(){
            actualizarStatus();
        }
    };
    protected TimerTask taskAcelerador = new TimerTask(){
        public void run(){
            acelerador += 1;
        }
    };
    
    public Mascota(String clase, String nombre, String status, int vida, int tristeza, int suciedad) {
        int segundos = 0;
        
        this.clase = clase;
        this.nombre = nombre;
        this.status = status;
        this.vida = vida;
        this.tristeza = tristeza;
        this.suciedad = suciedad;
        
        segundos = (int) Math.ceil(3000 / acelerador);
        timerVida.scheduleAtFixedRate(taskVida, 0, segundos);
        
        timerTristeza.scheduleAtFixedRate(taskTristeza, 0, 3000);
        
        timerSuciedad.scheduleAtFixedRate(taskSuciedad, 0, 1000);
        
        timerStatus.scheduleAtFixedRate(taskStatus,0, 1000);
    }
    
    public void jugarHardcore() {
        timerAcelerador.scheduleAtFixedRate(taskAcelerador,0,2000);
    }
    
    public void incrementar(String tipo, int cantidad){
        if( ("vida".equals(tipo)) && ((this.vida + cantidad) <= 100)){
            this.vida += cantidad;
        }
        if("tristeza".equals(tipo)){
            if((this.tristeza + cantidad) <= 100) {
                this.tristeza += cantidad;
            } else {
                this.tristeza = 100;
            }
        }
        if("suciedad".equals(tipo)){
            if((this.suciedad + cantidad) <= 100){
                this.suciedad += cantidad;
            } else {
                this.suciedad = 100;
            }
        }
    }
    
    public void decrementar(String tipo, int cantidad){
        if( ("vida".equals(tipo)) && ((this.vida) > 0)){
            this.vida -= cantidad;
        }
        if( ("tristeza".equals(tipo)) && ((this.tristeza - cantidad) >= 0)){
            this.tristeza -= cantidad;
        }
        if( ("suciedad".equals(tipo)) && ((this.suciedad - cantidad) >= 0)){
            this.suciedad -= cantidad;
        }
    }
    
    public void actualizarStatus(){
        // Status: Normal, Hambriento, Triste, Enfermo, Muerto
        this.velocidad = this.acelerador;
        this.status = "";
        if (this.vida <= 0){
            this.status = "Muerto";
            timerVida.cancel();
            timerTristeza.cancel();
            timerSuciedad.cancel();
            timerStatus.cancel();
        } else{
            if(this.vida < 30){
                this.velocidad += 2;
                this.status = "Hambriento";
            }
            if(this.tristeza >= 40){
                this.velocidad += 3;
                this.status = "Triste";
            }
            if(this.suciedad >= 80){
                this.velocidad += 6;
                this.status = "Enfermo";
            }
            if("".equals(this.status)) {
                this.status = "Normal";
            }
        }
    }
    
    public void alimentar(){
        incrementar("vida",20);
    }
    
    public void bañar(){
        decrementar("suciedad",50);
    }
    
    public void jugar (){
        decrementar("tristeza",30);
    }
  
}