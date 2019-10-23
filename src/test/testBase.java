package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import utils.VecTool;
import visual.Ray;
import visual.Vec3;

public class testBase {
	public static Vec3 color(Ray r)
	{
		Vec3 unit_direction = r.direction().unitVector();
		double t = 0.5 * (unit_direction.y() + 1.0);
		return VecTool.plus(
				VecTool.conTimes(1.0-t, new Vec3(1.0,1.0,1.0)),
				VecTool.conTimes(t, new Vec3(0.5,0.7,1.0))
				);
		
	}
	public static void main(String [] args) throws FileNotFoundException
	{
		int nx = 200;
		int ny = 100;
		FileOutputStream os = new FileOutputStream(new File("test.ppm"));
		PrintWriter pw = new PrintWriter(os);
		pw.print("P3\n"+nx+" "+ny+"\n255\n");
		Vec3 lowerLeftCorner = new Vec3(-2.0,-1.0,-1.0);
		Vec3 horizontal = new Vec3(4.0,0,0);
		Vec3 vertical = new Vec3(0,2.0,0);
		Vec3 origin = new Vec3(0,0,0);
		for(int j = ny - 1;j >= 0;j --)
		{
			for(int i = 0;i < nx;i ++)
			{
				double u = (double)i / (double)nx;
				double y = (double)j / (double)ny;
				Ray r = new Ray(origin,
						VecTool.plus(
								VecTool.plus(lowerLeftCorner,VecTool.conTimes(u, horizontal)),
								VecTool.conTimes(u, vertical))
						);
				Vec3 col = color(r);
			
				pw.println(				
						(int)255.99 * col.e[0] + " " +
						(int)255.99 * col.e[1] + " " + 
						(int)255.99 * col.e[2]);
			}
		}
	}
}
