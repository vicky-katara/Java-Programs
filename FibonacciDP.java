package vicky8rk;

import java.util.HashMap;

public class FibonacciDP {

	HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
	FibonacciDP(){
		store.put(0,0);
		store.put(1,1);
		//fibonacciComputeOrLookup(x);
	}
	
	int fibonacciComputeOrLookup(int num){
		if (store.containsKey(num))
			return store.get(num);
		else{
			int ret = fibonacciComputeOrLookup(num-1)+fibonacciComputeOrLookup(num-2);
			store.put(num, ret);
			return ret;
		}
	}
	
	int fibonacciRecursive(int num){
		if(num==0)
			return 0;
		else if(num==1)
			return 1;
		else return fibonacciRecursive(num-1)+fibonacciRecursive(num-2);
	}
	
	public static void main(String... ars){
		FibonacciDP fd = new FibonacciDP();
		int num = 40; 												// < ----- Provide input here
		long startDP=System.nanoTime();
		int answer = fd.fibonacciComputeOrLookup(num);
		long endDP=System.nanoTime();
		System.out.println("FibDP("+num+")="+answer+". Processed in "+(endDP-startDP)+" msecs.");
		long startRec=System.nanoTime();
		answer = fd.fibonacciRecursive(num);
		long endRec=System.nanoTime();
		System.out.println("FibRec("+num+")="+answer+". Processed in "+(endRec-startRec)+" msecs.");
		System.out.println("Dynamic Programming reduces time to a factor of "+(endDP-startDP)*(100.0)/(endRec-startRec)+"%");
	}
}
