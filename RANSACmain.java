

/*
 * Jamie Bly
 * 300231604
 * Feb 5 2023
 * CSI2120 Project - Java - Part 1
 */
public class RANSACmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("RANSAC Algorithm has started");
		
		//Instantiates PointCloud1
		PointCloud pcOne = new PointCloud("PointCloud1.xyz");
		
		pcOne.save(pcOne.getOrigName() + "_p0.xyz");//Saves original PointCloud
		
		PlaneRANSAC ranOne = new PlaneRANSAC(pcOne);//Initializes the PlaneRANSAC
		ranOne.setEps(2);//Sets the eps
		int numOfIters = ranOne.getNumberOfIterations(0.99, 0.1);//Calculates number of iterations to be done for RANSAC of PCone
		//Performs the 3 runs of the radsac
		ranOne.run(numOfIters, pcOne.getOrigName());
		ranOne.run(numOfIters, pcOne.getOrigName());
		ranOne.run(numOfIters, pcOne.getOrigName());
		
		System.out.println("Finished first PointCloud");
		//Instantiates PointCloud2
		PointCloud pcTwo = new PointCloud("PointCloud2.xyz");
		
		pcTwo.save(pcTwo.getOrigName() + "_p0.xyz");//Saves original PointCloud
		
		PlaneRANSAC ranTwo = new PlaneRANSAC(pcTwo);//Initializes the PlaneRANSAC
		ranTwo.setEps(2);//Sets the eps
		numOfIters = ranTwo.getNumberOfIterations(0.99, 0.1);//Calculates number of iterations to be done for RANSAC of PC2
		//Performs the 3 runs of the radsac
		ranTwo.run(numOfIters, pcTwo.getOrigName());
		ranTwo.run(numOfIters, pcTwo.getOrigName());
		ranTwo.run(numOfIters, pcTwo.getOrigName());
		
		System.out.println("Finished second PointCloud");
		//Instantiates PointCloud3
		PointCloud pcThree = new PointCloud("PointCloud3.xyz");
		
		pcThree.save(pcThree.getOrigName() + "_p0.xyz");//Saves original PointCloud
		
		PlaneRANSAC ranThree = new PlaneRANSAC(pcThree);//Initializes the PlaneRANSAC
		ranThree.setEps(2);//Sets the eps
		numOfIters = ranThree.getNumberOfIterations(0.99, 0.1);//Calculates number of iterations to be done for RANSAC of PC3
		//Performs the 3 runs of the radsac
		ranThree.run(numOfIters, pcThree.getOrigName());
		ranThree.run(numOfIters, pcThree.getOrigName());
		ranThree.run(numOfIters, pcThree.getOrigName());
		
		System.out.println("Finished third PointCloud");
		
		System.out.println("RANSAC Algorithm has finished");
		
		
		
		
		
		
		
		
		
		
	}

}
