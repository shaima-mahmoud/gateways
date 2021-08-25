package com.example.gateways.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "device")

public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="UID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	@NotNull(message = "Vendor is required")
	@Column(name="vendor")
	private String vendor;
	
	@Column(name="created")
	private Date created;
	
	@Column(name="status")
	private Boolean status = false;
	
	@NotNull(message="Gateway cannot be null")
	@JoinColumn(name="gateway_id", nullable = false)
	@ManyToOne
	private Gateway gateway;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getUid() {
		return uid;
	}


	public void setUid(Long uid) {
		this.uid = uid;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Gateway getGateway() {
		return gateway;
	}


	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}


	@PostPersist
	public void setCreatedValue(){
		setUid(id);
		setCreated(new Date());
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", uid=" + uid + ", vendor=" + vendor + ", created=" + created 
				+ ", status=" + status + ", gateway=" + gateway +"]";
	}
	
}
