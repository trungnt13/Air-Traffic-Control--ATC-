package test.airport.screen;

import test.airport.context.AdvanceMultiplexer;
import test.airport.gamecore.GameCore;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;


public abstract class GameScreen implements Screen {
	protected static  GameCore game;
	protected AdvanceMultiplexer multiplexer;
	protected SpriteBatch batch;
	
	@Override
	public void show(GameCore gamecore) {
		game = gamecore;
		this.multiplexer = game.getMultiplexer();
			
		Matrix4 projection = new Matrix4();
		projection.setToOrtho(0,(float)game.getWidth(), 0,(float)game.getHeight() , -1, 1);
	
		batch = new SpriteBatch();
		batch.setProjectionMatrix(projection);
		
		onLoadResource();
	}

	public abstract void onLoadResource();
	
	@Override
	public void dispose() {
		batch.dispose();
	}
	
	protected InputProcessor getInputProcessor(int ID){
		if(multiplexer != null)
			return this.multiplexer.getInputProcessor(ID);
		else return null;
	}
	
	protected void setScreen(Screen screen) {
		game.setScreen(screen);
	}
	
	protected int getWidth() {
		return game.getWidth();
	}
	
	protected int getHeight() {
		return game.getHeight();
	}
}
