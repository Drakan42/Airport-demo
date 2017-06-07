package com.daniel.demo.airport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

	@Autowired
	private AirportRepository airportRepository;
		
	public List<Airport> getAirportsFromIsoCountry(String Code)
	{
		List<Airport> airports = new ArrayList<>();
		airports  = airportRepository.findByIsoCountry(Code);
		return airports;
	}
	public List<Airport> count(byte order)// 0 = desc 1 = asc
	{
		List<Airport> result = new ArrayList<>();
		List<Object[]> quaryResult = null;
		if (order == 0) {
			quaryResult = airportRepository.findCountPerIsoCountryDesc();
		} else if (order == 1){
			quaryResult = airportRepository.findCountPerIsoCountryAsc();
		}
		if (quaryResult != null) {

			for (int i = 0; i < 10; i++) {
				Object[] obj = quaryResult.get(i);
				Airport airport = new Airport();
				airport.setIsoCountry(obj[2].toString());
				airport.setC(Integer.valueOf(obj[1].toString()));
				result.add(airport);
			}
		}
		return result;
	}
}
