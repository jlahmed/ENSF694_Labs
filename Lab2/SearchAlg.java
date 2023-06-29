import java.util.Arrays;
import java.util.Scanner;

public class SearchAlg {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//These are used to calculate time elapsed for search
		double start_time, end_time;
	    
		//Populate the array from user input and request search key
			System.out.print("Enter the number of elements in the array: ");
		    int size = scanner.nextInt();
		    int [] elements = new int[size];
		    System.out.println("Enter the elements in the array: ");
		    
		    for (int i = 0; i < size; i++) {
		        elements[i] = scanner.nextInt();
		    }
		    
		    System.out.print("Enter the serach key: ");
		    int key = scanner.nextInt();
		    scanner.close();
	    
	    
	    // Linear Search Method
			boolean search_result = false;
			int index = 0;
			
			// Start timer and iterate through each index in the array. Close timer when done.
			start_time = System.nanoTime();
		    while (index < size) {
		    	if (elements[index] == key) {
		    		search_result = true;
		    		break;
		    	}
		    	index++;
		    }
		    end_time = System.nanoTime() - start_time;
		    
		    //Linear search results output
		    if (search_result == true) {
	    		System.out.println("\nResult using Linear Search:\nSearch key found at index "
	    				+ index + ".\nExecution time: " + end_time + " nanoseconds.");
		    }else {
		    	System.out.println("\nSearch key not found");
		    }

		    
		//Improved linear search method
			// Reset variables from last search. Index set to midpoint. Close timer when done.
		    search_result = false;
			index = size / 2;
			
			//Start timer and iterate 
			start_time = System.nanoTime();
		    while (index < size) {
	    		// This If statement is used to check for match as the index is incremented towards the end of array
		    	if (elements[index] == key) {
		    		end_time = System.nanoTime() - start_time;
	    			search_result = true;
	    			break;
	    		}
		    	
		    	// This If statement is used to check for match as the index is reduced towards the start of array
	    		if (elements[size - index - 1] == key) {
	    			end_time = System.nanoTime() - start_time;
	    			search_result = true;
	    			index = size - index - 1;
	    			break;
	    		}
		    	index++;
		    }
		    
	    
		    //Improved linear search results output
		    if (search_result == true) {
	    		System.out.println("\nResult using Improved Linear Search:\nSearch key found at index "
	    				+ index + ".\nExecution time: " + end_time + " nanoseconds.");
		    }
		    
		    
		//Interpolation Search method
		    //Reset search result for new search method
		    search_result = false;
		    
		    //Set conditions required to start interpolation method
		    Arrays.sort(elements);
	    	int low = 0; 
	    	int high = size -1;
	    	int pos = (key - elements[low]) / (elements[high] - elements[low]) ;
	    	int mid = elements[low] + ((elements[high] - elements[low]) * pos);
		    
	    	// Start timer and iterate through the array by reassigning the low and high values based on key position
			start_time = System.nanoTime();
	    	while (low <= high) {
	    		mid = (low + high) / 2;
	    		
	    		if (key < elements[mid]) {
	    				high = mid - 1;
	    		} else if(elements[mid] < key) {
	    				low = mid + 1;
	    		} else {
	    			end_time = System.nanoTime() - start_time;
	    			search_result = true;
	    			break;
	    		}	    			    	
	    	}	
	    	
	    	//Interpolation Search Result Output
	    	if (search_result == true) {
    			System.out.println("\nResult using Interpolation Search:\n" + 
    					"Search key found at index " + mid + ".\nExecution time: " + 
    					end_time + " nanoseconds.");
	    	}
	    	
	}


}
