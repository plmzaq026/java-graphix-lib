package utils;

import visual.Ray;
import visual.Vec3;

public class VecTool {
	public static Vec3 plus(Vec3 v1, Vec3 v2) 
	{
		return new Vec3(v1.e[0] + v2.e[0], v1.e[1] + v2.e[1], v1.e[2] + v2.e[2]);
	}
	public static Vec3 minus( Vec3 v1,  Vec3 v2) 
	{
		return new Vec3(v1.e[0] - v2.e[0], v1.e[1] - v2.e[1], v1.e[2] - v2.e[2]);
	}
	public static Vec3 conTimes(double t,  Vec3 v) {
		  return new Vec3(v.e[0] * t, v.e[1] * t, v.e[2] * t);
		}
	public static Vec3 conTimes( Vec3 v, double t) {
	  return new Vec3(v.e[0] * t, v.e[1] * t, v.e[2] * t);
	}
	public static double dot( Vec3 v1,  Vec3 v2) {
	  return v1.e[0] * v2.e[0] + v1.e[1] * v2.e[1] + v1.e[2] * v2.e[2];
	}
	public static Vec3 cross( Vec3 v1,  Vec3 v2) {
	  return new Vec3(
	          v1.e[1] * v2.e[2] - v1.e[2] * v2.e[1],
	          -(v1.e[0] * v2.e[2] - v1.e[2] * v2.e[0]),
	          v1.e[0] * v2.e[1] - v1.e[1] * v2.e[0]
	  );
	}
	public static double hitSphere(Vec3 center, double radius, Ray r)
	{
		Vec3 oc = VecTool.minus(r.origin, center);
		double a = VecTool.dot(r.direction,r.direction);
		double b = 2.0*VecTool.dot(oc,r.direction);
		double c = VecTool.dot(oc,oc) - radius*radius;
		double derta = b*b-4*a*c;
		if(derta < 0)
		{
			return -1.0;
		}
		return (-b-Math.sqrt(derta))/(2*a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
