package com.gft.config;

import com.typesafe.config.Config;

import java.io.Serializable;


public class KafkaConfig implements Serializable {
    private final String kafkaBrokersUrls;
    private final String zkUrl;
    private final String schemaRegistryUrl;
    private final TopicConf tradesTopicConf;
 

    public KafkaConfig(Config conf) {

        this.kafkaBrokersUrls = conf.getString("kafka.kafkaBrokersUrls");
        this.zkUrl = conf.getString("kafka.zkUrl");
        this.schemaRegistryUrl = conf.getString("kafka.schemaRegistryUrl");

        String logs[] = conf.getString("kafka.topics.trades").split(":");
        this.tradesTopicConf = new TopicConf(logs[0], logs[1]);

      
    }

    public TopicConf getTradesTopicConf() {
        return tradesTopicConf;
    }

   
    public String getKafkaBrokersUrls() {
        return kafkaBrokersUrls;
    }

    public String getZkUrl() {
        return zkUrl;
    }

    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }

    
    public class TopicConf implements Serializable {
        private String name;
        private String partition;

        public TopicConf(String name, String partition) {
            this.name = name;
            this.partition = partition;
        }

        public String getName() {
            return name;
        }

        public String getPartition() {
            return partition;
        }

        @Override
        public String toString() {
            return "TopicConf{" +
                    "name='" + name + '\'' +
                    ", partition='" + partition + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "KafkaConf{" +
                "kafkaBrokersUrls='" + kafkaBrokersUrls + '\'' +
                ", zkUrl='" + zkUrl + '\'' +
                ", schemaRegistryUrl='" + schemaRegistryUrl + '\'' +
                ", tradesTopicConf=" + tradesTopicConf +
                '}';
    }
}