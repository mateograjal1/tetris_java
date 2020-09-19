/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.iud.practica.grajales.mateo.tetris.gui;

import co.edu.iud.practica.grajales.mateo.tetris.logica.CampoDeJuego;
import co.edu.iud.practica.grajales.mateo.tetris.logica.Jugador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mateo Grajales Jaramillo
 */
public class Ventana extends JFrame {

    //Paneles principales
    private PanelDibujable panelJuego;
    private JPanel panelEstado;
    private JPanel panelBotones;
    
    //Botones
    private JButton butIzquierda;
    private JButton butDerecha;
    private JButton butAbajo;
    
    //Panel estado
    private JLabel lblTituloPuntos;
    private JLabel lblPuntos;
    private JLabel lblTituloSiguiente;
    private JLabel lblSiguiente;
    
    
    //Logica
    private Jugador jugador;
    private CampoDeJuego campo;

    public Ventana() {        
        campo = new CampoDeJuego();
        jugador = new Jugador(campo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        configurarUI();
        ordenarEventos();
        this.setVisible(true);
        this.setTitle("Tetris");
        this.setResizable(false);
        this.pack();        
    }

    private void configurarUI() {
        this.setLayout(new BorderLayout());
        panelJuego = new PanelDibujable(campo);
        panelEstado = new JPanel();
        panelBotones = new JPanel();
        butIzquierda = new JButton("<-");
        butAbajo = new JButton("Abajo");
        butDerecha = new JButton("->");
        lblPuntos = new JLabel(String.valueOf(jugador.getPuntaje()));
        lblSiguiente = new JLabel(jugador.getSiguiente());
        lblTituloPuntos = new JLabel("Puntos:");
        lblTituloSiguiente = new JLabel("Siguiente ficha:");
        panelJuego.setPreferredSize(new Dimension(600, 600));
        panelEstado.setPreferredSize(new Dimension(200, 600));
        panelEstado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Panel de estado"));
        panelBotones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Panel de botones"));
        panelBotones.setLayout(new GridLayout(1, 3));
        panelBotones.add(butIzquierda);
        panelBotones.add(butAbajo);
        panelBotones.add(butDerecha);
        panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.Y_AXIS));
        panelEstado.add(lblTituloPuntos);
        panelEstado.add(lblPuntos);
        panelEstado.add(lblTituloSiguiente);
        panelEstado.add(lblSiguiente);
        
        this.add(panelJuego, BorderLayout.CENTER);
        this.add(panelEstado, BorderLayout.EAST);
        this.add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void ordenarEventos(){
        butIzquierda.addActionListener(e -> izquierda());
        butAbajo.addActionListener(e -> abajo());
        butDerecha.addActionListener(e -> derecha());
    }
    
    private void izquierda(){
        jugador.izquierda();
        repintar();
    }
    
    private void derecha(){
        jugador.derecha();
        repintar();
    }
    
    private void abajo(){
        jugador.abajo();
        repintar();
    }
    
    private void repintar(){
        lblPuntos.setText(String.valueOf(jugador.getPuntaje()));
        panelJuego.repaint();
    }
}
