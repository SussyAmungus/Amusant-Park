package Amusmant_super;

public class Attraction {

	public int visits = 0;
	public int deaths = 0;
	public int cashGenerated = 0;
	public int fun = 0;
	
	
	public int deathP = 0;
	public int cashP = 0;
	public int funP = 0;
	
	
	
	public Attraction(int cash, int death, int fun) {
		
		cashP = cash;
		funP = fun;
		deathP = death;
		
		
		
	}
	
	public void init() {
		
		
		
	}
	public void addCash(int adder) {
		
		
		cashGenerated = cashGenerated + adder;
	}
	public void addDeath(int adder) {
		
		deaths = deaths + adder;
		
	}
	
	
	
}
