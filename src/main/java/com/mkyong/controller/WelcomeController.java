package com.mkyong.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mkyong.entity.Customer;
import com.mkyong.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/findAll")
	public ModelAndView provaFindAll()  {

		List<String> listaNomi= new ArrayList<>();
		List<Customer> listPerson = new ArrayList<>();
		listPerson = customerRepository.findAll();
		listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondname()));
		return new ModelAndView("listaNomi","listaNomi", listaNomi);

	}

	@GetMapping("/customerById={id}")
	public ModelAndView getCustomerById(@PathVariable String id)  {

		List<String> listaNomi= new ArrayList<>();
		List<Customer> listPerson = new ArrayList<>();
		listPerson = customerRepository.findById(Long.parseLong(id));
		listaNomi.add(listPerson.get(0).getName()+" "+listPerson.get(0).getSecondname());
		return new ModelAndView("listaNomi","listaNomi", listaNomi);
	}

	@GetMapping("/insertCustomer={id},{name},{secondName}")
	public ModelAndView insertCustomer(@PathVariable("id") String id, @PathVariable("name") String name,@PathVariable("secondName")String secondName)  {

		List<String> listaNomi= new ArrayList<>();
		List<Customer> listPerson = new ArrayList<>();
		customerRepository.insertCustomer(Long.parseLong(id),name,secondName);
		listPerson =customerRepository.findAll();
		listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondname()));
		return new ModelAndView("listaNomi","listaNomi", listaNomi);
	}

	@GetMapping("/updateCustomer={id},{name},{secondName}")
	public ModelAndView updateCustomer(@PathVariable("id") String id, @PathVariable("name") String name,@PathVariable("secondName")String secondName)  {

		List<String> listaNomi= new ArrayList<>();
		List<Customer> listPerson = new ArrayList<>();
		customerRepository.updateCustomer(name,secondName,Long.parseLong(id));
		listPerson =customerRepository.findAll();
		listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondname()));
		return new ModelAndView("listaNomi","listaNomi", listaNomi);
	}

	@GetMapping("/deleteCustomer={id}")
	public ModelAndView deleteCustomer(@PathVariable("id") String id)  {

		List<String> listaNomi= new ArrayList<>();
		List<Customer> listPerson = new ArrayList<>();
		customerRepository.deleteCustomerById(Long.parseLong(id));
		listPerson =customerRepository.findAll();
		listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondname()));
		return new ModelAndView("listaNomi","listaNomi", listaNomi);
	}


	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

}