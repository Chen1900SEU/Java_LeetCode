package Algorithm;

/**
 Tip.1 在计算 mid 时不能使用 mid = (l + h) / 2 这种方式，因为 l + h 可能会导致加法溢出，应该使用 mid = l + (h - l) / 2。
 Tip.2对 h 的赋值和循环条件有关:
 当循环条件为 l <= h 时，h = mid - 1；
 当循环条件为 l < h 时，h = mid。
 解释如下：在循环条件为 l <= h 时，如果 h = mid，会出现循环无法退出的情况，例如 l = 1，h = 1，此时 mid 也等于 1，如果此时继续执行 h = mid，那么就会无限循环；
 在循环条件为 l < h，如果 h = mid - 1，会错误跳过查找的数，例如对于数组 [1,2,3]，要查找 1，最开始 l = 0，h = 2，mid = 1，判断 key < arr[mid] 执行 h = mid - 1 = 0，此时循环退出，直接把查找的数跳过了。

 二分查找优点是找的快，缺点是待查表为有序表。
 */
public class Binary_search {
    public static int search(int key, int[] array){
        int l = 0, h = array.length-1;
        while (l<=h)
        {
            int middle = l + (h-1)/2;//此处注意写middle的方法,Tip1
            if(key == array[middle])
                return middle;
            if(key<array[middle])
                h = middle -1;//Tip2
            else
                l = middle +1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array =  {1,2,3,5,6,7,8};
        System.out.println(search(2,array));
    }
}
