package com.asaka.swaggerhello.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Asaka
 */


@Component
@ConfigurationProperties(prefix = "map")
public class ReadConfig {
    private Map<String, String> data;

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}