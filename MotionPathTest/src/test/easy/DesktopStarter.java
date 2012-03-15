package test.easy;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JoglApplication(new LineDrawingTest(), "Test Pixmao",1024, 512, false).getJFrame().setResizable(false);
	}
	
}
