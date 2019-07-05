package com.gft.upv.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigParseOptions;

import java.io.File;
import java.io.Serializable;
import java.util.Properties;


public class AppConfig implements Serializable {

    private final Config config;
    private final KafkaConfig kafkaConfig;
    private final SchemaConfig schemaConfig;
    private final FlinkConfig flinkConfig;
    private final ElasticConfig elasticConfig;
    
    public AppConfig(Config conf) {
        this.config = conf;
        kafkaConfig = new KafkaConfig(conf);
        schemaConfig = new SchemaConfig(conf);
        flinkConfig = new FlinkConfig(conf);
        elasticConfig = new ElasticConfig(conf);
        
    }
    
    public AppConfig(String path) {
        this.config = ConfigFactory.parseFile(new File(path));
        kafkaConfig = new KafkaConfig(config);
        schemaConfig = new SchemaConfig(config);
        flinkConfig = new FlinkConfig(config);
        elasticConfig = new ElasticConfig(config);
    }

    public FlinkConfig getFlinkConf() {
        return flinkConfig;
    }

    public KafkaConfig getKafkaConf() {
        return kafkaConfig;
    }

    public Config getConf() {
        return config;
    }

   

    public SchemaConfig getSchemaConf() { return schemaConfig; }

    public ElasticConfig getElasticConf() { return elasticConfig; }

    @Override
    public String toString() {
        return "AppConfig{" +
                ", kafkaConf=" + kafkaConfig +
                ", elasticConf=" + elasticConfig +
                ", schemaRegConf=" + schemaConfig +
                ", conf=" + config +
                '}';
    }
}