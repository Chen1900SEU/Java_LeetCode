package 剑指offer;
/*
请实现一个函数，将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    /**
     * 空间换时间方法。
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str){
        /* 转成char[]
        String sti=str.toString();
        char []strChar=sti.toCharArray();
         */
        StringBuffer res = new StringBuffer();
        for(int i = 0;i<str.length();i++){
            //char n = str.charAt(i);
            if (str.charAt(i)==' '){
                res.append("%20");
            }else {
                res.append(str.charAt(i));
            }
            //System.out.println(str.charAt(i));
        }
        return res.toString();

    }

    /**
     * 考虑直接在原字符串上修改,双指针做法，从后往前。
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str){
        //因为需要大规模移动所以需要StringBuffer
        if(str.length()==0||str==null){
            return null;
        }
        int Originallen = str.length();
        int space = 0;

        for(int i=0;i<Originallen;i++){
            if(str.charAt(i)==' '){
                ++ space;
            }
        }
        System.out.println(space);
        int p2 = Originallen+space*2-1;
        int p1 =Originallen-1;
        str.setLength(p2+1);//重新设置数组长度
        while (p1>=0&&p2>=p1){
            if(str.charAt(p1)==' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                str.setCharAt(p2--,str.charAt(p1));
            }
            -- p1;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        //和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
        StringBuffer str = new StringBuffer("We are happy");
        //replaceSpace(str);
        System.out.println(replaceSpace1(str));
        System.out.println(replaceSpace2(str));
    }
}

/**
 * Java 中 StringBuffer 和 String 是有一定的区别的，首先，String 是被 final 修饰的，他的长度是不可变的，
 * 就算调用 String 的 concat 方法，那也是把字符串拼接起来并重新创建一个对象，把拼接后的 String 的值赋给新创建的对象，
 * 而 StringBuffer 的长度是可变的，调用StringBuffer 的 append 方法，来改变 StringBuffer 的长度，并且，
 * 相比较于 StringBuffer，String 一旦发生长度变化，是非常耗费内存的！
 *
 String 长度大小不可变
 StringBuffer 和 StringBuilder 长度可变
 StringBuffer 线程安全 StringBuilder 线程不安全
 StringBuilder 速度快
 */