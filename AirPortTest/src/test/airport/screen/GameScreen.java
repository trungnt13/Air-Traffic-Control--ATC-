package test.airport.screen;

import test.airport.context.AdvanceMultiplexer;
import test.airport.gamecore.GameCore;
import test.airport.graphics.Layout;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;


public abstract class GameScreen implements Screen {
	protected static  GameCore game;
	protected SpriteBatch batch;
	
	protected Layout layout = null;
	@Override
	public void show(GameCore gamecore) {
		game = gamecore;
			
		Matrix4 projection = new Matrix4();
		projection.setToOrtho(0,(float)game.getWidth(), 0,(float)game.getHeight() , -1, 1);
	
		batch = new SpriteBatch();
		batch.setProjectionMatrix(projection);
		
		onLoadResource();
		layout = onCreateLayout();
	}

	public abstract void onLoadResource();
	
	public abstract Layout onCreateLayout();
	
	@Override
	public void dispose() {
		batch.dispose();
	}
	
	
	@Override
	public void render(float delta) {
		onRender(delta);
		if(layout!= null)
			layout.apply();
	}

	public abstract void onRender(float delta);
	
	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
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
