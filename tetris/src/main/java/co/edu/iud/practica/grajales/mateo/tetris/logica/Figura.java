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
public class Figura {
    
    //entero de 0 a 7
    private int figura;
    //entero de 0 a 3, pero por simplicidad manejamos 1
    private int rotacion;

    public int getFigura() {
        return figura;
    }

    public int getRotacion() {
        return rotacion;
    }
    
    public Figura(int figura, int rotacion){
        this.figura = figura;
        this.rotacion = rotacion;
    }
    
    public void moverFigura(CampoDeJuego campo, int x1, int y1, int x2, int y2){
        //solo con el cuadro para probar
        campo.getCampo()[x1][y1] = 0;
        campo.getCampo()[x1][y1+1] = 0;
        campo.getCampo()[x1+1][y1] = 0;
        campo.getCampo()[x1+1][y1+1] = 0;
        campo.getCampo()[x2][y2] = 1;
        campo.getCampo()[x2][y2+1] = 1;
        campo.getCampo()[x2+1][y2] = 1;
        campo.getCampo()[x2+1][y2+1] = 1;        
    }
    
    public boolean movimientoValido(CampoDeJuego campo, int x2, int y2){
        if (x2 >= 0 && x2 <= 18 && y2 >= 0 && y2 <= 18){
            return (campo.getCampo()[x2][y2] <= 1 
                    && campo.getCampo()[x2+1][y2] <= 1 
                    && campo.getCampo()[x2][y2+1] <= 1 
                    && campo.getCampo()[x2+1][y2+1] <= 1);
        } else {
            return false;
        }
    }
    
    public boolean finMovimiento(CampoDeJuego campo, int x2, int y2){
        if (y2 == 18 || campo.getCampo()[x2][y2+2] == 2 || campo.getCampo()[x2+1][y2+2] == 2){
            campo.getCampo()[x2][y2] = 2;
            campo.getCampo()[x2][y2+1] = 2;
            campo.getCampo()[x2+1][y2] = 2;
            campo.getCampo()[x2+1][y2+1] = 2;  
            return true;
        } else {
            return false;
        }
    }
}
