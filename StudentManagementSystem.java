import java.util.ArrayList;
import java.util.Scanner;

class Students {
    int rollNo;
    String name;
    float marks;

    public Students(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks);
    }
}


public class StudentManagementSystem {
    static ArrayList<Students> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void addStudent() {
        System.out.println("Enter roll no.: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter marks: ");
        float marks = scanner.nextFloat();

        students.add(new Students(rollNo, name, marks));
        System.out.println("Student added");
    }

    public static void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("<<< Student Record >>>");
        for (Students s : students) {
            s.display();
        }
    }

    public static void searchStudent() {
        System.out.println("Enter rollNo: ");
        int rollNo = scanner.nextInt();

        for(Students s : students) {
            if(s.rollNo == rollNo) {
                System.out.println("Student found");
                s.display();
                return;
            }
        }
        System.out.println("Students not found");
    }

    public static void deleteStudent() {
        System.out.println("Enter Roll no to delete: ");
        int rollNo = scanner.nextInt();

        for(Students s: students) {
            if(s.rollNo == rollNo) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found");
    }


    public static void main(String[] args) {


        //displaying menu option
        while(true) {
            System.out.println("<<< Students Management System >>>");
            System.out.println("1. Add Students");
            System.out.println("2. Show all students");
            System.out.println("3. Search students");
            System.out.println("4. Delete students");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addStudent(); break;
                case 2:
                    displayStudent(); break;
                case 3:
                    searchStudent(); break;
                case 4:
                    deleteStudent(); break;
                case 5:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

}
