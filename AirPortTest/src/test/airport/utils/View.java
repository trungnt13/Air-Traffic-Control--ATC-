package test.airport.utils;

import test.airport.graphics.AttributeSet;
import test.airport.graphics.AttributeSet.Gravity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class View extends com.badlogic.gdx.graphics.g2d.Sprite 
						   implements onStateListener,onMoveListener{
	public enum ViewState{
		UP_STATE,DOWN_STATE,MOUSE_IN,MOUSE_OUT
	}
	
	public final int id;
	
	protected boolean enable;
	protected boolean visible ;
	protected boolean focusable ;
	
	String text;
	Color textColor;
	int textSize;
	
	protected AttributeSet attr;
	
	Gravity gravity;
	protected ViewState curState = ViewState.UP_STATE;
	
	

	public View (int id) {
		this.id = id;
		
		setColor(1, 1, 1, 1);
		this.attr = null;
		readData(attr);
	}
	
	public View(AttributeSet attr,int id){
		this.id = id;
		
		this.attr = attr;
		readData(attr);
	}
	
	public View (View view) {
		this.id = view.id;
		this.attr = view.attr;
		readData(attr);
	}
	
	protected void readData(AttributeSet attr){
		setPosition(attr.getX(), attr.getY());
		if(attr.getWidth() !=0 && attr.getHeight() != 0)
			setSize(attr.getWidth(), attr.getHeight());
		
		setOrigin(attr.getOriginX(), attr.getOriginY());
		
		if(attr.getScaleX() != 0 && attr.getScaleY() != 0)
			setScale(attr.getScaleX(), attr.getScaleY());
		setRotation(attr.getAngle());
		
		setColor(attr.getColor());
		
		setText(attr.getText());
		setTextColor(attr.getTextColor());
		setTextSize(attr.getTextSize());
		
		setGravity(attr.getGravity());
		
		this.enable = attr.isEnable();
		this.focusable = attr.isFocusable();
		this.visible = attr.isVisible();
	}
	
	public int getTextSize() {
		return textSize;
	}

	public Gravity getGravity() {
		return gravity;
	}

	public void setGravity(Gravity gravity) {
		this.gravity = gravity;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public ViewState getCurState() {
		return curState;
	}

	public void setCurState(ViewState curState) {
		this.curState = curState;
	}

	public void resetState(){
		this.curState = ViewState.UP_STATE;
	}
	
	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public abstract void setFocusable(boolean focusable);
	
	public AttributeSet getAttr() {
		return attr;
	}

	public void setAttr(AttributeSet attr) {
		this.attr = attr;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean isFocusable(){
		return this.focusable;
	}
	
	public abstract void setEnable(boolean enable);
	
	public boolean isEnable(){
		return this.enable;
	}
		
	
	public boolean hit(int X,int Y){
		if (X >= getX() && X <= getX()+getWidth() && 
			Y >= getY() && Y <= getY()+getHeight()){
			return true;
		}
		return false;
	}
	
}
