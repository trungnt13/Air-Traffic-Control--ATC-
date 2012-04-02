package test.airport.screen;

import test.airport.context.Art;
import test.airport.context.MyInput;
import test.airport.context.R;
import test.airport.graphics.AttributeSet;
import test.airport.graphics.Layout;
import test.airport.utils.Button;
import test.airport.utils.View;
import test.airport.utils.onActionListener;
import test.easy.admin.eAdmin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class PlayScreen extends GameScreen
						implements onActionListener{
	StartScreen parent;
	
	Vector2 pos;
	Vector2 speed;
	
	
	MyInput input;
	
	
	BitmapFont font;
	BitmapFontCache fontCache;
	BitmapFontCache fontCache1;
	Layout layout;
	
	Button b;
	Button b1;
	Button b2;
	
	public PlayScreen(StartScreen parent) {
		this.parent = parent;
	}

	@Override
	public void onLoadResource() {
		input = (MyInput) eAdmin.einput.findInputByID(R.input.MyInput);
		pos = new Vector2(0, 0);
		speed = new Vector2(5, 5);
		
		batch.enableBlending();
		batch.setBlendFunction(GL11.GL_SRC0_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		font = new BitmapFont(Gdx.files.internal("data/verdana39.fnt"),Gdx.files.internal("data/verdana39.png"), false);
		font.setScale(0.5f,0.5f);
		fontCache = new BitmapFontCache(font);
		fontCache.setText("fuck you", 100, 100,0,8);
		fontCache.setColor(Color.RED);
		
		font.setScale(1f,1f);
		fontCache1 = new BitmapFontCache(font);
		fontCache1.setText("fuck you", 100, 50);
		fontCache1.setColor(Color.RED);
		
	}
	
	
	@Override
	public void onRender(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		
		batch.begin();
		batch.disableBlending();
		batch.draw(Art.background, 0, 0, getWidth(), getHeight());
		
		batch.enableBlending();
		batch.draw(Art.plane, pos.x, pos.y);
		batch.draw(Art.back,getWidth()/2 - Art.back.getRegionWidth()/2,
							getHeight()/2 - Art.back.getRegionHeight()/2);
		
		fontCache.draw(batch);
		fontCache1.draw(batch);
		

		batch.end();
		
		layout.apply();
	}

	@Override
	public void update(float delta) {
		pos.x += speed.x;
		pos.y += speed.y;
		
		if(pos.x >= getWidth()-Art.plane.getRegionWidth())
			speed.x = - 5;
		else if(pos.x <= 0)
			speed.x = 5;
		if(pos.y >= getHeight()-Art.plane.getRegionHeight())
			speed.y = - 5;
		else if(pos.y <= 0)
			speed.y = 5;
		
		if(input.justDown){
			if(input.getX() >= getWidth()/2 - Art.back.getRegionWidth()/2 && 
			   input.getX() <= getWidth()/2 + Art.back.getRegionWidth()/2 &&
			   input.getY() >= getHeight()/2 - Art.back.getRegionHeight()/2 &&
			   input.getY() <= getHeight()/2  + Art.back.getRegionHeight()/2){
				setScreen(new GoAroundScreen());
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActionPerformed(View v) {
		if(b.equals((Button)v)){
			Gdx.app.log("b", "actoin");
		}
		if(b1.equals((Button)v)){
			Gdx.app.log("b1", "actoin");
		}
		if(b2.equals((Button)v)){
			Gdx.app.log("b2", "actoin");
		}
	}

	@Override
	public Layout onCreateLayout() {
		layout = new Layout(new AttributeSet(0, 0, getWidth(), getHeight()), this, 0);
		layout.registerListener(this);
		
		AttributeSet attr = new AttributeSet();
		attr.setPosition(100, 100);
//		attr.setSize(100, 100);
		b= new Button(1, attr, Art.startRegion, Art.exitRegion);
		attr.setPosition(200, 200);
		b1 = new Button(2, attr, Art.exitRegion, Art.startRegion);
		attr.setPosition(0,500);
		b2 = new Button(3, attr, Art.exitRegion, Art.startRegion);
		
		layout.bindToLayout(b);
		layout.bindToLayout(b1);
		layout.bindToLayout(b2);
		
		b.setVisible(false);
		return layout;
	}
	

}
