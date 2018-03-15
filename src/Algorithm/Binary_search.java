package Algorithm;

public class Binary_search {
    public static int search(int key, int[] array){
        int l = 0, h = array.length-1;
        while (l<h){
            int middle = l + (h-1)/2;//此处注意写middle的方法
            if(key == array[middle])
                return middle;
            if(key<array[middle])
                h = middle -1;
            else
                l = middle +1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array =  {3,45,1,9,2,7};
        System.out.println(search(2,array));
    }
}
