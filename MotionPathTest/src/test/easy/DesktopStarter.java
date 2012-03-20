package test.easy;

import test.easy.viewport.ProjectionViewPortCamera;

import com.badlogic.gdx.backends.jogl.JoglApplication;
public class DesktopStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new JoglApplication(new TiledMapTest(), "Test Pixmao",900, 600, false).getJFrame().setResizable(false);
//		new JoglApplication(new MapTest(), "Test Pixmao",900, 600, false).getJFrame().setResizable(false);
//		new JoglApplication(new TileTest(), "Test Pixmao",900, 600, false).getJFrame().setResizable(false);
//		new JoglApplication(new OrthographicCameraTesting(), "Test Pixmao",480, 320, false).getJFrame().setResizable(false);
//		new JoglApplication(new IsometricTileTest(), "test", 900, 600, false);
//		new JoglApplication(new IsoCamTest(), "test", 900, 600, false);
//		new JoglApplication(new ProjectionViewPortCamera(), "tittle", 900, 600, false);
		new JoglApplication(new SpriteTest(), "", 900, 600, false);
	
	}
}
