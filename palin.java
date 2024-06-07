import java.util.*;
public class palin {
    public static void main(String[] args) {
        String og,rev="";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String: ");
        og = in.nextLine();
        int limit = og.length();

        for(int i= limit-1; i>=0; i--)
        rev = rev + og.charAt(i);

    if(og.equals(rev))
    System.out.println("The String is Palindrome");
    else 
    System.out.println("String is Not Palindrome");

    }
}
