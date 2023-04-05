package com.project.insurance.controller;

import java.net.http.HttpHeaders;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.Client;
import com.project.insurance.service.ClientServiceImpl;

import jakarta.validation.Valid;

@RestController
public class ClientController
{
	@Autowired
	ClientServiceImpl clientServiceImpl;
	
	@PostMapping("POST/api/clients")
//	public ResponseEntity<String> createClient(@RequestBody @Valid Client client) {
//        clientServiceImpl.createClient(client);
//        return ResponseEntity.ok("User data is valid");
//	}
	public String createClient(@Valid @RequestBody Client client)
	{
		clientServiceImpl.createClient(client);
		return "New client created";
	}
	
	@DeleteMapping("DELETE/api/clients/{id1}")
	public String deleteClient(@PathVariable("id1") int id) throws ResourceNotFoundException
	{
		clientServiceImpl.deleteClient(id);
		return "Record deleted";
	}
	
	@GetMapping("GET/api/clients/{id1}")
	public ResponseEntity<Client> selectClient(@PathVariable("id1") int id) throws ResourceNotFoundException
	{
		ResponseEntity<Client> client=clientServiceImpl.selectClient(id);
		return client;
	}
	
	@GetMapping("GET/api/clients")
	public List<Client> selectAllClient(){
		List<Client> client=clientServiceImpl.selectAllClient();
		return client;
	}
	
	@PutMapping("PUT/api/clients/{id1}")
	public String updateClient(@PathVariable("id1") int id,
		 @Valid @RequestBody Client client) throws ResourceNotFoundException  {
		clientServiceImpl.updateClient(client, id);
	   	return "Record updated";
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
	      
}
