package model;

import java.time.LocalDate;

public class Flight {

	private long flightNumber;
	private  String flightType;
	private String flightsource;
	private String filghtDestination;
	private String layOffPoints;
	private LocalDate flyDate;
	private double flightCharge;
	public Flight() {
		super();
	}
	
	public Flight(long flightNumber, String flightType, String flightsource, String filghtDestination,
			String layOffPoints, LocalDate flyDate, double flightCharge) {
		super();
		this.flightNumber = flightNumber;
		this.flightType = flightType;
		this.flightsource = flightsource;
		this.filghtDestination = filghtDestination;
		this.layOffPoints = layOffPoints;
		this.flyDate = flyDate;
		this.flightCharge = flightCharge;
	}




	public long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public String getFlightsource() {
		return flightsource;
	}
	public void setFlightsource(String flightsource) {
		this.flightsource = flightsource;
	}
	public String getFilghtDestination() {
		return filghtDestination;
	}
	public void setFilghtDestination(String filghtDestination) {
		this.filghtDestination = filghtDestination;
	}
	public String getLayOffPoints() {
		return layOffPoints;
	}
	public void setLayOffPoints(String layOffPoints) {
		this.layOffPoints = layOffPoints;
	}
	public LocalDate getFlyDate() {
		return flyDate;
	}
	public void setFlyDate(LocalDate flyDate) {
		this.flyDate = flyDate;
	}
	public double getFlightCharge() {
		return flightCharge;
	}
	public void setFlightCharge(double flightCharge) {
		this.flightCharge = flightCharge;
	}
	
}
