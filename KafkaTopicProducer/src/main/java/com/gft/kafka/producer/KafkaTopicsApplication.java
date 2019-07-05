package com.gft.kafka.producer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gft.config.AppConfig;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class KafkaTopicsApplication {

    private static Logger logger = LogManager.getLogger(KafkaTopicsApplication.class.getName());

     public static void main(String[] args) throws Exception{
        
    	AppConfig config=initializeConfiguration(args);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
       // executorService.execute(new EmployeeMessagesProducer());

        executorService.execute(new KakfaTopicMessagesProducer(config));
        executorService.shutdown();
    }

    private static AppConfig initializeConfiguration(String[] args){
      
        //Config config = ConfigFactory.parseFile(new File("src/main/resources/application.conf"));	
        
    	ClassLoader classLoader = KafkaTopicsApplication.class.getClassLoader();
		//InputStream is=classLoader.getResourceAsStream("applicationCloud.conf");
		InputStream is=classLoader.getResourceAsStream("application.conf");
		InputStreamReader reader = new InputStreamReader(is);
		Config config = ConfigFactory.parseReader(reader);
		return new AppConfig(config);
	      
    }
}
