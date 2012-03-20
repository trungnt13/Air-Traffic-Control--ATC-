/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package test.easy;

import java.util.Random;

import test.easyWay.OrthoCamController;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.math.Vector3;


public class TileTest implements ApplicationListener {
	static final int LAYERS = 1;
	static final int BLOCK_TILES = 25;
	static final int WIDTH = 15;
	static final int HEIGHT = 10;
	static final int TILES_PER_LAYER = WIDTH * HEIGHT;

	SpriteCache[] caches = new SpriteCache[LAYERS];
	Texture texture;
	int[] layers = new int[LAYERS];
	OrthographicCamera cam;
	OrthoCamController camController;
	long startTime = System.nanoTime();

	Vector3 test = new Vector3();
	@Override
	public void create () {
		cam = new OrthographicCamera(480, 320);
		cam.position.set(WIDTH * 32 / 2, HEIGHT * 32 / 2, 0);
		camController = new OrthoCamController(cam);
		Gdx.input.setInputProcessor(camController);

		texture = new Texture(Gdx.files.internal("data/tiles.png"));

		Random rand = new Random();
		for (int i = 0; i < LAYERS; i++) {
			caches[i] = new SpriteCache();
			SpriteCache cache = caches[i];
			cache.beginCache();
			for (int y = 0; y < HEIGHT; y++) {
				for (int x = 0; x < WIDTH; x++) {
					int tileX = rand.nextInt(5);
					int tileY = rand.nextInt(5);
					cache.add(texture, x << 5, y << 5, 1 + tileX * 33, 1 + tileY * 33, 32, 32);
				}
			}
			layers[i] = cache.endCache();
		}
	}

	@Override
	public void render () {
		GL10 gl = Gdx.gl10;
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		cam.update();

		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		for (int i = 0; i < LAYERS; i++) {
			SpriteCache cache = caches[i];
			cache.setProjectionMatrix(cam.combined);
			cache.begin();
			for (int j = 0; j < TILES_PER_LAYER; j += BLOCK_TILES) {
				cache.draw(layers[i], j, BLOCK_TILES);
			}
			cache.end();
		}

//		if (System.nanoTime() - startTime >= 1000000000) {
//			Gdx.app.log("TileTest", "fps: " + Gdx.graphics.getFramesPerSecond());
//			startTime = System.nanoTime();
//		}
	}



	@Override
	public void resize(int width, int height) {
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
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
