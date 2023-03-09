import java.lang.reflect.Array;
import java. util.*;


public class Sorting {
    public static void bubblesort(Integer arr[]){
        for(int turn = 0; turn<arr.length-1; turn++){
            for(int j=0; j<arr.length-1-turn; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void OptimisedBubbleSort (int arr[]) {
       for(int turn = 0; turn<arr.length; turn++){
        boolean swapped = false;
        for(int j = 0; j<arr.length-1-turn; j++){
           if(arr[j]>arr[j+1]){
             //swap
             int temp = arr[j];
             arr[j] = arr[j+1];
             arr[j+1] = temp;
             swapped = true;
              }
             }
          if(swapped == false){
             break; 
          }
       }
    }
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void selectionSort(Integer arr[]) {
        for(int i=0; i<arr.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[minPos]< arr[j]) {
                   minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
     
    public static void insrtionSort(Integer arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;

        
         }      
    }

    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        int j=0;
        for(int i = 0; i<count.length; i++){
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
        
    

    public static void main(String[] args) throws Exception {
        int arr[] = {1, 6, 3, 9, 2, 9, 58, 8, 8};
        OptimisedBubbleSort(arr);
        //Arrays.sort(arr, 0, 5, Collections.reverseOrder());
        printArr(arr);
        
    }
}
