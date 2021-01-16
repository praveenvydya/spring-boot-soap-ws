//package com.javalines.spring.soap.api.controllers;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.javalines.spring.soap.api.models.CustomerModel;
//import com.javalines.spring.soap.api.repository.CustomerRepository;
//
//@RestController
//@RequestMapping("/mongo")
//public class CustomerController {
//
//	@Autowired
//	private CustomerRepository mongoRepository;
//	
//	@Autowired
//	private MongoTemplate mongoTemplate;
//
//	@RequestMapping(path="/repo", method = RequestMethod.GET)
//	public Iterable<CustomerModel> findByRepo() throws IOException {
//		return mongoRepository.findAll();
//	}
//	
//	@RequestMapping(path="/template", method = RequestMethod.GET)
//	public Iterable<Model> findByTemplate() throws IOException {
//		return mongoTemplate.findAll(Model.class);
//	}
//
//	@RequestMapping(value = "/repo/{value}", method = RequestMethod.GET)
//	public void saveByRepo(@PathVariable String value) {
//		CustomerModel model = new CustomerModel();
//		model.setId(1);
//		model.setName("Praveen");
//		model.setAge(34);
//		mongoRepository.save(model);
//	}
//	
////	@RequestMapping(value = "/template/{value}", method = RequestMethod.GET)
////	public void saveByTemplate(@PathVariable String value) {
////		Model model = new Model();
////		model.setId(System.currentTimeMillis());
////		model.setValue(value);
////		mongoTemplate.save(model);
////	}
//}
