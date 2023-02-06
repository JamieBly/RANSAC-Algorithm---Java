/*
 * Jamie Bly
 * 300231604
 * Jan 20 2023
 * CSI2120 Project - Java - Part 1
 */
public class Point3D {

	private double X;
	private double Y;
	private double Z;
	
	/**
	 * The constructor of the Point3D. Sets the X,Y,Z points of the Point3D
	 * @param x The X value of the Point3D
	 * @param y The Y value of the Point3D
	 * @param z The Z value of the Point3D
	 */
	public Point3D(double x, double y, double z) {
		X =x;
		Y=y;
		Z=z;
	}
	/**
	* Returns the X value
    * @return The X double value of the Point3D 
	*/
	public double getX() {
		return X;
	}
	
	/**
	* Returns the Y value
    * @return The Y double value of the Point3D 
	*/
	public double getY() {		
		return Y;
	}
	/**
	* Returns the Z value
    * @return The Z double value of the Point3D 
	*/
	public double getZ() {
		return Z;
	}
	
	
}
