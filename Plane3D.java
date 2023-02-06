/*
 * Jamie Bly
 * 300231604
 * Jan 20 2023
 * CSI2120 Project - Java - Part 1
 * 
 * Equations for the Equations of the Plane is sourced from: https://keisan.casio.com/exec/system/1223596129
 * 
 */

import java.lang.Math;

public class Plane3D {
	
	//The final values for the plane
	double planeX;
	double planeY;
	double planeZ;
	double planeD;

	/**
	* Constructor for a Plane3D with an input of three Point3D
	* @param pA The first Point3D used to calculate the Plane3D
	* @param pB The second Point3D used to calculate the Plane3D
	* @param pC The third Point3D used to calculate the Plane3D
	*/
	public Plane3D(Point3D pA, Point3D pB, Point3D pC) {
		
		double ABx, ABy, ABz, ACx, ACy,ACz; //defines the variables for the results from combining points A/B and A/C
		
		//results from first subtraction
		ABx = pB.getX() - pA.getX();
		ABy = pB.getY() - pA.getY();
		ABz = pB.getZ() - pA.getZ();
		
		//results from first subtraction
		ACx = pC.getX() - pA.getX();
		ACy = pC.getY() - pA.getY();
		ACz = pC.getZ() - pA.getZ();
		
		//Cross multiplying to get the overal X,Y,Z of the plane, including the D.
		planeX = ABy * ACz - ACy * ABz;
		planeY = ABz * ACx - ACz * ABx;
		planeZ = ABx * ACy - ACx * ABy;
		planeD = -( planeX * pA.getX() + planeY * pA.getY() + planeX * pA.getZ() );
		
	}
	
	/**
	* Constructor for a Plane3D with the param of 4 doubles
	* @param a The first double of the calculation
	* @param b The second double of the calculation
	* @param c The third double of the calculation
	* @param d The fourth double of the calculation
	*/
	public Plane3D(double a, double b, double c, double d) {
		
		planeX = a;
		planeY = b;
		planeZ = c;
		planeD = d;
		
	}
	
	/**
	* Calculates the distance from the Plane3D to the given Point3D
	* @param A Point3D to calculate the distance
    * @return The distance from the Plane3D to Point3D
	*/
	public double getDistance(Point3D pt) {
		
		return Math.abs( planeX * pt.getX() + planeY * pt.getY() + planeZ * pt.getZ() ) / Math.sqrt( Math.pow(planeX, 2) + Math.pow(planeY, 2) + Math.pow(planeZ, 2) );
	}
	
	
}
