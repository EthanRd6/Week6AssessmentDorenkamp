package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* @author Ethan Dorenkamp - edorenkamp
* CIS175 - Spring 2021
* Mar 4, 2021
*/
@Entity
@Table(name="drivers")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="DRIVER_NAME")
	private String driverName;
	
	public Driver() {
		super();
	}

	public Driver(String driverName) {
		super();
		this.driverName = driverName;
	}

	public Driver(int id, String driverName) {
		super();
		this.id = id;
		this.driverName = driverName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", driverName=" + driverName + "]";
	}
	
}
