package vicky8rk;

import java.util.Arrays;

public class MergeSort {
	
	int[] arr;
	int size;
	
	MergeSort(int[] orig){
		arr = new int[size=orig.length];
		System.arraycopy(orig, 0, arr, 0, size);
		mergeSort(0, size);
		System.out.println("!!!!MergeSort Result!!!!");
		System.out.println(Arrays.toString(arr));
	}
	void mergeSort(int start_index, int end_index){
		System.out.println("MergeSort:"+Arrays.toString(arr)+","+start_index+","+end_index);
		if(end_index-start_index <= 1)
			return;
		else{
			int mid = (end_index+start_index)/2;
			mergeSort(start_index, mid);
			mergeSort(mid, end_index);
			merge(start_index, mid, end_index);
		}
	}
	void merge(int start, int mid, int end){
		int i=start, j=mid;
		System.out.println("Merge:"+"\n"+Arrays.toString(arr)+", "+start+","+mid+","+end+".");
		int[] new_arr = new int[size];
		int new_arr_top=-1;
		while(i<mid && j<end){
			if(arr[i]<arr[j]){
				new_arr[++new_arr_top]=arr[i];
				i++;
			}
			else{
				new_arr[++new_arr_top]=arr[j];
				j++;
			}
		}
		if(i<mid)
			while(i<mid){
				new_arr[++new_arr_top]=arr[i];
				i++;
			}
		if(j<end)
			while(j<end){
				new_arr[++new_arr_top]=arr[j];
				j++;
			}
		for(int x=0;x<=new_arr_top;x++){
			arr[start+x]=new_arr[x];
		}
		System.out.println(Arrays.toString(arr)+", "+start+","+mid+","+end+".");
	}
	public static void main(String[] ars){
		new MergeSort(new int[]{11,2,5,12,43,5});
	}
}
