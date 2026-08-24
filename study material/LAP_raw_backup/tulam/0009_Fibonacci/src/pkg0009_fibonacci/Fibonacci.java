package pkg0009_fibonacci;

import java.util.HashMap;

public class Fibonacci {

    private static HashMap<Integer, Long> memoization = new HashMap<>();
    //Tim ra so fibonacci thu n su dung de quy

    public long fibonacci(int n) {
        if(memoization.containsKey(n)) return memoization.get(n);
        long result;
        if(n==0) result = 0;
        else if(n==1) result = 1;
        else{
            result = fibonacci(n-1)+fibonacci(n-1);
        }
        memoization.put(n, result);
        return result;
    }
    
    public void displayResult(int n){
        System.out.printf("The %d sequence fibonacci:\n", n);
        //Su dung vong lap de in ra tung so fibonacci
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
    }

   
   
    }
 public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
            
        fibo.displayResult(45);
        
        }
}
