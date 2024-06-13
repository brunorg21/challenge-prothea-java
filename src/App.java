import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Employee.CreateEmployee("Maria", "Operador", new BigDecimal("2000.9"), LocalDate.of(2000, 10, 18));
        Employee.CreateEmployee("João", "Operador", new BigDecimal("2284.38"), LocalDate.of(1990, 5, 12));
        Employee.CreateEmployee("Caio", "Coordenador", new BigDecimal("9836.14"), LocalDate.of(1961, 5, 2));
        Employee.CreateEmployee("Miguel", "Diretor", new BigDecimal("19119.88"), LocalDate.of(1988, 10, 14));
        Employee.CreateEmployee("Alice", "Recepcionista", new BigDecimal("2234.68"), LocalDate.of(1995, 1, 05));
        Employee.CreateEmployee("Heitor", "Operador", new BigDecimal("1582.72"), LocalDate.of(1999, 11, 19));
        Employee.CreateEmployee("Arthur", "Operador", new BigDecimal("4071.84"), LocalDate.of(1993, 3, 31));
        Employee.CreateEmployee("Laura", "Gerente", new BigDecimal("3017.45"), LocalDate.of(1994, 7, 8));
        Employee.CreateEmployee("Heloisa", "Eletricista", new BigDecimal("1606.85"), LocalDate.of(2003, 5, 24));
        Employee.CreateEmployee("Helena", "Gerente", new BigDecimal("2799.93"), LocalDate.of(1996, 9, 2));

        Employee.removeJoao();
        System.out.printf("Funcionários\n");
        for (Employee employee : Employee.getEmployees()) {

            System.out.println(employee);
        }

        Employee.salaryIncrease();

        System.out.printf("==================\n");
        System.out.printf("Funcionários atualizados\n");
        for (Employee employee : Employee.getEmployees()) {

            System.out.println(employee);
        }

        System.out.printf("==================\n");
        System.out.printf("Funcionários stream\n");
        Map<String, List<Employee>> employeesByFunction = Employee.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getFunction));

        for (String function : employeesByFunction.keySet()) {
            System.out.printf(function + "\n");
            System.out.printf("==================\n");
            for (Employee f : employeesByFunction.get(function)) {
                System.out.println(f);
            }
        }
        System.out.printf("==================\n");
        System.out.printf("Funcionários que fazem aniversário no mês 10 e 12\n");
        for (Employee employee : Employee.getEmployees()) {
            int monthBirthday = employee.birthdayDate.getMonthValue();
            if (monthBirthday == 10 || monthBirthday == 12) {
                System.out.println(employee);
            }
        }

        System.out.printf("==================\n");
        System.out.printf("Funcionário mais velho\n");
        Employee.getOlderEmployee();

        System.out.printf("==================\n");
        System.out.printf("Funcionários em ordem alfabetica\n");
        Employee.getOrderedEmployees();

        System.out.printf("==================\n");
        System.out.printf("Total salários\n");

        Employee.getTotalSalary();

        System.out.printf("==================\n");
        System.out.printf("Salário Minimo por Funcionário\n");
        Employee.getMinimumSalaryPerEmployee();
    }
}
