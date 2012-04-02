package test.easy.admin;


import test.airport.context.InputProcessor;
import test.easy.admin.eMultiplexer.MotionCallBack.MotionEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
public class eMultiplexer implements com.badlogic.gdx.InputProcessor{
	public static MotionEvent currentMotion;

	private Array<InputProcessor> processors = new Array<InputProcessor>();
	private Array<MotionCallBack> motion = new Array<eMultiplexer.MotionCallBack>();
	private Array<KeyCallBack> key = new Array<eMultiplexer.KeyCallBack>();
	
	private ObjectMap<Integer, InputProcessor> inputMap;
	
	public interface Callback{
		
	}
	
	public interface MotionCallBack extends Callback{
		public enum MotionEvent{
			ACTION_UP,ACTION_DOWN,ACTION_DRAG,ACTION_MOVE
		};
		/** Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Buttons#LEFT} on
		 * Android.
		 * 
		 * @param x The x coordinate, origin is in the upper left corner
		 * @param y The y coordinate, origin is in the upper left corner
		 * @param pointer the pointer for the event.
		 * @param button the button
		 * @return whether the input was processed */
		public boolean onTouchDown (int x, int y, int pointer, int button);

		/** Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Buttons#LEFT} on
		 * Android.
		 * 
		 * @param x The x coordinate
		 * @param y The y coordinate
		 * @param pointer the pointer for the event.
		 * @param button the button
		 * @return whether the input was processed */
		public boolean onTouchUp (int x, int y, int pointer, int button);

		/** Called when a finger or the mouse was dragged.
		 * 
		 * @param x The x coordinate
		 * @param y The y coordinate
		 * @param pointer the pointer for the event.
		 * @return whether the input was processed */
		public boolean onTouchDragged (int x, int y, int pointer);

		/** Called when the mouse was moved without any buttons being pressed. Will not be called on Android.
		 * 
		 * @param x The x coordinate
		 * @param y The y coordinate
		 * @return whether the input was processed */
		public boolean onTouchMoved (int x, int y);
	}
	
	public interface KeyCallBack extends Callback{
		public enum KeyEvent{
			
		};
		
		/** Called when a key was pressed
		 * 
		 * @param keycode one of the constants in {@link Input.Keys}
		 * @return whether the input was processed */
		public boolean onKeyDown (int keycode);

		/** Called when a key was released
		 * 
		 * @param keycode one of the constants in {@link Input.Keys}
		 * @return whether the input was processed */
		public boolean onKeyUp (int keycode);

		/** Called when a key was typed
		 * 
		 * @param character The character
		 * @return whether the input was processed */
		public boolean onKeyTyped (char character);
	}

	
	public eMultiplexer () {
		this.inputMap = new ObjectMap<Integer, InputProcessor>();
	}

	public eMultiplexer (InputProcessor... processors) {
		for (int i = 0; i < processors.length; i++)
			this.processors.add(processors[i]);
		this.inputMap = new ObjectMap<Integer, InputProcessor>();
	}

	public void addProcessor(int index, InputProcessor processor) {
		processors.insert(index, processor);
		inputMap.put( processor.getID(),processor);
	}
	
	public void removeProcessor(int index) {
		processors.removeIndex(index);
		inputMap.remove(processors.get(index).getID());
	}
	
	public void addProcessor (InputProcessor processor) {
		processors.add(processor);
		inputMap.put( processor.getID(),processor);
	}

	public void removeProcessor (InputProcessor processor) {
		processors.removeValue(processor, true);
		inputMap.remove(processor.getID());
	}

	/**
	 * @return the number of processors in this multiplexer
	 */
	public int size() {
		return processors.size;
	}
	
	public void clear () {
		processors.clear();
		inputMap.clear();
	}

	public void setProcessors (Array<InputProcessor> processors) {
		this.processors = processors;
	}

	public Array<InputProcessor> getProcessors () {
		return processors;
	}

