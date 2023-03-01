import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;

import BuildingsComp.BaseBuilding;
import Peoples.BasePeople;
import WindowComps.BKR;
import WindowComps.CogButton;
import WindowComps.PlayButton;
import WindowComps.StatsBar;

public class Window extends JFrame {

	public ItemBar itembar;
	public PlayButton playbtn;
	public CogButton cogbtn;
	public StatsBar stb;
	
	public BuildingArea BA;
	public BKR bkr;
	
	
	public MouseAction MA;
	
	public ArrayList<BaseBuilding> BuildList;
	public ArrayList<BasePeople> PeopleList;
	public GridBagLayout GBL;
	public GridBagConstraints GBC;
	
	public Window(ArrayList<BaseBuilding> BL,ArrayList<BasePeople> PeopleList) {
		
		this.PeopleList = PeopleList;
		
		this.setPreferredSize(new Dimension(1145,600));
		
		this.setTitle("AMUSMAT PARK");
		
		GBL = new GridBagLayout();
		GBC = new GridBagConstraints();
		//////////
		
		this.setResizable(true);
		this.setVisible(true);
		this.setLayout(GBL);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//////////
		
		BA = new BuildingArea(BL, PeopleList);
		BuildList = BL;
		
		//bkr = new BKR();
		
		MA = new MouseAction(BuildList,BA);
		
		itembar = new ItemBar(BA);
		playbtn = new PlayButton();
		cogbtn = new CogButton();
		stb = new StatsBar();
		
		
		GBC.weightx = 0.0;
		GBC.weighty = 0.0;
		GBC.gridwidth = 1;
		GBC.insets = new Insets(0,0,0,0);
		GBC.gridx = 0;
		GBC.gridy = 0;
		
		this.add(stb,GBC);
		
		
		GBC.insets = new Insets(0,75,0,0);
		GBC.gridx = 1;
		GBC.gridy = 0;
		
		this.add(cogbtn, GBC);
		
		
		GBC.weightx = 0.0;
		GBC.weighty = 0.0;
		GBC.gridwidth = 2;
		GBC.insets = new Insets(0,0,0,0);
		GBC.gridx = 0;
		GBC.gridy = 1;
		
		this.add(BA,GBC);
		
		
		GBC.weightx = 0.0;
		GBC.weighty = 0.0;
		GBC.gridwidth = 1;
		GBC.insets = new Insets(4,25,0,0);
		GBC.gridx = 0;
		GBC.gridy = 2;
		
		this.add(itembar,GBC);
		
		
		GBC.weightx = 0.0;
		GBC.weighty = 0.0;
		GBC.insets = new Insets(0,0,0,0);
		GBC.gridx = 1;
		GBC.gridy = 2;
		
		this.add(playbtn,GBC);
		
		BA.addMouseListener(MA);
		BA.addMouseMotionListener(MA);
		
		itembar.addMouseListener(MA);
		itembar.addMouseMotionListener(MA);
		
		this.pack();
		
	}
	
	
}
