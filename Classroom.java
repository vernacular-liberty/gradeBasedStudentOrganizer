/**
 * The Classroom class represents a classroom, which contains a list of students and a binary search tree for sorting the students by their grades and names. It provides methods for adding and removing students, getting the top and bottom students, and pairing students.
 */
import java.util.ArrayList;

public class Classroom {
    ArrayList<Student> classList;
    BinSearchTreeGrades binTreeGrades;
    ArrayList<Student> infixClassListGrades;
    BinSearchTreeNames binTreeNames;
    ArrayList<Student> infixClassListNames;
    ArrayList<ArrayList<Student>> studentPairs;

    /**
     * Creates a new Classroom object with an empty list of students.
     */
    Classroom(){
        ArrayList<Student> classList = new ArrayList<>();
        this.classList = classList;
        this.binTreeGrades = createBinSearchTreeGrades(classList);
        this.infixClassListGrades = this.binTreeGrades.infixTraversalWTwo();
        this.binTreeNames = createBinSearchTreeNames(classList);
        this.infixClassListNames = this.binTreeNames.infixTraversalW();
        this.studentPairs = pairStudentsW();
    }

    /**
     * Creates a new Classroom object with a single student.
     * @param s the student to add to the classroom.
     */
    Classroom(Student s){
        ArrayList<Student> classList = new ArrayList<>();
        classList.add(s);
        this.classList = classList;
        this.binTreeGrades = createBinSearchTreeGrades(classList);
        this.infixClassListGrades = this.binTreeGrades.infixTraversalWTwo();
        this.binTreeNames = createBinSearchTreeNames(classList);
        this.infixClassListNames = this.binTreeNames.infixTraversalW();
        this.studentPairs = pairStudentsW();
    }

    /**
     * Creates a new Classroom object with a list of students.
     * @param sArr the list of students to add to the classroom.
     */
    Classroom(ArrayList<Student> sArr){
        ArrayList<Student> classList = sArr;
        this.classList = classList;
        this.binTreeGrades = createBinSearchTreeGrades(classList);
        this.infixClassListGrades = this.binTreeGrades.infixTraversalWTwo();
        this.binTreeNames = createBinSearchTreeNames(classList);
        this.infixClassListNames = this.binTreeNames.infixTraversalW();
        this.studentPairs = pairStudentsW();
    }

    /**
     * Adds a student to the classroom and updates the binary search trees and infix lists.
     * @param s the student to add to the classroom.
     */
    public void addStudent(Student s){
        this.classList.add(s);
        this.binTreeGrades.insertSortRecW(s);
        this.binTreeNames.alphabetizeRecW(s);
        this.infixClassListGrades = this.binTreeGrades.infixTraversalWTwo();
        this.infixClassListNames = this.binTreeNames.infixTraversalW();
        this.studentPairs = pairStudentsW();
    } 

    /**
     * Removes a student from the classroom and updates the binary search trees and infix lists.
     * @param s the index of the student to remove from the classroom.
     */
    public void removeStudent(int s){
        this.classList.remove(s);
        this.binTreeGrades =  createBinSearchTreeGrades(this.classList);
        this.infixClassListGrades = this.binTreeGrades.infixTraversalWTwo();
        this.binTreeNames = createBinSearchTreeNames(this.classList);
        this.infixClassListNames = this.binTreeNames.infixTraversalW();
        this.studentPairs = pairStudentsW();
    }

    /**
     * Creates a binary search tree of students sorted by their grades.
     * @param a the array list of students to be sorted
     * @return a binary search tree of students sorted by their grades
     */
    public BinSearchTreeGrades createBinSearchTreeGrades(ArrayList<Student> a){
        BinSearchTreeGrades output = new BinSearchTreeGrades();
        for (int i = 0; i < a.size(); i++){
            output.insertSortRecW(a.get(i));
        }
        return output;
    }

