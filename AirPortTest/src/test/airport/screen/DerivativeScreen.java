package test.airport.screen;

import java.util.ArrayList;
import java.util.List;

import test.airport.graphics.Layout;
import test.airport.utils.math.FunctionSet;
import test.airport.utils.math.CircleFunction;
import test.airport.utils.math.Function;

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
import com.badlogic.gdx.math.Vector2;

public class DerivativeScreen extends GameScreen{
	int WIDTH = 800;
	int HEIGHT = 600;
	
	Pixmap pixmap ;
	Texture texture;
	Texture texture1;
	SpriteBatch batch;
	Sprite sprite;
	
	Vector2 center;
	float radius;
	float speed;
	
	List<Vector2> path = new ArrayList<Vector2>(1000);
	boolean changePath = false;
	
	float timePassed = 0;
	int frames = 0;
	float direction = 0;
	
	Function func;
	@Override
	public void onLoadResource() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		center = new Vector2(300, 300);
		radius = 200f;
		
		for(int i = 100;i <= 500 ; i++){
			path.add(new Vector2(i, getYinCircle(i, center, radius)));
		}

		for(int i = 500;i >= 100 ; i--){
			path.add(new Vector2(i, (float)f1(i)));
		}
		
		Pixmap.setBlending(Blending.None);
		Pixmap.setFilter(Filter.BiLinear);
		pixmap = new Pixmap(WIDTH,HEIGHT, Format.RGBA8888);
		pixmap.setColor(Color.RED);
		
	
		for(int i = 0;i< path.size()-1;i++){
			pixmap.drawLine((int)path.get(i).x,   getHeight()-(int) path.get(i).y , 
							(int)path.get(i+1).x, getHeight() -(int)path.get(i+1).y);
		}
		
		texture = new Texture(1024, 1024, Format.RGBA8888);
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);	
		texture.draw(pixmap, 0, 256);
		
		texture1 = new Texture(Gdx.files.internal("data/plane.png"));
		texture1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
		sprite = new Sprite(texture1);
		sprite.setPosition(500, 300);
		
		batch = new SpriteBatch();
		
		speed = 3;
		
//		func = new QuadricFunction(new AttributeSet(new float[]{-0.001f,0.01f,0}));
		func = new CircleFunction(new FunctionSet(new float[]{300,300,200}));
	}
	
	@Override
	public void onRender(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		float elapsed = Gdx.graphics.getDeltaTime();
		double x = sprite.getX();
		double angle  =0 ;
		
//		if(sprite.getX() > 500){
//			changePath = true;
//			speed = -3;
//			sprite.setX(500);
//			direction = 1;
//		}
//		else if(sprite.getX() < 100){
//			changePath = false;
//			speed = 3;
//			sprite.setX(100);
//			direction = 0;
//		}
//		
//		
//		if(!changePath)
//			angle =  getFactor(x);
//		else
//			angle = getFactor1(x);
		
		if(speed < 0)
			direction = 1;
		else 
			direction = 0;
		
		angle = func.getFactor(x);
		
		Gdx.app.log("test", " "+  Math.toDegrees(getFactor1(400)) + " " + 
							      Math.toDegrees(getFactor(400)));
		
		sprite.translate((float) Math.cos(angle) * speed, 
						 (float) Math.sin(angle) * speed);
		
		sprite.setRotation((float) Math.toDegrees(angle ) +180* direction);
		
		batch.begin();
		batch.draw(texture,0,0);
		sprite.draw(batch);
		batch.end();
		
		timePassed += elapsed;
		frames++;
		if(timePassed > 0.5f) {
			Gdx.app.log("SpritePerformanceTest2", "fps: " + frames *2);
			timePassed = 0;
			frames = 0;
		}
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
				
	}
	
	public float getFactor(double x){
		double tan = derivative(x);
		return (float) Math.atan(tan);
	}
	
	public double derivative(double x){
		double h = x * 1e-8;
		return (f(x+h) - f(x-h))/(2*h);		
	}
	
	public double f(double x){
		return (double) ( Math.sqrt( Math.abs( radius*radius - Math.pow((x - center.x),2))) ) + center.y;
	}
	
	public float getFactor1(double x){
		double tan = derivative1(x);
		return (float) Math.atan(tan);
	}
	
	public double derivative1(double x){
		double h = x * 1e-8;
		return (f1(x+h) - f1(x-h))/(2*h);		
	}
	public double f1(double x){
		return (double) (-Math.sqrt(Math.abs(radius*radius - Math.pow((x - center.x),2)))) + center.y;
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
