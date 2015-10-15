package CSC505;

import java.util.Arrays;

public class LongestNonDecDP {
	
	int[] l;
	int[] last;
	String[] s, s_temp;
	int[] seq;
	int n;
	
	LongestNonDecDP(int[] seq){
		this.seq = seq;
		this.n = seq.length - 1;
		l = new int[seq.length];
		s = new String[seq.length];
		s_temp = new String[seq.length];
		int max_index = longestNonDecDP();
		System.out.println("Longest subsequence Sequence is {"+s[max_index].replace(";", ",")+"} of length "+l[max_index]);
	}
	
	int longestNonDecDP(){
		l[0] = 1;
		s[0] = Integer.toString(seq[0]);
		for(int i=1;i<=n;i++){
			int max = -1;
			int max_ind = -1;
			for(int j=0;j<i;j++)
				if(seq[j]<seq[i] && l[j] > max){
					max = l[j];
					max_ind = j;
				}
			l[i] = 1 + max;
			if(max_ind != -1)
				s[i] = s[max_ind]+";"+seq[i];
		}
//		System.out.println(Arrays.toString(seq));
//		System.out.println(Arrays.toString(l));
//		System.out.println(Arrays.toString(s));
		int max_index = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			if(l[i]>max){
				max = l[i];
				max_index = i;
			}
		return max_index;
	}
	
	public static void main(String[] args) {
		//int seq[]=new int[]{3, 45, 23, 9, 3, 99, 108, 76, 12, 77, 16, 18, 4};
		int seq[]=new int[]{3,45,54,6,9,12,8};
		new LongestNonDecDP(seq);
	}
}
