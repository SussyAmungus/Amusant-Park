import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import BuildingsComp.BaseBuilding;

public class MouseAction extends MouseAdapter implements MouseMotionListener{
	
	 private BaseBuilding selected;
	 public ArrayList<BaseBuilding> BuildList;
	 
	 private BuildingArea BA;
	 
     private Point hit;
     public Boolean isHeld = false;
     
     private int deltaX = 0;
     private int deltaY = 0;
     
     private int lastX;
     private int lastY;
     
     public Boolean isValid = true;
     public Boolean special = false;

     public PointerInfo PI;
     public Point currentPoint;
     
	public MouseAction(ArrayList<BaseBuilding> BL, BuildingArea BA) {
		
		PI = MouseInfo.getPointerInfo();
		currentPoint = PI.getLocation();
		
		this.BA = BA;
		
		BuildList = BL;
	
		
	     
	}
	
	public void mouseMoved(MouseEvent e) {
		
		
		if(selected != null && isHeld == true) {
			
			special = true;
	            int x = e.getX();
	            int y = e.getY();
	            selected.Px = x - selected.Sx/2;
	            selected.Py = y - selected.Sy/2;
	            BA.repaint();
	            
	            if(this.isNotIntersecting(e)) {
	            	
					lastX = selected.Px;
		            lastY = selected.Py;
					isValid = true;
					
				}else if(this.isNotIntersecting(e) == false) {
					
					isValid = false;
					
				}
	            
		}
		
		
	}
	
	
	public void mousePressed(MouseEvent e) {
		
		
		
	    if (e.getButton() == MouseEvent.BUTTON1) {
	    	selected = (BaseBuilding) getCurrentR(e);
	    	
	    	if(selected != null && special == true && isValid == false) {
	    		
	    		selected.Px = lastX;
	    		selected.Py = lastY;
	    		

	    		
	    		
	    	}	
	    	
	    	if(selected != null) {
	    		
	    		lastX = selected.Px;
	    		lastY = selected.Py;
	    		
	    		deltaX = e.getX() - selected.Px;
		    	deltaY = e.getY() - selected.Py;
		    	
	    	}
	        
	    }
	}

	public void mouseReleased(MouseEvent e) {
		
		 deltaX = 0;
	     deltaY = 0;
		
	    if (e.getButton() == MouseEvent.BUTTON1) {
	     
	    	
	    	
	    	if(isValid == false) {

				selected.Px = lastX;
				selected.Py = lastY;
				
			}
	    	
	      selected = null;
	    }
	    
	    BA.repaint();
	    isHeld = false;
	    isValid = true;
	}
	
	
    @Override
    public void mouseDragged(MouseEvent e) {
    	
        if (selected != null) {
        	
        	
            int x = e.getX();
            int y = e.getY();
            selected.Px = x - deltaX;
            selected.Py = y - deltaY;
          
            if(this.isNotIntersecting(e)) {
        		lastX = selected.Px;
                lastY = selected.Py;
				isValid = true;
				
			}else if(this.isNotIntersecting(e) == false) {
				
				isValid = false;
				
			}
            
            
            BA.repaint();
            
        }
    }
    
     //other method
     public Rectangle getCurrentR(MouseEvent e) {
    	 
    	 for(int i = 0; i < BuildList.size(); i++ ) {
    		 
    		 double rectX = BuildList.get(i).Px;
    		 double rectY = BuildList.get(i).Py;
    		 double rectWidth = BuildList.get(i).Sx;
    		 double rectHeight = BuildList.get(i).Sy;
    	
    		 
    		 if (e.getX() > rectX && e.getX() < rectX + rectWidth && e.getY() > rectY && e.getY() < rectY + rectHeight) {
               
                 return BuildList.get(i);
             }
    		 
    	 }
    	 
    	 return null;
    	 
     }
     
     
     public Boolean isNotIntersecting(MouseEvent e) {
    	 
    	 if((selected.Px + selected.Sx > BA.SB.Px && selected.Px < BA.SB.Px + BA.SB.Sx) && (selected.Py + selected.Sy > BA.SB.Py && selected.Py < BA.SB.Py +BA.SB.Sy)) {
			 
 			
			 return false;
		 }
    	 if((selected.Px + selected.Sx > BA.EB.Px && selected.Px < BA.EB.Px + BA.EB.Sx) && (selected.Py + selected.Sy > BA.EB.Py && selected.Py < BA.EB.Py +BA.EB.Sy)) {
			 
  			
			 return false;
		 }
    	
    	 for(int i = 0; i < BuildList.size(); i++) {
    		 
    		 if(selected == BuildList.get(i)) continue;
    		 
   
    		 if((selected.Px + selected.Sx > BuildList.get(i).Px && selected.Px < BuildList.get(i).Px + BuildList.get(i).Sx) &&
    				 (selected.Py + selected.Sy > BuildList.get(i).Py && selected.Py < BuildList.get(i).Py + BuildList.get(i).Sy)) {
    			 
    			
    			 return false;
    		 }
    	 }
    	 
    	
    	 return true;
     }
     
     

     public BaseBuilding getSelected() {
 		
 		
 		return selected;
 	}
     
    public void setSelected(BaseBuilding BB) {
    	
    	selected = BB;
    	
    }
    
    
    public int getX() {
    	
    	
    	return (int) currentPoint.getX();
    }
    public int getY() {
    	
    	
    	return (int) currentPoint.getY();
    }  
     
}
