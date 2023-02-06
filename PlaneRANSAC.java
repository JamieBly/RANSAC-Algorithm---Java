import java.util.*;

/*
 * Jamie Bly
 * 300231604
 * Jan 20 2023
 * CSI2120 Project - Java - Part 1
 */

public class PlaneRANSAC {
	
	double eps;
	PointCloud cloud;
	int currentRun;
	int numIts;

	/**
	 * The constructor for the PlaneRANSAC.
	 * @param pc The PointCloud to be used for the PlaneRANSAC
	 */
	public PlaneRANSAC(PointCloud pc) {
		
		cloud = pc;
		currentRun = 0;
		
		numIts = getNumberOfIterations(99, 10000);//Default numbers
		
		
	}
	
	/**
	* Sets the epsilon value to the given new one.
    * @param A new double eps value
	*/
	public void setEps(double newEps) {
		
		eps = newEps;
		
	}
	
	/**
	* Returns the current eps value
    * @return The epsilon value
	*/
	public double getEps() {
		
		return eps;
	}
	
	/**
	* Calculates the number of iterations needed to have a certain level of confidence in our algorithms success
    * @param confidence The percent, represented by a double from 0 to 1, that we wish for the algorithm to be concise
    * @param percentageOfPointsOnPlane   The percentage of points we want to compare to determine the most dominant plane
    * @return The number of iterations needed to have our desired accuracy in regards to the most dominant plane
	*/
	public int getNumberOfIterations(double confidence, double percentageOfPointsOnPlane) {
		
		numIts = (int) (Math.log(1 - confidence) / Math.log( 1 - Math.pow(percentageOfPointsOnPlane,3)) );
		
		return numIts;
				
	}
	
	/**
	* Finds the most dominant plane in the PointCloud, and exports it into a .xyz folder
    * @param numberOfIterations The number of different random planes that will be tested to determine the most dominant
    * @param filename  The name of the file containing the exported most dominant plane
    * @return A list of points in the neihborhood of P
	*/
	public void run(int numberOfIterations, String filename) {
		
		int currIter = 0;
		int bestSupp = 0;
		List<Point3D> dom = new ArrayList<Point3D>();
		Plane3D domPlane = new Plane3D(cloud.getPoint(), cloud.getPoint(), cloud.getPoint());//holds the domPlane, is arbitrarily initialized
		
		//Finds the most dominant plane by taking 3 random points as a plane a number of time to
		//ensure with 99% correctness
		while(currIter < numberOfIterations) {
			
			Iterator<Point3D> it = cloud.iterator();
			
			int currSupp = 0;
			List<Point3D> tempList = new ArrayList<Point3D>();
			
			//Instantiates 3 random points in PointCloud
			Point3D randyA = cloud.getPoint();
			Point3D randyB = cloud.getPoint();
			Point3D randyC = cloud.getPoint();
			
			Plane3D curr = new Plane3D(randyA, randyB, randyC);
			//Iterator runs through all points in PC, and compares the distance to the Plane with the eps
			while(it.hasNext()) {
				
				Point3D currPoint = it.next();
				
				if ( curr.getDistance(currPoint) < eps ) {
					tempList.add(currPoint);
					currSupp++;
				}
				
			}
			
			if( currSupp > bestSupp) {
				bestSupp = currSupp;
				dom = tempList;
				domPlane = curr;
				
				
			}
			
			currIter++;
			
		}
		
		Iterator<Point3D> iter = cloud.iterator();//Instantiates iterator
		
		//Goes back and deletes the points of the most dominant plane
		while(iter.hasNext()) {
						
			Point3D currPoint = iter.next();
						
			if ( domPlane.getDistance(currPoint) < eps ) {
					iter.remove();
			}
			
		}
		
		//Creates a new PointCloud for the dominant plane, and adds all points
		PointCloud domCloud = new PointCloud();
		while (dom.size() !=0) {
			domCloud.addPoint(dom.remove(0));
		}
		
		currentRun++;
		domCloud.save(filename + "_p"+currentRun+".xyz");//Saves the most dominant plane in an .xyz / file output
		
		
		
	}
	
}
