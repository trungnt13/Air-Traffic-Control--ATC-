package test.airport.context;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Art {
	public static TextureAtlas uiAtlas;
	public static TextureAtlas gameAtlas;
	
	
	public static TextureRegion startRegion;
	public static TextureRegion exitRegion;
	
	public static TextureRegion background;
	public static TextureRegion plane;
	public static TextureRegion back;
	public static TextureRegion nextScreen;
	
	public static void load(){
		uiAtlas = new TextureAtlas(Gdx.files.internal("data/uiPack"));
		gameAtlas = new TextureAtlas(Gdx.files.internal("data/gamePack"));
	
		startRegion = uiAtlas.findRegion("rotate");
		exitRegion = uiAtlas.findRegion("blend");
		nextScreen = uiAtlas.findRegion("scale");
		
		background = gameAtlas.findRegion("background");
		plane = gameAtlas.findRegion("plane");
		back = gameAtlas.findRegion("car");
	}
}
