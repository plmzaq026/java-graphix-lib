package visual;

import utils.VecTool;

public class Ray {
	public Vec3 origin;
	public Vec3 direction;
	
	public Ray(){};
	public Ray( Vec3 origin,  Vec3 direction) 
	{ 
		
		this.origin = origin;
		this.direction = direction;
	}
	public Vec3 origin(){ 
		return origin; 
	}
	public Vec3 direction(){ 
		return direction; 
	}
	public Vec3 pointAtParameter(float t) {
	    return VecTool.plus(this.origin, VecTool.conTimes(this.direction,t));
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