    /**
     * Creates a binary search tree of students sorted by their names in alphabetical order.
     * @param a the array list of students to be sorted
     * @return a binary search tree of students sorted by their names in alphabetical order
     */
    public BinSearchTreeNames createBinSearchTreeNames(ArrayList<Student> a){
        BinSearchTreeNames output = new BinSearchTreeNames();
        for (int i = 0; i < a.size(); i++){
            output.alphabetizeRecW(a.get(i));
        }
        return output;
    }

    /**
     * Returns the student with the highest grade in the class.
     * @return the student with the highest grade in the class
     */
    public Student getTopStudent(){
        return this.infixClassListGrades.get(this.infixClassListGrades.size()-1);
    }

    /**
     * Returns an array list of the top "count" students in the class, sorted by grade.
     * @param count the number of top students to return
     * @return an array list of the top "count" students in the class, sorted by grade
     */
    public ArrayList<Student> getTopStudentsW(int count){
        ArrayList<Student> output = new ArrayList<>();
        if (count <= this.classList.size()){
            return getTopStudents(count, output);
        }
        return output;
    }

    /**
     * Helper method for getTopStudentsW() that returns an array list of the top "count" students in the class, sorted by grade.
     * @param count the number of top students to return
     * @param output the array list to which the top students will be added
     * @return an array list of the top "count" students in the class, sorted by grade
     */
    public ArrayList<Student> getTopStudents(int count, ArrayList<Student> output){
        if(count == 0){
            return output;
        }
        output.add(this.infixClassListGrades.get(this.infixClassListGrades.size()-count));
        count--;
        return getTopStudents(count, output);
    }

    /**
     * Returns an array list of the bottom "count" students in the class, sorted by grade.
     * @param count the number of bottom students to return
     * @return an array list of the bottom "count" students in the class, sorted by grade
     */
    public ArrayList<Student> getBottomStudents(int count){
        ArrayList<Student> output = new ArrayList<>();
        for (int i = 0; i < count; i++){
            output.add(this.infixClassListGrades.get(i));
        }
        return output;
    }
    
    /**
     * Recursive function to make an array list of array lists of students, where each array list contains two students who will be paired up for a project.
     * If there are an odd number of students, the last array list will contain three students.
     * @return an array list of array lists of students, where each student is paired to make academically equitable pairs.
     */
    public static ArrayList<ArrayList<Student>> pairStudents(ArrayList<ArrayList<Student>> pairs, int studentOne, int studentTwo, ArrayList<Student> sortedArr) {
        if (studentTwo - studentOne <= 0) {
            return pairs;
        } else {
            Student first = sortedArr.get(studentOne);
            Student last = sortedArr.get(studentTwo);
            ArrayList<Student> pair = new ArrayList<>(2);
            pair.add(first);
            pair.add(last);
            pairs.add(pair);
            studentOne++;
            studentTwo--;
            return pairStudents(pairs, studentOne, studentTwo, sortedArr);
        }
    }

    /**
     * Wrapper for pairStudents.
     * Returns an array list of array lists of students, where each array list contains two students who will be paired up for a project.
     * If there are an odd number of students, the last array list will contain three students.
     * @return an array list of array lists of students, where each student is paired to make academically equitable pairs.
     */
    public ArrayList<ArrayList<Student>> pairStudentsW(){
        ArrayList<ArrayList<Student>> output = new ArrayList<>();
        ArrayList<Student> firstPair = new ArrayList<>();
        if (this.infixClassListGrades.size() == 1) {
            firstPair.add(this.infixClassListGrades.get(0));
            output.add(firstPair);
            return output;
        } 
        if (this.infixClassListGrades.size() % 2 != 0){
            output = pairStudents(output, 0, this.infixClassListGrades.size()-1, this.infixClassListGrades);
            int mid = this.infixClassListGrades.size() / 2;
            output.get(output.size()-1).add(this.infixClassListGrades.get(mid));
            return output;
        } 
        return pairStudents(output, 0, this.infixClassListGrades.size()-1, this.infixClassListGrades);
    }
}
