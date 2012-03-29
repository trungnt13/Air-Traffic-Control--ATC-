package test.airport.screen;

import test.airport.context.Art;
import test.airport.context.MyInput;
import test.airport.context.R;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

public class StartScreen extends GameScreen {
	MyInput input;
	
	Vector2 posStart; 
	
	Vector2 posExit;
	
	public StartScreen(){
		
	}
	
	@Override
	public void onLoadResource() {
		input = (MyInput) getInputProcessor(R.input.MyInput);
		
		posStart = new Vector2(getWidth()/2-Art.startRegion.getRegionWidth()/2, 
				   		 	   getHeight()/3-Art.startRegion.getRegionHeight()/2);

		posExit = new Vector2(getWidth()/2-Art.exitRegion.getRegionWidth()/2, 
							  2*getHeight()/3 - Art.exitRegion.getRegionHeight()/2);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(Art.startRegion, posStart.x, posStart.y);
		batch.draw(Art.exitRegion,posExit.x,posExit.y);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float DeltaTime) {
		if(input.justDown){
			if(input.getX() >= posStart.x && 
			   input.getX() <= posStart.x + Art.startRegion.getRegionWidth() &&
			   input.getY() >= posStart.y &&
			   input.getY() <= posStart.y + Art.startRegion.getRegionHeight()){
			   setScreen(new TestingScreen());

				Gdx.app.log("Start", "" );
			}
			if(input.getX() >= posExit.x && 
			   input.getX() <= posExit.x + Art.exitRegion.getRegionWidth() &&
			   input.getY() >= posExit.y &&
			   input.getY() <= posExit.y + Art.exitRegion.getRegionHeight()){
				Gdx.app.exit();
				Gdx.app.log("exit", "");
			}
		
		}
	}



}
