package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    //display all departments in the furniture Department
    List<Department> findByDepartment(String department);

    //display all departments in the Health Division
    List<Department> findByDivision(String department);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String division);

    //display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findTop3DistinctByDivisionContaining(String division);


}
