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

package test.easyWay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class OrthoCamController extends InputAdapter {
	final OrthographicCamera camera;
	final Vector3 curr = new Vector3();
	final Vector3 last = new Vector3(-1, -1, -1);
	final Vector3 delta = new Vector3();

	
	
	public OrthoCamController (OrthographicCamera camera) {
		this.camera = camera;
	}

	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		if(camera.position.x  <= 480 && camera.position.x >=0 &&
		   camera.position.y  <= 320 && camera.position.y >=0 ){
			camera.unproject(curr.set(x, y, 0));
			if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
				camera.unproject(delta.set(last.x, last.y, 0));
				delta.sub(curr);
				camera.position.add(delta.x, delta.y, 0);
			}
		}else{
			if(camera.position.x  > 480){
				camera.unproject(curr.set(x, y, 0));
				if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
					camera.unproject(delta.set(last.x, last.y, 0));
					delta.sub(curr);
					if(delta.x < 0)
						camera.position.add(delta.x, delta.y, 0);
					else if (camera.position.y  <= 320 && camera.position.y >=0)
						camera.position.add(0, delta.y, 0);
				}
			}
			if(camera.position.x  < 0){
				camera.unproject(curr.set(x, y, 0));
				if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
					camera.unproject(delta.set(last.x, last.y, 0));
					delta.sub(curr);
					if(delta.x > 0)
						camera.position.add(delta.x, delta.y, 0);
					else if (camera.position.y  <= 320 && camera.position.y >=0)
						camera.position.add(0, delta.y, 0);
				}
			}
			
			if(camera.position.y  < 0){
				camera.unproject(curr.set(x, y, 0));
				if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
					camera.unproject(delta.set(last.x, last.y, 0));
					delta.sub(curr);
					if(delta.y > 0)
						camera.position.add(delta.x, delta.y, 0);
					else if(camera.position.x  <= 480 && camera.position.x >=0)
						camera.position.add(delta.x, 0, 0);
				}
			}	
			if(camera.position.y  > 320){
				camera.unproject(curr.set(x, y, 0));
				if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
					camera.unproject(delta.set(last.x, last.y, 0));
					delta.sub(curr);
					if(delta.y < 0)
						camera.position.add(delta.x, delta.y, 0);
					else if(camera.position.x  <= 480 && camera.position.x >=0)
						camera.position.add(delta.x, 0, 0);
				}
			}
		}
		last.set(x, y, 0);
		return false;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		last.set(-1, -1, -1);
		return false;
	}
//	Gdx.app.log("TileTest", "" + camera.position.x + " " + camera.position.y + " " + camera.position.z);
}
