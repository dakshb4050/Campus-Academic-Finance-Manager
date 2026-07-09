# Campus Academic & Finance Manager 🎓💳

A secure, object-oriented financial management system built in Java to process student tuition transactions, manage academic profiles, and track system anomalies. This project demonstrates core software engineering principles, including abstraction, robust exception handling, and persistent data logging.

## 🚀 Key Features

*   **Object-Oriented Architecture:** Utilizes Encapsulation to secure sensitive financial data within the `BankAccount` and `Student` models.
*   **Extensible Notification System:** Implements Abstraction and Runtime Polymorphism via a generic `Notification` base class, allowing for seamless scaling to Email, SMS, or Push alerts.
*   **Resilient Exception Handling:** Employs custom and built-in Java exceptions (`IllegalArgumentException`, `ArithmeticException`, `NumberFormatException`) to intercept invalid business logic and malformed inputs before they disrupt the system.
*   **Persistent Audit Logging:** Uses Java File I/O (`BufferedWriter`, `FileWriter`) to automatically write failed transaction attempts and system errors to a local `error_log.txt` file for auditing.

## 🛠️ Tech Stack

*   **Language:** Java (JDK 8+)
*   **Core Concepts:** OOP, File I/O, Error Handling, Data Validation

## 🏗️ System Architecture

*   `CampusManager.java`: The main driver class that handles the console interface and high-level transaction routing.
*   `Student.java`: Models the student entity, storing academic details and acting as a composite container for financial data.
*   `BankAccount.java`: An encapsulated domain model strictly responsible for validating and executing balance deductions.
*   `Notification.java` & `EmailNotification.java`: An abstract blueprint and concrete implementation for handling automated user alerts upon successful transactions.

## 💻 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/dakshb4050/Campus-Academic-Finance-Manager.git](https://github.com/dakshb4050/Campus-Academic-Finance-Manager.git)
   cd Campus-Academic-Finance-Manager
