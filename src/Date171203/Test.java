package Date171203;

public class Test {
    public static void main(String[] args) {
        int i=0;
        System.out.println(i++);
        int j =0;
        for(int k = 0; k<100; k++){
//            j=j++;
            int temp = j;
            temp = j+1;
            j=temp;
        }
        System.out.println(j);
    }
}

