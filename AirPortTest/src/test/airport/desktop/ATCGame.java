package test.airport.desktop;

import test.airport.context.Art;
import test.airport.context.MyInput;
import test.airport.context.R;
import test.airport.gamecore.GameCore;
import test.airport.screen.StartScreen;

public class ATCGame extends GameCore{
	MyInput input;

	@Override
	protected void onGameCreate() {
		input = new MyInput();
		addInputProcessor(input,R.input.MyInput);
		
		Art.load();
		
		screen = new StartScreen();	
		screen.show(this);
	}

	@Override
	protected void onGameChanged(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onGameRender(float DeltaTime) {
		
	}

	@Override
	protected void onGameResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onGameDestroy() {
		// TODO Auto-generated method stub
		
	}

}
