package com.example.gateways.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gateway")
public class Gateway {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "serial_number", unique = true)
	private String serialNumber;

	@NotNull(message = "Name is required")
	@Column(name = "name", unique = true)
	private String name;

	@NotNull(message = "Address is required")
	@Pattern(regexp = "^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
      "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
      "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
      "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$", message = "Invalid IPv4 address")
	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "gateway", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("gateway")
	private List<Device> devices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Device> getDevices() {
		if (devices == null)
			new ArrayList<>();
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	@PostPersist
	public void generateSerial(){
		this.setSerialNumber("GTW-"+ id);
	}

}
