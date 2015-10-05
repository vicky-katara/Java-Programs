package vicky8rk;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class BinaryAddition {

	static int[] add(int[] a, int[] b){
		int[] c= new int[a.length+1];
		int carry_over = 0; 
		for(int i=a.length-1;i>=0;i--){
			c[i+1] = (a[i]+b[i]+carry_over)%2;
			carry_over = (a[i]+b[i]+carry_over)/2;
		}
		c[0]=carry_over;
		
		return c;
	}
	
	public static void main(String... ars) throws UnknownHostException{
		System.out.println(Arrays.toString(add(new int[]{1,0,1}, new int[]{1,1,0})));
	}
	
}
