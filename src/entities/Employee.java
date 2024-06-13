package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.swing.text.StyledEditorKit;

public class Employee extends Person {
  public BigDecimal salary;
  public String function;
  static List<Employee> items = new ArrayList<>();

  public Employee(String name, String function, BigDecimal salary, LocalDate birthdayDate) {
    super(name, birthdayDate);
    this.function = function;
    this.salary = salary;
  }

  void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  void setFunction(String function) {
    this.function = function;
  }

  public BigDecimal getSalary() {
    return this.salary;
  }

  public String getFunction() {
    return this.function;
  }

  public static void getTotalSalary() {
    BigDecimal totalSalary = BigDecimal.ZERO;
    for (Employee employee : items) {

      totalSalary = totalSalary.add(employee.getSalary());
    }

    System.out.println(totalSalary + "\n");
  }

  public static void CreateEmployee(String name, String function, BigDecimal salary, LocalDate birthdayDate) {
    Employee newEmployee = new Employee(name, function, salary, birthdayDate);
    items.add(newEmployee);

  }

  public static List<Employee> getEmployees() {
    return items;
  }

  public int getAge() {
    return Period.between(this.birthdayDate, LocalDate.now()).getYears();
  }

  public static void getOlderEmployee() {

    Employee olderEmployee = items.stream()
        .min(Comparator.comparing(Employee::getBirthdayDate)).orElseThrow(NoSuchElementException::new);

    System.out.print("Nome:" + olderEmployee.getName() + ", Idade:" + olderEmployee.getAge() + "\n");
  }

  public static void getOrderedEmployees() {

    items.sort(Comparator.comparing(Employee::getName));

    for (Employee employee : items) {
      System.out.println(employee.getName());
    }
  }

  public static void getMinimumSalaryPerEmployee() {
    BigDecimal minimumSalary = new BigDecimal("1212.00");

    for (Employee employee : items) {
      BigDecimal miniumSalaryPerEmployee = employee.getSalary().divide(minimumSalary, 2, RoundingMode.HALF_UP);
      System.out.println("Nome:" + employee.getName() + ", Quantidade de salário minimo:" + miniumSalaryPerEmployee);
    }
  }

  public static void salaryIncrease() {
    for (Employee employee : items) {

      var result = employee.salary.multiply(new BigDecimal("0.10"));

      employee.salary = employee.salary.add(result);
    }
  }

  public static void removeJoao() {
    items.removeIf(employee -> employee.name.equals("João"));
  }

  @Override
  public String toString() {
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    return "Name: " + name + ", Function: " + function + ", Salary: "
        + NumberFormat.getCurrencyInstance().format(salary) + ", Birthday: "
        + birthdayDate.format(pattern);
  }
}
