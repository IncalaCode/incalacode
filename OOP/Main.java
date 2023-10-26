package OOP;

import java.util.Scanner;

public class Main {


  EmployeeService service = new EmployeeService();
  static boolean ordering = true;

  public static void menu() {

    System.out.println(

        "****************Welcome To Employee Managment System *********** "
                +"\n"
                +  "\n***************************************"
                + "\n*        1. Add Employee               *"
                + "\n*        2. View Employee              *"
                + "\n*        3. Update Employee            *"
                + "\n*        4. Delete Employee            *"
                + "\n*        5. View All Employee          *"
                + "\n*        6. Manage Account             *"
                + "\n*        7. Exit/n                     *"
                + "\n***************************************"

            );
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    EmployeeService service = new EmployeeService();
    Login Log = new Login();
    Log.insertData();

    do {
      menu();

      System.out.println("Enter your Choice");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Add Employee");
          service.addEmp();
          break;

        case 2:
          System.out.println("Search Employee");
          service.viewEmp();
          break;
        case 3:
          System.out.println("Update Employee");
          service.updateEmployee();
          break;
        case 4:
          System.out.println("Delete Employee");
          service.deleteEmp();
          break;
        case 5:
          System.out.println("View All Employee");
          service.viewAllEmps();
          break;
        case 6:
          System.out.println("Manage Account");
          Log.modifyUser();
          Log.insertData();
          break;
        case 7:
          System.exit(0);

        default:
          System.out.println("Please enter valid choice");
          break;

      }
    } while (ordering);
  }
}
