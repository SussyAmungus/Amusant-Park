package WindowComps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BuildingBttn extends JPanel  {

	public String Name = "Builda";
	public String Type = "Nothing Yet";
	
	public JButton Button;
	
	public BuildingBttn(String name, String type) {
		
		this.Type = type;
		
		this.Name = name;
		Button = new JButton(Name);
		
		this.setPreferredSize(new Dimension(123,65));
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(30,30,30));
		
		this.add(Button, BorderLayout.CENTER);
		
		
		
		
	}
}
