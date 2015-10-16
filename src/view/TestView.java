package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Game;
import model.Tile;

public class TestView extends JPanel implements Observer{
	private Game game;
	private JTextArea textField;
	private static Font font = new Font("Monospaced", Font.PLAIN,12);
	private int hunterX,hunterY;
	private boolean[][] visible;
	public TestView(Game g){
	
		game = g;	
		visible = new boolean[game.getBoard().getXMax()][game.getBoard().getYMax()];
		for (int i = 0; i < visible.length; i++){
			for (int j = 0; j < visible[0].length; j++){
				visible[i][j] = false;
			}
		}
		textField = new JTextArea("Welcome");
		textField.setSize(600,600);
		setLayout(null);
		textField.setLocation(0,0);
		textField.setFont(font);
		hunterX = game.getHunterX();
		hunterY = game.getHunterY();
		visible[hunterX][hunterY] = true;
		textField.setText(this.drawBoard());
		add(textField);


			
	}
	private String drawBoard(){
		String printString = new String();
		for (int y = 0; y < game.getBoard().getXMax(); y++){
			for (int x = 0; x < game.getBoard().getYMax(); x++){
				if ((x == hunterX)&&(y == hunterY)){
					printString+= "[H]";
					visible[hunterX][hunterY] = true;
				} else 
					if (visible[x][y])
					printString+= this.tileOutput(game.getBoard().getTile(x,y));
					else 
						printString+=this.tileOutput(Tile.NOT_VISITED);
			}
			printString+="\n";
		}

		return printString;
	}
				

	private String tileOutput(Tile t){
		switch (t){
			case SLIME:
				return "[S]";
			case NONE:
				return "[ ]";
			case PIT:
				return "[P]";
			case BLOOD:
				return "[B]";
			case WUMPUS:
				return "[W]";
			case GOOP:
				return "[G]";
			case NOT_VISITED:
				return "[X]";
			default:
				return "[*]";
			}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		game = (Game) arg0;	
		hunterX = game.getHunterX();
		hunterY = game.getHunterY();
		String text = drawBoard()+game.getCurrentTile();
		if (game.isOver())
			text+="\n GAME OVER!";
		textField.setText(text);
				
	}


}
