import java.util.*;
public class fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int str=0, n1= 1,n2 = 0,limit;
        System.out.println("Enter the limit: ");
        limit = in.nextInt();
        System.out.printf(str + " " + n1 + " ");
        for(int i = 2; i< limit; i++){
            n2 = str + n1;
            System.out.printf(n2+" ");
            str = n1;
            n1 = n2;
        }
    }
    
}
