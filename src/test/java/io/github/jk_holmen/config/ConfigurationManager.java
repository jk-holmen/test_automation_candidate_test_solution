package io.github.jk_holmen.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private final Properties properties = new Properties();

    private ConfigurationManager() {
        loadProperties();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private String get(String propertyLabel) {
        String property = properties.getProperty(propertyLabel);

        if (property == null) {
            throw new IllegalArgumentException(
                "No property configured for label: " + propertyLabel);
        }
        return property;
    }

    public String getBaseUrl() {
        return get("base.url");
    }

    public String getDatasetId(String datasetName) {
        return get("dataset.id." + datasetName);
    }
}
