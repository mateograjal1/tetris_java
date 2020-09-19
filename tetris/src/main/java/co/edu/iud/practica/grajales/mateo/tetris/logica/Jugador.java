/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.iud.practica.grajales.mateo.tetris.logica;

import java.awt.geom.Point2D;

/**
 *
 * @author Mateo Grajales Jaramillo
 */
public class Jugador {
    
    private long puntaje;
    private Figura figura;
    private CampoDeJuego campo;
    
    private int[] posicion;

    public long getPuntaje() {
        return puntaje;
    }
    
    public Jugador(CampoDeJuego campo){
        puntaje = 0;
        this.campo = campo;
        figura = new Figura((int)(Math.random()*7), 0);
        posicion = new int[]{0, 0};
        figura.moverFigura(campo, 0, 0, 0, 0);
    }
    
    public long incrementarPuntos(long puntos){
        puntaje += puntos;
        return puntaje;
    }
    
    public void resetearPuntos(){
        puntaje = 0;
    }
    
    private void nuevaFigura(){
        posicion[0] = 0;
        posicion[1] = 0;
        figura = new Figura((int)(Math.random()*7), 0);
    }
    
    public void izquierda(){
        mover(-1,0);
    }
    
    public void derecha(){        
        mover(1,0);
    }
    
    public void abajo(){
        mover(0,1);
    }
    
    private void mover(int dx, int dy){
        if (figura.movimientoValido(campo, posicion[0]+dx, posicion[1]+dy)){            
            figura.moverFigura(campo, posicion[0], posicion[1], posicion[0]+dx, posicion[1]+dy);
            posicion[0]+=dx;
            posicion[1]+=dy;
        } else if (figura.finMovimiento(campo, posicion[0], posicion[1])){
            nuevaFigura();
            figura.moverFigura(campo, 0, 0, 0, 0);
        }
        puntaje += campo.validarLineasLlenas();
    }
    
    public String getSiguiente(){
        switch (figura.getFigura()){
            case 0:
                return "Cuadro";
            case 1:
                return "La T";
            case 2:
                return "La L";
            case 3:
                return "La L invertida";
            case 4:
                return "La |";
            case 5:
                return "La S";
            case 6:
                return "la Z";
        }
        return "No hay siguiente";
    }
    
}

