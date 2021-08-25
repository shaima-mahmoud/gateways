package com.example.gateways.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gateways.model.Gateway;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, Long>{

	
}
