package com.gft.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigParseOptions;

import java.io.File;
import java.io.Serializable;
import java.util.Properties;


public class AppConfig implements Serializable {

    private final Config conf;
    private final KafkaConfig kafkaConf;
    private final SchemaConfig schemaConf;
    private final FlinkConfig flinkConf;
      
    public AppConfig(Config conf) {
        this.conf = conf;
        kafkaConf = new KafkaConfig(conf);
        schemaConf = new SchemaConfig(conf);
        flinkConf = new FlinkConfig(conf);
    }

    public AppConfig(String path) {
        this.conf = ConfigFactory.parseFile(new File(path));
        kafkaConf = new KafkaConfig(conf);
        schemaConf = new SchemaConfig(conf);
        flinkConf = new FlinkConfig(conf);
    }

    public FlinkConfig getFlinkConf() {
        return flinkConf;
    }

    public KafkaConfig getKafkaConf() {
        return kafkaConf;
    }

    public Config getConf() {
        return conf;
    }

   

    public SchemaConfig getSchemaConf() { return schemaConf; }

   
    //public ElasticConf getElasticConf() { return elasticConf; }

    @Override
    public String toString() {
        return "AppConfig{" +
                ", kafkaConf=" + kafkaConf +
                ", schemaRegConf=" + schemaConf +
                ", conf=" + conf +
                '}';
    }
}