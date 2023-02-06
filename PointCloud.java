import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;

/*
 * Jamie Bly
 * 300231604
 * Jan 20 2023
 * CSI2120 Project - Java - Part 1
 */
public class PointCloud {

	List<Point3D> pcList;
	public String nameOfOrigPC;
	
	
	/**
	* Creates a PointCloud from a given file 
	* @param The filename of the file that contains the data for the PointCloud
	*/
	public PointCloud(String filename) {
		
		nameOfOrigPC = filename;
		pcList = new ArrayList<Point3D>();
		
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String temp[];
			String newLine = " ";
			
			br.readLine();
			while( (newLine = br.readLine()) != null ) {
				
				temp = newLine.split("	");
				NumberFormat nf = NumberFormat.getInstance(Locale.CANADA);
				Point3D inPoint = new Point3D(nf.parse(temp[0]).doubleValue(), nf.parse(temp[1]).doubleValue(), nf.parse(temp[2]).doubleValue() );
				
				pcList.add(inPoint);
			}
			
			br.close();
			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error: File Not Found Exception");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error: Number Format Exception");
			e.printStackTrace();
		} catch(IOException e ) {
			System.out.println("Error: IO Exception");
			e.printStackTrace();
		} catch(ParseException e ) {
			System.out.println("Error: Parse Exception");
			e.printStackTrace();
		}
		
	}
	
	/**
	* Creates an empty PointCloud 
	*/
	public PointCloud() {
		
		pcList = new ArrayList<Point3D>();
		
	}
	/**
	* Adds a Point3D to the PointCloud
    * @param pt The point we want to add to the PointCloud
	*/
	public void addPoint(Point3D pt) {
		
		pcList.add(pt);
		
	}
	
	/**
	* Returns the name of the original PointCloud file
    * @return Name of original file
	*/
	public String getOrigName() {
		return nameOfOrigPC;
	}
	
	/**
	* Returns a random Point3D from the PointCloud
    * @return A Random Point3D
	*/
	public Point3D getPoint() {
	
		int maxArr =  pcList.size();
		Random randy = new Random();
		
		int randomPoint = randy.nextInt(maxArr);
		
		return pcList.get(randomPoint);
		
	}
	
	/**
	* Saves the current pcList as an .xyz file.
    * @param filename The name of the file that will contain the exported PointCloud
	*/
	public void save(String filename) {
		
		try {
			File outFile = new File(filename);
			
			if(outFile.createNewFile()) {
				System.out.println("File has been created:" +outFile.getName());
			} else {
				System.out.println("File already exists");
			}
			
			FileWriter writer = new FileWriter(filename);
			
			
			int i = 0;
			
			while( i < pcList.size()) {
				
				Point3D currWrite = pcList.get(i);
				writer.write( currWrite.getX() + "     " + currWrite.getY() + "     " + currWrite.getZ() + "\n" );
				i++;
			}
			
			writer.close();
		
			
		} catch(IOException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		}
		
	}
	/**
	* The iterator for the PointCloud
	*/
	public Iterator<Point3D> iterator(){
		
		Iterator<Point3D> it = new Iterator<Point3D>() {
			private int currentIndex = 0;
			
			/**
			* Returns if the iterator has a 'next' value
		    * @return A boolean value describing if there is a next value
			*/
			@Override
			public boolean hasNext() {
				
				return currentIndex < pcList.size() && pcList.get(currentIndex) != null;
			}
			
			/**
			* Iterates the iterator to the next value, and returns the current value
		    * @return The next value in the iterator
			*/
			@Override 
			public Point3D next(){	
				currentIndex++;
				return pcList.get(currentIndex-1);
				
			}
			
			/**
			* Removes the current value of the Iterator from the PointCloud
			*/
			@Override 
			public void remove() {
				
				pcList.remove(currentIndex -1);
				
			}
			
		};
		
		
		
		
		
		return it;
	}
	
}
