package test.airport.screen;

import java.util.ArrayList;
import java.util.List;

import test.airport.graphics.Layout;
import test.airport.utils.eMath;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Filter;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class TileMapScreen extends GameScreen{
	PlayScreen parent;
	Texture texture1;
	
	Sprite plane;
	SpriteBatch batch;
	
	Vector2 speed;
	
	static final int MAX = 1000;
	List<Vector2> path = new ArrayList<Vector2>(1000);
	
	Texture texture;
	TextureRegion region;
	
	Pixmap  pixmap;	
	
	float SPEED = 2;
	
	int current = 0;
	
	boolean change = false;
	
	Vector2 pathPos = new Vector2(100, 300);
	
	public TileMapScreen(PlayScreen screen){
		this.parent = screen;
		texture1 = new Texture(Gdx.files.internal("data/plane.png"));
		
		batch = new SpriteBatch();
		
		plane = new Sprite(texture1);
		plane.setPosition(100, 300);
		
		speed = new Vector2(0, 0);
	}
	
	@Override
	public void onLoadResource() {
		path.add(pathPos);
		while(pathPos.x <= 499.99f){
			Vector2 v = calSpeed(2, new Vector2(pathPos.x, pathPos.y));
			float x = pathPos.x;
			float y = pathPos.y;
			pathPos = new Vector2(x + v.x, y + v.y);
			path.add(pathPos);
			
		}
		
//		path.add( new Vector2(500, getYinCircle(500, new Vector2(300, 300), 200)));
		
		int size = path.size()-1;
		for(int i = size ; i >= 0;i--){
			path.add(new Vector2(path.get(i).x, 
								 600 - path.get(i).y));		
		}
	
		texture = new Texture(1024, 1024, Format.RGBA8888);
		Pixmap.setBlending(Blending.None);
		Pixmap.setFilter(Filter.BiLinear);
		pixmap = new Pixmap(getWidth(),getHeight(), Format.RGBA8888);
		
//		texture = new Texture(pixmap);
		
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		pixmap.setColor(Color.RED);
		for(int i = 0;i< path.size()-1;i++){
			pixmap.drawLine((int)path.get(i).x,   getHeight()-(int) path.get(i).y , 
							(int)path.get(i+1).x, getHeight() -(int)path.get(i+1).y);
//			Gdx.app.log("test", "" + path.get(i).x);
		}
		texture.draw(pixmap,0, 256);
		texture.bind();	
	}
	
	@Override
	public void onRender(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	
//		Vector2 v = calSpeed(1, new Vector2(plane.getX(), plane.getY()));
//		plane.translate(v.x, v.y);
		Gdx.app.log("test", "" +  path.get(current).x+ " " + path.get(current).y);
		plane.setPosition(path.get(current).x, path.get(current).y);
		batch.begin();
		plane.draw(batch);
		batch.draw(texture1,0,getHeight()-200);
		batch.draw(texture,0,0);
		batch.end();		
	
		if(current < path.size()-1){
			current ++;
		}else
			current = 0;
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
	}

	@Override
	public void resize(int width, int height) {

		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
	
	}
	
	public Vector2 calSpeed(float speed,Vector2 currentPos){
		float x = currentPos.x;
		Vector2 dst = new Vector2(x+1, getYinCircle(x+1, new Vector2(300, 300), 200));
	
		while(eMath.calModule(currentPos, dst) < Math.abs(speed) ){
			x++;
			dst.set(x+1, getYinCircle(x+1, new Vector2(300, 300), 200));
		}
//		Gdx.app.log("test", "" + eMath.calModule(currentPos, dst));
//		Gdx.app.log("vector", "" + dst.x + " " + dst.y);
		float a = eMath.getAngleFactor(currentPos, dst);
		double angle =  Math.atan(a);
//		Gdx.app.log("test", "" +  Math.toDegrees(angle) + " " + currentPos.x + " " + currentPos.y);
//		Gdx.app.log("vector", "" + dst.x + " " + dst.y);
	
		return new Vector2((float)Math.cos(angle) * speed , 
						   (float)Math.sin(angle) * speed );
	}
	
	public float getYinCircle(float x,Vector2 center,float radius){
		return (float) (Math.sqrt( Math.abs( radius*radius - Math.pow((x - center.x),2)))) + center.y;
	}
	
	public float getYinCircle1(float x,Vector2 center,float radius){
		return (float) (-Math.sqrt(radius*radius - Math.pow((x - center.x),2))) + center.y;
	}

	@Override
	public Layout onCreateLayout() {
		// TODO Auto-generated method stub
		return null;
	}
}
