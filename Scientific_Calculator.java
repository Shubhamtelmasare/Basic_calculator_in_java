import java.io.StringReader;
import java.util.*;
class calcy{
    public void add(double a ,double b){
        System.out.println("The addition of the given input is "+(a+b));
    }
    public void sub(double a ,double b){
        System.out.println("The subtraction of the given input is "+(a-b));
    }
    public void mul(double a ,double b){
        System.out.println("The multiplication of the given input is "+(a*b));
    }
    public void div(double a ,double b){
        try {
            System.out.println("The division of the given input is "+(a/b));
        }
        catch (ArithmeticException ar){
            System.out.println("You can not divide a number by 0\n" +
                    "Try another valid input");
        }
        catch (Exception e){
            System.out.println("You have entered invalid output\n" +
                    "Please enter correct output");
        }
    }
}
class operation extends calcy{
    Scanner s=new Scanner(System.in);
    public boolean op(int a,double b,double c){
        try {
            switch (a) {
                case 1:
                    add(b, c);
                    break;
                case 2:
                    sub(b, c);
                    break;
                case 3:
                    mul(b, c);
                    break;
                case 4:
                        System.out.println("Enter 1 for a/b" +
                                "\nEnter 2 for b/a");
                        int in = s.nextInt();
                        if (in == 1) {
                            div(b, c);
                        } else if (in==2) {
                            div(c,b);
                        }else
                            System.out.println("You have entered invalid input\n" +
                                    "Please try again");
                    break;
            }
        }
        catch (Exception my){
            System.out.println("You have entered invalid input" +
                    "\nExiting the program....");
            return false;
        }
        return true;
    }
}
class trig extends operation{
    public boolean tr(int a) {
        int p=0;
        try {
            switch (a) {
                case 5:
                    System.out.println("Enter 1 for sin(0)" +
                            "\nEnter 2 for cos(0)" +
                            "\nEnter 3 for tan(0)");
                   p = s.nextInt();
                    if (p==1||p==2||p==3){
                    System.out.println("Enter the value of 0");
                    double t = s.nextDouble();
                    switch (p) {
                        case 1:
                            System.out.println("sin(" + t + ")=" + Math.sin(t));
                            break;
                        case 2:
                            System.out.println("cos(" + t + ")=" + Math.cos(t));
                            break;
                        case 3:
                            System.out.println("tan(" + t + ")=" + Math.tan(t));
                            break;
                    }
                    }
                    else
                        System.out.println("You have entered invalid input" +
                                "\nPlease try again");
            }
        }
        catch (Exception e){
            System.out.println("You have entered invalid input" +
                    "\nExiting the program....");
            return false;
        }
        return true;
    }
}
public class Scientific_Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the calculator");
        Scanner input =new Scanner(System.in);
        operation ope = new operation();
        trig t=new trig();
        boolean tr=true;
        while (tr) {
            double b=0,c=0;
            int d = 0;
            try {
                System.out.println("Enter 1 for addition" +
                        "\nEnter 2 for subtraction" +
                        "\nEnter 3 for multiplication" +
                        "\nEnter 4 for division" +
                        "\nEnter 5 for trignometric operation");
                d = input.nextInt();
                if (d == 1 || d == 2 || d == 3 || d == 4) {
                    System.out.println("Enter the value of first input\n" +
                            "It will be store as \'a\'");
                    b = input.nextDouble();

                    System.out.println("Enter the value of second input\n" +
                            "It will be store as \'b\'");
                    c = input.nextDouble();
                    boolean b2=ope.op(d, b, c);
                    if(b2==true){

                    } else if (b2==false) {
                        break;
                    }
                }
                else if (d==5) {
                    //t.tr(d);
                    boolean b1=t.tr(d);
                    if(b1==true){

                    } else if (b1==false) {
                        break;
                    }
                }
                else {
                    System.out.println("You have entered invalid input\n" +
                            "Please try again");
                }
                System.out.println("\nEnter 1 to perform another operation\n" +
                        "Enter 2 to exist the program");
                int x = input.nextInt();
                if (x == 1) {
                    tr = true;
                }
                else if (x == 2) {
                    tr = false;
                    System.out.println("Exiting the program....");
                }
                else {
                    System.out.println("You have entered invalid input" +
                            "\nExiting the program....");
                    tr = false;
                }
            }
            catch (Exception e) {
                System.out.println("You have entered invalid input\n" +
                        "Exiting the program....");
                break;
            }
        }
        System.out.println("\nThanks for using the calculator");
    }
}