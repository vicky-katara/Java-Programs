package vicky8rk;

import java.util.Arrays;

public class BinarySearchFirstLast {

	static int binarySearchLast(char[] arr, int start, int end, char x ){
		if(start>end)
			return -1;
		int mid = (end+start)/2; // floor of
		if(arr[mid]==x){
			for(int i=mid;i<arr.length;i++)
				if(arr[i]!=x)
					return i-1;
		}
		else
			if(arr[mid]<x)
				return binarySearchLast(arr, mid+1, end, x);
			else
				return binarySearchLast(arr, start, mid-1, x);
		return -1;
	}
	static int binarySearchFirst(char[] arr, int start, int end, char x ){
		if(start>end)
			return -1;
		int mid = (end+start)/2; // floor of
		if(arr[mid]==x){
			for(int i=mid;i>=0;i--)
				if(arr[i]!=x)
					return i+1;
		}
		else
			if(arr[mid]<x)
				return binarySearchFirst(arr, mid+1, end, x);
			else
				return binarySearchFirst(arr, start, mid-1, x);
		return -1;
	}
	public static void main(String... ars){
		char[] c = "Viiccky".toLowerCase().toCharArray();
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		System.out.println(binarySearchLast(c, 0,c.length, 'i' ));
		System.out.println(binarySearchFirst(c, 0,c.length, 'i' ));
	}
}
