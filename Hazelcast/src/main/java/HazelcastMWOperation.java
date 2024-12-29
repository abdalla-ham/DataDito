package com.i2i.datadito.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.i2i.datadito.hazelcast.configurations.Configuration;
import com.i2i.datadito.hazelcast.constants.StringConstants;

public class HazelcastMWOperation {

    private static final ClientConfig config = Configuration.getConfig();
    private static final HazelcastInstance hazelcast = HazelcastClient.newHazelcastClient(config);
    public static String put(String key, String value){
        try{
            IMap<Object, Object> map = hazelcast.getMap(StringConstants.mapName);
            map.put(key,value);
            return "Put operation is successful";
        }catch (Exception e){
            e.printStackTrace();
            return "Put operation is not successful";
        }/*finally {
            hazelcast.shutdown();
        }*/
    }



}
