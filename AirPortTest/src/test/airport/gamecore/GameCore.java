package test.airport.gamecore;

import test.airport.context.AdvanceMultiplexer;
import test.airport.screen.Screen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public abstract class GameCore implements ApplicationListener{
	protected Screen screen;
	protected AdvanceMultiplexer multiInput;
	
	protected static int SCREEN_WIDTH;
	protected static int SCREEN_HEIGHT;
	
	@Override
	public void create() {
		multiInput = new AdvanceMultiplexer();
		Gdx.input.setInputProcessor(multiInput);
		
		SCREEN_WIDTH = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		
		onGameCreate();
	}
	/**
	 * Initialize all game com
	 */
	protected abstract void onGameCreate();


	@Override
	public void resize(int width, int height) {
		SCREEN_WIDTH = width;
		SCREEN_HEIGHT = height;
		if(screen != null)
			screen.resize(width, height);
		onGameChanged(width,height);
	}
	/**
	 * Listen to surface size
	 * @param width the screen width
	 * @param height the screen height
	 */
	protected abstract void onGameChanged(int width, int height);

	@Override
	public void render() {
		if(screen != null){
			screen.render(Gdx.graphics.getDeltaTime());
			screen.update(Gdx.graphics.getDeltaTime());
		}
		onGameRender(Gdx.graphics.getDeltaTime());
	}
	/**
	 * Render all stuff here
	 * @param DeltaTime the time each frame repeat
	 */
	protected abstract void onGameRender(float DeltaTime);
	
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if(screen != null)
			screen.pause();
		onGamePause();
	}

	private void onGamePause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		if(screen != null)
			screen.resume();
		onGameResume();
	}
	/**
	 * This method do the same function as resume
	 */
	protected abstract void onGameResume();
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		if(screen != null)
			screen.hide();
		onGameDestroy();
	}
	/**
	 * This method will release memory
	 */
	protected abstract void onGameDestroy();
	
	
	public void setScreen(Screen screen){
		if(this.screen != null)
			this.screen.hide();
		this.screen = screen;
		if(this.screen != null){
			screen.show(this);
			screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}
	
	public Screen getScreen(){
		return screen;
	}
	
	public AdvanceMultiplexer getMultiplexer(){
		return this.multiInput;
	}
	
	public void addInputProcessor(InputProcessor input,int ID){
		this.multiInput.addProcessor(ID, input);
	}
	
	public int getWidth(){
		return this.SCREEN_WIDTH;
	}
	
	public int getHeight(){
		return this.SCREEN_HEIGHT;
	}
}
