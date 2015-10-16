package model;
import java.util.Observable;
import java.util.Observer;

public class Game extends Observable{
	private Hunter hunter;
	private Board board;
	private boolean isGameOver;
	public Game(Hunter h, Board b){
		hunter = h;
		board = b;
		isGameOver = false;
	}
	
	@Override
	public String toString(){
		return this.getCurrentTile();
	}
	public boolean isOver(){
		return(isGameOver = board.isTileDeadly(hunter.getX(), hunter.getY()));
	}
	public void move(Dir d){
		if (!isGameOver){
			switch(d){
				case EAST:
					moveEast();
					break;
				case WEST:
					moveWest();
					break;
				case NORTH:
					moveNorth();
					break;
				case SOUTH:
					moveSouth();
					break;
				default:
			}	
			setChanged();
			notifyObservers(this);
		}

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

	public String getCurrentTile(){
		return board.getTile(hunter.getX(), hunter.getY()).toString();

	}	

	public Board getBoard(){
		return board;
	}

}
