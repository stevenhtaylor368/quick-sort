import java.util.Random;
/**
 * @author Steven Taylor
 * @version 8/27/2020
 * @class CSCI 333
 * @assignment HW3 QuickSort
 * @description This class implements QuickSort with 5 calls to the quickSort method and the randomQuickSort method respectively. 
 * Implementation from chapter 7 of book no changes or alterations to ensure accuracy. Random partition method created to implement 
 * randomQuickSort as necessary. Random value selected based upon the length of the array to 0. 
 */
public class quickSort{
	Random rand = new Random();
	public void quickSort(int [] array, int start, int end) {
		if(start < end) {
			int q = partition(array, start, end);
			System.out.println("After partition" + java.util.Arrays.toString(array));
			
			quickSort(array, start, q-1);
			quickSort(array, q+1, end);
		}
	}
	
	private int partition(int[] array, int start, int end) {
		int x = array[end];
		int i = start - 1;
		for( int j= start; j<=end-1; j++) {
			if(array[j] <= x) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i+1];
		array[i+1] = array[end];
		array[end] = temp;
		return i+1;
	}
	
	private int randomPartition(int[] array, int start, int end) {
		int i = rand.nextInt(end) + start;
		int temp = array[end];
		array[end] = array[i];
		array[i] = temp;
		return partition(array, start, end);
	}
	public void randomQuickSort(int [] array, int start, int end) {
		if(start < end) {
		int q = randomPartition(array, start, end);
		randomQuickSort(array, start, q-1);
		randomQuickSort(array, q+1, end);
		}
	}


	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,10,7,9,6,11,8,12};
		quickSort sort0 = new quickSort();
		sort0.quickSort(array, 6, 11);
		System.out.println(java.util.Arrays.toString(array));



	}

}
