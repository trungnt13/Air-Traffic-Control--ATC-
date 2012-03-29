package test.easy.admin;

import test.easy.admin.eMultiplexer.CallBack.MotionEvent;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class eMultiplexer implements Input{
	public static MotionEvent currentMotion;
	
	public static interface CallBack{
		public static enum MotionEvent{
			ACTION_UP,ACTION_DOWN,ACTION_DRAG
		};
		
		public void onTouchDown(float x,float y);
		public void onTouchDrag(float x,float y);
		public void onTouchUp(float x,float y);
	}
	
	
	
	@Override
	public float getAccelerometerX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getAccelerometerY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getAccelerometerZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX(int pointer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeltaX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeltaX(int pointer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY(int pointer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeltaY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeltaY(int pointer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isTouched() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean justTouched() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTouched(int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isButtonPressed(int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isKeyPressed(int key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getTextInput(TextInputListener listener, String title,
			String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPlaceholderTextInput(TextInputListener listener,
			String title, String placeholder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOnscreenKeyboardVisible(boolean visible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vibrate(int milliseconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vibrate(long[] pattern, int repeat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelVibrate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getAzimuth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPitch() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getRoll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getRotationMatrix(float[] matrix) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getCurrentEventTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCatchBackKey(boolean catchBack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCatchMenuKey(boolean catchMenu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInputProcessor(InputProcessor processor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputProcessor getInputProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPeripheralAvailable(Peripheral peripheral) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orientation getNativeOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCursorCatched(boolean catched) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCursorCatched() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCursorPosition(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
