package com.wipro.practice;
/*
 List<Employee> employees = Arrays.asList(
    new Employee(101, "Ravi", "HR", 50000),
    new Employee(102, "Priya", "IT", 60000),
    new Employee(103, "Arun", "HR", 55000),
    new Employee(104, "Kavya", "IT", 70000),
    new Employee(105, "Divya", "Sales", 45000));

Q1. Print all employee names using Stream
Q2. Filter and print employees with salary > 55000
Q3. Count the number of employees in "HR" department
Q4. Sort employees by salary in descending order
Q5. Find the highest paid employee (use max)
Q6. Find the average salary of all employees
Q7. Collect all names into a List
Q8. Group employees by department (use Collectors.groupingBy)
Q9. Calculate total salary per department
Q10. Find names of employees in IT department sorted by salary
Q11. Check if any employee earns less than 40000
Q12. Get a comma-separated string of all employee names
Q13. Get a list of top 2 highest earning employees
Q14. Skip first 2 employees and print the rest
Q15. Limit to first 3 employees and print their names
Q16. Get employee with minimum salary in HR department
Q17. Partition employees into two groups: salary > 55000 and <= 55000
Q18. Create a Map<Department, AverageSalary>
Q19. Sort employees by name and then by salary
Q20. Convert List<Employee> into Map<Id, Name>
🔹 Challenge 1: Get employees whose name starts with “D” and ends with “a”
🔹 Challenge 2: List departments with more than 1 employee
🔹 Challenge 3: Find the second highest salary using streams
(Hint: Use distinct(), sorted(), skip(1), findFirst())
 */
 
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class EmpPerson {
    int id;
    String name;
    String department;
    double salary;

    public EmpPerson(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + department + " " + salary;
    }

    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
}

public class Assignment50 {
    public static void main(String[] args) {

        List<EmpPerson> employees = Arrays.asList(
            new EmpPerson(101, "Ravi", "HR", 50000),
            new EmpPerson(102, "Priya", "IT", 60000),
            new EmpPerson(103, "Arun", "HR", 55000),
            new EmpPerson(104, "Kavya", "IT", 70000),
            new EmpPerson(105, "Divya", "Sales", 45000)
        );

        // Q1
        employees.stream().map(EmpPerson::getName).forEach(System.out::println);

        // Q2
        employees.stream().filter(e -> e.getSalary() > 55000).forEach(System.out::println);

        // Q3
        long hrCount = employees.stream().filter(e -> e.getDepartment().equals("HR")).count();
        System.out.println("HR Count: " + hrCount);

        // Q4
        employees.stream().sorted(Comparator.comparingDouble(EmpPerson::getSalary).reversed()).forEach(System.out::println);

        // Q5
        employees.stream().max(Comparator.comparingDouble(EmpPerson::getSalary)).ifPresent(System.out::println);

        // Q6
        double avgSal = employees.stream().mapToDouble(EmpPerson::getSalary).average().orElse(0.0);
        System.out.println("Average Salary: " + avgSal);

        // Q7
        List<String> names = employees.stream().map(EmpPerson::getName).collect(Collectors.toList());
        System.out.println(names);

        // Q8
        Map<String, List<EmpPerson>> deptMap = employees.stream().collect(Collectors.groupingBy(EmpPerson::getDepartment));
        System.out.println(deptMap);

        // Q9
        Map<String, Double> totalSalaryByDept = employees.stream().collect(Collectors.groupingBy(EmpPerson::getDepartment, Collectors.summingDouble(EmpPerson::getSalary)));
        System.out.println(totalSalaryByDept);

        // Q10
        List<String> itNames = employees.stream()
            .filter(e -> e.getDepartment().equals("IT"))
            .sorted(Comparator.comparingDouble(EmpPerson::getSalary))
            .map(EmpPerson::getName)
            .collect(Collectors.toList());
        System.out.println(itNames);

        // Q11
        boolean anyLow = employees.stream().anyMatch(e -> e.getSalary() < 40000);
        System.out.println("Any salary < 40000? " + anyLow);

        // Q12
        String commaNames = employees.stream().map(EmpPerson::getName).collect(Collectors.joining(", "));
        System.out.println(commaNames);

        // Q13
        List<EmpPerson> top2 = employees.stream()
            .sorted(Comparator.comparingDouble(EmpPerson::getSalary).reversed())
            .limit(2)
            .collect(Collectors.toList());
        System.out.println("Top 2: " + top2);

        // Q14
        employees.stream().skip(2).forEach(System.out::println);

        // Q15
        employees.stream().limit(3).map(EmpPerson::getName).forEach(System.out::println);

        // Q16
        employees.stream()
            .filter(e -> e.getDepartment().equals("HR"))
            .min(Comparator.comparingDouble(EmpPerson::getSalary))
            .ifPresent(System.out::println);

        // Q17
        Map<Boolean, List<EmpPerson>> partitioned = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 55000));
        System.out.println(partitioned);

        // Q18
        Map<String, Double> avgSalaryPerDept = employees.stream().collect(Collectors.groupingBy(EmpPerson::getDepartment, Collectors.averagingDouble(EmpPerson::getSalary)));
        System.out.println(avgSalaryPerDept);

        // Q19
        employees.stream().sorted(Comparator.comparing(EmpPerson::getName).thenComparing(EmpPerson::getSalary)).forEach(System.out::println);

        // Q20
        Map<Integer, String> idToName = employees.stream().collect(Collectors.toMap(EmpPerson::getId, EmpPerson::getName));
        System.out.println(idToName);

        // Challenge 1
        employees.stream().filter(e -> e.getName().startsWith("D") && e.getName().endsWith("a")).forEach(System.out::println);

        // Challenge 2
        deptMap.entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(System.out::println);

        // Challenge 3
        employees.stream().map(EmpPerson::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(s -> System.out.println("Second Highest Salary: " + s));
    }
}


