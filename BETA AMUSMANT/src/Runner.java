import java.util.ArrayList;
import java.util.Random;

import BuildingsComp.BaseBuilding;
import Peoples.BasePeople;

public class Runner extends Thread{
	
	public Window WW;
	public ArrayList<BaseBuilding> BuildList;
	public ACT act;
	public ArrayList<BasePeople> PeopleList;
	public Boolean noMore = false;
	public Boolean canEnd = false;
	
	public Game Game;
	
	
	public Runner(ArrayList<BaseBuilding> BuildList,ArrayList<BasePeople> PeopleList,Window WW, ACT act, Game game ) {
		this.Game = game;
		this.BuildList = BuildList;
		this.PeopleList = PeopleList;
		this.WW = WW;
		this.act = act;
		
		
		
	}
	
	
	
	@Override
	public void run() {
		
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 100000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta +=  (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				Game.statRefresh();
				countAllDown();
				
				moveAll();
				checkAllColision();
				checkBox();
				checkLeave();
				WW.BA.repaint();
				
				if(noMore == true) {
					break;
				}
				
				delta--;
				
			}
			
			//next round;
			
			
		}
		
		
	}
	
	
	
	public void checkLeave() {
		
		for(int i = 0; i < PeopleList.size(); i++) {
			
			
			if(PeopleList.get(i).checkLeave()) {
				left(PeopleList.get(i));
				Game.exits++;
				
			}

			if(checkIfEnd() == true) {
				noMore = true;
			}
		}
	}
	
	public void moveAll() {
		
		for(int i = 0; i < PeopleList.size(); i++) {
			
			PeopleList.get(i).move();
			
		}
		
	}
	
	public Boolean checkIfEnd() {
		
		if(PeopleList.size() <= 0) return true;
		
		
		
		
		return false;
		
	}
	
	
	public void checkBox() {
		
		for(int i = 0; i < PeopleList.size(); i++) {
			PeopleList.get(i).checkBoxCollision();
	
		}
			
		
			
	}
	
	public void checkAllColision() {
		
		for(int i = 0; i < PeopleList.size(); i++) {
			
			//not recomend to do this but lowkey this is really a not multiple return shit or something
			BaseBuilding yesOrno = PeopleList.get(i).checkBuildingCollision();
			
			
			if(yesOrno != null) {
				doOnCollision(yesOrno, PeopleList.get(i));
				if(checkIfEnd() == true) {
					noMore = true;
				}
				return;
			}
			//this makes it troll and if left it will try to get the dude left
			

			if(checkIfEnd() == true) {
				noMore = true;
			}
			
			
		}
		
	}
	
	public void doOnCollision(BaseBuilding BB, BasePeople BP) {
		
		Game.rides++;
		
		//ferris,tea,snack,clown,ye,tbo,space
		if(BB.type.equals("ferris")) {
			//use enums and shit
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
			
		}else if(BB.type.equals("tea")) {
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
		}else if(BB.type.equals("snack")) {
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
		}else if(BB.type.equals("clown")) {
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
		}else if(BB.type.equals("ye")) {
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
		}else if(BB.type.equals("tbo")) {
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
		}else if(BB.type.equals("space")) {
			Game.cash = Game.cash + BB.cashGive;
			Game.fun = Game.fun + BB.funGive;
			
			if(diesRoll(BB.deathP)) {
				Game.fun = Game.fun - 100;
				left(BP);
				Game.deaths++;
				BB.deaths++;
			}
			BB.totalFun = BB.totalFun + BB.funGive;
			BB.visits++;
			BB.cashGen = BB.cashGen + BB.cashGive;
			
			
		}
		
		
		
		
		
		//insert the stuff that we have to do on collison
		
		
	}
	
	public Boolean diesRoll(double procPercent) {
		
		Random newR = new Random();
		
		double roll = newR.nextDouble() * 100;
		//if the roll is smaller than the percent then it will fire like if its 50% then it will prob fire 50% of the time
		if(roll <= procPercent) {
			return true;
		}
		return false;
	}
	

	
	public void left(BasePeople BP) {
		
		
		
		for(int i = 0; i < PeopleList.size() ; i++) {
			
			if(PeopleList.get(i).equals(BP)) {
				Game.enters = Game.enters -1;
				
				PeopleList.remove(i);
			}
			
			
		}
			
		
	}
	
	
	public void countAllDown() {
		for(int i = 0; i < PeopleList.size(); i++) {
			
			PeopleList.get(i).countDown();
			
		}
		
	}
	
	public synchronized void firstLock() {
		
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
