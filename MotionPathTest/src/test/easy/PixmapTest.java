package test.easy;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PixmapTest implements ApplicationListener,InputProcessor{
	SpriteBatch batch;
	Texture texture;
	Texture plane;
	Pixmap pixmap;
	
	Vector2 test;
	List<Vector2> trace = new ArrayList<Vector2>();
	int cur;
	int count=0;
	float Timer=0;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		pixmap = new Pixmap(1024, 512, Pixmap.Format.RGBA8888);
		texture = new Texture(pixmap);
		plane = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));
		cur = 0;
		trace.add(new Vector2(-plane.getWidth(), -plane.getHeight()));
		test = new Vector2(0,0);
		Gdx.input.setInputProcessor(this);
		DrawSmiley();
	}

	private void DrawSmiley() {
		Gdx.app.log("MyLibGDXGame", "Game.DrawSmiley()");
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture,0,0);
		batch.draw(plane,trace.get(cur).x-plane.getWidth()/2,
						 Gdx.graphics.getHeight()-trace.get(cur).y-plane.getHeight()/2);
		batch.end();
		if(Timer != 0)
			Timer += Gdx.graphics.getDeltaTime();
		update();
	}

	private void update() {
		if(Timer >= 1.1f){
			if(cur < trace.size()-1){
				cur++;
			}
			Timer = 1;
		
			pixmap.drawLine((int)trace.get(cur-1).x,(int)trace.get(cur-1).y,(int)trace.get(cur).x,(int)trace.get(cur).y);
			texture.draw(pixmap, 0, 0);
			texture.bind();
		}
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		test.set(x, y);
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		Timer =1;
		pixmap.setColor(Color.WHITE);
		Gdx.app.log("Touch dragged", " ////////////" + trace.size()+ " " + count);
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		count++;
		if(calModule(test, new Vector2(x, y)) > 5){
			Vector2 v1 = calMiddle(test, new Vector2(x, y));
			Vector2 v2 = new Vector2(x, y);
			trace.add(v1);
			trace.add(v2);
		}else
			trace.add(new Vector2(x, y));
		
		pixmap.setColor(Color.RED);
		pixmap.drawLine((int)test.x, (int)test.y, x, y);
		texture.draw(pixmap, 0, 0);
	
		Gdx.app.log("Trace", ""+trace.get(trace.size()-1).x + " " + trace.get(trace.size()-1).y);
		Gdx.app.log("Touch dragged", "" + x + " " + y);
		test.set(x, y);
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private float calModule(Vector2 src,Vector2 dst){
		return (float) Math.sqrt(Math.pow((src.x-dst.x), 2) + Math.pow((src.y-dst.y), 2));
	}
	private Vector2 calMiddle(Vector2 v1,Vector2 v2){
		return new Vector2( (v1.x+v2.x)/2, (v1.y+v2.y)/2);
	}
}
