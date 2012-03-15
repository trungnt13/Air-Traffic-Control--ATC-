package test.easy;


import org.lwjgl.opengl.GL11;

import test.eUtils.MyInput;
import test.easyWay.AirPlane;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Filter;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class PixmapTest implements ApplicationListener{
	public static int SCREEN_WIDTH  = 800;
	public static int SCREEN_HEIGHT = 480;

	SpriteBatch batch;
	MyInput input;
	
	Texture texture;
	Pixmap pixmap;
	
	Texture plane;
	
	Texture background;
	Sprite backgroundSprite;
	float rateX;
	float rateY;
	
	Vector2 prePoint;
	Vector2 pos;
	
	AirPlane test;

	float Timer=0;
	
	int cur;
	int count=0;
	
	boolean draw = true;
	ShapeRenderer renderer;
	PerspectiveCamera cam;
	@Override
	public void create() {
		
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		SCREEN_WIDTH = Gdx.graphics.getWidth();
		
		input = new MyInput();
		
		batch = new SpriteBatch();
		batch.enableBlending();
		batch.setBlendFunction(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		Pixmap.setBlending(Blending.None);
		Pixmap.setFilter(Filter.NearestNeighbour);
		pixmap = new Pixmap(1024, 512, Pixmap.Format.RGBA8888);
		texture = new Texture(pixmap);
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture.draw(pixmap, 0, 0);
		texture.bind();
		
		plane = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));
		
		
		background = new Texture(Gdx.files.internal("data/stones.jpg"));
		rateX = SCREEN_WIDTH/background.getWidth();
		rateY = SCREEN_HEIGHT/background.getHeight();
		
		backgroundSprite = new Sprite(background);
		backgroundSprite.setOrigin(0, 0);
		backgroundSprite.setScale(rateX, rateY);
		backgroundSprite.setPosition(0, 0);
			
		cur = 0;
		
		test = new AirPlane(plane, input);
		pos = new Vector2();
		prePoint = new Vector2(0,0);
		
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		Gdx.gl.glEnable(GL10.GL_LINE_SMOOTH);
		texture.draw(pixmap, 0, 0);
		
		batch.begin();
		
		batch.disableBlending();
		backgroundSprite.draw(batch);
		
		batch.enableBlending();
		batch.draw(texture,0,0);
		batch.draw(plane,test.getPosX(),test.getPosY());
		batch.end();
		
	
		update();
	}

	private void update() {
		//Test the method draw when drag
//		if(input.justDown){
//			prePoint.set(input.getX(), input.getY());
//		}
//		if(input.isDragging){
//			pixmap.setColor(Color.RED);
//			pixmap.drawLine((int)prePoint.x,SCREEN_HEIGHT -(int)prePoint.y, 
//							(int)input.getX(),SCREEN_HEIGHT-(int)input.getY());
//			prePoint.set(input.getX(), input.getY());
//		}
//		if(input.justUp){
//			pixmap.setColor(Color.CLEAR);
//			pixmap.fill();
//		}
//		Gdx.app.log("test", "" + test.getTracker().size() + " " + test.getCURRENT());

		for(int i = 0;i < test.getTracker().size()-1;i++){
			
			pixmap.setColor(Color.RED);
			pixmap.drawLine((int)test.getTracker().get(i).x,  SCREEN_HEIGHT - (int)test.getTracker().get(i).y,
							(int)test.getTracker().get(i+1).x,SCREEN_HEIGHT -(int)test.getTracker().get(i+1).y);
		}

		//Test getXinLine and YinLine
//		pixmap.setColor(Color.RED);
//		pixmap.drawLine(100, 200, 500, 800);
//		
//		pixmap.setColor(Color.BLUE);
//		pixmap.fillCircle(eMath.getXinLine(400, new Vector2(100, 200), new Vector2(500, 800)),400 ,2);

		test.update(Gdx.graphics.getDeltaTime());
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
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
