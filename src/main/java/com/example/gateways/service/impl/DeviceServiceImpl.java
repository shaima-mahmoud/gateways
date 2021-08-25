package com.example.gateways.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gateways.model.Device;
import com.example.gateways.model.Gateway;
import com.example.gateways.repository.DeviceRepository;
import com.example.gateways.repository.GatewayRepository;
import com.example.gateways.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	GatewayRepository gatewayRepository;
	
	@Override
	public Device saveDevice(Device device) {
		return deviceRepository.save(device);
	}
	
	@Override
	public void save(List<Device> devices) {
		deviceRepository.saveAllAndFlush(devices);
	}

	@Override
	public Device saveDevice(long gatewayId, Device device) {
		Gateway gateway = gatewayRepository.getById(gatewayId);
		device.setGateway(gateway);
		return deviceRepository.save(device);
	}

	@Override
	public void deleteDevice(long deviceId) {
		deviceRepository.deleteById(deviceId);
		
	}
}
