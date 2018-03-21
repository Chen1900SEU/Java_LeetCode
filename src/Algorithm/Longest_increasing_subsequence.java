package Algorithm;

/**
 https://leetcode.com/problems/longest-increasing-subsequence/solution/
 300. Longest Increasing Subsequence
 *Given an unsorted array of integers, find the length of longest increasing subsequence.
 For example,Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Longest_increasing_subsequence {
    public static int lengthOfLIS(int[] nums) {
        /**
        这一方法比较容易想到！
         **/
        int result=0;
        int[] lis = new int[nums.length];//构建最长升序序列长度数组

        for (int i=0;i<nums.length;i++){
            // 找出当前点之前的最大上升序列长度
            int localmax=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]&&lis[j]>localmax){
                    //temp=nums[j];
                    localmax = lis[j];
                }
            }
            lis[i]=localmax +1;
            result = Math.max(result,lis[i]);
        }
        return result;
    }

    public static int lengthOfLIS1(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] lis = new int[nums.length];//构建最长升序序列长度数组
        lis[0] = 1;
        int max = 0; //存储结果
        for(int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if(nums[j]<nums[i])//递归的考虑，看过往数据并且运用0<j<i。
                    lis[i] = Math.max(lis[i],lis[j]);//找0-(i-1)中最大的升序序列长度且num[j]<num[i]
            }
            lis[i]+=1;//该位置能构成的最长升序序列长度。
            max = Math.max(max,lis[i]);
        }
        return max;
    }
    public static int lengthOfLIS2(int[] nums) {
        /**？？？
         * tail[k]表示长度为k+1的子序列末尾数字。并且tail[k]递增。
         如果nums[i]比所有序列的末尾都大，或等于最大末尾，说明有一个新的不同长度序列产生，我们把最长的序列复制一个，并加上这个nums[i]。
         如果nums[i]比所有序列的末尾都小，说明长度为1的序列可以更新了，更新为这个更小的末尾。
         如果在中间，则更新那个末尾数字刚刚大于等于自己的那个序列，说明那个长度的序列可以更新了。
         */
        if(nums.length==0)
            return 0;
        int len = 0;//len表示当前最长的升序序列长度（为了方便操作tails我们减1）
        int[] tails = new int[nums.length];//针对每加入一个数可以组成的序列进行一个记录
        tails[0]=nums[0];
        for (int i = 1;i<nums.length;i++){
            if(nums[i]<tails[0])
                tails[0] = nums[i];
            else if(nums[i]>tails[len]){
                tails[++len]=nums[i];
            }else
                tails[binarySearch(tails,0,len,nums[i])] = nums[i];
        }
        return len+1;
    }
    private static int binarySearch(int[] tails, int min, int max, int target){
        while (min<=max){
            int mid = min + (max-min)/2;
            if(tails[mid]==target)
                return mid;
            if(tails[mid]<target)
                min = mid+1;
            if(tails[mid]>target)
                max = mid-1;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {2,2};

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
        for(int x:nums){//用于打印数组中的数
            System.out.print(x+" ");
        }
        int i=-3;
        i = -(i+1);
        System.out.println(i);
    }
}

