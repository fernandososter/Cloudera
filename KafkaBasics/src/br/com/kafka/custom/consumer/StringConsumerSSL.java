package br.com.kafka.custom.consumer;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class StringConsumerSSL {

	public static void main(String[] args) {
		Properties props = new Properties(); 
		// 3 mandatory parameters: bootstrap.servers, key.deserializer, value.deserializer
		props.put("bootstrap.servers", "host-10-17-81-225.coe.cloudera.com:9092,host-10-17-81-226.coe.cloudera.com:9092"); 
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		// not mandatory but we can consider it is. 
		props.put("group.id", "TestGroup");
		
		KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
		
		
	}
	
	
}
