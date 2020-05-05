//I worked on the homework assignment alone, using only course materials.

import java.util.Random;

public class DataLeakSimulator {

    public static void main(String[] args) {

        Random rand = new Random();
        int randNumOne = rand.nextInt(26);

        int num = (int) (Math.sqrt(randNumOne));
        int randNumTwo = (int) (Math.random() * ((10 - (-10)) + 1) + (-10));

        //System.out.println("--> java DataLeakSimulator");
        System.out.println(leakData(num) + " data was leaked");
        System.out.println(leakData(randNumTwo) + " data was leaked");

    }

    public static SchoolDataType leakData(int num) {
        int choice  = (Math.abs(num)) % 4;
        SchoolDataType data = SchoolDataType.STUDENTS;
        switch (choice) {
        case 0: data = SchoolDataType.STUDENTS;
                break;
        case 1: data = SchoolDataType.CLASSES;
                break;
        case 2: data = SchoolDataType.HOUSING;
                break;
        case 3: data = SchoolDataType.DINING;
                break;
        default: data = SchoolDataType.STUDENTS;
        }
        return data;
    }
}
