package test.airport.screen;

import java.util.Queue;

import test.airport.context.MyInput;
import test.airport.context.R;
import test.airport.graphics.Layout;
import test.airport.utils.eMath;
import test.easy.admin.eAdmin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GoAroundScreen extends GameScreen{

	Texture plane;
	Sprite sprite;
	SpriteBatch batch = new SpriteBatch();
	
	float angle;
	float speed;
	
	float srcAngle = (float) (Math.PI/2);
	float dstAngle = 0;
	float SPEED = 200;
	
	Vector2 center;
	float radius;
	
	Vector2 curPos;
	
	Color color;
	
	MyInput input;
	@Override
	public void onRender(float delta) {
//		angle += Gdx.graphics.getDeltaTime();
//		curPos.x = (float) (200*Math.cos(angle)+ center.x);
//		curPos.y = (float) (200*Math.sin(angle)+ center.y);
//		sprite.setPosition(curPos.x, curPos.y);

		SPEED = 30*Gdx.graphics.getDeltaTime();
		input = (MyInput)eAdmin.einput.findInputByID(R.input.MyInput);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		
		if(srcAngle >= dstAngle){
			curPos.x = (float) Math.cos(srcAngle)*SPEED;
			curPos.y = (float) Math.sin(srcAngle)*SPEED;
			sprite.translate(curPos.x, curPos.y);
			sprite.setRotation((float) Math.toDegrees(srcAngle));
			srcAngle -= 0.5f*Gdx.graphics.getDeltaTime();
		}
		Gdx.app.log("test", "" + 0.6f/Math.PI*180 );
	}

	public float calculate(Vector2 src,Vector2 dst,float curAngle,float dstAngle,float speed){
		float D = eMath.calModule(src, dst);
		float Time = D/speed;
		float delta = dstAngle - curAngle;
		return delta/Time;
	}
	
	@Override
	public void update(float delta) {
		if(input.isDragging){
			sprite.setColor(color);
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

	@Override
	public void onLoadResource() {
		plane = new Texture(Gdx.files.internal("data/plane.png"));
		sprite = new Sprite(plane);
		sprite.setPosition(0, 0);
		center = new Vector2();
		center.set(300,300);
		
		curPos = new Vector2();
		curPos.set(0,0);
		
		radius = 200;
		angle = 0;
		color = sprite.getColor();
		sprite.setColor(Color.CLEAR);
	}

	@Override
	public Layout onCreateLayout() {
		// TODO Auto-generated method stub
		return null;
	}

}
