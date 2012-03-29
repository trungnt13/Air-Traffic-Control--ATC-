package test.airport.utils.sprite;

import test.airport.context.S;
import test.airport.utils.math.AttributeSet;
import test.airport.utils.math.CircleFunction;
import test.airport.utils.math.Function;
import test.airport.utils.math.QuadricFunction;
import test.airport.utils.math.TrigonometricFunction1;

public class Path {
	byte MOVE_MODE;
	
	Function func;
	float x;
	float speed;
	
	onDirectionListener listener;
	
	
	public void setMode(byte move_mode){
		
	}
	
	public void setListener(onDirectionListener listener){
		this.listener = listener;		
	}
	
	public float getAngle(){
		return 0;
	}
	
	
}
