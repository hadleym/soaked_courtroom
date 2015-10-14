package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Board;
import model.Game;
import model.Hunter;
import model.Tile;

public class TestWumpus{

	@Test
	public void TestBoard(){
		int[][] slimes = {{1,1},{2,2},{9,9}};
		int[] wumpus = {3,3};
		Board board = new Board(10,10,wumpus,slimes);
		int[] i = board.getSize();
		assertEquals(10,i[0]);
		assertEquals(10,board.getSize()[1]);
		assertEquals("10,10", board.toString());
		assertEquals(Tile.PIT, board.getTile(1,1));
		assertEquals(Tile.PIT, board.getTile(2,2));
		assertEquals(Tile.PIT, board.getTile(9,9));
		
		assertEquals(Tile.SLIME, board.getTile(8,9));
		assertEquals(Tile.SLIME, board.getTile(slimes[1][0]-1, slimes[1][1]));
		assertEquals(Tile.GOOP, board.getTile(slimes[1][0]+1, slimes[1][1]));
		assertEquals(Tile.SLIME, board.getTile(slimes[1][0], slimes[1][1]-1));
		assertEquals(Tile.GOOP, board.getTile(slimes[1][0], slimes[1][1]+1));

		assertEquals(Tile.SLIME, board.getTile(slimes[2][0]-1, slimes[2][1]));
		assertEquals(Tile.SLIME, board.getTile(slimes[2][0]+1, slimes[2][1]));
		assertEquals(Tile.SLIME, board.getTile(slimes[2][0], slimes[2][1]-1));
		assertEquals(Tile.SLIME, board.getTile(slimes[2][0], slimes[2][1]+1));
		
		assertEquals(Tile.WUMPUS, board.getTile(wumpus[0],wumpus[1]));

		assertEquals(Tile.BLOOD, board.getTile(wumpus[0]-2,wumpus[1]));
		assertEquals(Tile.GOOP, board.getTile(wumpus[0]-1,wumpus[1]));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0]+1,wumpus[1]));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0]+2,wumpus[1]));

		assertEquals(Tile.BLOOD, board.getTile(wumpus[0],wumpus[1]-2));
		assertEquals(Tile.GOOP, board.getTile(wumpus[0],wumpus[1]-1));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0],wumpus[1]+1));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0],wumpus[1]+2));

		assertEquals(Tile.PIT, board.getTile(wumpus[0]-1,wumpus[1]-1));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0]+1,wumpus[1]-1));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0]-1,wumpus[1]+1));
		assertEquals(Tile.BLOOD, board.getTile(wumpus[0]+1,wumpus[1]+1));

		assertTrue(board.isTileDeadly(wumpus[0],wumpus[1]));
		assertTrue(board.isTileDeadly(slimes[0][0],slimes[0][1]));
		assertTrue(board.isTileDeadly(slimes[1][0],slimes[1][1]));
		assertTrue(board.isTileDeadly(slimes[2][0],slimes[2][1]));
	}

	@Test
	public void TestHunter (){
		Hunter h = new Hunter(1,1);
		assertEquals(1,h.getX());
		assertEquals(1,h.getY());
		h.setX(2);
		h.setY(-1);
		assertEquals(2,h.getX());
		assertEquals(-1,h.getY());

	}

	@Test
	public void TestGame(){
		Hunter h = new Hunter(5,4);
		int[][] pits = {{1,1},{2,2},{9,9}};
		int[] wumpus = {3,3};
		Board board = new Board(10,10,wumpus,pits);
		Game game = new Game(h, board);

		assertTrue(!game.isOver());
		assertEquals(5,game.getHunterX());
		assertEquals(4,game.getHunterY());

		game.moveNorth();
		assertEquals(5,game.getHunterX());
		assertEquals(3,game.getHunterY());
		assertTrue(!game.isOver());

		game.moveSouth();
		assertEquals(5,game.getHunterX());
		assertEquals(4,game.getHunterY());
		assertTrue(!game.isOver());
		
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();

		assertEquals(5,game.getHunterX());
		assertEquals(0,game.getHunterY());

		game.moveSouth();
		game.moveNorth();

		assertEquals(5,game.getHunterX());
		assertEquals(0,game.getHunterY());

		game.moveEast();

		assertEquals(6,game.getHunterX());
		assertEquals(0,game.getHunterY());

		game.moveEast();
		game.moveEast();
		game.moveEast();
		game.moveEast();
		assertEquals(0,game.getHunterX());

		game.moveEast();
		assertEquals(1,game.getHunterX());
		
		game.moveWest();
		game.moveWest();
		assertEquals(9,game.getHunterX());
		
		game.moveSouth();
		game.moveSouth();
		assertEquals(2,game.getHunterY());
		
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		game.moveSouth();
		assertEquals(9, game.getHunterY());

		game.moveSouth();
		assertEquals(0, game.getHunterY());
		game.moveNorth();

		assertEquals(9, game.getHunterY());
		assertEquals(9, game.getHunterX());
		assertTrue(game.isOver());

	}
}
