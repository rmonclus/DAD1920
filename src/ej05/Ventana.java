/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej05;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

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
        setTitle("DAD - Ejemplo ejercicio 1.5");
        setSize(new Dimension(640, 480));
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new FlowLayout());
        add(campoTexto);
        add(boton);
        add(etiqueta);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(campoTexto.getText());
                    etiqueta.setText("" + factorial(num));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "¡El valor debe ser un número entero!");
                }

            }
        });
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cerrar el programa?", "Cerrar el programa", JOptionPane.YES_NO_OPTION);
                if (opcion == 0) {
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        setVisible(true);
    }

    private int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

}
