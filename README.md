## Software required to download:

Elastic --> https://www.elastic.co/es/downloads/elasticsearch

kibana --> https://www.elastic.co/es/downloads/kibana

Kafka stack --> https://www.confluent.io/download/

Schema registry for windows --> https://github.com/renukaradhya/confluentplatform/tree/master/bin/windows

kafka tool & avro pluggin --> http://www.kafkatool.com/ , https://github.com/laymain/kafka-tool-avro

## Launch platform locally:


•	Launch zookeeper inside confluent installation folder:
bin\windows\zookeeper-server-start.bat  etc\kafka\zookeeper.properties

•	Launch kafka broker inside confluent installation folder:
bin\windows\kafka-server-start.bat etc\kafka\server.properties

•	Launch schema registry on same folder. If it fails change default port 8081 on etc/schema-registry.properties 
bin\windows\schema-registry-start.bat etc\schema-registry\schema-registry.properties

•	Launch elastic on elastic installation installation folder:
	bin\elasticsearch

•	Launch kibana on kibana installation folder:
	bin\kibana
