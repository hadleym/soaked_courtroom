package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Board;
import model.Dir;
import model.Game;
import model.Hunter;

public class Controller extends JPanel{
	JButton north,south,east,west;
	Game game;
	JTextField textField;
	public Controller(Game g){
		textField = new JTextField(10);
		north = new JButton("North");
		south = new JButton("South");
		east = new JButton("East");
		west = new JButton("West");
		north.addActionListener( new NorthActionListener());
		west.addActionListener( new WestActionListener());
		east.addActionListener( new EastActionListener());
		south.addActionListener( new SouthActionListener());
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(textField, BorderLayout.CENTER);
		game = g;
		setSize(250,500);
		setLocation(0,0);	
	}
	
	private class NorthActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			game.move(Dir.NORTH);
			textField.setText(game.getCurrentTile());
		}
	}
	private class SouthActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			game.move(Dir.SOUTH);
			textField.setText(game.getCurrentTile());
		}
	}
	private class EastActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			game.move(Dir.EAST);
			textField.setText(game.getCurrentTile());
		}
	}
	private class WestActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			game.move(Dir.WEST);
			textField.setText(game.getCurrentTile());
		}
	}


}