package com.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HazelcastService {

    private final Map<Long, Book> mapDev;
    private final FlakeIdGenerator idGenerator;
    
    private final static Logger log = LoggerFactory.getLogger(HazelcastService.class);
    
    public HazelcastService() { 
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);
        mapDev = hazelcastInstanceClient.getMap("data");
        idGenerator = hazelcastInstanceClient.getFlakeIdGenerator("newid");
        log.info("hazelcast client instance created.");
    }
    
    public Map<Long, Book> getMapDev() {
        return mapDev;
    }
    
    public Long getNewId() {
        return idGenerator.newId();
    }

}