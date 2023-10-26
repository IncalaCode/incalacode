package OOP;

import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
public class EmployeeService {

  HashSet<Manager> mgrset = new HashSet<Manager>();

  Manager mgr1 = new Manager(5000, "Technician");

  HashSet<Employee> empset = new HashSet<Employee>();

  Employee emp1 = new Employee(101, "Bereket", 24, "IT", 25000);
  Employee emp2 = new Employee(102, "Biniyam", 26, "CO", 57000);
  Employee emp3 = new Employee(103, "Eyoas", 20, "Admin", 5000);
  Employee emp4 = new Employee(104, "Eyob", 27, "CO", 70000);

  Scanner sc = new Scanner(System.in);
  boolean found = false;
  int id;
  String name;
  int age;
  String department;
  double sal;

  public EmployeeService() {

    mgrset.add(mgr1);
    empset.add(emp1);
    empset.add(emp2);
    empset.add(emp3);
    empset.add(emp4);
  }

  public void viewAllEmps() {
    System.out.println("View\n1)Employees\n2)Managers");
    int choice = sc.nextInt();
    if (choice == 1){
      for (Employee emp : empset) {
      System.out.println(emp);
    }
    System.out.println("We have " + empset.size() + " Employees");

    } else if (choice == 2){
    for (Employee mgr : mgrset) {
      System.out.println(mgr);
    }
    System.out.println("We have " + mgrset.size() + " Managers");
   } else {
      System.out.println("Enter correct choice");
      viewAllEmps();
    }
  }

  public void viewEmp() {

    System.out.println("Search by:\n1. ID\n2. Name");
    int choice = sc.nextInt();
    if (choice == 1) SearchID();
    else if (choice == 2) SearchName();
    else {
      System.out.println("Enter correct choice");
      viewEmp();
    }
  }

  public void SearchID() {
    System.out.println("Enter id: ");
    id = sc.nextInt();
    for (Employee emp : empset) {
      if (emp.getId() == id) {
        System.out.println(emp);
        found = true;
      }
    }
    if (!found) {
      System.out.println("Employee with this ID is not present");
    }
  }

  public void SearchName() {
    System.out.println("Enter Name: ");
    name = sc.next();
    for (Employee emp : empset) {
      if (emp.getName().equals(name)) {
        System.out.println(emp);
        found = true;
      }
    }
    if (!found) {
      System.out.println("Employee with this Name is not present");
    }
  }

  public void updateEmployee() {
    System.out.println("Enter id: ");
    id = sc.nextInt();
    boolean found = false;
    for (Employee emp : empset) {
      if (emp.getId() == id) {

        System.out.println(
            "What do you want to Update?\n1. Name\n2. Age\n3. Department\n4. Salary\n5. All");
        int x;
        x = sc.nextInt();
        if (x == 1) {
          System.out.println("Enter Name");
          name = sc.next();
          emp.setName(name);
        } else if (x == 2) {
          System.out.println("Enter Age");
          age = sc.nextInt();
          emp.setAge(age);
        } else if (x == 3) {
          System.out.println("Enter Department");
          department = sc.next();
          emp.setDepartment(department);
        } else if (x == 4) {
          System.out.println("Enter Salary");
          sal = sc.nextDouble();
          emp.setSalary(sal);
        } else if (x == 5) {
          System.out.println("Enter Name");
          name = sc.next();
          emp.setName(name);
          System.out.println("Enter Age");
          age = sc.nextInt();
          emp.setAge(age);
          System.out.println("Enter Department");
          department = sc.next();
          emp.setDepartment(department);
          System.out.println("Enter Salary");
          sal = sc.nextDouble();
          emp.setSalary(sal);
        } else {
          System.out.println("Incorrect Choice");
          break;
        }
        System.out.println("Updated Details of Employee are: ");
        System.out.println(emp);
        found = true;
      }
    }
    if (!found) {
      System.out.println("Employee is not present");
    } else {
      System.out.println("Employee details updated successfully !!");
    }
  }

  public void deleteEmp() {
    int x;
    System.out.println("1. Delete one Employee\n2. Delete All Employee");
    x = sc.nextInt();
    if (x == 1) {
      System.out.println("Enter id");
      id = sc.nextInt();
      boolean found = false;
      Employee empdelete = null;
      for (Employee emp : empset) {
        if (emp.getId() == id) {
          empdelete = emp;
          found = true;
        }
      }
      if (!found) {
        System.out.println("Employee is not present");
      } else {
        empset.remove(empdelete);
        System.out.println("Employee deleted successfully!!");
      }
    } else if(x == 2){
      empset.clear();
      System.out.println("All Employees deleted successfully!!");
    }

  }

  public void addEmp() {

    boolean invalidInput;
    boolean found = false;
    int x;
    do {
      invalidInput = false;
      try {
        System.out.println("Enter ID:");
        id = sc.nextInt();
        for (Employee emp : empset) {
          if (emp.getId() == id) {
            found = true;
            break;
          }
        }
        if (!found) {
          System.out.println("Enter Name");
          name = sc.next();
          System.out.println("Enter Age");
          age = sc.nextInt();
          System.out.println("Enter Department");
          department = sc.next();
          System.out.println("Enter Salary");
          sal = sc.nextDouble();
          System.out.println("Employee Added\n1) Save\n2) Discard");
          x = sc.nextInt();

          if (x==1) {
            Employee emp = new Employee(id, name, age, department, sal);
            empset.add(emp);
            System.out.println(emp);
            System.out.println("Saved!");

            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;

            try {
              fw = new FileWriter("C:\\users\\user\\Desktop\\empfile2.txt", true);
              bw = new BufferedWriter(fw);
              pw = new PrintWriter(bw);

              pw.println(name + "\t" + age + "\t" + department + "\t" + sal);
              System.out.println("success");
              pw.flush();

            } catch (IOException f) {
            } finally {
              try {
                pw.close();
                bw.close();
                fw.close();
              } catch (IOException f) {
              }
            }


          } else if(x == 2){
            System.out.println("Record Discarded!");
          }
        }

      } catch (InputMismatchException e) {
        System.out.println("You have Entered an invalid data");
        System.out.println("Please Enter a valid data");
        invalidInput = true;
        sc.nextLine();
      }
    } while (invalidInput);
    if (found) 
     System.out.println("Employee with this ID already present");
  }
}
