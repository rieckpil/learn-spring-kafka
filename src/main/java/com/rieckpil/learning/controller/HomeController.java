package com.rieckpil.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rieckpil.learning.kafka.ProducerKafka;

@RestController
public class HomeController {

	@Autowired
	private Environment env;

	@Autowired
	private ProducerKafka producerKafka;

	@RequestMapping(value = "/home")
	public String getResponse(@RequestParam("message") String message) {
		producerKafka.sendMessage(message);
		return env.getProperty("message.response");
	}

}
