package vicky8rk;

import java.util.Arrays;

public class BInarySearch {
	
	int binarySearch(int[] arr, int start_index, int end_index,int x){
		System.out.print(Arrays.toString(arr)+", "+start_index+", "+end_index+", "+x);
		if(end_index - start_index == 1)
		{
			if(arr[start_index]==x)
				return start_index;
			else
				return -1;
		}
		else
		{
			int mid = (end_index + start_index)/2;
			System.out.println("\t"+mid+", "+arr[mid]);
			if(x<arr[mid])
				return binarySearch(arr, start_index, mid, x);
			else
				return binarySearch(arr, mid, end_index, x);
		}
	}
	
	public static void main(String[] ar){
		System.out.println("\n\nresult: "+new BInarySearch().binarySearch(new int[]{1,2,3,4,4,4,4	,5}, 0, 5, 4));
	}

}
