package model;

public class Hunter{
	private int x,y;
	public Hunter(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}
	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int xPos){ x = xPos;}
	public void setY(int yPos){ y = yPos;}
}
