package com.gft.config;

import com.typesafe.config.Config;

import java.io.Serializable;

public class SchemaConfig implements Serializable {

    private final String schTrade;
   
    public SchemaConfig(Config confFile) {
    	schTrade = confFile.getString("schemaregistry.tradeSchema");
     }

    public String getSchTrade() { return schTrade; }

}
