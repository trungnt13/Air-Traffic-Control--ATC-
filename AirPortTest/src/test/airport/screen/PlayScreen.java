package test.airport.screen;

import test.airport.context.Art;
import test.airport.context.MyInput;
import test.airport.context.R;
import test.airport.utils.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.math.Vector2;

public class PlayScreen extends GameScreen{
	StartScreen parent;
	
	Vector2 pos;
	Vector2 speed;
	
	Button b = new Button();
	
	MyInput input;
	
	
	
	public PlayScreen(StartScreen parent) {
		this.parent = parent;
	}

	@Override
	public void onLoadResource() {
		input = (MyInput) getInputProcessor(R.input.MyInput);
		pos = new Vector2(0, 0);
		speed = new Vector2(5, 5);
		
		batch.enableBlending();
		batch.setBlendFunction(GL11.GL_SRC0_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.disableBlending();
		batch.draw(Art.background, 0, 0, getWidth(), getHeight());
		
		batch.enableBlending();
		batch.draw(Art.plane, pos.x, pos.y);
		batch.draw(Art.back,getWidth()/2 - Art.back.getRegionWidth()/2,
							getHeight()/2 - Art.back.getRegionHeight()/2);

		batch.end();
	}

	@Override
	public void update(float delta) {
		pos.x += speed.x;
		pos.y += speed.y;
		
		if(pos.x >= getWidth()-Art.plane.getRegionWidth())
			speed.x = - 5;
		else if(pos.x <= 0)
			speed.x = 5;
		if(pos.y >= getHeight()-Art.plane.getRegionHeight())
			speed.y = - 5;
		else if(pos.y <= 0)
			speed.y = 5;
		
		if(input.justDown){
			if(input.getX() >= getWidth()/2 - Art.back.getRegionWidth()/2 && 
			   input.getX() <= getWidth()/2 + Art.back.getRegionWidth()/2 &&
			   input.getY() >= getHeight()/2 - Art.back.getRegionHeight()/2 &&
			   input.getY() <= getHeight()/2  + Art.back.getRegionHeight()/2){
				setScreen(new GoAroundScreen());
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	

}
