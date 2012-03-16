package test.airport.context;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

public class AdvanceMultiplexer extends InputMultiplexer{
	public InputProcessor getInputProcessor(int i){
		return this.getProcessors().get(i);
	}

}
