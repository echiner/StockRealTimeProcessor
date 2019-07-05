
package com.gft.upv.flink;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch6.ElasticsearchSink;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.http.HttpHost;

import com.gft.upv.config.AppConfig;
import com.gft.upv.flink.process.EnrichCompany;
import com.gft.upv.flink.process.ParseCompanies;
import com.gft.upv.flink.process.StockElasticSink;
import com.gft.upv.serde.GenericSchemaRegistrySerdeSchema;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;



/**
 * Skeleton for a Flink Streaming Job.
 *
 * <p>For a tutorial how to write a Flink streaming application, check the
 * tutorials and examples on the <a href="http://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class StreamingStockJob {

	private String topic;
	private AppConfig appConfig;
	private Properties jobProperties=new Properties();
	private StreamExecutionEnvironment env;
	
	
	
	public StreamingStockJob(String[] args) {
		this.topic=args[0];
	}
	
	public void setupJob() {
	
		ClassLoader classLoader = StreamingStockJob.class.getClassLoader();
			
		//Load application configuration
		InputStream is=classLoader.getResourceAsStream("application.conf");
		InputStreamReader reader = new InputStreamReader(is);
		Config config = ConfigFactory.parseReader(reader);
		appConfig = new AppConfig(config);
				
		//Setup job properties
		jobProperties.put("bootstrap.servers", appConfig.getKafkaConf().getKafkaBrokersUrls());
		// only required for Kafka 0.8
		jobProperties.put("zookeeper.connect", appConfig.getKafkaConf().getZkUrl());
		jobProperties.setProperty("group.id", "stockConsumer");
		jobProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		//properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
		//props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		jobProperties.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		jobProperties.put("schema.registry.url", appConfig.getKafkaConf().getSchemaRegistryUrl());
		jobProperties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
	}
	
	public void createPipeline() {
		
		// set up the streaming execution environment
		env = StreamExecutionEnvironment.getExecutionEnvironment();

		DataStreamSource<String> companies=env.readTextFile("C:\\Users\\role\\Documents\\Formacion\\Master Big Data\\2019\\Ejercicio\\companies.json");
		  
		
		DataStream<GenericRecord> companiesAvro=companies.process(new ParseCompanies(this.appConfig));
		
		GenericSchemaRegistrySerdeSchema serde=new GenericSchemaRegistrySerdeSchema(appConfig.getKafkaConf().getSchemaRegistryUrl());
		DataStream<GenericRecord> trades = env
			.addSource(new FlinkKafkaConsumer010<>(this.topic, serde, jobProperties));
			
		EnrichCompany tradeProcess = new EnrichCompany(appConfig);
		
		DataStream<GenericRecord> tradesTransformed = trades.process(tradeProcess);
		
		List<HttpHost> httpHosts = new ArrayList<>();
		httpHosts.add(new HttpHost(this.appConfig.getElasticConf().getHost(), this.appConfig.getElasticConf().getPort(), "http"));
		
		// use a ElasticsearchSink.Builder to create an ElasticsearchSink
		ElasticsearchSink.Builder<GenericRecord> esSinkBuilder = new ElasticsearchSink.Builder<>(
		    httpHosts,
		    new StockElasticSink(this.appConfig.getElasticConf()));
		
		// configuration for the bulk requests; this instructs the sink to emit after every element, otherwise they would be buffered
		esSinkBuilder.setBulkFlushMaxActions(1);

		// provide a RestClientFactory for custom configuration on the internally created REST client
		/*
		esSinkBuilder.setRestClientFactory(
		  restClientBuilder -> {
		    restClientBuilder.setDefaultHeaders(...)
		    restClientBuilder.setMaxRetryTimeoutMillis(...)
		    restClientBuilder.setPathPrefix(...)
		    restClientBuilder.setHttpClientConfigCallback(...)
		  }
		);*/

		// finally, build and add the sink to the job's pipeline
		tradesTransformed.addSink(esSinkBuilder.build());
		
		//tradesTransformed.addSink(new FlinkKafkaProducer010<>("tradesTransformed", serde, jobProperties));
	}
	
	public void launchPipeline() throws Exception{
		this.env.execute();
	}
	
	public static void main(String[] args) throws Exception {
		
		if(args.length!=1) {
			System.out.println("Error, you have not specified the right parameters");
			System.out.println("--------------------------------------------------");
			
			System.out.println("Example: StreamingStockJob topic ");
			System.out.println("topic: Kafka topic where you want to consume the messages ");		
		}
		else
		{
			StreamingStockJob streamingJob=new StreamingStockJob(args);
			streamingJob.setupJob();
			streamingJob.createPipeline();
			streamingJob.launchPipeline();
		}
		
	
	}
}
