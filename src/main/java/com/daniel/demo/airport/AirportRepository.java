package com.daniel.demo.airport;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AirportRepository extends JpaRepository<Airport, String>{

	List<Airport> findByIsoCountry(String isoCountry);
	
	 @Query(value = "select a.id , count(a.isoCountry) as c, a.isoCountry from Airport a group by (a.isoCountry) order by c desc,id", 
             countQuery = "select count(1) from (select count(1) from Airport group by a.isoCountry) z")
      public List<Object[]> findCountPerIsoCountryDesc();
      
      @Query(value = "select a.id , count(a.isoCountry) as c, a.isoCountry from Airport a group by (a.isoCountry) order by c asc,id", 
              countQuery = "select count(1) from (select count(1) from Airport group by a.isoCountry) z")
       public List<Object[]> findCountPerIsoCountryAsc();

}
