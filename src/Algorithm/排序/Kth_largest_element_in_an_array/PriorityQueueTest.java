package Algorithm.排序.Kth_largest_element_in_an_array;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        minHeap.offer(6);
        minHeap.offer(-1);
        minHeap.offer(9);
        minHeap.offer(0);
        System.out.println(minHeap);
        int len = minHeap.size();//这里之所以取出.size()大小，因为每一次poll()之后size大小都会变化，所以不能作为for循环的判断条件
        for(int i=0;i<len;i++){
            System.out.print(minHeap.poll()+" ");//只有poll了的是升序
        }
    }
}
