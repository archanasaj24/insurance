package com.project.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
