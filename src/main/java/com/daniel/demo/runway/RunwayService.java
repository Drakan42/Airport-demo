package com.daniel.demo.runway;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.demo.airport.Airport;

@Service
public class RunwayService {

	@Autowired
	private RunwayRepository runwayRepository;

	public List<Runway> getAllRunwaysFromAirport(Airport airport) {
		List<Runway> runways = new ArrayList<>();
		runways = runwayRepository.findByAirport(airport);
		return runways;
	}

	public String findSurfaceFromCountry(String code) {
		String string = "";
		String[] result = runwayRepository.findDistinctSurfaceFromCountry(code);
		for (String string2 : result) {
			string += string2 + ", ";
		}
		return string;
	}

	public LinkedHashMap<String, String> runwayIdentifications() {
		LinkedHashMap<String, String> runwayIdent = new LinkedHashMap<>();
		List<Object[]> result = runwayRepository.findCountPerleIdentdesc();
		for (Object[] objects : result) {
			runwayIdent.put(objects[0].toString(), objects[1].toString());
		}
		return runwayIdent;
	}
}
