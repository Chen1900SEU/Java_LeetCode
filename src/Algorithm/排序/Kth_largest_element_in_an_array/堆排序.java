package Algorithm.排序.Kth_largest_element_in_an_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,Given [3,2,1,5,6,4] and k = 2, return 5.
 https://blog.csdn.net/cyp331203/article/details/25310733
 https://ych0112xzz.github.io/2016/10/27/PriorityQueue/
 https://blog.csdn.net/u011116672/article/details/50997622
时间复杂度 O(nlgk)，空间复杂度 O(k)
 **/
public class 堆排序 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });//寻找第k小；
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//保证是升序，寻找第k大

        for (int val : nums){
            maxHeap.offer(val);//Inserts the specified element into this priority queue.

            if(maxHeap.size()>k){//保证只有k个数从大到小（或者从小到大）排列在队列中！
                maxHeap.poll();//该方法调用返回队列的头部，或null，如果队列为空。
            }
            System.out.println(maxHeap);
        }
        return maxHeap.peek();
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] numbs = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = findKthLargest(numbs, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
