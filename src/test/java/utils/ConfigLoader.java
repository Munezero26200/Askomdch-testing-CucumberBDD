package utils;

import Constants.EnvType;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env =  System.getProperty("env",String.valueOf(EnvType.STAGE));
        if (EnvType.valueOf(env) == EnvType.STAGE) {
            properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
        } else {
            throw new IllegalStateException("INVALID ENV" + env);
        }


    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }
}

