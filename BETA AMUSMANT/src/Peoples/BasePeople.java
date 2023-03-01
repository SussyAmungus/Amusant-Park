package Peoples;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import BuildingsComp.BaseBuilding;
import BuildingsComp.EndBuilding;

public class BasePeople {

	
	
	public int Px = 500;
	public int Py = 300;
	
	public int Sx = 20;
	public int Sy = 20;
	
	public int Mx = Px + (Sx/2);
	public int My = Py + (Sy/2);
	
	public int velocityX;
	public int velocityY;
	
	public int speed = 15; //speed is extra speed
	
	//this is for speed bc it can only be integers
	//we are only gonna use allow move for speed and stuff //reset sets the tick back //keep tick one
	public int reset = 5;
	public  int tick = 1;
	
	public final int waitAtTop = 50;
	
	public int wait = 0;

	Random random;
	
	public Color color;
	
	public ArrayList<BaseBuilding> BuildList;
	
	
	public EndBuilding EB;
	
	public BasePeople(EndBuilding EB, ArrayList<BaseBuilding> BuildList,int startx, int starty, Boolean isRandom, Boolean isRandomSpawn) {
		
		
		this.EB = EB;
		
		this.BuildList = BuildList;
		
		random = new Random();
		
		if(isRandom == true) {
		//this minus 1 so (1-4)
		int randomXDirection = random.nextInt(4) + 1;
		
		velocityX = randomXDirection;
		
		int randomYDirection = random.nextInt(4) + 1;
		
		velocityY = randomYDirection;
		
		}else if(isRandom != true) {
			
			velocityX = 1;
			velocityY = 1;
			
			
		}
		if (isRandomSpawn == true) {
		if(random.nextInt(2) == 1) {
			//keep
			
		}else if(random.nextInt(2) == 0) {
			//swap
			velocityY = -velocityY;
			
		}
		}
		reset = 3 * Math.max(velocityX , velocityY);
		
		color = new Color(100,100,100);
		
		
		int rX = random.nextInt(10);
		int rY = random.nextInt(100);
		
		if(rY >= 50 ) {
			rY = rY - 100;
		}
		
		
		Px = startx + rX;
		Py = starty + rY;
	}
	
	
	public BasePeople(EndBuilding EB, ArrayList<BaseBuilding> BuildList,int startx, int starty, Boolean isRandom, Boolean isRandomSpawn, Color c) {
	
		
		this.EB = EB;
		
		this.BuildList = BuildList;
		
		random = new Random();
		
		if(isRandom == true) {
		//this minus 1 so (1-4)
		int randomXDirection = random.nextInt(4) + 1;
		
		velocityX = randomXDirection;
		
		int randomYDirection = random.nextInt(4) + 1;
		
		velocityY = randomYDirection;
		
		}else if(isRandom != true) {
			
			velocityX = 1;
			velocityY = 1;
			
			
		}
		if (isRandomSpawn == true) {
		if(random.nextInt(2) == 1) {
			//keep
			
		}else if(random.nextInt(2) == 0) {
			//swap
			velocityY = -velocityY;
			
		}
		}
		reset = 3 * Math.max(velocityX , velocityY);
		
		color = c;
		
		Px = startx;
		Py = starty;
	}
	
	
	
	public void manualTickReset() {
	
		tick = 0; 
		
	}
	
	public void move() {
		//can move if allow == 0
		
		if(tick == 0|| checkBuildingCollisionBool() || checkBoxCollisionBool()) {
			
			Px = Px + (velocityX * speed);
			Py = Py + (velocityY * speed);
			Mx = Px + (Sx/2);
			My = Py + (Sy/2);
			
			tick = reset;
		}else{
			
			tick--;
		}
		
		
		
	}
	
	public void draw(Graphics g) {
		
		
		g.setColor(this.color);
		g.fillRect(Px, Py, Sx, Sy);
	
		
	}
	
	public void checkIfBounds() {
		
		
		
		
	}
	
	
	
