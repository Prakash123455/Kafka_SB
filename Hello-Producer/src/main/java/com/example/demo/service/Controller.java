package com.example.demo.service;

import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AppConfig;

@RestController
public class Controller {

    
	@RequestMapping(value = "/kafka")
    public String sendMessageToKafkaTopic() {
    	
        Properties p= new Properties();
        p.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfig.applicationID);
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfig.bootstrapserver);
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        
        KafkaProducer<Integer, String> prod= new KafkaProducer<>(p);
        for (int i =0; i<=AppConfig.numEvents;i++) {
			prod.send(new ProducerRecord<Integer, String>(AppConfig.topicName, i," Sample messages is :- "+i));
			System.out.println("Sample message- "+i+"data send to topic");
		}
        System.out.println("Data send to topic");
        prod.close();
        return "Data saved to topic";
    }
}