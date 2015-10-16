package model;


public class Board {
	private Tile[][] board;
	private int[][] pitTiles;
	private int width;
	private int height;
	private int[] wumpusTile;
	public Board(int x, int y, int[] wumpus, int[][] p){
		pitTiles = p;
		width = x;
		height = y;
		wumpusTile = wumpus;
		board = new Tile[width][height];
		for (int i =0; i < height; i++){
			for (int j =0; j< width; j++){
				board[j][i] = Tile.NONE;
			}
		}
		addPit();
		addWumpus();
		
	}		
	private void addWumpus(){
		board[wumpusTile[0]][wumpusTile[1]] = Tile.WUMPUS;
		setTile(wumpusTile[0],wumpusTile[1]+1, Tile.BLOOD);
		setTile(wumpusTile[0],wumpusTile[1]+2, Tile.BLOOD);
		setTile(wumpusTile[0],wumpusTile[1]-1, Tile.BLOOD);
		setTile(wumpusTile[0],wumpusTile[1]-2, Tile.BLOOD);
		setTile(wumpusTile[0]+1,wumpusTile[1], Tile.BLOOD);
		setTile(wumpusTile[0]+2,wumpusTile[1], Tile.BLOOD);
		setTile(wumpusTile[0]-1,wumpusTile[1], Tile.BLOOD);
		setTile(wumpusTile[0]-2,wumpusTile[1], Tile.BLOOD);
		setTile(wumpusTile[0]-1,wumpusTile[1]-1, Tile.BLOOD);
		setTile(wumpusTile[0]-1,wumpusTile[1]+1, Tile.BLOOD);
		setTile(wumpusTile[0]+1,wumpusTile[1]-1, Tile.BLOOD);
		setTile(wumpusTile[0]+1,wumpusTile[1]+1, Tile.BLOOD);
	}
	public boolean isTileDeadly(int x, int y){
		return (board[x][y] == Tile.WUMPUS || board[x][y] == Tile.PIT);
	}
			

	private void addPit(){
		for (int[] l : pitTiles){
			board[l[0]][l[1]] = Tile.PIT;
			setTile(l[0]-1,l[1], Tile.SLIME);
			setTile(l[0]+1,l[1], Tile.SLIME);
			setTile(l[0],l[1]-1, Tile.SLIME);
			setTile(l[0],l[1]+1, Tile.SLIME);
		}
	}
	public void setTile(int x, int y, Tile t){
		if (x >= width) x = x%width;
		if (x < 0 ) x = width + x;
		if (y >= height) y = y%height;
		if (y < 0 ) y = height + y;
		if ((t == Tile.SLIME) && (board[x][y] == Tile.NONE)) board[x][y] = Tile.SLIME;
		else if (t == Tile.BLOOD) {
			if (board[x][y] == Tile.NONE)
				board[x][y] = Tile.BLOOD;
			else if (board[x][y] == Tile.SLIME)
				board[x][y] = Tile.GOOP;
		}
	}
	public int[] getSize(){
		int[] returnArray = {width,height};
		return returnArray;
	}
	public Tile getTile(int x, int y){
		if (x >= width) x = x%width;
		if (x < 0 ) x = width + x;
		if (y >= height) y = y%height;
		if (y < 0 ) y = height + y;
		return board[x][y];
	}
	@Override
	public String toString(){
		return getSize()[0] +","+getSize()[1];
	}

}
