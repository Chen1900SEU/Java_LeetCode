package Hash_Table;

import java.util.HashMap;
import java.util.Map;

/**
 1. Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map =new HashMap<>();
//        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
//                result[0]=map.get(temp);
//                result[1]=i;
                return new int[]{map.get(temp), i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        int[] array ={2,7,11,15};
        int target = 9;
        int[] result = twoSum(array,target);
        System.out.println(result[0]+" "+result[1]);
    }
}

/*
Tip: Array in java
http://www.runoob.com/java/java-array.html
 */