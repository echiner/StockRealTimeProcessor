package com.gft.kafka.producer;



import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gft.config.AppConfig;


public class KakfaTopicMessagesProducer implements Runnable{

    private static Logger logger = LogManager.getLogger(KakfaTopicMessagesProducer.class.getName());

    private String topicName;
    private AppConfig config;
    
    public KakfaTopicMessagesProducer(AppConfig config) {
        this.config=config;
        this.topicName=config.getKafkaConf().getTradesTopicConf().getName();
    }

    private static GenericData.Record parseJson(String json, Schema schema)
    	    throws IOException {
    	  
    	  InputStream input = new ByteArrayInputStream(json.getBytes());
    	  DataInputStream din = new DataInputStream(input);
    	  
    	  Decoder decoder = DecoderFactory.get().jsonDecoder(schema, din);
    	
    	  DatumReader<GenericData.Record> reader =
    	      new GenericDatumReader<>(schema);
    	  return reader.read(null, decoder);
    }
    
    @Override
    public void run(){
        logger.info("Starting KakfaTopicMessagesProducer...");
        Properties props = new Properties();
        props.put("bootstrap.servers", this.config.getKafkaConf().getKafkaBrokersUrls());

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        //props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");

        props.put("schema.registry.url", this.config.getKafkaConf().getSchemaRegistryUrl());

        Schema.Parser parser = new Schema.Parser();
        Schema schema = null;
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("topic_avro_schemes/quote.avsc");
            schema = parser.parse(is);
        
	        //Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
	        org.apache.kafka.clients.producer.KafkaProducer<String, GenericRecord> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, GenericRecord>(props);
	        
	         
	        Path path = FileSystems.getDefault().getPath("C:\\Users\\role\\Documents\\Formacion\\Master Big Data\\2019\\Ejercicio\\quoteExample.json");
	        List<String> jsonFileContent = Files.readAllLines(path);
	        		
	        for(String jsonMessage:jsonFileContent) {
	        	GenericData.Record avroRecord=this.parseJson(jsonMessage, schema);
	        	
	            ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(topicName, avroRecord);
	            System.out.println(record.toString());
	            producer.send(record);
	        }
	        //String[] jsonContentSplitted = jsonFileContent.Split(Environment.NewLine.ToCharArray());

        } catch (IOException e) {
            logger.error(e);
        }
     }
}
        
        /*
        //org.apache.kafka.clients.producer.KafkaProducer<String, byte[]> producer = new org.apache.kafka.clients.producer.KafkaProducer(props);
        int factor=-1;
        while(true) {
        	for (int i = 0; i<10000; i++) {
        		factor*=-1;
        		GenericRecord avroRecord = new GenericData.Record(schema);
        		avroRecord.put("tradeId", i);
	            avroRecord.put("version", 1);
	             
	            avroRecord.put("fraRate", 5.0 );
	            avroRecord.put("referenceRate", 5.0);
	            avroRecord.put("amount", 100.0*factor);
	            avroRecord.put("currency", "EUR");
	            avroRecord.put("valid", true);
	            avroRecord.put("validationResults", new ArrayList<String>());                    
	       
            
         
        
             
//        	GenericRecordBuilder recordBuilder = new GenericRecordBuilder(schema);
//           
//        	recordBuilder.set("ContractId", i);
//        	recordBuilder.set("Version", i);
//       
//        	recordBuilder.set("fraRate", 5.0 );
//        	recordBuilder.set("referenceRate", 5.0);
//        	recordBuilder.set("notionalPrincipal", 10000.0);
//        	recordBuilder.set("valid", true);
//        	recordBuilder.set("validationResults", new ArrayList<String>(Arrays.asList("Vacio")));                    

           // avroRecord.put("numberItems", (int) Math.round(Math.random()*100));

            //byte[] bytes = recordInjection.apply(avroRecord);

            //ProducerRecord<String, byte[]> record = new ProducerRecord<String, byte[]>(topicName, bytes);
            ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(topicName, avroRecord);
            producer.send(record);

//            try {
            	System.out.println(record.toString());
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                logger.error(e);
//            }

        	}
        }
        //producer.close();
    }
}*/
