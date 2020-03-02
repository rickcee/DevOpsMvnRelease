package net.rickcee.scm.devops.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestServicesController {
	@Autowired
	private Environment env;

	@RequestMapping(method = RequestMethod.GET, path = "/HealthCheck", produces = { "application/json" })
	public Object healthCheck() {
		HashMap<String, String> result = new HashMap<>();
		result.put("environment", env.getProperty("app.environment"));
		result.put("result", "OK");
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/post", produces = { "application/json" })
	public void service0(@RequestBody String content) {
		log.info("[POST] Content: " + content);
	}
	
}