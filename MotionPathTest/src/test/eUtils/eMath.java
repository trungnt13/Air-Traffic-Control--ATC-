package test.eUtils;

import com.badlogic.gdx.math.Vector2;

public final class eMath {
	eMath() {
		// TODO Auto-generated constructor stub
	}
	
	public static float calModule(Vector2 src,Vector2 dst){
		return (float) Math.sqrt(Math.pow((src.x-dst.x), 2) + Math.pow((src.y-dst.y), 2));
	}
	
	public static Vector2 calMiddle(Vector2 v1,Vector2 v2){
		return new Vector2( (v1.x+v2.x)/2, (v1.y+v2.y)/2);
	}
	
	public static int getYinLine(int x,Vector2 src,Vector2 dst){
		float delta = ( (float)(src.y - dst.y) / (float)(src.x-dst.x) );
		return (int)(delta * (x - src.x)+src.y);
	}
	
	public static int getXinLine(int y,Vector2 src,Vector2 dst){
		float delta = ( (float)(src.x-dst.x) / (float)(src.y-dst.y) );
		return (int)(delta* (y-src.y)+ src.x);
	}
}
