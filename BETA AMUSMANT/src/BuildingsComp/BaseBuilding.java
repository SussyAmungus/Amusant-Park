package BuildingsComp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BaseBuilding extends Rectangle {

	//prob this will be our super class
	public int Px = 0;
	public int Py = 0;
	
	public int Sx = 100;
	public int Sy = 100;
	
	public int Mx = Px + (Sx/2);
	public int My = Py + (Sy/2);
	
	public Color color = new Color(255,255,0);
	
	
	//these are the types litteral
	//ferris,tea,snack,clown,ye,tbo,space
	
	public String type = "nothing";
	public String fullName = "nothing";
	
	
	public int deathP = 0;
	public int cashGive = 0;
	public int funGive = 0;
	
	
	
	public int cashGen = 0;
	public int deaths = 0;
	public int visits = 0;
	public int totalFun = 0;
	
	public BaseBuilding(int posX, int posY, String type){
		this.type = type;
		Px = posX;
		Py = posY;
		
		
		if(type.equals("ferris")) {
			
			Sx = 200;
			Sy = 200;
			
			
			deathP = 10;
			cashGive = 100;
			funGive = 10;
			fullName = "Ferris Wheel";
		}else if(type.equals("tea")) {
			Sx = 75;
			Sy = 100;
			
			
			deathP = 1;
			cashGive = 10;
			funGive = 2;
			fullName = "Tea Cups";
			
		}else if(type.equals("snack")) {
			Sx = 200;
			Sy = 100;
			
			
			deathP = 0;
			cashGive = 1;
			funGive = 1;
			fullName = "Snack Shack";
			
		}else if(type.equals("clown")) {
			Sx = 300;
			Sy = 100;
			
			
			deathP = 50;
			cashGive = 1000;
			funGive = -50;
			fullName = "Clown Town";
			
		}else if(type.equals("ye")) {
			Sx = 100;
			Sy = 100;
			
			
			deathP = 0;
			cashGive = 10000;
			funGive = 1000;
			fullName = "Praise Mr.Ye";
			
		}else if(type.equals("tbo")) {
			Sx = 300;
			Sy = 300;
			
			
			deathP = 25;
			cashGive = 1000;
			funGive = 200;
			fullName = "THE BIG ONE";
			
		}else if(type.equals("space")) {
			Sx = 100;
			Sy = 100;
			
			
			deathP = 30;
			cashGive = 50;
			funGive = 40;
			fullName = "Space Race";
			
		}
		
		
	}
	
	public BaseBuilding(int posX, int posY){
		Px = posX;
		Py = posY;
		
	}
	
	public BaseBuilding(){
		
		
	}
	
	public void draw(Graphics g) {
		
		
		this.Mx = Px + (Sx/2);
		this.My = Py + (Sy/2);
		g.setColor(this.color);
		g.fillRect(Px, Py, Sx, Sy);
		g.setColor(new Color(0,0,0));
		g.drawRect(Px, Py, Sx, Sy);
		g.drawRect(Px + 5, Py + 5, Sx - 10, Sy - 10);
		g.drawString(fullName, Px, Py);
		g.drawString("Cash: "+ Integer.toString(cashGive) + "$", Px + 7, Py + 16);
		g.drawString("Death: "+ Integer.toString(deathP) + "%", Px + 7, Py + 28);
		g.drawString("Fun: "+ Integer.toString(deathP) + "pts", Px + 7, Py + 40);
		
		g.drawLine(Px + 5,My - 8,Px + Sx - 5, My - 8);
		
		g.drawString("Cash: "+ Integer.toString(cashGen) + "$", Px + 7, My + 5);
		g.drawString("Deaths: "+ Integer.toString(deaths), Px + 7, My + 17);
		g.drawString("Fun: "+ Integer.toString(totalFun) + "pts", Px + 7, My + 29);
		g.drawString("Visits: "+ Integer.toString(visits), Px + 7, My + 41);
		
	}
	
	
	
	
}
