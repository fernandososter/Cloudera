package br.com.kafka.custom.consumer;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class StringConsumer {

	public static void main(String[] args) {
		Properties props = new Properties(); 
		// 3 mandatory parameters: bootstrap.servers, key.deserializer, value.deserializer
		props.put("bootstrap.servers", "localhost:9092"); 
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		// not mandatory but we can consider it is. 
		props.put("group.id", "TestGroup");
		
		KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
		
		
	}
	
	
}
