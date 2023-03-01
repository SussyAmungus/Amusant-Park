package WindowComps;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatsBar extends JPanel{

	public JLabel CashL;
	public JLabel FunL;
	public JLabel RidesL;
	public JLabel EntersL;
	public JLabel ExitsL;
	public JLabel DeathsL;
	public JLabel extraL;
	
	public FlowLayout ff;
	
	public StatsBar() {
		
		this.setBackground(new Color(230,230,230));
		this.setPreferredSize(new Dimension(1000,25));
		
		ff = new FlowLayout(FlowLayout.LEFT);
		
		
		CashL = new JLabel("Cash");
		FunL = new JLabel("Fun");
		RidesL = new JLabel("Rides");
		EntersL = new JLabel("Enters");
		ExitsL = new JLabel("Exits");
		DeathsL = new JLabel("Deaths");
		extraL = new JLabel(" CLICK THE BLUE BUTTON FOR SPECIAL EFFECTS >>>>>>>>>>>>>>>>>>>>>>>>>");
		extraL.setForeground(new Color(255,150,0));
	
		
		this.setLayout(ff);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		this.add(CashL);
		
		this.add(FunL);
		this.add(RidesL);
		this.add(EntersL);
		this.add(ExitsL);
		this.add(DeathsL);
		this.add(extraL);
	}
	
	public void setCash(int num) {
		
		CashL.setText("$: " + num);
		
	}

	public void setFun(int num) {
		
		FunL.setText("Fun: " + num);
		
	}
	public void setRides(int num) {
		
		RidesL.setText("Rides: " + num);
		
	}

	public void setEnters(int num) {
		
		EntersL.setText("In Park: " + num);
		
	}
	public void setExits(int num) {
		
		ExitsL.setText("Exited: " + num);
		
	}
	public void setDeaths(int num) {
		
		DeathsL.setText("Deaths: " + num);
		
	}
	
}
