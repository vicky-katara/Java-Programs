package vicky8rk;
import java.util.*;
public class UglyNumbers {
	SortedSet doneSet, processingSet;
    public int nthUglyNumber(int n) {
    	doneSet = new TreeSet();
    	processingSet = new TreeSet();
    	processingSet.add(1);	
    	populate(n);
    	return ((Integer)doneSet.toArray()[n-1]).intValue();
    }
    void populate(int n){
    	Object first;
    	while(processingSet.size()>0 && doneSet.size() <= n){
    		first = processingSet.first();
    		add_multiplicants_of(((Integer)first).intValue());
    		doneSet.add(first);
    		processingSet.remove(first);
    	}
    }
    void add_multiplicants_of(int x){
    	System.out.println("addING_multiplicants_of "+x);
    	processingSet.add(x*2);
    	processingSet.add(x*3);
    	processingSet.add(x*5);
    }
    public static void main(String[] args){
    		//System.out.println(new Solution().nthUglyNumber(1600));
    		System.out.println(new Solution().isUgly(14));
    }
    
    boolean isUgly(int x){
    	if(x==0) return false;
    	while(x%2==0)
    		x=x/2;
    	while(x%3==0)
    		x=x/3;
    	while(x%5==0)
    		x=x/5;
    	return (x ==1)?true:false;
    }
}