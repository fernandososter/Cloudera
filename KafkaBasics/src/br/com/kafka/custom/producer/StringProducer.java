package br.com.kafka.custom.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

class DemoProducerCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata r, Exception e) {
		if (e != null) {
			e.printStackTrace();
		}
		System.out.println(r.offset()); 
		
	}
	
}


public class StringProducer {

	
	public static void main(String[] args) {
		
		Properties kafkaProps = new Properties(); 
		// adding kafkabrokers (not necessary all broker but at least 2, in case one fails)
		kafkaProps.put("bootstrap.servers", "localhost:9092"); 	
		// setting the serializer that will convert the key to bytearray. 
		kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 	
		// setting the serializer to convert the value to bytearray
		kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 	
		
		//creating the producer to send the record to brokers
		KafkaProducer producer = new KafkaProducer<String,String>(kafkaProps); 
		
		//crearing the record with "topic", "key", "value"
		ProducerRecord<String,String> record = new ProducerRecord<>("CustomerCountry","Precision","France"); 
		
		//sending it in fire and forget way (not expecting future object)
		try{ 
			producer.send(record); 
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		// sending the message in a sync way (waiting the RecordMetada object)
		try {
			producer.send(record).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//sending the message in an async way. 
		producer.send(record,new DemoProducerCallback()); 
		
	}
	
	
	
}
