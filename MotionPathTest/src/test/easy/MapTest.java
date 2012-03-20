package test.easy;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteCache;

public class MapTest implements ApplicationListener{
	 static final int LAYERS = 5;
	 static final int BLOCK_TILES = 25;
	 static final int WIDTH = 15;
	 static final int HEIGHT = 10;
	 static final int TILES_PER_LAYER = WIDTH * HEIGHT;
	 
	 SpriteCache[] caches = new SpriteCache[LAYERS];
	 Texture texture;
	 int[] layers = new int[LAYERS];
	 
	 OrthographicCamera cam;
	 long startTime = System.nanoTime();
	 
	@Override
	public void create() {
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		/**
		 * 32 is the size of each block off this tile
		 */
		cam.position.set(WIDTH * 32 / 2, HEIGHT * 32 / 2, 0);
		
		texture = new Texture(Gdx.files.internal("data/tiles.png"));
		
		Random rand = new Random();
		for(int i = 0; i < LAYERS ; i++){
			caches[i] = new SpriteCache();
			SpriteCache cache = caches[i];
			cache.beginCache();
			for(int y = 0; y < HEIGHT;y++){
				for(int x = 0; x < WIDTH ; x++){
					int tileX = rand.nextInt(5);
					int tileY = rand.nextInt(5);
					cache.add(texture, x << 5, y << 5, 1 + tileX * 33, 1 + tileY * 33, 32, 32);
				}
			}
			layers[i] = cache.endCache();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		GL10 gl = Gdx.gl10;
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		cam.zoom = 1f;
		cam.update();
		
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		for (int i = 0; i < LAYERS; i++) {
			SpriteCache cache = caches[i];
			cache.setProjectionMatrix(cam.combined);
			cache.begin();
			for (int j = 0; j < TILES_PER_LAYER; j += BLOCK_TILES) {
				cache.draw(layers[i], j, 25);
			}
			cache.end();
		}
	
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
