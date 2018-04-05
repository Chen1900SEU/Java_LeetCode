package Algorithm.二分查找;

/**
 https://leetcode.com/problems/sqrtx/description/
 Implement int sqrt(int x).
 Compute and return the square root of x.
 x is guaranteed to be a non-negative integer.
 **/

public class Sqrt {
    public static int mySqrt(int x){
        if(1<x&&x<4)
           return 1;

        if (x<=1)
            return x;

        int l = 1,h=1+x/2;
        while (l<=h){
            int mid = l+(h-l)/2;
            int sqrt = x/mid;
            if(sqrt==mid)
                return mid;
            else if(sqrt<mid)
                h=mid-1;
            else
                l=mid+1;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
    }
}
