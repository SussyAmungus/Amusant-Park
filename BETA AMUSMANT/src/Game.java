import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import BuildingsComp.BaseBuilding;
import BuildingsComp.EndBuilding;
import Peoples.BasePeople;

public class Game extends Thread {

	
	public Window WW;
	public ArrayList<BaseBuilding> BuildList;
	public ACT act;
	public ArrayList<BasePeople> PeopleList;
	public Boolean canEdit;
	
	public int cash;
	public int fun;
	public int rides;
	public int enters;
	public int exits;
	public int deaths;
	
	
	public Game() {
		
		
		cash = 0;
		fun = 0;
		rides = 0;
		enters = 0;
		exits = 0;
		deaths = 0;
		
		canEdit = true;
		BuildList = new ArrayList<BaseBuilding>();
		PeopleList = new ArrayList<BasePeople>();
		
		
		
		WW = new Window(BuildList,PeopleList);
		try {
			act = new ACT(WW,BuildList,PeopleList, this );
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WW.BA.repaint();	
		
		while(true) {
			statRefresh();
			playGame();
		}
			
			                    
	}
	
	public void statRefresh() {
		
		WW.stb.setCash(cash);
		WW.stb.setFun(fun);
		WW.stb.setRides(rides);
		WW.stb.setEnters(enters);
		WW.stb.setExits(exits);
		WW.stb.setDeaths(deaths);
		
	}
	
	
	public void populate(int amount, Boolean randomSpeed,Boolean randomY, EndBuilding EB) {
		
		
		int startx = WW.BA.SB.Px + (WW.BA.SB.Sx/2);
		int starty = WW.BA.SB.Py + (WW.BA.SB.Sy/2);
	
		
		for(int i = 0; i < amount; i++) {
			
			if(i == 0) {
				PeopleList.add(new BasePeople(EB,BuildList,startx,starty, randomSpeed,randomY, new Color(255,0,0)));
				
				
				
			}else {

				PeopleList.add(new BasePeople(EB,BuildList,startx,starty, randomSpeed,randomY));
				
				
			}
			
			enters++;
			waita(this,10);
		}
		
		
		
	}
	
	
	public void playGame() {
		
		Runner newRun = new Runner(BuildList, PeopleList, WW, act,this);
		
		act.setThread(newRun);
		
		
		
		newRun.firstLock();
		canEdit = false;
		
		
		//event loop happens here
		newRun.start();
		
		populate(100,false,true,WW.BA.EB);
		
		newRun.firstLock();
		
		
		canEdit = true;
		
		
	}
	
	public synchronized void waita(Thread T, int sec) {
		try {
			T.wait(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
