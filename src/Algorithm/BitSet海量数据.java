package Algorithm;

import java.util.BitSet;

public class BitSet海量数据 {
    public static void main(String[] args) {
        BitSet bm = new BitSet();
        System.out.println(bm.isEmpty()+"--"+bm.size());
        bm.set(0);
        System.out.println(bm.isEmpty()+"--"+bm.size());
        bm.set(1);
        System.out.println(bm.isEmpty()+"--"+bm.size());
        System.out.println(bm.get(65));
        System.out.println(bm.isEmpty()+"--"+bm.size());
        bm.set(65);
        System.out.println(bm.isEmpty()+"--"+bm.size());
    }
    //说明默认的构造函数声明一个64位的BitSet，值都是false。如果你要用的位超过了默认size,它会再申请64位，而不是报错。

}
