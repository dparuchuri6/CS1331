import java.util.Scanner;

public class HW8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt();

        try {
            System.out.println(divide(number1,number2));
        } catch (DIVIDE0ERROR ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int divide(int num1, int num2) throws DIVIDE0ERROR {
        if (num2 == 0) {
            throw new DIVIDE0ERROR("CANNOT DIVIDE BY 0");
        } else {
            return num1/num2;
        }
    }
}
