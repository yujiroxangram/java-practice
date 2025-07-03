import java.util.Scanner;

public class GradeEvaluator {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your marks(0-100)");
        int marks = scan.nextInt();
        
        if (marks >= 90 && marks <= 100) {
            System.out.println("Grade: A");
        } else if (marks >= 80 && marks < 90) {
            System.out.println("Grade: B");
        } else if (marks >= 70 && marks < 80) {
            System.out.println("Grade: C");
        } else if (marks >= 60 && marks < 70) {
            System.out.println("Grade: D");
        } else if (marks >= 50 && marks < 60) {
            System.out.println("Grade: E");
        } else if (marks >= 0 && marks < 30) {
            System.out.println("Fail!");
        } else {
            System.out.println("Invalid credentials!");
        }
        scan.close();
    }
}
