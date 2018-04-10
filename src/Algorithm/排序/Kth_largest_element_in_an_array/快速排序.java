package Algorithm.排序.Kth_largest_element_in_an_array;

public class 快速排序 {
    /********************************************************************************
     * 快速选择方法
     * @param nums
     * @param k
     * @return
     *******************************************************************************/
    public static int findKthelement1(int[] nums,int k){
        k=nums.length-k;//因为只要排len-k个数字就行
        int low=0;
        int high=nums.length-1;
        while(low<high){
            final int j=partition(nums,low,high);
            if(j<k){
                low=j+1;
            }else if(j>k){
                high=j-1;
            }else {
                break;
            }
        }
        return nums[k];
    }
    public static int partition(int[] a,int lo,int hi){
        int i=lo;
        int j=hi+1;
        while (true){
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static boolean less(int v, int w) {
        return v < w;
    }

    /********************************************************************************
     * 快速排序方法
     * @param nums
     * @param k
     * @return
     *******************************************************************************/
    public static int findKthelement2(int[] nums,int k) {
        quickSortarray(nums,0,nums.length-1);
        return nums[(nums.length-k)];
    }
    public static void quickSortarray(int[] nums, int head,int tail){
        if(head>=tail||nums==null||nums.length<=1)
            return;
        int i = head, j = tail, pivot = nums[(head + tail) / 2];
        while (i<=j){//注意等号
            while (nums[i]<pivot){
                ++i;
            }
            while (nums[j]>pivot){
                --j;
            }
            if(i<j){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                ++i;
                --j;
            }else if(i==j){
                ++i;//让循环退出！
            }
        }
        quickSortarray(nums,head,j);
        quickSortarray(nums,i,tail);
    }

    /******************************************************************************
     * 快速选择方法
     * @param a
     * @param k
     * @return
     *******************************************************************************/
    public static int findKthelement3(int[] a,int k){
        int n = a.length;
        int p = quickSelect(a, 0, n - 1, n - k + 1);
        return a[p];
    }
    // return the index of the kth biggest number
    public static int quickSelect(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);
        // count the nums that are <= pivot from lo
        int m = i - lo + 1;
        // pivot is the one!
        if (m == k)
            return i;
        // pivot is too big, so it must be on the left
        else if (m > k)
            return quickSelect(a, lo, i - 1, k);
        // pivot is too small, so it must be on the right
        else
            return quickSelect(a, i + 1, hi, k - m);
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        System.out.println("result:");
        int res = findKthelement2(arr, 2);

        System.out.println(res);
    }

}
