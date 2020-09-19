/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.iud.practica.grajales.mateo.tetris.logica;

/**
 *
 * @author Mateo Grajales Jaramillo
 */
public class CampoDeJuego {
    
    private int [][] campo;

    public int[][] getCampo() {
        return campo;
    }
    
    public CampoDeJuego(){
        campo = new int[20][20];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                campo[i][j] = 0;
            }
        }
    }
    
    public int validarLineasLlenas(){
        int puntosGan = 0;
        for (int i = 0; i < 20; i++){
            int suma = 0;
            for (int j = 0; j < 20; j++){
                suma += campo[j][i] != 2? 1 : 0;
            }
            if (suma == 0){
                for (int j = 0; j < 20; j++){
                    campo[j][i] = 0;
                }
                puntosGan += 100;
            }
        }
        return puntosGan;
    }
    
}
