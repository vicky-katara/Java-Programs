package vicky8rk;

public class Binary {

	public String addBinary(String a, String b) {
		int ind_a = a.length();
		int ind_b = b.length();
		
		String ret = "";
		int carryOver = 0;
		
		while(ind_a >0 && ind_b> 0){
			int dig_a = Character.getNumericValue(a.charAt(--ind_a));
			int dig_b = Character.getNumericValue(b.charAt(--ind_b));
			ret = (dig_a+dig_b+carryOver)%2 + ret;
			carryOver = (dig_a+dig_b+carryOver)/2;
			//System.out.println("dig_a:"+dig_a+"dig_b:"+dig_b+"\t CarryOver:"+carryOver);
			//carryOver = 0;
			//System.out.println("combined: \t\t\t "+ret);
		}
		
		if(ind_a == 0 )
			while(ind_b> 0){
				//int dig_a = a.charAt(--ind_a);
				int dig_b = Character.getNumericValue(b.charAt(--ind_b));
				ret = (dig_b+carryOver)%2 + ret;
				//System.out.println("dig_b:"+dig_b+"\t CarryOver:"+carryOver);
				carryOver = (dig_b+carryOver)/2;
				//carryOver = 0;
				//System.out.println("from_b: \t\t\t"+ret);
			}
		if(ind_b == 0)
			while(ind_a> 0){
				int dig_a = Character.getNumericValue(a.charAt(--ind_a));
				//int dig_b = b.charAt(--ind_b);
				ret = (dig_a+carryOver)%2 + ret;
				carryOver = (dig_a+carryOver)/2;
				//carryOver = 0;
				//System.out.println("from_a:\t\t\t"+ret);
			}
		if(carryOver!=0)
			ret = (carryOver)%2 + ret;
		//System.out.println("final: \t\t\t"+ret);
		if(ret.contains("1"))
			return ret.substring(ret.indexOf("1"));
		else return "0";
    }
	
	public static void main(String[] as){
		System.out.println(new Binary().addBinary("1", "101"));
	}
}
