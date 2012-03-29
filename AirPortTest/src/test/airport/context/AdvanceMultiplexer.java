package test.airport.context;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

public class AdvanceMultiplexer extends InputMultiplexer{
	
	
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		super.touchDown(x, y, pointer, button);
		return false;
	}


	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return super.touchUp(x, y, pointer, button);
	}


	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return super.touchDragged(x, y, pointer);
	}


	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return super.touchMoved(x, y);
	}


	public InputProcessor getInputProcessor(int i){
		return this.getProcessors().get(i);
	}

}
