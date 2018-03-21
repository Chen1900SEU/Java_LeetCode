package Algorithm;

/**
 540. Single Element in a Sorted Array
 Given a sorted array consisting of only integers where every element appears twice except for one element which appears once.
 Find this single element that appears only once.
 Example 1:
 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2
 Example 2:
 Input: [3,3,7,7,10,11,11]
 Output: 10
 Note: Your solution should run in O(log n) time and O(1) space.
 */
//如果mid处在偶数位置！则有相同数字在哪边则那边就是有单一数字的半边。
public class Single_Element_in_Sorted_Array {
    public static int singleNonDuplicate(int[] nums) {
        int l=0,h=nums.length-1;
        while (l<h){//退出的条件永远都是l=h
            int mid = l+(h-l)/2;
            if(mid%2 == 1)
                mid = mid-1;
//            System.out.println(mid);
            if(nums[mid]==nums[mid+1])
                l=mid+2;
            else
                h=mid;//这里不需要提供elseif去返回nums[mid]
        }
        return nums[h];
    }
    public static void main(String[] args) {
        int[] nums ={1,1,2};
        int result=singleNonDuplicate(nums);
        System.out.println(result);
    }
}
