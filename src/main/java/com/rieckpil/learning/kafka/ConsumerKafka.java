package com.rieckpil.learning.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

public class ConsumerKafka implements AcknowledgingMessageListener<String, String> {

	@Override
	@KafkaListener(id = "consumer", topics = { "${kafka.topic}" })
	public void onMessage(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {

		try {
			System.out.println("Read Record is: " + data.value());
			System.out.println("Offset is: " + data.offset());
			System.out.println("Topic is: " + data.topic());
			System.out.println("Partition is: " + data.partition());
		} catch (Exception e) {
			System.out.println("Error while processing the data: " + e);
		} finally {
			acknowledgment.acknowledge();
		}

	}

}
