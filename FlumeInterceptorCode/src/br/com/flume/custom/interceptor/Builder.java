package br.com.flume.custom.interceptor;

import org.apache.flume.Context;
import org.apache.flume.interceptor.Interceptor;
import org.apache.log4j.Logger;

public class Builder implements Interceptor.Builder{

	private static final Logger LOG = Logger.getLogger(Builder.class); 
	
	@Override
	public void configure(Context arg0) {
		// TODO Auto-generated method stub
		LOG.info("calling configure");
	}

	@Override
	public Interceptor build() {
		// TODO Auto-generated method stub
		LOG.info("calling build()");
		return new CustomInterceptor();
	}

	
}