/*
 Ravi
Priya
Arun
Kavya
Divya
102 Priya IT 60000.0
104 Kavya IT 70000.0
HR Count: 2
104 Kavya IT 70000.0
102 Priya IT 60000.0
103 Arun HR 55000.0
101 Ravi HR 50000.0
105 Divya Sales 45000.0
104 Kavya IT 70000.0
Average Salary: 56000.0
[Ravi, Priya, Arun, Kavya, Divya]
{Sales=[105 Divya Sales 45000.0], HR=[101 Ravi HR 50000.0, 103 Arun HR 55000.0], IT=[102 Priya IT 60000.0, 104 Kavya IT 70000.0]}
{Sales=45000.0, HR=105000.0, IT=130000.0}
[Priya, Kavya]
Any salary < 40000? false
Ravi, Priya, Arun, Kavya, Divya
Top 2: [104 Kavya IT 70000.0, 102 Priya IT 60000.0]
103 Arun HR 55000.0
104 Kavya IT 70000.0
105 Divya Sales 45000.0
Ravi
Priya
Arun
101 Ravi HR 50000.0
{false=[101 Ravi HR 50000.0, 103 Arun HR 55000.0, 105 Divya Sales 45000.0], true=[102 Priya IT 60000.0, 104 Kavya IT 70000.0]}
{Sales=45000.0, HR=52500.0, IT=65000.0}
103 Arun HR 55000.0
105 Divya Sales 45000.0
104 Kavya IT 70000.0
102 Priya IT 60000.0
101 Ravi HR 50000.0
{101=Ravi, 102=Priya, 103=Arun, 104=Kavya, 105=Divya}
105 Divya Sales 45000.0
HR=[101 Ravi HR 50000.0, 103 Arun HR 55000.0]
IT=[102 Priya IT 60000.0, 104 Kavya IT 70000.0]
Second Highest Salary: 60000.0

 */
 