package visual;


public class Vec3 {
	public double[] e = new double[3];
	
	public Vec3() {
		super();
		for(int i =0 ;i < 3;i ++)
			e[i] = 0;
	}

	public Vec3(double e0,double e1,double e2) {
		super();
		this.e[0] = e0;
		this.e[1] = e1;
		this.e[2] = e2;
	}
	public double x()  { return e[0]; }
	public double y()  { return e[1]; }
	public double z()  { return e[2]; }
	public double r()  { return e[0]; }
	public double g()  { return e[1]; }
	public double b()  { return e[2]; }

	public double length() {
		return Math.sqrt(e[0]*e[0] + e[1]*e[1] + e[2]*e[2]);
	}
	public double squared_length() {
		return e[0]*e[0] + e[1]*e[1] + e[2]*e[2];
	}

	@Override
	public String toString() {
		return e[0] + " " + e[1] + " " + e[2];
	}
	
	public Vec3 unitVector()
	{
		double len = this.length();
		return new Vec3(this.x()/len,this.y()/len,this.z()/len);
	}
	
	
	
}
