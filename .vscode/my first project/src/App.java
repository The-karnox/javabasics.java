import java.util.*;
import java.util.prefs.PreferencesFactory;


public class App {
    public static void printHelloworld(){
        System.out.println("hello world");
    }


    public static void calculateSum(int a , int b) {
        int sum = a + b;
        System.out.println("Sum is  :" + sum);
    }

    public static int factorial(int n) {
        int f = 1;
        for(int i = 1; i <= n; i++){
            f = f*i;
        }
        return f;
    }

    public static boolean isPrime(int n){
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void primesInRange(int n){
        for(int i=2; i<=n; i++) {
            if(isPrime(i)) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static boolean isEven(int number) {
        if (number %2 == 0) {
            return true;
        } 
        else{
            return false;
        }

            
    }

    public static void Hollow_rectangle(int totRows, int totCols ){
        for(int i=1; i<=totRows; i++){
            for(int j=1; j<=totCols; j++){
                if(i==1|| i==totRows || j==1 || j==totCols) {
                    System.out.print("*");

                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void floyds_triangle (int n) {
        int counter = 1;
        for(int i=1; i<=n; i++) {
            for(int j = 1; j<=n-i+1; j++) {
                System.out.print(counter +  " ");
                counter++;
            }
            System.out.println();
        }
     }
     public static void zero_one_triangle(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++){
                if( (i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
     }
     public static void batman(int n) {
        for(int i=1; i<=n/2; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            for (int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();

        }
        for(int i=n; i>=1; i--){
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            for (int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
 
        }
     }
     public static void rhombus(int n){
        for (int i=1; i<=n; i++) {
            for(int j=1; j<=(n-i) ; j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=n; j++){
                System.out.print("*");
            }
            System.out.println();

        }
     }
     public static void hollow_rhombus(int n){
        for (int i=1; i<=n; i++) {
            for(int j=1; j<=(n-i) ; j++) {
                System.out.print(" ");
            }
             
                for(int j=1; j<=n; j++){
                    if(i==1|| i==n || j==1 || j==n) {
                        System.out.print("*");
    
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

     }

     public static void kite(int n) {
        for(int i=1; i<=n; i++){
           for(int j=1; j<=(n-i); j++) {
            System.out.print(" ");
           } 
           for(int j=1; j<=(2*i)-1; j++){
            System.out.print("*");
           }
           System.out.println();

        }
        for(int i=n; i>=1; i--){
            for(int j=1; j<=(n-i); j++) {
             System.out.print(" ");
            } 
            for(int j=1; j<=(2*i)-1; j++){
             System.out.print("*");
            }
            System.out.println();}
     }

     public static void Pairs(int numbers[]) {
        int tp = 0;
        for(int i=0; i<numbers.length; i++) {
            int curr= numbers[i];
            for(int j=i+1; j<numbers.length; j++) {
                System.out.print("(" +curr + "," + numbers[j]+ ")" );
                 tp++;
            }
            System.out.println();


        }
        System.out.println("total pairs=" + tp );
     }

     public static void subarrays(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[]= new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i = 1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + numbers[i];
        }
        for(int i=0; i<numbers.length; i++) {
            
            int start = i;
            for(int j=i; j<numbers.length; j++ ) {
                int end = j;
                currSum = start==0 ? prefix[end] :  prefix[end] - prefix[start-1];
            
                
                }
                
                if(maxSum<currSum) {
                    maxSum = currSum; 
                }
                
            }
            System.out.println("maxsum = " + maxSum);
            

        }



     public static void Kadanes(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0; i<numbers. length; i++) {
            cs = cs + numbers[i];
            if(cs < 0) {
                cs = 0;

            }
            ms = Math.max(cs,ms);
         }
         System.out.println("our max subarray sum is : " + ms);

     } 

     public static int trappedRainWater(int height[]) {
        int n = height.length;
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedRainWater = 0;

        for(int i=0; i<n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            trappedRainWater += waterLevel - height[i];
        }
        return trappedRainWater;
     }

     public static int stocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            if(buyPrice<prices[i]){
                int profit = prices[i] - buyPrice;

                maxProfit = Math.max(maxProfit, profit );
            }
            else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
     }

     





     
        

        
     

     



    public static void main(String[] args) throws Exception {
        int prices[] = {19, 2, 4, 7, 2, 1, 6, 9, 19};
        System.out.println(stocks(prices));

        

        

        }
   }

