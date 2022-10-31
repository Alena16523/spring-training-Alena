package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
     List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanOrAgeEquals(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAllByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int age1, int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String start);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAge(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select e from Account e ")
    List<Account> returnAll();

    //Write a JPQL query to list all admin accounts
    @Query("select e from Account e where e.role=?1")
    List<Account> adminAccounts(UserRole role);

    //Write a JPQL query to sort all accounts with age
    @Query("select e from Account e order by e.age desc")
    List<Account> sortedByAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age <?1", nativeQuery=true)
    List<Account> ageLowerThan(Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details ad where name ilike concat ('%',?1,'%')"+
            "or country ilike concat ('%',?1,'%')"+
            "or address ilike concat ('%',?1,'%')"+
            "or ad.state ilike concat ('%',?1,'%')"+
            "or city ilike concat ('%',?1,'%')", nativeQuery = true)
    List<Account> ifContains (@Param("pattern") String value);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value="select * from account_details where age > ?1", nativeQuery = true)
    List<Account> ageHigherThan(Integer age);


}
