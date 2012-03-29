package test.airport.context;

public class S {
	public static final class speed{
		
	}
	
	public static final class direction{
		public static final byte SLIENT = 0;
		public static final byte LEFT = 1;
		public static final byte RIGHT = 2;
		public static final byte UP = 3;
		public static final byte DOWN = 4;
	}
	
	public static final class fname{
		public static final byte Circle = 1;
		public static final byte Quadric = 2;
		public static final byte Triple = 3;
		public static final byte Abs = 4;
		public static final byte Line = 5;
		public static final byte Trigonometric1  = 6;
	}
	
	public static final class mode{
		public static final byte FreeMode = 1;
		public static final byte PathMode = 2;
	}
	
	public static final class pconfig{
		public static final byte GO_TO = 1;
		public static final byte ORBIT_MOVE = 2;
		public static final byte AVOID = 3;
	}
}
