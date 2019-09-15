/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author rubisco
 */
public class Ventana extends JFrame {

    public Ventana() {
        init();
    }

    private void init() {
        setTitle("DAD - Ejemplo ejercicio 1.2");
        setSize(new Dimension(640, 480));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
