package test.airport.context;



public abstract class InputProcessor implements com.badlogic.gdx.InputProcessor{
	
	final int id;
	
	
	public InputProcessor(int id){
		this.id = id;
	}
	
	public int getID(){
		return this.id;
	}
}
