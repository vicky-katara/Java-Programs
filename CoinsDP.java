package vicky8rk;

import java.util.Arrays;
import java.util.HashMap;

public class CoinsDP {

	//int[] denominations = new int[]{50, 25, 10, 5, 1};
	//int[] denominations = new int[]{10,6,1};
	int[] denominations = new int[]{1, 2, 5};
	
	int change(int req_amount){
		int[] num_coins = new int[req_amount+1];
		num_coins[0]=0;
		
		for(int amount_value=1;amount_value<=req_amount;amount_value++){
			int min = 99999;
			for(int coin=0;coin<denominations.length;coin++){
				//System.out.print("amount_value:"+amount_value+"denom:"+denominations[coin]);
				if(denominations[coin]<=amount_value){
					//System.out.println("amount_value:"+amount_value+"denom:"+denominations[coin]);
					//System.out.println(" inside");
					int current_num_coin = num_coins[amount_value-denominations[coin]];
					if(current_num_coin +1<min)
						min=current_num_coin+1;
				}
			}
			num_coins[amount_value]= min;
			System.out.println(Arrays.toString(num_coins));
		}
		
		return num_coins[req_amount];
	}
	public static void main(String... ars){
		//CoinsDP c = new CoinsDP();
		//System.out.println("Number of coins for 6 is "+c.change(6));
		System.out.println(2500/2000);
	}
	
}
