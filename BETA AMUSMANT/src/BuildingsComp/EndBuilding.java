package BuildingsComp;

import java.awt.Color;
import java.awt.Graphics;

public class EndBuilding {
	public int Px = 1000;
	public int Py = 200;
	
	public int Sx = 25;
	public int Sy = 50;
	
	public Color color = new Color(255,0,0);
	
	public EndBuilding(int posX, int posY){
		
		Px = posX;
		Py = posY;
		
	}
	
	public EndBuilding(){
		
		
	}
	
	public void draw(Graphics g) {
		
		
		g.setColor(this.color);
		g.fillRect(Px, Py, Sx, Sy);
	
		
	}
}
