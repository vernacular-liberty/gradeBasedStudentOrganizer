# Grade Based Student Organizer
## Guide to Implementation
I constructed a generic Binary Tree that takes in a generic Node which I used to sort students based
on different fields of data. The classroom class organizes and saves the student objects into different binary trees and lists constructed by traversing those trees. There are two tree classes that extend the generic binary tree. BinSearchTreeNames.java uses the full name of the student as the data field and constructs an alphabetized binary tree through a binary tree search algorithm. The other, 
BinSearchTreeGrades.java uses an arraylist of Students as the node's data field and constructs a binary search tree. Using the arraylist allows us to add multiple Students with the same grade to the tree.

## User Manuel
When you run the program the menu will appear. 
The program allows users to enter commands to manipulate the classroom.

Enter command, 0, to see the menu again.

Enter command, 1, to add a student. 
Follow the prompts to add the students information.
    The first name & last name must be a String.
        Ex: "Liberty" or "Lehr"
    The grade should be a positive integer.
        Ex: 86

Enter command, 2, to remove a student. 
The class list will print from 0 to the size of the class.
The Driver will ask the user to input the listing number of the student the user wants to remove. 
    Enter a negative number and the program will exit the remove function.
        Ex: -1
    Enter a number not corresponding to a student and the program will print an error.
        Ex: 6 in a list with four students
    Enter a number corresponding to a student and the program will remove that student.
        Ex: 4 in a list with seven students

Enter command, 3, to print the class alphabetically

Enter command, 4, to print the class by rank with the highest ranked at the top of the list.

Enter command, 5, to print the pairs of students.

Enter command, 6, to print the top grades.
    Enter the amount of students that you would like to see.
        Ex: 2 for the top two students in the class

Enter command, 7, to print the bottom grades.
    Enter the amount of students that you would like to see.
        Ex: 5 for the bottom five students in the class.

## To Do
- Add more fields to the student and manipulate them to serve the classrooms purpose.
