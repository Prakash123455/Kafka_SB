package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.EntriesList;

@Transactional
@Service
public class ApiServiceImpl implements ApiServices{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public EntriesList getApiDetails() {
		
		EntriesList ap=  restTemplate.getForObject("https://api.publicapis.org/entries", EntriesList.class);
		return ap;
		
	}

	
}
