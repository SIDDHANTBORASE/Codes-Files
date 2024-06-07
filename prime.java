import java.util.*;
class prime {
    public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        int num;
        System.out.println("Enter the Number to Check: ");
        num =Sc.nextInt();
        if (num <= 1) {
            System.out.println("Number is Not a prime");
            return;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println("Number is not Prime");
                return;
            }
        }
    System.out.println("Prime Number");
    }
    
}
