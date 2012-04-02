package test.airport.graphics;

import com.badlogic.gdx.graphics.Color;

public class AttributeSet {
	
	int x;
	int y;
	int width = 0;
	int height = 0;
	int originX;
	int originY;
	float scaleX = 1;
	float scaleY = 1;
	float angle = 0;
	


	Color color = new Color();
	String text;
	Color textColor = new Color();
	int textSize;
	
	boolean focusable = true;
	boolean enable = true;
	boolean visible = true;
	
	Gravity gravity;
	public  enum Gravity{
		TOP,BOTTOM,LEFT,CENTER,CENTER_HORIZONTAL,CENTER_VERTICAL
	}
	
		
	public AttributeSet(){		
		scaleX = 1;
		scaleY = 1;
		
		color.set(1, 1, 1, 1);
		text = null;
		textColor.set(Color.BLACK);
		textSize = 0;
		
		focusable = true;
		enable = true;
		visible = true;
		
		gravity = Gravity.CENTER;
	}

	
	public AttributeSet(int x, int y, int width,int height){
		set(x, y, width, height, x+width/2, y+height/2);

		scaleX = 1;
		scaleY = 1;
		color.set(1, 1, 1, 1);
		text = null;
		textColor.set(Color.BLACK);
		textSize = 0;
		
		focusable = true;
		enable = true;
		visible = true;
		
		gravity = Gravity.CENTER;
	}
	

	
	public void set(int x,int y,int width,int height,int originX,int originY){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		this.originX = originX;
		this.originY = originY;
	}
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getOriginX() {
		return originX;
	}


	public void setOriginX(int originX) {
		this.originX = originX;
	}


	public int getOriginY() {
		return originY;
	}


	public void setOriginY(int originY) {
		this.originY = originY;
	}


	public float getScaleX() {
		return scaleX;
	}


	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}


	public float getScaleY() {
		return scaleY;
	}


	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Color getTextColor() {
		return textColor;
	}


	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}


	public int getTextSize() {
		return textSize;
	}


	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}


	public boolean isFocusable() {
		return focusable;
	}


	public void setFocusable(boolean focusable) {
		this.focusable = focusable;
	}


	public boolean isEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public Gravity getGravity() {
		return gravity;
	}


	public void setGravity(Gravity gravity) {
		this.gravity = gravity;
	}
	


	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	public void setPosition(int x,int y){
		this.x = x;
		this.y = y;
	}

	public void setSize(int width,int height){
		this.width = width;
		this.height = height;
	}
	
	public void setScale(float scaleX,float scaleY){
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	
}
