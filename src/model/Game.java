package model;

public class Game{
	private Hunter hunter;
	private Board board;
	public Game(Hunter h, Board b){
		hunter = h;
		board = b;
	}
	
	public boolean isOver(){
		return board.isTileDeadly(hunter.getX(), hunter.getY());
	}
		
	public void moveWest(){
		int x = hunter.getX();
		x--;
		if (x<0) x = board.getSize()[0]+x;
		hunter.setX(x);
	}

	public void moveEast(){
		int x = hunter.getX();
		x++;
		if (x>=board.getSize()[0]) x = x%board.getSize()[0];
		hunter.setX(x);
	}

	public void moveSouth(){
		int y = hunter.getY();
		y++;
		if(y>=board.getSize()[1]) y = y%board.getSize()[1];

		hunter.setY(y);
	}

	public void moveNorth(){
		int y = hunter.getY();
		y--;
		if(y<0) y = board.getSize()[1]+y;
		hunter.setY(y);
	}

	public int getHunterX(){
		return hunter.getX();
	}

	public int getHunterY(){
		return hunter.getY();
	}
}

