import java.util.*;

class Operation{
    int a;
    int b;
    Scanner Sc = new Scanner(System.in);
    void getdata(){
        System.out.println("Enter the Value of A and B: ");
        a = Sc.nextInt();
        b = Sc.nextInt();
    }
    int add(){
        int sum = a+b;
        return sum;
    }
    int Sub(){
        int diff = a-b;
        return diff;
    }
    int Mul(){
        int multi = a*b;
        return multi;
    }
    float Div(){
        float ans = a/b;
        return ans;
    }
   void Check(){
        if (a>b){
            System.out.println("A is a Greater");
        }
        else
        System.out.println("B is Greatest");
    }
    public static void main(String[] args) {
        Operation O1 = new Operation();
        O1.getdata();
        System.out.println("Which Operation you want to perform: ");
        System.out.println("1)Addition 2) Subtraction 3)Multiply 4)Divide 5)Check Greater: ");
        int choice;
        System.out.println("Enter your Choice: ");
        choice = O1.Sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Addition is "+O1.add());
                break;
            case 2:
                System.out.print("Subtraction is "+O1.Sub());
                break;
            case 3:
                System.out.print("Multiplication  is "+O1.Mul());
                break;
            case 4:
                System.out.print("Division  is "+O1.Div());
            break;
            case 5:
            System.out.println("After checking result is ");
            O1.Check();
        break;
            default:
                break;
        }
    }
}