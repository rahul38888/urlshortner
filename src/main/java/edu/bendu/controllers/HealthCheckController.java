package edu.bendu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/")
public class HealthCheckController {

	@RequestMapping(value = "/healthcheck", produces="application/json; charset=utf-8")
	public String getHealthcheck(){
		return "Ok";
	}

}
