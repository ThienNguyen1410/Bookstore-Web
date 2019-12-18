package com.sqlite.connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class DialogExample {
 
    public DialogExample() {
    	JFrame frame = new JFrame();
    	JButton button = new JButton("Close");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Product added to wishlist success.");
        
        label.setFont (label.getFont ().deriveFont (16.0f));
        label.setBounds(30, -6, 1000, 60);
        
        button.setBounds(130, 50, 80, 30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        
        panel.setLayout(null);
        panel.add(button);
        panel.add(label);
        
               
        frame.add(panel);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public static void main(String args[]) {
    	new DialogExample();
    }
}