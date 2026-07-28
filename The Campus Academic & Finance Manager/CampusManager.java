import java.io.*;
import java.util.*;

// 1. Abstraction and Polymorphism
abstract class Notification {
    abstract void notifyUser(String message);
}

class EmailNotification extends Notification {
    @Override
    void notifyUser(String message) {
        System.out.println("Sending Email Notification: " + message);
    }
}

// 2. Encapsulation & Secure State
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double x) throws IllegalArgumentException {
        if (x <= balance && x > 0) {
            this.balance -= x;
            System.out.println("Fee Payment Successful: $" + x);
        } else {
            // This error is thrown outward to whoever called the method
            throw new IllegalArgumentException("INVALID amount for fee payment.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// 3. Core Data Models
class Student {
    private String name;
    private int rollnumber;
    private double marks;
    private BankAccount account;

    public Student(String name, int rollnumber, double marks, double initialBalance) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.marks = marks;
        this.account = new BankAccount(initialBalance);
    }
    
    public String getName() { return name; }
    public int getRollnumber() { return rollnumber; }
    public BankAccount getAccount() { return account; }
}

// 4. Main System with File I/O and Exception Handling
public class CampusManager {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String logfile = "error_log.txt";
        
        // Initializing the system with default data
        Student s1 = new Student("Kalathiya Daksh Rajeshkumar", 202403063, 98.5, 5000.0);
        Notification email = new EmailNotification();
        
        System.out.println("--- B.Tech (MnC) Academic & Fee Portal ---");
        System.out.println("Student: " + s1.getName() + " | ID: " + s1.getRollnumber());
        System.out.println("Enrolled Track: Generative AI & Cloud");
        System.out.println("Current Balance: $" + s1.getAccount().getBalance());
        
        System.out.print("Enter fee amount to pay (as a string): ");
        String input = read.nextLine();
        read.close();
        
        try {
            double feeAmount = Double.parseDouble(input);
            
            if (feeAmount <= 0) {
                throw new ArithmeticException("Error: Fee cannot be zero or negative.");
            }
            
            // Process payment and notify user
            s1.getAccount().withdraw(feeAmount);
            email.notifyUser("Payment of $" + feeAmount + " processed for ID " + s1.getRollnumber());
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter valid decimal numbers.");
            logError(logfile, "NumberFormatException: '" + input + "'");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            logError(logfile, e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
            logError(logfile, "IllegalArgumentException: " + e.getMessage());
        }
    }
    
    // File I/O for error tracking
    private static void logError(String filepath, String msg) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
             writer.write("Error logged: " + msg + "\n");
        } catch (IOException e) {
             System.out.println("Failed to write log: " + e.getMessage());
        }
    }
}
