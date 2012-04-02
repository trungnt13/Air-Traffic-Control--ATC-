package test.airport.utils.math;

public class TrigonometricFunction1 extends Function{
	float a;
	float b;
	
	public TrigonometricFunction1(FunctionSet attributes) {
		super(attributes);
	}

	@Override
	public void setAttributes(FunctionSet attr) {
		if(attr.size() >= 2)
			this.set = attr;
		else 
			set = new FunctionSet(new float[2]);
		a = set.attr[0];
		b = set.attr[1];
	}

	@Override
	public double getFactor(double x) {
		if(x == 0)
			x =0.000000001;
		return Math.atan(derivative(x));
	}

	@Override
	public double derivative(double x) {
		if(x == 0)
			x = 0.000000001;
		double h = x * MIN;
		return (f(x+h) - f(x-h))/(2*h);
	}

	@Override
	public double f(double x) {
		double ag = Math.toRadians(x);
		return a*Math.sin(ag)+ b * Math.cos(ag);
	}

	@Override
	public double f1(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
