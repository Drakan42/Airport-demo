package com.daniel.demo.runway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.daniel.demo.airport.Airport;
import com.daniel.demo.runway.Runway;

public interface RunwayRepository extends JpaRepository<Runway, String> {
	
	List<Runway> findByAirport(Airport airport);
    
    @Query(value = "select distinct(r.surface) from Runway r join r.airport a where a.isoCountry =?1")
    public String[] findDistinctSurfaceFromCountry(String code);
    
    @Query(value = "select r.le_ident , count(r.le_ident) as c from Runway r group by (r.le_ident) order by c desc limit 10", 
            countQuery = "select count(1) from (select count(1) from Airport group by a.isoCountry) z", nativeQuery = true)
     public List<Object[]> findCountPerleIdentdesc();
}
