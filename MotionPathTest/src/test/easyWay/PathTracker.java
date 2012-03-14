package test.easyWay;

import java.util.ArrayList;
import java.util.List;

import test.eUtils.MyInput;
import test.eUtils.eMath;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class PathTracker {
	List<Vector2> trace = new ArrayList<Vector2>();
	Vector2 prePosition;
	
	static final int MAX_LENGTH = 2500;
	boolean startTracking = false;
	int CURRENT;
	float Timer;
	
	MyInput input;
	AirPlane plane;
	public PathTracker(MyInput input,AirPlane airplane){
		this.input = input;
		this.plane = airplane;
		prePosition = new Vector2();
		CURRENT = 0;
	}
	
	public void update(float deltaTime){
		if(size() > 0){
			Timer += deltaTime;
			if(Timer >= 0.5f){
				if(CURRENT < size()-1)
					CURRENT ++;
				else {
					trace.clear();
					CURRENT = 0;
				}
				Timer = 0;
			}
			
		}
		if(plane.isHit()){
				trace.clear();
				CURRENT = 0;
				prePosition.set(input.getX(), input.getY());
				startTracking = true;
		}	
		Tracking();
	}
	
	private void Tracking(){
		if(startTracking){
			if(input.isDragging){
//				int x = (int)prePosition.x;
//				Vector2 dst = new Vector2(input.getX(), input.getY());
//				while(x<input.getX()){
//					trace.add(new Vector2(x, eMath.getYinLine(x, prePosition, dst)));
//					x++;
//					Gdx.app.log("test", "" + x + " " + eMath.getYinLine(x, prePosition, dst) );
//				}
				trace.add(new Vector2(input.getX(), input.getY()));
				Gdx.app.log("test", ""+ trace.size()+ " " + input.getX() +" " +  input.getY());
			}
			if(input.justUp)
				startTracking = false;
		}
	}
	
	public boolean isTracking(){
		return startTracking;
	}
	
	
	
	public List<Vector2> getTrack(){
		return this.trace;
	}
	
	public int size(){
		return trace.size();
	}
	
	public int getX(){
		return (int)trace.get(CURRENT).x - (int)plane.getWidth()/2;
	}
	
	public int getY(){
		return (int)trace.get(CURRENT).y - (int)plane.getHeight()/2;
	}
}
