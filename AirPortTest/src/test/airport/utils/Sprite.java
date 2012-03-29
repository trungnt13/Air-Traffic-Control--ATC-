package test.airport.utils;

import test.airport.utils.sprite.Path;
import test.airport.utils.sprite.onDirectionListener;
public class Sprite extends com.badlogic.gdx.graphics.g2d.Sprite
					implements onDirectionListener{
	
	float speed = 0;
	
	/**
	 * Direction ( = 0 if move to right , = 1 if move to left)
	 */
	float direction = 0;
	float angle = 0;
	
	Path path;
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	
	/**
	 * Set the angle for the movement ( in radian)
	 * @param angle the move's angle in radian
	 */
	public void setAngle(float angle){
		this.angle = angle;
	}
	
	public void setMode(byte move_mode){
		if(this.path != null)
			path.setMode(move_mode);
	}
	
	public void registerPath(Path path){
		this.path = path;
	}
	
	public void update(){
		onDirectChange(speed,getX());
		angle = path.getAngle();
		translate((float) Math.cos(angle) * speed, 
				  (float) Math.sin(angle) * speed);
	}

	@Override
	public void onDirectChange(float speed, float xPosition) {
		
	}

	
}
