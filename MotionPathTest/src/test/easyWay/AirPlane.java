package test.easyWay;

import java.util.List;

import test.eUtils.MyInput;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class AirPlane {
	
	Vector2 pos;
	Vector2 size;
	
	PathTracker trace;
	MyInput input;
	public AirPlane(Texture texture,MyInput input){
		size = new Vector2(texture.getWidth(), texture.getHeight());
		pos = new Vector2(300, 300);
		this.input = input;
		trace = new PathTracker(input, this);
	}
	
	public void update(float deltaTime){
		trace.update(deltaTime);
	}
	
	public boolean isHit(){
		if(input.getX() >= pos.x && input.getX() <= pos.x + size.x &&
		   input.getY() >= pos.y && input.getY() <= pos.y + size.y && 
		   input.justDown ){
			return true;
		}
		return false;
	}
	
	public float getWidth(){
		return size.x;
	}
	
	public float getHeight(){
		return size.y;
	}
	
	public float getPosX(){
		if(trace.size() > 0){
			pos.x = trace.getX();
			return trace.getX();
		}
		return pos.x;
	}
	
	public float getPosY(){
		if(trace.size() > 0){
			pos.y = trace.getY();
			return trace.getY();
		}
		return pos.y;
	}
	
	public List<Vector2> getTracker(){
		return this.trace.getTrack();
	}
	
	public int getCURRENT(){
		return this.trace.CURRENT;
	}
}
