package Algorithm.排序.Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** hash table,heap.
 Given a non-empty array of integers, return the k most frequent elements.
 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].
 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class 桶排序 {
    public static List<Integer> topKFrequent(int[] nums, int k) {//O(n) Solution
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num:nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];//frequency 可以取0-n
        for(int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);//frequency=value
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);//记录下各自频数下的key list
            System.out.println("frequency："+frequency+" "+bucket[frequency]);

        }
        System.out.println("Bucket len: "+bucket.length);
        for(int i=bucket.length-1;i>=0&&ret.size()<k;i--){//从最高的开始

            if(bucket[i]!=null){//不是0的bucket进行存储到result中
                ret.addAll(bucket[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,2,3,3,3,4,5,5,6,7,7,8};
        List res = topKFrequent(arr,2);
        System.out.println(res);

    }
}
