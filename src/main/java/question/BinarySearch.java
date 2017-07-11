package question;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		//Integer[] list = Arrays.asList("dsf");

	}

	
	public static int binarySearch(Integer[] srcArray, int des) {
	    int low = 0;
	    int high = srcArray.length - 1;
	 
	    while ((low <= high) && (low <= srcArray.length - 1)
	            && (high <= srcArray.length - 1)) {
	        int middle = (high + low) >> 1;
	        if (des == srcArray[middle]) {
	            return middle;
	        } else if (des < srcArray[middle]) {
	            high = middle - 1;
	        } else {
	            low = middle + 1;
	        }
	    }
	    return -1;
	}
}
