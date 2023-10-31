/**
 * This class contains a driver with methods for handling user input and printing information related to the Classroom.
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver{

    /**
     * This method gets an integer input from the user using a Scanner object.
     * @param s The Scanner object used to get user input.
     * @return An integer input by the user.
     */
    public static int intInput(Scanner s){
        int input = -10;
        try{
            if (s.hasNextLine()){
                input = s.nextInt();
            }
        } catch (InputMismatchException e){
            System.out.println("Invalid input! Please enter an integer.");
            s.next();
        }
        return input;
    }

    /**
     * This method gets a String input from the user using a Scanner object.
     * @param s The Scanner object used to get user input.
     * @return A String input by the user.
     */
    public static String stringInput(Scanner s){
        String input = "";
        if (s.hasNextLine()){
            input = s.nextLine();
        }
        return input;
    }
    
    /**
     * This method gets a String input from the user using a Scanner object and ignores the first input received.
     * @param s The Scanner object used to get user input.
     * @return A String input by the user.
     */
    public static String stringInputTwo(Scanner s){
        String input = "";
        if (s.hasNextLine()){
            s.nextLine();
            input = s.nextLine();
        }
        return input;
    }

    /**
     * This method prints out a menu of options for the user to choose from.
     * @param menu An array of String objects representing the options to display in the menu.
     */
    public static void printMenu(String[] menu){
        int count = 0;
        for(String item: menu){
            System.out.println(count + ". " + item);
            count++;
        }
    }

    /**
     * This method prints out the list of students passed as an ArrayList of Student objects.
     * @param students An ArrayList of Student objects to be printed.
     */
    public static void printStudents(ArrayList<Student> students){
        int count = 0;
        for(Student item: students){
            System.out.println(count + ". " + item.toStringTwo());
            count++;
        }
    }

    /**
     * This method prints out the paired students in the Classroom object passed.
     * @param classRoom A Classroom object containing a list of Student objects and their pairs.
     */
    public static void printStudentPairs(Classroom classRoom){
        System.out.println("Paired Students: ");
        if (classRoom.classList.size() == 1){
            System.out.println(classRoom.classList.get(0).toStringTwo());
        } else{
            for(ArrayList<Student> pair: classRoom.studentPairs){
                String temp = pair.get(0).toStringTwo() + " & ";
                for (int i = 1; i < pair.size(); i++){
                    temp += pair.get(i).toStringTwo();
                    if(i == 1 && pair.size() == 3) temp += " & ";
                }
                System.out.println(temp);
            }
        }
    }

    /**
     * This method prints out a ranked list of students based on their grade.
     * The students are sorted in descending order based on their grade.
     * @param students An ArrayList of Student objects to be ranked
     */
    public static void printStudentsRank(ArrayList<Student> students){
        int count = 1;
        for(int i = students.size()-1; i >= 0; i--){
            System.out.println(count + ". " + students.get(i).toStringTwo());
            count++;
        }
    }

    /**
     * This is the main method of the Driver class.
     * It serves as the user interface for the Classroom program.
     * The user is presented with a menu of options to manipulate the list of students in the class.
     * The program continues to loop until the user selects the "Quit" option.
     * @param args The command line arguments passed to the program
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Classroom classRoom = new Classroom();
        System.out.println("Welcome to the Classroom user interface!");
        String[] menu = {"Reprint menu", "Add student", "Remove student", "Print class alphabetically", 
        "Print class ranked", "Print Paired Students", "Get top grades", "Get bottom grades", "Quit"};
        printMenu(menu);

        while (true) {
            System.out.println("To make a command enter it's associated number.");
            int command = intInput(s);
            switch (command) {
                case 0:
                    printMenu(menu);
                    break;
                case 1:
                    System.out.println("Input student first name: ");
                    String firstName = stringInputTwo(s);
                    System.out.println("Input student last name: ");
                    String lastName = stringInput(s);
                    System.out.println("Input student grade: ");
                    int grade = intInput(s);
                    Student newStudent = new Student(firstName, lastName, grade);
                    classRoom.addStudent(newStudent);
                    break;
                case 2:
                    printStudents(classRoom.classList);
                    do {
                        System.out.println("Enter the number corresponding to the student to remove or -1 to exit: ");
                        int toRemove = intInput(s);
                        if (toRemove == -1) {
                            break; 
                        } else if (toRemove >= 0 && toRemove < classRoom.classList.size()) {
                            classRoom.removeStudent(toRemove);
                            break; 
                        } else {
                            System.out.println("ERROR: out of bounds");
                        }
                    } while (true);
                    break;
                case 3:
                    System.out.println("Alphabetized Students: ");
                    printStudents(classRoom.infixClassListNames);
                    break;
                case 4:
                    System.out.println("Ranked Students: ");
                    printStudentsRank(classRoom.infixClassListGrades);
                    break;
                case 5:
                    printStudentPairs(classRoom);
                    break;
                case 6:
                    System.out.println("Enter a number for the amount students: ");
                    int amount = intInput(s);
                    if(amount > 0 && amount <= classRoom.classList.size()){
                        System.out.println("Top " + amount + " students:" );
                        printStudentsRank(classRoom.getTopStudentsW(amount));
                    } else {
                        System.out.println("ERROR: out of bounds");
                    }  
                    break;
                case 7:
                    System.out.println("Enter a number for the amount of students: ");
                    int amountTwo = intInput(s);
                    if(amountTwo > 0 && amountTwo <= classRoom.classList.size()){
                        System.out.println("Bottom " + amountTwo + " students:" );
                        printStudentsRank(classRoom.getBottomStudents(amountTwo));
                    } else {
                        System.out.println("ERROR: out of bounds");
                    }  
                    break;
                case 8:
                    System.out.println("Thank you for using Classroom!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}