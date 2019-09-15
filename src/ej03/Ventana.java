/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author rubisco
 */
public class Ventana extends JFrame {

    JLabel etiqueta = new JLabel("Una etiqueta");
    JButton boton = new JButton("Un botón");
    JTextField campoTexto = new JTextField(10);

    public Ventana() {
        init();
    }

    private void init() {
        setTitle("DAD - Ejemplo ejercicio 1.3");
        setSize(new Dimension(640, 480));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(campoTexto);
        add(boton);
        add(etiqueta);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText(campoTexto.getText());

            }
        });
        setVisible(true);
    }

}
