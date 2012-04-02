package test.airport.utils.math;

import com.badlogic.gdx.math.Vector2;

public class CircleFunction extends Function{

	Vector2 center ;
	float radius;
	
	public CircleFunction(FunctionSet attributes) {
		super(attributes);
	}
	
	@Override
	public void setAttributes(FunctionSet attr) {
		if(attr.size() >= 3 )
			this.set = attr;
		else 
			set = new FunctionSet(new float[]{0,0,0} );
		center = new Vector2();
		center.x = set.attr[0];
		center.y = set.attr[1];
		this.radius = set.attr[2];
	}
	
	
	@Override
	public double getFactor(double x) {
		if(x == 0)
			x += 0.000000001;
		double tan = derivative(x);
		return  Math.atan(tan);
	}

	@Override
	public double derivative(double x) {
		if(x == 0)
			x += 0.000000001;
		double h = x * MIN;
		return (f(x+h) - f(x-h))/(2*h) ;
	}
	
	public double f(double x){
		return (double) ( Math.sqrt( Math.abs( radius*radius - Math.pow((x - center.x),2))) ) + center.y;
	}

	@Override
	public double f1(double x){
		return (double) (-Math.sqrt(Math.abs(radius*radius - Math.pow((x - center.x),2)))) + center.y;
	}


	
}
