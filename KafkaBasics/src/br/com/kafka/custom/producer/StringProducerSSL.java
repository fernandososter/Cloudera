package br.com.kafka.custom.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;




public class StringProducerSSL {

	
	public static void main(String[] args) {
		
		Properties kafkaProps = new Properties(); 
		// adding kafkabrokers (not necessary all broker but at least 2, in case one fails)
		kafkaProps.put("bootstrap.servers", "host-10-17-81-225.coe.cloudera.com:9093"); 	
		// setting the serializer that will convert the key to bytearray. 
		kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 	
		// setting the serializer to convert the value to bytearray
		kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 	
		
		kafkaProps.put("security.protocol", "SSL"); 	
		kafkaProps.put("ssl.truststore.location", "/Users/fsoster/client.truststore.jks"); 	
		kafkaProps.put("ssl.truststore.password", "cloudera");
		
		
		
		//creating the producer to send the record to brokers
		KafkaProducer producer = new KafkaProducer<String,String>(kafkaProps); 
		
		//crearing the record with "topic", "key", "value"
		ProducerRecord<String,String> record = new ProducerRecord<>("first","Precision","France"); 
		
		//sending it in fire and forget way (not expecting future object)
		try{ 
			producer.send(record); 
		}catch(Exception e) {
			e.printStackTrace();
		}

		//producer.close();
		
	}
	
	
	
}
