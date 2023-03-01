package BuildingsComp;

import java.awt.Color;
import java.awt.Graphics;

public class StartBuilding {

	public int Px = 50;
	public int Py = 200;
	
	public int Sx = 25;
	public int Sy = 50;
	
	public Color color = new Color(0,255,0);
	
	public StartBuilding(int posX, int posY){
		
		Px = posX;
		Py = posY;
		
	}
	
	public StartBuilding(){
		
		
	}
	
	public void draw(Graphics g) {
		
		
		g.setColor(this.color);
		g.fillRect(Px, Py, Sx, Sy);
	
		
	}
	
	
	
}
