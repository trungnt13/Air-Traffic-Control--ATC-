package test.airport.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Button extends View{
	TextureRegion upRegion;
	TextureRegion downRegion;
	
	public Button(){	
		
	}
	
	public void test(){
		Gdx.app.log("test", ""+ Gdx.input.getX());
	}
}
