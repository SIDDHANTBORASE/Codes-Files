import java.util.*;
	public class Largest{
		public static void main(String[] Args){
			int num1, num2, num3 , largest = 0;
			Scanner Sc = new Scanner(System.in);
			System.out.println("Enter the Number 1st: ");
			num1 = Sc.nextInt();
			System.out.println("Enter the Number 2nd: ");
			num2 = Sc.nextInt();
			System.out.println("Enter the Numbers 3rd: ");
			num3 = Sc.nextInt();
			if(num1 > num2 && (num1 > num3)){
				System.out.println("largest Number is: "+num1);
				
			}
			else if (num2>num3 && num2 > num1 ){
				System.out.println("largest Number is : " + num2);
			}				
			else {
				System.out.println("largest Number is : " + num3);
			}
		}
	}
	
	
	