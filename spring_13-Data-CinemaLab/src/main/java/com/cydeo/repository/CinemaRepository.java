package com.cydeo.repository;

import com.cydeo.entity.BaseEntity;
import com.cydeo.entity.Cinema;
import com.cydeo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName (String name);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocationCountry(String location);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrBySponsoredName (String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id=?1 ")
    String findById2(@Param("id") Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "select * from cinema c join  location l "+
            "on l.id=c.location_id where l.country=?1", nativeQuery = true)
    List<Cinema> readByLocation(String location);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select * from cinema where name ilike concat ('%', ?1, '%') "+
            "or sponsored_name ilike concat ('%', ?1, '%')", nativeQuery = true)
    List<Cinema> findByNameOrSponsoredName (@Param ("pattern") String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "select * from cinema order by name", nativeQuery = true)
    List<Cinema> sortedByName ();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "select distinct sponsored_name from cinema where name=?1", nativeQuery = true)
    List<Cinema> distinctBySponsoredName(String name);



}
