package com.fdmgroup.bankUserStories.webClient;

import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.bankUserStories.geoCoder.Geodata;

public class GeoCoderWebClient 
{
	private WebClient webClient;

	public GeoCoderWebClient(WebClient webClient) {
		super();
		this.webClient = webClient;
	}
	
	public Geodata fetchCityAndProvince(String postalCode)
	{
		String url = "https://geocoder.ca/?locate="+ postalCode +"&json=1";
		
		Geodata geodata = webClient
		.get()
		.uri(url)
		.retrieve()
		.bodyToMono(Geodata.class)
		.block();
		
		return geodata;
	}
}
