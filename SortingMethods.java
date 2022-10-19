package sortingmethod;
import java.util.Arrays;
public class SortingMethods {

	public static void main(String[] args) {
		/* 
		 Bubble Sort
		 Selection Sort
		 Insertion Sort
		 Shell Sort
		 
		 Run sort on arrays to prove your implementations are working
		 
		 Try to use times of swap to estimate their runtime performance.
		 
		 Submit your code with github repo link, and your conclusion of the runtime performance comparison.
		 */
		{
		public static void main(String[] args) {
		      
			int[] numbers = {85, 35, 28, 21, 2, 3, 41, 79, 64, 67, 22, 99, 51, 79, 65, 31, 71, 22, 63, 39, 6, 2, 40, 80, 53, 83, 24, 94, 66, 1, 74, 1};
			int[] n2 = numbers.clone();
			int[] n3 = numbers.clone();
			int[] n4 = numbers.clone();
			
		    System.out.println("UNSORTED: " + Arrays.toString(numbers));
		      
		    int swaps = bubbleSort(numbers);
		    int swaps2 = selectionSort(n2);
		    int swaps3 = insertionSort(n3,1,0);
		    int swaps4 = shellSort(n4);
		      
		    System.out.println("SORTED with bubble sort: " + Arrays.toString(numbers));
		    System.out.println("SORTED: " + Arrays.toString(n2));
		    System.out.println("SORTED: " + Arrays.toString(n3));
		    System.out.println("SORTED: " + Arrays.toString(n4));
		    
		    System.out.println("Length: " + numbers.length);
		    System.out.println("Swaps for bubble sort: " + swaps);
			System.out.println("Swaps for selection sort: " + swaps2);
			System.out.println("Swaps: " + swaps3);
			System.out.println("Swaps: " + swaps4);
			
		}
		
		private static void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		
		//Bubble Sort
		private static int bubbleSort(int[] nums) {
			int swaps = 0;
			for (int j = 0; j < nums.length - 1; j++) {
				for (int i = 0; i < nums.length - 1; i++) {
					if (nums[i] > nums[i+1]) {
						
						//Perform a swap
						int temp = nums[i];
						nums[i] = nums[i+1];
						nums[i+1] = temp;
						
						//Increment total
						swaps++;
					}
				}
			}
			
			return swaps;
			
		}
		
		
		
		//Selection Sort
		private static int selectionSort(int[] nums) {
			int swaps = 0;
			
			for (int j = 0; j < nums.length - 1; j++) {
				int min = j;
				for (int i = j + 1; i < nums.length; i++) {
					if (nums[i] < nums[min]) {
						min = i;
					}
				}
				
				int temp = nums[j];
				nums[j] = nums[min];
				nums[min] = temp;
				
				swaps++;
				
			}
			
			return swaps;
		}
		
		
		
		
		//Insertion Sort
		private static int insertionSort(int[] nums, int gap, int start) {
			int swaps = 0;
			
			//For each unsorted element
			for (int i = start + gap; i < nums.length; i = i + gap) {	
				
				//Swap it down into place
				for (int j = i; j - gap >= 0; j = j - gap) {
					
					if (nums[j] < nums[j-gap]) {
						swap(nums, j, j-gap);
						swaps++;
					} else {
						//If we don't need to swap anymore, then this element is sorted
						break;
					}
				}
			}
			
			return swaps;
			
		}
		
		
		
		
		//Shell Sort
		private static int shellSort(int[] nums) {
			
			int swaps = 0;
			
			//Gap sequence will be obtained via halving the prior gap, starting with the length of the array
			for (int gap = nums.length / 2; gap >= 1; gap = gap / 2) {
				
				//Need to sort each interleaved array with that gap
				for (int i = 0; i < gap; i++) {
					swaps = swaps + insertionSort(nums, gap, i);
				}	
			}
			
			return swaps;
		}
	}

}
}