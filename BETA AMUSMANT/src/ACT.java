import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import BuildingsComp.BaseBuilding;
import Peoples.BasePeople;
import WindowComps.BuildingBttn;

public class ACT implements ActionListener, MouseListener{

	private Window WW;
	
	private MouseAction MA;
	
	public ArrayList<BaseBuilding> BuildList;
	
	public ArrayList<BuildingBttn> bbl;
	public ArrayList<BasePeople> PeopleList;
	
	private Runner holder;
	
	private Game Game;
	public ImageIcon dab  = new ImageIcon(getClass().getClassLoader().getResource("scary.jpg"));
	public AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("spook.wav"));
	public Clip clip = AudioSystem.getClip();

	
	public ACT(Window WW, ArrayList<BaseBuilding>  BL,ArrayList<BasePeople> PeopleList, Game Game ) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		this.Game = Game;
		this.PeopleList = PeopleList;
		this.BuildList = BL;
		this.WW = WW;
		this.MA = WW.MA;
		
		bbl = WW.itembar.bttnList;
		
		WW.playbtn.texta.addActionListener(this);
		WW.cogbtn.addActionListener(this);
		
		for(int i = 0; i < bbl.size(); i++) {
			
			bbl.get(i).Button.addMouseListener(this);
			
		}
			
		
		try {
			clip.open(audioStream);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void setThread(Runner r) {
		
		
		this.holder = r;
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == WW.cogbtn) {
			
			
			clip.start();
			
			JOptionPane.showMessageDialog(null, "ss", "haha", JOptionPane.INFORMATION_MESSAGE, dab);
			
			clip.stop();
			clip.setMicrosecondPosition(0);
			
		}
		
		
		
		// TODO Auto-generated method stub
		if(e.getSource() == WW.playbtn.texta) {
			
			if(Game.canEdit == false) {
				
				return;
				
			}
			
			
			
			synchronized(holder){
				Game.enters = 0;
				Game.exits = 0;
				
				holder.notify();
			}
			
			
			
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		for(int i = 0; i < bbl.size(); i++) {
			
			if(Game.canEdit == false) {
				
				return;
				
			}
			if(e.getSource() == bbl.get(i).Button) {
				
				
				//add the code to make a building obj 
				
				BaseBuilding temp = new BaseBuilding(MA.getX(), MA.getY(), bbl.get(i).Type);
				
				
				
				BuildList.add(temp);
				
				MA.setSelected(temp);
				
				MA.isHeld = true;
				
			}
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
