package test.airport.graphics;

import java.util.ArrayList;
import java.util.List;

import test.airport.screen.GameScreen;
import test.airport.utils.View;
import test.airport.utils.onActionListener;
import test.easy.admin.eAdmin;
import test.easy.admin.eMultiplexer.MotionCallBack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ObjectMap;

public class Layout extends View implements MotionCallBack{
	List<View> views = new ArrayList<View>();
	ObjectMap<Integer, View> viewMap = new ObjectMap<Integer, View>();
	View focusView;
	
	SpriteBatch batch;
	GameScreen screen;
	
	onActionListener listener;
	
	public Layout(AttributeSet attr,GameScreen screen,int id){
		super(attr, id);
		
		this.screen = screen;
		this.batch = screen.getBatch();	
		
		readData(attr);
		eAdmin.einput.registerCallback(this);
		enable = true;
		focusable = enable;
	}
	
	public void registerListener(onActionListener listener){
		this.listener = listener;
	}
	
	public void unregisterListener(){
		this.listener = null;
	}
	
	@Override
	public void setEnable(boolean enable) {
		if(isEnable() && !enable)
			eAdmin.einput.unregisterCallback(this);
		else if(!isEnable() && enable)
			eAdmin.einput.registerCallback(this);
		this.enable = enable;
		this.focusable = enable;
	}

	@Override
	public void setFocusable(boolean focusable) {
		setEnable(focusable);
		this.focusable = focusable;
	}
	
	public void setActionListener(onActionListener listener){
		this.listener = listener;
	}
	
	public void bindToLayout(View view){
		if(view != null){
			this.views.add(view);
			this.viewMap.put(view.id, view);
		}
	}
	
	public void apply(){
		batch.begin();
		for (int i = 0; i < views.size(); i++) {
			View v = views.get(i);
			if(v.isVisible()){
				v.draw(batch);
			}
		}
		batch.end();
	}
		
	@Override
	public boolean onTouchDown(int x, int y, int pointer, int button) {
		for(int i =0; i < views.size();i++){
			View v = views.get(i);
			if (v.hit(x, y) && v.isFocusable()){
				if(v != null){
					this.focusView = v;
					this.focusView.setCurState(ViewState.DOWN_STATE);	
					focusView.StateChanged(v.getCurState());
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean onTouchUp(int x, int y, int pointer, int button) {
		if(focusView != null && focusView.hit(x, y)){
			focusView.setCurState(ViewState.UP_STATE);
			focusView.StateChanged(focusView.getCurState());
			if(focusView.isEnable() && listener != null)
				listener.ActionPerformed(focusView);
			return true;
		}
		return false;
	}

	@Override
	public boolean onTouchDragged(int x, int y, int pointer) {
		if(focusView != null && focusView.hit(x, y)){
			focusView.setCurState(ViewState.DOWN_STATE);
			focusView.StateChanged(focusView.getCurState());
			return true;
		}else if(focusView != null && !focusView.hit(x, y)){
			focusView.setCurState(ViewState.UP_STATE);
			focusView.StateChanged(focusView.getCurState());
			return true;
		}
		return false;
	}

	@Override
	public boolean onTouchMoved(int x, int y) {
		for(int i = 0;i < views.size();i++){
			View v = views.get(i);
			if(v.isFocusable() && v.hit(x, y)){
				v.MousePassed(ViewState.MOUSE_IN);
			}else if(!v.hit(x, y)){
				v.MousePassed(ViewState.MOUSE_OUT);
			}
		}
		return false;
	}

	
	public View findViewByID(int id){
		return viewMap.get(id);
	}
	
	@Override
	public void StateChanged(ViewState state) {
		
	}

	@Override
	public void MousePassed(ViewState state) {
		
	}



}
