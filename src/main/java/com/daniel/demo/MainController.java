package com.daniel.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.demo.airport.Airport;
import com.daniel.demo.airport.AirportService;
import com.daniel.demo.country.Country;
import com.daniel.demo.country.CountryService;
import com.daniel.demo.runway.Runway;
import com.daniel.demo.runway.RunwayService;

@Controller
public class MainController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private AirportService airportService;
	@Autowired
	private RunwayService runwayService;

	@RequestMapping("/query") //SELECT * FROM lunatech.runway inner join airport on airport.id = airport_ref inner join country on country.code = airport.iso_country where country.code = 'NL' ;
	public String Query(@RequestParam(value = "name",required=false, defaultValue="NL") String name, Model model) {
		List<Country> countries = countryService.getCountriesfromCodeOrName(name);
		model.addAttribute("countries",countries);
		for(Country country:countries)
		{
			List<Airport> airports = airportService.getAirportsFromIsoCountry(country.getCode());
			model.addAttribute("airports",airports);
			for (Airport airport : airports) {
				List<Runway> runways = runwayService.getAllRunwaysFromAirport(airport);
				model.addAttribute("runwaysfor"+airport.getId(),runways);
			}
		}
		return "query";
	}
	
	@RequestMapping("/report")
	public String Report(Model model) {
		model.addAttribute("runwayIdent",runwayService.runwayIdentifications());
		List<Airport> airportCountDesc = airportService.count((byte) 0);
		for (Airport airport : airportCountDesc) {
			airport.setName(countryService.getCountriesfromCode(airport.getIsoCountry()).getName());
		}
		model.addAttribute("airportCountDesc", airportCountDesc);
		
		List<Airport> airportCountAsc = airportService.count((byte) 1);
		for (Airport airport : airportCountAsc) {
			airport.setName(countryService.getCountriesfromCode(airport.getIsoCountry()).getName());
		}
		model.addAttribute("airportCountAsc", airportCountAsc);
		
		List<Country> countries = countryService.getAllCountries();
		HashMap<String, String> countryRunways = new HashMap<>();
		for (Country country : countries) {		
			String runwayTypes = runwayService.findSurfaceFromCountry(country.getCode());
			countryRunways.put(country.getName(),runwayTypes );
		}
		model.addAttribute("countries",countryRunways);
		
		return "report";
	}

}
