package vicky8rk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CoinIterator {

	//int denomination[]=new int[]{50,25,10,5,1};
	int denomination[]=new int[]{10,6,1};
	
	HashMap returnCoinsGreedy(int amount, HashMap coins){
		if(amount==0)
			return coins;
		else{
			int i = 0;
			while(denomination[i]>amount){
				i++;
			}
			int num_coins = (coins.get(denomination[i])!=null)?(int)coins.get(denomination[i]):0;
			coins.put(denomination[i], num_coins+1);
			return returnCoinsGreedy(amount-denomination[i], coins);
		}
	}
	
	HashMap returnCoinsConstant(int amount, HashMap coins){
		if(amount==0)
			return coins;
		else{
			int i = 0;
			while(denomination[i]>amount){
				i++;
			}
			coins.put(denomination[i], amount/denomination[i]);
			return returnCoinsGreedy(amount%denomination[i], coins);
		}
	}
	
	HashMap returnCoinsConstant2(int amount, HashMap coins){
		int amount_left = amount;
		for(int i=0; i<denomination.length;i++){
			//if(denomination[i]>amount_left)
			{
				coins.put(denomination[i], amount_left/denomination[i]);
				amount_left = amount_left % denomination[i];
			}
		}
		return coins;
	}
	
	public static void main(String... asr){
		
		int amount = 24;
		
		CoinIterator ci = new CoinIterator();
		//for(int i=1;i<=100;i++){
		HashMap a=ci.returnCoinsGreedy(amount, new HashMap());
		System.out.println(Arrays.toString(a.entrySet().toArray()));
		
		HashMap b=ci.returnCoinsConstant(amount, new HashMap());
		System.out.println(Arrays.toString(b.entrySet().toArray()));

		HashMap c=ci.returnCoinsConstant(amount, new HashMap());
		System.out.println(Arrays.toString(c.entrySet().toArray()));
		
		//System.out.println(a.equals(b)+" for "+i);
		//}
	}
	
}
