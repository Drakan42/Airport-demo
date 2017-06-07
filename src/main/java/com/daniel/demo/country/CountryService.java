package com.daniel.demo.country;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
		
	public List<Country> getAllCountries()
	{
		List<Country> countries = new ArrayList<>();
		countryRepository.findAll().forEach(countries::add);
		return countries;
	}
	public List<Country> getCountriesfromCodeOrName(String name)
	{
		List<Country> countrys = new ArrayList<>();
		Country country = countryRepository.findByCode(name);
		if (country != null)
			countrys.add(country);
		else
			countrys = countryRepository.findByNameStartingWith(name);
		return countrys;
	}
	public Country getCountriesfromCode(String name)
	{
		Country country = countryRepository.findByCode(name);
		return country;
	}
}
