package LeetCode;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 Given two integers x and y, calculate the Hamming distance.
 在信息论中，两个等长字符串之间的汉明距离（英语：Hamming distance）是两个字符串对应位置的不同字符的个数。它就是将一个字符串变换成另外一个字符串所需要替换的字符个数。

 Note:
 0 ≤ x, y < 2^31.
 */
public class Hamming_Distance {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(1^4));//^符号用于异或， 函数Returns the number of one-bits in the two's complement binary
        int x=1,y=4;
        int xor = x^y;
        int count = 0;
        for(int i=0;i<32;i++)
            count +=(xor>>i)&1;//移位运算符
        System.out.println(count);

    }
}
