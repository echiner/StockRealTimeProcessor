package com.gft.config;

import com.typesafe.config.Config;

import java.io.Serializable;

public class HazelcastConfig implements Serializable{

    private final String hzUrl;
    private final String hzPath;
    private final String mapTrades;
    
    public HazelcastConfig(Config confFile) {
        hzUrl = confFile.getString("hazelcast.hzUrl");
        hzPath = confFile.getString("hazelcast.hzPath");
        mapTrades = confFile.getString("hazelcast.mapTrades");
      
    }
   
    public String getHzUrl() {
        return hzUrl;
    }

    public String getHzPath() {
        return hzPath;
    }

   
    @Override
    public String toString() {
        return  "HazelCastConfig{"+
                ", hzUrl='" + hzUrl + '\'' +
                ", hzPath='" + hzPath + '\'' +
                ", mapTrades='" + mapTrades + '\'' +
                '}';
    }
}
