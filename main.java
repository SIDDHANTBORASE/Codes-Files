import java.util.Scanner;

public class Armstrong {

    public static void main(String[] args){
		Scanner Sc = new Scanner(System.in);
        int num , ogNum, rem, result = 0;
		System.out.println("Enter the Number:");
		num = Sc.nextInt();
        ogNum = num;

        while (ogNum != 0)
        {
            rem = ogNum % 10;
            result += Math.pow(rem, 3);
            ogNum /= 10;
        }

        if(result == num)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
    }
}