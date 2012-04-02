package test.airport.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import test.airport.context.Art;
import test.airport.context.MyInput;
import test.airport.context.R;
import test.airport.gamecore.GameCore;
import test.airport.screen.StartScreen;
import test.easy.admin.eAdmin;
import test.easy.admin.eMultiplexer;

public class ATCGame extends GameCore{
	MyInput input;
	
	SpriteBatch batch ;
	
	@Override
	protected void onGameCreate() {
		input = new MyInput(R.input.MyInput);
		eAdmin.einput.addProcessor(input);
		
		/**
		 * true will enable BackKey
		 */
		Gdx.input.setCatchBackKey(true);
		Art.load();	
//		Texture tex = new Texture(Gdx.files.internal("data/plane.png"));
//		batch =  new SpriteBatch();
//		batch.begin();
//		batch.draw(tex,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//		batch.end();
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
