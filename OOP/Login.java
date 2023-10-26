package OOP;

import java.util.Scanner;

class Login {
  Scanner sc = new Scanner(System.in);
  String ur, pass;
  String ur1 = "admin";
  String pass1 = "admin";
  int count = 3;

  public void insertData() {
    System.out.println("Enter Username:");
    ur = sc.next();
    System.out.println("Enter Password: ");
    pass = sc.next();
    validation();
  }

  public void validation() {
    if (ur.equals(ur1)) {
      if (pass.equals(pass1)) {
        System.out.println("Successful Login! Welcome");
      } else {
        System.out.println("Wrong Password Please try Again");
        count--;
        System.out.println("You have only " + count + " chance");
        if (count == 0) System.exit(0);
        insertData();
      }
    } else {
      System.out.println("Wrong Username Please try Again");
      count--;
      System.out.println("You have only " + count + " chance");
      if (count == 0) System.exit(0);
      insertData();
    }
  }

  public void modifyUser() {
    String ur2, pass2;
    System.out.println("1. Change Username\n2. Change Password");
    int choice = sc.nextInt();
    if (choice == 1) {
      System.out.println("Enter Old Username:");
      ur2 = sc.next();
      if (ur2.equals(ur1)) {
        System.out.println("Enter New Username:");
        ur1 = sc.next();
        System.out.println("\n\t\tUsername Successfully changed");
       System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\tLogin Now!\n");
      } else {
        System.out.println("Incorrect Username");
      }
    } else if (choice == 2) {
      System.out.println("Enter Old Password:");
      pass2 = sc.next();
      if (pass2.equals(pass1)) {
        System.out.println("Enter New Password:");
        pass1 = sc.next();
        System.out.println("\n\t\tPassword Successfully changed");
       System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\tLogin Now!\n");
      } else {
        System.out.println("Incorrect Password");
      }
    } else {
      System.out.println("Invalid choice");
      modifyUser();
    }
  }
}
