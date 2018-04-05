package Algorithm.二分查找;

/**
 * LeetCode 441
 You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 Given n, find the total number of full staircase rows that can be formed.
 n is a non-negative integer and fits within the range of a 32-bit signed integer.
 **/
public class Arranging_Coins {
    public static int arrangeCoins(int n) {
        int l =1,h=n;
        while(l<=h){
            int mid = l + (h-l)/2;
            int x = mid*(mid+1)/2;
            System.out.println(l+"*"+h+"*"+mid+" x="+x);
            if (x==n)
                return mid;
            else if (x<n)
                l = mid+1;
            else
                h = mid-1;
            System.out.println(l+" "+h);
        }
        return h;
    }

    public static int arrangecoins2(int n){
        int l =1,h=n;
        while(l<=n){
            int mid = l + (h-l)/2;
            long x = mid*(mid+1L)/2;//此处必须这样表示
            if(x<=n&&(x+mid+1)>n)
                return mid;
            else if (x<n)
                l = mid+1;
            else
                h = mid-1;
        }
        return h;//边界判断
    }

    public static int arrangecoins3(int n){
        int level = 1;
        while (n>0){
            n -= level;
            level ++;
        }
        return  n==0?level-1:level-2;
    }

    public static void main(String[] args) {
        int result = arrangecoins3(1804289383);
        System.out.println(result);
    }
}
