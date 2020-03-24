//I worked on the homework assignment alone,
//using only course materials

public class Tax {

  public static void main(String[] args) {

      String name = "Chad";
      int salary = 118000;
      double taxRate = 0.3;

      double income = salary - salary*taxRate;

      System.out.print(name + " is making $");
      System.out.println(income + " dollars after tax!");
  }
}
