// Validation subsystems
class PaymentStatus {
    public static boolean checkPaymentStatus(String studentNumber) {
        // Perform payment status validation logic here
        // Return true if paid, false otherwise
        return false;
    }

    public static double getBalance(String studentNumber) {
        // Get the balance for the student number
        // Return the balance amount
        return 0;
    }
}

class ViolationChecking {
    public static boolean withViolation(String studentNumber) {
        // Perform violation checking logic here
        // Return true if there is a violation, false otherwise
        return false;
    }
}

class FailingCoursesDetection {
    public static boolean talkToDean(String studentNumber) {
        // Perform failing courses detection logic here
        // Return true if the student needs to talk to the dean, false otherwise
        return false;
    }
}

// Facade pattern
class EnrollmentAssist {
    public static void enrollStudent(String studentNumber, String studentName, String program) {
        boolean paymentStatus = PaymentStatus.checkPaymentStatus(studentNumber);
        if (!paymentStatus) {
            double balance = PaymentStatus.getBalance(studentNumber);
            System.out.println("Payment pending! Balance: $" + balance);
            return;
        }

        boolean hasViolation = ViolationChecking.withViolation(studentNumber);
        if (hasViolation) {
            System.out.println("Proceed to the Discipline office.");
            return;
        }

        boolean needsToTalkToDean = FailingCoursesDetection.talkToDean(studentNumber);
        if (needsToTalkToDean) {
            System.out.println("Proceed to the Dean's office.");
            return;
        }

        System.out.println("Enrollment successful for student: " + studentName);
        // Perform additional enrollment logic here
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Example usage
        String studentNumber = "123456";
        String studentName = "John Doe";
        String program = "BSCS";

        EnrollmentAssist.enrollStudent(studentNumber, studentName, program);
    }
}
