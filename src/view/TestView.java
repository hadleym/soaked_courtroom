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
	public TestView(Game g){

		game = g;	
		textField = new JTextArea("Welcome");
		textField.setSize(600,600);
		setLayout(null);
		textField.setLocation(0,0);
		textField.setFont(font);
		hunterX = game.getHunterX();
		hunterY = game.getHunterY();
		textField.setText(this.drawBoard());
		add(textField);


			
	}
	private String drawBoard(){
		String printString = new String();
		for (int y = 0; y < game.getBoard().getXMax(); y++){
			for (int x = 0; x < game.getBoard().getYMax(); x++){
				if ((x == hunterX)&&(y == hunterY))
					printString+= "[H]";
				else 
					printString+= this.tileOutput(game.getBoard().getTile(x,y));
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
			default:
				return "[X]";
			}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		game = (Game) arg0;	
		hunterX = game.getHunterX();
		hunterY = game.getHunterY();
		textField.setText(drawBoard());
		
	}


}
