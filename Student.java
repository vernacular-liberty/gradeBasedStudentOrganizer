/**
 * A class that represents a student with a full name and grade.
 */
public class Student {
    String fullName;
    int grade;

    /**
     * Constructs a Student object with the given first name, last name, and grade.
     * The full name is constructed as last name followed by a comma and a space followed by the first name.
     * @param firstName the first name of the student.
     * @param lastName the last name of the student.
     * @param grade the grade of the student.
     */
    Student(String firstName, String lastName, int grade){
        String fullName = lastName + ", " + firstName;
        this.fullName = fullName;
        this.grade = grade;
    }

    /**
     * Constructs a default Student object with null name and -1 grade.
     */
    Student(){
        this.fullName = null;
        this.grade = -1;
    }
    
    /**
     * Returns the grade of the student.
     *
     * @return the grade of the student.
     */
    public int getGrade(){
        return this.grade;
    }

    /**
     * Returns the full name of the student.
     *
     * @return the full name of the student.
     */
    public String getFullName(){
        return this.fullName;
    }

    /**
     * Returns the Student object.
     *
     * @return the Student object.
     */
    public Student getStudent(){
        return this;
    }

    /**
     * Sets the grade of the student to the given data.
     * @param data the grade to be set.
     */
    public void setGrade(int data){
        this.grade = data;
    }

    /**
     * Returns a string representation of the Student object with square brackets.
     * @return a string representation of the Student object.
     */
    public String toString(){
        return "[" + this.fullName + "(" + this.grade + ")]";
    }

    /**
     * Returns a string representation of the Student object without square brackets.
     * @return a string representation of the Student object.
     */
    public String toStringTwo(){
        return this.fullName + "(" + this.grade + ")";
    }
}
