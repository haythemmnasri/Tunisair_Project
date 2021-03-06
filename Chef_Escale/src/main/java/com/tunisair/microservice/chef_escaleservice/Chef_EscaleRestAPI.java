package com.tunisair.microservice.chef_escaleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/chefs")
public class Chef_EscaleRestAPI {
	private String title = "Hello, I'm the Chef_Escale Microservice";
	@Autowired
	private  Chef_EscaleService chef_escale_Service;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Chef_Escale> createChef_Escale(@RequestBody Chef_Escale chef_escale) {
		return new ResponseEntity<>(chef_escale_Service.addChefEscale(chef_escale), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Chef_Escale> updateChef_Escale(@PathVariable(value = "id") int id,
    										@RequestBody Chef_Escale chef_escale){
		return new ResponseEntity<>(chef_escale_Service.updateChefEscale(id, chef_escale), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteChef_Escale(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(chef_escale_Service.delete_Chef_Escale(id), HttpStatus.OK);
	}
}
