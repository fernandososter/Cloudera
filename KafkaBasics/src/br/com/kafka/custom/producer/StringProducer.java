package br.com.kafka.custom.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;


public class StringProducer {

	
	public static void main(String[] args) {
		
		
		
		Properties kafkaProps = new Properties(); 
		// adding kafkabrokers (not necessary all broker but at least 2, in case one fails)
		kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "host-10-17-81-225.coe.cloudera.com:9092"); 	
		// setting the serializer that will convert the key to bytearray. 
		kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 	
		// setting the serializer to convert the value to bytearray
		kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 	
		
		//creating the producer to send the record to brokers
		KafkaProducer producer = new KafkaProducer<String,String>(kafkaProps); 
		
		//crearing the record with "topic", "key", "value"
		ProducerRecord<String,String> record = new ProducerRecord<>("first","test","France"); 
		
		//sending it in fire and forget way (not expecting future object)
		try{ 
			producer.send(record); 
			System.out.println("testado");
		
		System.out.println("apos close");
		producer.flush();
		producer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*
		// sending the message in a sync way (waiting the RecordMetada object)
		try {
			producer.send(record).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		//sending the message in an async way. 
		producer.send(record,new DemoProducerCallback()); 
	*/ 	
	}
	
	
	
}
