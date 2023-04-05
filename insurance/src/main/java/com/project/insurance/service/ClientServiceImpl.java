package com.project.insurance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.ClientRepository;
import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.Client;

@Service
public class ClientServiceImpl implements ClientService
{
	@Autowired
     ClientRepository clientRepo;

	@Override
	public void createClient(Client client) 
	{
		clientRepo.save(client);		
	}

	@Override
	public Map<String, Boolean> deleteClient(int id) throws ResourceNotFoundException {
		 Client client = clientRepo.findById(id)
		           .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
		 
		         clientRepo.delete(client);
		         Map<String, Boolean> response = new HashMap<>();
		         response.put("deleted", Boolean.TRUE);
		         return response;
		
	}

	@Override
	public ResponseEntity<Client> selectClient(int id) throws ResourceNotFoundException
	{
		Client client = clientRepo.findById(id)
		           .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
		         return ResponseEntity.ok().body(client);

	}

	@Override
	public List<Client> selectAllClient() {
		List<Client> clientList=new ArrayList<>();
		clientRepo.findAll().forEach(client -> clientList.add(client));
		return clientList;
	}

	@Override
	public ResponseEntity<Client> updateClient(Client client, int id) throws ResourceNotFoundException
	{
		Client client1 = clientRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
        
		client1.setName(client.getName());
		client1.setDateOfBirth(client.getDateOfBirth());
		client1.setAddress(client.getAddress());
		client1.setContact(client.getContact());
		
        final Client updateClient = clientRepo.save(client);
        return ResponseEntity.ok(updateClient);
		
	}
	
}
