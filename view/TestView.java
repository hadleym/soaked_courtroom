package view;

import java.util.Observable;
import java.util.Observer;

import model.Game;

public class TestView implements Observer{
	public TestView(){

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(arg0.toString());
	}


}
