package gui;

import javax.swing.JFrame;

import controller.Controller;

import model.Board;
import model.Game;
import model.Hunter;
import view.TestView;

public class GUI extends JFrame{
	public static void main(String[] args) {
		GUI window = new GUI();
		window.setVisible(true);
	}

	
	public GUI(){
		
		int[][] pits = {{1,1},{2,2},{9,9}};
		int[] wumpus = {3,3};
		Game game = new Game(new Hunter(8,8), new Board(10,10,wumpus,pits));
		Controller controller = new Controller(game);
		TestView testView = new TestView();
		game.addObserver(testView);
		add(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setSize(250,500);
		setLayout(null);

	}
}