package Hash_Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Given a string, sort it in decreasing order based on the frequency of characters.
 **/
public class Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>[] frequencyBucket = new List[s.length()+1];
        for (char c:map.keySet()){
            int f = map.get(c);//c这个key 的value
            if(frequencyBucket[f]==null){
                frequencyBucket[f]=new ArrayList<>();//new
            }
            frequencyBucket[f].add(c);//
        }
        StringBuilder str = new StringBuilder();
        //StringBuilder 字符串变量 非线程安全。
        for(int i =frequencyBucket.length-1;i>=0;i--){
            if(frequencyBucket[i]==null){
                continue;
            }
            for(char c:frequencyBucket[i]){
                for(int j=0;j<i;j++)//i记录的是字母出现的个数
                    str.append(c);
            }
        }
        return str.toString();
    }
}
/**Tip: Java 遍历字符串方法
 * http://blog.51cto.com/firrty/1729914
 **/
/*
 String 类型和 StringBuffer 类型的主要性能区别其实在于 String 是不可变的对象, 因此在每次对 String 类型进行改变的时候
 其实都等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String。
 StringBuffer 每次对对象本身进行操作，而不是生成新的对象，再改变对象引用。
 */