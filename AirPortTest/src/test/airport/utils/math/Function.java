package test.airport.utils.math;

import test.airport.context.S;

public abstract class Function {

	static final double MIN = 1e-8;
	AttributeSet set;
	
	public Function(AttributeSet attributes){
		setAttributes(attributes);
	}
	
	
	public abstract void setAttributes(AttributeSet attr);
	
	public abstract double getFactor(double x);
	
	public abstract double derivative(double x);
	
	public abstract double f(double x);
	
	public abstract double f1(double x);
}
