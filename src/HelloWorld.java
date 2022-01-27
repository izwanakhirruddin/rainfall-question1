import java.text.DateFormatSymbols;
import java.util.Scanner;

public class HelloWorld {

	private static String[][] aLocationData = null;

	public static void main(String[] args) {
		// create an object of Scanner
		Scanner input = new Scanner(System.in);

		System.out.print("Enter number of location (N): ");
		// take integer input from the user
		int iNumberLocation = input.nextInt();

		// initialize the 2D array
		aLocationData = new String[iNumberLocation][6];

		//loop N times to ask user for rainfall data of each location
		for(int i=0; i<iNumberLocation; i++) {
			System.out.print("Enter 6 months rainfall data for location "+(i+1)+", separated by comma: ");
			// take string input from the user
			String sRainfallData = input.next();
			// convert string above to 1D array for 6 months
			String[] aRainfallData = sRainfallData.split(",");
			// populate each location with the data above
			aLocationData[i] = aRainfallData;
		}

		//ask user for X
		System.out.print("Enter respective month (X): ");
		int iMonth = input.nextInt();
		//ask user for Y
		System.out.print("Enter respective location of interest (Y): ");
		int iLocation = input.nextInt();

		// show the result from X and Y
		System.out.println(getMonthForInt(iMonth) + ": " + getMonthSum(iMonth) + " mm");
		System.out.println("Location " + iLocation + ": " + getLocationSum(iLocation) + " mm");

		// closing the scanner object
		input.close();
	}

	static String getMonthForInt(int num) {
	    String month = "wrong";
	    DateFormatSymbols dfs = new DateFormatSymbols();
	    String[] months = dfs.getMonths();
	    if (num >= 0 && num <= 11) {
	        month = months[num-1];
	    }
	    return month;
	}
	
	static double getMonthSum(int iMonth) {
		double dMonthSum = 0.0;
		// loop the aLocationData data
		for(int i=0; i<aLocationData.length; i++) {
			String[] aRainfallData = aLocationData[i];

		    // get rainfall data for the month
			String sRainfallData = aRainfallData[iMonth];
		    // sum for X
			dMonthSum += Double.parseDouble(sRainfallData);
		}
		return dMonthSum;
	}
	
	static double getLocationSum(int iLocation) {
		// get rainfall data for the location first
		String[] aRainfallData = aLocationData[iLocation-1];
		double dLocationSum = 0.0;
		// loop the above data
		for(int j=0; j<aRainfallData.length; j++) {
			String sRainfallData = aRainfallData[j];
		    // sum for Y
			dLocationSum += Double.parseDouble(sRainfallData);
		}
		return dLocationSum;
	}
}
