/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author rmonclus
 */
public class Ventana extends JFrame {

    JLabel etiqueta = new JLabel("Una etiqueta");
    JButton boton = new JButton("Un botón");
    JTextField campoTexto = new JTextField(10);
    JLabel nuevaEtiqueta = new JLabel("Otra etiqueta");

    public Ventana() {
        setSize(new Dimension(640, 480));
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        JTabbedPane tabbed = new JTabbedPane();
        JPanel primeraPestaña = new JPanel();
        primeraPestaña.setLayout(new BorderLayout());
        JPanel arriba = new JPanel();
        arriba.add(campoTexto);
        primeraPestaña.add(arriba, BorderLayout.NORTH);
        JPanel centro = new JPanel();
        centro.add(boton);
        JRadioButton habilita = new JRadioButton("Habilitar");
        JRadioButton deshabilita = new JRadioButton("Deshabilitar");
        
        ButtonGroup grupo = new ButtonGroup();
        
        grupo.add(habilita);
        grupo.add(deshabilita);
        
        habilita.setSelected(true);

        JPanel abajo = new JPanel();
        abajo.setLayout(new BoxLayout(abajo, BoxLayout.Y_AXIS));
        
        arriba.add(nuevaEtiqueta);
        abajo.add(habilita);
        abajo.add(deshabilita);
        
        primeraPestaña.add(abajo, BorderLayout.SOUTH);

        primeraPestaña.add(centro);

        JPanel segundaPestaña = new JPanel();

        segundaPestaña.add(etiqueta);

        tabbed.add(primeraPestaña, "Datos");
        tabbed.add(segundaPestaña, "Resultado");

        habilita.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tabbed.setEnabledAt(1, true);

            }
        });
        
        deshabilita.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tabbed.setEnabledAt(1, false);

            }
        });
        
   
        campoTexto.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                try {
                    long num = Integer.parseInt(campoTexto.getText());
                    nuevaEtiqueta.setText("" + factorial(num));
                } catch (NumberFormatException nfe) {
                }
            }
        });
        

        add(tabbed);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long num = Integer.parseInt(campoTexto.getText());
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

    private long factorial(long n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

}
