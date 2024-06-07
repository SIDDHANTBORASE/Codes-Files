import java.util.*;
	public class OddorEven{
		public static void main(String[] Args){
			int num;
			Scanner Sc = new Scanner(System.in);
			System.out.println("Enter the Number: ");
			num = Sc.nextInt();
			if(num % 2 == 0){
				System.out.println("Number is Even.");
				
			}
			else {
				System.out.println("Number is Odd");
			}
		}
	}