import Amusmant_super.ClownTown;
import Amusmant_super.FerrisWheel;
import Amusmant_super.SnackShack;
import Amusmant_super.SpaceRace;
import Amusmant_super.TheBigOne;
import Amusmant_super.Ye;

public class Main {

	public static void main(String[] args) {
			
		Game newgame = new Game();
		
		ClownTown ct = new ClownTown(10,10,10);
		FerrisWheel fw = new FerrisWheel(10,20,30);
		SnackShack ss = new SnackShack(40,40,50);
		SpaceRace sr = new SpaceRace(50,50,50);
		TheBigOne tbo = new TheBigOne(60,60,60);
		Ye ye = new Ye(50,60,70);
		
		
		
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
