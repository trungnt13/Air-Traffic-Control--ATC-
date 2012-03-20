package test.airport.utils.math;

public class QuadricFunction extends Function{
	float a;
	float b;
	float c;
	float speed;
	
	public QuadricFunction(AttributeSet attributes) {
		super(attributes);
	}

	public void setAttributes(AttributeSet attr){
		if(attr.size() >= 3)
			this.set = attr;
		else 
			this.set = new AttributeSet(new float[3]);
		this.a = attr.attr[0];
		this.b = attr.attr[1];
		this.c = attr.attr[2];
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	@Override
	public double getFactor(double x) {
		return Math.atan(derivative(x));
	}

	@Override
	public double derivative(double x) {
		double h = x * MIN;
		return (f(x+h)-f(x-h)) / (2*h);
	}

	@Override
	public double f(double x) {
		return (a*x*x + b*x + c);
	}

	@Override
	public double f1(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
