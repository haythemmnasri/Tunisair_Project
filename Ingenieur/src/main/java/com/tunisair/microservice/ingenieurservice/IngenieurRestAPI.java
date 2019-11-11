package com.tunisair.microservice.ingenieurservice;

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
@RequestMapping(value = "/api/ingenieurs")
public class IngenieurRestAPI {
	private String title = "Hello, I'm the Ingenieur Microservice";
	@Autowired
	private  IngenieurService ingenieurService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Ingenieur> createIngenieur(@RequestBody Ingenieur ingenieur) {
		return new ResponseEntity<>(ingenieurService.addIngenieur(ingenieur), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ingenieur> updateIngenieur(@PathVariable(value = "id") int id,
    										@RequestBody Ingenieur ingenieur){
		return new ResponseEntity<>(ingenieurService.updateIngenieur(id, ingenieur), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteIngenieur(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(ingenieurService.deleteIngenieur(id), HttpStatus.OK);
	}
}