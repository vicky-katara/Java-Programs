package vicky8rk;
import java.util.Arrays;

public class InsertionSort {
	
	public int[] sort(int[] input){
		
		for(int i=1; i<input.length;i++)
		{
			int x = input[i];
			System.out.println("Taking x = "+x);
			int j;
			for(j=i-1; j>=0 && input[j] > x ;j--){
				input[j+1] = input[j];
				System.out.println("\t"+input[j+1]+" moves one place ahead in the sorted list.");
				}
			input[j+1] = x;
		}
		
		int[] ret = new int[input.length];
		System.arraycopy(input, 0, ret, 0, input.length);
		return ret;
	}
	
	public static void main(String[]  args){
		//System.out.println(Arrays.toString(new InsertionSort().sort(new int[]{2,5,2,1,4,6,7,12,52,3,0,-18})));
		System.out.println(Arrays.toString(new InsertionSort().sort(new int[]{6,3,5})));
	}

}
