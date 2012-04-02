package test.airport.utils;

import test.airport.graphics.AttributeSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Button extends View{
	TextureRegion upRegion;
	TextureRegion downRegion;	
	
	
	public Button(int id,AttributeSet attr,TextureRegion upRegion,TextureRegion downRegion) {
		super(attr, id);
		setRegion(upRegion, downRegion);
	}
	
	public void setRegion(TextureRegion up,TextureRegion down){	
		this.upRegion = up;
		this.downRegion = down;
		setRegion(up);
		if(getWidth() == 0 || getHeight() == 0)
			setSize(up.getRegionWidth(), up.getRegionHeight());
	}
	
	@Override
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	@Override
	public void setFocusable(boolean focusable) {
		this.focusable = focusable;
	}

	@Override
	public void StateChanged(ViewState state) {
		if(state == ViewState.DOWN_STATE)
			setRegion(downRegion);
		else if(state == ViewState.UP_STATE)
			setRegion(upRegion);
	}

	@Override
	public void MousePassed(ViewState state) {
		if(state == ViewState.MOUSE_IN)
			setRegion(downRegion);
		else if(state == ViewState.MOUSE_OUT)
			setRegion(upRegion);
	}

	
}
