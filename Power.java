package vicky8rk;

public class Power {
	int power(int a, int n){
		if(n==0)
			return 1;
		else
			if (n %2 ==0){
				int p = power(a,n/2);
				return p*p;
			}
			else{	
				int p = power(a, (n/2));
				return p*p*a;}
	}
	public static void main(String[] as){
		System.out.println(new Power().power(5, 5));
	}
}
