package com.daniel.demo.airport;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import com.daniel.demo.runway.Runway;

@Entity
public class Airport {
	
	@Id
	private Long id;
	private String ident;
	private String type;
	private String name;
	private String latitude_deg;
	private String longitude_deg;
	private String elevation_ft;
	private String continent;
	private String isoCountry;
	private String iso_region;
	private String municipality;
	private String scheduled_service;
	private String gps_code;
	private String iata_code;
	private String local_code;
	private String home_link;
	private String wikipedia_link;
	private String keywords;
	@OneToMany(mappedBy = "airport")
	private List<Runway> runways;
	public List<Runway> getRunway() {
		return runways;
	}
	public void setRunway(List<Runway> runway) {
		this.runways = runway;
	}
	private long c;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatitude_deg() {
		return latitude_deg;
	}
	public void setLatitude_deg(String latitude_deg) {
		this.latitude_deg = latitude_deg;
	}
	public String getLongitude_deg() {
		return longitude_deg;
	}
	public void setLongitude_deg(String longitude_deg) {
		this.longitude_deg = longitude_deg;
	}
	public String getElevation_ft() {
		return elevation_ft;
	}
	public void setElevation_ft(String elevation_ft) {
		this.elevation_ft = elevation_ft;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getIsoCountry() {
		return isoCountry;
	}
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}
	public String getIso_region() {
		return iso_region;
	}
	public void setIso_region(String iso_region) {
		this.iso_region = iso_region;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getScheduled_service() {
		return scheduled_service;
	}
	public void setScheduled_service(String scheduled_service) {
		this.scheduled_service = scheduled_service;
	}
	public String getGps_code() {
		return gps_code;
	}
	public void setGps_code(String gps_code) {
		this.gps_code = gps_code;
	}
	public String getIata_code() {
		return iata_code;
	}
	public void setIata_code(String iata_code) {
		this.iata_code = iata_code;
	}
	public String getLocal_code() {
		return local_code;
	}
	public void setLocal_code(String local_code) {
		this.local_code = local_code;
	}
	public String getHome_link() {
		return home_link;
	}
	public void setHome_link(String home_link) {
		this.home_link = home_link;
	}
	public String getWikipedia_link() {
		return wikipedia_link;
	}
	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public long getC() {
		return c;
	}
	public void setC(long c) {
		this.c = c;
	}
	

}