	public void checkBoxCollision() {
		
		//lowkey their manualy set but its the size of the BuildArea (1100 450)
		if(Py < 0 || Py + Sy > 450) {
			if(Math.abs(velocityX) > Math.abs(velocityY)) {
				
				velocityY = -velocityY;
			}else if(Math.abs(velocityX) == Math.abs(velocityY)) {
				
				velocityY = -velocityY;
				
				
			}else if (Math.abs(velocityY) > Math.abs(velocityX)){
				
				velocityY = -velocityY;
				
			}
			
		
		}
		if(Px < 0 || Px + Sx > 1100) {
			
			if(Math.abs(velocityY) > Math.abs(velocityX)) {
				
				velocityX = -velocityX;
			}else if(Math.abs(velocityY) == Math.abs(velocityX)) {
				
				
				velocityX = -velocityX;
				
			}else if (Math.abs(velocityX) > Math.abs(velocityY)){
				
				velocityX = -velocityX;
				
			}
			
			
		}
		
	}
	
	public Boolean checkLeave() {
			 
			 if((this.Px + this.Sx > EB.Px && this.Px < EB.Px + EB.Sx) &&
    				 (this.Py + this.Sy > EB.Py && this.Py < EB.Py + EB.Sy)) {
				 
				 
				
				 return true;
			 }
			
		return false;
		
	}
	
	//main method for collision
	public BaseBuilding checkBuildingCollision() {	
		 for(int i = 0; i < BuildList.size(); i++) {
			 
			 if((this.Px + this.Sx >= BuildList.get(i).Px && this.Px <= BuildList.get(i).Px + BuildList.get(i).Sx) &&
    				 (this.Py + this.Sy >= BuildList.get(i).Py && this.Py <= BuildList.get(i).Py + BuildList.get(i).Sy)) {
	
				int topCordY = BuildList.get(i).Py;
				
				if(Math.abs((this.Py + this.Sy) - topCordY) < 3) {
					
					
						velocityY = -velocityY;
					
				
					
					
				}
				
				int BotCordY = BuildList.get(i).Py + BuildList.get(i).Sy;
				
				if(Math.abs((this.Py) - BotCordY) < 3) {
					
						velocityY = -velocityY;
					
					
					
					
				}
			
				
				int LeftCordX = BuildList.get(i).Px;
				
				
				if(Math.abs((this.Px + this.Sx) - LeftCordX) < 3) {
					
					
						velocityX = -velocityX;
					
					
					
					
				}
				int RightCordX = BuildList.get(i).Px + BuildList.get(i).Sx;
	
				
				if(Math.abs((this.Px) - RightCordX) < 3) {
					
					
						
						velocityX = -velocityX;
					
					
					
					
				}
			
				
				 if(wait > 0) {
					 
					return null;
				 }else {
				
					  wait = waitAtTop;
					 
				 }
				
				// System.out.println((this.Py + this.Sy) + "   " + topCordY); //cord is lower
				// System.out.println((this.Py) + "   " + BotCordY); //cord is higher / same
				// System.out.println((this.Px + this.Sx) + "   " + LeftCordX); //cord is lower
				// System.out.println((this.Px) + "   " + RightCordX); //cord higher
				 
				 
				// System.exit(0);
				 
				 return BuildList.get(i);
				 
				 
				 
				 
				
			 }				
			 
		 }
		
		 return null;
		 
	}
	
	public Boolean checkBuildingCollisionBool() {	
		 for(int i = 0; i < BuildList.size(); i++) {
			 
			 if((this.Px + this.Sx > BuildList.get(i).Px && this.Px < BuildList.get(i).Px + BuildList.get(i).Sx) &&
   				 (this.Py + this.Sy > BuildList.get(i).Py && this.Py < BuildList.get(i).Py + BuildList.get(i).Sy)) {
				 
				 if(this.Px + this.Sx >= BuildList.get(i).Px && this.Px <= BuildList.get(i).Px + BuildList.get(i).Sx) {
					 return true;
				 }
				 if(this.Py + this.Sy >= BuildList.get(i).Py && this.Py <= BuildList.get(i).Py + BuildList.get(i).Sy) {
					 return true;
				 }
				 manualTickReset();
			 }				
			 
		 }
		return false;
	}
	
	public void countDown() {
		
		
		if(wait <= 0) {
			
			return;
			
		}else {
			
			wait--;
		}
		
		
	}
	
	public void terminate() {
		
		//this is kinda empty bc the tester class does the shits
		
	}
	
	
	public Boolean checkBoxCollisionBool() {
		
		//lowkey their manualy set but its the size of the BuildArea (1100 450)
		if(Py <= 0 || Py + Sy >= 450) {
			return true;
		}
		if(Px <= 0 || Px + Sx >= 1100) {
			return true;
		}
		return false;
	}
	
	
}
