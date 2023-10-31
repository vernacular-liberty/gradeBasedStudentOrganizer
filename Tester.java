/**
 * The Tester class contains methods to test the functionality of the Classroom and BinSearchTreeGrades classes.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Tester {

    /**
     * The passTest method prints whether a unit test has passed or failed.
     * @param isFunctional a boolean indicating whether the unit test passed (true) or failed (false)
     */
    public static void passTest(boolean isFunctional){
        if (isFunctional){
            System.out.println("Passed unit test ✅ \n");
        } else {
            System.out.println("Did not pass unit test ❌ \n");
        }
    }
    
    /**
     * The testPairStudents method tests the pairStudents method in the Classroom class.
     * It creates a classroom of students with varying grades and prints the resulting pairs of students.
     */
    public static void testPairStudents(){
        System.out.println("1. Test: pairStudents for Classroom.java");
        ArrayList<Student> sArr = new ArrayList<>(
            Arrays.asList(
            new Student("George", "Gray", 100),
            new Student("John", "Doe", 93),
            new Student("Liberty", "Lehr", 100),
            new Student("Alana", "Mitchel", 85),
            new Student("Reno", "Hayward", 79),
            new Student("Mary", "Franklin", 12)));
        Classroom classRoom = new Classroom(sArr);
        System.out.println("Input: " + classRoom.infixClassListGrades.toString());
        System.out.println("Output: " +  classRoom.studentPairs.toString());
        Driver.printStudentPairs(classRoom);
        passTest(true);
    }

    /**
     * The testRemoveStudent method tests the removeStudent method in the Classroom class.
     * It creates a classroom of students and removes a student from the class, checking that the class list and binary search tree are updated correctly.
     */
    public static void testRemoveStudent(){
        System.out.println("2. Test: removeStudent for Classroom.java");
        ArrayList<Student> sArr = new ArrayList<>(
            Arrays.asList(new Student("Liberty", "Lehr", 87), 
            new Student("Lily", "Garner", 100), 
            new Student("Lena", "Miller", 100), 
            new Student("Annika", "Jawanda", 100),
            new Student("Ingrid", "Lackey", 98)));
        Classroom classRoom = new Classroom(sArr);
        int get = 1;
        System.out.println("Input: " + sArr.toString() + " & " + classRoom.classList.get(get));
        classRoom.removeStudent(get);
        System.out.println("Output classList: " + classRoom.classList.toString());
        System.out.println("Output binTreeGrades: " + classRoom.binTreeGrades.toString());
        passTest(true);
    }

    public static void main(String[] args){
        System.out.println("------------TESTERS: Classroom.java & BinSearchTreeGrades.java----------------------");
        testPairStudents();
        testRemoveStudent();
    }
}
