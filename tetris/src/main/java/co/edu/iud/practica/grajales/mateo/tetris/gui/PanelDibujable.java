/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.iud.practica.grajales.mateo.tetris.gui;

import co.edu.iud.practica.grajales.mateo.tetris.logica.CampoDeJuego;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Mateo Grajales Jaramillo
 */
public class PanelDibujable extends JPanel {
    
    private static final int ANCHO = 30;
    private static final int ALTO = 30;
    
    private CampoDeJuego campo;
    
    public PanelDibujable(CampoDeJuego campo){
        this.campo = campo;
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                switch (campo.getCampo()[i][j]){
                    case 0:
                        g.setColor(Color.BLACK);
                        break;
                    case 1:
                        g.setColor(Color.GREEN);
                        break;
                    case 2:
                        g.setColor(Color.BLUE);
                        break;
                    case 3:
                        g.setColor(Color.RED);
                        break;
                    case 4:
                        g.setColor(Color.ORANGE);
                        break;
                    default:
                }
                g.fillRect(i*ANCHO, j*ALTO, ANCHO, ALTO);
            }
        }
    }
    
}
