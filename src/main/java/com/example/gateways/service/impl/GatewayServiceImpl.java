package com.example.gateways.service.impl;


import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gateways.controller.Messages;
import com.example.gateways.model.Device;
import com.example.gateways.model.Gateway;
import com.example.gateways.repository.GatewayRepository;
import com.example.gateways.service.DeviceService;
import com.example.gateways.service.GatewayService;

@Service
public class GatewayServiceImpl implements GatewayService {

	@Autowired
	GatewayRepository gatewayRepository;
	
	@Autowired
	DeviceService deviceService;
	
	@Override
	public List<Gateway> findAll(){
		return gatewayRepository.findAll();
	}
	
	@Override
	public Gateway saveGateway(Gateway gateway) {
		if(gateway!=null && gateway.getAddress()!=null) {
			validateIp(gateway.getAddress());
		}
		
		List<Device> devices = gateway.getDevices();
		if(devices == null || devices.isEmpty())
			return gatewayRepository.save(gateway);
		else {
			gateway.setDevices(null);
			gateway = gatewayRepository.save(gateway);
			for(Device device: devices) {
				device.setGateway(gateway);
			}
			deviceService.save(devices);
			return gatewayRepository.findById(gateway.getId()).get();
		}
	}
	
	@Override
	public Optional<Gateway> findById(long id) {
		return gatewayRepository.findById(id);
	}
	
	private void validateIp(String ip) throws ValidationException {
		String[] parts = ip.split("\\.");
		if( parts.length < 4 ) {
			throw new ValidationException (Messages.INVALID_IP_ADDRESS);
		} else {
			for(String p : parts) {
				try {
					int pInt = Integer.parseInt(p);
					if(pInt < 0 || pInt>255) {
						throw new ValidationException (Messages.INVALID_IP_ADDRESS);
					}
				} catch (Exception e ) {
					throw new ValidationException ("Invalid IP Address");
				}
			}
		}
	}
	
}
