import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import BuildingsComp.BaseBuilding;
import BuildingsComp.EndBuilding;
import BuildingsComp.StartBuilding;
import Peoples.BasePeople;

public class BuildingArea extends JPanel{

	
	
	public ArrayList<BaseBuilding> BuildList;
	ArrayList<BasePeople> PeopleList;
	
	public StartBuilding SB;
	public EndBuilding EB;
	
	//we might need to have a thing that links the custom to the non custom
	//or we have a abstract class and then an interface that does shit
	
	
	public BuildingArea(ArrayList<BaseBuilding> BL, ArrayList<BasePeople> PeopleList) {
		
		this.PeopleList = PeopleList;
		
		SB = new StartBuilding();
		EB = new EndBuilding();

		
		this.setPreferredSize(new Dimension(1100,450));
		BuildList = BL;
		
	}
	
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, 1100, 450);
		
		
		for(int i = 0; i < PeopleList.size(); i++) {
			
			PeopleList.get(i).draw(g);
			
			
		}
			
		for(int i = 0; i < BuildList.size(); i++) {
			
			BuildList.get(i).draw(g);
			
		}
		
		SB.draw(g);
		EB.draw(g);
		
		
	}
	public void refresh() {
		
		repaint();
		
		
	}
	
	public void createOnMouse(int x, int y) {
		
		BuildList.add(new BaseBuilding(x, y));
		
		
		
		
	}
	
	
}
