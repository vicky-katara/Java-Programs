package CSC505;

import java.util.HashMap;

class MatrixMult_Memoized {
	
	int[][] s;
	int[] p;
	HashMap<String, Integer> computed = new HashMap<String, Integer>();
	
	MatrixMult_Memoized(int[] p){
		this.p = p;
		s = new int[p.length][p.length];
		long startTime = System.nanoTime();
		int minNumOps = computeOps(1, p.length-1);
		long endTime = System.nanoTime();
		System.out.println("Minimum Operations:"+minNumOps);
		printOptimalParens(1, p.length-1);
		System.out.println("\nTime taken for Memoized (In Nanosecs:)"+(endTime-startTime));
		System.out.println(computed.entrySet());
	}

	void printOptimalParens(int i, int j){
		if(i==j)
			System.out.print("A"+i);
		else{
			System.out.print("(");
			printOptimalParens(i, s[i][j]);
			printOptimalParens(s[i][j]+1, j);
			System.out.print(")");
		}
	}
	
	int computeOps(int i, int j){
		int min;
		String key_val = i+"_"+j;
		if(i==j)
			return 0;
		else{
			
			if(computed.containsKey(key_val))
				return computed.get(key_val);
			min = Integer.MAX_VALUE;
			for(int k=i;k<j;k++){
				int currOps = computeOps(i,k)+computeOps(k+1,j)+p[i-1]*p[k]*p[j];
				if(currOps < min){
					min = currOps;
					s[i][j] = k;
				}
			}		
		}
		computed.put(key_val, min);
		return min;
	}
	
	public static void main(String... ars){
		int p[] = new int[]{30,35,15,5,10,20,25,30,35,15,5,10,20,25,30,35};
		//new MatrixMult_Recursive(p);
		new MatrixMult_Memoized(p);
		//new MatrixMult_DP(p);
	}
}
