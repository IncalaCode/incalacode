package OOP;

class Manager extends Employee {
  double Bonus;
  String Speciality;

  public double getBonus() {
    return Bonus;
  }

  public void setBonus(double Bonus) {
    this.Bonus = Bonus;
  }

  public String getSpeciality() {
    return Speciality;
  }

  public void setSpeciality(String Speciality) {
    this.Speciality = Speciality;
  }

  public String toString() {
    return "Manager [id="
        + id
        + ", Name="
        + name.toUpperCase()
        + ", Age="
        + age
        + ", Department="
        + department
        + ", Salary="
        + salary
        + ", Bonus="
        + Bonus
        + ", Speciality="
        + Speciality
        + "]";
  }

  public Manager(double Bonus, String Speciality) {
    super(1001, "Abebe", 34, "cs", 20000);
    this.Bonus = Bonus;
    this.Speciality = Speciality;
  }
}

public class Employee {

  int id;
  String name;
  int age;
  String department;
  double salary;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  @Override
  public String toString() {
    return "Employee [id="
        + id
        + ", Name="
        + name.toUpperCase()
        + ", Age="
        + age
        + ", Department="
        + department
        + ", Salary="
        + salary
        + "]";
  }

  public Employee(
      int id, String name, int age, String department, double salary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.department = department;
    this.salary = salary;
  }
}
