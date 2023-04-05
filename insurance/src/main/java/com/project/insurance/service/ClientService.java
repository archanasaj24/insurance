package com.project.insurance.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.Client;

public interface ClientService
{
	public void createClient(Client client );
	
	public Map<String, Boolean> deleteClient(int id) throws ResourceNotFoundException;
	
	public ResponseEntity<Client> selectClient(int id) throws ResourceNotFoundException;
	
	public List<Client> selectAllClient();
	
	public ResponseEntity<Client> updateClient(Client client,int id) throws ResourceNotFoundException ;
}
