package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.Entries;
import com.example.demo.bean.EntriesList;
import com.example.demo.service.ApiServices;

@RestController
public class PublicApiController {

	private static final Logger logger = LoggerFactory.getLogger(PublicApiController.class);

	@Autowired
	private KafkaTemplate<String, Entries> kafkaTemplate;


	@Autowired
	ApiServices aps;

	@Value(value = "${kafka.topicName}")
	private String topicName;
	String status = "";

	//reading data from 3rd party {"https://api.publicapis.org/entries"}api and displaying as well as saving it to topic
	@RequestMapping("/get")
	public EntriesList getApiDeails()
	{

		EntriesList appl=aps.getApiDetails();
		for (int i = 0; i < appl.getEntries().size(); i++) {
			Entries ee=appl.getEntries().get(i);

			ListenableFuture<SendResult<String, Entries>> future =this.kafkaTemplate.send(topicName,ee.aPI, ee);

			future.addCallback(new ListenableFutureCallback<SendResult<String, Entries>>() {

				@Override
				public void onSuccess(SendResult<String, Entries> result) {
					status = "Message sent successfully";
					logger.info("successfully sent message = {}, with offset = {}", aps.getApiDetails(),result.getRecordMetadata().offset());
				}

				@Override
				public void onFailure(Throwable ex) {
					logger.info("Failed to send message = {}, error = {}", aps.getApiDetails(), ex.getMessage());
					status = "Message sending failed";
				}
			});
		}
		return aps.getApiDetails();
	}

}
