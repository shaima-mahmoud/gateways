package com.example.gateways.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gateways.model.Device;

public interface DeviceRepository  extends JpaRepository<Device, Long> {
	
	List<Device> findByStatus(boolean status);
	
	List<Device> findByVendorContaining(String vendor);
}
