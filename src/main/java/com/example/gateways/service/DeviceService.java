package com.example.gateways.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.gateways.model.Device;
import com.example.gateways.model.Gateway;

public interface DeviceService {
	
	Device saveDevice(Device device);
	
	void save(List<Device> devices);

	Device saveDevice(long gatewayId, Device device);

	void deleteDevice(long deviceId);
}
