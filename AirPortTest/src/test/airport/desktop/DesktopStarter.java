package test.airport.desktop;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JoglApplication(new ATCGame(), "test", 1024, 768, false);
	}

}
