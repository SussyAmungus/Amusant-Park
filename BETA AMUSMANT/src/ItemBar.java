

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import WindowComps.BuildingBttn;

public class ItemBar extends JPanel {

	public FlowLayout ff;
	
	public BuildingBttn ferris;
	public BuildingBttn teaCups;
	public BuildingBttn SnackShack;
	public BuildingBttn clownTown;
	public BuildingBttn mrYe;
	public BuildingBttn theBigOne;
	public BuildingBttn spaceRace;
	
	public BuildingArea BA;
	
	public ArrayList<BuildingBttn> bttnList;
	//ferris,tea,snack,clown,ye,tbo,space
	
	public ItemBar(BuildingArea BA) {
		
		bttnList = new ArrayList<BuildingBttn>();
		ferris = new BuildingBttn("Feris Wheel","ferris");
		bttnList.add(ferris);
		teaCups = new BuildingBttn("Tea Cups","tea");
		bttnList.add(teaCups);
		SnackShack = new BuildingBttn("SnackShack", "snack");
		bttnList.add(SnackShack);
		clownTown= new BuildingBttn("clown Town", "clown");
		bttnList.add(clownTown);
		mrYe = new BuildingBttn("Mr.Ye's costa", "ye");
		bttnList.add(mrYe);
		theBigOne = new BuildingBttn("theBigOne", "tbo");
		bttnList.add(theBigOne);
		spaceRace = new BuildingBttn("spaceRace", "space");
		bttnList.add(spaceRace);
		
		this.BA = BA;
	
		ff = new FlowLayout(FlowLayout.LEFT);
		
		
		
		this.setSize(new Dimension(900,50));
		
		this.setPreferredSize(new Dimension(900,75));
		this.setBackground(new Color(255,100,0));
		this.setLayout(ff);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		for(int i = 0; i < bttnList.size(); i++) {
			
			this.add(bttnList.get(i));
			
		}
	}
	
	
}
