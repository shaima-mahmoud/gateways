package com.example.gateways.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gateways.model.Device;
import com.example.gateways.model.Gateway;
import com.example.gateways.service.DeviceService;
import com.example.gateways.service.GatewayService;


@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class GatewayController {

	@Autowired
	GatewayService gatewayService;
	
	@Autowired
	DeviceService deviceService;
	
	@GetMapping("/gateway")
	public ResponseEntity<List<Gateway>> getAllGateways() {
		try {
			List<Gateway> gateways = gatewayService.findAll();
			if (gateways.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(gateways, HttpStatus.OK);
		} catch (Exception e) {
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	@GetMapping("/gateway/{gatewayId}")
	public ResponseEntity<Gateway> getGatewayById(@PathVariable("gatewayId") long id) {
		Optional<Gateway> gatewayOptional = gatewayService.findById(id);
		if (gatewayOptional.isPresent()) {
			return new ResponseEntity<>(gatewayOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/gateway")
	public ResponseEntity<Gateway> createGateway(@RequestBody Gateway gateway) {
		gatewayService.saveGateway(gateway);
		return new ResponseEntity<>(gateway, HttpStatus.CREATED);
	}
	

	@PostMapping("/gateway/{gatewayId}/device")
	public ResponseEntity<Device> saveDevice(@PathVariable("gatewayId") long gatewayId, @RequestBody Device device) {
		return new ResponseEntity<>(deviceService.saveDevice(gatewayId, device), HttpStatus.CREATED);
		
	}
	

	@DeleteMapping("/device/{deviceId}")
	public ResponseEntity deleteDevice(@PathVariable("deviceId") long deviceId) {
		deviceService.deleteDevice(deviceId);
		return  new ResponseEntity<> (HttpStatus.NO_CONTENT);
		
	}
	
	
}
