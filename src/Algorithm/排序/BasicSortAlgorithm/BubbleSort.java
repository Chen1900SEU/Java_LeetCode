package Algorithm.排序.BasicSortAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[]arr){
        for (int i = arr.length;i>0;i--){//外层移动游标
            for(int j=0;j<i&&(j+1)<i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                }
            }
        }
    }

    public static void BubbleSort(int[]arr){
        int i, temp,len = arr.length-1;
        boolean change=true;
        while (change){
            change = false;
            for (i=0;i<len;i++){
                if(arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    change = true;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        String out = "";
        BubbleSort(arr);
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+' ');
//        }

    }
}
