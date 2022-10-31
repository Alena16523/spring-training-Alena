package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with firstname "" and last name ""
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastName, String email );

    //display all employees that firstName is not ""
    List<Employee> findByFirstNameIsNot(String name);

    //display all employees where lastName starts with ""
    List<Employee> findByLastNameStartingWith (String starts);

    //display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //display all employees that have been hired between "" and ""
    List<Employee> findEmployeeByHireDateBetween(LocalDate start, LocalDate end);

    //display all employees where salary is greater ad equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer Salary);

    //display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees than do not have email address
    List<Employee> findEmployeeByEmailNull(String email);

    @Query("select e from Employee e where e.email='amcnee1@google.com'")
    Employee retrieveEmployeeDetail();

    @Query("select e from Employee e where e.email='amvnee1@google.com'")
    Employee retrieveEmployeeSalary();

    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains / Starts-with / Ends-with
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //BETWEEN
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1,int salary2);

    //BEFORE
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();

    //NOT NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING in Asc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //SORTING in Desc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query
    @Query(value = "SELECT * FROM employees WHERE salary = ?1",nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);



}
