package model;

public enum Tile {
	NONE(0),BLOOD(1),SLIME(2), PIT(3), WUMPUS(4), GOOP(5);
	int value;
	Tile(int val){
		value = val;
	}
	public int getValue(){
		return value;
	}

	public String toString(){
		String retString;
		switch (value){
			case(0):
				retString = "NONE";
				break;
			case(1):
				retString = "BLOOD";
				break;
			case(2): 
				retString = "SLIME";
				break;
			case(3):
				retString = "PIT";
				break;
			case(4):
				retString = "WUMPUS";
				break;
			case(5):
				retString = "GOOP";
				break;
			default:
				retString = "ERROR";
			
		}	
		return retString;
	}
	
}
