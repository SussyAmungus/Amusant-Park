package WindowComps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import Quirky.FixedStateButtonModel;

public class PlayButton extends JPanel {

	public JButton texta;
	
	public PlayButton() {
		
		texta = new JButton();
		texta.setText("PLAY");
		texta.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		texta.setBackground(new Color(0,0,0));
		texta.setModel(new FixedStateButtonModel());
		
		//this.setSize(new Dimension(100,50));
		//this.setBounds(1068,496,100,50);
		this.setPreferredSize(new Dimension(100,50));
		this.setBackground(new Color(0,255,0));
		
		this.setLayout(new BorderLayout());
		this.add(texta,BorderLayout.CENTER);
		texta.setOpaque(false);
		
	}
	
	
	
	
	
}
