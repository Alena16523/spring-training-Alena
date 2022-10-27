package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("_________Regions________");
        System.out.println("findByCountry: "+ regionRepository.findByCountry("Canada"));
        System.out.println("findByCountry: "+ regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountry: "+ regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("findByCountry: "+ regionRepository.findTop2ByCountry("United States"));
        System.out.println("findByCountry: "+ regionRepository.findTopByCountryContainingOrderByRegion("United States"));
        System.out.println("________________________________");
        System.out.println("---------Departments-----------------");
        System.out.println("findByDepartment: "+ departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDepartment: "+ departmentRepository.findByDivision("Health"));
        System.out.println("findByDepartment: "+ departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findByDepartment: "+ departmentRepository.findTop3DistinctByDivisionContaining("Hea"));


    }
}
