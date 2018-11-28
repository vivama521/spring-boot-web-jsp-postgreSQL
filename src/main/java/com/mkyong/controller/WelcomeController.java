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
		listPerson.forEach(e -> listaNomi.add(e.getName()+" "+e.getSecondName()));
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