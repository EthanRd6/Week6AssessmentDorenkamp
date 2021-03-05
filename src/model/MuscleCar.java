package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author Ethan Dorenkamp - edorenkamp
* CIS175 - Spring 2021
* Feb 11, 2021
*/
@Entity
@Table(name = "muscleCars")
public class MuscleCar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "MAKE")
	private String make;
	@Column(name = "MODEL")
	private String model;
	@Column(name = "YEAR")
	private int year;
	@Column(name = "ZEROTOSIXTYTIME")
	private double zeroToSixtyTime;
	@Column(name = "EXTERIORCOLOR")
	private String exteriorColor;
	
	public MuscleCar() {
		super();
	}

	public MuscleCar(String make, String model, int year, double zeroToSixtyTime, String exteriorColor) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.zeroToSixtyTime = zeroToSixtyTime;
		this.exteriorColor = exteriorColor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getZeroToSixtyTime() {
		return zeroToSixtyTime;
	}

	public void setZeroToSixtyTime(double zeroToSixtyTime) {
		this.zeroToSixtyTime = zeroToSixtyTime;
	}

	public String getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}
	
	public String returnCarDetails() {
		return make + ": " + year + " "+ model + ", " + exteriorColor + ", 0 to 60 MPH time: " + zeroToSixtyTime;
	}
}
