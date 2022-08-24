package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.Entries;
import com.example.demo.bean.EntriesList;

@Transactional
@Service
public class ApiServiceImpl 
{
	
	@KafkaListener(topics = "Third-Party-API-Topic",groupId = "group_id", containerFactory= "kafkaListenerContainerFactory")
	public void getApiDetails(Entries e) {
		
	 System.out.println("New Entry: " + e);
		
	}
}
