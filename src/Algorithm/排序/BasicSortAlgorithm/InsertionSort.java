package Algorithm.排序.BasicSortAlgorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++ ){//排序好的数字
            for(int j = i+1;j>0;j--){
                if(arr[j-1]<=arr[j])
                    break;
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,2,6,7,8,4,5,6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
