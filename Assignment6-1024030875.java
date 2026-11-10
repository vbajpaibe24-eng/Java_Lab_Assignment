package assignment6;

import java.io.*;

class Q1 {
    public static void main(String[] args) {

        // Writing student details
        try (FileWriter fw = new FileWriter("students.txt")) {
            fw.write("Student ID: 101\n");
            fw.write("Name: Arshita\n");
            fw.write("Course: Computer Engineering\n");
            fw.write("Marks: 85\n");

            System.out.println("Student details written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Reading student details
        try (FileReader fr = new FileReader("students.txt")) {
            int ch;

            System.out.println("\nStudent Details:");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Copying binary file
        try (
                FileInputStream fis = new FileInputStream("input.jpg");
                FileOutputStream fos = new FileOutputStream("copy.jpg")) {
            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("\nBinary file copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}

class Employee implements Serializable {
    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class Q3 {
    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Rahul", "IT", 50000);
        Employee e2 = new Employee(102, "Priya", "HR", 45000);
        Employee e3 = new Employee(103, "Aman", "Finance", 55000);

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("employee.dat"))) {

            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(e3);

            System.out.println("Employee records saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employee.dat"))) {

            System.out.println("\nEmployee Records:");

            Employee emp;

            for (int i = 0; i < 3; i++) {
                emp = (Employee) in.readObject();
                emp.display();
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
