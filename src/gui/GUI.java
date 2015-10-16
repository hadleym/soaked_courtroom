package gui;

import javax.swing.JFrame;

import controller.Controller;

import model.Board; import model.Game; import model.Hunter; import
view.TestView;

public class GUI extends JFrame{ public static void main(String[] args) { GUI
	window = new GUI(); window.setVisible(true); }

	
	public GUI(){
		
		int[][] pits = {{1,1},{2,2},{9,9}};
		int[] wumpus = {3,3};
		Game game = new Game(new Hunter(8,8), new Board(10,10,wumpus,pits));
		Controller controller = new Controller(game);
		TestView testView = new TestView(game);
		game.addObserver(testView);
		testView.setLocation(100,10);
		testView.setSize(300,300);
		controller.setLocation(100,350);
		controller.setSize(300,100);
		controller.setFocusable(true);
		this.addKeyListener(controller);
		add(controller);
		add(testView);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,100);
		setSize(500,500);
		setLayout(null);
		this.setFocusable(true);

	}
}
