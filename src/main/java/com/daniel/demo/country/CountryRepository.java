package com.daniel.demo.country;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

	List<Country> findByNameStartingWith(String name);
	Country findByCode(String Code);
	List<Country> findByCodeOrNameStartingWith(String code,String name);
	
}