	public boolean keyDown (int keycode) {
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).keyDown(keycode)) return true;
		for (int i = 0, n = key.size; i < n; i++)
			if (key.get(i).onKeyDown(keycode)) return true;
		return false;
	}

	public boolean keyUp (int keycode) {
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).keyUp(keycode)) return true;
		for (int i = 0, n = key.size; i < n; i++)
			if (key.get(i).onKeyUp(keycode)) return true;
		return false;
	}

	public boolean keyTyped (char character) {
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).keyTyped(character)) return true;
		for (int i = 0, n = key.size; i < n; i++)
			if (key.get(i).onKeyTyped(character)) return true;
		return false;
	}

	public boolean touchDown (int X, int Y, int pointer, int button) {
		int x= X;
		int y = Gdx.graphics.getHeight()-Y;
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).touchDown(x, y, pointer, button)) return true;
		for (int i = 0, n = motion.size; i < n; i++)
			if (motion.get(i).onTouchDown(x, y, pointer, button)) return true;
		return false;
	}

	public boolean touchUp (int X, int Y, int pointer, int button) {
		int x= X;
		int y = Gdx.graphics.getHeight()-Y;
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).touchUp(x, y, pointer, button)) return true;
		for (int i = 0, n = motion.size; i < n; i++)
			if (motion.get(i).onTouchUp(x, y, pointer, button)) return true;
		return false;
	}

	public boolean touchDragged (int X, int Y, int pointer) {
		int x= X;
		int y = Gdx.graphics.getHeight()-Y;
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).touchDragged(x, y, pointer)) return true;
		for (int i = 0, n = motion.size; i < n; i++)
			if (motion.get(i).onTouchDragged(x, y, pointer)) return true;
		return false;
	}

	@Override
	public boolean touchMoved (int X, int Y) {
		int x= X;
		int y = Gdx.graphics.getHeight()-Y;
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).touchMoved(x, y)) return true;
		for (int i = 0, n = motion.size; i < n; i++)
			if (motion.get(i).onTouchMoved(x, y)) return true;
		return false;
	}

	@Override
	public boolean scrolled (int amount) {
		for (int i = 0, n = processors.size; i < n; i++)
			if (processors.get(i).scrolled(amount)) return true;
		return false;
	}

	public InputProcessor findInputByID(int key){
		return inputMap.get(key);
	}
	
	public void registerCallback(Callback callback){
		if(callback instanceof MotionCallBack && callback instanceof KeyCallBack){
			this.motion.add((MotionCallBack) callback);
			this.key.add((KeyCallBack) callback);	
		}else if(callback instanceof MotionCallBack)
			this.motion.add((MotionCallBack) callback);
		else if(callback instanceof KeyCallBack)
			this.key.add((KeyCallBack) callback);
	}
	
	public boolean unregisterCallback(Callback callback){
		if(callback instanceof MotionCallBack && callback instanceof KeyCallBack){
			return this.motion.removeValue((MotionCallBack) callback,true) &&
				   this.key.removeValue((KeyCallBack) callback,true);
		}else if(callback instanceof MotionCallBack){
			return this.motion.removeValue((MotionCallBack) callback,true);	
		}
		else if(callback instanceof KeyCallBack){
			return this.key.removeValue((KeyCallBack) callback,true);
		}
		return false;
	}
	
	public boolean contain(Callback callback){
		int m = motion.size;
		int n = key.size;
		if(callback instanceof MotionCallBack && callback instanceof KeyCallBack){
			for(int i = 0;i < m;i++){
				MotionCallBack call = (MotionCallBack)callback;
				if(call.equals(motion.get(i)))
					return true;
			}
			for(int i = 0;i < n;i++){
				KeyCallBack call = (KeyCallBack)callback;
				if(call.equals(motion.get(i)))
					return true;
			}
			return false;
		}else if(callback instanceof MotionCallBack){
			for(int i = 0;i < m;i++){
				MotionCallBack call = (MotionCallBack)callback;
				if(call.equals(motion.get(i)))
					return true;
			}
			return false;
		}
		else if(callback instanceof KeyCallBack){
			for(int i = 0;i < n;i++){
				KeyCallBack call = (KeyCallBack)callback;
				if(call.equals(motion.get(i)))
					return true;
			}
			return false;
		}
		return false;
	}
}
