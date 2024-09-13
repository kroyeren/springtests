package com.example.servingwebcontent;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {
	
	private RestTemplate restTemplate;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/instrument")
	public String instrument(@RequestParam(name="instrumentId", required=false, defaultValue = "0000012") int instrumentId, Model model) {

//		Instrument ins = getInstrument(instrumentId);
		Instrument ins = new Instrument(1,123,"Mortens New instrument", "Longname for instrument","Morten");

		model.addAttribute("instrumentId", instrumentId);
		model.addAttribute("instrument", ins);
		return "instrument";
	}

	@GetMapping("/catFact")
	public String catFact(Model model) {
		CatFact catFact = getCatFact();

		model.addAttribute("catFact", catFact.fact());
		model.addAttribute("length",catFact.length());
		return "catFact";
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		this.restTemplate =  builder.build();
		return this.restTemplate;
	}

	public CatFact getCatFact() {
		return restTemplate.getForObject("https://catfact.ninja/fact",CatFact.class);
	}
	
	public Instrument getInstrument(int instrumentId) {
		return restTemplate.getForObject("http://172.31.2.94:3098/?instrumentid=" + instrumentId, Instrument.class);
	}
	
	
}
