package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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


}
