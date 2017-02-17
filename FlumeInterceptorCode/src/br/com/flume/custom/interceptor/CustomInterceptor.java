package br.com.flume.custom.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import org.apache.log4j.Logger;

public class CustomInterceptor implements Interceptor {

	private static final Logger LOG = Logger.getLogger(CustomInterceptor.class);
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		LOG.info("close - interceptor");
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event intercept(Event arg0) {
		// TODO Auto-generated method stub
		LOG.info("calling intercept method - list");
		
		String body = new String(arg0.getBody()); 
		Map<String,String> mp = arg0.getHeaders();
		
		if(body.contains("Bob")) {
			LOG.info("Bob is present");
			mp.put("bob", "is present"); 
		} else {
			LOG.info("Bob is not present");
			return null; //removing event. 
		}
		return arg0;
	}

	@Override
	public List<Event> intercept(List<Event> arg0) {
		// TODO Auto-generated method stub
		LOG.info("calling intercept method - list");
		for(Event e : arg0){intercept(e);}
		return null;
	}

}
