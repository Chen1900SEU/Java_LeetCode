package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class Two_Sum {
    public static int[] main(String[] args) {
        int[] numbers = new int[0];
        int target = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < numbers.length;i++)
            {
                if (map.containsKey(numbers[i])){
                    return new int[]{map.get(numbers[i]),i};
                }else{
                    map.put(target-numbers[i],i);
                }
            }
            return new int[]{0, 0};
    }

}
/***
 我们常常使用 Map 对象来缓存数据, 比较常见的处理流程是:
 1. 调用 Map 的 get() 方法获取数据;
 2. 如果返回不为 null, 直接返回该数据;
 3. 如果返回为 null, 则生成数据, 或者从其他地方获取数据, 然后存放入 Map 中, 最后返回该数据.
 这里, 我们可以通过使用 Map 的containsKey() 方法来检测是否数据是否存在, 如果key存在, 则表明已经获取过一次数据, 那么直接返回该 key 在 Map 中的值. 不管是否为 null 都直接返回; 如果 key 不存在, 则去生成或者获取数据, 并放入到 Map 中, 并返回该数据.
 这里使用 containsKey() 来检测可以应用于: 1. 从其他对方获取的数据可能为空, 并且不会有变化; 2. 获取数据比较耗时. 这个场景下, 使用该方法可以大大降低消耗, 特别是在同步情况下.
 ***/