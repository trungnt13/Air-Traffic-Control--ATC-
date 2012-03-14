package test.eUtils;

import test.easy.PixmapTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Pixmap;

public class MyInput implements InputProcessor{
	static int X;
	static int Y;
	
	static int xUp;
	static int yUp;
	
	static int xDown;
	static int yDown;
	
	public boolean justUp;
	public boolean isDragging;
	public boolean justDown;
	
	int height = PixmapTest.SCREEN_HEIGHT;
	
	public MyInput(){
		justUp = true;
		isDragging = false;
		justDown = false;
		
		X = -1;
		Y = -1;
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
		justDown = true;
		justUp = false;
		isDragging = false;
		
		xDown = x;
		yDown = height - y;
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		justUp = true;
		justDown = false;
		isDragging = false;
		
		reset();
		xUp = x;
		yUp = height - y;
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		isDragging = true;
		justDown = false;
		justUp = false;
		
		X = x;
		Y = height-y;
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		Gdx.app.log("", "" + x + " " + y);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getX(){
		if(justDown)
			return xDown;
		else if(isDragging)
			return X;
		else if(justUp)
			return xUp;
		return 0;
	}
	
	public int getY(){
		if(justDown)
			return yDown;
		else if(isDragging)
			return Y;
		else if(justUp)
			return yUp;
		return 0;
	}
	
	public int getXDown(){
		return xDown;
	}
	
	public int getYDown(){
		return yDown;
	}
	
	public int getXUp(){
		return xUp;
	}
	
	public int getYUp(){
		return yUp;
	}
	
	void reset(){
		X = -1;
		Y = -1;
	}
	
	public boolean isValid(){
		if(X >=0 && Y >= 0)
			return true;
		return false;
	}
}
