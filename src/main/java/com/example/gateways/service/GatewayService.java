package com.example.gateways.service;


import java.util.List;
import java.util.Optional;

import com.example.gateways.model.Gateway;

public interface GatewayService {

	List<Gateway> findAll();
	
	Gateway saveGateway(Gateway gateway);
	
	Optional<Gateway> findById(long id);
}
