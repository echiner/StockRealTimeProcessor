package com.gft.upv.flink.process;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.upv.config.AppConfig;

public class EnrichCompany extends ProcessFunction<GenericRecord, GenericRecord> {
    private static final Logger logger = LoggerFactory.getLogger(EnrichCompany.class);
    private AppConfig appConfig;
   
       public EnrichCompany(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void processElement(GenericRecord quote, Context ctx, Collector<GenericRecord> collector) throws Exception {
     
        if (true)
            collector.collect(quote);
        else
            logger.debug("Transaction null. Deal message received:{} ", quote);
        
    }
}