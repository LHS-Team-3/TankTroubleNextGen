package com.lhs.ui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TTUI 
implements KeyListener{
	public static void main(String args[]){
		JButton play = new JButton(new PlayAction());
		JButton quit = new JButton(new Quit());
		play.setBackground(new Color(59, 89, 182));
        play.setForeground(Color.RED);
        play.setFocusPainted(false);
        play.setFont(new Font("Tahoma", Font.BOLD, 12));
        quit.setBackground(Color.blue);
        quit.setForeground(Color.BLACK);
        quit.setFocusPainted(false);
        quit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,2,5,5));
		p.add(play);
		p.add(quit);
		
		JFrame f = new JFrame("TT: Controls");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(p);
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
