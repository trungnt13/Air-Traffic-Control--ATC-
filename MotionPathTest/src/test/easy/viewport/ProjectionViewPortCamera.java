package test.easy.viewport;

import javax.jws.soap.SOAPBinding.Use;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProjectionViewPortCamera implements ApplicationListener{
	Mesh one;
	Mesh two;
	Mesh square;
	Mesh square1;
	Mesh square2;
	
	Texture texture;
	SpriteBatch spritebatch;
	
	Camera camera;

	   private int total = 0;
	    private float movementIncrement = 0.0006f;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		if(one == null){
			one = new Mesh(true, 3, 3, 
                    new VertexAttribute(Usage.Position, 3, "a_position"),
                    new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
			one.setVertices(new float[]{
				-0.5f, -0.5f, 0, Color.toFloatBits(129, 0, 0, 255),
				0.5f , -0.5f, 0, Color.toFloatBits(192, 0, 0, 255),
				-0.5f, 0.5f , 0, Color.toFloatBits(192, 0, 0, 255)
			});
			one.setIndices(new short[]{0,1,2});
		}
		
		if(two == null){
			two = new Mesh(true,3,3,
					new VertexAttribute(Usage.Position,3, "a_position"),
					new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
			two.setVertices(new float[]{
					0.5f, -0.5f, 0, Color.toFloatBits(192, 0, 0, 255),
					-0.5f, 0.5f, 0, Color.toFloatBits(192, 0, 0, 255),
					0.5f, 0.5f, 0, Color.toFloatBits(255, 0, 0, 255)
			});
			two.setIndices(new short[]{0,1,2});
		}
		
		if(square == null){
			square = new Mesh(true,4,6,
					new VertexAttribute(Usage.Position,3,"a_position"),
					new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
			
			square.setVertices(new float[]{
				0.75f,0.75f,0, Color.toFloatBits(128, 0, 0, 255),
				0.75f,-0.75f,0,Color.toFloatBits(192, 0, 0, 255),
				-0.75f,0.75f,0,Color.toFloatBits(192, 0, 0, 255),
				-0.75f,-0.75f,0,Color.toFloatBits(192, 0, 0, 255)
			});
			
			square.setIndices(new short[]{0,1,2,3,1,2});
		}
		
		
		if(square1 == null){
			square1 = new Mesh(true,4,4,
					new VertexAttribute(Usage.Position, 3, "a_position"),
					new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
			square1.setVertices(new float[]{
					-1f, 0.5f, -4f,Color.toFloatBits(0, 0, 192, 255),
					0f , 0.5f, -4f,Color.toFloatBits(0, 0, 128, 255),
					0f  , -0.5f,-4f,Color.toFloatBits(0, 0, 192, 255),
					-1f , -0.5f,-4f,Color.toFloatBits(0, 0, 192, 255)
			});
			square1.setIndices(new short[]{3,2,0,1});
		}
		
//		if(square1 == null){
//			square1 = new Mesh(true,4,4,
//					new VertexAttribute(Usage.Position, 3, "a_position"),
//					new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
//			square1.setVertices(new float[]{
//					-1f, 0.5f, -4f,Color.toFloatBits(0, 192, 0, 255),
//					0f , 0.5f, -4f,Color.toFloatBits(0, 128, 0, 255),
//					0f  , -0.5f,-4f,Color.toFloatBits(0, 192, 0, 255),
//					-1f , -0.5f,-4f,Color.toFloatBits(0, 192, 0, 255)
//			});
//			square1.setIndices(new short[]{3,2,0,1});
//		}
		
		if(square2 == null){
			square2 = new Mesh(true, 4, 4, 
					new VertexAttribute(Usage.Position, 3, "a_position"),
					new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
			square2.setVertices(new float[]{
					1f, 0.5f, -1.1f,Color.toFloatBits(0, 128, 0, 255),
					1f,-0.5f, -1.1f,Color.toFloatBits(0, 192, 0, 255),
					0f,-0.5f, -1.1f,Color.toFloatBits(0, 192, 0, 255),
					0f,0.5f , -1.1f,Color.toFloatBits(0, 192, 0, 255)
			});
			square2.setIndices(new short[]{3,2,0,1});
		}
		
		texture = new Texture(Gdx.files.internal("data/badlogic.jpg"));
		spritebatch = new SpriteBatch();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		float ratio = (float)width/(float)height;
//		camera = new OrthographicCamera(3, 2);
		camera = new PerspectiveCamera(67f, 3f, 2f);
	}

	@Override
	public void render() {
		 total += 1;
	        if (total > 500) {
	            movementIncrement = -movementIncrement;
	            total = -200;
	        }

	        camera.rotate(movementIncrement * 20, 0, 1, 0);
	        camera.translate(movementIncrement, 0, movementIncrement);
	        
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		camera.apply(Gdx.gl10);
		spritebatch.setProjectionMatrix(camera.combined);
		
//		one.render(GL10.GL_TRIANGLES);
//		two.render(GL10.GL_TRIANGLES);
//		square.render(GL10.GL_TRIANGLES);
		
		/**
		 * Green far, blue near
		 */
		square1.render(GL10.GL_TRIANGLE_STRIP,0,4);
		square2.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//		spritebatch.begin();
//		spritebatch.draw(texture, 0, 0, 1, 1, 0, 0, 
//						 texture.getWidth(), texture.getHeight(), false, false);
//		spritebatch.end();
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
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
